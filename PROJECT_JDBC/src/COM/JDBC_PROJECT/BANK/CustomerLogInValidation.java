package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerLogInValidation {
	
	public static boolean cusloginValidation(int Acc, int pin)
	{
		
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement psl =null;
		ResultSet rs = null;
		String cval = "SELECT * FROM customer where AccNumber=? And Pin =?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
			psl = con.prepareStatement(cval);
			psl.setInt(1, Acc);
			psl.setInt(2, pin);
			rs = psl.executeQuery();
			if(rs.next())
			{
				String cname =rs.getString(2);
				System.out.println("Welcome to the Bank:"+ cname +",");
				return true;
			}
			else 
			{
				System.out.println("Invalid Customer AccountNumber and pin.please try again ");
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(psl!=null)psl.close();
				if(con!=null)con.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}

}
