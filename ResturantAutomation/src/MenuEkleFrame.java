import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEkleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Client client;

	/**
	 * Create the frame.
	 */
	public MenuEkleFrame(Client c) {
		client = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenAd = new JLabel("Men\u00FC Ad\u0131:");
		lblMenAd.setBounds(10, 30, 78, 14);
		contentPane.add(lblMenAd);
		
		JLabel lblcreti = new JLabel("\u00DCcreti:");
		lblcreti.setBounds(10, 68, 78, 14);
		contentPane.add(lblcreti);
		
		JLabel lblPimeSresi = new JLabel("Pi\u015Fme S\u00FCresi");
		lblPimeSresi.setBounds(10, 109, 78, 14);
		contentPane.add(lblPimeSresi);
		
		JButton btnMenEkle = new JButton("Men\u00FC Ekle");
		btnMenEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer("EKLEE");
				client.sendUTFDataToServer(textField.getText());
				client.sendUTFDataToServer(textField_1.getText());
				client.sendUTFDataToServer(textField_2.getText());
			}
		});
		btnMenEkle.setBounds(29, 150, 89, 23);
		contentPane.add(btnMenEkle);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnTemizle.setBounds(129, 150, 89, 23);
		contentPane.add(btnTemizle);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnk.setBounds(75, 194, 89, 23);
		contentPane.add(btnk);
		
		textField = new JTextField();
		textField.setBounds(91, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 65, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 106, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}
