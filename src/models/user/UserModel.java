package models.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import views.message.MessageError;
import views.message.MessageSucess;

public class UserModel {
	static final String DB_NAME = "ordemservico";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	static final String USER = "root";
	static final String PASS = "admin";
	static String QUERY = null;
	
	public static void registerUser(String QUERY, JTextField inputSenha, JTextField inputNome, JTextField inputUser) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt =  conn.prepareStatement(QUERY);
			int result = pstmt.executeUpdate(QUERY);
			
			if(inputNome.getText().isBlank()) {
				MessageError.handleWindowMessage("Nome em branco!");
				return;
			} else if (inputUser.getText().isBlank()) {
				MessageError.handleWindowMessage("Usuário em branco!");
				return;
			} else if (inputSenha.getText().isBlank()) {
				MessageError.handleWindowMessage("Senha em branco!");
				return;
			}

		    if(result == 0) {
		    	MessageError.handleWindowMessage("Erro ao criar conta!");
		    } else {
		    	MessageSucess.handleWindowMessageSucess("Conta criada com sucesso!");
		    	inputSenha.setText("");
		    	inputUser.setText("");
		    	inputNome.setText("");
		    }
		    
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
		
		try {
		    if (conn != null) {
		        conn.close();
		    }
		} catch (SQLException error) {
		    System.out.println("Erro ao fechar a conexão com o banco de dados: " + error.getMessage());
		}
	}
	
	public static void searchUser(String QUERY, JPasswordField inputSenha, JTextField inputUser, JTextField inputNome) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String usuario = null;
		String nome = null;
		String senha = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt =  conn.prepareStatement(QUERY);
			rs = stmt.executeQuery(QUERY);

			if(inputUser.getText().isBlank() && inputNome.getText().isBlank()) {
				MessageError.handleWindowMessage("Preencha um dos campos para pesquisar");
				return;
			}
			
			while(rs.next()) {
				usuario = rs.getString("usuario");
				nome = rs.getString("nome");
				senha = rs.getString("senha");
				
				inputUser.setText(usuario);
				inputNome.setText(nome);
				inputSenha.setText(senha);
			}
			
			if(usuario == null) {
				MessageError.handleWindowMessage("Usuário não encontrado!");
				return;
			}
			
			
		} catch (SQLException error) {
			System.out.println("Erro ao pesquisar usuário!" + error.getMessage());
		}
	}
	
	public static void deleteUser(String QUERY, JPasswordField inputSenha, JTextField inputUser, JTextField inputNome) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				pstmt =  conn.prepareStatement(QUERY);

				int result = pstmt.executeUpdate(QUERY);

			    if(result == 0) {
			    	MessageError.handleWindowMessage("Erro ao remover conta!");
			    } else {
			    	MessageSucess.handleWindowMessageSucess("Conta removida com sucesso!");
			    	inputSenha.setText("");
			    	inputUser.setText("");
			    	inputNome.setText("");
			    }

			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		
	}

	public static boolean loginUser(JPasswordField inputSenha, JTextField inputUsuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		QUERY = "SELECT * FROM usuarios WHERE usuario = '" 
		+ inputUsuario.getText() + "' AND senha = '" + inputSenha.getText() + "'";
		
		boolean fechar = false;
		String usuario = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt =  conn.prepareStatement(QUERY);
		    rs = stmt.executeQuery(QUERY);
		    
			while (rs.next()) {
				 usuario = rs.getString("usuario");
				
				 if(usuario.equals(inputUsuario.getText())) {
					 MessageSucess.handleWindowMessageSucess("Bem-vindo de volta!");
					 return fechar = true;
				 } 
			}

			if(usuario == null) {
				MessageError.handleWindowMessage("Usuário ou senha incorreto!");
				return fechar = false;
			} 

		} catch (SQLException erro) {
			erro.printStackTrace();
		}
		return fechar;
	}
	
}
