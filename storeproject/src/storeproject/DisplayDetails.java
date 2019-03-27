package storeproject;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayDetails
 */
@WebServlet("/DisplayDetails")
public class DisplayDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList<Product> list=new ArrayList<Product>();
		Product p=new Product();
		//p.setCategory(request.getParameter("category"));
		list=ProductDAO.GetDetails();
		out.print("<html>");
		out.print("");
		out.println("<head>");
		out.println("<style>");
		out.println("body{");
		out.println("background-color:#C8C8C8");
		out.println("}");
		out.println("table,td,th{");        
	    out.println("border: 1px solid black;");
	 	 out.println(" padding: 3px;");
		  out.println("}");
		  out.println("table {");
		  out.println("border-spacing: 15px;");
		  out.println("}");
		  out.println("</style>");
		  out.println("</head>");
		  out.println("<body>");
		  out.print("<center>");
		  out.print("<h1>");
		  out.print("Product Details");
		  out.print("</h1");
		  out.print("</center>");
		out.print("<table width='100%'");
		out.print("<tr><th>Product Id</th><th>Product Name</th><th>Category</th><th>Description</th><th>Price</th><th>View</th><th>Edit</th><th>Delete</th></tr>");
		for(Product pp:list){
			out.print("<tr><td>"+pp.getId()+"</td><td>"+pp.getName()+"</td><td>"+pp.getCategory()+"</td><td>"+pp.getDescription()+"</td><td>"+pp.getPrice()+"</td><td><a href='View?id="+pp.getId()+"'>View</a></td><td><a href='UpdateDetails.jsp?id="+pp.getId()+"'>edit</a></td><td><a href='DeleteDetails?id="+pp.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.print("<br>");
		out.print("<a href='Home.jsp'><button>Home page </button></a>"); 
		out.println("</body>");
		 out.println("</html>");
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
	}
}
