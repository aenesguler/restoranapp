import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KasaHesapFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Client client=null;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public KasaHesapFrame(Client c) {
		client =c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGnlkKazan = new JLabel("G\u00FCnl\u00FCk KAZAN\u00C7");
		lblGnlkKazan.setBounds(10, 84, 103, 14);
		contentPane.add(lblGnlkKazan);
		
		label = new JLabel("0");
		label.setFont(new Font("Tahoma", Font.BOLD, 39));
		label.setBounds(106, 45, 148, 87);
		contentPane.add(label);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnk.setBounds(83, 126, 89, 23);
		contentPane.add(btnk);
		
		textField = new JTextField();
		textField.setBounds(70, 24, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTarih = new JLabel("tarih");
		lblTarih.setBounds(14, 27, 46, 14);
		contentPane.add(lblTarih);
		
		JButton btnHesapla = new JButton("Hesapla");
		btnHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String day = textField.getText();
				client.sendUTFDataToServer(day);
				label.setText(client.getIntDataFromServer()+"");
			}
		});
		btnHesapla.setBounds(165, 23, 89, 23);
		contentPane.add(btnHesapla);
	}
}
