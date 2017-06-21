/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.bo;

import br.udesc.notifymenow.reader.controller.mail.MailSender;
import br.udesc.notifymenow.reader.controller.mail.MailSenderFactory;
import br.udesc.notifymenow.reader.controller.rss.RssReader;
import br.udesc.notifymenow.reader.controller.rss.RssReaderFactory;
import br.udesc.notifymenow.reader.model.dao.AssuntoDao;
import br.udesc.notifymenow.reader.model.dao.NoticiaDao;
import br.udesc.notifymenow.reader.model.dao.SiteDao;
import br.udesc.notifymenow.reader.model.dao.sqlite.DaoFactory;
import br.udesc.notifymenow.reader.model.entity.Assunto;
import br.udesc.notifymenow.reader.model.entity.Noticia;
import br.udesc.notifymenow.reader.model.entity.Site;
import br.udesc.notifymenow.reader.util.Logger;
import br.udesc.notifymenow.reader.util.Property;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class NoticiaBo {

    private final NoticiaDao dao;
    private final AssuntoDao assuntoDao;
    private final SiteDao siteDao;
    private Calendar dataLimite;

    public NoticiaBo(NoticiaDao dao) {
        this.dao = DaoFactory.getNoticia();
        this.assuntoDao = DaoFactory.getAssunto();
        this.siteDao = DaoFactory.getSite();
    }

    /**
     * busca e salva no banco de dados os feeds de todos os sites filtrando os assuntos
     */
    public void atualiza() {
        RssReader reader = RssReaderFactory.getRssReader();
        List<Assunto> assuntos = assuntoDao.lista();

        for (Site site : siteDao.lista()) {
            Date dataAtualizacao = dao.ultimaAtualizacao(site);
            if (dataAtualizacao == null || dataAtualizacao.before(getDataLimite().getTime())) {
                dataAtualizacao = getDataLimite().getTime();
            }

            for (Noticia feed : reader.retrieve(site.getLink(), dataAtualizacao)) {
                for (Assunto assunto : assuntos) {
                    if (feed.getConteudo().contains(assunto.getNome()) || feed.getTitulo().contains(assunto.getNome())) {
                        dao.salva(feed);
                        break;
                    }
                }
            }
        }

    }

    public Calendar getDataLimite() {
        if (dataLimite == null) {
            dataLimite = Calendar.getInstance();

            String dias = Property.get("limite_dias");
            if (!dias.isEmpty()) {
                int diferenca = Integer.parseInt(dias);
                diferenca *= -1;
                dataLimite.add(Calendar.DAY_OF_MONTH, diferenca);
            }
        }
        return dataLimite;
    }

    public void enviaEmail() {
        for (Noticia naoEnviado : listaNaoEnviados()) {
            MailSender msg = MailSenderFactory.getMailSender();
            msg.addRecipient(Property.get("email_detinatario"));
            msg.setSubject("NotifyMeNow: " + naoEnviado.getTitulo());
            msg.setContent("NotifyMeNow: " + naoEnviado.getConteudoHtml());
            naoEnviado.setEnviado(true);
            dao.salva(naoEnviado);
            msg.send();
            Logger.info("Enviado e-mail: " + naoEnviado.getTitulo());
        }
    }

    public List<Noticia> listaNaoEnviados() {
        return dao.lista(false);
    }

    public List<Noticia> lista() {
        return dao.lista();
    }

}
