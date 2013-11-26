/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

/**
 *
 * @author Rodrigo
 */
public enum StatusIngresso {
    
    NaoConfirmado("Não Confirmado", 1),
    Confirmado("Confirmado", 2);
    
    private String nome;
    private int statusingressoid;
    
    StatusIngresso(String nome, int statusingressoid){
        this.nome = nome;
        this.statusingressoid = statusingressoid;
    }
    
    public String consultaStatusIngresso(int statusingressoid){
        switch(statusingressoid){
            case 1: return "Não Confirmado";
            case 2: return "Confirmado";
            default: return "";        
        }
    }
    
    
    public int getStatusIngressoId(){
        return this.getStatusIngressoId();
    }
    
    public String getNome(){
        return this.getNome();
    }
    
}
