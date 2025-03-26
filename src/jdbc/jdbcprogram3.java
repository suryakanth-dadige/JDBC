package jdbc;
import java .sql .*;
public class jdbcprogram3 
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException 
	{
		//1.register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.get the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/working","root","root");
		
		// 3.create statement
		Statement smt=con.createStatement();
		
		//4.exicute query
//		smt.executeUpdate("create table books(id int,name varchar(200),price float)");
//		System.out.println("table created succesfully");
		
		
		smt.executeUpdate("insert into books(id,name,price) values(1,'classmate','50.0')");
		smt.executeUpdate("insert into books(id,name,price) values(2,'bestfriend','40.0')");
		smt.executeUpdate("insert into books(id,name,price) values(3,'bhagavan','30.0')");
		System.out.println("inserted succesfully");
		//5.close the connection
		con.close();

	}

}
