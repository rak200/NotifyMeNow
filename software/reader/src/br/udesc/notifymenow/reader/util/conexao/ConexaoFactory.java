/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.util.conexao;

import br.udesc.notifymenow.reader.model.dao.sqlite.ConexaoSqlite;
import br.udesc.notifymenow.reader.util.Logger;
import br.udesc.notifymenow.reader.util.Property;

/**
 *
 * @author Ricardo Augusto Küstner
 */
class ConexaoFactory {

    public static ConexaoDb getConexao() {
        String type = Property.get("banco_dados_tipo");
        if (type.toLowerCase().equals("sqlite")) {
            return new ConexaoSqlite();
        }

        Logger.error("Banco de dados " + type + " não disponível!");
        return null;
    }

}
