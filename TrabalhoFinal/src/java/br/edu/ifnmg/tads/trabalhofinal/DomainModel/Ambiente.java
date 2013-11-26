/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "ambiente")
public class Ambiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ambienteid;

    @Column(name = "nome", length = 255)
    private String nome;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "capacidadetotal", length = 255)
    private int capacidadetotal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "enderecoid")
    private Endereco endereco;

    public Ambiente(String nome, String descricao, int capacidadetotal, Endereco endereco) {
        this.nome = nome;
        this.descricao = descricao;
        this.capacidadetotal = capacidadetotal;
        this.endereco = endereco;
    }
    
    public Ambiente() {
        this.nome = "";
        this.descricao = "";
        this.capacidadetotal = 0;
        this.endereco = new Endereco();
    }
    
    public Long getAmbienteid() {
        return ambienteid;
    }

    public void setAmbienteid(Long ambienteid) {
        this.ambienteid = ambienteid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCapacidadetotal() {
        return capacidadetotal;
    }

    public void setCapacidadetotal(int capacidadetotal) {
        this.capacidadetotal = capacidadetotal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ambiente other = (Ambiente) obj;
        if (this.endereco != other.endereco && (this.endereco == null || !this.endereco.equals(other.endereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
   
   
   
}
