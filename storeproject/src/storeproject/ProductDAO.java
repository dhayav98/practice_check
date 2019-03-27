package storeproject;

import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
public class ProductDAO 
{
	public static Connection GetConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cogdb","root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static int SaveDetails(Product p)
	{
		int savedstatus=0;
		try
		{
			Connection con=ProductDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?)");
			System.out.println(p.getId());
			ps.setInt(1,p.getId());
			ps.setString(2,p.getCategory());
			ps.setString(3,p.getName());
			ps.setString(4,p.getDescription());
			ps.setFloat(5,p.getPrice());
			savedstatus=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return savedstatus;
	}
	public static ArrayList GetDetails()
	{
		ArrayList<Product> list=new ArrayList<Product>();
		try
		{
			Connection con=ProductDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select * from product");
			//ps.setString(1,Category);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setCategory(rs.getString(3));
				p.setDescription(rs.getString(4));
				p.setPrice(rs.getFloat(5));
				list.add(p);
			}			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public static int UpdateDetails(Product p)
	{
		int updatestatus=0;
		try
		{
			Connection con=ProductDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("update product set category=?,name=?,description=?,price=? where product_id=?");
			ps.setString(1,p.getCategory());
			ps.setString(2,p.getName());
			ps.setString(3,p.getDescription());
			ps.setFloat(4,p.getPrice());
			ps.setInt(5,p.getId());
			updatestatus=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return updatestatus;
	}
	public static int DeleteProduct(int id)
	{
		int delstatus=0;
		try
		{
			Connection con=ProductDAO.GetConnection();
			
			PreparedStatement ps=con.prepareStatement("delete from product where product_id=?");
			ps.setInt(1,id);
			delstatus=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return delstatus;
	}
	public static ArrayList ViewProduct(int pid)
	{
		ArrayList<Product> list1=new ArrayList<Product>();
		try
		{
			Connection con=ProductDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select * from product where product_id=?");
			ps.setInt(1,pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setCategory(rs.getString(3));
				p.setDescription(rs.getString(4));
				p.setPrice(rs.getFloat(5));
				list1.add(p);
			}			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list1;
	}

}

