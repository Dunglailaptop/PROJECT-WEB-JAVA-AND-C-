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
    
<link rel="stylesheet" href="styles/styles.css" />
    <title>Youtube UI Clone</title>
</head>
  <body>
    <!-- Header Starts -->
   <jsp:include page="header.jsp"></jsp:include>
    <!-- Header Ends -->

   

     <jsp:include page="category.jsp"></jsp:include>
      <!-- Sidebar Ends -->
              
         
                <ul class="category_list" style="
                margin-left: 20%;
    margin-top: 10px;
    padding: 12px;">
  <c:forEach items="${cate}" var="o">
                    <a class="category_link" href="showwithcategory?idcate=${o.cateid}">
                        <li class="category_items" >${o.cname}</li>
                    </a> 
                 </c:forEach> 
                </ul>
    
      
<div class="container">
        <div class="banner">
            
        </div>
          
        <div class="list-container">
        <!--  -->
        <c:forEach items="${list}" var="o">
        
                   <div class="video-list">
                <a href="showallvideo?idv=${o.id}&idcate=${o.cateid}"><img src="${o.image}" class="thumbnail" ></a>
                <div class="flex-div">
                    <img src="${o.imageacc}" alt="">
                    <div class="video-info">
                        <a href="showallvideo?idv=${o.id}&idcate=${o.cateid}">${o.title}</a>
                        <p>${o.nameacc}</p>
                        <p>5k views &bull; ${o.timeup}</p>
                    </div>
                </div>
            </div>
                  </c:forEach>

        </div>
    </div>
    <!----main end-->
  </body>

     <script src="js/script.js"></script>
</html>