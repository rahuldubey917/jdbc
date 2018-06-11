package bankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class UserOp {
DbConnection obj=new DbConnection();
UserOp3 obj1=new UserOp3();	
public void openAccount(int a)
{//function start
try{	
Statement stmt=obj.st();
 	Scanner sc=new Scanner(System.in);
    	
  			System.out.println("enter ac Name: ");
			String c=sc.next();
			System.out.println("enter Address :");
			String d=sc.next();
			System.out.println("enter mobile number :");
		    Double l=sc.nextDouble(); 
			System.out.println("enter Balance :");
			int g=sc.nextInt();
	    
			int m=stmt.executeUpdate("insert into bank values("+a+",'"+c+"','"+d+"',"+l+","+g+")");
	        obj1.balance(a, g);	
			if (m==1)
			 System.out.println("inserted");
		 else
			 System.out.println("not inserted");
}catch(SQLException e)
{
	System.out.println(e);
}

}//function end

	public void enquiry(int a){

try { 	
	Statement stmt=obj.st();
			

	ResultSet rs=stmt.executeQuery("select *from bank where acno="+a);
			System.out.println("A/C no\t C_name\tbalamce");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(5));
			}
			
		} catch (SQLException e) {
		System.out.println(e);
		}
	}
}

