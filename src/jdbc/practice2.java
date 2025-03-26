package jdbc;
import java.sql.*;
import java.util.Scanner;
public class practice2 
{
  public static void main(String args[]) 
  {
	 try 
	 {
     //load and register the driver
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  // get the connection
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
	  // create statement object by using callabale statement
	  CallableStatement csmt=con.prepareCall("{call m3(?)}");
	  Scanner sc=new Scanner(System.in);
	  System.out.println("enter hotel name");
	  String n=sc.next();
	  csmt.setString(1, n);
//	  System.out.println("proceedure called successfully");
	  //execute statement
	  ResultSet res=csmt.executeQuery();
	  if(res.next())
	  {
		  System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
	  }
	  else
	  {
		  System.out.println("please enter the correct name");
	  }
	 
		 
	  
	  // close the connection
	  con.close();
	 }
     catch(Exception e)
     {
    	System.out.println(e); 
     }
  }
}
