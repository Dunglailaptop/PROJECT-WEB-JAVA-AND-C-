<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%@page import="object.*"%>
<%@page import="Model.*"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="Servlets.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%
DecimalFormat dcf = new DecimalFormat("#.##");
String namecus=request.getParameter("namecus");
request.setAttribute("dcf", dcf);
billproduct listp=new billproduct();
billcustomer listc = null;
	
		DBUtils db= new DBUtils();
		
		listp=db.getbillproduct(namecus);
			
		
		
		listc = db.getidcustomer(namecus);
		request.setAttribute("cus", listp);

		
		
		
			
			
		
		
		
		request.setAttribute("customer", listc);
	
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
       <div class="col-sm-12 col-xl-6" >
                        <div class="bg-secondary rounded h-100 p-4" style="margin:15px;">
                            <h6 class="mb-4">Horizontal Form</h6>
                            <form action="updatebillcustomer" method="get">
                                <div class="row mb-3">
                                    <label for="inputEmail3" class="col-sm-2 col-form-label">name customer</label>
                                    <div class="col-sm-10">
                                        <input name="namecus" readonly type="text" value="${customer.namecustomer}" class="form-control" id="inputEmail3">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-2 col-form-label">email</label>
                                    <div class="col-sm-10">
                                        <input name="email" type="text" value="${customer.email}" class="form-control" id="inputPassword3">
                                    </div>
                                </div>
                                 <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-2 col-form-label">pay</label>
                                    <div class="col-sm-10">
                                        <input  name="pay" type="text" value="${customer.pay}" class="form-control" id="inputPassword3">
                                    </div>
                                </div>
                                 <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-2 col-form-label">address</label>
                                    <div class="col-sm-10">
                                        <input name="address" type="text" value="${customer.address}" class="form-control" id="inputPassword3">
                                    </div>
                                </div>
                                 <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-2 col-form-label">SDT</label>
                                    <div class="col-sm-10">
                                        <input name="sdt" type="text" value="${customer.sdt}" class="form-control" id="inputPassword3">
                                    </div>
                                </div>
                           
                                <button type="submit" class="btn btn-primary">update</button>
                            </form>
                        </div>
                    </div>
   <div class="col-12" style="padding:15px;">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4">chi tiết đơn hàng</h6>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                          
                                            <th scope="col">tên người mua</th>
                                            <th scope="col">mã sản phẩm</th>
                                          <th scope="col">tên sản phẩm</th>
                                            <th scope="col">số lượng</th>
                                            
                                                 <th scope="col">thành tiền</th>
                                                    
                                                     
                                                     
                                              
                                        </tr>
                                    </thead>
                                    <tbody>
                                       
                                        <tr>
                                           <input hidden name="" value=""/>
                                            <td>${cus.namecustomer}</td>
                                             <input hidden name="" value=""/>
                                            <td>${cus.idproduct}</td>
                                             <input hidden name="" value=""/>
                                             <td>${cus.nameproduct}</td>
                                            <td>${cus.quantity}</td>
                                             <input hidden name="" value=""/>
                                         <td>${cus.totalprice}</td>
                                               <input hidden name="" value=""/>
                                          
                                   
                                        </tr>
                                            
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

  </div>
</body>
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
</html>