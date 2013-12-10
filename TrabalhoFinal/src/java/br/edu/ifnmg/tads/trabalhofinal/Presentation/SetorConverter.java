/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Setor;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.SetorRepositorio;
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

@Named(value = "setorConverter")
@SessionScoped
public class SetorConverter implements Serializable, Converter{
    
    @EJB
    SetorRepositorio dao;
    
    public SetorConverter(){
        
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
            Setor setor = (Setor) value;
            return setor.getSetorid().toString();
        }
    }
    
    
}
