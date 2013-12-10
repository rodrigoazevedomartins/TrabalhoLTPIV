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
    Vazio("Selecione", 0),
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoatividadeid(int tipoatividadeid) {
        this.tipoatividadeid = tipoatividadeid;
    }
           
    public String getNome(){
        return this.nome;
    }
    
    public int getTipoAtividadeId(){
        return this.tipoatividadeid;
    }
   
    @Override
    public String toString() {
        return name();
    }
    
    
    
}
