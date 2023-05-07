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

import views.MessageError;
import views.MessageSucess;

public class ClientEachModel {
	private String nome;
	private String rg;
	private String cpf;
	private String email;
	private String cidade;
	private String nascimento;
	
	static final String DB_NAME = "ordemservico";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	static final String USER = "root";
	static final String PASS = "admin";
	static String QUERY = null;
	
	static List<ClientEachModel> ClientesX = new ArrayList<ClientEachModel>();
	static ClientsEachTB pegador = new ClientsEachTB(ClientesX);
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public static void grabClients(JTable table) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String QUERY = "SELECT * FROM clientes";
		
		String nome, cpf, email, rg, cidade, nascimento = null;
		
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
				rg = rs.getString("rg");
				cidade = rs.getString("cidade");
				nascimento = rs.getString("nascimento");
					
				ClientEachModel clientes = new ClientEachModel();
				clientes.setNome(nome);
				clientes.setCpf(cpf);;
				clientes.setEmail(email);
				clientes.setRg(rg);
				clientes.setCidade(cidade);
				clientes.setNascimento(nascimento);
				
				ClientesX.add(clientes);
			}
			
		} catch (SQLException error) {
			error.printStackTrace();
		}	
		
		ClientsEachTB pegaval = new ClientsEachTB(ClientesX);
		table.setModel(pegaval);
		
	}
	public static void deleteClients(String QUERY, JTextField inputNome, JTextField inputCPF) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rs;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.prepareStatement(QUERY);
			rs = stmt.executeUpdate(QUERY);
			
			if(rs == 0) {
				MessageError.handleWindowMessage("Erro ao excluir!");
				return;
			} else {
				MessageSucess.handleWindowMessageSucess("Excluído com sucesso!");
				return;
			}
			
		} catch (SQLException error) {
			System.out.println("Erro ao excluir cliente: " + error.getMessage());
		}
		
	}
	
	public static void searchEachClient(String QUERY, JTextField inputNome, JTextField inputCPF, JTable table) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String nome, cpf, rg, nascimento, email, cidade = null;
		
		ClientesX.clear();
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.prepareStatement(QUERY);
			rs = stmt.executeQuery(QUERY);
			
			while(rs.next()) {
				nome = rs.getString("nome");
				cpf = rs.getString("cpf");
				rg = rs.getString("rg");
				nascimento = rs.getString("nascimento");
				email = rs.getString("email");
				cidade = rs.getString("cidade");

				ClientEachModel clientes = new ClientEachModel();
				clientes.setNome(nome);
				clientes.setCpf(cpf);;
				clientes.setEmail(email);
				clientes.setRg(rg);
				clientes.setCidade(cidade);
				clientes.setNascimento(nascimento);
				
				ClientesX.add(clientes);
							
			}
			
		} catch (SQLException error) {
			System.out.println(error);
		}
		
		ClientsEachTB pegaval = new ClientsEachTB(ClientesX);
		table.setModel(pegaval);
		
	}
}
