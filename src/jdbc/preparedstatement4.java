package jdbc;

import java.sql.*;
import java.util.Scanner;

public class preparedstatement4 
{

	public static void main(String[] args) 
	{
		try {
			//1.register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.create connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			//3.create statement object by using prepared statement
			Scanner sc=new Scanner(System.in);
			System.out.println("enter product id");
			String id=sc.next();
			System.out.println("enter product name");
			String name=sc.next();
			System.out.println("enter product price");
			String price=sc.next();
			String query="insert into product(pid,pname,price) values(?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
				psmt.setString(1,id);
				psmt.setString(2, name);
				psmt.setString(3,price);
				
				System.out.println("succesfully inserted");
				
			//4.excecute query
				psmt.executeUpdate();
				
			//5.close the connection
				con.close();
				
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
