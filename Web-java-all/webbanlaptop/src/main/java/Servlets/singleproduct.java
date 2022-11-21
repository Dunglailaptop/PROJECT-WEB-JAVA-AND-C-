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
import object.chitietproduct;
import object.product;


/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/singleproduct")
public class singleproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public singleproduct() {
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

int idp=Integer.parseInt(request.getParameter("idp"));
String cateid=request.getParameter("cateid");

List<product> listcatecom = null;	

chitietproduct list = null;
product listp = null;	
		
		
			try {
				list=DBUtils.singlechitietProduct(idp);
				listp=DBUtils.singleProduct(idp);
				listcatecom=DBUtils.singlecateidcompanyidProduct(cateid);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		
		request.setAttribute("chitiet", list);
		request.setAttribute("product", listp);

		request.setAttribute("listproduct", listcatecom);


// Forward sang /WEB-INF/views/productListView.jsp
request.getRequestDispatcher("/single-product.jsp").forward(request, 
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
