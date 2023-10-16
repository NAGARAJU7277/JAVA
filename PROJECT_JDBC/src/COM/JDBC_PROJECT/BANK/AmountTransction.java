package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AmountTransction {
	
	static float BankBalance;
	
	public static void Deposit(int id)
	{
		
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		
		PreparedStatement ps5 = null;
		ResultSet rs = null;
		String Depo = "UPDATE CUSTOMER SET AccBalance = ? WHERE AccNumber=?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
			ps5 = con.prepareStatement(Depo);
			PreparedStatement ps6 = con.prepareStatement("SELECT AccBalance FROM CUSTOMER WHERE AccNumber=?");
			System.out.println("Enter Your Account Number:");
			int num= sc.nextInt();
			ps5.setInt(2, num);
			if(id == num)
			{
				ps6.setInt(1, id);
				rs = ps6.executeQuery();
				if(rs.next())
				{
				   BankBalance = (rs.getFloat(1));
				}
			System.out.println("Enter the Amount You Want to Deposit");
			float Deposit = sc.nextFloat();
			BankBalance = BankBalance+Deposit;
			ps5.setFloat(1,BankBalance);
			
			int n = ps5.executeUpdate();
			if(n>=1)
			    { 
				System.out.println("Amount added Successfully" + Deposit);
				System.out.println("Your Bank Balance is:" + BankBalance);
			    }
			}
			else 
			{
				System.out.println("Invalid Account Number Please Try Again");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void WithDraw(int id, int pwd)
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		
		PreparedStatement ps7 = null;
		ResultSet rs = null;
     	String widr = "UPDATE CUSTOMER SET AccBalance = ? WHERE AccNumber=? And Pin =?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?" + "user=root&password=tiger123");
			ps7 = con.prepareStatement(widr);
		    PreparedStatement ps8 = con.prepareStatement("SELECT AccBalance FROM CUSTOMER WHERE AccNumber=?");
		    
		    System.out.println("Enter Your Account Number:");
			int num= sc.nextInt();
			ps7.setInt(2, num);
			System.out.println("Enter Your Pin");
			int pin = sc.nextInt();
			ps7.setInt(3, pin);
			if(id == num && pin==pwd)
	           {
				ps8.setInt(1, id);
				rs = ps8.executeQuery();
				if(rs.next())
				{
				   BankBalance = (rs.getFloat(1));
				}
			System.out.println("Enter the Amount You Want to Withdraw");
			float WithDraw = sc.nextFloat();
			if(BankBalance+300>WithDraw)
		         {
			
			BankBalance = BankBalance-WithDraw;
			ps7.setFloat(1,BankBalance);
			
			int n = ps7.executeUpdate();
			if(n>=1)
			    { 
				System.out.println("Amount WithDraw Successfully"+ WithDraw);
				System.out.println("Your Bank Balance is:" + BankBalance);
			    }
		          }
			else
			{
				System.out.println("You Account has insufficient Balance try with Different Amount");
			}
   }
			else 
			{
				System.out.println("Invalid Account Number and pin Please Try Again");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
