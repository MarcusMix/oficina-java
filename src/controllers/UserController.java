package controllers;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.user.UserModel;

public class UserController {
	
	public static void handleDataLoginUser(String QUERY, JTextField inputSenha, JTextField inputNome, JTextField inputUser) {
		
		UserModel.registerUser(QUERY, inputSenha, inputUser, inputNome);	
	}

	public static void handleDataSearchUser(String QUERY, JPasswordField inputSenha, JTextField inputNome, JTextField inputUser) {
		
		UserModel.searchUser(QUERY, inputSenha, inputUser, inputNome);
	}

	public static void handleDataDeleteUser(String QUERY, JTextField inputUser, JTextField inputNome, JPasswordField inputSenha) {
		
		UserModel.deleteUser(QUERY, inputSenha, inputUser, inputNome);
	}

	public static boolean handleLoginUser(String QUERY, JPasswordField inputSenha,	JTextField inputUsuario) {
		return UserModel.loginUser(QUERY, inputSenha, inputUsuario);
	}

	
}
