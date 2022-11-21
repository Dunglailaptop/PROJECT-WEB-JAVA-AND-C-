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






List<category> cate=null;
		DBUtils db= new DBUtils();
		
		cate=db.getcategory();
	
		
	
		
		request.setAttribute("cate", cate);
	
	
		
	
		
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
   <jsp:include page="header.jsp"></jsp:include>
   
     <jsp:include page="category.jsp"></jsp:include>

     <div class="container play-contain" style="padding-left:20%;">
        <div class="row" style="flex-wrap: nowrap;">
            <div class="play-vid" >
             <form action="addnewvideo" method="POST"  enctype="multipart/form-data">
                <div class="col-sm-12 col-xl-6" style="width:500px;">
                    <h1>Edit</h1>
                    <div class="bg-secondary rounded h-100 p-4">
                       
                        <div class="mb-3">
                           
                            <label for="formFile" class="form-label">Image title</label>
                            <input name="image" class="form-control bg-dark" type="file">
                           
                        </div>
                        <div class="mb-3">
                           
                          <label for="formFile" class="form-label">VIDEO</label>
                          <input name="video" class="form-control bg-dark" type="file">
                      </div>
                      <div class="mb-3">
                       <label for="exampleInputEmail1" class="form-label">title</label>
                       <input name="title" type="text" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                       
                   </div>
                 
                <div class="mb-3">
                 <label hidden for="exampleInputEmail1" class="form-label">nameacc</label>
                 <input hidden name="nameacc" value="${sessionScope.acc.userName}" type="type" class="form-control" id="exampleInputEmail1"
                     aria-describedby="emailHelp">
                
             </div>
             <div class="form-floating mb-3">
              <select name="cateid" class="form-select" id="floatingSelect"
                  aria-label="Floating label select example">
                  <c:forEach items="${cate}" var="o">
                  <option value="${o.cateid}">${o.cname}</option>
                  </c:forEach>
                  
                 
              </select>
              <label for="floatingSelect">category</label>
          </div>
         
           <input hidden name="imageacc" value="${sessionScope.acc.image}" type="text">
             <input hidden name="idacc" type="text" value="${sessionScope.acc.iduser}"/>
             <button type="submit" class="btn btn-primary">add video</button>
           
                    </div>
                </div>
              </form>
            </div>
            <div class="right-sidebar" style="flex-basis:auto;">
                <h1>my list video</h1>
           <c:forEach items="${video}" var="o">
                <div class="side-list">
                    <a href="getvideoupdate?idv=${o.id}" class="small-size"><img src="${o.image}" class="thumbnail" alt=""></a>
                    <div class="video-info">
                        <a href="switch.html">${o.title}</a>
                        <p>${o.nameacc}</p>
                        <p>5k views &bull; ${o.timeup}</p>
                    </div>
                </div>
      </c:forEach>
          
            </div>
        </div>
    </div>
              
  
  </body>

     <script src="js/script.js"></script>
</html>