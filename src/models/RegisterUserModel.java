package models;

import java.sql.Connection;
import project.RegisterUser;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

import project.Message;
import project.MessageSucess;

public class RegisterUserModel {
	static final String DB_NAME = "ordemservico";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	static final String USER = "root";
	static final String PASS = "admin";
	static String QUERY = null;
	
	public static void registerUser(String QUERY, JTextField inputSenha, JTextField inputNome, JTextField inputUser) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//criar conexao
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt =  conn.prepareStatement(QUERY);
			int result = pstmt.executeUpdate(QUERY);

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
