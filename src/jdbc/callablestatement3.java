package jdbc;

import java.sql.*;
import java.util.Scanner;

public class callablestatement3
{

	public static void main(String[] args) 
	{
		try
		{
			//1.register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.create the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			// 3.create the statement object by using callabale statement
				CallableStatement csmt=con.prepareCall("{call p4(?)}");
				Scanner sc=new Scanner(System.in);
				System.out.println("enter product name");
				String pn=sc.next();
				csmt.setString(1, pn);
				
			//4. execute query
				ResultSet res=csmt.executeQuery();
				if(res.next())
				{
					System.out.println(res.getInt(1)+"\t"+res.getInt(2));
				}
				else
				{
					System.out.println("invalid");
				}
			//5. close the connection
				con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
