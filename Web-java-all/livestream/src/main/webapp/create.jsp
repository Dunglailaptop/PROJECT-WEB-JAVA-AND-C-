<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    
    <title>Document</title>
   <link rel="stylesheet" type="text/css" media="screen" href="styles/main.css">
    <link rel="stylesheet" type="text/css" media="screen" href="styles/join.css">
</head>
<body>
   <jsp:include page="header.jsp"></jsp:include>
<!--   <header id="nav">
        <div class="nav--list">
            <button id="members__button">
               <svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M24 18v1h-24v-1h24zm0-6v1h-24v-1h24zm0-6v1h-24v-1h24z" fill="#ede0e0"><path d="M24 19h-24v-1h24v1zm0-6h-24v-1h24v1zm0-6h-24v-1h24v1z"/></svg>
            </button>
            <a href="lobby.jsp"/>
                <h3 id="logo">
                    <img src="./image/logo.png" alt="Site Logo">
                    <span>Mumble</span>
                </h3>
            </a>
       </div>

        <div id="nav__links">
            <button id="chat__button"><svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" fill="#ede0e0" clip-rule="evenodd"><path d="M24 20h-3v4l-5.333-4h-7.667v-4h2v2h6.333l2.667 2v-2h3v-8.001h-2v-2h4v12.001zm-15.667-6l-5.333 4v-4h-3v-14.001l18 .001v14h-9.667zm-6.333-2h3v2l2.667-2h8.333v-10l-14-.001v10.001z"/></svg></button>
            <!-- <a class="nav__link" href="/">
                Lobby
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="#ede0e0" viewBox="0 0 24 24"><path d="M20 7.093v-5.093h-3v2.093l3 3zm4 5.907l-12-12-12 12h3v10h7v-5h4v5h7v-10h3zm-5 8h-3v-5h-8v5h-3v-10.26l7-6.912 7 6.99v10.182z"/></svg>
            </a> 
            <a class="nav__link" id="create__room__btn" href="create.jsp">
                Create Room
               <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="#ede0e0" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm6 13h-5v5h-2v-5h-5v-2h5v-5h2v5h5v2z"/></svg>
            </a>
        </div>
    </header> -->
   
    <main id="room__lobby__container" style="background-color: #262625;">
       <div id="form__container" style="background-color: #262625;">
           <div id="form__container__header" style="">
              <p>join room</p>
           </div>
           <form id="lobby__form" style="background-color: #262625;">
               <div class="form__field__wrapper" style="background-color: #262625;">
                    <label style="background-color: #262625;">Your name</label>
                    <input type="text" name="name" value="${sessionScope.acc.userName}" required placeholder="Enter you name..."/>
               </div>
               <div class="form__field__wrapper" style="background-color: #262625;">
                <label style="background-color: #262625;">room name</label>
                <input type="text" name="room" required placeholder="Enter you name..."/>
           </div>
           <div class="form__field__wrapper" style="background-color: #262625;">
            <label style="background-color: #262625;">select Avatar</label>
            <div id="avatar_selection" style="background-color: #262625;">
                <img class="avatar__option" src="image/1.png"/>
                <img class="avatar__option" src="image/2.PNG"/>
                <img class="avatar__option" src="image/3.PNG"/>
                <img class="avatar__option" src="image/4.PNG"/>
                <img class="avatar__option" src="${sessionScope.acc.image}"/>
            </div>
       </div>
           <div class="form__field__wrapper">
           <!-- <input type="submit" value="Join"/> -->
           <button type="submit">Go to Room 
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M13.025 1l-2.847 2.828 6.176 6.176h-16.354v3.992h16.354l-6.176 6.176 2.847 2.828 10.975-11z"/></svg>
       </button>
            </div>
           </form>
       </div>
    </main>
</body>
<script src="js/agora-rtm-sdk-1.5.0.js"></script>
<!-- <script type="module" src="js/test.js"></script> -->
<script type="module" src="js/create.js"></script>
</html>