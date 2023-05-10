package models.laborer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import views.message.MessageError;
import views.message.MessageSucess;

public class LaborerModel {
	
	private static final String DB_NAME = "ordemservico";
	private static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	private static final String USER = "root";
	private static final String PASS = "admin";


	public static void registerLaborer(String QUERY, JTextField inputNome, JTextField inputRG, JTextField inputCPF,
			JTextField inputRua, JTextField inputBairro, JTextField inputCidade, JComboBox comboBoxEstado,
			JFormattedTextField inputCEP, JTextField inputEmail, JFormattedTextField inputTelefone1,
			JFormattedTextField inputTelefone2, JComboBox comboBoxCargo, JTextField inputNascimento,
			JTextField inputDataAdmissao, JComboBox comboBoxFuncao) {
		
		if(inputNome.getText().isBlank()) {
			MessageError.handleWindowMessage("Nome em branco!");
			return;
		} else if (inputRG.getText().isBlank()) {
			MessageError.handleWindowMessage("RG em branco!");
			return;
		} else if (inputCPF.getText().isBlank()) {
			MessageError.handleWindowMessage("CPF em branco!");
			return;
		} else if (inputNascimento.getText().isBlank()) {
			MessageError.handleWindowMessage("Data de Nascimento em branco!");
			return;
		} else if (inputEmail.getText().isBlank()) {
			MessageError.handleWindowMessage("E-mail em branco!");
			return;
		} else if (inputTelefone1.getText().isBlank()) {
			MessageError.handleWindowMessage("Telefone 1 em branco!");
			return;
		} else if (inputTelefone2.getText().isBlank()) {
			MessageError.handleWindowMessage("Telefone2 em branco!");
			return;
		} else if (inputCidade.getText().isBlank()) {
			MessageError.handleWindowMessage("Cidade em branco!");
			return;
		} else if (inputRua.getText().isBlank()) {
			MessageError.handleWindowMessage("Rua em branco!");
			return;
		} else if (inputBairro.getText().isBlank()) {
			MessageError.handleWindowMessage("Bairro em branco!");
			return;
		} else if (inputCEP.getText().isBlank()) {
			MessageError.handleWindowMessage("CEP em branco!");
			return;
		} 
		
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement stmt =  conn.prepareStatement(QUERY);

			int result = stmt.executeUpdate(QUERY);

			if(result == 0) {
				MessageError.handleWindowMessage("Erro cadastrar profissional!");
			} else {
				MessageSucess.handleWindowMessageSucess("Profissional cadastrado com sucesso!");
				inputCPF.setText("");
				inputRG.setText("");
				inputNome.setText("");
				inputRG.setText("");
				inputEmail.setText("");
				inputNascimento.setText("");
				inputTelefone1.setText("");
				inputTelefone2.setText("");
				inputCidade.setText("");
				inputBairro.setText("");
				inputRua.setText("");
				inputCEP.setText("");
			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		}
		
	}

}
