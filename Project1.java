import java.util.Scanner;
class Project1 
{
 public static void main(String[] args)
 {
   Scanner scan = new Scanner(System.in);
   int pin = 1234,c=0,AB=5000;
   int AVB;
   
   for(int i=1;i<=3;i++)
   {
     System.out.println("Enter Your Four Digit Pin:");
     int epin = scan.nextInt();
     if(epin==pin)
     {
       System.out.println("crea new Account");
       System.out.println("----Availeble options--- ");
       System.out.println("1 Deposit");
       System.out.println("2 Account Balance");
       System.out.println("3 With Draw");
       System.out.println("4 Exit");
       System.out.println("Choose Your Option");
       int choice = scan.nextInt();
       switch(choice)
       {
         case 1:
         System.out.println("Enter The Depositing Amount:");
         int D = scan.nextInt();
         System.out.println("Your Deposited Amount is" + D);
         AVB = AB+D;
         System.out.println("Total Avilable Balanc In Your Account is:" + AVB);
         break;
         case 2:
         System.out.println("Availeble Balance in Your Account is:"+ AB);
         case 3:
         System.out.println("Enter with Draw Amount:");
         int w = scan.nextInt();
         System.out.println("Your withdrawal Amount is:" + w);
         AVB = AB-w;
         System.out.println("Total Avilable Balance In your Account is:" + AVB);
         break;
         case 4:
         System.out.println("---------@ Thank You Visit Again @-------");
         break;
         default:
         System.out.println("You entered in corect Choice");
         break;

       }

      break;

     }
     else if(c==2)
     {
        System.out.println("contact Bank Manager:");
     }
     else
     {
       System.out.println("you Entered invalid pin");
       c++;
     }
    }
 }    }
