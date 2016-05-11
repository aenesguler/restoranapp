
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.table.DefaultTableModel;

public class Server {

	public Server() {

		try {
			DB.initializeDB();

			ServerSocket server = new ServerSocket(8000);
			System.out.println("Server is running");

			System.out.println("Server is wating for client");
			while (true) {
				Socket clientsocket = server.accept();
				MyClientThread tforclient = new MyClientThread(clientsocket);
				tforclient.start();
				System.out.println("Server starts to serve to client");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("END SERVER");

	}

	public static void main(String[] args) {
		Server server = new Server();
	}

	class MyClientThread extends Thread {

		Socket clientsocket;
		DataInputStream dis;
		DataOutputStream dos;
		ObjectInputStream ois;
		ObjectOutputStream oos;

		public MyClientThread(Socket csocket) {
			this.clientsocket = csocket;
			System.out.println("Client connected");
			try {
				dis = new DataInputStream(clientsocket.getInputStream());
				dos = new DataOutputStream(clientsocket.getOutputStream());

				oos = new ObjectOutputStream(clientsocket.getOutputStream());
				ois = new ObjectInputStream(clientsocket.getInputStream());

				System.out.println("I/O streams are created");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				String un = dis.readUTF();
				String pw = dis.readUTF();
				
				ResultSet rs = ServerSys.login(un, pw);
				
				if(rs.next())
				 {
					 dos.writeUTF("YES");
					 
					 int id = rs.getInt(1);
					 String name = rs.getString(2);
					 int type = rs.getInt(4);
					 
					 dos.writeInt(id);
					 dos.writeUTF(name);
					 dos.writeInt(type);
					 
					 
					 if(type==1) //yönetici					
						 while(true)
						 {
							 String op = dis.readUTF();
							 if(op.equals("KASAHESAPLA"))
							 {
								 int reskasa = ServerSys.getKasa(dis.readUTF());
								 dos.writeInt(reskasa);
							 } 
							 else if(op.equals("PERSONELBILGILERI"))
							 {
								
								rs = ServerSys.getPeronels();
								DefaultTableModel dtm = DB.showTables(rs);
								oos.writeObject(dtm);
							 }
							 else if(op.equals("RESTORANBILGILERI"))
							 {
								 rs = ServerSys.getRestinfo();
								rs.next();
									dos.writeUTF(rs.getString(2));
									dos.writeUTF(rs.getString(3));
									dos.writeUTF(rs.getString(4));
									dos.writeUTF(rs.getString(5));
									dos.writeUTF(rs.getString(6));
									
									if(dis.readUTF().equals("KAYDET")){
										String adi=dis.readUTF();
										String slogan=dis.readUTF();
										String adres=dis.readUTF();
										String telefon=dis.readUTF();
										String site=dis.readUTF();
										
										ServerSys.updateresinfo(adi, slogan, adres, telefon, site);
									}
							 }
									 
						 }
					 else if(type==2) //mutfak
						 while(true)
						 {
							 String op = dis.readUTF();
							 if(op.equals("GELENSIPARISLER"))
							 {
								  rs = ServerSys.getGelenSiparis();
								  DefaultTableModel dtm=DB.showTables(rs);
								  oos.writeObject(dtm);
								 
							 } 
							 else if(op.equals("HAZIRSIPARISBILDIR"))
							 {
								 int masano=Integer.parseInt(dis.readUTF());
								 ServerSys.updateOrders(masano);
							 }
							 else if(op.equals("MENUEKLE2"))
							 {
								 if(dis.readUTF().equals("EKLEE")){
									 String adi=dis.readUTF();
									 int ucret=Integer.parseInt(dis.readUTF());
									 int sure=Integer.parseInt(dis.readUTF());
									 
									 ServerSys.addMenu(adi, ucret, sure);
								 }
								 
								 /*
								 ArrayList<String> menuname=ServerSys.getMenuName();
								 oos.writeObject(menuname);
								 
								 if(dis.readUTF().equals("SIPARISEKLE")){
									 int masano=Integer.parseInt(dis.readUTF());
									 String menuname1=dis.readUTF();
									 String notlar=dis.readUTF();
									 int price=ServerSys.findPrice(menuname1);
									 int id1=ServerSys.findId(menuname1);
									 ServerSys.addOrders(masano, id1, notlar, price);
								 }
								 */
							 }
						 }
					 else if(type==3) //Garson
						 while(true)
						 {
							 String op = dis.readUTF();
							 if(op.equals("GETPATIENTS"))
							 {
								 ArrayList patient = ServerSys.getPatients();					
								 oos.writeObject(patient);
							 } 
							 else if(op.equals("FINDPATIENT"))
							 {
								 String patientId = dis.readUTF();
								 rs = ServerSys.findPatient(patientId);
								 DefaultTableModel dtm = DB.showTables(rs);							
								 oos.writeObject(dtm);
							 }
							 else if(op.equals("DIAGNOSE"))
							 {
								 int patientId = Integer.parseInt(dis.readUTF());
								 String diagnose = dis.readUTF();
								 ServerSys.addDiagnosis(patientId,diagnose);
								 rs = ServerSys.showDiagnosis(patientId);
								 DefaultTableModel dtm = DB.showTables(rs);							
								 oos.writeObject(dtm);
							 }
						 }
				 }
				 else{ 
					 dos.writeUTF("NO");
				 }

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
