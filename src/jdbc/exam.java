package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class exam 
{
   public static void main(String args[]) throws ClassNotFoundException, SQLException
   {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
	   Statement smt=con.createStatement();
	   String query="create table  college (id int,name varchar(200),location varchar(200),nos int)";
//	   smt.executeUpdate(query);
	   System.out.println("table created succesfully");
	   CallableStatement csmt=con.prepareCall("{call a()}");
	   Scanner sc=new Scanner(System.in);
	   System.out.println("enter id");
	   int id=sc.nextInt();
	   System.out.println("enter college name");
	   String name=sc.next();
	   System.out.println("enter location");
	   String location=sc.next();
	   System.out.println("enter no of students");
	   int nos=sc.nextInt();
	   String query2="insert into college (id,name,location,nos) values(?,?,?,?)";
	   PreparedStatement psmt=con.prepareStatement(query2);
	   psmt.setInt(1,id);
	   psmt.setString(2,name);
	   psmt.setString(3,location);
	   psmt.setInt(4,nos);
	   System.out.println("data inserted succesfully");
	   psmt.executeUpdate();
	   
	   
	   System.out.println("data retrived successfully");
	   
	   ResultSet res=csmt.executeQuery();
	   while(res.next())
	   {
		   System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4));
	   }
	   con.close();
   }
}
