package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmploeeLogInvalidation {

	public static boolean loginValidation( int id, String  pwd)
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement psl =null;
		ResultSet rs = null;
		String eval = "SELECT * FROM Employee where EID=? AND PASSWORD=?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
			psl = con.prepareStatement(eval);
			psl.setInt(1, id);
			psl.setString(2, pwd);
			rs = psl.executeQuery();
			if(rs.next())
			{
				String name =rs.getString(3);
				System.out.println("Welcome to the Bank:"+ name +",");
				return true;
			}
			else 
			{
				System.out.println("Invalid Employee Id and Password.please try again ");
			}
			
			
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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


