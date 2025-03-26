package jdbc;
import java.sql.*;
public class retrivedata2 
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		//1.register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.get the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/working","root","root");
		
		//3.create statemnt object
		Statement smt=con.createStatement();
		
		//4.exicute query
		ResultSet res=smt.executeQuery("select * from books");
		
		while(res.next())
		{
//			System.out.println(res.getInt(1));
//			System.out.println(res.getString(2));
//			System.out.println(res.getDouble(3));
			
			
			System.out.println(res.getInt(1)+"  "+res.getString(2)+"  "+res.getDouble(3));
		}
		//5.close the connection
		con.close();
	}

}
