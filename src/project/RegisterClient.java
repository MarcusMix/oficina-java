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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class RegisterClient extends JDialog {

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
	private JTextField textField;
	private JTextField inputCEP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterClient dialog = new RegisterClient();
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
	public RegisterClient() {
		setBounds(100, 100, 732, 726);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Cadastrar novo usuário");
		setLocationRelativeTo(null);
		
		
		{
			JLabel lblNewUser = new JLabel("Cadastrar cliente");
			lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewUser.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
			lblNewUser.setBounds(0, 0, 716, 51);
			contentPanel.add(lblNewUser);
		}
		
		JLabel lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCompleto.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNomeCompleto.setBounds(116, 107, 488, 22);
		contentPanel.add(lblNomeCompleto);
		
		inputNome = new JTextField();
		inputNome.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputNome.setBounds(116, 128, 488, 25);
		contentPanel.add(inputNome);
		inputNome.setColumns(10);
		
		JLabel lblRG = new JLabel("RG");
		lblRG.setHorizontalAlignment(SwingConstants.CENTER);
		lblRG.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblRG.setBounds(116, 164, 226, 22);
		contentPanel.add(lblRG);
		
		inputRG = new JTextField();
		inputRG.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputRG.setColumns(10);
		inputRG.setBounds(116, 185, 226, 25);
		contentPanel.add(inputRG);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblCPF.setBounds(378, 164, 226, 22);
		contentPanel.add(lblCPF);
		
		inputCPF = new JTextField();
		inputCPF.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCPF.setColumns(10);
		inputCPF.setBounds(378, 185, 226, 25);
		contentPanel.add(inputCPF);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\user-icon.png"));
		lblNewLabel.setBounds(0, 37, 716, 70);
		contentPanel.add(lblNewLabel);
		
		inputNascimento = new JTextField();
		inputNascimento.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputNascimento.setColumns(10);
		inputNascimento.setBounds(116, 240, 226, 25);
		contentPanel.add(inputNascimento);
		
		JLabel lblNascimento = new JLabel("Data de nascimento");
		lblNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNascimento.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNascimento.setBounds(116, 219, 226, 22);
		contentPanel.add(lblNascimento);
		
		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputEmail.setColumns(10);
		inputEmail.setBounds(378, 240, 226, 25);
		contentPanel.add(inputEmail);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblEmail.setBounds(378, 219, 226, 22);
		contentPanel.add(lblEmail);
		
		JLabel lblTel1 = new JLabel("Telefone 1");
		lblTel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTel1.setBounds(116, 276, 226, 22);
		contentPanel.add(lblTel1);
		
		inputTelefone1 = new JTextField();
		inputTelefone1.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputTelefone1.setColumns(10);
		inputTelefone1.setBounds(116, 297, 226, 25);
		contentPanel.add(inputTelefone1);
		
		inputTelefone2 = new JTextField();
		inputTelefone2.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputTelefone2.setColumns(10);
		inputTelefone2.setBounds(378, 297, 226, 25);
		contentPanel.add(inputTelefone2);
		
		JLabel lblTel2 = new JLabel("Telefone 2");
		lblTel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTel2.setBounds(378, 276, 226, 22);
		contentPanel.add(lblTel2);
		
		inputEstado = new JTextField();
		inputEstado.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputEstado.setColumns(10);
		inputEstado.setBounds(116, 354, 226, 25);
		contentPanel.add(inputEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblEstado.setBounds(116, 333, 226, 22);
		contentPanel.add(lblEstado);
		
		inputCidade = new JTextField();
		inputCidade.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCidade.setColumns(10);
		inputCidade.setBounds(378, 354, 226, 25);
		contentPanel.add(inputCidade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblCidade.setBounds(378, 333, 226, 22);
		contentPanel.add(lblCidade);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setHorizontalAlignment(SwingConstants.CENTER);
		lblRua.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblRua.setBounds(116, 390, 488, 22);
		contentPanel.add(lblRua);
		
		inputRua = new JTextField();
		inputRua.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputRua.setColumns(10);
		inputRua.setBounds(116, 411, 488, 25);
		contentPanel.add(inputRua);
		
		textField = new JTextField();
		textField.setFont(new Font("Poppins", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(116, 468, 226, 25);
		contentPanel.add(textField);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBairro.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblBairro.setBounds(116, 447, 226, 22);
		contentPanel.add(lblBairro);
		
		JLabel lvlCEP = new JLabel("CEP");
		lvlCEP.setHorizontalAlignment(SwingConstants.CENTER);
		lvlCEP.setFont(new Font("Poppins", Font.PLAIN, 14));
		lvlCEP.setBounds(378, 447, 226, 22);
		contentPanel.add(lvlCEP);
		
		inputCEP = new JTextField();
		inputCEP.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCEP.setColumns(10);
		inputCEP.setBounds(378, 468, 226, 25);
		contentPanel.add(inputCEP);
		
		JTextArea inputOBS = new JTextArea();
		inputOBS.setLineWrap(true);
		inputOBS.setWrapStyleWord(true);
		inputOBS.setBounds(116, 536, 488, 82);
		contentPanel.add(inputOBS);
		
		JLabel lblOBS = new JLabel("Observações");
		lblOBS.setHorizontalAlignment(SwingConstants.CENTER);
		lblOBS.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblOBS.setBounds(116, 513, 488, 22);
		contentPanel.add(lblOBS);
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
						
						//registrar usuário
						String QUERY = "INSERT INTO usuarios (nome, usuario, senha) "
								+ "VALUES ('" + inputNome.getText() +"', '" + inputRG.getText() + "', '" + inputCPF.getText() +"')";
									
						if(inputNome.getText().isBlank()) {
							handleWindowMessage("Nome em branco!");
							return;
						} else if (inputRG.getText().isBlank()) {
							handleWindowMessage("Usuário em branco!");
							return;
						} else if (inputCPF.getText().isBlank()) {
							handleWindowMessage("Senha em branco!");
							return;
						}

						//criar conexao
						try {
							Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
							PreparedStatement stmt =  conn.prepareStatement(QUERY);

							int result = stmt.executeUpdate(QUERY);

						    if(result == 0) {
						    	handleWindowMessage("Erro ao criar conta!");
						    } else {
						    	handleWindowMessageSucess("Conta criada com sucesso!");
						    	inputCPF.setText("");
						    	inputRG.setText("");
						    	inputNome.setText("");
						    }
							

						} catch (SQLException erro) {
							erro.printStackTrace();
						}
						
						//fechar conexao
//						try {
//						    if (conn != null) {
//						        conn.close();
//						    }
//						} catch (SQLException error) {
//						    System.out.println("Erro ao fechar a conexão com o banco de dados: " + error.getMessage());
//						}
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
