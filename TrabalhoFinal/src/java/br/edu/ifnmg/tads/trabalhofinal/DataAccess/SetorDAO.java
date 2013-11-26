/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Setor;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.SetorRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class SetorDAO extends DAOGenerico<Setor> implements SetorRepositorio{
    
    public SetorDAO(){
        super(Setor.class);
    }
    
    public List<Setor> buscarSetor(Setor setor){
        
        String consulta = "select s from Setor s";
        
        String filtro = "";
            
            HashMap<String, Object> param = new HashMap<String, Object>();
            
            if (setor != null){
                if(setor.getNome() != null && setor.getNome().length() > 0){
                    filtro += " s.nome=:nome";
                    param.put("nome", setor.getNome());
                }
                
                if(setor.getDescricao() != null && setor.getDescricao().length() > 0){
                    if(filtro.length() > 0){
                        filtro += " and";
                    }
                   
                    filtro += " s.descricao=:descricao";
                    param.put("descricao", setor.getDescricao());
                }
                
                if(setor.getCapacidade() > 0){
                    if(filtro.length() > 0){
                        filtro += " and";
                    }
                    
                    filtro += " s.capacidade=:capacidade";
                    param.put("capacidade", setor.getCapacidade());
                }
            }
            
            Query query = manager.createQuery(consulta);
            
            for(String par : param.keySet()){
                query.setParameter(par, param.get(param));
            }
            
            //System.out.println(query);
            
            return query.getResultList();
        
        
    }
    
}
