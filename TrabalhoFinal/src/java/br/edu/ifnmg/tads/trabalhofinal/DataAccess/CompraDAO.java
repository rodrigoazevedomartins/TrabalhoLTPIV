/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Compra;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.CompraRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */

@Stateless(mappedName = "CompraRepositorio")
public class CompraDAO extends DAOGenerico<Compra> implements CompraRepositorio{
    
    public CompraDAO(){
        super(Compra.class);
    }
    
    @Override
    public List<Compra> buscarCompra(Compra compra){
        
        String consulta = "select cp from Compra cp where cp.ativo = 1";
        
        String filtro = "";
        
        HashMap<String, Object> param = new HashMap<String, Object>();
        
        if (compra != null){
            
            if(compra.getCliente().getPessoaid() > 0){
                filtro = " cp.cliente.clienteid=:clienteid";
                param.put("clienteid", compra.getCliente().getPessoaid());       
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
