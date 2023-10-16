package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateCustomerData {
	
	public static void updateCustomerName()
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps3 =null;
		String UnQuery = "UPDATE  customer set CustomerName =? WHERE AccNumber=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
			ps3 = con.prepareStatement(UnQuery);
			System.out.println("Enter customer Acoount Number");
			int  a = sc.nextInt();
			ps3.setInt(2, a);
			System.out.println("Enter Customer Name");
			String name = sc.next();
			ps3.setString(1, name);
			System.out.println("Do You want to change the Customer Name if Yes Enter YES otherWise Enter NO");
			String confirm = sc.next();
			if(confirm.equalsIgnoreCase("yes"))
			{
				int p =ps3.executeUpdate();
				if(p>=1)
				{
					System.out.println("Customer Name changed Successfully");
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

public static void updateCustomerPhone()
{
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	PreparedStatement ps4 =null;
	String UnQuery = "UPDATE  customer set phoneNumber =? WHERE AccNumber=?";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
		ps4 = con.prepareStatement(UnQuery);
		System.out.println("Enter customer Acoount Number");
		int  a = sc.nextInt();
		ps4.setInt(2, a);
		System.out.println("Enter Customer mobile Number");
		String name = sc.next();
		ps4.setString(1, name);
		System.out.println("Do You want to change the Customer mobile Number if Yes Enter YES otherWise Enter NO");
		String confirm = sc.next();
		if(confirm.equalsIgnoreCase("yes"))
		{
			int p =ps4.executeUpdate();
			if(p>=1)
			{
				System.out.println("Customer Phone number changed Successfully");
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
public static void updateCustomerEmail()
{
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	PreparedStatement ps5 =null;
	String UnQuery = "UPDATE  customer set CustomerEmail =? WHERE AccNumber=?";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
		ps5 = con.prepareStatement(UnQuery);
		System.out.println("Enter customer Acoount Number");
		int  a = sc.nextInt();
		ps5.setInt(2, a);
		System.out.println("Enter Customer Email Number");
		String name = sc.next();
		ps5.setString(1, name);
		System.out.println("Do You want to change the Customer Email if Yes Enter YES otherWise Enter NO");
		String confirm = sc.next();
		if(confirm.equalsIgnoreCase("yes"))
		{
			int p =ps5.executeUpdate();
			if(p>=1)
			{
				System.out.println("Customer Email changed Successfully");
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
