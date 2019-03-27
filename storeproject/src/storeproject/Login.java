package storeproject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count=0;
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int flag=0;
		Connection con=null;
		PreparedStatement ps;
		String user=request.getParameter("id");
		String password=request.getParameter("pass");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cogDB", "root","root");	
			}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		try 
		{
			HttpSession session=request.getSession();  
			ps=con.prepareStatement("select * from storedb");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				if((user.equals(rs.getString(1))) && (password.equals(rs.getString(2))))
				{
					flag=1;
					
					break;
				}
				else
				{
					flag=0;
				}
			}
			if(count<3)
			{
				if(flag==1)
				{	
					
			        session.setAttribute("name",user);  
					
					 request.getRequestDispatcher("Home.jsp").include(request, response);  
				}
				else
				{
					count++;
					out.println("<script>alert('Incorrect userid or password!!!')</script>");
					request.getRequestDispatcher("Login.jsp").include(request, response);  
				}
			}
			else
			{
				out.print("<h1>Access Blocked!!!</h1>");
				out.print("<h1>You Have Tried More Than 3 Attempts</h1>");
				//response.sendRedirect("login.jsp");
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
