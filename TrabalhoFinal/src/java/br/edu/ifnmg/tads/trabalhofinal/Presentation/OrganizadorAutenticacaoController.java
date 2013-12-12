/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Organizador;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.OrganizadorRepositorio;
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

@Named(value = "organizadorAutenticacaoController")
@SessionScoped
public class OrganizadorAutenticacaoController implements Serializable{
    
    Organizador organizador;
    Organizador login;
    
    @EJB
    OrganizadorRepositorio organizadordao;
    
    public OrganizadorAutenticacaoController(){
        login = new Organizador();
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String validar(){
        
        try{
            organizador = organizadordao.Login(login);
            
            if(organizador == null){
                exibirMensagem("Null");
                return "LoginOrganizador.xhtml";
            } else {
                HttpSession sessao;
                FacesContext ctx = FacesContext.getCurrentInstance();
                sessao = (HttpSession) ctx.getExternalContext().getSession(false);
                sessao.setAttribute("organizadorAutenticado", organizador);
                exibirMensagem("OK");
                return "index.xhtml";
            }
            
        }catch(Exception ex){
            exibirMensagem("Erro");
            return "LoginOrganizador.xhtml";
        }
        
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Organizador getLogin() {
        return login;
    }

    public void setLogin(Organizador login) {
        this.login = login;
    }
    
    
    
    
}
