/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medinapassos.base.dao;

import br.com.medinapassos.base.Cliente;
import java.util.List;

/**
 *
 * @author João Paulo
 */
public interface ClienteDAO {

    public void salvar(Cliente cliente);

    public void excluir(Cliente cliente);

    public Cliente carregar(Integer codigo);

    public List<Cliente> listar();
}
