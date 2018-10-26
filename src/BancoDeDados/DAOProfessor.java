/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;
import Classes.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class DAOProfessor {
    private ConexaoBD conexao;
	
	public DAOProfessor() {
		this.conexao = new ConexaoBD();
	}
	
	public void criarProfessor(Professor p) {
		conexao.conectar();

		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into professor(matricula,nome) values(?,?)");
			pst.setString(1, p.getNome());
			pst.setString(2, p.getMatricula());
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
	}
	public Professor buscarProfessor(String matricula) {
		conexao.conectar();
		ResultSet resultado;
        resultado = conexao.executarSQL("select * from Professor where matricula = \'" + matricula + "\'");
		Professor p = new Professor();
		
		try {
			resultado.next();
			String matriculaProfessor = resultado.getString("matricula");
			String nome = resultado.getString("nome");
			p.setMatricula(matriculaProfessor);
                        p.setNome(nome);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return p;
	}
	
	public void excluirProfessor(String matricula) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from Professor where matricula = \'" + matricula + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}
}
