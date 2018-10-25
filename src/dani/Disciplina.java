/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dani;

/**
 *
 * @author Dani
 */
public class Disciplina {
    private String nome;
    private String acro;
    private String professor;

    public Disciplina(String nome, String acro, String professor) {
        this.nome = nome;
        this.acro = acro;
        this.professor = professor;
    }

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public Disciplina() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAcro() {
        return acro;
    }

    public void setAcro(String acro) {
        this.acro = acro;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", acro=" + acro + ", professor=" + professor + '}';
    }
}
