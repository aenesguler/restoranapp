
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JPasswordField;

public class LoginClient extends JFrame {

	Client client = null;

	private JPanel contentPane;
	private JTextField tssn;
	private JLabel lres;
	private JPasswordField tpw;

	public LoginClient(Client pclient) {

		client = pclient;

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				client.closeConnection();
			}
		});

		setTitle("Login to Hospital System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 228, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(24, 25, 77, 14);
		contentPane.add(lblNewLabel);

		tssn = new JTextField();
		tssn.setBounds(96, 22, 86, 20);
		contentPane.add(tssn);
		tssn.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(24, 56, 77, 14);
		contentPane.add(lblPassword);

		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				client.sendUTFDataToServer(tssn.getText());
				client.sendUTFDataToServer(tpw.getText());

				String ans = client.getUTFDataFromServer();

				if (ans.equals("YES")) {
					
					int id = client.getIntDataFromServer();
					String name = client.getUTFDataFromServer();
					int type = client.getIntDataFromServer();
					System.out.println(name+""+type);
					
				//	client.setClientInfo(id, name,type);
					
					if(type == 1)//yonetici
					{	
						System.out.println("frame yönetici açýldý");
						YoneticiFrame y = new YoneticiFrame(client);
						y.setTitle("Admin : "+name);
						y.setVisible(true);
					}
					else if(type == 2)//mutfak
					{ 
						System.out.println("frame mutfak açýldý");
						MutfakFrame m = new MutfakFrame(client);
						m.setTitle("Admin : "+name);
						m.setVisible(true);
					}
					else if(type == 3)//garson
					{ 
						System.out.println("frame garson açýldý");
						GarsonFrame g = new GarsonFrame(client);
						g.setTitle("Admin : "+name);
						g.setVisible(true);
					}
					dispose();
				} else {
					lres.setText("Wrong User name or password");
				}
			}
		});
		btnLogin.setBounds(56, 95, 89, 23);
		contentPane.add(btnLogin);

		lres = new JLabel("");
		lres.setBounds(24, 78, 239, 14);
		contentPane.add(lres);
		
		tpw = new JPasswordField();
		tpw.setBounds(96, 53, 86, 20);
		contentPane.add(tpw);
	}
}
