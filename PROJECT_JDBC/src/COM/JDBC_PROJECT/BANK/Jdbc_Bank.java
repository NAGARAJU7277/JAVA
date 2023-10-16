package COM.JDBC_PROJECT.BANK;

import java.util.*;

public class Jdbc_Bank {

	public static void main(String[] args) {
		
		int option =0;
		
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("Select option:");
			System.out.println("1.LogIn in Employee Page");
			System.out.println("2.LogIn in Customer Page");
			System.out.println("3.Exit the Appliaction");
			option=sc.nextInt();
			
			switch(option)
			{
			case 1:
				EmployeeInterface.showEmployeeLogIn();
				break;
			case 2:
				CustomerLoginPage.showCustomerLogIn();
				break;
			case 3:
				System.out.println(" (: == Thank You Visit again == :) ");
				break;
			default:
				System.out.println("Invalid Choice. Please select again");
			}
		}
		while(option!=3); // until and unless the option is equal to 3 the loop will continue.
		
	}
		

	}


