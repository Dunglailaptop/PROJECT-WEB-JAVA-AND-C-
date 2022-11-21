<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="Servlets.*"%>
<%@page import="java.util.*"%>
<%@page import="object.*"%>
<%@page import="Model.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%


List<category> cate = null;
List<companyproduct> com = null;	

		DBUtils db= new DBUtils();
		cate=db.getcategory();
		com=db.getcompanyproduct();
	
		
		request.setAttribute("cate", cate);

		request.setAttribute("com", com);
		
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="assets1/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="assets1/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="assets1/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="assets1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="assets1/css/style.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="categoryadmin.jsp"></jsp:include>
  <div class="content">

     <jsp:include page="headeradmin.jsp"></jsp:include>
      <div class="container-fluid pt-4 px-4">
        <form action="updateproduct" method="post"  enctype="multipart/form-data">
       
        <div class="row g-4" >
            <div class="col-sm-12 col-xl-6" STYLE="MARGIN:30PX;">
                <div class="bg-secondary rounded h-100 p-4">
                    <h6 class="mb-4">thêm sản phẩm</h6>
                 
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Tên sản phẩm</label>
                            <input name="name" value="${list.name}" type="text" class="form-control" 
                               >
                            
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">mã sản phẩm:</label>
                           
                            <input name="id" hidden readonly value="${list.id}" type="text" class="form-control" 
                               >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">số lượng</label>
                            <input name="quantity"  value="${list.quantity}"  type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Đơn giá</label>
                            <input name="price"  value="${list.price}"  type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">thành tiền</label>
                            <input name="pricevnd"  value="${list.pricevnd}" type="text" class="form-control" >
                        </div>
                       <label for="exampleInputPassword1" class="form-label">producer</label>
                        <select class="form-select mb-3" name="companyid" aria-label="Default select example">
                         <label for="exampleInputPassword1" class="form-label">producer</label>
                              <c:forEach items="${com}" var="o"> <option value="${o.companyid}">${o.namecompany}</option>
                              </c:forEach>
                           
                            
                        </select>
                        <label for="exampleInputPassword1" class="form-label">category</label>
                        <select class="form-select mb-3" name="cateid" aria-label="Default select example">
                          <label for="exampleInputPassword1" class="form-label">category</label>
                            <c:forEach items="${cate}" var="c">
                               <option value="${c.cateid}">${c.cname}</option>
                            </c:forEach>
                         
                         
                        </select>
                         <div class="mb-3">
                            <label for="formFileMultiple" class="form-label">ảnh detail</label>
                            <img src="${list.image}" style="width: 40%;
    height: auto;
    padding: 12px;"/>
     <input name="imageold" hidden value="${list.image}" type="text" class="form-control" >
                        </div>
                          <div class="mb-3">
                           <label for="formFileMultiple" class="form-label">ảnh mới</label>
                            <input name="image"  class="form-control bg-dark" type="file" id="formFileMultiple" multiple>
                          </div>
                  <button type="submit" class="btn btn-primary" style="MARGIN-TOP: 15PX;WIDTH: 50%;">UPDATE PRODUCT</button>
                 
                </div>
            </div>
          
                        
                        
                </div>
            </div>
            </div>
        </form>
            </div>
   
  </div>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets1/lib/chart/chart.min.js"></script>
    <script src="assets1/lib/easing/easing.min.js"></script>
    <script src="assets1/lib/waypoints/waypoints.min.js"></script>
    <script src="assets1/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="assets1/lib/tempusdominus/js/moment.min.js"></script>
    <script src="assets1/lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="assets1/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="assets1/js/main.js"></script>
</body>
  <script>
function kiemtra(){
	var loi="";

	//kt phai
	dem=0;
	var gender=document.getElementsByName("gender");
	for(var i=0;i<gender.length;i++){
		if(gender[i].checked) dem++;
	}
	if(dem==0){
		document.getElementById("fs1").className="loi";
		loi+="chon laptop product hoac phukien neu chon phukien ban co the ko can nhap thong so laptop&pc.<br>";
	}else document.getElementById("fs1").className="";
	//kt xac nhan mk
	
	;
	if(loi!=""){
		document.getElementById('baoloi').innerHTML=loi;
		return false;
	}
}

</script>
</html>