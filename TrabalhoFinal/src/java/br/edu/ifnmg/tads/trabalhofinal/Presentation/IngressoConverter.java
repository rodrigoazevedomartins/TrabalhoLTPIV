/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ingresso;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.IngressoRepositorio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Rodrigo
 */

@Named(value = "ingressoConverter")
@SessionScoped
public class IngressoConverter implements Serializable, Converter{
    
    @EJB
    IngressoRepositorio dao;
    
    IngressoConverter(){
        
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;

        } else {
            Long id = Long.parseLong(value);
            return dao.Abrir(id);

        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Ingresso ingresso = (Ingresso) value;
            return ingresso.getIngressoid().toString();
        }
    }
    
}
