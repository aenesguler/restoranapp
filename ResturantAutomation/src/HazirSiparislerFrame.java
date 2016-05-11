import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HazirSiparislerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	Client client;

	/**
	 * Create the frame.
	 */
	public HazirSiparislerFrame(Client c) {
		client=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMasaNumaras = new JLabel("Masa Numaras\u0131 :");
		lblMasaNumaras.setBounds(22, 26, 114, 14);
		contentPane.add(lblMasaNumaras);
		
		textField = new JTextField();
		textField.setBounds(135, 23, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Haz\u0131rland\u0131");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer(textField.getText());
			}
		});
		btnNewButton.setBounds(297, 22, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnk.setBounds(203, 70, 89, 23);
		contentPane.add(btnk);
	}

}
