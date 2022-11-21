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
        <form action="addproduct" method="POST"  enctype="multipart/form-data">
       
        <div class="row g-4" >
            <div class="col-sm-12 col-xl-6">
                <div class="bg-secondary rounded h-100 p-4">
                    <h6 class="mb-4">thêm sản phẩm</h6>
                 
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Tên sản phẩm</label>
                            <input name="name" type="text" class="form-control" 
                               >
                            
                        </div>
                     
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">số lượng</label>
                            <input name="quantity" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Đơn giá</label>
                            <input name="price" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">thành tiền</label>
                            <input name="pricevnd" type="text" class="form-control" >
                        </div>
                         <label for="exampleInputPassword1" class="form-label">producer</label>
                        <select class="form-select mb-3" name="companyid" aria-label="Default select example">
                          
                              <c:forEach items="${com}" var="o"> <option value="${o.companyid}">${o.namecompany}</option>
                              </c:forEach>
                           
                            
                        </select>
                          <label for="exampleInputPassword1" class="form-label">category</label>
                        <select class="form-select mb-3" name="cateid" aria-label="Default select example">
                          
                            <c:forEach items="${cate}" var="c">
                               <option value="${c.cateid}">${c.cname}</option>
                            </c:forEach>
                         
                         
                        </select>
                        <div class="mb-3">
                            <label for="formFileMultiple" class="form-label">ảnh detail</label>
                            <input name="image" class="form-control bg-dark" type="file" id="formFileMultiple" multiple>
                        </div>
                        <div class="mb-3">
                            <label  hidden  for="formFileMultiple" class="form-label">ảnh phụ 1</label>
                            <input name="image1" hidden value="images/null" class="form-control bg-dark" type="text" id="formFileMultiple" multiple>
                        </div>
                        <div class="mb-3">
                            <label  hidden  for="formFileMultiple" class="form-label">ảnh phụ 2</label>
                            <input   name="image2" hidden value="images/null" class="form-control bg-dark" type="text" id="formFileMultiple" multiple>
                        </div>
                        <div class="mb-3">
                            <label  hidden  for="formFileMultiple" class="form-label">ảnh phụ 3</label>
                            <input  name="image3" hidden value="images/null" class="form-control bg-dark" type="text" id="formFileMultiple" multiple>
                        </div>
                        <div class="mb-3">
                            <label  hidden  for="formFileMultiple" class="form-label">ảnh phụ 4</label>
                            <input  name="image4" hidden value="images/null" class="form-control bg-dark" type="text" id="formFileMultiple" multiple>
                        </div>
                        <div class="mb-3">
                            <label  hidden  for="formFileMultiple" class="form-label">ảnh phụ 5</label>
                            <input  name="image5" hidden value="images/null" class="form-control bg-dark" type="text" id="formFileMultiple" multiple>
                        </div>
                       
                  
                </div>
            </div>
            <div class="col-sm-12 col-xl-6">
                <div class="bg-secondary rounded h-100 p-4">
                   
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">CPU</label>
                            <input name="CPU" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">GPU</label>
                            <input name="GPU" type="text" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">DISPLAY</label>
                            <input name="DISPLAY" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">RAM</label>
                            <input name="RAM" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">SSD</label>
                            <input name="SSD" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">WEIGHT</label>
                            <input name="WEIGHT" type="text" class="form-control" >
                        </div>
                        <div class="form-floating" style="PADDING-BOTTOM: 10PX;">
                            <textarea name="mota" class="form-control" placeholder="Leave a comment here"
                                id="floatingTextarea" style="height: 150px;"></textarea>
                            <label for="floatingTextarea">MÔ TẢ THÊM</label>
                        </div>
                        <div class="form-floating">
                            <textarea name="khuyenmai" class="form-control" placeholder="Leave a comment here"
                                id="floatingTextarea" style="height: 150px;"></textarea>
                            <label for="floatingTextarea">KHUYẾN MẠI VÀ QUÀ TẶNG</label>
                        </div>
                         
                        <button type="submit" class="btn btn-primary" onclick="return send();" style="MARGIN-TOP: 15PX;WIDTH: 50%;">ADD PRODUCT</button>
                        <button type="reset" class="btn btn-primary" style="MARGIN-TOP: 15PX;WIDTH: 50%;">CLEAR</button>
                </div>
            </div>
            </div>
        </form>
            </div>
   <div id="baoloi" style="color:red;"></div>
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
function send(){
	 var name = 'Please enter your name';
		var loi="";
		var arr=document.getElementsByTagName('input');
		var arr1=arr[1].value;
		var arr2=arr[2].value;
		var arr3=arr[3].value;
		var arr4=arr[4].value;
		var arr5=arr[5].value;
		var arr6=arr[6].value;
		var arr7=arr[7].value;
		var arr8=arr[8].value;
		var arr9=arr[9].value;
		var arr10=arr[10].value;
		var arr11=arr[11].value;
		var arr12=arr[12].value;
		var arr13=arr[13].value;
		var arr14=arr[14].value;
		var arr15=arr[15].value;
		var arr16=arr[16].value;
		var arr17=arr[17].value;
		var arr18=arr[18].value;
		if(arr1==""||arr2==""||arr3==""||arr4==""||arr5==""||arr6==""||arr7==""||arr8=""||arr9=""||arr10=""||arr11=""||arr12=""||arr13=""||arr14=""||arr15=""||arr16=""||arr17=""||arr18=""){
			loi="không được bỏ trống.<br>";
			
		
		}
		
		if(loi!=""){
			document.getElementById('baoloi').innerHTML=loi;
			return false;
		}
}

</script>
</html>