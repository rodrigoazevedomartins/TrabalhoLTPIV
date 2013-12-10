/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ambiente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.AmbienteRepositorio;
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

@Named(value = "ambienteConverter")
@SessionScoped
public class AmbienteConverter implements Serializable, Converter{
    
    @EJB
    AmbienteRepositorio daoAmbiente;
    
    
    public AmbienteConverter(){
        
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoAmbiente.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Ambiente a = (Ambiente)value;
          return a.getAmbienteid().toString();
      } 
    }
    
}
