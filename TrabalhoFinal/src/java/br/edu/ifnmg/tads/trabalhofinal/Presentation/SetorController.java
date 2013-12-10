/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ambiente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Setor;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.SetorRepositorio;
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

@Named(value = "setorController")
@SessionScoped
public class SetorController implements Serializable{
    
    Setor setor;
    Setor filtro;
    List<Setor> listaSetor;
    Ambiente ambiente;
    
    @EJB
    SetorRepositorio dao;
    
    public SetorController(){
        setor = new Setor();
        filtro = new Setor();
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String limparfiltros(){
        filtro = new Setor();
        filtro.setAmbiente(setor.getAmbiente());
        listaSetor = dao.buscarSetor(filtro);
        return "SetorListagem.xhtml";
    }
    
    public String voltaPagina(){
        return "SetorListagem.xhtml";
    }
    
    public String novo(){
        setor = new Setor();
        setor.setAmbiente(filtro.getAmbiente());
        return "SetorEditar.xhtml";
    }
    
    public String salvar(){
        if(dao.Salvar(setor)){
        listaSetor = null;
        exibirMensagem("Sucesso");
        return voltaPagina();
        } else {
            exibirMensagem("Erro");
            return voltaPagina();
        }
    }
    
    public String editar(){
        return "SetorEditar.xhtml";
    }
    
    public String apagar(){
        setor.setAtivo(0);
        dao.Apagar(setor);
        listaSetor = null;
        exibirMensagem("Sucesso");
        return voltaPagina();
    }
    
    public String filtrar(){
        listaSetor = dao.buscarSetor(filtro);
        return voltaPagina();
    }
    
    public Setor getSetor(){
        return this.setor;
    }
    
    public void setSetor(Setor setor){
        this.setor = setor;
    }
    
    public List<Setor> getListaSetor(){
        if(listaSetor == null){
            Setor filtro = new Setor();
            filtro.setAmbiente(setor.getAmbiente());
            listaSetor = dao.buscarSetor(filtro);
        }
        
        return listaSetor;
    }
    
    public void setListaSetor(List<Setor> listaSetor){
        this.listaSetor = listaSetor;
    }
    
    public Setor getFiltro(){
        if (filtro == null){
            filtro = new Setor();
        }
        return this.filtro;
    }
    
    public void setFiltro(Setor filtro){
        this.filtro = filtro;
    }
    
    public Ambiente getAmbiente(){       
        return setor.getAmbiente();
        
    }
    
    public void setAmbiente(Ambiente ambiente){
        this.setor.setAmbiente(ambiente);
        this.filtro.setAmbiente(ambiente);
    }
        
}
