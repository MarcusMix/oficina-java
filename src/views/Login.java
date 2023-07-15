package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.UserController;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField inputUsuario;
	private JPasswordField inputSenha;
	static String QUERY = null;

	public static void main(String[] args, boolean logado) {
		try {
			Login dialog = new Login();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setBounds(100, 100, 395, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Login");
		setModal(true);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblUsuario.setBounds(0, 116, 379, 20);
		contentPanel.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblSenha.setBounds(0, 173, 379, 25);
		contentPanel.add(lblSenha);
		
		inputUsuario = new JTextField();
		inputUsuario.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputUsuario.setBounds(87, 136, 202, 25);
		contentPanel.add(inputUsuario);
		inputUsuario.setColumns(10);
		
		inputSenha = new JPasswordField();
		inputSenha.setBounds(87, 199, 202, 25);
		contentPanel.add(inputSenha);
		
		JLabel title = new JLabel("Faça login no sistema");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
		title.setBounds(0, 11, 379, 30);
		contentPanel.add(title);
		
		JLabel imageIcon = new JLabel("");
		imageIcon.setHorizontalAlignment(SwingConstants.CENTER);
		imageIcon.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\user-login.png"));
		imageIcon.setBounds(0, 52, 379, 53);
		contentPanel.add(imageIcon);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEntrar = new JButton("Entrar");
				btnEntrar.setFont(new Font("Poppins", Font.PLAIN, 11));
				btnEntrar.setSelectedIcon(null);
				btnEntrar.setBackground(new Color(255, 255, 255));
				btnEntrar.setIcon(null);
				btnEntrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						if(UserController.handleLoginUser(inputSenha, inputUsuario)) {
							Login.this.dispose();
						} else {
							return;
						}
					}
				});
				btnEntrar.setActionCommand("OK");
				buttonPane.add(btnEntrar);
				getRootPane().setDefaultButton(btnEntrar);
			}
			{
				JButton btnSair = new JButton("Sair");
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnSair.setBackground(new Color(255, 255, 255));
				btnSair.setFont(new Font("Poppins", Font.PLAIN, 11));
				btnSair.setIcon(null);;
				btnSair.setActionCommand("Cancel");
				buttonPane.add(btnSair);
			}
		}
	}
}
