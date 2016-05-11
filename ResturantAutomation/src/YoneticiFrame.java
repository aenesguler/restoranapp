import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YoneticiFrame extends JFrame {

	private JPanel contentPane;
	Client client = null;

	/**
	 * Create the frame.
	 * @param client 
	 */
	public YoneticiFrame(Client c) {
		client=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnKasaHesapla = new JButton("KASA HESAPLA");
		btnKasaHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer("KASAHESAPLA");
					KasaHesapFrame kasa=new KasaHesapFrame(client);
					kasa.setVisible(true);
			}
		});
		btnKasaHesapla.setBounds(54, 38, 153, 23);
		contentPane.add(btnKasaHesapla);
		
		JButton btnPersonelBilgileri = new JButton("Personel Bilgileri");
		btnPersonelBilgileri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer("PERSONELBILGILERI");
				PersonelBilgiFrame per=new PersonelBilgiFrame(client);
				per.setVisible(true);
			}
		});
		btnPersonelBilgileri.setBounds(54, 66, 153, 23);
		contentPane.add(btnPersonelBilgileri);
		
		JButton btnRestoranBilgileriDzenle = new JButton("Restoran Bilgileri D\u00FCzenle");
		btnRestoranBilgileriDzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer("RESTORANBILGILERI");
				RestaurantBilgiFrame res = new RestaurantBilgiFrame(client);
				res.setVisible(true);
			}
		});
		btnRestoranBilgileriDzenle.setBounds(54, 95, 153, 23);
		contentPane.add(btnRestoranBilgileriDzenle);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.setBounds(54, 129, 153, 23);
		contentPane.add(btnk);
	}
}
