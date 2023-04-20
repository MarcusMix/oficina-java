package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField inputUsuario;
	private JPasswordField inputSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
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

	public Login() {
		setBounds(100, 100, 395, 268);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Login");
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblUsuario.setBounds(0, 52, 379, 20);
		contentPanel.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblSenha.setBounds(0, 118, 379, 25);
		contentPanel.add(lblSenha);
		
		inputUsuario = new JTextField();
		inputUsuario.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputUsuario.setBounds(87, 72, 202, 25);
		contentPanel.add(inputUsuario);
		inputUsuario.setColumns(10);
		
		inputSenha = new JPasswordField();
		inputSenha.setBounds(87, 144, 202, 25);
		contentPanel.add(inputSenha);
		
		JLabel lblNewLabel = new JLabel("Faça login no sistema");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 11, 379, 30);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Entrar");
				okButton.setFont(new Font("Poppins", Font.PLAIN, 11));
				okButton.setSelectedIcon(null);
				okButton.setBackground(new Color(102, 204, 51));
				okButton.setIcon(null);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String DB_NAME = "ordemservico";
						String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
						String USER = "root";
						String PASS = "admin";
						String QUERY = "SELECT * FROM usuarios WHERE usuario = '" 
						+ inputUsuario.getText() + "' AND senha = '" + inputSenha.getText() + "'";
						
						Connection conn = null;
						PreparedStatement stmt;
						ResultSet rs;
						
						String usuario = null;
						boolean usuarioBol;
						
						//criar conexao
						try {
							conn = DriverManager.getConnection(DB_URL, USER, PASS);
							stmt =  conn.prepareStatement(QUERY);
						    rs = stmt.executeQuery(QUERY);
//							System.out.println(QUERY);

							while (rs.next()) {
								 usuario = rs.getString("usuario");
								
								 //usuário existe
								 if(usuario.equals(inputUsuario.getText())) {
									 handleWindowMessageSucess("Bem-vindo de volta!");
										Login.this.dispose();
								 } 
							}
							//usuário não existe
							if(usuario == null) {
								handleWindowMessage("Usuário ou senha incorretos!");
							}

						} catch (SQLException erro) {
							erro.printStackTrace();
						}
						
						
						
						//fechar conexao
						try {
						    if (conn != null) {
						        conn.close();
						    }
						} catch (SQLException error) {
						    System.out.println("Erro ao fechar a conexão com o banco de dados: " + error.getMessage());
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnSair = new JButton("Sair");
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnSair.setBackground(new Color(204, 102, 102));
				btnSair.setFont(new Font("Poppins", Font.PLAIN, 11));
				btnSair.setIcon(null);
//				btnSair.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					}
//				});
				btnSair.setActionCommand("Cancel");
				buttonPane.add(btnSair);
			}
		}
	}
}
