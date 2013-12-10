/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rodrigo
 */
@Entity
public class Parceiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parceiroid;
    
    @Column(name = "nome", length = 255)
    private String nome;
    
    @Column(name = "ativo", length = 1)
    private int ativo;
    
    public Parceiro(String nome, int ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }

    public Parceiro(){
        this.nome = "";
        this.ativo = 1;
    }
    
    public Long getParceiroid() {
        return parceiroid;
    }

    public void setParceiroid(Long parceiroid) {
        this.parceiroid = parceiroid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.nome != null ? this.nome.hashCode() : 0);
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
        final Parceiro other = (Parceiro) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
    
}
