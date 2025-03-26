package jdbc;
import java.sql.*;
import java.util.*;
public class preparedstatement2 
{

	public static void main(String[] args)
	{
		
		try
		{
			//1.register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.create the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			
			//3.create the statement object by using prepared statement
			
				Scanner sc=new Scanner(System.in);
				System.out.println("enter the product id");
				String pid=sc.next();
				System.out.println("enter product price");
				String pirce=sc.next();
				String query="select pname from product where pid=? and price=?";
				PreparedStatement psmt=con.prepareStatement(query);
				
				psmt.setString(1,pid);
				psmt.setString(2, pirce);
				
			//4.execute query
				ResultSet res=psmt.executeQuery();
				if(res.next())
				{
					System.out.println(res.getString(1)); 
				}
				else
				{
					System.out.println("invalid credentials");
				}
				
			//5.close the connection
				con.close();
				
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
