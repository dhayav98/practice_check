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
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		Product p=new Product();
		ArrayList<Product> list=new ArrayList<Product>();
		list=ProductDAO.ViewProduct(id);
		out.print("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body{");
		out.println("background-color:#C8C8C8");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		  out.println("<body>");
		  out.print("<center>");
		  out.print("<i>");
		  out.print("<h2>");
		  out.print("Product Details");
		  out.print("<br>");
		  out.print("<br>");
		  out.print("</h2");
		  out.print("<h4>");
		  for(Product p1 : list)
		  {
			  out.print("Product ID :"+p1.getId());
			  out.print("<br>");
			  out.print("Product Category :"+p1.getCategory());
			  out.print("<br>");
			  out.print("Product Name :"+p1.getName());
			  out.print("<br>");
			  out.print("Product Description :"+p1.getDescription());
			  out.print("<br>");
			  out.print("Product Price :"+p1.getPrice());
			  out.print("<br>");
		  }
		  out.print("<br>");
		  out.print("<br>");
		  out.print("<a href='DisplayDetails'><button>List product</button></a>");
		  out.print("<br>");
		  out.print("<br>");
		  out.print("<a href='Home.jsp'><button>Home</button></a>");
		  out.print("</i>");
		  out.print("</h4");
		  out.print("</center>");
		  out.print("</body>");
		  out.print("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
