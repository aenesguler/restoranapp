import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerSys {
	
	public static ResultSet login(String uname, String pswd)
	{
		String sql = "select * from user where name='"+uname+"' and pass='"+pswd+"'";
		ResultSet rs = DB.executeQ(sql);
		return rs;
	}
	
	public static int getKasa(String day){
		int dayres=Integer.parseInt(day);
		int res = 0;
		String sql = "SELECT total FROM kasa where date="+dayres;
		ResultSet rs = DB.executeQ(sql);
		try {
			while (rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public static ResultSet getPeronels()
	{
		String sql = "select name from personel";
		ResultSet rs = DB.executeQ(sql);
		return rs;
	}
	
	public static int findPrice(String name){
		int res=0;
		String sql = "select price from menu where name like '"+name+"'";
		ResultSet rs = DB.executeQ(sql);
		try {
			rs.next();
			res=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public static int findId(String name){
		int res=0;
		String sql = "select id from menu where name like '"+name+"'";
		ResultSet rs = DB.executeQ(sql);
		try {
			rs.next();
			res=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public static ArrayList<String> getMenuName(){
		ArrayList<String> temp=new ArrayList<String>();
		String sql = "select name from menu";
		ResultSet rs = DB.executeQ(sql);
		try {
			while(rs.next())
				temp.add(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return temp;
	}
	
	public static ResultSet getRestinfo()
	{
		String sql = "select * from restinfo";
		ResultSet rs = DB.executeQ(sql);
		return rs;
	}
	public static void updateresinfo (String adi,String slogan,String adres,String tel,String site)
	{
		int res=0;
		String sql="update restinfo set adi='"+adi+"',slogani='"+slogan+"',adresi='"+adres+"',telefon='"+tel+"',site='"+site+"'";
		DB.executeU(sql);
		
	}
	
	public static void addMenu (String name,int price,int time)
	{
		int res=0;
		String sql="insert into menu (name,time,price) values('"+name+"',"+time+","+price+")";
		DB.executeU(sql);
	}
	
	public static void updateOrders (int masano)
	{
		int res=0;
		String sql="update orders set status='ready' where tableno="+masano;
		DB.executeU(sql);
		
	}
	
	public static void addOrders (int masano,int menuno,String notlar,int price)
	{
		int res=0;
		String sql="insert into orders (tableno,bill,status,menuid,notlar) values("+masano+","+price+",'waiting',"+menuno+",'"+notlar+"')";
		DB.executeU(sql);
	}
	
	public static ResultSet getGelenSiparis()
	{
		String sql = "select * from orders where status='waiting'";
		ResultSet rs = DB.executeQ(sql);
		return rs;
	}
	
	public static ArrayList getDepartments() {
		ArrayList<String> departments = new ArrayList<String>();
		String sql = "Select name from department";
		ResultSet rs = DB.executeQ(sql);
		try {
			while (rs.next()) {
				departments.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departments;
	}
	
	public static ResultSet getDoctors(String deptName)
	{
		String sql = "select s.id, s.name, s.surname from staff s, department d where s.type=2 and d.name='"+deptName+"' and d.id=s.dept";
		ResultSet rs = DB.executeQ(sql);
		return rs;
	}
	
	public static ArrayList getPatients() {
		ArrayList<String> patients = new ArrayList<String>();
		String sql = "Select id from patient";
		ResultSet rs = DB.executeQ(sql);
		try {
			while (rs.next()) {
				patients.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patients;
	}
	
	public static ResultSet findPatient(String patientId)
	{
		String sql = "select id, name, surname from patient where id=" + patientId;
		ResultSet rs = DB.executeQ(sql);
		return rs;
	}
	
	public static void addDiagnosis(int patientId, String diagnose)
	{
		String sql = "insert into doctorpatient values(" + patientId + ",'" + diagnose + "')";
		DB.executeU(sql);
	}
	
	public static ResultSet showDiagnosis(int patientId)
	{
		String sql = "select * from doctorpatient where pid = " + patientId;
		ResultSet rs = DB.executeQ(sql);
		return rs;
	}
}
