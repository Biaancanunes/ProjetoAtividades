/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dani
 */
public class Atividade {
    private int cod_Atividade;  
    private List<Tag> tag;
    private String deadline;
    private Disciplina disciplina;
    private String desc;
    private String status;

    public Atividade(List<Tag> tag, String deadline, Disciplina disciplina, String desc, int cod_Atividade, String status) {
        this.tag = tag;
        this.deadline = deadline;
        this.disciplina = disciplina;
        this.desc = desc;
        this.cod_Atividade = cod_Atividade;
        this.status = status;
    }

    public Atividade(int cod_Atividade, String deadline) {
        this.deadline = deadline;
        this.cod_Atividade = cod_Atividade;
        this.tag = new ArrayList();
    }

    public Atividade(List<Tag> tag, String deadline, Disciplina disciplina, String desc, int cod_Atividade) {
        this.tag = tag;
        this.deadline = deadline;
        this.disciplina = disciplina;
        this.desc = desc;
        this.cod_Atividade = cod_Atividade;
        this.status = "Pendente";
    }

    public Atividade() {
    }
    

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }
    
    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCod_Atividade() {
        return cod_Atividade;
    }

    public void setCod_Atividade(int cod_Atidade) {
        this.cod_Atividade = cod_Atidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Atividade{" + "cod_Atividade=" + cod_Atividade + ", tag=" + tag + ", deadline=" + deadline + ", disciplina=" + disciplina + ", desc=" + desc + ", status=" + status + '}';
    }
}
