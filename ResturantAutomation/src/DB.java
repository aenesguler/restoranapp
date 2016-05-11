
import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;

public class DB {
	private static Connection con = null;
	private static Statement stmt = null;

	public static void initializeDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DBMS conection Provided");

			con = DriverManager.getConnection("jdbc:mysql://localhost/ctis252",
					"root", "123698745");
			stmt = con.createStatement();
			System.out.println("Database connection provided");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initializeDB(String host, String dbname, String uname,
			String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DBMS conection Provided");
			String constr = "jdbc:mysql://" + host + "/" + dbname;
			con = DriverManager.getConnection(constr, uname, password);			
			stmt = con.createStatement();
			System.out.println("Database connection provided");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static ResultSet executeQ(String sql) {
		ResultSet rs = null;
		if (con != null) {
			sql = sql.toLowerCase();

			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

	public static int executeU(String sql) {
		int effectedRownumber = 0;
		if (con != null) {
			sql = sql.toLowerCase();
			try {
				effectedRownumber = stmt.executeUpdate(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return effectedRownumber;
	}

	public ResultSet execute(String sql) {
		sql = sql.toLowerCase();
		ResultSet rs = null;
		try {

			if (sql.startsWith("select")) {
				stmt.executeQuery(sql);
			} else {
				stmt.executeUpdate(sql);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	
	public static DefaultTableModel showTables(ResultSet rs) {
		DefaultTableModel dtm = new DefaultTableModel();
		Vector allrows = null;
		if (con != null) {
			try {
				Vector rowVectors = new Vector();
				 Vector columnHeaderVector = new Vector();
				 
					 
					 int columncount = rs.getMetaData().getColumnCount();
					 while(rs.next())
					 {
						 Vector singleRow = new Vector();
						 for(int i=1;i<=columncount;i++)
						 {
							 singleRow.addElement(rs.getObject(i));
						 }
						 rowVectors.addElement(singleRow);
					 }
					 for(int i=1;i<=columncount;i++)
					 {
						 columnHeaderVector.addElement(rs.getMetaData().getColumnName(i));
					 }
				dtm.setDataVector(rowVectors, columnHeaderVector);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtm;
	}

	public static Vector getTableNames() {
		
		String sql = "show tables";
		ResultSet rs;
		Vector tablenames = new Vector();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);			
			rs = pstmt.executeQuery();			
			while (rs.next()) {
				tablenames.add(rs.getString(1));
			}
			System.out.println(tablenames);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tablenames;
	}	
}
