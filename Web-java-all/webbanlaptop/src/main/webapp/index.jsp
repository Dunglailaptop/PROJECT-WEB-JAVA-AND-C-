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
List<product> list = null;	
		DBUtils db= new DBUtils();
		list=db.topsellerProduct();
		
	
		
		request.setAttribute("product", list);


	
		
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
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
</head>
<body>
<jsp:include page="headerweb.jsp"></jsp:include>
  <!-- Start Categories of The Month -->
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">LAPTOP GAMING</h1>
                <p>
                   
                </p>
            </div>
        </div>
       
           <div class="row">
            <c:forEach items="${pro}" var="o">
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img src="${o.picture}" class=" img-fluid border"></a>
                <h5 class="text-center mt-3 mb-3">${o.namecompany}</h5>
                <p class="text-center"><a href="phantrangproduct?num=1" class="btn btn-success">Go Shop</a></p>
            </div>
            </c:forEach>
          
        </div>
        
     
    </section>
    <!-- End Categories of The Month -->


    <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">BÁN CHẠY (TOP SELLER)</h1>
                    <p>
                        
                    </p>
                </div>
            </div>
            <div class="row">
               
              <c:forEach items="${product}" var="o">
               <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a href="singleproduct?idp=${o.id}&cateid=${o.cateid}">
                            <img src="${o.image}" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                                <li class="text-muted text-right">${o.pricevnd}</li>
                            </ul>
                            <a href="singleproduct?idp=${o.id}&cateid=${o.cateid}" class="h2 text-decoration-none text-dark">${o.name}</a>
                            <p class="card-text">
                              
                                <span>${o.mota}</span>
                            </p>
                            <p class="text-muted">Reviews (24)</p>
                        </div>
                    </div>
                </div>
              </c:forEach>
            </div>
        </div>
    </section>
    <!-- End Featured Product -->
    <jsp:include page="footerweb.jsp"></jsp:include>
        <!-- Start Script -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
    <!-- End Script -->
</body>
   ${emaill}
</html>