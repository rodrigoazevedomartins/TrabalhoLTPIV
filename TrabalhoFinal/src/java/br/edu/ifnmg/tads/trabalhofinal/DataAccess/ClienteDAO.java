/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.Cliente;
import br.edu.ifnmg.tads.trabalhofinal.DomainModel.ClienteRepositorio;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
@Stateless(mappedName = "ClienteRepositorio")
public class ClienteDAO extends DAOGenerico<Cliente> implements ClienteRepositorio{
    
    public ClienteDAO(){
        super(Cliente.class);
    }
    
    public Cliente Login(Cliente cliente){
                  
            String consulta = "select c from Cliente c where c.ativo = 1";
            
            String filtro = "";
            
            HashMap<String, Object> param = new HashMap<String, Object>();
            
            if (cliente != null){
                if((cliente.getLogin() != null && cliente.getLogin().length() > 0) && (cliente.getSenha() != null && cliente.getLogin().length() > 0)){
                    filtro += " c.login=:login and c.senha=:senha";
                    param.put("login", cliente.getLogin());
                    param.put("senha", cliente.getSenha());
                }
            }
            
            if(filtro.length() > 0){
                consulta = consulta + " and " + filtro;
            }
            
            Query query = manager.createQuery(consulta);
            
            for(String par : param.keySet()){
                query.setParameter(par, param.get(par));
            }
            
            if(query.getSingleResult()!= null){
                return (Cliente) query.getSingleResult();
            } else {
                return null;
            }
        
    }
    
}
