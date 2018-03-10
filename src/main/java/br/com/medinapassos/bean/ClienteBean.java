/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medinapassos.bean;

import br.com.medinapassos.base.Cliente;
import br.com.medinapassos.base.ctr.ClienteCTR;
import br.com.medinapassos.base.json.Contato;
import br.com.medinapassos.base.json.Endereco;
import br.com.medinapassos.base.json.Enderecos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author JP1
 */
@ManagedBean
@ViewScoped
public class ClienteBean {

    private List<Cliente> clientes;

    private Cliente cliente;

    public void cadastrarCliente() {
        Integer i;
        if (clientes == null) {
            i = 1;
        } else {
            i = clientes.size() + 1;
        }

        Cliente cliente = new Cliente();
        cliente.setNome("Cliente " + i.toString());
        cliente.setCpf("456.456.451-" + ((Integer) (10 + i)).toString());

        cliente.setEnderecos(new Enderecos());
        cliente.getEnderecos().setItens(new ArrayList<Endereco>());

        Endereco endereco;
        for (Integer j = 0; j < i; j++) {
            endereco = new Endereco();
            endereco.setBairro("Bairro " + i.toString() + j.toString());
            endereco.setCep("39874-0" + i.toString() + j.toString());
            endereco.setCidade("Cidade " + i.toString() + j.toString());
            endereco.setLogradouro("Rua " + i.toString() + j.toString());
            endereco.setNumero(i.toString() + j.toString());
            endereco.setUf("MG");

            cliente.getEnderecos().getItens().add(endereco);
        }

        Contato contato = new Contato();
        contato.setContato("Contato " + i.toString());
        contato.setDescricao("Descricao " + i.toString());
        contato.setNome("Nome " + i.toString());
        contato.setTipo("Tipo " + i.toString());

        cliente.setContato(contato);

        ClienteCTR clienteCTR = new ClienteCTR();
        clienteCTR.salvar(cliente);

        clientes = null;
    }

    public List<Cliente> getClientes() {
        if (clientes == null) {
            ClienteCTR clienteCTR = new ClienteCTR();
            clientes = clienteCTR.listar();
        }
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
