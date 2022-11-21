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
import jakarta.servlet.http.HttpSession;
import object.UserAccount;
import object.chitietproduct;
import object.product;


/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/comment")
public class comment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public comment() {
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
String usern=request.getParameter("username");
String content=request.getParameter("content");
String idpro=request.getParameter("idpro");
HttpSession session=request.getSession();
session.getAttribute("acc");

if(session.getAttribute("acc")==null) {
	String emmail= "<script>alert('ban chua dang nhap')</script>";
	request.setAttribute("emaill", emmail);
	request.getRequestDispatcher("phantrangproduct?num=1").forward(request, response);
}else if(session.getAttribute("acc")!=null) {
	DBUtils db=new DBUtils();
	try {
		db.createcomment(usern, idpro, content);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	String emmail= "<script>alert('binh luan thanh cong')</script>";
	request.setAttribute("emaill", emmail);
	request.getRequestDispatcher("phantrangproduct?num=1").forward(request, response);
}


// Forward sang /WEB-INF/views/productListView.jsp

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
