package views.message;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MessageSucess extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			MessageError dialog = new MessageError("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MessageSucess(String message) {
		setLocationRelativeTo(null);
		setBounds(100, 100, 391, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setModal(true);
		setLocationRelativeTo(null);
		
		JLabel messageText = new JLabel(message);
		messageText.setHorizontalAlignment(SwingConstants.CENTER);
		messageText.setFont(new Font("Poppins Black", Font.BOLD, 22));
		messageText.setBounds(0, 0, 375, 53);
		contentPanel.add(messageText);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vini6\\Documents\\ADS\\Desenvolvimento-desktop\\oficina\\images\\feito.png"));
			lblNewLabel.setBounds(125, 45, 128, 128);
			contentPanel.add(lblNewLabel);
		}
		
		setTitle("Sucesso!");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MessageSucess.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
		}
	}
	
	public static void handleWindowMessageSucess(String text) {
		MessageSucess message = new MessageSucess(text);
		message.setLocationRelativeTo(null);
		message.setVisible(true);
	}
}
