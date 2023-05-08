package views.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.UserController;
import models.user.UserModel;

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
import javax.swing.JPasswordField;

public class UserView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField inputNome;
	private JTextField inputUser;
	private JPasswordField inputSenha;
	static String QUERY = null;

	public static void main(String[] args) {
		try {
			UserView dialog = new UserView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserView() {
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\user-color.png"));
		lblNewLabel.setBounds(10, 37, 522, 70);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 279, 532, 35);
		contentPanel.add(panel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 QUERY = "INSERT INTO usuarios (nome, usuario, senha) "
							+ "VALUES ('" + inputNome.getText() +"', '" + inputUser.getText() + "', '" + inputSenha.getText() +"')";
				
				UserController.handleDataLoginUser(QUERY, inputSenha, inputNome, inputUser);		
						
			}
		});
		btnCadastrar.setFont(new Font("Poppins", Font.PLAIN, 11));
		btnCadastrar.setActionCommand("OK");
		panel.add(btnCadastrar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputSenha.setText("");
		    	inputUser.setText("");
		    	inputNome.setText("");
			}
		});
		btnNovo.setFont(new Font("Poppins", Font.PLAIN, 11));
		panel.add(btnNovo);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QUERY = "SELECT * FROM usuarios  WHERE usuario = '" + inputUser.getText() + "' OR nome = '" + inputNome.getText() + "'";
			
				UserController.handleDataSearchUser(QUERY, inputSenha, inputNome, inputUser);	
			}
		});
		btnPesquisar.setFont(new Font("Poppins", Font.PLAIN, 11));
		panel.add(btnPesquisar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					QUERY = "DELETE FROM usuarios WHERE usuario = '" + inputUser.getText() + "' OR nome = '" + inputNome.getText() + "'";
					
					UserController.handleDataDeleteUser(QUERY, inputUser, inputNome, inputSenha);	
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
		
		inputSenha = new JPasswordField();
		inputSenha.setBounds(160, 242, 202, 25);
		contentPanel.add(inputSenha);
	}
}
