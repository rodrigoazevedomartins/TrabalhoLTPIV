/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Organizador;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.OrganizadorRepositorio;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */

@Stateless(mappedName = "OrganizadorRepositorio")
public class OrganizadorDAO extends DAOGenerico<Organizador> implements OrganizadorRepositorio{
    
    public OrganizadorDAO(){
        super(Organizador.class);    
    }
    
    public boolean Login(Organizador organizador){
        
        String consulta = "select o from Organizador o where o.ativo = 1";
        
        String filtro = "";
            
            HashMap<String, Object> param = new HashMap<String, Object>();
            
            if (organizador != null){
                if((organizador.getLogin() != null && organizador.getLogin().length() > 0) && (organizador.getSenha() != null && organizador.getLogin().length() > 0)){
                    filtro += " o.login=:login and o.senha=:senha";
                    param.put("login", organizador.getLogin());
                    param.put("senha", organizador.getSenha());
                }
            }
            
            if(filtro.length() > 0){
                consulta = consulta + " and " + filtro;
            }
            
            Query query = manager.createQuery(consulta);
            
            for(String par : param.keySet()){
                query.setParameter(par, param.get(par));
            }
            
            if(query.getResultList() != null){
                return true;
            } else {
                return false;
            }
    }
    
}
