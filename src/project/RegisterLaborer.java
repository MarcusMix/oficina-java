package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;

public class RegisterLaborer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField inputNome;
	private JTextField inputRG;
	private JTextField inputCPF;
	private JTextField inputNascimento;
	private JTextField inputEmail;
	private JTextField inputTelefone1;
	private JTextField inputTelefone2;
	private JTextField inputEstado;
	private JTextField inputCidade;
	private JTextField inputRua;
	private JTextField inputBairro;
	private JTextField inputCEP;
	private JTextField inputDataAdmissao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterLaborer dialog = new RegisterLaborer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//message
		public void handleWindowMessage(String text) {
			Message message = new Message(text);
			message.setLocationRelativeTo(null);
			message.setVisible(true);
		}
		
		public void handleWindowMessageSucess(String text) {
			MessageSucess message = new MessageSucess(text);
			message.setLocationRelativeTo(null);
			message.setVisible(true);
		}

	/**
	 * Create the dialog.RegisterClient
	 */
	public RegisterLaborer() {
		setBounds(100, 100, 585, 726);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Cadastrar novo profissional");
		setLocationRelativeTo(null);
		
		
		{
			JLabel lblNewUser = new JLabel("Cadastrar profissional");
			lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewUser.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
			lblNewUser.setBounds(0, 0, 561, 51);
			contentPanel.add(lblNewUser);
		}
		
		JLabel lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCompleto.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNomeCompleto.setBounds(40, 106, 488, 22);
		contentPanel.add(lblNomeCompleto);
		
		inputNome = new JTextField();
		inputNome.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputNome.setBounds(40, 127, 488, 25);
		contentPanel.add(inputNome);
		inputNome.setColumns(10);
		
		JLabel lblRG = new JLabel("RG");
		lblRG.setHorizontalAlignment(SwingConstants.CENTER);
		lblRG.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblRG.setBounds(40, 163, 226, 22);
		contentPanel.add(lblRG);
		
		inputRG = new JTextField();
		inputRG.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputRG.setColumns(10);
		inputRG.setBounds(40, 184, 226, 25);
		contentPanel.add(inputRG);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblCPF.setBounds(302, 163, 226, 22);
		contentPanel.add(lblCPF);
		
		inputCPF = new JTextField();
		inputCPF.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCPF.setColumns(10);
		inputCPF.setBounds(302, 184, 226, 25);
		contentPanel.add(inputCPF);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\pro-color.png"));
		lblNewLabel.setBounds(0, 37, 561, 70);
		contentPanel.add(lblNewLabel);
		
		inputNascimento = new JTextField();
		inputNascimento.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputNascimento.setColumns(10);
		inputNascimento.setBounds(40, 239, 226, 25);
		contentPanel.add(inputNascimento);
		
		JLabel lblNascimento = new JLabel("Data de nascimento");
		lblNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNascimento.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNascimento.setBounds(40, 218, 226, 22);
		contentPanel.add(lblNascimento);
		
		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputEmail.setColumns(10);
		inputEmail.setBounds(302, 239, 226, 25);
		contentPanel.add(inputEmail);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblEmail.setBounds(302, 218, 226, 22);
		contentPanel.add(lblEmail);
		
		JLabel lblTel1 = new JLabel("Telefone 1");
		lblTel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTel1.setBounds(40, 275, 226, 22);
		contentPanel.add(lblTel1);
		
		inputTelefone1 = new JTextField();
		inputTelefone1.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputTelefone1.setColumns(10);
		inputTelefone1.setBounds(40, 296, 226, 25);
		contentPanel.add(inputTelefone1);
		
		inputTelefone2 = new JTextField();
		inputTelefone2.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputTelefone2.setColumns(10);
		inputTelefone2.setBounds(302, 296, 226, 25);
		contentPanel.add(inputTelefone2);
		
		JLabel lblTel2 = new JLabel("Telefone 2");
		lblTel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTel2.setBounds(302, 275, 226, 22);
		contentPanel.add(lblTel2);
		
		inputEstado = new JTextField();
		inputEstado.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputEstado.setColumns(10);
		inputEstado.setBounds(40, 353, 226, 25);
		contentPanel.add(inputEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblEstado.setBounds(40, 332, 226, 22);
		contentPanel.add(lblEstado);
		
		inputCidade = new JTextField();
		inputCidade.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCidade.setColumns(10);
		inputCidade.setBounds(302, 353, 226, 25);
		contentPanel.add(inputCidade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblCidade.setBounds(302, 332, 226, 22);
		contentPanel.add(lblCidade);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setHorizontalAlignment(SwingConstants.CENTER);
		lblRua.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblRua.setBounds(40, 389, 488, 22);
		contentPanel.add(lblRua);
		
		inputRua = new JTextField();
		inputRua.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputRua.setColumns(10);
		inputRua.setBounds(40, 410, 488, 25);
		contentPanel.add(inputRua);
		
		inputBairro = new JTextField();
		inputBairro.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputBairro.setColumns(10);
		inputBairro.setBounds(40, 467, 226, 25);
		contentPanel.add(inputBairro);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBairro.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblBairro.setBounds(40, 446, 226, 22);
		contentPanel.add(lblBairro);
		
		JLabel lvlCEP = new JLabel("CEP");
		lvlCEP.setHorizontalAlignment(SwingConstants.CENTER);
		lvlCEP.setFont(new Font("Poppins", Font.PLAIN, 14));
		lvlCEP.setBounds(302, 446, 226, 22);
		contentPanel.add(lvlCEP);
		
		inputCEP = new JTextField();
		inputCEP.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCEP.setColumns(10);
		inputCEP.setBounds(302, 467, 226, 25);
		contentPanel.add(inputCEP);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblCargo.setBounds(40, 503, 226, 22);
		contentPanel.add(lblCargo);
		
		String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
		JComboBox comboBoxCargo = new JComboBox(opcoes);
		comboBoxCargo.setFont(new Font("Poppins", Font.PLAIN, 11));
		comboBoxCargo.setBounds(40, 525, 226, 22);
		contentPanel.add(comboBoxCargo);
		
		JLabel lblDataDeAdmisso = new JLabel("Data de admissão");
		lblDataDeAdmisso.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDeAdmisso.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblDataDeAdmisso.setBounds(302, 503, 226, 22);
		contentPanel.add(lblDataDeAdmisso);
		
		inputDataAdmissao = new JTextField();
		inputDataAdmissao.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputDataAdmissao.setColumns(10);
		inputDataAdmissao.setBounds(302, 526, 226, 25);
		contentPanel.add(inputDataAdmissao);
		
		String[] funcoes = {"Opção 1", "Opção 2", "Opção 3"};
		JComboBox comboBoxFuncao = new JComboBox(funcoes);
		comboBoxFuncao.setFont(new Font("Poppins", Font.PLAIN, 11));
		comboBoxFuncao.setBounds(40, 580, 226, 22);
		contentPanel.add(comboBoxFuncao);
		
		JLabel lblFuno = new JLabel("Função");
		lblFuno.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuno.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblFuno.setBounds(40, 558, 226, 22);
		contentPanel.add(lblFuno);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cadastrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//querys
						String DB_NAME = "ordemservico";
						String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
						String USER = "root";
						String PASS = "admin";
						
						//registrar profissional
						String QUERY = "INSERT INTO profissionais (nome, rg, cpf, rua, bairro, cidade, estado, cep, email, fone1, fone2, cargo, nascimento, admissao, funcao) "
								+ "VALUES ('" + inputNome.getText() +"', '" + inputRG.getText() + "', '" + inputCPF.getText() +"', "
								+ "'" + inputRua.getText() + "', '" + inputBairro.getText() + "', '" + inputCidade.getText() + "'"
								+ ", '" + inputEstado.getText() + "', '" + inputCEP.getText() + "', '" + inputEmail.getText() + "'"
								+ ", '" + inputTelefone1.getText() + "', '" + inputTelefone2.getText() + "'"
								+ ", '" + comboBoxCargo.getSelectedItem() + "', '" + inputNascimento.getText() 
								+ "', '" + inputDataAdmissao.getText() + "', '" + comboBoxFuncao.getSelectedItem() + "' )";

									
						if(inputNome.getText().isBlank()) {
							handleWindowMessage("Nome em branco!");
							return;
						} else if (inputRG.getText().isBlank()) {
							handleWindowMessage("RG em branco!");
							return;
						} else if (inputCPF.getText().isBlank()) {
							handleWindowMessage("CPF em branco!");
							return;
						} else if (inputNascimento.getText().isBlank()) {
							handleWindowMessage("Data de Nascimento em branco!");
							return;
						} else if (inputEmail.getText().isBlank()) {
							handleWindowMessage("E-mail em branco!");
							return;
						} else if (inputTelefone1.getText().isBlank()) {
							handleWindowMessage("Telefone 1 em branco!");
							return;
						} else if (inputTelefone2.getText().isBlank()) {
							handleWindowMessage("Telefone2 em branco!");
							return;
						} else if (inputEstado.getText().isBlank()) {
							handleWindowMessage("Estado em branco!");
							return;
						} else if (inputCidade.getText().isBlank()) {
							handleWindowMessage("Cidade em branco!");
							return;
						} else if (inputRua.getText().isBlank()) {
							handleWindowMessage("Rua em branco!");
							return;
						} else if (inputBairro.getText().isBlank()) {
							handleWindowMessage("Bairro em branco!");
							return;
						} else if (inputCEP.getText().isBlank()) {
							handleWindowMessage("CEP em branco!");
							return;
						} 
						//arrumar
//						else if (comboBoxCargo) {
//							handleWindowMessage("Observação em branco!");
//							return;
//						}

						//criar conexao
						try {
							Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
							PreparedStatement stmt =  conn.prepareStatement(QUERY);

							int result = stmt.executeUpdate(QUERY);

						    if(result == 0) {
						    	handleWindowMessage("Erro cadastrar cliente!");
						    } else {
						    	handleWindowMessageSucess("Cliente cadastrado com sucesso!");
						    	inputCPF.setText("");
						    	inputRG.setText("");
						    	inputNome.setText("");
						    	inputRG.setText("");
						    	inputEmail.setText("");
						    	inputNascimento.setText("");
//						    	inputOBS.setText("");
						    	inputTelefone1.setText("");
						    	inputTelefone2.setText("");
						    	inputEstado.setText("");
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
				);
				okButton.setFont(new Font("Poppins", Font.PLAIN, 11));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnVoltar = new JButton("Voltar");
				btnVoltar.setFont(new Font("Poppins", Font.PLAIN, 11));
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnVoltar.setActionCommand("Cancel");
				buttonPane.add(btnVoltar);
			}
		}
	}
}
