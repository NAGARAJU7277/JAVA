import java.util.*;
public class Groom {

    public static void main(String args[])
    {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the Maximum Boxes Size");
      int n = sc.nextInt();
      int b[]  =  new int[n];
      for(int i=0;i<=n-1;i++)
      {
        b[i] = sc.nextInt();
      }
     System.out.println("Enter pawan's number");
     int p = sc.nextInt();
     System.out.println("Ente karthi number");
     int k = sc.nextInt();
     int pc=0,kc=0;
     for(int j=0;j<=n-1;j++)
     {
        if(b[j]==p)
        {
            pc++;
        }
       
     }
     for(int j=n-1;j>=0;j--)
     {
        if(b[j]==k)
        {
            kc++;
        }
     }
      if((pc>1 && kc<1) || (pc<1 && kc>1 ))
     {
        System.out.println("Invalid game");
     }
     else if(pc>kc)

     {
        System.out.println("pawan win the game");
     }
     else if(kc>pc)
     {
        System.out.println("karthi wins game");
     }
     else if(pc==kc)
     {
        System.out.println("Draw");

     }
     
     else
     {
        System.out.println("invalid inputs");
     }

    }
    
}
