package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class sqlInjectionexample5
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		// 1.register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.create connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
		
		// 3.create statement object
		Statement smt=con.createStatement();
		
		//4.exicute query
			Scanner sc=new Scanner(System.in);
			System.out.println("enter roll number");
			String r=sc.next();
			System.out.println("enter name ");
			String n=sc.next();
//			System.out.println("enter marks");
//			String m=sc.next();
			
//			String query="insert into student(rollno,name,marks) values("+r+",'"+n+"',"+m+")";
//			
//			smt.executeUpdate(query);
//			
//			System.out.println("succesfully inserted");
		
			String query="select marks from student where rollno='"+r+"'and name='"+n+"'";
			ResultSet res=smt.executeQuery(query);
			
			if(res.next())
			{
				System.out.println(res.getInt(1));
			}
			else
			{
				System.out.println("please enter the correct details");
			}
		
		//5.close the connection
		con.close();
	}

}
