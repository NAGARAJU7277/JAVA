package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewCustomerDetails {
	
	public static void viewDetails() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps6 =null;
		ResultSet rs = null;
		String UnQuery = "SELECT * FROM customer where AccNumber = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
			ps6 = con.prepareStatement(UnQuery);
			System.out.println("Enter customer Acoount Number");
			int  a = sc.nextInt();
			ps6.setInt(1, a);
			rs = ps6.executeQuery();
			while(rs.next()==true)
			{
				System.out.println("Account Number Of the Customer :" + rs.getInt(1));
				System.out.println("AccountHolderName is:" +rs.getString(2));
				System.out.println("Account HOlder Mobile NUmber :" +rs.getString(3));
				System.out.println("AccountHolder E MailId" + rs.getString(4));
				System.out.println("Account balance:" + rs.getInt(6));
		
				
			}
			      
			
		} catch (ClassNotFoundException | SQLException e) 
		{
		
			e.printStackTrace();
		}

	}

}
