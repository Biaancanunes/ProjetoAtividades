/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import BancoDeDados.DAOProfessor;
import BancoDeDados.DAOUserProfessor;
import BancoDeDados.DAOUsuario;

/**
 *
 * @author Dani
 */
public class Dani {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario user = new Usuario("Dani");
        //DAOUsuario daouser = new DAOUsuario();
        //daouser.excluirUsuario("Dani");
        DAOProfessor daoprofessor = new DAOProfessor();
        Professor p = user.criarProfessor("201610040050", "Jhonatan");
        daoprofessor.criarProfessor(p);
        //DAOUserProfessor daouserprofessor = new DAOUserProfessor();
        //daouserprofessor.criarRelacao("Dani", "Jhonatan");
        
        
    }
    
}
