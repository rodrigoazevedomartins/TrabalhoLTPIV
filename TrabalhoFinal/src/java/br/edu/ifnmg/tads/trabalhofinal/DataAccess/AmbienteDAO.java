/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ambiente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.AmbienteRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */

@Stateless(mappedName = "AmbienteRepositorio")
public class AmbienteDAO extends DAOGenerico<Ambiente> implements AmbienteRepositorio{
    
    public AmbienteDAO(){
        super(Ambiente.class);
    }
    
    public List<Ambiente> buscarAmbiente(Ambiente ambiente){
        
        String consulta = "select a from Ambiente a where a.ativo = 1";
        
        String filtro = "";
            
            HashMap<String, Object> param = new HashMap<String, Object>();
            
            if (ambiente != null){
                if(ambiente.getNome() != null && ambiente.getNome().length() > 0){
                    filtro += "a.nome =:nome";
                    param.put("nome", ambiente.getNome());
                }
                
                if(ambiente.getDescricao() != null && ambiente.getDescricao().length() > 0){
                    if(filtro.length() > 0){
                        filtro += " and ";
                    }
                    
                    filtro += "a.descricao=:descricao";
                    param.put("descricao", ambiente.getDescricao());
                }
                
                if(ambiente.getCapacidadetotal() > 0){
                    if(filtro.length() > 0){
                        filtro += " and ";
                    }
                    
                    filtro += "a.capacidadetotal=:capacidadetotal";
                    param.put("capacidadetotal", ambiente.getCapacidadetotal());
                }
                
                
            }
            
            if(filtro.length() > 0){
                consulta = consulta + " and " + filtro;
            }
            
            Query query = manager.createQuery(consulta);
            
            for(String par : param.keySet()){
                query.setParameter(par, param.get(par));
            }
            
            System.out.println(query);
            
            return query.getResultList();
        
    }
    
}
