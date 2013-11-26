/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "compraingresso")
public class CompraIngresso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compraingressoid;
    
    @Column(name = "codigoingresso", length = 11)
    private int codigoingresso;
    
    @Enumerated
    @JoinColumn(name = "statusingressoid")
    private StatusIngresso statusingresso;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingressoid")
    private Ingresso ingresso;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "compraid")
    private Compra compra;

    public CompraIngresso(int codigoingresso, StatusIngresso statusingresso, Ingresso ingresso, Compra compra) {
        this.codigoingresso = codigoingresso;
        this.statusingresso = statusingresso;
        this.ingresso = ingresso;
        this.compra = compra;
    }

    public CompraIngresso() {
        this.codigoingresso = 0;
        this.statusingresso = StatusIngresso.NaoConfirmado;
        this.ingresso = new Ingresso();
        this.compra = new Compra();
    }

    public Long getCompraingressoid() {
        return compraingressoid;
    }

    public void setCompraingressoid(Long compraingressoid) {
        this.compraingressoid = compraingressoid;
    }

    public int getCodigoingresso() {
        return codigoingresso;
    }

    public void setCodigoingresso(int codigoingresso) {
        this.codigoingresso = codigoingresso;
    }

    public StatusIngresso getStatusingresso() {
        return statusingresso;
    }

    public void setStatusingresso(StatusIngresso statusingresso) {
        this.statusingresso = statusingresso;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.codigoingresso;
        hash = 13 * hash + (this.ingresso != null ? this.ingresso.hashCode() : 0);
        hash = 13 * hash + (this.compra != null ? this.compra.hashCode() : 0);
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
        final CompraIngresso other = (CompraIngresso) obj;
        if (this.codigoingresso != other.codigoingresso) {
            return false;
        }
        if (this.ingresso != other.ingresso && (this.ingresso == null || !this.ingresso.equals(other.ingresso))) {
            return false;
        }
        if (this.compra != other.compra && (this.compra == null || !this.compra.equals(other.compra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.ingresso.getNome();
    }
    
    
    
}
