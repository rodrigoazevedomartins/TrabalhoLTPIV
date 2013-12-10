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
import javax.persistence.JoinColumns;
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
@Table(name="Evento")
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoid;
    
    @Column(name = "nome", length = 255)
    private String nome;
    
    @Column(name = "descricao", length = 255)
    private String descricao;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date termino;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "organizadorid")
    private Organizador organizador;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ambienteid")
    private Ambiente ambiente;
    
    @Enumerated
    @JoinColumn(name = "categoriaid")
    private Categoria categoria;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "eventoid")
    private List<Atividade> atividades;
    
    @Column(name = "ativo", length = 1)
    private int ativo;

    public Evento(String nome, String descricao, Date inicio, Date termino, Organizador organizador, Ambiente ambiente, Categoria categoria, List<Atividade> atividades, int ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.termino = termino;
        this.organizador = organizador;
        this.ambiente = ambiente;
        this.categoria = categoria;
        this.atividades = atividades;
        this.ativo = ativo;
    }
    
    public Evento() {
        this.nome = "";
        this.descricao = "";
        this.inicio = new Date();
        this.termino = new Date();
        this.organizador = new Organizador();
        this.ambiente = new Ambiente();
        this.categoria = categoria.Vazio;
        this.atividades = new LinkedList<Atividade>();
        this.ativo = 1;
    }
    
    
    public Long getEventoid() {
        return eventoid;
    }

    public void setEventoid(Long eventoid) {
        this.eventoid = eventoid;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
    
    public Categoria getCategoria(){
        return categoria;
    }
    
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }
    
    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
    
    public void addAtividade(Atividade atividade){
        if (!atividades.contains(atividade)){
            atividades.add(atividade);
        }
    }
    
    public void removeAtividade(Atividade atividade){
        if (atividades.contains(atividade)){
            atividades.remove(atividade);
        }
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
        hash = 29 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 29 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 29 * hash + (this.inicio != null ? this.inicio.hashCode() : 0);
        hash = 29 * hash + (this.termino != null ? this.termino.hashCode() : 0);
        hash = 29 * hash + (this.ambiente != null ? this.ambiente.hashCode() : 0);
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
        final Evento other = (Evento) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.inicio != other.inicio && (this.inicio == null || !this.inicio.equals(other.inicio))) {
            return false;
        }
        if (this.termino != other.termino && (this.termino == null || !this.termino.equals(other.termino))) {
            return false;
        }
        if (this.ambiente != other.ambiente && (this.ambiente == null || !this.ambiente.equals(other.ambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
