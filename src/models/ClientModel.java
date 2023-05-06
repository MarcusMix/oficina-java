package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

public class ClientModel {
	private String nome;
	private String cpf;
	private String email;
	private String fone1;
	private String cidade;
	private String estado;
	
	static List<ClientModel> ClientesX = new ArrayList<ClientModel>();
	static ClientesTB pegador = new ClientesTB(ClientesX);
	
	static final String DB_NAME = "ordemservico";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	static final String USER = "root";
	static final String PASS = "admin";
	static String QUERY = null;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone1() {
		return fone1;
	}
	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}
	public static void searchClient(String QUERY, JTextField inputPesquisar, JTable table) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String nome, cpf, email, tel1, cidade, estado = null;
		
		ClientesX.clear();

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt =  conn.prepareStatement(QUERY);
			rs = pstmt.executeQuery(QUERY);
			
			ClientesX.clear();
			while(rs.next()) {
				nome = rs.getString("nome");
				cpf = rs.getString("cpf");
				email = rs.getString("email");
				tel1 = rs.getString("fone1");
				cidade = rs.getString("cidade");
				estado = rs.getString("estado");
					
				ClientModel clientes = new ClientModel();
				clientes.setNome(nome);
				clientes.setCpf(cpf);;
				clientes.setEmail(email);
				clientes.setFone1(tel1);
				clientes.setCidade(cidade);
				clientes.setEstado(estado);
				
				ClientesX.add(clientes);
			}
			
		} catch (SQLException error) {
			error.printStackTrace();
		}	
		
		ClientesTB pegaval = new ClientesTB(ClientesX);
		table.setModel(pegaval);
		
	}
	public static void loadingInfoClients(JTable table) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QUERY = "SELECT * FROM clientes";
		
		String nome, cpf, email, tel1, cidade, estado = null;
		
		ClientesX.clear();

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			pstmt =  conn.prepareStatement(QUERY);
			rs = pstmt.executeQuery(QUERY);
			
			ClientesX.clear();
			while(rs.next()) {
				nome = rs.getString("nome");
				cpf = rs.getString("cpf");
				email = rs.getString("email");
				tel1 = rs.getString("fone1");
				cidade = rs.getString("cidade");
				estado = rs.getString("estado");
					
				ClientModel clientes = new ClientModel();
				clientes.setNome(nome);
				clientes.setCpf(cpf);;
				clientes.setEmail(email);
				clientes.setFone1(tel1);
				clientes.setCidade(cidade);
				clientes.setEstado(estado);
				
				ClientesX.add(clientes);
			}
			
		} catch (SQLException error) {
			error.printStackTrace();
		}	
		
		ClientesTB pegaval = new ClientesTB(ClientesX);
		table.setModel(pegaval);
		
	}
	
}
