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
import jakarta.servlet.http.Part;
import object.Cart;
import object.billcustomer;
import object.billproduct;


/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/bill")
public class bill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bill() {
		super();
		// TODO Auto-generated constructor stub
	}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
	 
	 String name=request.getParameter("name");
	 String email=request.getParameter("email"); 
	 String address=request.getParameter("address"); 
	 String pay=request.getParameter("pay"); 
	 String idp=request.getParameter("idp");
	 String sdt=request.getParameter("sdt");
	 String nameproduct=request.getParameter("nameproduct");
	 int quantity=Integer.parseInt(request.getParameter("quantity"));
	 int price=Integer.parseInt(request.getParameter("price"));
	 HttpSession session = request.getSession();
	 ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	
		List<Cart> cartProduct = null;
		if (cart_list != null) {
			DBUtils db= new DBUtils();
			try {
				cartProduct = db.getCartProducts(cart_list);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		for (Cart c : cart_list) {
		 billproduct billp=new  billproduct();
		 billp.setIdproduct(idp);
		 billp.setNamecustomer(name);
		 billp.setQuantity(quantity);
		 billp.setTotalprice(price);
		 billp.setNameproduct(nameproduct);
		 try {
			 Connection conn = MySQLConntUtils.getMySQLConnection();
			DBUtils.createbill(conn, billp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 //tạo đối tượng product
	 //thêm đối tượng vào CSDL
	
	try {
		 Connection conn = MySQLConntUtils.getMySQLConnection();
		DBUtils.createcus(conn, name, email, address, pay, sdt); 
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	session.removeAttribute("cart-list");
	 request.getRequestDispatcher("/index.jsp").forward(request, 
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
