package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;

public class ReportClients extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ReportClients dialog = new ReportClients();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ReportClients() {
		setBounds(100, 100, 521, 495);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JTextPane labelDataClients = new JTextPane();
		labelDataClients.setEditable(false);
		labelDataClients.setFont(new Font("Arial", Font.BOLD, 12));
		labelDataClients.setBounds(51, 95, 413, 189);
		contentPanel.add(labelDataClients);
		
		String resultados = "";
		
		
				//querys
				String DB_NAME = "ordemservico";
				String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
				String USER = "root";
				String PASS = "admin";
			    try (Connection conexao = DriverManager.getConnection(DB_URL, USER, PASS)) {
			    	
			      String sql = "SELECT * FROM clientes";
			      
			      Statement comando = conexao.createStatement();
			      ResultSet resultado = comando.executeQuery(sql);
			      int i = 1;
			      
			      while (resultado.next()) {
			    	  String nome = resultado.getString("nome").toUpperCase();
			    	  String cpf = resultado.getString("cpf").toUpperCase();
			    	  String email = resultado.getString("email").toUpperCase();
			    	  resultados +=  (i++) +"- " + nome + " " + cpf + " " + email + "\n\n";
			    	  labelDataClients.setText(resultados);
//			    	  System.out.println(nome + cpf + email);
			      }
			    } catch (SQLException e) {
			      System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
			    }
		
		{
			JLabel lblRelatorioDeClientes = new JLabel("Relatorio de Clientes");
			lblRelatorioDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
			lblRelatorioDeClientes.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
			lblRelatorioDeClientes.setBounds(10, 11, 485, 51);
			contentPanel.add(lblRelatorioDeClientes);
		}

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("OK");
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
//		{
//			JButton cancelButton = new JButton("Cancel");
//			cancelButton.setActionCommand("Cancel");
//			buttonPane.add(cancelButton);
//		}

	}
}
