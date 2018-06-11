package bankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection{
	
	Connection con=null;
	Statement stmt=null;
	
	
	public Statement st(){
		
          try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			stmt=con.createStatement();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return stmt;
	} 
}