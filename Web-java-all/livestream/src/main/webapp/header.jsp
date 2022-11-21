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
   <nav class="flex-div flex" >
        <div class="nav-left flex-div">
            <img src="img/menu.png" class="menu" alt="">
            <img src="img/logo.png" class="logo" alt="">
        </div>
        <div class="nav-middle flex-div">
        <form action="search" method="get">
         <div class="search flex-div">
                <input name="namesc" type="text" placeholder="Search" style="color: white;">
                <button type="submit" style="background-color:#1a1a1a;"><img src="img/search.png" alt=""></button>
            </div>
        </form>
           
            <img src="img/voice-search.png" class="mic" alt="">
        </div>
        <div class="nav-right flex-div">
        <a href="create.jsp"><img src="img/upload.png" alt=""></a>
         <c:if test="${sessionScope.acc !=null}">
            <a href="create.jsp" ><h2 style="border: 1px solid black;
    border-radius: 15px;
    background-color: rebeccapurple;
        margin-right: 12px;
    padding: 10px;">create room</h2></a>
    </c:if>
          <c:if test="${sessionScope.acc !=null}">
            <a href="showuser?email=${sessionScope.acc.email}&pass=${sessionScope.acc.password}"> <img src="${sessionScope.acc.image}" class="user" alt=""></a>
           </c:if>
        </div>
    </nav>
  </body>

    <script src="js/script.js"></script>
</html>