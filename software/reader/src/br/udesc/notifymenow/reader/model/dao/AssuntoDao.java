/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao;

import br.udesc.notifymenow.reader.model.entity.Assunto;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public interface AssuntoDao {

    public boolean salva(Assunto assunto);

    public boolean exclui(Assunto assunto);
    
    public boolean altera(Assunto assunto);

    public List<Assunto> lista();

    public Assunto busca(int id);

}
