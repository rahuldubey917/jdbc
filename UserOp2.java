package bankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.net.aso.s;

public class UserOp2 {
	DbConnection obj=new DbConnection();
	Scanner sc=new Scanner(System.in);
	UserOp3 obj1=new UserOp3();
	
	//Method for Transferring money to one account to another
	public void transfer(int b){
try{
	Statement stmt=obj.st();
		
	    ResultSet rs=stmt.executeQuery("select balance from bank where acno="+b);
	System.out.println("enter amount to be transfer");
	int tMoney=sc.nextInt();
	while(rs.next())
	{
		int c=rs.getInt(1);
		int fmoney=c-tMoney;
		
		stmt.executeUpdate("Update bank set balance="+fmoney+" where acno="+b);
        obj1.debit(b, fmoney);
		System.out.println("A/C no of benificery :");
		int vbac=sc.nextInt();
        rs=stmt.executeQuery("select balance from bank where acno="+vbac);
		      while(rs.next())
		      {
		    	  int c1=rs.getInt(1);
		    	  int dmoney=c1+tMoney;
		  		  int m=stmt.executeUpdate("Update bank set balance="+dmoney+" where acno="+vbac);
		  		  obj1.credit(vbac, dmoney);
		  		  if(m==1)
		    	  System.out.println(tMoney+" is Transferred from\n acno :"+b+" to acno :"
		    	  +vbac);
		      }
	}
}catch(SQLException e)
    {
	System.out.println(e);
	}
}
}
