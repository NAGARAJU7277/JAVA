package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewAccountBalance {
	
	public static void balance(int id)
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps2 =null;
		ResultSet rs = null;
		String view = "SELECT * FROM CUSTOMER WHERE AccNumber=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
			ps2 = con.prepareStatement(view);
			ps2.setInt(1,id);
			rs = ps2.executeQuery();
			if(rs.next())
			{
				System.out.println("Account Number:    "+ rs.getString(1));
				System.out.println("Name:              "+rs.getString(2));
				System.out.println("Balance:           "+ rs.getString(5));
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
