package storeproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnterDetails
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
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
		// doGet(request, response);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Product p=new Product();
		System.out.println(Integer.parseInt(request.getParameter("id")));
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setName(request.getParameter("name"));
		p.setCategory(request.getParameter("category"));
		p.setDescription(request.getParameter("desc"));
		p.setPrice(Float.parseFloat(request.getParameter("price")));
		int status=ProductDAO.SaveDetails(p);
		if(status>0)
		{
			out.println("<script>alert('Product Saved Successfully')</script>");
			request.getRequestDispatcher("Home.jsp").include(request,response);
		}
		else
		{
			out.println("<script>alert('Error in Saving')</script>");
			request.getRequestDispatcher("Home.jsp").include(request,response);
		}
	}

}
