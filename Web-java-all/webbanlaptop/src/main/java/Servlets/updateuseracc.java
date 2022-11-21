package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.DBUtils;
import Model.MySQLConntUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import object.UserAccount;

@WebServlet(name = "updateacc", urlPatterns = { "/SignInServlet" })
public class SignInServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null; // connect SQL
		String email = request.getParameter("email");
		UserAccount user=new UserAccount();
		DBUtils DB=new DBUtils();
		try {
			user=DB.findemail(email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null) {
			String emmail= "<script>alert('email is exixts')</script>";
			request.setAttribute("emaill", emmail);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			try {
			conn = MySQLConntUtils.getMySQLConnection();
			// xá»­ lÃ½ tham sá»‘ tá»« form
			String username = request.getParameter("username");
			
			String gender = request.getParameter("gender");
			String password = request.getParameter("password");

			UserAccount usr = new UserAccount(username, gender,email,password); // táº¡o Ä‘á»‘i tÆ°á»£ng user
			// thÃªm Ä‘á»‘i tÆ°á»£ng vÃ o CSDL
			
			DB.insertUserAccount(conn, username, password, gender,email);
		
			String thongbao= "<script>alert('success account')</script>";
			request.setAttribute("thongbao", thongbao);
			request.getRequestDispatcher("/signin.jsp").forward(request, response);
			
			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

		}
			}
		
	}
}
