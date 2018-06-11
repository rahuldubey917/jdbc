package bankApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserOp1 {
DbConnection obj=new DbConnection();
	Scanner sc=new Scanner(System.in);
UserOp3 obj1=new UserOp3();	
public void deposit(int a)
	{
		try{
		Statement stmt=obj.st();
		ResultSet rs=stmt.executeQuery("select balance from bank where acno="+a);
		System.out.println("enter amount to be deposited");
		int dmoney=sc.nextInt();
		while(rs.next())
		{
			int b=rs.getInt(1);
			int fmoney=b+dmoney;
			int m=stmt.executeUpdate("Update bank set balance="+fmoney+" where acno="+a);
			obj1.credit(a, fmoney);
			if(m==1)
				System.out.println(dmoney+"$ are added to \n account number = "+a+"\n"
						+ "new balance = "+fmoney);
			else
				System.out.println("balance updated");
		}
		
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	public void withdrawl(int b)
	{
		try{
		Statement stmt=obj.st();
	    ResultSet rs=stmt.executeQuery("select balance from bank where acno="+b);
		System.out.println("enter amount to be withdrawl");
		int wMoney=sc.nextInt();
		while(rs.next())
		{
			int c=rs.getInt(1);
			int fmoney=c-wMoney;
			int m=stmt.executeUpdate("Update bank set balance="+fmoney+" where acno="+b);
			obj1.debit(b, wMoney);
			if(m==1)
				{System.out.println(wMoney+"$ is withdrawl from \n account number = "+b+"\n"
						+ "new balance = "+fmoney);
				}else
				System.err.println("Transaction Faild!!!!");
		}
		
		}catch(SQLException e)
		{System.out.println(e);}
		
	}
		
}


