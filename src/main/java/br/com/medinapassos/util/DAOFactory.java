/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medinapassos.util;

//import br.com.vendasmobile.dao.*;
import br.com.medinapassos.base.dao.ClienteDAO;
import br.com.medinapassos.base.dao.ClienteDAOImpl;

/**
 *
 * @author João Paulo
 */
public class DAOFactory {

    public static ClienteDAO criarClienteDAO() {
        ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
        clienteDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return clienteDAOImpl;
    }
}
