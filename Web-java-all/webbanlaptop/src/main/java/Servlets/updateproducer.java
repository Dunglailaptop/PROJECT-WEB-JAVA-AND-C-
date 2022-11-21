
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
import object.product;

import java.net.URL;

/**
* Servlet implementation class newProductServlet
*/
@MultipartConfig(
 fileSizeThreshold = 1024 * 1024 * 10,
 maxFileSize = 1024 * 1024 * 50,
 maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/updateproducer")
public class updateproducer extends HttpServlet {
private static final long serialVersionUID = 1L;
 private static final String UPLOAD_DIR = "Images";
 
 /**
 * @see HttpServlet#HttpServlet()
 */
 public updateproducer() {
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
product listp=new product();

	 try {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 conn = MySQLConntUtils.getMySQLConnection();
		 //xử lý tham số từ form
		 
		 String name=request.getParameter("namecom");
		 String id=request.getParameter("companyid");
		 String diachi=request.getParameter("diachi");
		 String lienhe=request.getParameter("lienhe");
		 String email=request.getParameter("email");
		
		
		 
		 
		 
		 String image=""; 
		 String image1=""; 
//		 String image2=""; 
//		 String image3=""; 
//		 String image4=""; 
//		 String image5=""; 
		 Part part1= request.getPart("picture");
		 String fileName1=extractFileName(part1);
		 fileName1=new File(fileName1).getName();
		 
		 String path1=request.getContextPath();
		 System.out.println(path1);
		 part1.write("C:\\Users\\Admin\\eclipse-workspace\\webbanlaptop\\src\\main\\webapp\\images/"+fileName1);
		 image="images/"+fileName1; 
		 
		 Part part2= request.getPart("icon");
		 String fileName2=extractFileName(part2);
		 fileName2=new File(fileName2).getName();
		 
		 String path2=request.getContextPath();
		 System.out.println(path2);
		 part2.write("C:\\Users\\Admin\\eclipse-workspace\\webbanlaptop\\src\\main\\webapp\\images/"+fileName2);
		 image1="images/"+fileName2; 
//		 
//		 Part part3= request.getPart("image2");
//		 String fileName3=extractFileName(part3);
//		 fileName3=new File(fileName3).getName();
//		 
//		 String path3=request.getContextPath();
//		 System.out.println(path3);
//		 part3.write("C:\\Users\\Admin\\eclipse-workspace\\webbanlaptop\\src\\main\\webapp\\images/"+fileName3);
//		 image2="images/"+fileName3; 
//		
//		
//		 
//		 Part part4= request.getPart("image3");
//		 String fileName4=extractFileName(part4);
//		 fileName4=new File(fileName4).getName();
//		 
//		 String path4=request.getContextPath();
//		 System.out.println(path4);
//		 part4.write("C:\\Users\\Admin\\eclipse-workspace\\webbanlaptop\\src\\main\\webapp\\images/"+fileName4);
//		 image4="images/"+fileName4;
//		 
//		 Part part5= request.getPart("image5");
//		 String fileName5=extractFileName(part5);
//		 fileName5=new File(fileName5).getName();
//		 
//		 String path5=request.getContextPath();
//		 System.out.println(path5);
//		 part5.write("C:\\Users\\Admin\\eclipse-workspace\\webbanlaptop\\src\\main\\webapp\\images/"+fileName5);
//		 image5="images/"+fileName5; 
//		 
//		 Part part6= request.getPart("image3");
//		 String fileName6=extractFileName(part6);
//		 fileName6=new File(fileName6).getName();
//		 
//		 String path6=request.getContextPath();
//		 System.out.println(path6);
//		 part6.write("C:\\Users\\Admin\\eclipse-workspace\\webbanlaptop\\src\\main\\webapp\\images/"+fileName6);
//		 image5="images/"+fileName6; 
		 //thêm đối tượng vào CSDL

			 
		
			
		
			 db.updatecompanychitiet(name, image, image1, diachi, lienhe, email, id);
		
		 
request.getRequestDispatcher("/admin.jsp").forward(request, 
		response);
		 } catch (ClassNotFoundException ex) {
		 Logger.getLogger(updateproducer.class.getName()).log(Level.SEVERE, null, 
		ex);
		 } catch (SQLException ex) {
		 Logger.getLogger(updateproducer.class.getName()).log(Level.SEVERE, null, 
		ex);
		 }finally{
		 if(conn != null){
		 try {
		 conn.close();
		 } catch (SQLException ex) {
		 Logger.getLogger(updateproducer.class.getName()).log(Level.SEVERE, 
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