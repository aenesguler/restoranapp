import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MutfakFrame extends JFrame {

	private JPanel contentPane;
	Client client= null;

	/**
	 * Create the frame.
	 */
	public MutfakFrame(Client c) {
		client=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGelenSipariler = new JButton("Gelen Sipari\u015Fler");
		btnGelenSipariler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer("GELENSIPARISLER");
				GelenSiparisFrame gel = new GelenSiparisFrame(client);
				gel.setVisible(true);
			}
		});
		btnGelenSipariler.setBounds(65, 11, 130, 23);
		contentPane.add(btnGelenSipariler);
		
		JButton btnHazrSipariBilgir = new JButton("Haz\u0131r Sipari\u015F Bilgir");
		btnHazrSipariBilgir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer("HAZIRSIPARISBILDIR");
				HazirSiparislerFrame hazir=new HazirSiparislerFrame(client);
				hazir.setVisible(true);
			}
		});
		btnHazrSipariBilgir.setBounds(65, 45, 130, 23);
		contentPane.add(btnHazrSipariBilgir);
		
		JButton btnMenyeEkle = new JButton("Men\u00FCye ekle");
		btnMenyeEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendUTFDataToServer("MENUEKLE2");
				MenuEkleFrame menek=new MenuEkleFrame(client);
				menek.setVisible(true);
				
				/*
				ArrayList<String> menuname= (ArrayList<String>)client.getObjectFromServer2();
				SparisEkleFrame sipek=new SparisEkleFrame(client);
				sipek.setCombo(menuname);
				sipek.setVisible(true);
				*/
			}
		});
		btnMenyeEkle.setBounds(65, 82, 130, 23);
		contentPane.add(btnMenyeEkle);
		
		JButton btnMendenkar = new JButton("Men\u00FCden \u00C7\u0131kar");
		btnMendenkar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMendenkar.setBounds(65, 116, 130, 23);
		contentPane.add(btnMendenkar);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.setBounds(65, 150, 130, 23);
		contentPane.add(btnk);
	}

}
