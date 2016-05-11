import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class HazirSiparisGosterFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HazirSiparisGosterFrame frame = new HazirSiparisGosterFrame();
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
	public HazirSiparisGosterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHazrSiparisler = new JLabel("Haz\u0131r Siparisler");
		lblHazrSiparisler.setBounds(10, 11, 90, 14);
		contentPane.add(lblHazrSiparisler);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 337, 203);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.setBounds(198, 248, 89, 23);
		contentPane.add(btnk);
	}

}
