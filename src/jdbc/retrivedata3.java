package jdbc;

import java.sql.*;

public class retrivedata3 
{

	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		// 1.register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.get the connection
			Connection 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/working","root","root");
		//3.create statement object
			Statement smt=con.createStatement();
		//4.execute query
			ResultSet res=smt.executeQuery("select * from product");
			
			while(res.next())
			{
//				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+
//									res.getString(3)+"\t"+res.getInt(4)+"\t"+
//						res.getDouble(5)+"\t"+res.getString(6));
				
				
				
						System.out.println(res.getInt("p_id")+"\t"+res.getString("name")+"\t"+
								res.getString("brand")+"\t"+res.getInt("rating")+"\t"+
					res.getDouble("price")+"\t"+res.getString("discount"));
			}
			
		//5.close the connection
			con.close();

	}

}
