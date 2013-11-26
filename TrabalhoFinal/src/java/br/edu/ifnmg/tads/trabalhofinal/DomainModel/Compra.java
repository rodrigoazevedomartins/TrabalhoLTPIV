/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "compra")
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compraid;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datacompra")
    private Date datacompra;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteid")
    private Cliente cliente;
    
    @Enumerated
    @JoinColumn(name = "formapagamentoid")
    private FormaPagamento formapagamento;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="compraingresso",  
    joinColumns= @JoinColumn(name="compraid"), 
    inverseJoinColumns=@JoinColumn(name="ingressoid")
    )
    private List<Ingresso> ingressos;

    public Compra(Date datacompra, Cliente cliente, FormaPagamento formapagamento, List<Ingresso> ingressos) {
        this.datacompra = datacompra;
        this.cliente = cliente;
        this.formapagamento = formapagamento;
        this.ingressos = ingressos;
    }
    
    public Compra() {
        this.datacompra = new Date(0);
        this.cliente = new Cliente();
        this.formapagamento = formapagamento.Vazio;
        this.ingressos = new LinkedList<Ingresso>();
    }

    public Long getCompraid() {
        return compraid;
    }

    public void setCompraid(Long compraid) {
        this.compraid = compraid;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagamento getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(FormaPagamento formapagamento) {
        this.formapagamento = formapagamento;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
    
    public void addIngresso(Ingresso ingresso){
        if (!ingressos.contains(ingresso)){
            ingressos.add(ingresso);
        }
    }
    
    public void removeIngresso(Ingresso ingresso){
        if (ingressos.contains(ingresso)){
            ingressos.add(ingresso);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.datacompra != null ? this.datacompra.hashCode() : 0);
        hash = 59 * hash + (this.cliente != null ? this.cliente.hashCode() : 0);
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
        final Compra other = (Compra) obj;
        if (this.datacompra != other.datacompra && (this.datacompra == null || !this.datacompra.equals(other.datacompra))) {
            return false;
        }
        if (this.cliente != other.cliente && (this.cliente == null || !this.cliente.equals(other.cliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.cliente.getNome();
    }
    
    
    
    
    
}
