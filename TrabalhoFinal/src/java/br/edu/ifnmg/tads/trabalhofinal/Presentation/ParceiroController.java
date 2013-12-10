/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ambiente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Parceiro;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.ParceiroRepositorio;
import java.io.Serializable;
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

@Named(value = "parceiroController")
@SessionScoped
public class ParceiroController implements Serializable{
    
    Parceiro parceiro;
    Parceiro filtro;
    List<Parceiro> listaParceiro;
    
    @EJB
    ParceiroRepositorio dao;
    
    public ParceiroController(){
        parceiro = new Parceiro();
        filtro = new Parceiro();
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    
    public String limparfiltros(){
        filtro = new Parceiro();
        listaParceiro = dao.buscarParceiro(filtro);
        return "ParceiroListagem.xhtml";
    }
    
    public String voltaPagina(){
        return "ParceiroListagem.xhtml";
    }
    
    public String novo(){
        parceiro = new Parceiro();
        return "ParceiroEditar.xhtml";
    }
    
    public String salvar(){
        dao.Salvar(parceiro);
        listaParceiro = null;
        exibirMensagem("Sucesso");
        return "ParceiroListagem.xhtml";
   }
        
    public String editar(){  
        return "ParceiroEditar.xhtml";
    }
    
    public String apagar(){
        parceiro.setAtivo(0);
        dao.Apagar(parceiro);
        listaParceiro = null;
        exibirMensagem("Apagado Com sucesso!");
        return "ParceiroListagem.xhtml";
    }
    
    public String filtrar(){
        listaParceiro = dao.buscarParceiro(filtro);
        return "ParceiroListagem.xhtml";
    }
    
    public Parceiro getParceiro(){        
        return this.parceiro;
    }
    
    public void setParceiro(Parceiro parceiro){
        this.parceiro = parceiro;
    }
    
    public List<Parceiro> getListaParceiro(){
        if(listaParceiro == null){
            Parceiro filtro = new Parceiro();
            listaParceiro = dao.buscarParceiro(filtro);
        }
        
        return listaParceiro;
    }
    
    public void setListaParceiro(List<Parceiro> listaParceiro){
        this.listaParceiro = listaParceiro;
    }
    
    public Parceiro getFiltro(){       
        return this.filtro;
    }
    
    public void setFiltro(Parceiro filtro){
        this.parceiro = filtro;
    }
    
}
