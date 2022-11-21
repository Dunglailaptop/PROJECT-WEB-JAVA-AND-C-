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

request.setAttribute("dcf", dcf);

List<donhangdagiao> listc = null;
	
		DBUtils db= new DBUtils();
		
			listc = db.gethistoryordercustomer();
			
		
		
		
		request.setAttribute("cus", listc);
		
	
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
   <div class="col-12" style="padding:15px;">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4">order by customer</h6>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                          
                                            <th scope="col">tênngườimua</th>
                                            <th scope="col">địachỉ</th>
                                         
                                            <th scope="col">hìnhthứcthanhtoán</th>
                                            
                                                 <th scope="col">email</th>
                                                     <th scope="col">SĐT</th>
                                                     <th scope="col">ngàyđặt</th>
                                                      <th scope="col">giaohang</th>
                                               <th scope="col">xemchitietsp</th>
                                            <th scope="col">edit</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <c:forEach items="${cus}" var="o">
                                        <tr>
                                     
                                       
                                          
                                            <td>${o.namecustomer}</td>
                                             <input hidden name="" value=""/>
                                            <td>${o.address}</td>
                                             <input hidden name="" value=""/>
                                            <td>${o.pay}</td>
                                             <input hidden name="" value=""/>
                                         <td>${o.email}</td>
                                               <input hidden name="" value=""/>
                                         <td>${o.sdt}</td>
                                           <td>${o.ngaydat}</td>
                                            
                                            <td> ${o.tinhtrang}
                                            </td>
                                            
                                            <td> <button type="button" class="btn btn-success rounded-pill m-2"><a href="chitietproduct.jsp?namecus=${o.namecustomer}">xem</a></button>
                                            </td>
                                            <td>    <div class="btn-group" role="group">
                                <input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off">
                                <label class="btn btn-outline-primary" for="btncheck1">sửa</label>

                                <input type="checkbox" class="btn-check" id="btncheck2" autocomplete="off">
                                <label class="btn btn-outline-primary" for="btncheck2">xóa</label>

                                
                            </div></td>
                                        </tr>
                                            </c:forEach>
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