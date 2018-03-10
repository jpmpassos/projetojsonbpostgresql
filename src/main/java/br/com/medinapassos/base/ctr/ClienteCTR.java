/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medinapassos.base.ctr;

import br.com.medinapassos.base.Cliente;
import br.com.medinapassos.base.dao.ClienteDAO;
import br.com.medinapassos.util.DAOFactory;
import java.util.List;

/**
 *
 * @author João Paulo
 */
public class ClienteCTR {

    private final ClienteDAO clienteDAO;

    public ClienteCTR() {
        this.clienteDAO = DAOFactory.criarClienteDAO();
    }

    public void salvar(Cliente cliente) {
        this.clienteDAO.salvar(cliente);
    }

    public void excluir(Cliente cliente) {
        this.clienteDAO.excluir(cliente);
    }

    public Cliente carregar(Integer codigo) {
        return this.clienteDAO.carregar(codigo);
    }

    public List<Cliente> listar() {
        return this.clienteDAO.listar();
    }
    
}
