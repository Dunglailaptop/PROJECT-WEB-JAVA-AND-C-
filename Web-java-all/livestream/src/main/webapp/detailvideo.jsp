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






	
		
	
		
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link rel="stylesheet" href="styles/cate.css" />
    
<link rel="stylesheet" href="styles/style.css" />
    <title>Youtube UI Clone</title>
</head>
  <body>
    <!---navigation start-->
   <jsp:include page="header.jsp"></jsp:include>
    <!--navigation end-->
    <!--video start-->
    <div class="container play-contain">
        <div class="row">
            <div class="play-vid">
                <video controls autoplay>
                    <source src="${list.video}" type="video/mp4"> 
                </video>
                <div class="tags">
                    <a href="">#web-programming</a>
                    <a href="">#web-designing</a>
                    <a href="">#web-development</a>
                </div>
                <h3>${list.title}</h3>
                <div class="play-info">
                    <p>5k views &bull; 1 days ago</p>
                    <div>
                        <a href=""><img src="img/like.png" alt="">2k</a>
                        <a href=""><img src="img/dislike.png" alt="">159</a>
                        <a href=""><img src="img/share.png" alt="">Share</a>
                        <a href=""><img src="img/save.png" alt="">Save</a>
                    </div>
                </div>
                <hr>
                <div class="owner">
                    <img src="${list.imageacc}" alt="">
                    <div>
                        <p>${list.nameacc}</p>
                        <span>1.2M Subscribers</span>
                    </div>
                    <button type="button">Subscribe</button>
                </div>
                <div class="description">
                    <p>A Complete Solution For Business</p>
                    <p>Subscribe To Our Channel For Free Projects</p>
                    <hr>
                    <h4>18 Comments</h4>
                    <div class="add-comment">
                    <form action="comment" method="get">
                     <input hidden name="idvideo" value="${list.id}" type="text" placeholder="Write Comments">
                     <input hidden name="nameacc" value="${list.nameacc}" type="text" placeholder="Write Comments">
                     <input hidden name="image" value="${list.imageacc}" type="text" placeholder="Write Comments">
                      <img src="img/1.png" alt="">
                        <input name="content" type="text" placeholder="Write Comments">
                       
                        <button type="submit">send</button>
                    </form>
                      
                    </div>
                      <c:forEach items="${listcc}" var="o">
                    <div class="prev-comnet">
                        <img src="${o.image}" alt="">
                        <div>
                            <h3>${o.username} <span> ${o.timeup}</span></h3>
                            <p>${o.content}</p>
                            <div class="action">
                                <img src="img/like.png" alt="">
                                <span>1522</span>
                                <img src="img/dislike.png" alt="">
                                <span>52</span>
                                <span>Reply</span>
                                <a href="">All Replies</a>
                            </div>
                        </div>
                    </div>
          </c:forEach>
                </div>
            </div>
            <div class="right-sidebar">
                <c:forEach items="${listc}" var="o">
                <div class="side-list">
                    <a href="showallvideo?idv=${o.id}&idcate=${o.cateid}" class="small-size"><img src="${o.image}" class="thumbnail" alt=""></a>
                    <div class="video-info">
                        <a href="showallvideo?idv=${o.id}&idcate=${o.cateid}">${o.title}</a>
                        <p>${o.nameacc}</p>
                        <p>5k views &bull; ${o.timeup}</p>
                    </div>
                </div>
                  </c:forEach>
    
            </div>
        </div>
    </div>
    <!--video end-->
  </body>

     <script src="js/script.js"></script>
</html>