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
import javax.persistence.ManyToOne;

/**
 *
 * @author Rodrigo
 */
@Entity
public class ParceiroEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parceiroeventoid;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parceiroid")
    private Parceiro parceiro;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "eventoid")
    private Evento evento;

    public ParceiroEvento(Parceiro parceiro, Evento evento) {
        this.parceiro = parceiro;
        this.evento = evento;
    }

    public ParceiroEvento(){
        this.parceiro = new Parceiro();
        this.evento = new Evento();
    }
    
    public Long getParceiroeventoid() {
        return parceiroeventoid;
    }

    public void setParceiroeventoid(Long parceiroeventoid) {
        this.parceiroeventoid = parceiroeventoid;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.parceiro != null ? this.parceiro.hashCode() : 0);
        hash = 29 * hash + (this.evento != null ? this.evento.hashCode() : 0);
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
        final ParceiroEvento other = (ParceiroEvento) obj;
        if (this.parceiro != other.parceiro && (this.parceiro == null || !this.parceiro.equals(other.parceiro))) {
            return false;
        }
        if (this.evento != other.evento && (this.evento == null || !this.evento.equals(other.evento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getParceiro().getNome();
    }
    
    
}
