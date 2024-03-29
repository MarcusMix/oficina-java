package views;

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
import views.client.RegisterClient;
import views.client.ReportClients;
import views.laborer.RegisterLaborer;
import views.user.UserView;

public class Index extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem menuRegisterUser;
	private JMenuItem menuRegisterClient;
	private JMenuItem menuRegisterPro;
	private JMenuItem menuRelVendas;
	private JMenuItem menuRelClientes;
	private JMenu menuCadastro;
	private JMenu menuVendas;
	private JMenu menuRelatorio;
	private JMenu menuSobre;
	private JLabel mainIcon;
	private JLabel title;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
					Login login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("Oficina...");
		setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuCadastro = new JMenu("Cadastro");
		menuCadastro.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		menuBar.add(menuCadastro);
		
		menuRegisterUser = new JMenuItem("Usuários");
		menuRegisterUser.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuRegisterUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserView user = new UserView();
				user.setVisible(true);
			}
		});
		menuCadastro.add(menuRegisterUser);
		
		menuRegisterClient = new JMenuItem("Clientes");
		menuRegisterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterClient client = new RegisterClient();
				client.setVisible(true);
			}
		});
		menuRegisterClient.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuCadastro.add(menuRegisterClient);
		
		menuRegisterPro = new JMenuItem("Profissionais");
		menuRegisterPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterLaborer laborer = new RegisterLaborer();
				laborer.setVisible(true);
			}
		});
		menuRegisterPro.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuCadastro.add(menuRegisterPro);
		
		menuVendas = new JMenu("Movimento/Vendas");
		menuVendas.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		menuVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(menuVendas);
		
		menuRelatorio = new JMenu("Relatórios");
		menuRelatorio.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		menuRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(menuRelatorio);
		
		menuRelVendas = new JMenuItem("Vendas");
		menuRelVendas.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuRelatorio.add(menuRelVendas);
		
		menuRelClientes = new JMenuItem("Clientes");
		menuRelClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportClients reportClients = new ReportClients();
				reportClients.setVisible(true);
			}
		});
		menuRelClientes.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		menuRelatorio.add(menuRelClientes);
		
		menuSobre = new JMenu("Sobre");
		menuSobre.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(menuSobre);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JLabel("Oficina do Zé");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 38));
		title.setBounds(0, 55, 909, 51);
		contentPane.add(title);
		
		mainIcon = new JLabel("");
		mainIcon.setHorizontalAlignment(SwingConstants.CENTER);
		mainIcon.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\main-image.png"));
		mainIcon.setBounds(0, 117, 909, 76);
		contentPane.add(mainIcon);
	}
}
