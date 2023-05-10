package controllers;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import models.laborer.LaborerModel;

public class LaborerController {

	public static void handleRegisterLaborer(
			String QUERY,
			JTextField inputNome, 
			JTextField inputRG, 
			JTextField inputCPF,
			JTextField inputRua, 
			JTextField inputBairro, 
			JTextField inputCidade, 
			JComboBox comboBoxEstado,
			JFormattedTextField inputCEP, 
			JTextField inputEmail, 
			JFormattedTextField inputTelefone1,
			JFormattedTextField inputTelefone2, 
			JComboBox comboBoxCargo, 
			JTextField inputNascimento,
			JTextField inputDataAdmissao, 
			JComboBox comboBoxFuncao
			) {

		LaborerModel.registerLaborer(
				QUERY,
				inputNome, 
				inputRG, 
				inputCPF,
				inputRua, 
				inputBairro, 
				inputCidade, 
				comboBoxEstado,
				inputCEP, 
				inputEmail, 
				inputTelefone1,
				inputTelefone2, 
				comboBoxCargo, 
				inputNascimento,
				inputDataAdmissao, 
				comboBoxFuncao);

	}
}
