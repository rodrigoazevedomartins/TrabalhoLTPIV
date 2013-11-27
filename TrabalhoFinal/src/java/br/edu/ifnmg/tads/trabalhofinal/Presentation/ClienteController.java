/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Cliente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.ClienteRepositorio;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Pessoa;
import java.io.Serializable;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

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
    
    public String Login(){
       
        if(dao.Login(cliente) == null){
            exibirMensagem("Login ou Senha incorretos");
            return "login.xhtml";
        } else {
            HttpSession sessao;
            FacesContext ctx = FacesContext.getCurrentInstance();
            sessao = (HttpSession) ctx.getExternalContext().getSession(false);
            sessao.setAttribute("usuarioAutenticado", cliente);
            //AppendLog("Login");
            return "index.xhtml";
        }
        
        
        
    }
    
    public String logout(){
        
        HttpSession sessao;
 
        FacesContext ctx = FacesContext.getCurrentInstance();
        sessao = (HttpSession) ctx.getExternalContext().getSession(false);
        sessao.setAttribute("usuarioAutenticado", null);
 
        //AppendLo("Logout");
        
        Enumeration<String> vals = sessao.getAttributeNames(); 
        
        while(vals.hasMoreElements()){
            sessao.removeAttribute(vals.nextElement());
        }
 
        return "login.xhtml";
        
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
}
