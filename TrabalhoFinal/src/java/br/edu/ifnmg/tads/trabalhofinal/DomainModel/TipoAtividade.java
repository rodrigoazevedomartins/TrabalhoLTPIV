/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

/**
 *
 * @author Rodrigo
 */
public enum TipoAtividade {
    Vazio("Vazio", 0),
    Palestra("Paletra", 1),
    Minicurso("Minicurso", 2),
    Abertura("Abertura", 3),
    Intervalo("Intervalo", 4),
    MesaRedonda("Mesa Redonda", 5),
    WorkShop("Workshop", 6),
    ApresentacaoodeArtigos("Apresentação de Artigos", 7);
    
    private String nome;
    private int tipoatividadeid;
    
    TipoAtividade(String nome, int tipoatividadeid){
        this.nome = nome;
        this.tipoatividadeid = tipoatividadeid;
    }
    
    public String consultaTipoAtividade(int tipoatividade){
        switch(tipoatividade){
            case 0: return "Vazio";
            case 1: return "Palestra";
            case 2: return "Minicurso";
            case 3: return "Abertura";
            case 4: return "Intervalo";
            case 5: return "Mesa Redonda";
            case 6: return "Workshop";
            case 7: return "Apresentação de Artigos";
            default: return "";
        }
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getTipoAtividadeId(){
        return this.tipoatividadeid;
    }
    
}
