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
	static final String DB_NAME = "ordemservico";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	static final String USER = "root";
	static final String PASS = "admin";
	static String QUERY = null;

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

	public RegisterUser() {
		setBounds(100, 100, 548, 364);
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
			lblNewUser.setBounds(0, 0, 532, 51);
			contentPanel.add(lblNewUser);
		}
		
		JLabel lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCompleto.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNomeCompleto.setBounds(0, 107, 532, 22);
		contentPanel.add(lblNomeCompleto);
		
		inputNome = new JTextField();
		inputNome.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputNome.setBounds(160, 128, 202, 25);
		contentPanel.add(inputNome);
		inputNome.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsurio.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblUsurio.setBounds(0, 164, 532, 22);
		contentPanel.add(lblUsurio);
		
		inputUser = new JTextField();
		inputUser.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputUser.setColumns(10);
		inputUser.setBounds(160, 184, 202, 25);
		contentPanel.add(inputUser);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblSenha.setBounds(0, 220, 522, 22);
		contentPanel.add(lblSenha);
		
		inputSenha = new JTextField();
		inputSenha.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputSenha.setColumns(10);
		inputSenha.setBounds(160, 243, 202, 25);
		contentPanel.add(inputSenha);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\user-color.png"));
		lblNewLabel.setBounds(10, 37, 522, 70);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 279, 532, 35);
		contentPanel.add(panel);
		
		JButton okButton = new JButton("Cadastrar");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//registrar usuário
				QUERY = "INSERT INTO usuarios (nome, usuario, senha) "
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
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				//criar conexao
				try {
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					pstmt =  conn.prepareStatement(QUERY);
//					arrumar depois
//					pstmt.setString(1, inputNome.getText());
//					pstmt.setString(2, inputUser.getText());
//					pstmt.setString(3, inputSenha.getText())
//					pstmt.close();
//					conn.close();

					int result = pstmt.executeUpdate(QUERY);

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
				try {
				    if (conn != null) {
				        conn.close();
				    }
				} catch (SQLException error) {
				    System.out.println("Erro ao fechar a conexão com o banco de dados: " + error.getMessage());
				}
			}
		});
		okButton.setFont(new Font("Poppins", Font.PLAIN, 11));
		okButton.setActionCommand("OK");
		panel.add(okButton);
		
		JButton btnNovo = new JButton("Novo");
		panel.add(btnNovo);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Poppins", Font.PLAIN, 11));
		btnVoltar.setActionCommand("Cancel");
		panel.add(btnVoltar);
	}
}
