package jdbc;

import java.sql.*;
import java.util.Scanner;

public class callablestatement1
{

	public static void main(String[] args) 
	{
		try 
		{
			//1.register the driver
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 //2.create the connection
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			 
			 //3.create the statement object by using callable statement
			 CallableStatement csmt=con.prepareCall("{call p2()}");//dont return any type of value just call  the proceedure 
			 System.out.println("proceedure called succesfully");
			 //4.execute statement
			 csmt.execute();
			 //5.close the connection
			 con.close();
			 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
