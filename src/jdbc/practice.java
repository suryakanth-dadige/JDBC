package jdbc;

import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class practice 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		// reigister the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// get the connectionn 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		//create statement
		Statement smt=con.createStatement();
		//execute query
//		String query="create table hotel (id int,name varchar(200),location varchar(200))";
		
		// table creation
//		smt.executeUpdate(query);
		
		System.out.println("table created succesfully");
		//accepting data at runtime
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		
		int id=sc.nextInt();
		System.out.println("enter hotel name");
		
		String name=sc.next();
		System.out.println("enter hotel location");
		String location=sc.next();
		
		//inserting data at runtime
		String query1="insert into hotel (id,name,location) values("+id+",'"+name+"','"+location+"')";
		smt.executeUpdate(query1);
		System.out.println("data inserted succesfully");
		
		// retriveing the data
		String query2="select * from hotel";
		ResultSet res=smt.executeQuery(query2);
		
		while(res.next())
		{
			System.out.println(res.getInt(1)+"  "+res.getString(2)+"  "+res.getString(3));
			
		}
		// close the connection
		con.close();
	}

}
