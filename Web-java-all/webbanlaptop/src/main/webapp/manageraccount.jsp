<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="Servlets.*"%>
<%@page import="java.util.*"%>
<%@page import="object.*"%>
<%@page import="Model.*"%>
<%@page import="java.text.DecimalFormat"%>

<%


List<phanquyen> cate = null;
List<UserAccount> user = null;	
		DBUtils db= new DBUtils();
		
			user=db.showallUser();
			cate=db.showphanquyen();
		
	
	
		
		
		request.setAttribute("quyen", cate);
		request.setAttribute("user", user); 

		
	
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
  <div class="col-12" style="margin: 15px;">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4">quản lý tài khoản</h6>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                         <th scope="col">ảnh</th>
                                            <th scope="col">tên tài khoản</th>
                                            <th scope="col">email</th>
                                            <th scope="col">sdt</th>
                                        
                                              <th scope="col">phân quyền</th>
                                            <th scope="col">edit</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                 
                                <c:forEach items="${user}" var="o">
                                 <tr>
                                        <td> <div class="position-relative">
                        <img class="rounded-circle" src="${o.image}" alt="" style="width: 40px; height: 40px;">
                        
                    </div></td>
                                         <td>${o.userName}</td>
                                         
                                          <td>${o.email}</td>
                                            <td>${o.phone}</td>
                                          <td>   <select class="form-control" onchange="location = this.value;">
                                           <option  value="">${o.password} quyền hiện tại</option>
                                           <c:if test="${sessionScope.acc.idadmin==1}">
                                               <c:forEach items="${quyen}" var="i">
                                          
                                           <option  value="updatequyen?id=${i.idadmin}&username=${o.userName}">${i.namequyen}</option>
                                          </c:forEach>
                                           </c:if>
                                      
                                 
                               
                            </select></td>   
                                  <td> <div class="btn-group" role="group">
                                <c:if test="${sessionScope.acc.idadmin==1}">
                                 <button type="button" class="btn btn-primary"><a href="deleteaccount?usernn=${o.userName}">delete</a></button>
                                  <form action="lockacc" method="get">
                                <input hidden name="user" value="${o.userName}" type="text">
                                <input hidden name="number" value="1" type="text">
                                <button type="submit" class="btn btn-primary">lock account</button>
                                </form>
                                </c:if>
                               
                              
                                
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