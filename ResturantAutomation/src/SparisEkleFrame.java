import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SparisEkleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JTextArea textArea;
	Client client=null;

	/**
	 * Create the frame.
	 */
	public SparisEkleFrame(Client c) {
		client=c;
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSipariEklenecekMasa = new JLabel("Sipari\u015F Eklenecek Masa");
		lblSipariEklenecekMasa.setBounds(10, 11, 119, 14);
		contentPane.add(lblSipariEklenecekMasa);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(10, 39, 46, 14);
		contentPane.add(lblMenu);
		
		JLabel lblMutfaaNotlar = new JLabel("Mutfa\u011Fa notlar");
		lblMutfaaNotlar.setBounds(10, 63, 100, 14);
		contentPane.add(lblMutfaaNotlar);
		
		JButton btnSpariGnder = new JButton("Spari\u015F G\u00F6nder");
		btnSpariGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer("SIPARISEKLE");
				client.sendUTFDataToServer(textField.getText());
				client.sendUTFDataToServer((String)comboBox.getSelectedItem());
				client.sendUTFDataToServer(textArea.getText());
			}
		});
		btnSpariGnder.setBounds(30, 227, 99, 23);
		contentPane.add(btnSpariGnder);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnk.setBounds(141, 227, 89, 23);
		contentPane.add(btnk);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 249, 124);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		comboBox = new JComboBox();
		comboBox.setBounds(145, 36, 108, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(144, 8, 109, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
	
	public void setCombo(ArrayList<String> arr){
		for(int i=0;i<arr.size();i++){
			comboBox.addItem((String)arr.get(i));
		}
	}
}
