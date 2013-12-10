/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Parceiro;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.ParceiroRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
@Stateless(mappedName = "ParceiroRepositorio")
public class ParceiroDAO extends DAOGenerico<Parceiro> implements ParceiroRepositorio{
    
    public ParceiroDAO(){
        super(Parceiro.class);
    }
    
    public List<Parceiro> buscarParceiro(Parceiro parceiro){
        
        String consulta = "select p from Parceiro p where p.ativo = 1";
        
        String filtro = "";
        
        HashMap<String, Object> param = new HashMap<String, Object>();
        
        if(parceiro != null){
            
            if(parceiro.getNome() != null && parceiro.getNome().length() > 0){
                filtro += "p.nome =:nome";
                param.put("nome", parceiro.getNome());
            }
            
        }
        
        if (filtro.length() > 0){
            consulta = consulta + " and " + filtro;
        }
        
        Query query = manager.createQuery(consulta);
        
        for(String par : param.keySet()){
            query.setParameter(par, param.get(par));
        }
        
        return query.getResultList();
    }
    
}
