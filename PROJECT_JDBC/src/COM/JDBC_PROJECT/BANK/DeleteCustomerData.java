package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCustomerData {
	
	
	public static void deleteCustomerData()
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps5 =null;
		String UnQuery = "DELETE FROM customer where AccNumber=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
			ps5 = con.prepareStatement(UnQuery);
			System.out.println("Enter customer Acoount Number");
			int  a = sc.nextInt();
			ps5.setInt(1, a);
			
			System.out.println("Do You want to change the Customer Email if Yes Enter YES otherWise Enter NO");
			String confirm = sc.next();
			if(confirm.equalsIgnoreCase("yes"))
			{
				int p =ps5.executeUpdate();
				if(p>=1)
				{
					System.out.println("Customer Details Deleted Successfully");
				}
				else
				{
					System.out.println("Unable to change the Customer Name");
				}
				
			}
			      
			
		} catch (ClassNotFoundException | SQLException e) 
		{
		
			e.printStackTrace();
		}
		
	}


}
