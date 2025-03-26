package jdbc;

import java.sql.*;

public class jdbcprogram1 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// 1.register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2.get connection
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/working","root","root");
		
		//3.create statement object
		
		Statement smt=con.createStatement();
		
		// 4.exicute query
		smt.executeUpdate("insert into mytable(id,name) values(11,'kanth')");
		smt.executeUpdate("insert into mytable(id,name) values(12,'dadige')");
		System.out.println("inserted succesfully");
		  
		//5.close the connection
		
		con.close();
		
	}

}
