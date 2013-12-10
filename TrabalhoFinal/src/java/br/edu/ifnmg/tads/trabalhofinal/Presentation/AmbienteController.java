/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ambiente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.AmbienteRepositorio;
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

@Named(value = "ambienteController")
@SessionScoped
public class AmbienteController implements Serializable{
    
    Ambiente ambiente;
    Ambiente filtro;
    List<Ambiente> listaAmbiente;
    
    
    @EJB
    AmbienteRepositorio dao;
    
    
    public AmbienteController(){
        ambiente = new Ambiente();
        filtro = new Ambiente();
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String limparfiltros(){
        filtro = new Ambiente();
        listaAmbiente = dao.buscarAmbiente(filtro);
        return "AmbienteListagem.xhtml";
    }
    
    public String voltaPagina(){
        return "AmbienteListagem.xhtml";
    }
    
    public String novo(){
        ambiente = new Ambiente();
        return "AmbienteEditar.xhtml";
    }
    
    public String Salvar(){
        dao.Salvar(ambiente);
        listaAmbiente = null;
        exibirMensagem("Sucesso");
        return "AmbienteListagem.xhtml";
   }
        
    public String editar(){  
        return "AmbienteEditar.xhtml";
    }
    
    public String apagar(){
        ambiente.setAtivo(0);
        dao.Apagar(ambiente);
        listaAmbiente = null;
        exibirMensagem("Apagado Com sucesso!");
        return "AmbienteListagem.xhtml";
    }
    
    public String filtrar(){
        listaAmbiente = dao.buscarAmbiente(filtro);
        return "AmbienteListagem.xhtml";
    }
    
    public void setAmbiente(Ambiente ambiente){
        this.ambiente = ambiente;
    }
    
    public Ambiente getAmbiente(){
        return this.ambiente;
    }
    
    public List<Ambiente> getListaAmbiente(){
        if(listaAmbiente == null){
            Ambiente filtro = new Ambiente();
            listaAmbiente = dao.buscarAmbiente(filtro);
        }
        
        return listaAmbiente;
    }
    
    public void setListaAmbiente(List<Ambiente> listaambiente){
        this.listaAmbiente = listaambiente;
    }
    
    public void setFiltro(Ambiente filtro){
        this.filtro = filtro;
    }
    
    public Ambiente getFiltro(){
        return this.filtro;
    }
}
