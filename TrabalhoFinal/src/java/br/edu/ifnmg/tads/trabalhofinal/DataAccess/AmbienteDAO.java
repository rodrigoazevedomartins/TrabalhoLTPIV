/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Ambiente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.AmbienteRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class AmbienteDAO extends DAOGenerico<Ambiente> implements AmbienteRepositorio{
    
    public AmbienteDAO(){
        super(Ambiente.class);
    }
    
    public List<Ambiente> buscarAmbiente(Ambiente ambiente){
        
        String consulta = "select a from Ambiente a";
        
        String filtro = "";
            
            HashMap<String, Object> param = new HashMap<String, Object>();
            
            if (ambiente != null){
                if(ambiente.getNome() != null && ambiente.getNome().length() > 0){
                    filtro += " s.nome=:nome";
                    param.put("nome", ambiente.getNome());
                }
                
                if(ambiente.getDescricao() != null && ambiente.getDescricao().length() > 0){
                    filtro += " and s.descricao=:descricao";
                    param.put("descricao", ambiente.getDescricao());
                }
                
                if(ambiente.getCapacidadetotal() > 0){
                    filtro += " and s.capacidadetotal=:capacidadetotal";
                    param.put("capacidadetotal", ambiente.getCapacidadetotal());
                }
                
                
            }
            
            if(filtro.length() > 0){
                consulta = consulta + " where " + filtro;
            }
            
            Query query = manager.createQuery(consulta);
            
            for(String par : param.keySet()){
                query.setParameter(par, param.get(param));
            }
            
            //System.out.println(query);
            
            return query.getResultList();
        
    }
    
}
