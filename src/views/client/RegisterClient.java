package views.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controllers.ClientsController;
import models.client.ClientesTB;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegisterClient extends JDialog {

	private JTextField inputNome;
	private JTextField inputRG;
	private JTextField inputCPF;
	private JTextField inputNascimento;
	private JTextField inputEmail;
	private JTextField inputTelefone1;
	private JTextField inputTelefone2;
	private JTextField inputCidade;
	private JTextField inputRua;
	private JTextField inputBairro;
	private JTextField inputCEP;

	static String QUERY = null;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNascimento;
	private static JTable table;

	public static void main(String[] args) {
		try {
			RegisterClient dialog = new RegisterClient();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public RegisterClient() {
		setBounds(100, 100, 944, 814);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Cadastrar novo cliente");
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\client-color.png"));
		lblNewLabel.setBounds(0, 37, 561, 70);
		contentPanel.add(lblNewLabel);


		JLabel title = new JLabel("Cadastrar cliente");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
		title.setBounds(0, 0, 561, 51);
		contentPanel.add(title);

		JLabel lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCompleto.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNomeCompleto.setBounds(21, 106, 378, 22);
		contentPanel.add(lblNomeCompleto);

		inputNome = new JTextField();
		inputNome.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputNome.setBounds(21, 127, 378, 25);
		contentPanel.add(inputNome);
		inputNome.setColumns(10);

		JLabel lblRG = new JLabel("RG");
		lblRG.setHorizontalAlignment(SwingConstants.CENTER);
		lblRG.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblRG.setBounds(426, 106, 226, 22);
		contentPanel.add(lblRG);

		inputRG = new JTextField();
		inputRG.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputRG.setColumns(10);
		inputRG.setBounds(426, 127, 226, 25);
		contentPanel.add(inputRG);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblCPF.setBounds(680, 106, 226, 22);
		contentPanel.add(lblCPF);

		//cpf
		try {
			inputCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		inputCPF.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCPF.setColumns(10);
		inputCPF.setBounds(680, 127, 226, 25);
		contentPanel.add(inputCPF);


		inputNascimento = new JTextField();
		inputNascimento.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputNascimento.setColumns(10);
		inputNascimento.setBounds(110, 184, 226, 25);
		contentPanel.add(inputNascimento);

		lblNascimento = new JLabel("Data de nascimento");
		lblNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNascimento.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNascimento.setBounds(110, 163, 226, 22);
		contentPanel.add(lblNascimento);

		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputEmail.setColumns(10);
		inputEmail.setBounds(426, 184, 226, 25);
		contentPanel.add(inputEmail);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblEmail.setBounds(426, 163, 226, 22);
		contentPanel.add(lblEmail);

		//telefone 1
		JLabel lblTel1 = new JLabel("Telefone 1");
		lblTel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTel1.setBounds(680, 163, 226, 22);
		contentPanel.add(lblTel1);

		try {
			inputTelefone1 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		inputTelefone1.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputTelefone1.setColumns(10);
		inputTelefone1.setBounds(680, 184, 226, 25);
		contentPanel.add(inputTelefone1);

		//telefone 2
		try {
			inputTelefone2 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		inputTelefone2.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputTelefone2.setColumns(10);
		inputTelefone2.setBounds(110, 235, 226, 25);
		contentPanel.add(inputTelefone2);

		JLabel lblTel2 = new JLabel("Telefone 2");
		lblTel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTel2.setBounds(110, 214, 226, 22);
		contentPanel.add(lblTel2);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblEstado.setBounds(426, 214, 226, 22);
		contentPanel.add(lblEstado);

		String[] estados = {
				"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", 
				"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
				"Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", 
				"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
		};

		JComboBox comboBoxEstado = new JComboBox(estados);
		comboBoxEstado.setSelectedIndex(23);
		comboBoxEstado.setFont(new Font("Poppins", Font.PLAIN, 11));
		comboBoxEstado.setBounds(426, 237, 226, 22);
		contentPanel.add(comboBoxEstado);

		inputCidade = new JTextField();
		inputCidade.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCidade.setColumns(10);
		inputCidade.setBounds(680, 235, 226, 25);
		contentPanel.add(inputCidade);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblCidade.setBounds(680, 214, 226, 22);
		contentPanel.add(lblCidade);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setHorizontalAlignment(SwingConstants.CENTER);
		lblRua.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblRua.setBounds(21, 266, 378, 22);
		contentPanel.add(lblRua);

		inputRua = new JTextField();
		inputRua.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputRua.setColumns(10);
		inputRua.setBounds(21, 287, 378, 25);
		contentPanel.add(inputRua);

		inputBairro = new JTextField();
		inputBairro.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputBairro.setColumns(10);
		inputBairro.setBounds(426, 287, 226, 25);
		contentPanel.add(inputBairro);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBairro.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblBairro.setBounds(426, 266, 226, 22);
		contentPanel.add(lblBairro);

		//tabela config 
//		ClientesTB Modelo;
		DefaultTableModel tableModel = new DefaultTableModel();
//		Modelo = new ClientesTB(null);

		tableModel.addColumn("Nome");
		tableModel.addColumn("CPF");
		tableModel.addColumn("Email");
		tableModel.addColumn("Telefone");
		tableModel.addColumn("Cidade");
		tableModel.addColumn("Estado");
		table = new JTable(tableModel);
		table.setFont(new Font("Poppins", Font.PLAIN, 12));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(21, 478, 885, 189);
		contentPanel.add(scrollPane);

		ClientsController.grabClientsInDb(table);


		JLabel lvlCEP = new JLabel("CEP");
		lvlCEP.setHorizontalAlignment(SwingConstants.CENTER);
		lvlCEP.setFont(new Font("Poppins", Font.PLAIN, 14));
		lvlCEP.setBounds(680, 266, 226, 22);
		contentPanel.add(lvlCEP);

		try {
			inputCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		inputCEP.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCEP.setColumns(10);
		inputCEP.setBounds(680, 287, 226, 25);
		contentPanel.add(inputCEP);

		JTextArea inputOBS = new JTextArea();
		inputOBS.setFont(new Font("Poppins", Font.PLAIN, 13));
		inputOBS.setLineWrap(true);
		inputOBS.setWrapStyleWord(true);
		inputOBS.setBounds(21, 345, 488, 82);
		contentPanel.add(inputOBS);

		JLabel lblOBS = new JLabel("Observações");
		lblOBS.setHorizontalAlignment(SwingConstants.CENTER);
		lblOBS.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblOBS.setBounds(21, 323, 488, 22);
		contentPanel.add(lblOBS);

		JPanel panel = new JPanel();
		panel.setBounds(0, 729, 915, 35);
		contentPanel.add(panel);


		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//registrar usuário
				QUERY = "INSERT INTO clientes (nome, rg, cpf, rua, bairro, cidade, estado, cep, email, fone1, fone2, obs, nascimento) "
						+ "VALUES ('" 
						+ inputNome.getText() +"', '" 
						+ inputRG.getText() + "', '" 
						+ inputCPF.getText() +"', "+ "'" 
						+ inputRua.getText() + "', '" 
						+ inputBairro.getText() + "', '" 
						+ inputCidade.getText() + "'"+ ", '" 
						+ comboBoxEstado.getSelectedItem() + "', '" 
						+ inputCEP.getText() + "', '" 
						+ inputEmail.getText() + "'"+ ", '" 
						+ inputTelefone1.getText() + "', '" 
						+ inputTelefone2.getText() + "'"+ ", '" 
						+ inputOBS.getText() + "', '" 
						+ inputNascimento.getText() + "' )";


				ClientsController.handleRegisterClient(
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
						inputNascimento);

			}
			Object [] dados = {
					inputNome.getText(), 
					inputRG.getText(), 
					inputCPF.getText(), 
					inputRua.getText(), 
					inputBairro.getText(), 
					inputCidade.getText(), 
					comboBoxEstado.getSelectedItem(), 
					inputCEP.getText(), 
					inputEmail.getText(), 
					inputTelefone1.getText(), 
					inputTelefone2.getText(), 
					inputOBS.getSelectedText(), 
					inputNascimento.getText()
			};
			
			
		});
		btnCadastrar.setFont(new Font("Poppins", Font.PLAIN, 11));
		btnCadastrar.setActionCommand("OK");
		panel.add(btnCadastrar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		});
		btnNovo.setFont(new Font("Poppins", Font.PLAIN, 11));
		panel.add(btnNovo);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QUERY = "SELECT * FROM clientes WHERE nome = '" + inputNome.getText() + "' OR cpf = '" + inputCPF.getText() + "'";

				ClientsController.handleSearchEachClient(QUERY, inputNome, inputCPF, table);		
			}
		});
		btnPesquisar.setFont(new Font("Poppins", Font.PLAIN, 11));
		panel.add(btnPesquisar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QUERY = "DELETE FROM clientes WHERE nome = '" + inputNome.getText() + "' OR cpf = '" + inputCPF.getText() + "'";

				ClientsController.handleDeleteClient(QUERY, inputNome, inputCPF);
			}
		});
		btnEliminar.setFont(new Font("Poppins", Font.PLAIN, 11));
		panel.add(btnEliminar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Poppins", Font.PLAIN, 11));
		btnVoltar.setActionCommand("Cancel");
		panel.add(btnVoltar);

	}
}
