package jdbc;
import java.sql.*;
import java.util.*;
public class sqlInjectionexample6
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		//1.register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.create the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
		//3.create statement object
		Statement smt=con.createStatement();
		//4.exicute query
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter product id");
		String i=sc.next();
//		System.out.println("enter product name");
//		String n=sc.next();
		System.out.println("enter product price");
		String p=sc.next();
		
//		smt.executeUpdate("insert into product(pid,pname,price) values ("+i+",'"+n+"',"+p+")");
//		System.out.println("inserted succesfully");
		
		
		String query="select pname from product where pid='"+i+"'and price='"+p+"'";
		ResultSet res=smt.executeQuery(query);
		if(res.next())
		{
			System.out.println(res.getString(1));
		}
		else
		{
			System.out.println("inavlid credentials");
		}
		
		//5.close the connection
		con.close();
	}

}
