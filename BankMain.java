package bankApp;

import java.sql.SQLException;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class BankMain 
{
	
	
		public static void main(String[] args)  {
			UserOp a1=new UserOp();
			UserOp1 a2=new UserOp1();
			UserOp2 a3=new UserOp2();
			UserOp3 a4=new UserOp3();
			Scanner sc=new Scanner(System.in);	
		
			
		
	
	do{
		System.out.println("want you want to do\n1-Open a New Account\n2-Account Enquiry"
		+ "\n3-Deposit"+"\n4-Withdrawl"+"\n5-Transfer"+"\n6-Mini Statement"+"\n7-Exit");
		
			int opt=sc.nextInt();
		  switch(opt){
		
		  case 1://opening a new Account
			  System.out.println("enter ac No: ");
			  int acn=sc.nextInt();
			  
			  a1.openAccount(acn);
		break;
		case 2://for account Enquiry
			  System.out.println("enter ac number");
              int acn1=sc.nextInt();    
		    
              a1.enquiry(acn1);   
	    break;
		
		case 3://for Deposit
			System.out.println("enter ac number");
            int acn2=sc.nextInt();
            
            a2.deposit(acn2);
        break;
            
		case 4://for Withdrawl
			System.out.println("enter ac number");
            int acn3=sc.nextInt();
		
            a2.withdrawl(acn3);	
            break;
            
		case 5:///for Transfer
			System.out.println("enter ac number");
            int acn4=sc.nextInt();
            
            a3.transfer(acn4);
			break;
		
		case 6://for Mini Statement
			System.out.println("enter ac number");
            int acn5=sc.nextInt();
            
			a4.miniStatement(acn5);
         break;	
	
		case 7://exit
			System.out.println("Transaction Cancelled!!! ");
			
			break;
		default:System.err.println("wrong Option!!!");
         		  }
		System.out.println("\nDo You Want To Continue (y/n):");
		
		}while(sc.next().equalsIgnoreCase("y"));
		System.out.println("ThankYou!! Visit Ag1ain");
		}

}
