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
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\user-icon.png"));
		lblNewLabel.setBounds(0, 37, 430, 70);
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
					}
				});
				okButton.setFont(new Font("Poppins", Font.PLAIN, 11));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Poppins", Font.PLAIN, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
