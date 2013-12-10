/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Setor;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.SetorRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */

@Stateless(mappedName = "SetorRepositorio")
public class SetorDAO extends DAOGenerico<Setor> implements SetorRepositorio{
    
    public SetorDAO(){
        super(Setor.class);
    }
    
    public List<Setor> buscarSetor(Setor setor){
        
        String consulta = "select s from Setor s where s.ativo = 1";
        
        String filtro = "";
            
            HashMap<String, Object> param = new HashMap<String, Object>();
            
            filtro += " s.ambiente.ambienteid=:ambienteid";
            param.put("ambienteid", setor.getAmbiente().getAmbienteid());
            
            if (setor != null){
                if(setor.getNome() != null && setor.getNome().length() > 0){
                    if(filtro.length() > 0){
                        filtro += " and ";
                    }
                    
                    filtro += "s.nome=:nome";
                    param.put("nome", setor.getNome());
                }
                
                if(setor.getDescricao() != null && setor.getDescricao().length() > 0){
                    if(filtro.length() > 0){
                        filtro += " and ";
                    }
                   
                    filtro += "s.descricao=:descricao";
                    param.put("descricao", setor.getDescricao());
                }
                
                if(setor.getCapacidade() > 0){
                    if(filtro.length() > 0){
                        filtro += " and ";
                    }
                    
                    filtro += "s.capacidade=:capacidade";
                    param.put("capacidade", setor.getCapacidade());
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
