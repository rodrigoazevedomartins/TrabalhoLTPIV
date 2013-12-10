/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Compra;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.CompraIngresso;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.CompraRepositorio;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Evento;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ingresso;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.IngressoRepositorio;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Rodrigo
 */

@Named(value = "compraController")
@SessionScoped
public class CompraController implements Serializable{
    
    Compra compra;
    Compra filtro;
    List<Compra> listaCompra;
    Ingresso ingressoCompra;
    List<Ingresso> listaIngressoCompra;
    
    int qtdecompr;
    double valortotal;
    
    
    @EJB
    CompraRepositorio dao;
    
    @EJB
    IngressoRepositorio daoIngresso;
    
    public CompraController(){
        listaIngressoCompra = null;
        compra = new Compra();
        filtro = new Compra();
        ingressoCompra = new Ingresso();
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String voltaPagina(){
        return "CompraSelecionaEvento.xhtml";
    }
    
    public String selecionaIngresso(){
        listaIngressoCompra = null;
        return "CompraSelecionaIngresso.xhtml";
    }
    
    public String informaQuantidade(){
        return "CompraInformaQuantidade.xhtml";
    }
    
    public String adicionaIngressoLista(){
        for(int x=1; x<=qtdecompr; x++){
            CompraIngresso ci = new CompraIngresso();
            ci.setIngresso(ingressoCompra);
            ci.setCompra(compra);
            compra.addIngresso(ci);
            valortotal = valortotal + ingressoCompra.getValor();
        } 
        
        return "CompraListaIngresso.xhtml";
    }
    
    public String novo(){
        qtdecompr = 0;
        valortotal = 0;
        compra = new Compra();
        return "CompraSelecionaEvento.xhtml";
    }
    
    public String salvar(){
        if(dao.Salvar(compra)){
            listaCompra = null;
            exibirMensagem("Sucesso");
            return voltaPagina();
        } else {
            exibirMensagem("Erro");
            return voltaPagina();
        }
    }
    
    public void setCompra(Compra compra){
        this.compra = compra;
    }
    
    public Compra getCompra(){
        return this.compra;
    }
    
    
    public List<Ingresso> getListaIngresso(){
        if(listaIngressoCompra == null){
            Ingresso filtroingresso = new Ingresso();
            filtroingresso.setEvento(ingressoCompra.getEvento());
            listaIngressoCompra = daoIngresso.buscarIngresso(filtroingresso);
        }
        
        return listaIngressoCompra;
    }
    
    public void setListaIngresso(List<Ingresso> listaIngressoCompra){
        this.listaIngressoCompra = listaIngressoCompra;
    }
    
    
    public void setIngresso(Ingresso ingressoCompra){
        this.ingressoCompra = ingressoCompra;
    }
    
    public Ingresso getIngresso(){
        return this.ingressoCompra;
    }
    
    public int getQtdeComprada(){
        return this.qtdecompr;
    }
    
    public void setQtdeComprada(int qtdecompr){
        this.qtdecompr = qtdecompr;
    }
    
    public double getValorTotal(){
        return this.valortotal;
    }
    
    public void setValorTotal(double valortotal){
        this.valortotal = valortotal;
    }
}
