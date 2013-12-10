/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Evento;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.EventoRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */

@Stateless(mappedName = "EventoRepositorio")
public class EventoDAO extends DAOGenerico<Evento> implements EventoRepositorio{
    
    public EventoDAO(){
        super(Evento.class);
    }
    
    @Override
    public List<Evento> buscarEvento(Evento evento){
        
        String consulta = "select e from Evento e where e.ativo = 1";
        
        String filtro = "";
        
        HashMap<String, Object> param = new HashMap<String, Object>();
        
        if(evento != null){
            if(evento.getNome() != null && evento.getNome().length() > 0){
                filtro += "e.nome =:nome";
                param.put("nome", evento.getNome());
            }
            
            if(evento.getDescricao() != null && evento.getDescricao().length() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                
                filtro += "e.descricao =:descricao";
                param.put("descricao", evento.getDescricao());
            }
            
            if(evento.getAmbiente() != null && evento.getAmbiente().toString().length() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                filtro += "e.ambiente.ambienteid =:ambienteid";
                param.put("ambienteid", evento.getAmbiente().getAmbienteid());
            }
            
            
            if(evento.getCategoria().getCategoriaId() > 0){
                if(filtro.length() > 0){
                    filtro += " and ";
                }
                
                filtro += "e.categoria=:categoriaid";
                param.put("categoriaid", evento.getCategoria());
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
