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
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link rel="stylesheet" href="styles/cate.css" />
    
<link rel="stylesheet" href="styles/styles.css" />
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link rel="stylesheet" href="styles/cate.css" />
   <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/edit.css">
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Youtube UI Clone</title>
</head>
  <body style="background-color:#1a1a1a;">
    <!-- Header Starts -->
   <jsp:include page="header.jsp"></jsp:include>
    <!-- Header Ends -->

   

     <jsp:include page="category.jsp"></jsp:include>
      <!-- Sidebar Ends -->
     <div class="col-12" style="padding-left: 20%;padding-right: 10%;margin: 15px;padding-top: 4%;/* border: 1px solid; */">
                        <div class="bg-secondary rounded h-100 p-4" style="
    border: 4px solid red;">
    <a href="accountlock.jsp" style="color:red;">account lock</a><a href="mangeraccount.jsp"  style="color:red;">/mangeraccount</a>
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
  <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
     <script src="js/script.js"></script>
</html>