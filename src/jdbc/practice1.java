package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class practice1
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
            // load and register the driver
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    // get the connection 
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		    // create statement object by using prepared statement
		    String query="insert into hotel (id,name,location) values(?,?,?)";
		    PreparedStatement psmt=con.prepareStatement(query);
		    Scanner sc=new Scanner(System.in);
		    System.out.println("enter hotel id");
		    int i=sc.nextInt();
		    System.out.println("enter hotel name");
		    String n=sc.next();
		    System.out.println("enter hotel location");
		    String l=sc.next();
		    System.out.println("data inserted succesfully");
		    psmt.setInt(1, i);
		    psmt.setString(2, n);
		    psmt.setString(3, l);
		    //execute query
		    psmt.executeUpdate();
		    
		    // retriving the data from the database
		    String query1="select * from hotel";
		    ResultSet res=psmt.executeQuery(query1);
		    
		    while(res.next())
		    {
		      System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));	
		    }
	}

}
