/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Organizador;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.OrganizadorRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@Named(value = "organizadorController")
@SessionScoped
public class OrganizadorController implements Serializable {

    /**
     * Creates a new instance of OrganizadorController
     */
    
    Organizador organizador;
    
    @EJB
    OrganizadorRepositorio dao;
    
    public OrganizadorController() {
        organizador = new Organizador();
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String novo(){
        organizador = new Organizador();
        return "OrganizadorEditar.xhtml";
    }
    
    public String salvar(){
        dao.Salvar(organizador);
        exibirMensagem("Sucesso");
        return "index.xhtml";
    }
    
    public String voltaPaginaInicial(){
        return "index.xhtml";
    }
    
    public String apagar(){
        organizador.setAtivo(0);
        dao.Apagar(organizador);
        exibirMensagem("Apagado Com Sucesso");
        return "index.xhtml";
    }
    
    public String editar(){
        return "OrganizadorEditar.xhtml";
    }
    
    public void setOrganizador(Organizador organizador){
        this.organizador = organizador;
    }
    
    public Organizador getOrganizador(){
        if(organizador == null){
            organizador = new Organizador();
        }
        
        return this.organizador;
    }
    
    
    
   
}
