import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MasaKapatFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasaKapatFrame frame = new MasaKapatFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MasaKapatFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHesabnKapatmakIstediiniz = new JLabel("Hesab\u0131n\u0131 Kapatmak \u0130stedi\u011Finiz Masa :");
		lblHesabnKapatmakIstediiniz.setBounds(10, 33, 176, 14);
		contentPane.add(lblHesabnKapatmakIstediiniz);
		
		JLabel lblTutar = new JLabel("Tutar");
		lblTutar.setBounds(10, 69, 46, 14);
		contentPane.add(lblTutar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(76, 69, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnHesapla = new JButton("Hesapla");
		btnHesapla.setBounds(219, 65, 89, 23);
		contentPane.add(btnHesapla);
		
		textField = new JTextField();
		textField.setBounds(222, 30, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.setBounds(193, 213, 89, 23);
		contentPane.add(btnk);
	}

}
