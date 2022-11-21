package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.UserAccount;
import object.category;
import object.comment;
import object.phanquyen;
import object.video;

public class DBUtils {
//get all video
         public static List<video> getallvideo() throws SQLException, ClassNotFoundException {
       		String sql = "SELECT * FROM video";
       		 Connection conn=MySQLConntUtils.getMySQLConnection();
       		PreparedStatement pstm = conn.prepareStatement(sql);
       
       		ResultSet rs = pstm.executeQuery();
       		List<video> list = new ArrayList<video>();
       		while (rs.next()) {
       			
       	
       			int id = rs.getInt("id");
      			String image = rs.getString("image");
      			String imageacc = rs.getString("imageacc");
      			String nameacc= rs.getString("nameacc");
      			String title = rs.getString("title");
      			int cateid = rs.getInt("cateid");
      			int idacc =rs.getInt("idacc");
      			String timeup =rs.getString("timeup");
      		
      			video video = new video();
      			video.setId(id);
      			video.setImage(image);;
      			video.setImageacc(imageacc);;
      		     video.setNameacc(nameacc);
      		    video.setTitle(title);
      		    video.setCateid(cateid);
      		    video.setIdacc(idacc);
      		    video.setTimeup(timeup);
      			
      			list.add(video);
       		
                
       		}
       		return list;
       	
       	}
 //get id video
         public static video getidvideo(int idv) throws SQLException, ClassNotFoundException {
        		String sql = "SELECT * FROM video where id=?";
        		 Connection conn=MySQLConntUtils.getMySQLConnection();
        		PreparedStatement pstm = conn.prepareStatement(sql);
        		pstm.setInt(1, idv);
        		ResultSet rs = pstm.executeQuery();
        		
        		while (rs.next()) {
        			
        	
        			int id = rs.getInt("id");
       			String image = rs.getString("image");
       			String imageacc = rs.getString("imageacc");
       			String nameacc= rs.getString("nameacc");
       			String title = rs.getString("title");
       			int cateid = rs.getInt("cateid");
       			int idacc =rs.getInt("idacc");
       			String videoload=rs.getString("video");
       			String timeup =rs.getString("timeup");
       		
       			video video = new video();
       			video.setId(id);
       			video.setImage(image);;
       			video.setImageacc(imageacc);;
       		     video.setNameacc(nameacc);
       		    video.setTitle(title);
       		    video.setCateid(cateid);
       		    video.setIdacc(idacc);
       		    video.setTimeup(timeup);
       		    video.setVideo(videoload);
       			
       			return video;
        		
                 
        		}
        		return null;
        	
        	}
         public static List<video> getidcategory(int idcate) throws SQLException, ClassNotFoundException {
     		String sql = "SELECT * FROM video where cateid=?";
     		 Connection conn=MySQLConntUtils.getMySQLConnection();
     		PreparedStatement pstm = conn.prepareStatement(sql);
     		pstm.setInt(1, idcate);
     		ResultSet rs = pstm.executeQuery();
     		List<video> list = new ArrayList<video>();
     		while (rs.next()) {
     			
     	
     			int id = rs.getInt("id");
    			String image = rs.getString("image");
    			String imageacc = rs.getString("imageacc");
    			String nameacc= rs.getString("nameacc");
    			String title = rs.getString("title");
    			int cateid = rs.getInt("cateid");
    			int idacc =rs.getInt("idacc");
    			String videoload=rs.getString("video");
    			String timeup =rs.getString("timeup");
    		
    			video video = new video();
    			video.setId(id);
    			video.setImage(image);;
    			video.setImageacc(imageacc);;
    		     video.setNameacc(nameacc);
    		    video.setTitle(title);
    		    video.setCateid(cateid);
    		    video.setIdacc(idacc);
    		    video.setTimeup(timeup);
    		    video.setVideo(videoload);
    			
    			list.add(video);
     		
              
     		}
     		return list;
     	
     	}
         public static List<video> getidaccvideo(int idacc) throws SQLException, ClassNotFoundException {
     		String sql = "SELECT * FROM video where idacc=?";
     		 Connection conn=MySQLConntUtils.getMySQLConnection();
     		PreparedStatement pstm = conn.prepareStatement(sql);
     		pstm.setInt(1, idacc);
     		ResultSet rs = pstm.executeQuery();
     		List<video> list = new ArrayList<video>();
     		while (rs.next()) {
     			
     	
     			int id = rs.getInt("id");
    			String image = rs.getString("image");
    			String imageacc = rs.getString("imageacc");
    			String nameacc= rs.getString("nameacc");
    			String title = rs.getString("title");
    			int cateid = rs.getInt("cateid");
    			int idaccc =rs.getInt("idacc");
    			String videoload=rs.getString("video");
    			String timeup =rs.getString("timeup");
    		
    			video video = new video();
    			video.setId(id);
    			video.setImage(image);;
    			video.setImageacc(imageacc);;
    		     video.setNameacc(nameacc);
    		    video.setTitle(title);
    		    video.setCateid(cateid);
    		    video.setIdacc(idaccc);
    		    video.setTimeup(timeup);
    		    video.setVideo(videoload);
    			
    			list.add(video);
     		
              
     		}
     		return list;
     	
     	}
     	public void Addvideo(String image, String imageacc, String nameacc,String title,String cateid,String idacc,String video) throws SQLException, ClassNotFoundException {
    		String sql = "INSERT INTO video (image,imageacc,nameacc,title,cateid,idacc,video)VALUES (?,?,?,?,?,?,?)";
    		 Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);

    		pstm.setString(1, image);
    		pstm.setString(2, imageacc);
    		pstm.setString(3, nameacc);
    	    pstm.setString(4, title);
    	    pstm.setString(5, cateid);
    	    pstm.setString(6, idacc);
    	    pstm.setString(7, video);
    		pstm.executeUpdate();
    	}
    	public void updateAddvideo(String image, String title,String cateid,String video,String id) throws SQLException, ClassNotFoundException {
    		String sql = "UPDATE video SET  image =?,title = ?,cateid = ?,video = ? WHERE id = ?";
    		 Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);

    		pstm.setString(1, image);
    		
    	    pstm.setString(2, title);
    	    pstm.setString(3, cateid);
    	
    	    pstm.setString(4, video);
    	    pstm.setString(5, id);
    		pstm.executeUpdate();
    	}
    	public void deletevideo(String id) throws SQLException, ClassNotFoundException {
    		String sql = "DELETE FROM video WHERE id=?";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);

    		
    		pstm.setString(1, id);
    		
    	   
    		pstm.executeUpdate();
    	}
//get account
       	public static UserAccount findemail( //
    			String email) throws SQLException, ClassNotFoundException {
    		String sql = "Select a.User_Name, a.Password, a.Gender,a.email from user_account a "
    				+ "where a.email= ?";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
    		pstm.setString(1, email);
    		
    		ResultSet rs = pstm.executeQuery();
    		if (rs.next()) {
    			String gender = rs.getString("Gender");
    			String userName=rs.getString("User_Name");
    			String password=rs.getString("Password");
    			UserAccount user = new UserAccount();
    			
    			user.setUserName(userName);
    			user.setEmail(email);;
    			user.setPassword(password);
    			user.setGender(gender);
    			return user;
    		}
    		return null;
    	}
    	public void insertUserAccount(Connection conn, String user, String pass, String gender,String email) throws SQLException {
    		String sql = "INSERT INTO User_Account(User_Name, Password, Gender,email,image,idadmin,phone,address,lockacc) VALUES (?,?,?,?,'chua co','2','none','none','2')";

    		PreparedStatement pstm = conn.prepareStatement(sql);

    		pstm.setString(1, user);
    		pstm.setString(2, pass);
    		pstm.setString(3, gender);
    	    pstm.setString(4, email);
    	   
    		pstm.executeUpdate();
    	}
    	public int  checklockUser( //
    			String emaill, String passwordd) throws SQLException, ClassNotFoundException {
    		String sql = "Select lockacc from User_Account "
    				+ "where email= ? and Password= ?";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
    		pstm.setString(1, emaill);
    		pstm.setString(2, passwordd);
    		ResultSet rs = pstm.executeQuery();
    		if (rs.next()) {
    			
    			return rs.getInt(1);
    		}
    		return 0;
    	}
     	public static UserAccount findUser( //
    			String emaill, String passwordd) throws SQLException, ClassNotFoundException {
    		String sql = "Select * from User_Account "
    				+ "where email= ? and Password= ?";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
    		pstm.setString(1, emaill);
    		pstm.setString(2, passwordd);
    		ResultSet rs = pstm.executeQuery();
    		if (rs.next()) {
    			String username = rs.getString("User_Name");
    			String image= rs.getString("image");
    			String email = rs.getString("email");
    			String address = rs.getString("address");
    			String phone = rs.getString("phone");
    			String password = rs.getString("Password");
    			String gender = rs.getString("Gender");
    			String idadmin = rs.getString("idadmin");
    			int iduser = rs.getInt("idacc");
    			UserAccount user = new UserAccount();
    			user.setUserName(username);
    			user.setImage(image);
    			user.setEmail(email);
    			user.setGender(gender);
    			user.setPassword(password);
    			user.setIduser(iduser);
    			user.setAddress(address);
    			user.setPhone(phone);
    			user.setIdadmin(idadmin);
    			return user;
    		}
    		return null;
    	}
     	public void savechange( String user, String gender,String address,String phone,	String image,String email,int iduser) throws SQLException, ClassNotFoundException {
    		String sql = "UPDATE user_account SET User_Name=?,email=?,address=?,phone=?,Gender=?,image=? where idacc=?";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);

    		pstm.setString(1, user);
    		pstm.setString(2, email);
    		pstm.setString(3, address);
    		pstm.setString(4, phone);
    	    pstm.setString(5, gender);
    	    pstm.setString(6, image);
    	    pstm.setInt(7,iduser);
    		pstm.executeUpdate();
    	}
     	//get category
        public static  List<category> getcategory() throws SQLException, ClassNotFoundException {
     			String sql = "select c.cateid,c.cname from category c";
     			Connection conn=MySQLConntUtils.getMySQLConnection();
     			PreparedStatement pstm = conn.prepareStatement(sql);

     			ResultSet rs = pstm.executeQuery();
     			List<category> list = new ArrayList<category>();
     			while (rs.next()) {
     				String cateid = rs.getString("cateid");
     	                    
     				String cname = rs.getString("cname");
     	                      
     				category category=new category();
     				category.setCateid(cateid);
     	                      
     	                      
     				category.setCname(cname);
     	                      
     				list.add(category);
     			}
     			return list;
     		}
        //tim kiem
        public static List<video> search(String name) throws SQLException, ClassNotFoundException {
     		String sql = "SELECT * FROM video where title like '%"+name+"%'";
     		 Connection conn=MySQLConntUtils.getMySQLConnection();
     		PreparedStatement pstm = conn.prepareStatement(sql);
     	
     		ResultSet rs = pstm.executeQuery();
     		List<video> list = new ArrayList<video>();
     		while (rs.next()) {
     			
     	
     			int id = rs.getInt("id");
    			String image = rs.getString("image");
    			String imageacc = rs.getString("imageacc");
    			String nameacc= rs.getString("nameacc");
    			String title = rs.getString("title");
    			int cateid = rs.getInt("cateid");
    			int idacc =rs.getInt("idacc");
    			String videoload=rs.getString("video");
    			String timeup =rs.getString("timeup");
    		
    			video video = new video();
    			video.setId(id);
    			video.setImage(image);;
    			video.setImageacc(imageacc);;
    		     video.setNameacc(nameacc);
    		    video.setTitle(title);
    		    video.setCateid(cateid);
    		    video.setIdacc(idacc);
    		    video.setTimeup(timeup);
    		    video.setVideo(videoload);
    			
    			list.add(video);
     		
              
     		}
     		return list;
     	
     	}
        
        //binh luan
        public void insertcomment(String content,String idv,String nameacc,String image) throws SQLException, ClassNotFoundException {
    		String sql = "INSERT INTO commentuser (content,idvideo,nameacc,image) VALUES (?,?,?,?)";
    		 Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);

    		pstm.setString(1, content);
    		pstm.setString(2, idv);
    		pstm.setString(3, nameacc);
    		pstm.setString(4, image);
    		pstm.executeUpdate();
    	}
        public static List<comment> Comment(String idv) throws SQLException, ClassNotFoundException {
     		String sql = "SELECT * FROM commentuser,video where video.id=commentuser.idvideo and video.id=?";
     		 Connection conn=MySQLConntUtils.getMySQLConnection();
     		PreparedStatement pstm = conn.prepareStatement(sql);
     		pstm.setString(1, idv);
     		ResultSet rs = pstm.executeQuery();
     		List<comment> list = new ArrayList<comment>();
     		while (rs.next()) {
     			
     	
     			String idcomment = rs.getString("idcomment");
    			String content = rs.getString("content");
    			String timeup = rs.getString("timeup");
    			String name = rs.getString("nameacc");
    			String imageacc = rs.getString("image");
    		comment video=new comment();
    			video.setIdcomment(idcomment);
    			video.setContent(content);
    			video.setTimeup(timeup);
    		    video.setImage(imageacc);
    		    video.setUsername(name);
    			
    			list.add(video);
     		
              
     		}
     		return list;
     	
     	}
        //tai khoan
        public static List<UserAccount> showallUser() throws SQLException, ClassNotFoundException {
    		String sql = "SELECT p.namequyen,a.* FROM user_account a,phanquyen p where a.idadmin=p.idadmin";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
    		
    		ResultSet rs = pstm.executeQuery();
    		List<UserAccount> list = new ArrayList<UserAccount>(); 
    		while (rs.next()) {
    		
    			String username = rs.getString("User_Name");
    			String image= rs.getString("image");
    			String email = rs.getString("email");
    			String phone = rs.getString("phone");
    			String password = rs.getString("namequyen");
    			String gender = rs.getString("Gender");
    			UserAccount user = new UserAccount();
    			user.setUserName(username);
    			user.setImage(image);
    			user.setEmail(email);
    			user.setGender(gender);
    			user.setPassword(password);
    			user.setPhone(phone);
    			
    			list.add(user);
    		}
    		return list;
    	}
        public static List<phanquyen> showphanquyen() throws SQLException, ClassNotFoundException {
    		String sql = "SELECT * FROM phanquyen";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
    		
    		ResultSet rs = pstm.executeQuery();
    		List<phanquyen> list = new ArrayList<phanquyen>(); 
    		while (rs.next()) {
    		
    			int id = rs.getInt("idadmin");
    			String namequyen= rs.getString("namequyen");
    			
    			phanquyen user = new phanquyen();
    			user.setIdadmin(id);;
    			user.setNamequyen(namequyen);
    			
    			
    			list.add(user);
    		}
    		return list;
    	}
    	public void updatequyenAccount(String id,String username) throws SQLException, ClassNotFoundException {
    		String sql = "UPDATE user_account SET idadmin = ? WHERE User_Name=? ";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);

    		pstm.setString(1, id);
    		pstm.setString(2, username);
    		
    	   
    		pstm.executeUpdate();
    	}
    	public void deleteacc(String username) throws SQLException, ClassNotFoundException {
    		String sql = "DELETE FROM user_account WHERE User_Name=?";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);

    		
    		pstm.setString(1, username);
    		
    	   
    		pstm.executeUpdate();
    	}
    	public void unlockacc(int number,String username) throws SQLException, ClassNotFoundException {
    		String sql = "UPDATE user_account SET lockacc=? WHERE User_Name=? ";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);

    		pstm.setInt(1, number);
    		pstm.setString(2, username);
    		
    	   
    		pstm.executeUpdate();
    	}
    	
    	public void lockacc(int number,String username) throws SQLException, ClassNotFoundException {
    		String sql = "UPDATE user_account SET lockacc=? WHERE User_Name=? ";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);

    		pstm.setInt(1, number);
    		pstm.setString(2, username);
    		
    	   
    		pstm.executeUpdate();
    	}
    	public static List<UserAccount> showallUserlock() throws SQLException, ClassNotFoundException {
    		String sql = "SELECT p.namequyen,a.* FROM user_account a, phanquyen p where a.idadmin=p.idadmin and a.lockacc='1'";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
    		
    		ResultSet rs = pstm.executeQuery();
    		List<UserAccount> list = new ArrayList<UserAccount>(); 
    		while (rs.next()) {
    		
    			String username = rs.getString("User_Name");
    			String image= rs.getString("image");
    			String email = rs.getString("email");
    			String phone = rs.getString("phone");
    			String password = rs.getString("namequyen");
    			String gender = rs.getString("Gender");
    			UserAccount user = new UserAccount();
    			user.setUserName(username);
    			user.setImage(image);
    			user.setEmail(email);
    			user.setGender(gender);
    			user.setPassword(password);
    			user.setPhone(phone);
    			
    			list.add(user);
    		}
    		return list;
    	}
    	//danh muc
        public void  insertcategory(String cname) throws SQLException, ClassNotFoundException {
    		String sql = "INSERT INTO category(cname) VALUES (?);";
    		 Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
                    
                     pstm.setString(1,cname);
                   
                  
                       
    		 pstm.executeUpdate();
             
    		
    	
    	}
        public void  upcategory(String cateid,String cname) throws SQLException, ClassNotFoundException {
    		String sql = "UPDATE category SET cname=? where cateid=?";
    		 Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
                     pstm.setString(2,cateid);
                     pstm.setString(1,cname);
                   
                  
                       
    		 pstm.executeUpdate();
             
    		
    	
    	}
        public void  deletecate(String cateid) throws SQLException, ClassNotFoundException {
    		String sql = "DELETE FROM category WHERE cateid=?";
    		 Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
                     pstm.setString(1,cateid);
                     
                   
                  
                       
    		 pstm.executeUpdate();
             
    		
    	
    	}
}
