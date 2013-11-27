/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DomainModel.RepositorioGenerico;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodrigo
 */
public abstract class DAOGenerico<T> implements RepositorioGenerico<T>{
    
    @PersistenceContext(name = "TrabalhoFinalPU")
    protected EntityManager manager;
    
    private Class tipo;
    
    public DAOGenerico(Class tipo){
        this.tipo = tipo;
    }
    
    public boolean Salvar(T obj){
        try{
            manager.merge(obj);
            manager.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
        
    }
    
    public T Abrir(Long id){
        return (T) manager.find(tipo, id);
    }
    
    public boolean Apagar(T obj){
        try{
            manager.merge(obj);
            return true;
        } catch (Exception ex){
            return false;
        }
    }
    
}
