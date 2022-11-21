<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

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
                <div class="row g-4">
                
                  <div class="col-12">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4">danh sách sản phẩm</h6>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">STT</th>
                                           
                                            <th scope="col">picture</th>
                                            <th scope="col">name product</th>
                                            <th scope="col">producer</th>
                                            <th scope="col">type</th>
                                             <th scope="col">quantity</th>
                                            <th scope="col">price</th>
                                               <th scope="col">parameter/edit</th>
                                           
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                      <c:forEach items="${productList}" var="o">  
                                        <tr>
                                            <th scope="row">${o.id}</th>

                                            <td><img style="width: 50px;
                                                height: auto;"  src="${o.image}"/>
                                            <button type="button" class="btn btn-outline-info m-2"><a href="picshow?idp=${o.id}">list</a></button>    
                                            </td>
                                            <td>${o.name}</td>
                                            <td>${o.companyid}</td>
                                            <td>${o.cateid}</td>
                                                 <td>${o.quantity}</td>
                                                   <td>${o.price}</td>
                                              <td><div class="btn-group" role="group">
                                <button type="button" class="btn btn-danger"><a style="color:white;" href="showinforproduct?idp=${o.id}">xem</a></button>
                                  <c:if test="${sessionScope.acc.idadmin==1}">
                                   <button type="button" class="btn btn-warning"><a style="color:white;" href="deleteproduct?idd=${o.id}">delete</a></button>
                                  </c:if>
                               
                                <button type="button" class="btn btn-success"><a style="color:white;" href="showinforupdate?idd=${o.id}">update</a></button>
                            </div></td>
                                             
                           
                               
                        
                                        </tr>
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