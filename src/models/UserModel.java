package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import views.Message;
import views.MessageSucess;
import views.UserView;

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
		
		//criar conexao
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt =  conn.prepareStatement(QUERY);
			int result = pstmt.executeUpdate(QUERY);
			
			if(inputNome.getText().isBlank()) {
				handleWindowMessage("Nome em branco!");
				return;
			} else if (inputUser.getText().isBlank()) {
				handleWindowMessage("Usuário em branco!");
				return;
			} else if (inputSenha.getText().isBlank()) {
				handleWindowMessage("Senha em branco!");
				return;
			}

		    if(result == 0) {
		    	handleWindowMessage("Erro ao criar conta!");
		    } else {
		    	handleWindowMessageSucess("Conta criada com sucesso!");
		    	inputSenha.setText("");
		    	inputUser.setText("");
		    	inputNome.setText("");
		    }
		    
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
		
		//fechar conexao
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
				handleWindowMessage("Preencha um dos campos para pesquisar");
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
				handleWindowMessage("Usuário não encontrado!");
				return;
			}
			
			
		} catch (SQLException error) {
			System.out.println("Erro ao pesquisar usuário!" + error.getMessage());
		}
	}
	
	public static void deleteUser(String QUERY, JPasswordField inputSenha, JTextField inputUser, JTextField inputNome) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
			//criar conexao
			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				pstmt =  conn.prepareStatement(QUERY);

				int result = pstmt.executeUpdate(QUERY);

			    if(result == 0) {
			    	handleWindowMessage("Erro ao remover conta!");
			    } else {
			    	handleWindowMessageSucess("Conta removida com sucesso!");
			    	inputSenha.setText("");
			    	inputUser.setText("");
			    	inputNome.setText("");
			    }

			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		
	}
	
	//message
	public static void handleWindowMessage(String text) {
		Message message = new Message(text);
		message.setLocationRelativeTo(null);
		message.setVisible(true);
	}
	
	public static void handleWindowMessageSucess(String text) {
		MessageSucess message = new MessageSucess(text);
		message.setLocationRelativeTo(null);
		message.setVisible(true);
	}

	

	
}
