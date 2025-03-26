package jdbc;

import java.sql.*;
import java.util.Scanner;

public class callablestatement4
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
			CallableStatement csmt=con.prepareCall("{call p5(?)}");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the product id ");
			int i=sc.nextInt();
			csmt.setInt(1,i);
			//4.execute statement
			ResultSet res=csmt.executeQuery();
			if(res.next())
			{
				System.out.println(res.getString(1)+"\t"+res.getString(2));
			}
			else
			{
				System.out.println("invalid");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
