package object;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class product {
    private int id;
     private String name;
      private String image;
       private String image1;
        private String image2;
         private String image3;
          private String image4;
           private String image5;
       private int price;
         private String pricevnd;
        private String cateid;
        private int quantity;
private String companyid;
private String sellid;
private String adminid;
private category cate;
private companyproduct company;
private String mota;
private String khuyenmai;
public product(){

}
   public product(int id, String name, String image, String image1, String image2, String image3, String image4, String image5, int price, String pricevnd, String cateid, int quantity, String companyid, String sellid, String adminid) {
       this.id = id;
       this.name = name;
       this.image = image;
       this.image1 = image1;
       this.image2 = image2;
       this.image3 = image3;
       this.image4 = image4;
       this.image5 = image5;
       this.price = price;
       this.pricevnd = pricevnd;
       this.cateid = cateid;
       this.quantity = quantity;
       this.companyid = companyid;
       this.sellid = sellid;
       this.adminid = adminid;
   }

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getImage() {
       return image;
   }

   public void setImage(String image) {
       this.image = image;
   }

   public String getImage1() {
       return image1;
   }

   public void setImage1(String image1) {
       this.image1 = image1;
   }

   public String getImage2() {
       return image2;
   }

   public void setImage2(String image2) {
       this.image2 = image2;
   }

   public String getImage3() {
       return image3;
   }

   public void setImage3(String image3) {
       this.image3 = image3;
   }

   public String getImage4() {
       return image4;
   }

   public void setImage4(String image4) {
       this.image4 = image4;
   }

   public String getImage5() {
       return image5;
   }

   public void setImage5(String image5) {
       this.image5 = image5;
   }

   public int getPrice() {
       return price;
   }

   public void setPrice(int price) {
       this.price = price;
   }

   public String getPricevnd() {
       return pricevnd;
   }

   public void setPricevnd(String pricevnd) {
       this.pricevnd = pricevnd;
   }

   public String getCateid() {
       return cateid;
   }

   public void setCateid(String cateid) {
       this.cateid = cateid;
   }

   public int getQuantity() {
       return quantity;
   }

   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }

   public String getCompanyid() {
       return companyid;
   }

   public void setCompanyid(String companyid) {
       this.companyid = companyid;
   }

   public String getSellid() {
       return sellid;
   }

   public void setSellid(String sellid) {
       this.sellid = sellid;
   }

   public String getAdminid() {
       return adminid;
   }

   public void setAdminid(String adminid) {
       this.adminid = adminid;
   }

   public product(int id, String name, String image, String image1, String image2, String image3, String image4, String image5, int price, String pricevnd, String cateid, int quantity, String companyid, String sellid, String adminid, category cate, companyproduct company) {
       this.id = id;
       this.name = name;
       this.image = image;
       this.image1 = image1;
       this.image2 = image2;
       this.image3 = image3;
       this.image4 = image4;
       this.image5 = image5;
       this.price = price;
       this.pricevnd = pricevnd;
       this.cateid = cateid;
       this.quantity = quantity;
       this.companyid = companyid;
       this.sellid = sellid;
       this.adminid = adminid;
       this.cate = cate;
       this.company = company;
   }

   public category getCate() {
       return cate;
   }

   public void setCate(category cate) {
       this.cate = cate;
   }

   public companyproduct getCompany() {
       return company;
   }

   public void setCompany(companyproduct company) {
       this.company = company;
   }

   public product(int id, String name, String image, String image1, String image2, String image3, String image4, String image5, int price, String pricevnd, String cateid, int quantity, String companyid, String sellid, String adminid, category cate, companyproduct company, String mota, String khuyenmai) {
       this.id = id;
       this.name = name;
       this.image = image;
       this.image1 = image1;
       this.image2 = image2;
       this.image3 = image3;
       this.image4 = image4;
       this.image5 = image5;
       this.price = price;
       this.pricevnd = pricevnd;
       this.cateid = cateid;
       this.quantity = quantity;
       this.companyid = companyid;
       this.sellid = sellid;
       this.adminid = adminid;
       this.cate = cate;
       this.company = company;
       this.mota = mota;
       this.khuyenmai = khuyenmai;
   }

   public String getMota() {
       return mota;
   }

   public void setMota(String mota) {
       this.mota = mota;
   }

   public String getKhuyenmai() {
       return khuyenmai;
   }

   public void setKhuyenmai(String khuyenmai) {
       this.khuyenmai = khuyenmai;
   }

 
 

  
        
}
