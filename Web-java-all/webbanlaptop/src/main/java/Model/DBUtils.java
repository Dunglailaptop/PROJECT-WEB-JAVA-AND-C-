package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.Cart;
import object.UserAccount;
import object.billcustomer;
import object.billproduct;
import object.category;
import object.chitietproduct;
import object.comment;
import object.companyproduct;
import object.donhangdagiao;
import object.phanquyen;
import object.product;

public class DBUtils {
	public static UserAccount findUser( //
			String emaill, String passwordd) throws SQLException, ClassNotFoundException {
		String sql = "Select * from user_account "
				+ "where email= ? and password= ?";
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
			String password = rs.getString("password");
			String gender = rs.getString("Gender");
			String idadmin = rs.getString("idadmin");
			int iduser = rs.getInt("iduser");
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
	public int  checklockUser( //
			String emaill, String passwordd) throws SQLException, ClassNotFoundException {
		String sql = "Select lockacc from user_account "
				+ "where email= ? and password= ?";
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

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {
		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a "//
				+ " where a.User_Name = ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}
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
	public static UserAccount showemailUser(Connection conn,String email) throws SQLException {
		String sql = "SELECT User_Name,email, image,Password,Gender FROM user_account where email=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		ResultSet rs = pstm.executeQuery();
	
		if (rs.next()) {
		
			String username = rs.getString("User_Name");
			String image= rs.getString("image");
			String emaill = rs.getString("email");
			
			String password = rs.getString("password");
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(username);
			user.setImage(image);
			user.setEmail(emaill);
			user.setGender(gender);
			user.setPassword(password);
			
			return user;
		}
		return null;
	}
	public void deleteacc(String username) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM user_account WHERE User_Name=?";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);

		
		pstm.setString(1, username);
		
	   
		pstm.executeUpdate();
	}
	public void updatequyenAccount(String id,String username) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE user_account SET idadmin = ? WHERE User_Name=? ";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, id);
		pstm.setString(2, username);
		
	   
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
	public void insertUserAccount(Connection conn, String user, String pass, String gender,String email) throws SQLException {
		String sql = "INSERT INTO user_account(User_Name, Password, Gender,email,image,idadmin,phone,address,lockacc) VALUES (?,?,?,?,'chua co','2','none','none','2')";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user);
		pstm.setString(2, pass);
		pstm.setString(3, gender);
	    pstm.setString(4, email);
	   
		pstm.executeUpdate();
	}
	public void insertAccount(Connection conn, String user, String pass, String gender,String email,String image) throws SQLException {
		String sql = "INSERT INTO user_account(User_Name, Password, Gender,email,image) VALUES (?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user);
		pstm.setString(2, pass);
		pstm.setString(3, gender);
	    pstm.setString(4, email);
	    pstm.setString(5, image);
		pstm.executeUpdate();
	}
	public void updateUserAccount(Connection conn, String user, String pass, String gender,	String image,String email) throws SQLException {
		String sql = "UPDATE user_account SET User_Name=?,Password=?,Gender=?,image=? where email=?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user);
		pstm.setString(2, pass);
		pstm.setString(3, gender);
		pstm.setString(4, image);
	    pstm.setString(5, email);
		pstm.executeUpdate();
	}
	public void savechange( String user, String gender,String address,String phone,	String image,String email,int iduser) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE user_account SET User_Name=?,email=?,address=?,phone=?,Gender=?,image=? where iduser=?";
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
	public static List<product> queryProduct() throws SQLException, ClassNotFoundException {
		String sql = "SELECT p.id,p.name,p.image,p.price,p.quantity,co.namecom,c.cname FROM product p,companyproduct co,category c"
				+ " where p.companyid=co.companyid and p.cateid=c.cateid;";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		List<companyproduct> listc=new ArrayList<companyproduct>();
		List<category> listcate=new ArrayList<category>();
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String image = rs.getString("image");
			int price = rs.getInt("price");
			int quantity = rs.getInt("quantity");  
	String namecom=rs.getString("namecom");
	String cname=rs.getString("cname");
		
			product product = new product();
			product.setId(id);
			product.setName(name);
			product.setImage(image);
		
		
			product.setQuantity(quantity);
		product.setPrice(price);
		product.setCateid(cname);
		product.setCompanyid(namecom);
			list.add(product);
			
		}
		return list;
	
		
		
	}
	public static List<product> allProduct() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM product;";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		List<companyproduct> listc=new ArrayList<companyproduct>();
		List<category> listcate=new ArrayList<category>();
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String image = rs.getString("image");
			int price = rs.getInt("price");
			String pricevnd = rs.getString("pricevnd");
			int quantity = rs.getInt("quantity"); 
			String khuyenmai = rs.getString("khuyenmai");

		
			product product = new product();
			product.setId(id);
			product.setName(name);
			product.setImage(image);
			product.setPrice(price);
			product.setPricevnd(pricevnd);
			product.setQuantity(quantity);
			
		product.setKhuyenmai(khuyenmai);
	
			list.add(product);
			
		}
		return list;
	
		
		
	}
	public static List<product> topsellerProduct() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM product where cateid='1' order by id limit 6";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		List<companyproduct> listc=new ArrayList<companyproduct>();
		List<category> listcate=new ArrayList<category>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String image = rs.getString("image");
			int price = rs.getInt("price");
			String pricevnd = rs.getString("pricevnd");
			int quantity = rs.getInt("quantity"); 
			String khuyenmai = rs.getString("khuyenmai");
			String mota = rs.getString("mota");
			String cateidd = rs.getString("cateid");
			String companyidd = rs.getString("companyid");
		
			product product = new product();
			product.setId(id);
			product.setName(name);
			product.setImage(image);
			product.setPrice(price);
			product.setPricevnd(pricevnd);
			product.setQuantity(quantity);
			product.setMota(mota);
		product.setKhuyenmai(khuyenmai);
	product.setCateid(cateidd);
	product.setCompanyid(companyidd);
			
	
			list.add(product);
			
		}
		return list;
	
		
		
	}
	public static product SHOWIDProduct(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM product WHERE id=?";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,id);
		ResultSet rs = pstm.executeQuery();
	
	
		while (rs.next()) {
			
			int idp = rs.getInt("id");
			String name = rs.getString("name");
			String image = rs.getString("image");
			int price = rs.getInt("price");
			String pricevnd = rs.getString("pricevnd");
			int quantity = rs.getInt("quantity");  

		
			product product = new product();
			product.setId(id);
			product.setName(name);
			product.setImage(image);
		
		
			product.setQuantity(quantity);
		product.setPrice(price);
	product.setPricevnd(pricevnd);
	
			return product;
			
		}
		return null;
	
		
		
	}
	public static product showpicProduct(int idp) throws SQLException, ClassNotFoundException {
		String sql = "SELECT id,image,image1,image2,image3,image4,image5 FROM product where id=?";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,idp);
		ResultSet rs = pstm.executeQuery();
		
	
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String image = rs.getString("image");
			String image1 = rs.getString("image1");
			String image2= rs.getString("image2");
			String image3 = rs.getString("image3");
			String image4 = rs.getString("image4");
			String image5 = rs.getString("image5");
			product product = new product();
		
			product.setImage(image);
			product.setImage1(image1);
			product.setImage2(image2);
			product.setImage3(image3);
			product.setImage4(image4);
			product.setImage5(image5);
			product.setId(id);
			return product;
			
		}
		return null;
	
		
		
	}
	public static product singleProduct(int idp) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM product where id=?";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,idp);
		ResultSet rs = pstm.executeQuery();
		
	
		while (rs.next()) {

			int id = rs.getInt("id");
			String name = rs.getString("name");
		
			int price = rs.getInt("price");
			String pricevnd = rs.getString("pricevnd");
			int quantity = rs.getInt("quantity");  

		
			
			
	
			String mota = rs.getString("mota");
			String khuyenmai = rs.getString("khuyenmai");
			String image = rs.getString("image");
			String image1 = rs.getString("image1");
			String image2= rs.getString("image2");
			String image3 = rs.getString("image3");
			String image4 = rs.getString("image4");
			String image5 = rs.getString("image5");
			String cateid = rs.getString("cateid");
			String companyid = rs.getString("companyid");
			product product = new product();
			product.setId(id);
			product.setName(name);
			
		product.setMota(mota);
		product.setKhuyenmai(khuyenmai);
		
			product.setQuantity(quantity);
		product.setPrice(price);
	product.setPricevnd(pricevnd);
			product.setImage(image);
			product.setImage1(image1);
			product.setImage2(image2);
			product.setImage3(image3);
			product.setImage4(image4);
			product.setImage5(image5);
			product.setId(id);
			product.setCateid(cateid);
			product.setCompanyid(companyid);
			return product;
			
		}
		return null;
	
		
		
	}
	public static List<product> singlecateidcompanyidProduct(String cateid) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM product where cateid=? ";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,cateid);
		
		ResultSet rs = pstm.executeQuery();
		
		List<product> list = new ArrayList<product>();
		while (rs.next()) {

			int id = rs.getInt("id");
			String name = rs.getString("name");
		
			int price = rs.getInt("price");
			String pricevnd = rs.getString("pricevnd");
			int quantity = rs.getInt("quantity");  

		
			
			
	
			String mota = rs.getString("mota");
			String khuyenmai = rs.getString("khuyenmai");
			String image = rs.getString("image");
			String image1 = rs.getString("image1");
			String image2= rs.getString("image2");
			String image3 = rs.getString("image3");
			String image4 = rs.getString("image4");
			String image5 = rs.getString("image5");
			String cateidd = rs.getString("cateid");
			String companyidd = rs.getString("companyid");
			product product = new product();
			product.setId(id);
			product.setName(name);
			
		product.setMota(mota);
		product.setKhuyenmai(khuyenmai);
		
			product.setQuantity(quantity);
		product.setPrice(price);
	product.setPricevnd(pricevnd);
			product.setImage(image);
			product.setImage1(image1);
			product.setImage2(image2);
			product.setImage3(image3);
			product.setImage4(image4);
			product.setImage5(image5);
			product.setId(id);
			product.setCateid(cateidd);
			product.setCompanyid(companyidd);
			list.add(product);
			
		}
		return list;
	
		
		
	}
	public static chitietproduct singlechitietProduct(int idp) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM chitietproduct where idproduct=?";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,idp);
		ResultSet rs = pstm.executeQuery();
		
	
		while (rs.next()) {

		 

		
			
			
	
		
			String cpu = rs.getString("CPU");
			String gpu = rs.getString("GPU");
			String ram= rs.getString("RAM");
			String ssd = rs.getString("SSD");
			String display = rs.getString("DISPLAY");
			String weight = rs.getString("WEIGHT");
			int idproduct = rs.getInt("idproduct");
			chitietproduct product = new chitietproduct();
			product.setCpu(cpu);;
			product.setGpu(gpu);;
			product.setDisplay(display);
		
		
			product.setRam(ram);
		product.setSsd(ssd);;
	product.setWeight(weight);;
			product.setIdproduct(idproduct);;
		
		
			return product;
			
		}
		return null;
	
		
		
	}
	public void  updateProduct(String name,String companyid,String image,int price,String pricevnd,int quantity,String cateid,int id) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE product SET name= ?,companyid = ?,image = ?,price= ?,pricevnd = ?,quantity = ?,cateid= ? WHERE id = ?";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			  
	                 
	                   pstm.setString(1, name);
	                   pstm.setString(2,companyid);
	                   pstm.setString(3,image);
	                   pstm.setInt(4,price);
	                   pstm.setString(5,pricevnd);
	                   pstm.setInt(6,quantity);
	                   pstm.setString(7,cateid);
	                   
	                   pstm.setInt(8,id); 
	                     
	                   
			 pstm.executeUpdate();
		
		
		
	}
	public void  updatechitietProduct(String cpu,String gpu,String display,String ram,String ssd,String weight,String mota,String khuyenmai,int id) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE chitietproduct ctp,product p SET  ctp.CPU= ?, ctp.GPU= ?,ctp.DISPLAY= ?,ctp.RAM= ?,ctp.SSD= ?,ctp.WEIGHT = ?,p.mota=?,p.khuyenmai=? \r\n"
				+ "WHERE ctp.idproduct = p.id and ctp.idproduct=?";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			  
	                 
	                   pstm.setString(1, cpu);
	                   pstm.setString(2, gpu);
	                   pstm.setString(3,display);
	                   pstm.setString(4,ram);
	                   pstm.setString(5,ssd);
	                   pstm.setString(6,weight);
	                   pstm.setString(7,mota);
	                   pstm.setString(8,khuyenmai);
	                   
	                   pstm.setInt(9,id); 
	                     
	                   
			 pstm.executeUpdate();
		
		
		
	}
	public void  deleteProduct(int id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM product WHERE id=?;";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			  
	                 
	                 
	                   
	                   pstm.setInt(1,id); 
	                     
	                   
			 pstm.executeUpdate();
		
		
		
	}
	public void  deletechitietProduct(int id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM chitietproduct WHERE idproduct=?;";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			  
	                 
	                 
	                   
	                   pstm.setInt(1,id); 
	                     
	                   
			 pstm.executeUpdate();
		
		
		
	}
	public static List<product> idcompany(String pid) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM  product  where companyid=?";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, pid);
		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String image = rs.getString("image");
			int price = rs.getInt("price");
			String pricevnd = rs.getString("pricevnd");
			int quantity = rs.getInt("quantity"); 
			String khuyenmai = rs.getString("khuyenmai");

		
			product product = new product();
			product.setId(id);
			product.setName(name);
			product.setImage(image);
			product.setPrice(price);
			product.setPricevnd(pricevnd);
			product.setQuantity(quantity);
			
		product.setKhuyenmai(khuyenmai);
	
			
			 list.add(product);
		}
		return list;
	}
	public static List<product> search(String name) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM  product  where name like '%"+name+"%';";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String named = rs.getString("name");
			String image = rs.getString("image");
			int price = rs.getInt("price");
			String pricevnd = rs.getString("pricevnd");
			int quantity = rs.getInt("quantity"); 
			String khuyenmai = rs.getString("khuyenmai");

		
			product product = new product();
			product.setId(id);
			product.setName(named);
			product.setImage(image);
			product.setPrice(price);
			product.setPricevnd(pricevnd);
			product.setQuantity(quantity);
			
		product.setKhuyenmai(khuyenmai);
	
			
			 list.add(product);
		}
		return list;
	}
	public static List<product> idcategory(String pid) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM  product  where cateid=?";
		Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, pid);
		ResultSet rs = pstm.executeQuery();
		List<product> list = new ArrayList<product>();
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String image = rs.getString("image");
			int price = rs.getInt("price");
			String pricevnd = rs.getString("pricevnd");
			int quantity = rs.getInt("quantity"); 
			String khuyenmai = rs.getString("khuyenmai");

		
			product product = new product();
			product.setId(id);
			product.setName(name);
			product.setImage(image);
			product.setPrice(price);
			product.setPricevnd(pricevnd);
			product.setQuantity(quantity);
			
		product.setKhuyenmai(khuyenmai);
	
			
			 list.add(product);
		}
		return list;
	}
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
	   public static  List<category> getcategoryid(String id) throws SQLException, ClassNotFoundException {
			String sql = "select c.cateid,c.cname from category c where c.cateid=?";
			Connection conn=MySQLConntUtils.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,id);
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
	   public static  List<companyproduct> getcompanyproduct() throws SQLException, ClassNotFoundException {
				String sql = "SELECT c.companyid,c.namecom FROM companyproduct c";
				Connection conn=MySQLConntUtils.getMySQLConnection();
				PreparedStatement pstm = conn.prepareStatement(sql);

				ResultSet rs = pstm.executeQuery();
				List<companyproduct> list = new ArrayList<companyproduct>();
				while (rs.next()) {
					String companyid = rs.getString("companyid");
		                    
					String namecom = rs.getString("namecom");
		                      
					companyproduct company= new companyproduct();
					
					company.setCompanyid(companyid);
					company.setNamecompany(namecom);;        
		                      
					
		                      
					list.add(company);
				}
				return list;
			}
	   public static  List<companyproduct> getcompanyproductid(String id) throws SQLException, ClassNotFoundException {
			String sql = "SELECT c.companyid,c.namecom FROM companyproduct c where c.companyid=?";
			Connection conn=MySQLConntUtils.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,id);
			ResultSet rs = pstm.executeQuery();
			List<companyproduct> list = new ArrayList<companyproduct>();
			while (rs.next()) {
				String companyid = rs.getString("companyid");
	                    
				String namecom = rs.getString("namecom");
	                      
				companyproduct company= new companyproduct();
				
				company.setCompanyid(companyid);
				company.setNamecompany(namecom);;        
	                      
				
	                      
				list.add(company);
			}
			return list;
		}
	   public static  List<companyproduct> getproducer() throws SQLException, ClassNotFoundException {
			String sql = "SELECT * FROM companyproduct ";
			Connection conn=MySQLConntUtils.getMySQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			List<companyproduct> list = new ArrayList<companyproduct>();
			while (rs.next()) {
				String id = rs.getString("companyid");
				
				String picture = rs.getString("picture");
				String diachi = rs.getString("diachi");
				String lienhe = rs.getString("lienhe");
				String email = rs.getString("email");
				String namecom = rs.getString("namecom");
				String icon = rs.getString("icon");    
				companyproduct company= new companyproduct();
				company.setCompanyid(id);
				company.setDiachi(diachi);
				company.setEmail(email);
				company.setLienhe(lienhe);
				company.setIcon(icon);
				company.setPicture(picture);
				
				company.setNamecompany(namecom);;        
	                      
				
	                      
				list.add(company);
			}
			return list;
		}
	   public static  category getidcategory(String cateid) throws SQLException, ClassNotFoundException {
				String sql = "select c.cateid,c.cname from category c where c.cateid=?";
				Connection conn=MySQLConntUtils.getMySQLConnection();
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1,cateid);
				ResultSet rs = pstm.executeQuery();
				List<category> list = new ArrayList<category>();
				while (rs.next()) {
					String cateidd = rs.getString("cateid");
		                    
					String cname = rs.getString("cname");
		                      
					category category=new category();
					category.setCateid(cateidd);
		                      
		                      
					category.setCname(cname);
		                      
					return category;
				}
				return null;
			}
//	     public static  List<Product> getqueryProduct(String cateid) throws SQLException, ClassNotFoundException {
//	 		String sql = "SELECT * FROM product "+"WHERE cateid=?";
//	                 Connection conn=MySQLConntUtils.getMySQLConnection();
//	 		PreparedStatement pstm = conn.prepareStatement(sql);
//	                   pstm.setString(1,cateid);
//	 		ResultSet rs = pstm.executeQuery();
//	 		List<Product> list = new ArrayList<Product>();
//	 		while (rs.next()) {
//	 			int id = rs.getInt("id");
//	 			String name = rs.getString("name");
//	                         String image = rs.getString("image");
//	 			int price = rs.getInt("price");
//	 			Product product = new Product();
//	 			product.setId(id);
//	 			product.setName(name);
//	                         product.setImage(image);
//	 			product.setPrice(price);
//	 			list.add(product);
//	 		}
//	 		return list;
//	     }
//	     public static  List<Product> gethomeproduct(Connection conn) throws SQLException, ClassNotFoundException {
//		 		String sql = "SELECT * FROM product where cateid='1' order by id LIMIT 8";
//		                 
//		 		PreparedStatement pstm = conn.prepareStatement(sql);
//		               
//		 		ResultSet rs = pstm.executeQuery();
//		 		List<Product> list = new ArrayList<Product>();
//		 		while (rs.next()) {
//		 			int id = rs.getInt("id");
//		 			String name = rs.getString("name");
//		                         String image = rs.getString("image");
//		 			int price = rs.getInt("price");
//		 			Product product = new Product();
//		 			product.setId(id);
//		 			product.setName(name);
//		                         product.setImage(image);
//		 			product.setPrice(price);
//		 			list.add(product);
//		 		}
//		 		return list;
//	     }
//	     public static  List<Product> gethomeproduct1(Connection conn) throws SQLException, ClassNotFoundException {
//		 		String sql = "SELECT * FROM product where cateid='2' order by id LIMIT 8";
//		                 
//		 		PreparedStatement pstm = conn.prepareStatement(sql);
//		               
//		 		ResultSet rs = pstm.executeQuery();
//		 		List<Product> list = new ArrayList<Product>();
//		 		while (rs.next()) {
//		 			int id = rs.getInt("id");
//		 			String name = rs.getString("name");
//		                         String image = rs.getString("image");
//		 			int price = rs.getInt("price");
//		 			Product product = new Product();
//		 			product.setId(id);
//		 			product.setName(name);
//		                         product.setImage(image);
//		 			product.setPrice(price);
//		 			list.add(product);
//		 		}
//		 		return list;
//	     }
//	     public static  List<Product> gethomeproduct2(Connection conn) throws SQLException, ClassNotFoundException {
//		 		String sql = "SELECT * FROM product where cateid='3' order by id LIMIT 8";
//		                 
//		 		PreparedStatement pstm = conn.prepareStatement(sql);
//		               
//		 		ResultSet rs = pstm.executeQuery();
//		 		List<Product> list = new ArrayList<Product>();
//		 		while (rs.next()) {
//		 			int id = rs.getInt("id");
//		 			String name = rs.getString("name");
//		                         String image = rs.getString("image");
//		 			int price = rs.getInt("price");
//		 			Product product = new Product();
//		 			product.setId(id);
//		 			product.setName(name);
//		                         product.setImage(image);
//		 			product.setPrice(price);
//		 			list.add(product);
//		 		}
//		 		return list;
//	     }
	//create product admin
         public void  insertProduct(String name,String image,String image1,String image2,String image3,String image4,String image5,
                 String mota,String khuyenmai,int price,int quantity,String pricevnd,String companyid,String cateid) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO product( name, image, image1,image2,image3,image4,image5,mota,khuyenmai,price,pricevnd,cateid,companyid,quantity,sellid,adminid) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,'1','1')";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
             
                 pstm.setString(1,name);
                  pstm.setString(2,image);
                   pstm.setString(3,image1);
                   pstm.setString(4,image2);
                   pstm.setString(5,image3);
                   pstm.setString(6,image4);
                   pstm.setString(7,image5);
                    pstm.setString(8,mota);
                     pstm.setString(9,khuyenmai);
                     pstm.setInt(10,price);
                     pstm.setString(11,pricevnd);
                     pstm.setString(12,cateid);
                     pstm.setString(13,companyid);
                     pstm.setInt(14,quantity);
                     
                   
		 pstm.executeUpdate();
         
		
	
	}
         public void  updatepictureProduct(String image1,String image2,String image3,String image4,String image5
                 ,int id) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE product SET image1 =? ,image2 = ?,image3 = ?,image4= ?,image5= ?"
				+ "WHERE id = ?";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		  
                 
                   pstm.setString(1,image1);
                   pstm.setString(2,image2);
                   pstm.setString(3,image3);
                   pstm.setString(4,image4);
                   pstm.setString(5,image5);
                   pstm.setInt(6,id); 
                     
                   
		 pstm.executeUpdate();
         
		
	
	}
         public void  insertchitietproduct(String cpu,String gpu,String display,String ram,String ssd
                 ,String weight) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO chitietproduct \r\n"
				+ "(CPU,GPU,DISPLAY,RAM,SSD,WEIGHT)VALUES\r\n"
				+ "(?,?,?,?,?,?);";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		  
                 
                   pstm.setString(1,cpu);
                   pstm.setString(2,gpu);
                   pstm.setString(3,display);
                   pstm.setString(4,ram);
                   pstm.setString(5,ssd);
                   pstm.setString(6,weight);
                   
                   
                     
                   
		 pstm.executeUpdate();
         
		
	
	}
     	public static chitietproduct showidinforproduct(int idp) throws SQLException, ClassNotFoundException {
    		String sql = "SELECT ctp.idproduct,ctp.CPU,ctp.GPU,ctp.DISPLAY,ctp.RAM,ctp.SSD,ctp.WEIGHT,p.mota,p.khuyenmai FROM chitietproduct ctp,product p where ctp.idproduct=p.id and ctp.idproduct=?";
    		Connection conn=MySQLConntUtils.getMySQLConnection();
    		PreparedStatement pstm = conn.prepareStatement(sql);
    		pstm.setInt(1,idp);
    		ResultSet rs = pstm.executeQuery();
    		
    	
    		while (rs.next()) {
    			
    			int idproduct = rs.getInt("idproduct");
    			String cpu = rs.getString("CPU");
    			String gpu = rs.getString("GPU");
    			String display= rs.getString("DISPLAY");
    			String ram= rs.getString("RAM");
    			String ssd = rs.getString("SSD");
    			String weight = rs.getString("WEIGHT");
    			String mota = rs.getString("mota");
    			String khuyenmai = rs.getString("khuyenmai");
    			chitietproduct chitiet = new chitietproduct();
    		chitiet.setIdproduct(idp);
    			chitiet.setCpu(cpu);
    		chitiet.setGpu(gpu);
    			chitiet.setDisplay(display);
    			chitiet.setRam(ram);
    			chitiet.setSsd(ssd);
    			chitiet.setWeight(weight);
    			chitiet.setMota(mota);
    			chitiet.setKhuyenmai(khuyenmai);
    			return chitiet;
    			
    		}
    		return null;
    	
    		
    		
    	}
 
         public void  upcategory(String cateid,String cname) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE category SET cname=? where cateid=?";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
                 pstm.setString(2,cateid);
                 pstm.setString(1,cname);
               
              
                   
		 pstm.executeUpdate();
         
		
	
	}
         public void  updatetinhtrang(String namecus,String email,String address,String sdt,String tinhtrang,String pay) throws SQLException, ClassNotFoundException {
     		String sql = "INSERT INTO dondagiao(namecustomer,email,address,sdt,tinhtrang,pay) VALUES (?,?,?,?,?,?);";
     		 Connection conn=MySQLConntUtils.getMySQLConnection();
     		PreparedStatement pstm = conn.prepareStatement(sql);
                      pstm.setString(1, namecus );
                      pstm.setString(2, email);
                      pstm.setString(3, address);
                      pstm.setString(4, sdt);
                      pstm.setString(5, tinhtrang);
                      pstm.setString(6, pay);
     		 pstm.executeUpdate();
              
     		
     	
     	}
         public void  deletecate(String cateid) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM category WHERE cateid=?";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
                 pstm.setString(1,cateid);
                 
               
              
                   
		 pstm.executeUpdate();
         
		
	
	}
         public void  insertcategory(String cname) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO category(cname) VALUES (?);";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
                
                 pstm.setString(1,cname);
               
              
                   
		 pstm.executeUpdate();
         
		
	
	}
         public void  updatecompany(String namecom,String idcompany) throws SQLException, ClassNotFoundException {
     		String sql = "UPDATE companyproduct SET namecom =? WHERE companyid= ?;";
     		 Connection conn=MySQLConntUtils.getMySQLConnection();
     		PreparedStatement pstm = conn.prepareStatement(sql);
                     
                      pstm.setString(1,namecom);
                      pstm.setString(2,idcompany);
                    
                   
                        
     		 pstm.executeUpdate();
              
     		
     	
     	}
         public void  updatecompanychitiet(String namecom,String picture,String icon,String diachi,String lienhe,String email,String idcompany) throws SQLException, ClassNotFoundException {
      		String sql = "UPDATE companyproduct SET namecom =?,picture=?,icon=?,diachi=?,lienhe=?,email=? WHERE companyid= ?;";
      		 Connection conn=MySQLConntUtils.getMySQLConnection();
      		PreparedStatement pstm = conn.prepareStatement(sql);
                      
                       pstm.setString(1,namecom);
                       pstm.setString(2,picture);
                       pstm.setString(3,icon);
                       pstm.setString(4,diachi);
                       pstm.setString(5,lienhe);
                       pstm.setString(6,email);
                       pstm.setString(7,idcompany);
                     
                    
                         
      		 pstm.executeUpdate();
               
      		
      	
      	}
         public void  deletecompany(String companyid) throws SQLException, ClassNotFoundException {
     		String sql = "DELETE FROM companyproduct WHERE companyid=?;";
     		 Connection conn=MySQLConntUtils.getMySQLConnection();
     		PreparedStatement pstm = conn.prepareStatement(sql);
                     
                      pstm.setString(1,companyid);
                    
                   
                        
     		 pstm.executeUpdate();
              
     		
     	
     	}
         public void  insertcompany(String namecompany) throws SQLException, ClassNotFoundException {
     		String sql = "INSERT INTO companyproduct(namecom,`picture`,`icon`,`diachi`,`lienhe`,`email`) VALUES (?,'NONE','NONE','NONE','NONE','NONE')";
     		 Connection conn=MySQLConntUtils.getMySQLConnection();
     		PreparedStatement pstm = conn.prepareStatement(sql);
                     
                      pstm.setString(1,namecompany);
                    
                   
                        
     		 pstm.executeUpdate();
              
     		
     	
     	}
         
     
         public int phantrangProduct() throws SQLException, ClassNotFoundException {
		String sql = "SELECT count(*) FROM product";
		 Connection conn=MySQLConntUtils.getMySQLConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
	
		ResultSet rs = pstm.executeQuery();
		
		while (rs.next()) {
			
	
			return rs.getInt(1);
		
         
		}
		return 0;
	
	}
         public static List<product> getnumberphantrangProduct(int index) throws SQLException, ClassNotFoundException {
     		String sql = "SELECT * FROM product limit ?,9;";
     		 Connection conn=MySQLConntUtils.getMySQLConnection();
     		PreparedStatement pstm = conn.prepareStatement(sql);
     	pstm.setInt(1,(index-1)*9);
     		ResultSet rs = pstm.executeQuery();
     		List<product> list = new ArrayList<product>();
     		while (rs.next()) {
     			
     	
     			int id = rs.getInt("id");
    			String name = rs.getString("name");
    			String image = rs.getString("image");
    			int price = rs.getInt("price");
    			String pricevnd = rs.getString("pricevnd");
    			int quantity = rs.getInt("quantity"); 
    			String khuyenmai = rs.getString("khuyenmai");
    			String cateidd = rs.getString("cateid");
    			String companyidd = rs.getString("companyid");
    		
    			product product = new product();
    			product.setId(id);
    			product.setName(name);
    			product.setImage(image);
    			product.setPrice(price);
    			product.setPricevnd(pricevnd);
    			product.setQuantity(quantity);
    			
    		product.setKhuyenmai(khuyenmai);
    	product.setCateid(cateidd);
    	product.setCompanyid(companyidd);
    			list.add(product);
     		
              
     		}
     		return list;
     	
     	}
         public static List<product> thaptoicaoProduct(int index) throws SQLException, ClassNotFoundException {
      		String sql = "SELECT * FROM product order by price asc limit ?,9";
      		 Connection conn=MySQLConntUtils.getMySQLConnection();
      		PreparedStatement pstm = conn.prepareStatement(sql);
      	pstm.setInt(1,(index-1)*9);
      		ResultSet rs = pstm.executeQuery();
      		List<product> list = new ArrayList<product>();
      		while (rs.next()) {
      			
      	
      			int id = rs.getInt("id");
     			String name = rs.getString("name");
     			String image = rs.getString("image");
     			int price = rs.getInt("price");
     			String pricevnd = rs.getString("pricevnd");
     			int quantity = rs.getInt("quantity"); 
     			String khuyenmai = rs.getString("khuyenmai");
     			String cateidd = rs.getString("cateid");
     			String companyidd = rs.getString("companyid");
     		
     			product product = new product();
     			product.setId(id);
     			product.setName(name);
     			product.setImage(image);
     			product.setPrice(price);
     			product.setPricevnd(pricevnd);
     			product.setQuantity(quantity);
     			
     		product.setKhuyenmai(khuyenmai);
     	product.setCateid(cateidd);
     	product.setCompanyid(companyidd);
     			list.add(product);
      		
               
      		}
      		return list;
      	
      	}
         public static List<product> caotoithapProduct(int index) throws SQLException, ClassNotFoundException {
       		String sql = "SELECT * FROM product order by price desc limit ?,9;";
       		 Connection conn=MySQLConntUtils.getMySQLConnection();
       		PreparedStatement pstm = conn.prepareStatement(sql);
       	pstm.setInt(1,(index-1)*9);
       		ResultSet rs = pstm.executeQuery();
       		List<product> list = new ArrayList<product>();
       		while (rs.next()) {
       			
       	
       			int id = rs.getInt("id");
      			String name = rs.getString("name");
      			String image = rs.getString("image");
      			int price = rs.getInt("price");
      			String pricevnd = rs.getString("pricevnd");
      			int quantity = rs.getInt("quantity"); 
      			String khuyenmai = rs.getString("khuyenmai");
      			String cateidd = rs.getString("cateid");
      			String companyidd = rs.getString("companyid");
      		
      			product product = new product();
      			product.setId(id);
      			product.setName(name);
      			product.setImage(image);
      			product.setPrice(price);
      			product.setPricevnd(pricevnd);
      			product.setQuantity(quantity);
      			
      		product.setKhuyenmai(khuyenmai);
      	product.setCateid(cateidd);
      	product.setCompanyid(companyidd);
      			list.add(product);
       		
                
       		}
       		return list;
       	
       	}
//         
//         public static Product getidProduct(Connection conn,String id) throws SQLException {
//     		String sql = "SELECT a.id, a.name, a.image, a.image1, a.price, a.mota, a.luuy, a.cateid, a.sellid, a.adminid FROM product a where a.id=?";
//
//     		PreparedStatement pstm = conn.prepareStatement(sql);
//     		 pstm.setString(1,id);
//     		ResultSet rs = pstm.executeQuery();
//     		
//     		while (rs.next()) {
//     			
//     			int idp = rs.getInt("id");
//     			String name = rs.getString("name");
//     			String image = rs.getString("image");
//     			String image1 = rs.getString("image1");
//     			
//     			String mota = rs.getString("mota");
//     			String luuy = rs.getString("luuy");
//     			String cateid = rs.getString("cateid");
//     			String sellid = rs.getString("sellid");
//     			String adminid = rs.getString("adminid");
//     			int Price = rs.getInt("Price");
//     		
//     			Product product = new Product();
//     			product.setId(idp);
//     			product.setName(name);
//     			product.setImage(image);
//     			product.setImage1(image1);
//     			product.setPrice(Price);
//     			product.setMota(mota);
//     			product.setLuuy(luuy);;
//     		
//     			product.setLuuy(luuy);
//     			product.setCateid(cateid);
//     			product.setAdminid(adminid);
//     			product.setSellid(sellid);
//     			
//     			return product;
//     		}
//     		return null;
//     	}
//
//     
     	 public List<Cart> getCartProducts(ArrayList<Cart> cartList) throws ClassNotFoundException {
     	        List<Cart> book = new ArrayList<>();
     	        try {
     	            if (cartList.size() > 0) {
     	                for (Cart item : cartList) {
     	                    String sql = "select * from product where id=?";
     	                    Connection conn=MySQLConntUtils.getMySQLConnection();
     	                    PreparedStatement pstm = conn.prepareStatement(sql);
     	                    pstm.setInt(1, item.getId());
     	                    ResultSet rs = pstm.executeQuery();
     	                    while (rs.next()) {
     	                        Cart row = new Cart();
     	                        row.setId(rs.getInt("id"));
     	                        row.setName(rs.getString("name"));
     	                        row.setImage(rs.getString("image"));
     	                        row.setPrice(rs.getInt("price")*item.getQuantity());
     	                        row.setQuantity(item.getQuantity());
     	                        book.add(row);
     	                    }

     	                }
     	            }

     	        } catch (SQLException e) {
     	            e.printStackTrace();
     	            System.out.println(e.getMessage());
     	        }
     	        return book;
     	    }
     	 public double getTotalCartPrice(ArrayList<Cart> cartList) throws ClassNotFoundException {
     	        double sum = 0;
     	        try {
     	            if (cartList.size() > 0) {
     	                for (Cart item : cartList) {
     	                    String sql = "select price from product where id=?";
     	                    Connection conn=MySQLConntUtils.getMySQLConnection();
     	                    PreparedStatement pstm = conn.prepareStatement(sql);
     	                    pstm.setInt(1, item.getId());
     	                    ResultSet rs = pstm.executeQuery();
     	                    while (rs.next()) {
     	                        sum+=rs.getDouble("price")*item.getQuantity();
     	                    }

     	                }
     	            }

     	        } catch (SQLException e) {
     	            e.printStackTrace();
     	            System.out.println(e.getMessage());
     	        }
     	        return sum;
     	    }
     	 public static void createbill(Connection conn, billproduct bproduct) throws SQLException {
     			String sql = "Insert into billproduct(idproduct, namecustomer,quantity,totalprice,nameproduct) values (?,?,?,?,?)";
     			PreparedStatement pstm = conn.prepareStatement(sql);
     			pstm.setString(1, bproduct.getIdproduct());
     			pstm.setString(2, bproduct.getNamecustomer());
     			
     			pstm.setInt(3, bproduct.getQuantity());
     			pstm.setInt(4, bproduct.getTotalprice());
     			pstm.setString(5, bproduct.getNameproduct());
     			pstm.executeUpdate();
     			}
     	 public static void deletebill(String namecustomer) throws SQLException, ClassNotFoundException {
  			String sql = "DELETE FROM billcustomer  where namecustomer=?";
  		  Connection conn=MySQLConntUtils.getMySQLConnection();
  			PreparedStatement pstm = conn.prepareStatement(sql);
  			pstm.setString(1, namecustomer);
  	
  			
  			pstm.executeUpdate();
  			}
     	 public static void deletedondagiao( String namecustomer) throws SQLException, ClassNotFoundException {
   			String sql = "DELETE FROM dondagiao  where namecustomer=?";
   		  Connection conn=MySQLConntUtils.getMySQLConnection();
   			PreparedStatement pstm = conn.prepareStatement(sql);
   			pstm.setString(1, namecustomer);
   	
   			
   			pstm.executeUpdate();
   			}
     	 public static void createcus(Connection conn,String namecus,String email,String address,String pay,String sdt) throws SQLException {
     			String sql = "Insert into billcustomer(namecustomer,email,address,pay,sdt,User_Name) values (?,?,?,?,?,'none');";
     			PreparedStatement pstm = conn.prepareStatement(sql);
     			pstm.setString(1, namecus);
     			pstm.setString(2, email);
     			pstm.setString(3, address);
     			pstm.setString(4, pay);
     			pstm.setString(5, sdt);
     			
     			pstm.executeUpdate();
     			}
    	 public static void createcomment(String username,String idpro,String content) throws SQLException, ClassNotFoundException {
  			String sql = "INSERT INTO commentuser\r\n"
  					+ "(User_Name,idproduct,commenttext)\r\n"
  					+ "VALUES\r\n"
  					+ "(?,?,?);";
  		  Connection conn=MySQLConntUtils.getMySQLConnection();
  			PreparedStatement pstm = conn.prepareStatement(sql);
  			pstm.setString(1, username);
  			pstm.setString(2, idpro);
  			pstm.setString(3, content);
  			
  			
  			pstm.executeUpdate();
  			}
     	 public static void updatebillcus(String email,String address,String pay,String sdt,String namecus) throws SQLException, ClassNotFoundException {
  			String sql = "UPDATE billcustomer SET email= ?, address= ?,pay= ?,sdt= ? WHERE namecustomer = ?";
  		  Connection conn=MySQLConntUtils.getMySQLConnection();
  			PreparedStatement pstm = conn.prepareStatement(sql);
  			
  			pstm.setString(1, email);
  			pstm.setString(2, address);
  			pstm.setString(3, pay);
  			pstm.setString(4, sdt);
  			pstm.setString(5, namecus);
  			pstm.executeUpdate();
  			}
     	  public static  List<comment> getcomment(String id) throws SQLException, ClassNotFoundException {
		 		String sql = "SELECT c.*,u.image FROM commentuser c,user_account u,product p where c.User_Name=u.User_Name and c.idproduct=p.id  and c.idproduct=?";
		 		  Connection conn=MySQLConntUtils.getMySQLConnection();
		 		PreparedStatement pstm = conn.prepareStatement(sql);
		               
		               pstm.setString(1, id);
		 		ResultSet rs = pstm.executeQuery();
		 		List<comment>  list = new ArrayList<comment>();
		 		while (rs.next()) {
		 			String nameuser = rs.getString("User_Name");
		 			int idd = rs.getInt("idproduct");
		                         String content = rs.getString("commenttext");
		                         String time = rs.getString("timecomment");
		                         String image = rs.getString("image");
		                         comment billcus=new comment();
		 			billcus.setUsername(nameuser);
		 			billcus.setContent(content);
		 			
		 			billcus.setIdproduct(idd);
		 			billcus.setTimeup(time);
		 			billcus.setIdcomment(image);
		 		
		 			list.add(billcus);
		 		}
		 		return list;
	     }
         public static  List<billcustomer> getcustomer() throws SQLException, ClassNotFoundException {
		 		String sql = "SELECT * FROM billcustomer";
		 		  Connection conn=MySQLConntUtils.getMySQLConnection();
		 		PreparedStatement pstm = conn.prepareStatement(sql);
		               
		 		ResultSet rs = pstm.executeQuery();
		 		List<billcustomer>  list = new ArrayList<billcustomer>();
		 		while (rs.next()) {
		 			String namecustomer = rs.getString("namecustomer");
		 			String email = rs.getString("email");
		                         String address = rs.getString("address");
		                         String pay = rs.getString("pay");
		                         String sdt = rs.getString("sdt");
		                         String ngaydat = rs.getString("ngaydat");
		                         billcustomer billcus=new billcustomer();
		 			billcus.setNamecustomer(namecustomer);
		 			billcus.setEmail(email);
		 			billcus.setAddress(address);
		 			billcus.setPay(pay);
		 			billcus.setSdt(sdt);
		 			billcus.setNgaydat(ngaydat);
		 			list.add(billcus);
		 		}
		 		return list;
	     }
         public static  billcustomer getidcustomer(String namecus) throws SQLException, ClassNotFoundException {
		 		String sql = "SELECT * FROM billcustomer where namecustomer=?";
		 		  Connection conn=MySQLConntUtils.getMySQLConnection();
		 		PreparedStatement pstm = conn.prepareStatement(sql);
		 		pstm.setString(1, namecus);
		 		ResultSet rs = pstm.executeQuery();
		 		List<billcustomer>  list = new ArrayList<billcustomer>();
		 		while (rs.next()) {
		 			String namecustomer = rs.getString("namecustomer");
		 			String email = rs.getString("email");
		                         String address = rs.getString("address");
		                         String pay = rs.getString("pay");
		                         String sdt = rs.getString("sdt");
		                         String ngaydat = rs.getString("ngaydat");
		                         billcustomer billcus=new billcustomer();
		 			billcus.setNamecustomer(namecustomer);
		 			billcus.setEmail(email);
		 			billcus.setAddress(address);
		 			billcus.setPay(pay);
		 			billcus.setSdt(sdt);
		 			billcus.setNgaydat(ngaydat);
		 			return billcus;
		 		}
		 		return null;
	     }
         public static  List<donhangdagiao> gethistoryordercustomer() throws SQLException, ClassNotFoundException {
    		 		String sql = "SELECT * FROM dondagiao;";
    		 		  Connection conn=MySQLConntUtils.getMySQLConnection();
    		 		PreparedStatement pstm = conn.prepareStatement(sql);
    		               
    		 		ResultSet rs = pstm.executeQuery();
    		 		List<donhangdagiao>  list = new ArrayList<donhangdagiao>();
    		 		while (rs.next()) {
    		 			String namecustomer = rs.getString("namecustomer");
    		 			String email = rs.getString("email");
    		                         String address = rs.getString("address");
    		                         String pay = rs.getString("pay");
    		                         String sdt = rs.getString("sdt");
    		                         String tinhtrang = rs.getString("tinhtrang");
    		                         String ngaydat = rs.getString("ngaygiao");
    		                         donhangdagiao billcus=new donhangdagiao();
    		 			billcus.setNamecustomer(namecustomer);
    		 			billcus.setEmail(email);
    		 			billcus.setAddress(address);
    		 			billcus.setPay(pay);
    		 			billcus.setSdt(sdt);
    		 			billcus.setNgaydat(ngaydat);
    		 			billcus.setTinhtrang(tinhtrang);
    		 			list.add(billcus);
    		 		}
    		 		return list;
    	     }
         public static  billproduct getbillproduct(String namecus) throws SQLException, ClassNotFoundException {
		 		String sql = "SELECT * FROM billproduct where namecustomer=?";
		 		  Connection conn=MySQLConntUtils.getMySQLConnection();
		 		PreparedStatement pstm = conn.prepareStatement(sql);
		 		pstm.setString(1, namecus);
		 		ResultSet rs = pstm.executeQuery();
		 		List<billproduct>  list = new ArrayList<billproduct>();
		 		while (rs.next()) {
		 			String idproduct = rs.getString("idproduct");
		 			String namecustomer = rs.getString("namecustomer");
		 			String nameproduct = rs.getString("nameproduct");
		                         int quantity = rs.getInt("quantity");
		                         int totalp = rs.getInt("totalprice");
		                        
		                         billproduct billp=new billproduct();
		                         billp.setNameproduct(nameproduct);        
		 			billp.setNamecustomer(namecustomer);
		 			billp.setIdproduct(idproduct);;
		 			billp.setQuantity(quantity);;
		 			billp.setTotalprice(totalp);;
		 			
		 		return billp;
		 		}
		 		return null;
	     }
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
//     	  public static  Product checkidProduct(int id) throws SQLException, ClassNotFoundException {
//  	 		String sql = "SELECT * FROM product "+"WHERE id=?";
//  	                 Connection conn=MySQLConntUtils.getMySQLConnection();
//  	 		PreparedStatement pstm = conn.prepareStatement(sql);
//  	                   pstm.setInt(1,id);
//  	 		ResultSet rs = pstm.executeQuery();
//  	 		
//  	 		while (rs.next()) {
//  	 			int idd = rs.getInt("id");
//  	 			String name = rs.getString("name");
//  	                         String image = rs.getString("image");
//  	 			int price = rs.getInt("price");
//  	 			Product product = new Product();
//  	 			product.setId(idd);
//  	 			product.setName(name);
//  	                         product.setImage(image);
//  	 			product.setPrice(price);
//  	 			return product;
//  	 		}
//  	 		return null;
//  	     } 	
}
