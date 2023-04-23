package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
					Login login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("Oficina...");
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuCadastro.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		menuBar.add(menuCadastro);
		
		JMenuItem menuRegisterUser = new JMenuItem("Usuários");
		menuRegisterUser.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuRegisterUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUser user = new RegisterUser();
				user.setVisible(true);
			}
		});
		menuCadastro.add(menuRegisterUser);
		
		JMenuItem menuRegisterClient = new JMenuItem("Clientes");
		menuRegisterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterClient client = new RegisterClient();
				client.setVisible(true);
			}
		});
		menuRegisterClient.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuCadastro.add(menuRegisterClient);
		
		JMenuItem menuRegisterPro = new JMenuItem("Profissionais");
		menuRegisterPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterLaborer laborer = new RegisterLaborer();
				laborer.setVisible(true);
			}
		});
		menuRegisterPro.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuCadastro.add(menuRegisterPro);
		
		JMenu menuVendas = new JMenu("Movimento/Vendas");
		menuVendas.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		menuVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(menuVendas);
		
		JMenu menuRelatorio = new JMenu("Relatórios");
		menuRelatorio.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		menuRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(menuRelatorio);
		
		JMenuItem menuRelVendas = new JMenuItem("Vendas");
		menuRelVendas.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuRelatorio.add(menuRelVendas);
		
		JMenuItem menuRelClientes = new JMenuItem("Clientes");
		menuRelClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuRelClientes.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuRelatorio.add(menuRelClientes);
		
		JMenu menuSobre = new JMenu("Sobre");
		menuSobre.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(menuSobre);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Oficina do Zé");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 22, 434, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\main-image.png"));
		lblNewLabel_1.setBounds(0, 52, 434, 76);
		contentPane.add(lblNewLabel_1);
	}
}
