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
@Table(name="telefone")
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long telefoneid;
    
    @Column(name = "ddd", length = 3)
    private int ddd;
    
    @Column(name = "numero", length = 8)
    private int numero;

    public Telefone(int ddd, int numero) {
        this.ddd = ddd;
        this.numero = numero;
    }
    
    public Telefone() {
        this.ddd = 0;
        this.numero = 0;
    }
    
    public Long getTelefoneId() {
        return telefoneid;
    }

    public void setTelefoneId(Long telefoneid) {
        this.telefoneid = telefoneid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefoneid != null ? telefoneid.hashCode() : 0);
        return hash;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefone other = (Telefone) obj;
        if (this.ddd != other.ddd) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+numero;
    }
    
    
    
}
