package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddingNewCustomer {
	
	public static void addNewCustomer()
	{
		Scanner sc = new Scanner(System.in);
		Connection con= null;
		PreparedStatement ps2 =null;
		String addQuery = "INSERT INTO customer(CustomerName, PhoneNumber, CustomerEmail) VALUES(?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
			ps2 = con.prepareStatement(addQuery);
			System.out.println("Enter the Customer Name:");
			String name = sc.next();
			ps2.setString(1, name);
			System.out.println("Enter the customer phone Number:");
			String phone = sc.next();
			ps2.setString(2, phone);
			System.out.println("Enter the Customer Mail Id");
			String Email = sc.next();
			ps2.setString(3, Email);
			
			int t = ps2.executeUpdate();
			if(t>=1)
			{
				System.out.println("Customer data added Successfullt");
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps2!=null)ps2.close();
				if(con!=null)con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	
		
	}

}
