/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.util.List;
/**
 *
 * @author Dani
 */
public class Usuario {
    private String nome;
    private String login;
    private String senha;
    
    /**
     *
     * @param nome
     * @param login
     * @param senha
     */
    public Usuario ( String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    /**
     *
     * @param login
     */
    public Usuario(String login) {
        this.login = login;
    }
    
    
    public Usuario(){
    }
    
    /**
     *
     * @param tag
     * @param deadline
     * @param disciplina
     * @param desc
     * @param cod_Atidade
     * @return 
     * 
     */
    public Atividade criarAtividade( List<Tag> tag, String deadline, Disciplina disciplina, String desc, int cod_Atidade){
        return new Atividade(tag,deadline,disciplina,desc,cod_Atidade);
    }

    /**
     *
     * @param nome
     * @param cor
     * @return 
     */
    public Tag criarTag(String nome, String cor){
        return new Tag(nome, cor);
    }

    /**
     *
     * @param nome
     * @param acro
     * @param professor
     * @return 
     */
    public Disciplina criarDisciplina(String nome, String acro, String professor){
        return new Disciplina(nome,acro, professor);
    }
    
    /**
     *
     * @param matricula
     * @param nome
     * @return
     */
    public Professor criarProfessor(String matricula, String nome){
        return new Professor(matricula,nome);
    }

    /**
     *
     * @param atv
     */
    public void concluirAtividade(Atividade atv){
        atv.setStatus("Concluida");
    }
    
    /**
     *
     * @param atv
     */
    public void atrasarAtividade(Atividade atv){
        atv.setStatus("Atrasada");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", login=" + login + ", senha=" + senha + '}';
    }
    
}
