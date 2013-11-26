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
    Vazio("Vazio", 0),
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
    
    public String consultaCategoria(int categoriaid){
        switch(categoriaid){
            case 0: return "";
            case 1: return "Congresso, Seminário";
            case 2: return "Show, Música, Festa";
            case 3: return "Esportivo";
            case 4: return "Curso, Workshop";
            case 5: return "Encontro, Networking";
            case 6: return "Filme, Cinema, Teatro";
            case 7: return "Outro";
            default: return "";
        }
    }
    
    public int getCategoriaId(){
        return this.categoriaid;
    }
    
    public String getNome(){
        return this.nome;
    }
}
