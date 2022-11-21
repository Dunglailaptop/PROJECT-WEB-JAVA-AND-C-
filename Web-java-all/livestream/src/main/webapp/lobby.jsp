<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    
    <title>Document</title>
  <link rel='stylesheet' type='text/css' media='screen' href='styles/main.css'>
    <link rel='stylesheet' type='text/css' media='screen' href='styles/lobby.css'>
     <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    
    
<link rel="stylesheet" href="styles/styles.css" />
</head>
<body>
   <jsp:include page="header.jsp"></jsp:include>
   <!-- <header id="nav">
        <div class="nav--list">
             <a href="lobby.jsp"/>
                 <h3 id="logo">
                     <img src="./image/logo.png" alt="Site Logo">
                     <span>Mumble</span>
                 </h3>
             </a>
        </div>
 
         <div id="nav__links">
             <a class="nav__link" id="create__room__btn" href="create.jsp">
                 Create Room
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="#ede0e0" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm6 13h-5v5h-2v-5h-5v-2h5v-5h2v5h5v2z"/></svg>
             </a>
         </div>
     </header> --> 
           <div class="mainBody2" style="height: calc(100vh - 70px);
    display: flex;">
           
                   <jsp:include page="category.jsp"></jsp:include>
       <!--      <section class="hero__section">
        <h2>Interactive Chat & Streaming</h2>
        <div class="hero__section__img">
            <img style="max-height: 550px;object-fit: contain;" src="image/preview.png">
        </div>
    </section>-->
   

    <main style="width:100%;     margin-left: 15%;" >
        <section id="room__list">
            <h3 id="room__listTitle">Live Now: <span id="rooms__count">0</span></h3>
            <div id="room__container">
             

            </div>
        </section>
     </main>
           
           </div>
       

       
    
    
</body>
<script type="text/javascript" src="js/agora-rtm-sdk-1.5.0.js"></script>
<script type="module" src='js/lobby.js'></script>
  <script src="js/index.js"></script>
</html>