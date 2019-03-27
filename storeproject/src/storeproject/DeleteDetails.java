package storeproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteDetails
 */
@WebServlet("/DeleteDetails")
public class DeleteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Product p=new Product();
		System.out.println(request.getParameter("t1"));
		int pid=Integer.parseInt(request.getParameter("id"));
		
		int delstatus=ProductDAO.DeleteProduct(pid);
		System.out.println("delete status :"+delstatus);
		if(delstatus>0)
		{
			out.println("<script>alert('Deleted Successfully')</script>");
			//ervletContext context= getServletContext();
			//RequestDispatcher rd= context.getRequestDispatcher("/DisplayDetails");
			//rd.forward(request, response);
			request.getRequestDispatcher("DisplayDetails").include(request, response);

		}
		else
		{
			out.println("<script>alert(' Error in Deleting')</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
	}

}
