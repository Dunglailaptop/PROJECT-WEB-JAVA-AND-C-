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
List<companyproduct> com2 = null;
List<companyproduct> com = null;	
		DBUtils db= new DBUtils();
		cate=db.getcategory();
		com=db.getcompanyproduct();
         com2=db.getproducer();
		
		request.setAttribute("cate", cate);
	
		request.setAttribute("com", com);
		request.setAttribute("pro", com2);
	
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
  
      
        <div class="row g-4" >
            <div class="col-sm-12 col-xl-6">
                <div class="bg-secondary rounded h-100 p-4">
                    <h6 class="mb-4">add new company</h6>
                   <form action="insertcompany" method="get">
                           <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">name company</label>
                            <input name="namecom" type="text" value="" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp">
                           
                        </div>
                         <button type="submit" class="btn btn-primary" style="MARGIN-TOP: 15PX;WIDTH: 50%;">add company</button>
                    </form>   
                       
                       
                         
                   
                  
                    
     
            
               
                   
                       
                     
                
             
       
             
                </div>
               
            </div>
                 <div class="col-sm-12 col-xl-6">
                <div class="bg-secondary rounded h-100 p-4">
                    <h6 class="mb-4">Accented Table</h6>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                              
                                <th scope="col">id </th>
                                <th scope="col">name </th>
                             <th scope="col">edit</th>
                       
                        
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${com}" var="o">
                         <tr>
                                <th scope="row">${o.companyid}</th>
                                 <form action="updatecompany" method="get">
                                <td><input name="namecom" type="text" value="${o.namecompany}"/></td>
                               
                                    <input name="id" hidden type="text" value="${o.companyid}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                           
                                    
                                <td>
                                 <c:if test="${sessionScope.acc.idadmin==3}">
                    ban phai la admin
                    </c:if> 
                                 <c:if test="${sessionScope.acc.idadmin==1}">
                                 <button type="submit" class="btn btn-success"><a style="color:white;">update</a></button>
                                  <button type="button" class="btn btn-success"><a style="color:red;" href="deletecompany?idd=${o.companyid}">delete</a></button></td>
                                 </c:if>
                                
                                  </form>
                            </tr>
                        </c:forEach>
                           
                        
                        </tbody>
                    </table>
                </div>
            </div>
             
             <div class="col-12">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4">chi tiết nhà cung cấp sản phẩm</h6>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">nha san xuat</th>
                                            <th scope="col">dia chi</th>
                                            <th scope="col">lien he</th>
                                            <th scope="col">email</th>
                                             <th scope="col">picture</th>
                                              <th scope="col">icon</th>
                                            <th scope="col">edit</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pro}" var="o">
                                  <form action="updateproducer" method="post" enctype="multipart/form-data">
                               
                                        <tr>
                                         <input hidden name="companyid" value="${o.companyid}" type="text">
                                            <td><input name="namecom" value="${o.namecompany}" type="text"></td>
                                            <td><input  name="diachi" value="${o.diachi}"  type="text"></td>
                                            <td><input  name="lienhe" value="${o.lienhe}"  type="text"></td>
                                            <td><input  name="email" value="${o.email}"  type="text"></td>
                                         <td><img src="${o.picture}" style="width: 50%;height: auto;"/>
                                         <input  name="picture"   type="file"></td>
                                         <td><img src="${o.icon}" style="width: 50%;height: auto;"/>
                                         <input  name="icon"   type="file"></td>
                                            <td>
                                             <c:if test="${sessionScope.acc.idadmin==1}">
                                              <button type="submit" class="btn btn-success"><a style="color:white;">update</a></button>
                                             </c:if>
                                
                                
                                        </tr>
                                           </form>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
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