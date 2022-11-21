package Servlets;


import java.io.IOException;

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
import jakarta.servlet.http.HttpSession;
import object.UserAccount;

@WebServlet(name = "showadminuser", urlPatterns = { "/showadminuser" })
public class showadminuser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null; // connect SQL
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			// xá»­ lÃ½ tham sá»‘ tá»« form
			String email = request.getParameter("email");
		
			String password = request.getParameter("password");

			UserAccount usr = new UserAccount(email, password); // táº¡o Ä‘á»‘i tÆ°á»£ng user
			// thÃªm Ä‘á»‘i tÆ°á»£ng vÃ o CSDL
			DBUtils DB=new DBUtils();
			usr=DB.findUser( email, password);
			if(usr==null)
			{
				String err="tên đăng nhập hoặc mật khẩu của bạn bị sai";
				request.setAttribute("error", err);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else {
				HttpSession session=request.getSession();
				session.setAttribute("acc", usr);
		request.setAttribute("user", usr);
				request.getRequestDispatcher("/admin.jsp").forward(request, response);
				
			}
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
