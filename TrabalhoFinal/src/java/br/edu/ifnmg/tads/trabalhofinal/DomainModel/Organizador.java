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
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "organizador")
public class Organizador extends Pessoa implements Serializable {
    
    @Column(name = "cnpj", length = 14)
    private int cnpj;
    
    @Column(name = "descricao", length = 255)
    private String descricao;
    
    @Column(name = "razaosocial", length = 255)
    private String razaosocial;
    
    @Column(name = "ativo", length = 1)
    private int ativo;
    
    public Organizador(int cnpj, String descricao, String razaosocial, int ativo) {
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.razaosocial = razaosocial;
        this.ativo = ativo;
    }

    public Organizador() {
        this.cnpj = 0;
        this.descricao = "";
        this.razaosocial = "";
        this.ativo = 1;
    }
        
    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.cnpj;
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
        final Organizador other = (Organizador) obj;
        if (this.cnpj != other.cnpj) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getRazaosocial();
    }
    
    
    
    
    
    
}
