/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

/**
 *
 * @author Rodrigo
 */
public enum FormaPagamento {
    
    Vazio("", 0),
    AvistaBoleto("A Vista - Boleto", 1),
    AprazoBoleto("A Prazo - Boleto", 2),
    AvistaCartao("A Vista - Cartão", 3),
    AprazoCartao("A Prazo - Cartão", 4);
    
    private String nome;
    private int formapagamentoid;
    
    FormaPagamento(String nome, int formapagamentoid){
        this.nome = nome;
        this.formapagamentoid = formapagamentoid;
    }
    
    public String consultaFormaPagamento(String nome, int formapagamentoid){
        switch(formapagamentoid){
            case 1: return "A Vista - Boleto";
            case 2: return "A Prazo - Boleto";
            case 3: return "A Vista - Cartão";
            case 4: return "A Prazo - Cartão";
            default: return "";
        }
    }
    
}
