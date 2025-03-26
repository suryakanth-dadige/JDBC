package jdbc;

import java.sql.*;
import java.util.Scanner;

public class callablestatement2 
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
				CallableStatement csmt=con.prepareCall("{call p3(?)}");
				Scanner sc=new Scanner(System.in);
				System.out.println("enter product id");
				int pid=sc.nextInt();
				csmt.setInt(1, pid);
				
				
			//4.execute query
			ResultSet res=csmt.executeQuery();
			if(res.next())
			{
				System.out.println(res.getString(1));
			}
			else
			{
				System.out.println("inavalid");
			}
			//5.close the connection
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
