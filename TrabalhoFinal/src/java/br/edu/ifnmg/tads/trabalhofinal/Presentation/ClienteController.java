/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Cliente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.ClienteRepositorio;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Pessoa;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Rodrigo
 */
@Named(value = "clienteController")
@SessionScoped
public class ClienteController implements Serializable{
    
    Cliente cliente;  
    @EJB
    ClienteRepositorio dao;
    
    public ClienteController(){
        cliente = new Cliente();       
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
       
    public void Salvar(){
        dao.Salvar(cliente);
        exibirMensagem("Sucesso");
    }
    
    public Cliente Abrir(Long id){
        return dao.Abrir(id);
    }
    
    public String voltaPaginaInicial(){
        return "index.xhtml";
    }
    
    public String Apagar(){
        dao.Apagar(cliente);
        return voltaPaginaInicial();
    }
    
    public String Editar(){
        return "ClienteEditar.xhtml";
    }
    
    public void Login(){
       if (dao.Login(cliente)){
           exibirMensagem("sucesso");
       }
        
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
}
