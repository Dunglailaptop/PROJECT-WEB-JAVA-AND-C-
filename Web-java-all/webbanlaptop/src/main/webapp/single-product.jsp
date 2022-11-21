
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




String id=request.getParameter("idp");
List<object.comment> com=null;

	com=DBUtils.getcomment(id);

request.setAttribute("usercomment", com);



		
	
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Zay Shop - Product Detail Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="assets/css/commet.css" rel="stylesheet" >
    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">

    <!-- Slick -->
    <link rel="stylesheet" type="text/css" href="assets/css/slick.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/slick-theme.css">
<!--
    
TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

-->
</head>

<body>
  <jsp:include page="headerweb.jsp"></jsp:include>

    <!-- Open Content -->
    <section class="bg-light">
        <div class="container pb-5">
            <div class="row">
                <div class="col-lg-5 mt-5">
                    <div class="card mb-3">
                        <img class="card-img img-fluid" style="HEIGHT: 500PX;" src="${product.image}" alt="Card image cap" id="product-detail">
                    </div>
                    <div class="row">
                        <!--Start Controls-->
                        <div class="col-1 align-self-center">
                            <a href="#multi-item-example" role="button" data-bs-slide="prev">
                                <i class="text-dark fas fa-chevron-left"></i>
                                <span class="sr-only">Previous</span>
                            </a>
                        </div>
                        <!--End Controls-->
                        <!--Start Carousel Wrapper-->
                        <div id="multi-item-example" class="col-10 carousel slide carousel-multi-item" data-bs-ride="carousel">
                            <!--Start Slides-->
                            <div class="carousel-inner product-links-wap" role="listbox">

                                <!--First slide-->
                                <div class="carousel-item active">
                                    <div class="row">
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.image}" alt="Product Image 1">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.image1}" alt="Product Image 2">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.image2}" alt="Product Image 3">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!--/.First slide-->

                                <!--Second slide-->
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.image3}" alt="Product Image 4">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.image4}" alt="Product Image 5">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.image5}" alt="Product Image 6">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!--/.Second slide-->

                                <!--Third slide-->
                              
                                <!--/.Third slide-->
                            </div>
                            <!--End Slides-->
                        </div>
                        <!--End Carousel Wrapper-->
                        <!--Start Controls-->
                        <div class="col-1 align-self-center">
                            <a href="#multi-item-example" role="button" data-bs-slide="next">
                                <i class="text-dark fas fa-chevron-right"></i>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                        <!--End Controls-->
                    </div>
                </div>
                <!-- col end -->
                <div class="col-lg-7 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="h2">${product.name}</h1>
                            <p class="h3 py-2">${product.pricevnd}</p>
                          
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6 style="color:red;">Khuyến mãi:</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong>${product.khuyenmai}</strong></p>
                                </li>
                            </ul>

                            <h6 style="color:red;">Mô tả:</h6>
                            <p>${product.mota}</p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Color :</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong>black</strong></p>
                                </li>
                            </ul>

                            <h6 style="color:red;">Thông số kỹ thuật:</h6>
                            <ul class="list-unstyled pb-3">
                                <li> <span style="font-weight: bold;
                                    color: black;">CPU:</span>${chitiet.cpu}</li>
                                <li> <span style="font-weight: bold;
                                    color: black;">GPU:</span> ${chitiet.gpu}</li>
                                <li> <span style="font-weight: bold;
                                    color: black;">SSD:</span>${chitiet.ssd}</li>
                                <li> <span style="font-weight: bold;
                                    color: black;">RAM:</span> ${chitiet.ram}</li>
                                <li> <span style="font-weight: bold;
                                    color: black;">DISPLAY:</span>${chitiet.display}</li>
                                <li> <span style="font-weight: bold;
                                    color: black;">WEIGHT:</span>${chitiet.weight}</li>
                                
                            </ul>

                            <form action="" method="GET">
                                <input type="hidden" name="product-title" value="Activewear">
                                <div class="row">
                                  
                                    <div class="col-auto">
                                        <ul class="list-inline pb-3">
                                           
                                            <li class="list-inline-item"><span class="btn btn-success" id="btn-minus">-</span></li>
                                            <li class="list-inline-item"><span class="badge bg-secondary" id="var-value">1</span></li>
                                            <li class="list-inline-item"><span class="btn btn-success" id="btn-plus">+</span></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="row pb-3">
                                    <div class="col d-grid">
                                        <button type="submit" class="btn btn-success btn-lg" name="submit" value="buy">Buy</button>
                                    </div>
                                    <div class="col d-grid">
                                        <button type="submit" class="btn btn-success btn-lg" name="submit" value="addtocard">Add To Cart</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Close Content -->
   
    <div class="container">
    <div class="be-comment-block">
        <h1 class="comments-title">Comments (3)</h1>
        <c:forEach items="${usercomment}" var="o">
            <div class="be-comment">
            <div class="be-img-comment">	
                <a href="blog-detail-2.html">
                    <img src="${o.idcomment}" alt="" class="be-ava-comment">
                </a>
            </div>
            <div class="be-comment-content">
                
                    <span class="be-comment-name">
                        <a href="blog-detail-2.html">${o.username}</a>
                        </span>
                    <span class="be-comment-time">
                        <i class="fa fa-clock-o"></i>
                        ${o.timeup}
                    </span>
    
                <p class="be-comment-text">
                  ${o.content}
                </p>
            </div>
        </div>
        </c:forEach>
    
  
       <hr>
       <c:if test="${sessionScope.acc!=null}">
         <form class="form-block" action="comment" method="get">
       </c:if>
       <c:if test="${sessionScope.acc!=null}">
            <div class="row">
                 <div class="be-comment">
            <div class="be-img-comment">	
                <a href="blog-detail-2.html">
                    <img src="${sessionScope.acc.image}" alt="" class="be-ava-comment">
                </a>
            </div>
            <div class="be-comment-content">
                <span class="be-comment-name">
                    <a href="blog-detail-2.html">${sessionScope.acc.userName}</a>
                </span>
              
            </div>
        </div>
        </c:if>
        <input name="username" value="${sessionScope.acc.userName}" type="text" hidden/>
         <input name="idpro" value="${product.id}" type="text" hidden/>
                <div class="col-xs-12">									
                    <div class="form-group">
                        <textarea name="content" class="form-input" required="" placeholder="Your text"></textarea>
                    </div>
                </div>
              <button class="btn btn-primary pull-right"  type="submit">submit</button>
                
            </div>
             <c:if test="${sessionScope.acc!=null}">
              </form>
             </c:if>
       
    </div>
    </div>
    <!-- Start Article -->
    <section class="py-5">
        <div class="container">
            <div class="row text-left p-2 pb-3">
                <h4>Related Products</h4>
            </div>

            <!--Start Carousel Wrapper-->
            <div id="carousel-related-product">

                

              

              <c:forEach items="${listproduct}" var="i">
                <div class="p-2 pb-3">
                    <div class="product-wap card rounded-0">
                        <div class="card rounded-0">
                            <img class="card-img rounded-0 img-fluid" src="${i.image}">
                            <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                <ul class="list-unstyled">
                                    <li><a class="btn btn-success text-white" href="singleproduct?idp=${i.id}&cateid=${i.cateid}"><i class="far fa-heart"></i></a></li>
                                    <li><a class="btn btn-success text-white mt-2" href="singleproduct?idp=${i.id}&cateid=${i.cateid}"><i class="far fa-eye"></i></a></li>
                                     <c:url value="add-to-cart?id=${i.id}" var="add"/>
                                        <li><a class="btn btn-success text-white mt-2" href="${add}"><i class="fas fa-cart-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="card-body">
                            <a href="singleproduct?idp=${i.id}&cateid=${i.cateid}" class="h3 text-decoration-none">${i.name}</a>
                            <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                <li>${i.mota}</li>
                                <li class="pt-2">
                                    <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                    <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                    <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                    <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                    <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                </li>
                            </ul>
                            <ul class="list-unstyled d-flex justify-content-center mb-1">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                            </ul>
                            <p class="text-center mb-0">${i.pricevnd}</p>
                        </div>
                    </div>
                </div>
              </c:forEach>

            </div>


        </div>
    </section>
    <!-- End Article -->


   <jsp:include page="footerweb.jsp"></jsp:include>

    <!-- Start Script -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
    <!-- End Script -->

    <!-- Start Slider Script -->
    <script src="assets/js/slick.min.js"></script>
    <script>
        $('#carousel-related-product').slick({
            infinite: true,
            arrows: false,
            slidesToShow: 4,
            slidesToScroll: 3,
            dots: true,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 480,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                }
            ]
        });
    </script>
    <!-- End Slider Script -->

</body>

</html>