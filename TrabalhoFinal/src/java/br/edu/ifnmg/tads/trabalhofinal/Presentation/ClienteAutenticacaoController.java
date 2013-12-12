/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Cliente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.ClienteRepositorio;
import com.sun.msv.reader.Controller;
import java.io.Serializable;
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

@Named(value = "clienteAutenticacaoController")
@SessionScoped
public class ClienteAutenticacaoController implements Serializable{
    
    Cliente login;
    Cliente cliente;
    
    @EJB
    ClienteRepositorio clientedao;
  
    
    public ClienteAutenticacaoController(){
        login = new Cliente();
    }
      
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String validar(){       

        try {
        
        cliente = clientedao.Login(login);
        
        if(cliente == null){
            exibirMensagem("Null");
            return "Login.xhtml";
        } else {
            HttpSession sessao;
            FacesContext ctx = FacesContext.getCurrentInstance();
            sessao = (HttpSession) ctx.getExternalContext().getSession(false);
            sessao.setAttribute("clienteAutenticado", cliente);
            exibirMensagem("OK");
            return "indexCliente.xhtml";
        }
        
        } catch (Exception ex) {
            exibirMensagem("Erro");
            return "Login.xhtml";
        }
    }
            
    public void setLogin(Cliente login){
        this.login = login;
    }
        
    public Cliente getLogin(){
        return this.login;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
}
