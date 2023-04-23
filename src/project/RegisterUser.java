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

public class RegisterUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField inputNome;
	private JTextField inputUser;
	private JTextField inputSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterUser dialog = new RegisterUser();
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
	 * Create the dialog.
	 */
	public RegisterUser() {
		setBounds(100, 100, 452, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Cadastrar novo usuário");
		setLocationRelativeTo(null);
		
		
		{
			JLabel lblNewUser = new JLabel("Cadastrar usuário");
			lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewUser.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
			lblNewUser.setBounds(0, 0, 430, 51);
			contentPanel.add(lblNewUser);
		}
		
		JLabel lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCompleto.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNomeCompleto.setBounds(0, 107, 430, 22);
		contentPanel.add(lblNomeCompleto);
		
		inputNome = new JTextField();
		inputNome.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputNome.setBounds(116, 128, 202, 25);
		contentPanel.add(inputNome);
		inputNome.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsurio.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblUsurio.setBounds(0, 164, 430, 22);
		contentPanel.add(lblUsurio);
		
		inputUser = new JTextField();
		inputUser.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputUser.setColumns(10);
		inputUser.setBounds(116, 184, 202, 25);
		contentPanel.add(inputUser);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblSenha.setBounds(0, 220, 430, 22);
		contentPanel.add(lblSenha);
		
		inputSenha = new JTextField();
		inputSenha.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputSenha.setColumns(10);
		inputSenha.setBounds(116, 243, 202, 25);
		contentPanel.add(inputSenha);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\user-color.png"));
		lblNewLabel.setBounds(10, 37, 420, 70);
		contentPanel.add(lblNewLabel);
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
								+ "VALUES ('" + inputNome.getText() +"', '" + inputUser.getText() + "', '" + inputSenha.getText() +"')";
									
						if(inputNome.getText().isBlank()) {
							handleWindowMessage("Nome em branco!");
							return;
						} else if (inputUser.getText().isBlank()) {
							handleWindowMessage("Usuário em branco!");
							return;
						} else if (inputSenha.getText().isBlank()) {
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
						    	inputSenha.setText("");
						    	inputUser.setText("");
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
