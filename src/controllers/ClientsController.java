package controllers;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.client.ClientModel;
import models.clientEach.ClientEachModel;

public class ClientsController {

	public static void handleSearchClient(String QUERY, JTextField inputPesquisar, JTable table) {
		ClientModel.searchClient(QUERY, inputPesquisar, table);
	}

	public static void handleDataClients(JTable table) {
		ClientModel.loadingInfoClients(table);
	}

	public static void handleRegisterClient(
			String QUERY, 
			JTextField inputNome, 
			JTextField inputRG, 
			JTextField inputCPF, 
			JTextField inputRua, 
			JTextField inputBairro,
			JTextField inputCidade, 
			JComboBox<?> comboBoxEstado,
			JTextField inputCEP, 
			JTextField inputEmail, 
			JTextField inputTelefone1, 
			JTextField inputTelefone2, 
			JTextArea inputOBS, 
			JTextField inputNascimento)
	
	{
		ClientModel.registerClient(
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
				inputOBS, 
				inputNascimento
				);
		
	}

	public static void handleSearchEachClient(String QUERY, JTextField inputNome, JTextField inputCPF, JTable table) {
		ClientEachModel.searchEachClient(QUERY, inputNome, inputCPF, table);
		
	}

	public static void grabClientsInDb(JTable table) {
		ClientEachModel.grabClients(table);
	}

	public static void handleDeleteClient(String QUERY, JTextField inputNome, JTextField inputCPF) {
		ClientEachModel.deleteClients(QUERY, inputNome, inputCPF);
	}
	
	public static void handleSearchAllClients(String QUERY, JTable table, JTextField inputPesquisar) {
		ClientEachModel.searchAllClients(QUERY, table, inputPesquisar);
	}
}
