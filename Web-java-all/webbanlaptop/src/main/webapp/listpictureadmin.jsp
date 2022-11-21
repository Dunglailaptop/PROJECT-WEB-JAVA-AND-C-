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
 <link href="assets1/css/listpic.css" rel="stylesheet">
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
                 
                    <div class="col-2-1">
                        <img src="${picture.image}" alt="alt"  id="ProductImg">
                        <div class="small-img-row">
                            <div class="small-img-col">
                                <img src="${picture.image}" width="100%" alt="alt" class="small-img">
                            </div>
                             <div class="small-img-col">
                                <img src="${picture.image1}" width="100%" alt="alt" class="small-img">
                             </div><!-- comment -->
                              <div class="small-img-col">
                                <img src="${picture.image2}" width="100%" alt="alt" class="small-img">
                              </div><!-- comment -->
                               <div class="small-img-col">
                                <img src="${picture.image3}" width="100%" alt="alt" class="small-img">
                            </div>
                            <div class="small-img-col">
                                <img src="${picture.image4}" width="100%" alt="alt" class="small-img">
                            </div>
                            <div class="small-img-col">
                                <img src="${picture.image5}" width="100%" alt="alt" class="small-img">
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
            <form action="addpicture" method="POST" enctype="multipart/form-data">
              <div class="col-sm-12 col-xl-6" style="padding-left:40px">
                <div class="bg-secondary rounded h-100 p-4">
                   
               
                       
                        <div class="mb-3">
                            <label for="formFileMultiple" class="form-label">ảnh phụ 1</label>
                            <input name="image1"   class="form-control bg-dark" type="file" id="formFileMultiple" >
                        </div>
                        <div class="mb-3">
                            <label for="formFileMultiple" class="form-label">ảnh phụ 2</label>
                            <input   name="image2"   class="form-control bg-dark" type="file" id="formFileMultiple" >
                        </div>
                        <div class="mb-3">
                            <label for="formFileMultiple" class="form-label">ảnh phụ 3</label>
                            <input  name="image3"   class="form-control bg-dark" type="file" id="formFileMultiple" >
                        </div>
                        <div class="mb-3">
                            <label for="formFileMultiple" class="form-label">ảnh phụ 4</label>
                            <input  name="image4"    class="form-control bg-dark" type="file" id="formFileMultiple" >
                        </div>
                        <div class="mb-3">
                            <label for="formFileMultiple" class="form-label">ảnh phụ 5</label>
                            <input  name="image5"    class="form-control bg-dark" type="file" id="formFileMultiple" >
                        </div>
                            <div class="mb-3">
                           
                            <input  name="idp" hidden   value="${picture.id}"  class="form-control bg-dark" type="text" >
                        </div>
                        <button type="submit" class="btn btn-primary" style="MARGIN-TOP: 15PX;WIDTH: 50%;">update picture</button>
                        <button type="reset" class="btn btn-primary" style="MARGIN-TOP: 15PX;WIDTH: 50%;">CLEAR</button>
                </div>
            </div>
            </form>
  
            </div>
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
              
var ProductImg=document.getElementById("ProductImg");
var Smallimg=document.getElementsByClassName("small-img");

Smallimg[0].onclick= function()
{
    ProductImg.src= Smallimg[0].src;
    
}
Smallimg[1].onclick= function()
{
    ProductImg.src= Smallimg[1].src;
    
}
Smallimg[2].onclick= function()
{
    ProductImg.src= Smallimg[2].src;
    
}
Smallimg[3].onclick= function()
{
    ProductImg.src= Smallimg[3].src;
    
}
Smallimg[4].onclick= function()
{
    ProductImg.src= Smallimg[4].src;
    
}
Smallimg[5].onclick= function()
{
    ProductImg.src= Smallimg[5].src;
    
}

          </script>
</html>