package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DBUtils;
import Model.MySQLConntUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import object.category;
import object.product;


/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/showcategoryadmin")
public class showcategoryadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showcategoryadmin() {
		super();
		// TODO Auto-generated constructor stub
	}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
// TODO Auto-generated method stub
request.setCharacterEncoding("utf-8");
 response.setCharacterEncoding("utf-8");
response.getWriter().append("Served at: ").append(request.getContextPath());
//Connection conn = MyUtils.getStoredConnection(request);

String id=request.getParameter("idd");
category cate1 = null;
DBUtils db= new DBUtils();
try {
	cate1=db.getidcategory(id);
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
request.setAttribute("cateid", cate1);
		
	
		
		


 


// Forward sang /WEB-INF/views/productListView.jsp
request.getRequestDispatcher("/managercategoryadmin.jsp").forward(request, 
response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
