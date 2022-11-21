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
  
      
        <div class="row g-4" >
            <div class="col-sm-12 col-xl-6">
                <div class="bg-secondary rounded h-100 p-4">
                    <h6 class="mb-4">add new category</h6>
                   <form action="createcategory" method="get">
                           <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">name category</label>
                            <input name="cname" type="text" value="" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp">
                           
                        </div>
                         <button type="submit" class="btn btn-primary" style="MARGIN-TOP: 15PX;WIDTH: 50%;">add category</button>
                    </form>   
                       
                       
                         
                   
                  
                    
     
            
               
                   
                       
                     
                
             
       
             
                </div>
               
            </div>
              
             
           
            
            <div class="col-sm-12 col-xl-6">
                <div class="bg-secondary rounded h-100 p-4">
                    <h6 class="mb-4">Accented Table</h6>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                              
                                <th scope="col">id category</th>
                                <th scope="col">name category</th>
                             <th scope="col">edit</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cate}" var="o">
                         <tr>
                                <th scope="row">${o.cateid}</th>
                                 <form action="updatecategory" method="get">
                                <td><input name="cname" type="text" value="${o.cname}"/></td>
                                    <input name="idc" hidden type="text" value="${o.cateid}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                           
                                    
                                <td>
                                 <button type="submit" class="btn btn-success"><a style="color:white;">update</a></button>
                                 <button type="button" class="btn btn-success"><a style="color:red;" href="deletecateid?cateidd=${o.cateid}">delete</a></button></td>
                                  </form>
                            </tr>
                        </c:forEach>
                           
                        
                        </tbody>
                    </table>
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