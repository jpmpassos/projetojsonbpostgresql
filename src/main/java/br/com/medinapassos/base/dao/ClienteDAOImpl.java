/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medinapassos.base.dao;

import br.com.medinapassos.base.Cliente;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author João Paulo
 */
public class ClienteDAOImpl implements ClienteDAO {

    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Cliente cliente) {
        if (cliente.getClienteid() != null) {
            this.session.update(cliente);
        } else {
            this.session.save(cliente);
        }
    }

    @Override
    public void excluir(Cliente cliente) {
        this.session.delete(cliente);
    }

    @Override
    public Cliente carregar(Integer codigo) {
        return (Cliente) this.session.get(Cliente.class, codigo);
    }

    @Override
    public List<Cliente> listar() {
        return this.session.createCriteria(Cliente.class).list();
    }
}
