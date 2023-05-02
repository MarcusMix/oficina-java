package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
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

public class RegisterClient extends JDialog {

	private final JPanel contentPanel = new JPanel();
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
	static final String DB_NAME = "ordemservico";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
	static final String USER = "root";
	static final String PASS = "admin";
	static String QUERY = null;

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

	public RegisterClient() {
		setBounds(100, 100, 585, 814);
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
		
		
		{
			JLabel title = new JLabel("Cadastrar cliente");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
			title.setBounds(0, 0, 561, 51);
			contentPanel.add(title);
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
		
		//cpf
		try {
			inputCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
	    } catch (ParseException e) {
	      e.printStackTrace();
	    }
		
		inputCPF.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCPF.setColumns(10);
		inputCPF.setBounds(302, 184, 226, 25);
		contentPanel.add(inputCPF);
		
		
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
		
		//telefone 1
		JLabel lblTel1 = new JLabel("Telefone 1");
		lblTel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTel1.setBounds(40, 275, 226, 22);
		contentPanel.add(lblTel1);
	
		    try {
		    	inputTelefone1 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		    } catch (ParseException e) {
		      e.printStackTrace();
		    }
		    
	    inputTelefone1.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputTelefone1.setColumns(10);
		inputTelefone1.setBounds(40, 296, 226, 25);
		contentPanel.add(inputTelefone1);
		
		//telefone 2
		    try {
		    	inputTelefone2 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		    } catch (ParseException e) {
		      e.printStackTrace();
		    }
	    
		inputTelefone2.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputTelefone2.setColumns(10);
		inputTelefone2.setBounds(302, 296, 226, 25);
		contentPanel.add(inputTelefone2);
		
		JLabel lblTel2 = new JLabel("Telefone 2");
		lblTel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTel2.setBounds(302, 275, 226, 22);
		contentPanel.add(lblTel2);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblEstado.setBounds(40, 332, 226, 22);
		contentPanel.add(lblEstado);
		
		String[] estados = {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", 
				"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
				"Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", 
				"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};

		JComboBox comboBoxEstado = new JComboBox(estados);
		comboBoxEstado.setSelectedIndex(23);
		comboBoxEstado.setFont(new Font("Poppins", Font.PLAIN, 11));
		comboBoxEstado.setBounds(40, 355, 226, 22);
		contentPanel.add(comboBoxEstado);
		
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
		
		try {
			inputCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
	    } catch (ParseException e) {
	      e.printStackTrace();
	    }
		
		inputCEP.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputCEP.setColumns(10);
		inputCEP.setBounds(302, 467, 226, 25);
		contentPanel.add(inputCEP);
		
		JTextArea inputOBS = new JTextArea();
		inputOBS.setFont(new Font("Poppins", Font.PLAIN, 13));
		inputOBS.setLineWrap(true);
		inputOBS.setWrapStyleWord(true);
		inputOBS.setBounds(40, 534, 488, 82);
		contentPanel.add(inputOBS);
		
		JLabel lblOBS = new JLabel("Observações");
		lblOBS.setHorizontalAlignment(SwingConstants.CENTER);
		lblOBS.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblOBS.setBounds(40, 512, 488, 22);
		contentPanel.add(lblOBS);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 729, 569, 35);
		contentPanel.add(panel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					//registrar usuário
					QUERY = "INSERT INTO clientes (nome, rg, cpf, rua, bairro, cidade, estado, cep, email, fone1, fone2, obs, nascimento) "
							+ "VALUES ('" + inputNome.getText() +"', '" + inputRG.getText() + "', '" + inputCPF.getText() +"', "
							+ "'" + inputRua.getText() + "', '" + inputBairro.getText() + "', '" + inputCidade.getText() + "'"
							+ ", '" + comboBoxEstado.getSelectedItem() + "', '" + inputCEP.getText() + "', '" + inputEmail.getText() + "'"
							+ ", '" + inputTelefone1.getText() + "', '" + inputTelefone2.getText() + "'"
							+ ", '" + inputOBS.getText() + "', '" + inputNascimento.getText() + "' )";

								
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
					} else if (inputOBS.getText().isBlank()) {
						handleWindowMessage("Observação em branco!");
						return;
					}

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
					    	inputOBS.setText("");
					    	inputTelefone1.setText("");
					    	inputTelefone2.setText("");
					    	inputCidade.setText("");
					    	inputBairro.setText("");
					    	inputRua.setText("");
					    	inputCEP.setText("");
					    }

					} catch (SQLException erro) {
						erro.printStackTrace();
				}		
			}
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
				System.out.println(QUERY);
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				String nome, cpf, rg, nascimento, email, rua, bairro, cidade, estado, cep,
				fone1, fone2, obs = null;
				
				try {
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.prepareStatement(QUERY);
					rs = stmt.executeQuery(QUERY);
					
					while(rs.next()) {
						nome = rs.getString("nome");
						cpf = rs.getString("cpf");
						rg = rs.getString("rg");
						nascimento = rs.getString("nascimento");
						email = rs.getString("email");
						rua = rs.getString("rua");
						bairro = rs.getString("bairro");
						cidade = rs.getString("cidade");
						estado = rs.getString("estado");
						cep = rs.getString("cep");
						fone1 = rs.getString("fone1");
						fone2 = rs.getString("fone2");
						obs = rs.getString("obs");
						
						inputNome.setText(nome);
						inputCPF.setText(cpf);
						inputRG.setText(rg);
						inputNascimento.setText(nascimento);
						inputEmail.setText(email);
						inputRua.setText(rua);
						inputBairro.setText(bairro);
						inputCidade.setText(cidade);
						comboBoxEstado.setSelectedItem(estado);;
						inputCEP.setText(cep);
						inputTelefone1.setText(fone1);
						inputTelefone2.setText(fone2);
						inputOBS.setText(obs);						
					}
					
				} catch (SQLException error) {
					System.out.println(error);
				}
				
			}
		});
		btnPesquisar.setFont(new Font("Poppins", Font.PLAIN, 11));
		panel.add(btnPesquisar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Poppins", Font.PLAIN, 11));
		panel.add(btnEliminar);
		
		JButton btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar_1.setFont(new Font("Poppins", Font.PLAIN, 11));
		btnVoltar_1.setActionCommand("Cancel");
		panel.add(btnVoltar_1);
	}
}
