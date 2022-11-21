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
@WebServlet("/updatechitietproduct")
public class updatechitietproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updatechitietproduct() {
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

String cpu=request.getParameter("CPU");
String gpu=request.getParameter("GPU");
String display=request.getParameter("DISPLAY");
String ram=request.getParameter("RAM");
String ssd=request.getParameter("SSD");
String weight=request.getParameter("WEIGHT");
String mota=request.getParameter("mota");
String khuyenmai=request.getParameter("khuyenmai");

DBUtils bd=new DBUtils();
try {
	bd.updatechitietProduct(cpu, gpu, display, ram, ssd,weight, mota, khuyenmai, idp);
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
		
		
		
	
		



 


// Forward sang /WEB-INF/views/productListView.jsp
response.sendRedirect("showproductadmin");
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
