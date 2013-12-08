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
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "atividade")
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atividadeid;

    @Column(name = "nome", length = 255)
    private String nome;
    
    @Column(name = "descricao", length = 255)
    private String descricao;
    
    @Column(name = "local", length = 255)
    private String local;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inicio")
    private Date inicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "termino")
    private Date termino;
  
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "eventoid")
    private Evento evento;
    
    @Enumerated
    @JoinColumn(name = "tipoaatividadeid")
    private TipoAtividade tipoatividade;
    
    @Column(name = "ativo", length = 1)
    private int ativo;
    
    public Atividade(String nome, String descricao, String local, Date inicio, Date termino, Evento evento, int ativo, TipoAtividade tipoatividade) {
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.inicio = inicio;
        this.termino = termino;
        this.evento = evento;
        this.tipoatividade = tipoatividade;
        this.ativo = ativo;
    }
    
    public Atividade(){
        this.nome = "";
        this.descricao = "";
        this.local = "";
        this.inicio = new Date(0);
        this.termino = new Date(0);
        this.evento = new Evento();
        this.ativo = 1;
        this.tipoatividade = tipoatividade.Vazio;
    }

    public Long getAtividadeid() {
        return atividadeid;
    }

    public void setAtividadeid(Long atividadeid) {
        this.atividadeid = atividadeid;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public void setAtivo(int ativo){
        this.ativo = ativo;
    }
    
    public int getAtivo(){
        return this.ativo;
    }
    public TipoAtividade getTipoatividade() {
        return tipoatividade;
    }

    public void setTipoatividade(TipoAtividade tipoatividade) {
        this.tipoatividade = tipoatividade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 41 * hash + (this.local != null ? this.local.hashCode() : 0);
        hash = 41 * hash + (this.inicio != null ? this.inicio.hashCode() : 0);
        hash = 41 * hash + (this.termino != null ? this.termino.hashCode() : 0);
        hash = 41 * hash + (this.evento != null ? this.evento.hashCode() : 0);
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
        final Atividade other = (Atividade) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.local == null) ? (other.local != null) : !this.local.equals(other.local)) {
            return false;
        }
        if (this.inicio != other.inicio && (this.inicio == null || !this.inicio.equals(other.inicio))) {
            return false;
        }
        if (this.termino != other.termino && (this.termino == null || !this.termino.equals(other.termino))) {
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
