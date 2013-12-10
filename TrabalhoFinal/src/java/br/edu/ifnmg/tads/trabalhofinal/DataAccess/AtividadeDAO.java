/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Atividade;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.AtividadeRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */

@Stateless(mappedName = "AtividadeRepositorio")
public class AtividadeDAO extends DAOGenerico<Atividade> implements AtividadeRepositorio{
    
    public AtividadeDAO(){
        super(Atividade.class);
    }
    
    public List<Atividade> buscarAtividade(Atividade atividade){
        
        String consulta = "select a from Atividade a where a.ativo = 1";
        
        String filtro = "";
        
        HashMap<String, Object> param = new HashMap<String, Object>();
        
        filtro = " a.evento.eventoid=:eventoid";
        param.put("eventoid", atividade.getEvento().getEventoid());
        
        
        if (atividade != null){
            if(atividade.getNome() != null && atividade.getNome().length() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                filtro += "a.nome =:nome";
                param.put("nome", atividade.getNome());
            }
            
            if(atividade.getDescricao() != null && atividade.getDescricao().length() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                filtro += "a.descricao =:descricao";
                param.put("descricao", atividade.getDescricao());
            }
            
            if(atividade.getLocal() != null && atividade.getLocal().length() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                filtro += "a.local =:local";
                param.put("local", atividade.getLocal());
            }
            
            if(atividade.getTipoatividade().getTipoAtividadeId() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                filtro += "a.tipoatividade=:tipoatividadeid";
                param.put("tipoatividadeid", atividade.getTipoatividade());
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
