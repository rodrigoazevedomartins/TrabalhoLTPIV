/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ambiente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.AmbienteRepositorio;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Categoria;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Evento;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.EventoRepositorio;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Organizador;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.OrganizadorRepositorio;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Setor;
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

@Named(value = "eventoController")
@SessionScoped
public class EventoController implements Serializable{
    
    Evento evento;
    Evento filtro;
    Organizador organizador;
    List<Evento> listaEvento;
    List<Ambiente> listaAmbiente;
    Categoria[] listaCategoria;
    
    @EJB
    EventoRepositorio dao;
    @EJB
    AmbienteRepositorio daoAmbiente;
    
    public EventoController(){
        evento = new Evento();
        filtro = new Evento();
        listaCategoria = Categoria.values();
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String limparfiltros(){
        filtro = new Evento();
        listaEvento = dao.buscarEvento(filtro);
        listaAmbiente = daoAmbiente.buscarAmbiente(null);
        return "EventoListagem.xhtml";
    }
    
    public String voltaPagina(){
        return "EventoListagem.xhtml";
    }
    
    public String novo(){
        evento = new Evento();
        return "EventoEditar.xhtml";
    }
    
    public String salvar(){
        if(dao.Salvar(evento)){
        listaEvento = null;
        exibirMensagem("Sucesso");
        return voltaPagina();
        } else {
            exibirMensagem("Erro");
            return voltaPagina();
        }
    }
    
    public String editar(){
        return "EventoEditar.xhtml";
    }
    
    public String apagar(){
        evento.setAtivo(0);
        dao.Apagar(evento);
        listaEvento = null;
        exibirMensagem("Sucesso");
        return voltaPagina();
    }
    
    public String filtrar(){
        listaEvento = dao.buscarEvento(filtro);
        return voltaPagina();
    }
    
    public void setEvento(Evento evento){
        this.evento = evento;
    }
    
    public Evento getEvento(){
        return this.evento;
    }
    
    public Categoria[] getListaCategoria(){
        if(listaCategoria == null){
            listaCategoria = Categoria.values();
        }
        
        return listaCategoria;
    }
    
    public void setListaCategoria(Categoria[] listaCategoria){
        this.listaCategoria = listaCategoria;
    }
    
    public void setFiltro(Evento filtro){
        this.filtro = filtro;
    }
    
    public Evento getFiltro(){
        return this.filtro;
    }
     
    public Organizador getOrganizador(){
        return this.organizador;
    }
    
    public void setOrganizador(Organizador organizador){
        this.organizador = organizador;
    }
    
    public List<Ambiente> getListaAmbiente(){
        if(listaAmbiente == null){
            listaAmbiente = daoAmbiente.buscarAmbiente(null);
        }
        
        return listaAmbiente;
    }
    
    public void setListaAmbiente(List<Ambiente> listaAmbiente){
        this.listaAmbiente = listaAmbiente;
    }
    
    public List<Evento> getListaEvento(){
        if(listaEvento == null){
            Evento filtro = new Evento();
            listaEvento = dao.buscarEvento(filtro);
        }
        
        return listaEvento;
    }
    
    public void setListaEvento(List<Evento> listaEvento){
        this.listaEvento = listaEvento;
    }
       
}
