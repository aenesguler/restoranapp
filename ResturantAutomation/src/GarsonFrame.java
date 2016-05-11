import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class GarsonFrame extends JFrame {

	private JPanel contentPane;
Client client=null;


	/**
	 * Create the frame.
	 */
	public GarsonFrame(Client c) {
		client=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSipariEkle = new JButton("Sipari\u015F Ekle");
		btnSipariEkle.setBounds(36, 29, 139, 23);
		contentPane.add(btnSipariEkle);
		
		JButton btnHazrSiparileriGster = new JButton("Haz\u0131r Sipari\u015Fleri G\u00F6ster");
		btnHazrSiparileriGster.setBounds(36, 63, 139, 23);
		contentPane.add(btnHazrSiparileriGster);
		
		JButton btnMasaHesapKapat = new JButton("Masa Hesap Kapat");
		btnMasaHesapKapat.setBounds(36, 97, 139, 23);
		contentPane.add(btnMasaHesapKapat);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.setBounds(36, 131, 139, 23);
		contentPane.add(btnk);
	}

}
