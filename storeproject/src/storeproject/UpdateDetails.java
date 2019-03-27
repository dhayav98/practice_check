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
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetails() {
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
		Product p=new Product();
		p.setId(Integer.parseInt(request.getParameter("id")));
		
		p.setCategory(request.getParameter("category"));
		p.setName(request.getParameter("name"));
		p.setDescription(request.getParameter("desc"));
		p.setPrice(Float.parseFloat(request.getParameter("price")));
		int updatestatus=ProductDAO.UpdateDetails(p);
		boolean b=false;
		if(updatestatus>0)
		{
			b=true;
		}
		if(b)
		{
			out.println("<script>alert('Updated Successfully')</script>");
			request.getRequestDispatcher("DisplayDetails").forward(request,response);
			
		}
		else
		{
			out.println("<script>alert('Error in Updating')</script>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
