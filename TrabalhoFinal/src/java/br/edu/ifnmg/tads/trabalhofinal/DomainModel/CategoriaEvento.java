/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
public class CategoriaEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaeventoid;
    
    @Enumerated
    @JoinColumn(name = "categoriaid")
    private Categoria categoria;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "eventoid")
    private Evento evento;

    public CategoriaEvento(Categoria categoria, Evento evento) {
        this.categoria = categoria;
        this.evento = evento;
    }
    
    public CategoriaEvento(){
        this.categoria = categoria.Vazio;
        this.evento = new Evento();
        
    }
    
    public Long getCategoriaeventoid() {
        return categoriaeventoid;
    }

    public void setCategoriaeventoid(Long categoriaeventoid) {
        this.categoriaeventoid = categoriaeventoid;
    }
   
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.categoria != null ? this.categoria.hashCode() : 0);
        hash = 13 * hash + (this.evento != null ? this.evento.hashCode() : 0);
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
        final CategoriaEvento other = (CategoriaEvento) obj;
        if (this.categoria != other.categoria) {
            return false;
        }
        if (this.evento != other.evento && (this.evento == null || !this.evento.equals(other.evento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.categoria.getNome();
    }
    
    
    
}
