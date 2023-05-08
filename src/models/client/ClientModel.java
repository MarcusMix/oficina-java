package models.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import views.message.MessageError;
import views.message.MessageSucess;

public class ClientModel {
	private String nome;
	private String cpf;
	private String email;
	private String fone1;
	private String cidade;
	private String estado;
	private String edit;
	
	static List<ClientModel> ClientesX = new ArrayList<ClientModel>();
	static ClientesTB pegador = new ClientesTB(ClientesX);
	
	static final String DB_NAME = "ordemservico";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	static final String USER = "root";
	static final String PASS = "admin";
	static String QUERY = null;
	
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
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
	public static void registerClient(String QUERY, JTextField inputNome, JTextField inputRG, JTextField inputCPF, JTextField inputRua, JTextField inputBairro, JTextField inputCidade, JComboBox comboBoxEstado, JTextField inputCEP, JTextField inputEmail, JTextField inputTelefone1, JTextField inputTelefone2, JTextArea inputOBS, JTextField inputNascimento) {
		
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
		} else if (inputOBS.getText().isBlank()) {
			MessageError.handleWindowMessage("Observação em branco!");
			return;
		}

		//criar conexao
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement stmt =  conn.prepareStatement(QUERY);

			int result = stmt.executeUpdate(QUERY);

		    if(result == 0) {
		    	MessageError.handleWindowMessage("Erro cadastrar cliente!");
		    } else {
		    	MessageSucess.handleWindowMessageSucess("Cliente cadastrado com sucesso!");
		    	inputCPF.setText("");
		    	inputRG.setText("");
		    	inputNome.setText("");
		    	inputRG.setText("");
		    	inputEmail.setText("");
		    	inputNascimento.setText("");
		    	inputOBS.setText("");
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
