package models;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;


public class TabelaClientes extends JDialog {
	static final String DB_NAME = "ordemservico";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	static final String USER = "root";
	static final String PASS = "admin";
	static String QUERY = null;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	static List<ClienteModel> ClientesX = new ArrayList<ClienteModel>();
	static ClientesTB pegador = new ClientesTB(ClientesX);

	
	public static void main(String[] args) {
		try {
			TabelaClientes dialog = new TabelaClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public TabelaClientes() {
		setBounds(100, 100, 929, 462);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 56, 866, 198);
		contentPanel.add(scrollPane);
	
		table = new JTable();
		table.setBorder(null);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Poppins", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "RG", "CPF", "E-mail ", "Telefone-1"
			}
		));
		scrollPane.setColumnHeaderView(table);
		
		JButton btnAbastecer = new JButton("Abastecer");
		btnAbastecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				QUERY = "SELECT * FROM CLIENTES";
				
				String id, nome, cpf, rg,  email, tel1 = null;
				
				ClientesX.clear();

				try {
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					pstmt =  conn.prepareStatement(QUERY);
					rs = pstmt.executeQuery(QUERY);
					
					ClientesX.clear();
					while(rs.next()) {
						id = rs.getString("id");
						nome = rs.getString("nome");
						rg = rs.getString("rg");
						cpf = rs.getString("cpf");
						email = rs.getString("email");
						tel1 = rs.getString("fone1");
							
						ClienteModel clientes = new ClienteModel();
						clientes.setId(id);
						clientes.setNome(nome);
						clientes.setRg(rg);
						clientes.setCpf(cpf);;
						clientes.setEmail(email);
						clientes.setFone1(tel1);
						
						ClientesX.add(clientes);
					}
					
				} catch (SQLException error) {
					error.printStackTrace();
				}	
				
				ClientesTB pegaval = new ClientesTB(ClientesX);
				table.setModel(pegaval);
			}
		});
			
		btnAbastecer.setBounds(161, 265, 113, 23);
		contentPanel.add(btnAbastecer);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
		lblNewLabel.setBounds(61, 11, 134, 34);
		contentPanel.add(lblNewLabel);
		
	} 
}

