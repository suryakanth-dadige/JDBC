package jdbc;
import java.sql.*;
import java.util.Scanner;
public class sqlInjectionexample4
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		
		//1.register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.get the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
		
		//3.create statement object
		Statement smt=con.createStatement();
		
		//4.exicuteQuery
		
//		smt.executeUpdate("insert into product(pid,pname,price,is_available) values (100,'tv',3000,true)");
		
		Scanner sc=new Scanner(System.in);
//		System.out.println("enter product id");
//		String id=sc.next();
//		System.out.println("enter product name");
//		String name=sc.next();
//		System.out.println("enter product price");
//		String price=sc.next();
		
		
//		String query="insert into product(pid,pname,price) values("+id+",'"+name+"','"+price+"')";
		
//		smt.executeUpdate(query);
		
//		System.out.println("inserted succesfully");
		
		System.out.println("enter product id");
		String id=sc.next();
		
		System.out.println("enter product price");
		String price=sc.next();
		
		String query="select pname from product where pid='"+id+"'and price='"+price+"'";
		
		ResultSet res=smt.executeQuery(query);
		
		if(res.next())
		{
			System.out.println(res.getString(1));
		}
		else
		{
			System.out.println("please enter the correct deatils");
		}
		
		//5.close the connection
		con.close();
	}

}
