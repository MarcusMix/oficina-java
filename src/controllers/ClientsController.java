package controllers;

import javax.swing.JTable;
import javax.swing.JTextField;

import models.ClientModel;

public class ClientsController {

	public static void handleSearchClient(String QUERY, JTextField inputPesquisar, JTable table) {
		ClientModel.searchClient(QUERY, inputPesquisar, table);
	}

	public static void handleDataClients(JTable table) {
		ClientModel.loadingInfoClients(table);
	}
}
