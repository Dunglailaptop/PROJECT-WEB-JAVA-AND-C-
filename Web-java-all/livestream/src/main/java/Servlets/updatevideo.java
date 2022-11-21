
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
import object.video;

import java.net.URL;

/**
* Servlet implementation class newProductServlet
*/
@MultipartConfig(
 fileSizeThreshold = 1024 * 1024 * 10,
 maxFileSize = 1024 * 1024 * 50,
 maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/updatevideo")
public class updatevideo extends HttpServlet {
private static final long serialVersionUID = 1L;
 private static final String UPLOAD_DIR = "Images";
 
 /**
 * @see HttpServlet#HttpServlet()
 */
 public updatevideo() {
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
video video=new video();

	 try {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 conn = MySQLConntUtils.getMySQLConnection();
		
		 String cateid=request.getParameter("cateid");
		
		 String title=request.getParameter("title");
		 String id=request.getParameter("id");
		 String image1=""; 
		 String image2=""; 
		 String imageold="";
		String videoold="";
		
		 
		 Part part2= request.getPart("image");
		 String fileName2=extractFileName(part2);
		 fileName2=new File(fileName2).getName();
		 
		 String path2=request.getContextPath();
		 System.out.println(path2);
			part2.write("C:\\Users\\Admin\\eclipse-workspace\\livestream\\src\\main\\webapp\\images/"+fileName2);
			 image1="images/"+fileName2;
		 
		 
		 Part part3= request.getPart("video");
		 String fileName3=extractFileName(part3);
		 fileName3=new File(fileName3).getName();
		 
		 String path3=request.getContextPath();
		 System.out.println(path3);
		 imageold=request.getParameter("imageold");
		 
		 
		
	
			
				
		
			
				
				  if(fileName3=="") {
					  videoold=request.getParameter("videoold");
					  db.updateAddvideo(image1, title, cateid,videoold, id);
				  }else if(fileName3!="") {
					  part3.write("C:\\Users\\Admin\\eclipse-workspace\\livestream\\src\\main\\webapp\\images/"+fileName3);
						 image2="images/"+fileName3;
						 db.updateAddvideo(image1, title, cateid,image2, id);
				  }
				 
			
			
			
	
			
				
				
				response.sendRedirect("edit.jsp");
		
		
		
		
		 //thêm đối tượng vào CSDL
		  
		 
		 } catch (ClassNotFoundException ex) {
		 Logger.getLogger(updatevideo.class.getName()).log(Level.SEVERE, null, 
		ex);
		 } catch (SQLException ex) {
		 Logger.getLogger(updatevideo.class.getName()).log(Level.SEVERE, null, 
		ex);
		 }finally{
		 if(conn != null){
		 try {
		 conn.close();
		 } catch (SQLException ex) {
		 Logger.getLogger(updatevideo.class.getName()).log(Level.SEVERE, 
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