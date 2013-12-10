/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ingresso;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.IngressoRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */

@Stateless(mappedName = "IngressoRepositorio")
public class IngressoDAO extends DAOGenerico<Ingresso> implements IngressoRepositorio{
    
    public IngressoDAO(){
        super(Ingresso.class);
    }
    
    @Override
    public List<Ingresso> buscarIngresso(Ingresso ingresso){
        
        String consulta = "select i from Ingresso i where i.ativo = 1";
        
        String filtro = "";
        
        HashMap<String, Object> param = new HashMap<String, Object>();
        
        filtro += " i.evento.eventoid=:eventoid";
        param.put("eventoid", ingresso.getEvento().getEventoid());
        
        if(ingresso != null){
            if(ingresso.getNome() != null && ingresso.getNome().length() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                filtro += "i.nome=:nome";
                param.put("nome", ingresso.getNome());
            }
            
            if (ingresso.getDescricao() != null && ingresso.getDescricao().length() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                
                filtro += "i.descricao=:descricao";
                param.put("descricao", ingresso.getDescricao());
            }
            
            if(ingresso.getSetor() != null && ingresso.getSetor().toString().length() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                
                filtro += "i.setor.setorid=:setorid";
                param.put("setorid", ingresso.getSetor().getSetorid());
            }
                  
        }
        
        if(filtro.length() > 0){
            consulta = consulta + " and " + filtro;
        }
        
        Query query = manager.createQuery(consulta);
        
        for(String par : param.keySet()){
            query.setParameter(par, param.get(par));
        }
        
        return query.getResultList();
        
    }
    
}
