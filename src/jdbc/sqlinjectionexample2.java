package jdbc;
import java .sql.*;
import java.util.*;
public class sqlinjectionexample2 
{

	public static void main(String[] args)throws ClassNotFoundException,SQLException
	
	{
		// 1.register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.get the connection
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/working","root","root");
		
		//3.create statement object
		
		Statement smt=con.createStatement();
		
		//4.execute Query
		
//		Scanner sc=new Scanner(System.in);
//		
//		System.out.println("eneter user name");
//		String uname=sc.next();
//		System.out.println("enter password");
//		String pwd=sc.next();
//		
//		String query="select * from bankbalance";
//		ResultSet res=smt.executeQuery(query);
//		while(res.next())
//		{
//			System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getInt(3));
//			
//		}
		// connection close
		con.close();
	}

}
