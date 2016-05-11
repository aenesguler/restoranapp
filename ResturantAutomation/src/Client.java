
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.table.DefaultTableModel;

public class Client {

	private Socket client;
	private DataInputStream dis;
	private DataOutputStream dos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private String name;
	int id, type;

	
	public void setClientInfo(int id, String name, int type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public void connectServer() {
		try {

			client = new Socket("localhost", 8000);
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());

			ois = new ObjectInputStream(client.getInputStream());
			oos = new ObjectOutputStream(client.getOutputStream());
			System.out.println("I/O streams for client created");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			sendUTFDataToServer("EXIT");
			dis.close();
			dos.close();
			client.close();
			System.out.println("CLIENT END");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean sendUTFDataToServer(String msg) {

		if (client != null) {
			try {
				dos.writeUTF(msg);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean sendIntDataToServer(int num) {

		if (client != null) {
			try {
				dos.writeInt(num);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean sendDoubleDataToServer(double num) {

		if (client != null) {
			try {
				dos.writeDouble(num);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public String getUTFDataFromServer() {
		String res = "";
		if (client != null) {
			try {
				res = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

	public int getIntDataFromServer() {
		int res = 0;
		if (client != null) {
			try {
				res = dis.readInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

	public double getDoubleDataFromServer() {
		double res = 0;
		if (client != null) {
			try {
				res = dis.readDouble();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

	public void sendObjectToServer(Object obj) {

		if (client != null) {
			try {
				oos.writeObject(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Object getObjectFromServer() {
		Object obj = null;
		if (client != null) {
			try {
				obj = (DefaultTableModel) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	public Object getObjectFromServer2() {
		Object obj = null;
		if (client != null) {
			try {
				obj = (ArrayList<String>)ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	public Object getArrayListFromServer() {
		Object obj = null;
		if (client != null) {
			try {
				obj = (ArrayList) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;
	}

	public static void main(String[] args) {

		Client client = new Client();
		client.connectServer();
		LoginClient frame = new LoginClient(client);
		frame.setVisible(true);
	}

}
