import java.io.Console;
import java.util.*;

public class Atm 
{
  private static String username = "vikram";
  private static String password = "123456";
  private static double balance = 50000;
  private static ArrayList<String > transHistory = new ArrayList<String>();

  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);

    System.out.println("enter the username : ");
    String inputuser = sc.nextLine();

    Console console = System.console();
    String inputpasswd;

    if(console == null)
    {
       System.out.println("console is not working .please enter your password :");
       inputpasswd = sc.nextLine(); 
    }
    else
    {
        char [] passwdArray = console.readPassword("enter password :");
        inputpasswd = new String(passwdArray);
    }

    if(inputuser.equals(username) && inputpasswd.equals(password))
    {
        System.out.println("Login Successful ");
        boolean quit = false;
        while(!quit)
        {
            System.out.println("1.Transcation History :");
            System.out.println("2.Withdraw");
            System.out.println("3.Transfer ");
            System.out.println("4.Deposit");
            System.out.println("5.Quit");


            System.out.println("Select your choice :");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1 : transHistory();
                         break;
                case 2 : withdraw();
                         break;
                case 3 : transfer();
                         break;
                case 4 : deposit();
                         break;
                case 5 : quit = true;
                         System.out.println("Thanks for visiting ...!!");
                         break;
                    default:
                     System.out.println("Invalid option . please try again ");
            }
        }
    }
    else
    {
      System.out.println("Invalid Username or Password .. please re-enter login credentials ");
    }
  }

  private static void deposit()
  {
    System.out.println("Enter the amount to deposit :");
    Scanner sc = new Scanner(System.in);

    double amount = sc.nextDouble(); 
    balance = balance + amount;

    System.out.printf("Deposited amount %.2f\n",amount);
    System.out.printf("balance amount %.2f\n",balance);

  }

  private static void transHistory()
  {
    System.out.println("Transcation history :");
    if(transHistory.size() == 0 )
    {
        System.out.println("NO Transcations are performed ");
    }
    else
    {
        for(String x:transHistory)
        {
            System.out.println(x);
        }
    }
  }

  private static void transfer()
  {
    System.out.println("enter the account to transfer :");
    Scanner sc = new Scanner(System.in);
    String accnum = sc.nextLine();

    System.out.println("enter the amount to transfer :");
    double amount = sc.nextDouble();

    if(amount > balance)
    {
        System.out.println("Money is insufficient ..please try again ");
    }
    else
    {
        balance = balance - amount;
        System.out.printf("Transferred %.2f to account %s",amount,accnum);
        System.out.printf("Available amount : %.2f\n",balance);
    }

  }

  private static void withdraw()
  {
    System.out.println("enter the amoutn to withdraw :");
    Scanner sc = new Scanner(System.in);
    double amount = sc.nextDouble();

    if(amount>balance)
    {
        System.out.println("Insufficient amount to withdraw ..please try again");    
    }
    else
    {
        balance = balance - amount;
        String trans = String.format("withdraw amount %.2f \n.Available balance : %.2f",amount,balance);
        transHistory.add(trans);
        System.out.println(trans);
    }
  }
}