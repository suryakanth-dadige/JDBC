package jdbc;

import java.sql.*;
import java.util.Scanner;

public class preparedstatement3 
{

	public static void main(String[] args)
	{
		try
		{
			//1.register the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.create the connection
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
				
			// 3.create the statement object by using prepared statement
				
				Scanner sc=new Scanner(System.in);
				System.out.println("enter student rollnumber");
				String rollno=sc.next();
				System.out.println("enter Student marks");
				String marks=sc.next();
				String query="select name from student where rollno=? and marks=?";
				
				PreparedStatement psmt=con.prepareStatement(query);
				
				psmt.setString(1, rollno);
				psmt.setString(2, marks);
			//4.execute query
				ResultSet res=psmt.executeQuery();
			
				if(res.next())
				{
					System.out.println(res.getString(1));
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
