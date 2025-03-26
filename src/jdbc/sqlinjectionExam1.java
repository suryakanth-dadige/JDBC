package jdbc;

import java.sql.*;
import java.util.*;
public class sqlinjectionExam1
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException 
	{
		
		Scanner sc=new Scanner(System.in);
		//1.register the driver manager
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.get the connection
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/working","root","root");
		
		//3.create statement object
		Statement smt=con.createStatement();
		
		// 4.execute query
					//			smt.executeUpdate("insert into books values(4,'book',80)");
					//			System.out.println("inserted succesfully");
								
					//		  ResultSet res=smt.executeQuery("select * from books");
					//		  
					//		  while(res.next())
					//		  {
					//			  System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getDouble(3));
					//		  }
							
			System.out.println("enter book id");
			String id=sc.next();
			System.out.println("enter book name");
			String name=sc.next();
			System.out.println("enter book price");
			String price=sc.next();
			
			String query ="insert into books(id,name,price) values("+id+",'"+name+"',"+price+")";
		
			smt.executeUpdate(query);
			System.out.println("inserted succesfully");
		   //5.close the connection
			con.close();
			
   	}

}
