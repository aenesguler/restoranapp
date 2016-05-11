import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MenuCýkarFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCýkarFrame frame = new MenuCýkarFrame();
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
	public MenuCýkarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblkarlacakMen = new JLabel("\u00C7\u0131kar\u0131lacak Men\u00FC");
		lblkarlacakMen.setBounds(23, 39, 93, 14);
		contentPane.add(lblkarlacakMen);
		
		JButton btnMendenkar = new JButton("Men\u00FCden \u00C7\u0131kar");
		btnMendenkar.setBounds(57, 82, 116, 23);
		contentPane.add(btnMendenkar);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.setBounds(182, 82, 89, 23);
		contentPane.add(btnk);
		
		textField = new JTextField();
		textField.setBounds(111, 36, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
