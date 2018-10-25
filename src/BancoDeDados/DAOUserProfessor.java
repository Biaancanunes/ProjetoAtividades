/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;
import dani.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author dani
 */
public class DAOUserProfessor {
    private ConexaoBD conexao;
	
	public DAOUserProfessor() {
		this.conexao = new ConexaoBD();
	}
	
	public void criarRelacao(String loginUser, String matricula) {
		conexao.conectar();

		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into UserProfessor(loginUser, matriculaProfessor) values(?,?)");
			pst.setString(1, loginUser);
			pst.setString(2, matricula);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
	}
	public List<Professor> buscarProfessores(String loginUser) {
		conexao.conectar();
		ResultSet resultado;
        resultado = conexao.executarSQL("select matriculaProfessor from UserProfessor where loginUser = \'" + loginUser + "\'");
                DAOProfessor daoprofessor = new DAOProfessor();
		List<Professor> listP = new ArrayList();
		
		try {
			resultado.next();
			String matriculaProfessor = resultado.getString("matricula");
			Professor p = daoprofessor.buscarProfessor(matriculaProfessor);
                        listP.add(p);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return listP;
	}
}
