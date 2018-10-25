/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;
import dani.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author dani
 */
public class DAOUsuario {
    private ConexaoBD conexao;
	
	public DAOUsuario() {
		this.conexao = new ConexaoBD();
	}
	
	public void criarUsuario(Usuario user) {
		conexao.conectar();

		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into usuario(login, senha, nome) values(?,?,?)");
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getSenha());
                        pst.setString(3, user.getNome());
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
	}
	public Usuario buscarUsuario(String login) {
		conexao.conectar();
		ResultSet resultado;
        resultado = conexao.executarSQL("select * from usuario where login = \'" + login + "\'");
		Usuario user = new Usuario();
		
		try {
			resultado.next();
			String loginUser = resultado.getString("login");
			String nomeUser = resultado.getString("nome");
			String senha = resultado.getString("senha");
			user.setLogin(loginUser);
                        user.setNome(nomeUser);
                        user.setSenha(senha);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return user;
	}
	
	public void excluirUsuario(String login) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from usuario where login = \'" + login + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}

	
	public ArrayList<Usuario> verTodos() {
		ArrayList<Usuario> pessoas = new ArrayList<>();
		
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from usuario");
		
		try {
			while (resultado.next()) {
				
                                String login = resultado.getString("login");
				String nome = resultado.getString("nome");
				String senha = resultado.getString("senha");
                                
				pessoas.add(new Usuario(nome,login,senha));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		return pessoas;
	}
        public boolean isExiste(String login){
            conexao.conectar();
            ResultSet resultado = conexao.executarSQL("select COUNT(login) from usuario where login = \'" + login + "\'");
            boolean isExist = false;
            try{
                resultado.next();
                int cont = resultado.getInt("count");
                if(cont != 0){
                    isExist = true;
                }
            } catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
            return isExist;
        }
        public void editarNome(String loginUser,String novoNome){
            conexao.conectar();
            try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update usuario set nome = ?"
					+ "where login = \'" + loginUser + "\'");
			stm.setString(1, novoNome);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
        }
        }
        public void editarSenha(String loginUser,String novaSenha){
            conexao.conectar();
            try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update usuario set senha = ?"
					+ "where login = \'" + loginUser + "\'");
			stm.setString(1, novaSenha);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
        }
        }
}
