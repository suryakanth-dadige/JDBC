package jdbc;
import java.sql.*;
import java.util.Scanner;
public class preparedStatement5
{
   public static void main(String args[]) throws SQLException, ClassNotFoundException
   {
	   //load and register the driver
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   // get the connection
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
	   //create statement object by using prepared statement
	   Scanner sc=new Scanner(System.in);
	   System.out.println("enter hotel id");
	   int i=sc.nextInt();
	   System.out.println("enter hotel name");
	   String n=sc.next();
	   System.out.println("enter hotel location");
	   String l=sc.next();
	   String query="insert into hotel (id,name,location) values(?,?,?)";
	   PreparedStatement psmt=con.prepareStatement(query);
	   psmt.setInt(1, i);
	   psmt.setString(2, n);
	   psmt.setString(3, l);
	   
	  //execute query
	   psmt.executeUpdate();
	   //close the connection
	   con.close();
   }
}
