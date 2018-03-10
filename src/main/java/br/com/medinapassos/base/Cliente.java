/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medinapassos.base;

import br.com.medinapassos.base.json.Contato;
import br.com.medinapassos.base.json.Enderecos;
import br.com.medinapassos.tipo.json.JsonBinaryType;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

/**
 *
 * @author João Paulo
 */
@TypeDefs({
    @TypeDef(name = "jsonbEnderecos", typeClass = JsonBinaryType.class)
    ,
    @TypeDef(name = "jsonbContato", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "cliente_clienteid_seq", sequenceName = "cliente_clienteid_seq", allocationSize = 1)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_clienteid_seq")
    private Integer clienteid;
    private String nome;
    private String cpf;
    @Type(type = "jsonbEnderecos")
    @Column(columnDefinition = "enderecos")
    @Basic(fetch = FetchType.LAZY)
    private Enderecos enderecos;
    @Type(type = "jsonbContato")
    @Column(columnDefinition = "contato")
    @Basic(fetch = FetchType.LAZY)
    private Contato contato;

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Enderecos getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

}
