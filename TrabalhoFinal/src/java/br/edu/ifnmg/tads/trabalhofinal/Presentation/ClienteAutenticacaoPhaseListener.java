/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Cliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo
 */
public class ClienteAutenticacaoPhaseListener implements PhaseListener{

    public ClienteAutenticacaoPhaseListener() {
    }
    
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();
        ExternalContext ec = fc.getExternalContext();

        if (!fc.getViewRoot().getViewId().contains("Login.xhtml")) {
            HttpSession session = (HttpSession) ec.getSession(true);
            Cliente cliente = (Cliente) session.getAttribute("clienteAutenticado");

            if (cliente == null) {
                try {
                    ec.redirect(ec.getRequestContextPath() + "/Login.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(ClienteAutenticacaoPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }


}
