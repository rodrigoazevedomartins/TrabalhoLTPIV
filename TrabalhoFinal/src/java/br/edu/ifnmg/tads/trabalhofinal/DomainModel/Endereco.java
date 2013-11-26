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
@Table(name="endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enderecoid;
    
    @Column(name = "rua", length = 255)
    private String rua;
    
    @Column(name = "numero", length = 11)
    private int numero;
    
    @Column(name = "complemento", length = 255)
    private String complemento;
    
    @Column(name = "bairro", length = 255)
    private String bairro;
    
    @Column(name = "cidade", length = 255)
    private String cidade;
    
    @Column(name = "cep", length = 9)
    private String cep;
    
    @Column(name = "estado", length = 255)
    private String estado;
    
    @Column(name = "pais", length = 255)
    private String pais;

    public Endereco(String rua, int numero, String complemento, String bairro, String cidade, String cep, String estado, String pais) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.pais = pais;
    }
    
    public Endereco() {
        this.rua = "";
        this.numero = 0;
        this.complemento = "";
        this.bairro = "";
        this.cidade = "";
        this.cep = "";
        this.estado = "";
        this.pais = "";
    }
    
    public Long getEnderecoId() {
        return enderecoid;
    }

    public void setEnderecoId(Long enderecoid) {
        this.enderecoid = enderecoid;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.rua != null ? this.rua.hashCode() : 0);
        hash = 79 * hash + this.numero;
        hash = 79 * hash + (this.complemento != null ? this.complemento.hashCode() : 0);
        hash = 79 * hash + (this.bairro != null ? this.bairro.hashCode() : 0);
        hash = 79 * hash + (this.cidade != null ? this.cidade.hashCode() : 0);
        hash = 79 * hash + (this.cep != null ? this.cep.hashCode() : 0);
        hash = 79 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 79 * hash + (this.pais != null ? this.pais.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if ((this.rua == null) ? (other.rua != null) : !this.rua.equals(other.rua)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if ((this.complemento == null) ? (other.complemento != null) : !this.complemento.equals(other.complemento)) {
            return false;
        }
        if ((this.bairro == null) ? (other.bairro != null) : !this.bairro.equals(other.bairro)) {
            return false;
        }
        if ((this.cidade == null) ? (other.cidade != null) : !this.cidade.equals(other.cidade)) {
            return false;
        }
        if ((this.cep == null) ? (other.cep != null) : !this.cep.equals(other.cep)) {
            return false;
        }
        if ((this.estado == null) ? (other.estado != null) : !this.estado.equals(other.estado)) {
            return false;
        }
        if ((this.pais == null) ? (other.pais != null) : !this.pais.equals(other.pais)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getRua();
    }
    
    
    
    
}
