/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DomainModel;

/**
 *
 * @author Rodrigo
 */
public enum Categoria {
    Vazio("Selecione", 0),
    CongressoSeminario("Congresso, Seminário", 1),
    ShowMusicaFesta("Show, Música, Festa", 2),
    Esportivo("Esportivo", 3),
    CursoWorkshop("Curso, Workshop", 4),
    EncontroNetworking("Encontro, Networking", 5),
    FilmeCinemaTeatro("Filme, Cinema, Teatro", 6),
    Outro("Outro", 7);
    
    private String nome;
    private int categoriaid;
    
    Categoria(String nome, int categoriaid){
        this.nome = nome;
        this.categoriaid = categoriaid;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoriaid(int categoriaid) {
        this.categoriaid = categoriaid;
    }
    
    
    
    public int getCategoriaId(){
        return this.categoriaid;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    
    
    @Override
    public String toString() {
        return name();
    }
    
    
}
