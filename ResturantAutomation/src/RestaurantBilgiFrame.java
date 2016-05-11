import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurantBilgiFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
Client client=null;
	/**
	 * Create the frame.
	 */
	public RestaurantBilgiFrame(Client c) {
		client=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer("KAYDET");
				client.sendUTFDataToServer(textField.getText());
				client.sendUTFDataToServer(textField_1.getText());
				client.sendUTFDataToServer(textField_2.getText());
				client.sendUTFDataToServer(textField_3.getText());
				client.sendUTFDataToServer(textField_4.getText());
			}
		});
		btnNewButton.setBounds(71, 208, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnk.setBounds(188, 208, 89, 23);
		contentPane.add(btnk);
		
		textField = new JTextField();
		textField.setBounds(160, 22, 125, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 53, 125, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 84, 125, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(160, 115, 125, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(160, 146, 125, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblRestaurantAd = new JLabel("Restaurant ad\u0131:");
		lblRestaurantAd.setBounds(40, 25, 89, 14);
		contentPane.add(lblRestaurantAd);
		
		JLabel lblRestaurantSlogan = new JLabel("Restaurant slogan");
		lblRestaurantSlogan.setBounds(40, 56, 89, 14);
		contentPane.add(lblRestaurantSlogan);
		
		JLabel lblRestaurantAdres = new JLabel("Restaurant Adres");
		lblRestaurantAdres.setBounds(40, 87, 89, 14);
		contentPane.add(lblRestaurantAdres);
		
		JLabel lblTelefonNumaras = new JLabel("Telefon numaras\u0131");
		lblTelefonNumaras.setBounds(40, 118, 89, 14);
		contentPane.add(lblTelefonNumaras);
		
		JLabel lblInternetSitesi = new JLabel("internet sitesi");
		lblInternetSitesi.setBounds(40, 149, 89, 14);
		contentPane.add(lblInternetSitesi);
		
		textField.setText(client.getUTFDataFromServer());
		textField_1.setText(client.getUTFDataFromServer());
		textField_2.setText(client.getUTFDataFromServer());
		textField_3.setText(client.getUTFDataFromServer());
		textField_4.setText(client.getUTFDataFromServer());
	}
}
