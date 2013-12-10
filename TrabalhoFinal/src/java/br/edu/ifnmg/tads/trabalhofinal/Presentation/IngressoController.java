/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Evento;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ingresso;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.IngressoRepositorio;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Setor;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.SetorRepositorio;
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

@Named(value = "ingressoController")
@SessionScoped
public class IngressoController implements Serializable{
    
    Ingresso ingresso;
    Ingresso filtro;
    List<Ingresso> listaIngresso;
    List<Setor> listaSetor;
    Setor setor;
    
    @EJB
    IngressoRepositorio dao;
    
    @EJB
    SetorRepositorio daoSetor;
    
    public IngressoController(){
        ingresso = new Ingresso();
        filtro = new Ingresso();
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String limparfiltros(){
        filtro = new Ingresso();
        filtro.setEvento(ingresso.getEvento());
        listaIngresso = dao.buscarIngresso(filtro);
        setor = new Setor();
        setor.setAmbiente(filtro.getEvento().getAmbiente());
        listaSetor = daoSetor.buscarSetor(setor);
        return "IngressoListagem.xhtml";
    }
    
    public String voltaPagina(){
        return "IngressoListagem.xhtml";
    }
    
    public String novo(){
        ingresso = new Ingresso();
        ingresso.setEvento(filtro.getEvento());
        return "IngressoEditar.xhtml";
    }
    
    public String salvar(){
        if(dao.Salvar(ingresso)){
        listaIngresso = null;
        exibirMensagem("Sucesso");
        return voltaPagina();
        } else {
            exibirMensagem("Erro");
            return voltaPagina();
        }
    }
    
    public String editar(){
        return "IngressoEditar.xhtml";
    }
    
    public String apagar(){
        ingresso.setAtivo(0);
        dao.Apagar(ingresso);
        listaIngresso = null;
        exibirMensagem("Sucesso");
        return voltaPagina();
    }
    
    public String filtrar(){
        listaIngresso = dao.buscarIngresso(filtro);
        return voltaPagina();
    }
    
    public Ingresso getIngresso(){
        return this.ingresso;
    }
    
    public void setIngresso(Ingresso ingresso){
        this.ingresso = ingresso;
    }
    
    public List<Ingresso> getListaIngresso(){
        if(listaIngresso == null){
            Ingresso filtro = new Ingresso();
            filtro.setEvento(ingresso.getEvento());
            listaIngresso = dao.buscarIngresso(filtro);
        }
        
        return listaIngresso;
    }
    
    public void setListaIngresso(List<Ingresso> listaIngresso){
        this.listaIngresso = listaIngresso;
    }
    
    public Ingresso getFiltro(){
        if (filtro == null){
            filtro = new Ingresso();
        }
        return this.filtro;
    }
    
    public void setFiltro(Ingresso filtro){
        this.filtro = filtro;
    }
    
    public List<Setor> getListaSetor(){
        if(listaSetor == null){
            setor = new Setor();
            setor.setAmbiente(ingresso.getEvento().getAmbiente());
            listaSetor = daoSetor.buscarSetor(setor);
        }
        
        return listaSetor;
    }
    
    public void setListaSetor(List<Setor> listaSetor){
        this.listaSetor = listaSetor;
    }
    
}
