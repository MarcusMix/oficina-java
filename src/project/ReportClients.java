package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ReportClients extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportClients dialog = new ReportClients();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			SwingUtilities.invokeLater(() -> {
	            new Clients();
	        });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReportClients() {
		setBounds(100, 100, 989, 775);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Cria o modelo da tabela com algumas colunas e dados
        DefaultTableModel modelo = new DefaultTableModel(new Object[][] {
            {},
        }, new String[] {"Nome", "Idade"});

        // Cria a tabela com o modelo
        tabela = new JTable(modelo);

        // Adiciona a tabela a um painel de rolagem
        JScrollPane scrollPane = new JScrollPane(tabela);

        // Cria um painel para a tabela
        JPanel painelTabela = new JPanel();
        painelTabela.add(scrollPane);

        // Adiciona o painel da tabela ao frame
        add(painelTabela);

        // Configura o frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setTitle("Exemplo de tabela");
        setVisible(true);
		
		
		{
			JLabel lblRelatorioDeClientes = new JLabel("Relatorio de Clientes");
			lblRelatorioDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
			lblRelatorioDeClientes.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
			lblRelatorioDeClientes.setBounds(10, 11, 456, 51);
			contentPanel.add(lblRelatorioDeClientes);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		//querys
		String DB_NAME = "ordemservico";
		String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
		String USER = "root";
		String PASS = "admin";
	    try (Connection conexao = DriverManager.getConnection(DB_URL, USER, PASS)) {
	    	
	      String sql = "SELECT * FROM clientes";
	      
	      Statement comando = conexao.createStatement();
	      ResultSet resultado = comando.executeQuery(sql);


	      while (resultado.next()) {
	        String nome = resultado.getString("nome");
	        String cpf = resultado.getString("cpf");
            String email = resultado.getString("email");;

	        System.out.println(nome + cpf + email);
	      }
	    } catch (SQLException e) {
	      System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
	    }
	}
	
}
