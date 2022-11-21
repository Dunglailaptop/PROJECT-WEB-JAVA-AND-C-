<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    
    
<link rel="stylesheet" href="styles/style.css" />
    <title>Youtube UI Clone</title>
</head>
  <body>
  
       <div class="sidebar">
        <div class="shortcut">
            <a href="index.jsp"><img src="img/home.png" alt=""><p class="edit">Home</p></a>
              <a href="lobby.jsp"><img src="img/explore.png" alt=""><p class="edit">live now</p></a>
              <a href="signin.jsp"><img src="img/explore.png" alt=""><p class="edit">sign in</p></a>
            <c:if test="${sessionScope.acc !=null}">
          
            <a href="getvideoaccount?idacc=${sessionScope.acc.iduser}"><img src="img/subscriprion.png" alt=""><p class="edit">add video</p></a>
            
            <a href="showuser?email=${sessionScope.acc.email}&pass=${sessionScope.acc.password}"><img src="img/library.png" alt=""><p class="edit">myprofile</p></a>
          </c:if>
             <c:if test="${sessionScope.acc !=null}">
              <a href="logoutaccount"><img src="img/library.png" alt=""><p class="edit">log out</p></a>
             </c:if>
             <c:if test="${sessionScope.acc.idadmin==1}">
              <a href="mangeraccount.jsp"><img src="img/library.png" alt=""><p class="edit">manager account</p></a>
             </c:if>
               <c:if test="${sessionScope.acc.idadmin==1}">
              <a href="categoryadmin.jsp"><img src="img/library.png" alt=""><p class="edit">manager category</p></a>
             </c:if>
            
        </div>
      
    </div>
     
  </body>

     <script src="js/script.js"></script>
</html>