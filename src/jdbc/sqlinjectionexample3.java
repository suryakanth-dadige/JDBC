package jdbc;
import java.sql.*;
import java.util.Scanner;
public class sqlinjectionexample3
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		// 1.register the driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.get the connection
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/working","root","root");
		
		//3.create statement object
		
		Statement smt=con.createStatement();
		
		//4.execute query
		Scanner sc=new Scanner(System.in);
		System.out.println("enter user name");
		String uname=sc.next();
		System.out.println("enter password");
		String pwd=sc.next();
		
		
		String query="select balance from bankbalance where username='"+uname+"' and password='"+pwd+"'";
		ResultSet res=smt.executeQuery(query);
		System.out.println(query);
		
		if(res.next())
		{
			System.out.println("balancde is "+res.getInt(1));
		}
		else
		{
			System.out.println("inavalid credentials");
		}
		//5.close the connection
		
		
	}

}
