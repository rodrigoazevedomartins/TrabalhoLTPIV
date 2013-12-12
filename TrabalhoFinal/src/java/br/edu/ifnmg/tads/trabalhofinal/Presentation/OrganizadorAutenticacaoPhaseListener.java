/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.Presentation;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Organizador;
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
public class OrganizadorAutenticacaoPhaseListener implements PhaseListener{
    
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();
        ExternalContext ec = fc.getExternalContext();

        if (!fc.getViewRoot().getViewId().contains("LoginOrganizador.xhtml")) {
            HttpSession session = (HttpSession) ec.getSession(true);
            Organizador organizador = (Organizador) session.getAttribute("organizadorAutenticado");

            if (organizador == null) {
                try {
                    ec.redirect(ec.getRequestContextPath() + "/Login.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(OrganizadorAutenticacaoPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
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
