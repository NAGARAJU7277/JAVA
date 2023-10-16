package COM.JDBC_PROJECT.BANK;

import java.util.*;
public class CustomerLoginPage {
	int id,pwd;
	
	public static void showCustomerLogIn()
	{
		
		CustomerLoginPage c = new CustomerLoginPage();
		Scanner sc = new Scanner(System.in);
		CustomerLogInValidation e1 = new CustomerLogInValidation();
		boolean login = false;
		int attempts =0;
		System.out.println("<===Customer Interface===>");
		System.out.println("Welcome to New Bank");

		while(!login && attempts<3)
		{
			System.out.println("Enter You Account Number:");
		    c.id = sc.nextInt();
			System.out.println("Ente Your Pin");
			c.pwd = sc.nextInt();

			if(e1.cusloginValidation(c.id,c.pwd))
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
			System.out.println("1.View You Account Balance");
			System.out.println("2.Deposit Money");
			System.out.println("3.WithDraw Money");
			System.out.println("4.Change Pin");
			System.out.println("5.GoBack To Employye and Customer LogIn page:");

			 
			
			
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				ViewAccountBalance.balance(c.id);
				break;
			case 2:
	            AmountTransction.Deposit(c.id);
				break;
			case 3:
				AmountTransction.WithDraw(c.id,c.pwd);
				break;
			case 4:
				ChangePin.PinUpdate(c.id,c.pwd);
				break;
			case 5:
				//System.out.println("Employee and Customer LogIn page");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		while(choice!=5);
	}

	
	
}

