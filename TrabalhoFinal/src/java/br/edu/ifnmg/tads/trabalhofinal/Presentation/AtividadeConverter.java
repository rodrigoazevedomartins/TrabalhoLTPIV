/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Rodrigo
 */

@FacesConverter(value = "AtividadeConverter")
public class AtividadeConverter implements Serializable, Converter{
    
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {  
          
        df.setLenient(false);  
        try {  
              
            return df.parse(arg2);              
              
        } catch (Exception e) {  
              
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));   
        }  
    }  
  
    @Override  
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {  
        try {  
              
            df.setLenient(false);  
            String d = df.format((Date) arg2);  
              
            return d;  
        } catch (Exception e) {  
            return "";  
        }  
    }  

    
}
