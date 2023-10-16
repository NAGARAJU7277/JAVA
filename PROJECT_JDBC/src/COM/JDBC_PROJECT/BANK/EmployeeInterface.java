package COM.JDBC_PROJECT.BANK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
public class EmployeeInterface {

	public static void showEmployeeLogIn()
	{
		Scanner sc = new Scanner(System.in);
		EmploeeLogInvalidation e1 = new EmploeeLogInvalidation();
		boolean login = false;
		int attempts =0;
		System.out.println("<===Employee Interface===>");
		System.out.println("Welcome to New Bank");

		while(!login && attempts<3)
		{
			System.out.println("Enter the Employee ID");
			int id = sc.nextInt();
			System.out.println("Ente the password");
			String pwd = sc.next();

			if(e1.loginValidation(id,pwd))
			{
				System.out.println("Login Successful");
				login = true;
			}
			else
			{
				attempts++;
				System.out.println("Login Failed , Please Try again ");
			}

		}
		if(attempts>=3)
		{
			System.out.println("Max login Attemps Reached. Existing");
			return;
		}


		int choice=0;
		do{
			System.out.println("Select option");
			System.out.println("1.Add a customer data");
			System.out.println("2.Update a Customer data");
			System.out.println("3.Delete Customer Data");
			System.out.println("4.view Customer Data");
			System.out.println("5.GoBack To Employye and Customer LogIn page:");

			 
			
			
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				AddingNewCustomer.addNewCustomer();
				break;
			case 2:
				UpdateCustomer();
				break;
			case 3:
				DeleteCustomerData.deleteCustomerData();
				break;
			case 4:
				ViewCustomerDetails.viewDetails();
				break;
			case 5:
				System.out.println("Employee and Customer LogIn page");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		while(choice!=5);


	}



	public static void UpdateCustomer()
	{
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do 
		{
			System.out.println("Enter the option to update:");
			System.out.println("1.update Customer Name");
			System.out.println("2.Update Mobile Number");
			System.out.println("3.update Emailid Of customer:");

			System.out.println("4.Exit");

			option = sc.nextInt();
			switch(option)
			{
			case 1:
				UpdateCustomerData.updateCustomerName();
				break;
			case 2:
				UpdateCustomerData.updateCustomerPhone();
				break;
			case 3:
				UpdateCustomerData.updateCustomerEmail();
				break;
			case 4:
				break;

			default:
				System.out.println("Invalid option select again");
				break;
			}
		}
		while(option!=4);

	} 

}
