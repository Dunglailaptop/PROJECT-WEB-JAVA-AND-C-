
package Servlets;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.DBUtils;
import Model.MySQLConntUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.net.URL;

/**
* Servlet implementation class newProductServlet
*/
@MultipartConfig(
 fileSizeThreshold = 1024 * 1024 * 10,
 maxFileSize = 1024 * 1024 * 50,
 maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/savechangemyprofile")
public class savechangemyprofile extends HttpServlet {
private static final long serialVersionUID = 1L;
 private static final String UPLOAD_DIR = "Images";
 
 /**
 * @see HttpServlet#HttpServlet()
 */
 public savechangemyprofile() {
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
response.getWriter().append("Served at: ").append(request.getContextPath());
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException {
Connection conn = null; //connect SQL

DBUtils db= new DBUtils();


	 try {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 conn = MySQLConntUtils.getMySQLConnection();
		 //xử lý tham số từ form
		 int id=Integer.parseInt(request.getParameter("iduser"));
		 String name=request.getParameter("username");
		 String email=request.getParameter("email");
		 String phone=request.getParameter("phone");
		 String gender=request.getParameter("gender");
		 String address=request.getParameter("address");
		 
		 String image=""; 

		 Part part1= request.getPart("image");
		 String fileName1=extractFileName(part1);
		 fileName1=new File(fileName1).getName();
		 
		 String path1=request.getContextPath();
		 System.out.println(path1);
		
		 
		if(fileName1=="") {
			 image=request.getParameter("imageold");
			DBUtils bd=new DBUtils();
			bd.savechange(name, gender, address, phone, image, email, id);
		}else if(fileName1!="") {
			 part1.write("C:\\Users\\Admin\\eclipse-workspace\\livestream\\src\\main\\webapp\\images//"+fileName1);
			image="images/"+fileName1;
			
			 
			 DBUtils bd=new DBUtils();
				bd.savechange(name, gender, address, phone, image, email, id);
		}
		 
		
		 

response.sendRedirect("signin.jsp");
		 } catch (ClassNotFoundException ex) {
		 Logger.getLogger(savechangemyprofile.class.getName()).log(Level.SEVERE, null, 
		ex);
		 } catch (SQLException ex) {
		 Logger.getLogger(savechangemyprofile.class.getName()).log(Level.SEVERE, null, 
		ex);
		 }finally{
		 if(conn != null){
		 try {
		 conn.close();
		 } catch (SQLException ex) {
		 Logger.getLogger(savechangemyprofile.class.getName()).log(Level.SEVERE, 
		null, ex);
		 }
		 }
}

	 doGet(request, response);
 } 
 


private String extractFileName(Part part) {
 String contentDisp = part.getHeader("content-disposition");
 String[] items = contentDisp.split(";");
 for (String s : items) {
 if (s.trim().startsWith("filename")) {
 return s.substring(s.indexOf("=") + 2, s.length() - 1);
 }
 }
 return "";
 }
}