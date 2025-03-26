package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class practice3 
{

	public static void main(String[] args) 
	{
      try {
		// load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
		// create statement object by using callable statement
		
		CallableStatement csmt=con.prepareCall("{call k2(?)}");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter hotel id");
		int i=sc.nextInt();
		csmt.setInt(1, i);
		// execute query
		ResultSet res=csmt.executeQuery();
		if(res.next())
		{
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
		}
		else
		{
			System.out.println("invalid");
		}
		// close the connection 
		con.close();
      }
      catch(Exception e)
      {
    	  System.out.println(e);
      }
	}

}
