package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controllers.ClientsController;
import models.ClientModel;
import models.ClientesTB;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class ReportClients extends JDialog {
	
	static final String DB_NAME = "ordemservico";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	static final String USER = "root";
	static final String PASS = "admin";
	static String QUERY = null;
	
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	
	static List<ClientModel> ClientesX = new ArrayList<ClientModel>();
	static ClientesTB pegador = new ClientesTB(ClientesX);
	private JTextField inputPesquisar;
	

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
		setBounds(100, 100, 697, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		{
			JLabel lblRelatorioDeClientes = new JLabel("Relatorio de Clientes");
			lblRelatorioDeClientes.setBounds(0, 0, 681, 51);
			lblRelatorioDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
			lblRelatorioDeClientes.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
			contentPanel.add(lblRelatorioDeClientes);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(46, 95, 590, 141);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "E-mail ", "Telefone-1", "Cidade", "Estado"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMinWidth(8);
		table.setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPane.setColumnHeaderView(table);
		
		inputPesquisar = new JTextField();
		inputPesquisar.setFont(new Font("Poppins", Font.PLAIN, 11));
		inputPesquisar.setBounds(219, 52, 237, 23);
		contentPanel.add(inputPesquisar);
		inputPesquisar.setColumns(10);
		
		ClientsController.handleDataClients(table);
		
		JButton btnPesquisar = new JButton();
		btnPesquisar.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\search-icon_resized.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QUERY = "SELECT * FROM clientes WHERE nome = '" + inputPesquisar.getText() + "'";
				
				ClientsController.handleSearchClient(QUERY, inputPesquisar, table);				
			}
		});
		btnPesquisar.setActionCommand("OK");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPesquisar.setBounds(466, 52, 30, 23);
		contentPanel.add(btnPesquisar);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}

	}
}


