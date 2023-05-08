package views.client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controllers.ClientsController;
import models.client.ClientModel;
import models.client.ClientesTB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class ReportClients extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private JTextField inputPesquisar;
	static String QUERY = null;
	

	public static void main(String[] args) {
		try {
			ReportClients dialog = new ReportClients();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ReportClients() {
		setBounds(100, 100, 697, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		
		JLabel lblRelatorioDeClientes = new JLabel("Relatorio de Clientes");
		lblRelatorioDeClientes.setBounds(0, 0, 681, 51);
		lblRelatorioDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorioDeClientes.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 20));
		contentPanel.add(lblRelatorioDeClientes);
		
		//tabela config
		DefaultTableModel tableModel = new DefaultTableModel();
		
		tableModel.addColumn("Nome");
		tableModel.addColumn("CPF");
		tableModel.addColumn("Email");
		tableModel.addColumn("Telefone");
		tableModel.addColumn("Cidade");
		tableModel.addColumn("Estado");
		tableModel.addColumn("Editar");
		table = new JTable(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(46, 95, 590, 141);
		contentPanel.add(scrollPane);
		
		table.setFont(new Font("Poppins", Font.PLAIN, 12));		
		
		inputPesquisar = new JTextField();
		inputPesquisar.setFont(new Font("Poppins", Font.PLAIN, 11));
		inputPesquisar.setBounds(219, 52, 237, 23);
		contentPanel.add(inputPesquisar);
		inputPesquisar.setColumns(10);
		
		ClientsController.handleDataClients(table);
		
		JButton btnPesquisar = new JButton();
		btnPesquisar.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\search-icon_resized.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QUERY = "SELECT * FROM clientes WHERE nome LIKE '" + inputPesquisar.getText() + "%'";
				System.out.println(QUERY);
				
				ClientsController.handleSearchClient(QUERY, inputPesquisar, table);				
			}
		});
		btnPesquisar.setActionCommand("OK");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPesquisar.setBounds(466, 52, 30, 23);
		contentPanel.add(btnPesquisar);
		
		JLabel lblNewLabel = new JLabel("Pesquisar:");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel.setBounds(146, 54, 69, 18);
		contentPanel.add(lblNewLabel);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Poppins", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QUERY = "SELECT * FROM clientes";
				
				ClientsController.handleSearchAllClients(QUERY, table, inputPesquisar);
			}
		});
		btnLimpar.setBounds(501, 52, 75, 23);
		contentPanel.add(btnLimpar);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		
		
//		class ButtonRenderer extends JButton implements TableCellRenderer {
//		    public ButtonRenderer() {
//		        setOpaque(true);
//		    }
//
//		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//		        setText((value == null) ? "" : value.toString());
//		        return this;
//		    }
//		}
//		
//		
//		
//
//		class ButtonEditor extends DefaultCellEditor {
//		    protected JButton button;
//
//		    public ButtonEditor(JCheckBox checkBox, JButton button) {
//		        super(checkBox);
//		        this.button = button;
//		        this.button.setOpaque(true);
//		        this.button.addActionListener(e -> fireEditingStopped());
//		    }
//
//		    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//		        return button;
//		    }
//
//		    public Object getCellEditorValue() {
//		        return button.getText();
//		    }
//		}
//		
//		JButton editButton = new JButton("Editar");
//		editButton.addActionListener(new ActionListener() {
//		    @Override
//		    public void actionPerformed(ActionEvent e) {
//		    	System.out.println("editando...");
//		        int selectedRow = table.getSelectedRow();
//		        if (selectedRow != -1) { // se houver uma linha selecionada
//		            int option = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este registro?");
//		            if (option == JOptionPane.YES_OPTION) {
//		                // execute a ação de deleção do banco de dados aqui
////		                tableModel.removeRow(selectedRow); // remove a linha da tabela
//		            }
//		        }
//		    }
//		});
//
//		// Adicione o botão de exclusão na última coluna da tabela
//		int lastColumn = table.getColumnCount() - 1;
//		table.getColumnModel().getColumn(lastColumn).setCellRenderer(new ButtonRenderer());
//		table.getColumnModel().getColumn(lastColumn).setCellEditor(new ButtonEditor(new JCheckBox(), editButton));
//
	}
}


