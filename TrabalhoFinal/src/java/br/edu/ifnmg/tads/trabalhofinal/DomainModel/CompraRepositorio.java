/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rodrigo
 */

@Local
public interface CompraRepositorio extends RepositorioGenerico<Compra>{
    
    public List<Compra> buscarCompra(Compra compra);
    
    
}
