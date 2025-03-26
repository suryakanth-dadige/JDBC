package jdbc;

import java.sql.*;
import java.util.*;
public class preparedstatement1
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		//1.register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.create the connection
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
		
		//3.create the statement object
		// preparedstatement
		Scanner sc=new Scanner(System.in);
		System.out.println("enter product id");
		String id=sc.next();
		System.out.println("enter product name");
		String n=sc.next();
		System.out.println("enter product price");
		String p=sc.next();
		
		
		String query="insert into product(pid,pname,price) values(?,?,?)";
		
		PreparedStatement psmt=con.prepareStatement(query);
		psmt.setString(1,id);
		psmt.setString(2,n);
		psmt.setString(3,p);
		System.out.println("inserted succesfully");
		//4.execute statement
			
		psmt.executeUpdate();
		
		//5.close the connection
		con.close();
		
		
		

	}

}
