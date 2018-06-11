package bankApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserOp3 {
	DbConnection obj=new DbConnection();
	public void debit(int a,int b)
	           {
		Statement stmt=obj.st();
	try{	
    stmt.executeUpdate("insert into record(acno,debit) values("+a+","+b+")"); 
       }catch(SQLException e)
	{
		System.out.println(e);
	}
	           
	           }

	public void balance(int a,int b)
    {
Statement stmt=obj.st();
try{	
stmt.executeUpdate("insert into record(acno,balance) values("+a+","+b+")"); 
}catch(SQLException e)
{
System.out.println(e);
}
    
    }

public void credit(int a,int b)
{
Statement stmt=obj.st();
try{	
stmt.executeUpdate("insert into record(acno,credit) values("+a+","+b+")"); 
}catch(SQLException e)
     {
       System.out.println(e);
     }
}
	
public void miniStatement(int a){
	Statement stmt=obj.st();
	try{	
   System.out.println("ACNO\tDEBIT\tCREDIT\tBALANCE"); 
   ResultSet rs = stmt.executeQuery("select *from record where acno="+a);
   while(rs.next())
    {   
    System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
    }
	
	}catch(SQLException e)
	{
		System.out.println(e);
	}
                               }
}