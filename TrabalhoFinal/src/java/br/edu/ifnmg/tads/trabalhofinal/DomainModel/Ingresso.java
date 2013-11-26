/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "ingresso")
public class Ingresso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingressoid;
    
    @Column(name = "nome", length = 255)
    private String nome;
    
    @Column(name = "descricao", length = 255)
    private String descricao;
    
    @Column(name = "quantidade", length = 11)
    private int quantidade;
    
    @Column(name = "qtdeminimavenda", length = 11)
    private int qtdeminimavenda;
    
    @Column(name = "qtdemaximavenda", length = 11)
    private int qtdemaximavenda;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "iniciovenda") 
    private Date iniciovenda;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fimvenda", length = 11) 
    private Date fimvenda;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Setor setor;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Evento evento;

    public Ingresso(String nome, String descricao, int quantidade, int qtdemaximavenda, Date iniciovenda, Date fimvenda, Setor setor, Evento evento) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.qtdemaximavenda = qtdemaximavenda;
        this.iniciovenda = iniciovenda;
        this.fimvenda = fimvenda;
        this.setor = setor;
        this.evento = evento;
    }
    
    public Ingresso() {
        this.nome = "";
        this.descricao = "";
        this.quantidade = 0;
        this.qtdemaximavenda = 0;
        this.iniciovenda = new Date(0);
        this.fimvenda = new Date(0);
        this.setor = new Setor();
        this.evento = new Evento();   
    }

    public Long getIngressoid() {
        return ingressoid;
    }

    public void setIngressoid(Long ingressoid) {
        this.ingressoid = ingressoid;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQtdeminimavenda() {
        return qtdeminimavenda;
    }

    public void setQtdeminimavenda(int qtdeminimavenda) {
        this.qtdeminimavenda = qtdeminimavenda;
    }

    public int getQtdemaximavenda() {
        return qtdemaximavenda;
    }

    public void setQtdemaximavenda(int qtdemaximavenda) {
        this.qtdemaximavenda = qtdemaximavenda;
    }

    public Date getIniciovenda() {
        return iniciovenda;
    }

    public void setIniciovenda(Date iniciovenda) {
        this.iniciovenda = iniciovenda;
    }

    public Date getFimvenda() {
        return fimvenda;
    }

    public void setFimvenda(Date fimvenda) {
        this.fimvenda = fimvenda;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
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
        hash = 79 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 79 * hash + (this.iniciovenda != null ? this.iniciovenda.hashCode() : 0);
        hash = 79 * hash + (this.fimvenda != null ? this.fimvenda.hashCode() : 0);
        hash = 79 * hash + (this.setor != null ? this.setor.hashCode() : 0);
        hash = 79 * hash + (this.evento != null ? this.evento.hashCode() : 0);
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
        final Ingresso other = (Ingresso) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.iniciovenda != other.iniciovenda && (this.iniciovenda == null || !this.iniciovenda.equals(other.iniciovenda))) {
            return false;
        }
        if (this.fimvenda != other.fimvenda && (this.fimvenda == null || !this.fimvenda.equals(other.fimvenda))) {
            return false;
        }
        if (this.setor != other.setor && (this.setor == null || !this.setor.equals(other.setor))) {
            return false;
        }
        if (this.evento != other.evento && (this.evento == null || !this.evento.equals(other.evento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
    
}
