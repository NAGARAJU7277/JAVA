package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangePin {
	
	public static void PinUpdate(int id, int pwd)
	{
	
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	PreparedStatement ps9 = null;
	PreparedStatement ps10 = null;
	ResultSet rs = null;
	
	String pinQuery = "UPDATE CUSTOMER SET Pin =  ? WHERE AccNUmber = ? And Pin=?";
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
		ps9 = con.prepareStatement(pinQuery);
		System.out.println("Enter the Account Number");
		int acc = sc.nextInt();
		ps9.setInt(2, acc);
		System.out.println("Enter Your old pin");
		int pin = sc.nextInt();
		ps9.setInt(3, pin);
		ps10 = con.prepareStatement("SELECT Pin FROM CUSTOMER WHERE AccNumber=?");
		ps10.setInt(1, id);
		rs = ps10.executeQuery();
		int p=0;
		if(rs.next())
		{
			 p =rs.getInt(1);		
		}
		System.out.println("Enter Your New pin");
		int Newpin = sc.nextInt();
		ps9.setInt(1, Newpin);
		if(id==acc && pin==pwd && pin==p)
		{
			int n =ps9.executeUpdate();
			if(n>=1)
			{
				System.out.println("Pin changed Successfully");
			}
			else
			{
				System.out.println("Unable to change the pin please tray again");
			}
		}
		else
		{
			System.out.println("Your Entered Incorrect pinand the Account NUmber");
		}
		
		
	} catch (ClassNotFoundException | SQLException e) {
	
		e.printStackTrace();
	}
	
	}
	
	
	
}