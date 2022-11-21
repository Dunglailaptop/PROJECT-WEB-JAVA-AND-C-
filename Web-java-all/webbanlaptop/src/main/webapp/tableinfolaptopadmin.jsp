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
              <div class="col-sm-12 col-xl-6" style="    margin: 40px;">
              <form action="updatechitietproduct" method="get">
                <div class="bg-secondary rounded h-100 p-4">
                   
              
                            
                            <input hidden name="idp" value="${chitiet.idproduct}" type="text" class="form-control" >
                       
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">CPU</label>
                            <input name="CPU" value="${chitiet.cpu}" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">GPU</label>
                            <input name="GPU" value="${chitiet.gpu}" type="text" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">DISPLAY</label>
                            <input name="DISPLAY" value="${chitiet.display}" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">RAM</label>
                            <input name="RAM" value="${chitiet.ram}" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">SSD</label>
                            <input name="SSD" value="${chitiet.ssd}" type="text" class="form-control" >
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">WEIGHT</label>
                            <input name="WEIGHT" value="${chitiet.weight}" type="text" class="form-control" >
                        </div>
                        <div class="form-floating" style="PADDING-BOTTOM: 10PX;">
                            <input name="mota" value="${chitiet.mota}" class="form-control" placeholder="Leave a comment here"
                                id="floatingTextarea" style="height: 150px;">
                            <label for="floatingTextarea">MÔ TẢ THÊM</label>
                        </div>
                        <div class="form-floating">
                            <input name="khuyenmai" value="${chitiet.khuyenmai}" class="form-control" placeholder="Leave a comment here"
                                id="floatingTextarea" style="height: 150px;">
                            <label for="floatingTextarea">KHUYẾN MẠI VÀ QUÀ TẶNG</label>
                        </div>
                        
                        <button type="submit" class="btn btn-primary" style="MARGIN-TOP: 15PX;WIDTH: 50%;">update information</button>
                       
                </div>
                </form>
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