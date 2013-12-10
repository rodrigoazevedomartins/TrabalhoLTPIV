/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Atividade;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.AtividadeRepositorio;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Evento;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.TipoAtividade;
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

@Named(value = "atividadeController")
@SessionScoped
public class AtividadeController implements Serializable{
    
    Atividade atividade;
    Atividade filtro;
    List<Atividade> listaAtividade;
    TipoAtividade[] listaTiposAtividade;
    Evento evento;
    
    TipoAtividade tipoatividade;
    
    @EJB
    AtividadeRepositorio dao;
    
    public AtividadeController(){
        atividade = new Atividade();
        filtro = new Atividade();
        listaTiposAtividade = TipoAtividade.values();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
        
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String limparfiltros(){
        filtro = new Atividade();
        filtro.setEvento(atividade.getEvento());
        listaAtividade = dao.buscarAtividade(filtro);
        return "AtividadeListagem.xhtml";
    }
        
    public String novo(){
        atividade = new Atividade();
        atividade.setEvento(filtro.getEvento());
        return "AtividadeEditar.xhtml";
    }
    
    public String salvar(){
        dao.Salvar(atividade);
        listaAtividade = null;
        exibirMensagem("Sucesso");
        return "AtividadeListagem.xhtml";
    }
    
    public String editar(){
        return "AtividadeEditar.xhtml";
    }
    
    public String apagar(){
        atividade.setAtivo(0);
        dao.Apagar(atividade);
        listaAtividade = null;
        exibirMensagem("Sucesso");
        return "AtividadeListagem.xhtml";
    }
    
    public String filtrar(){
        listaAtividade = dao.buscarAtividade(filtro);
        return "AtividadeListagem.xhtml";
    }
    
    public Atividade getAtividade(){
        return this.atividade;
    }
    
    public void setAtividade(Atividade atividade){
        this.atividade = atividade;
    }
    
    public List<Atividade> getListaAtividade(){
        if(listaAtividade == null){
            Atividade filtro = new Atividade();
            filtro.setEvento(atividade.getEvento());
            listaAtividade = dao.buscarAtividade(filtro);
        }
        
        return listaAtividade;
    }
    
    public void setListaAtividade(List<Atividade> listaAtividade){
        this.listaAtividade = listaAtividade;
    }
    
    public void setFiltro(Atividade filtro){
        this.filtro = filtro;
    }
    
    public Atividade getFiltro(){
        return this.filtro;
    }
    
    public TipoAtividade[] getListaTipoAtividade(){
        if (listaTiposAtividade == null){
            listaTiposAtividade = TipoAtividade.values();
        }
        
        return listaTiposAtividade;
    }
    
    public void setListaTipoAtividade(TipoAtividade[] listaTiposAtividade){
        this.listaTiposAtividade = listaTiposAtividade;
    }
    
   
    public TipoAtividade getTipoAtividade(){
        if(tipoatividade == null){
            tipoatividade = TipoAtividade.Vazio;
        }
        
        return this.atividade.getTipoatividade();
    }
    
    public void setTipoAtividade(TipoAtividade tipoatividade){
        this.atividade.setTipoatividade(tipoatividade);
    }
}

