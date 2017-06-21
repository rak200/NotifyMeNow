/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.entity;

import br.udesc.notifymenow.reader.util.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Noticia {

    private int id;
    private Site site;
    private String titulo;
    private String conteudo;
    private String link;
    private Date data;
    private boolean enviado;
    private TipoBusca tipoBusca;

    public Site getSite() {
        if (site == null) {
            site = new Site();
        }
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getConteudoHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append(titulo);
        sb.append("<br />");
        sb.append(getDataFormatada());
        sb.append("<br />");
        sb.append(link);
        return sb.toString();
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public String getDataFormatada() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        return format.format(data);
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setData(String data) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        try {
            this.data = format.parse(data);
        } catch (ParseException ex) {
            Logger.error(ex);
        }
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public TipoBusca getTipoBusca() {
        return tipoBusca;
    }

    public void setTipoBusca(TipoBusca tipoBusca) {
        this.tipoBusca = tipoBusca;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
