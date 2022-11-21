<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

</head>
<body>
    <div class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="index.html" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>Dunglailaptop</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="${sessionScope.acc.image}" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">${sessionScope.acc.userName}</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="showuseradmin?email=${sessionScope.acc.email}&pass=${sessionScope.acc.password}" class="nav-item nav-link "><i class="fa fa-laptop me-2"></i>myprofile</a>
                      
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>managerproduct</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="addproductadmin.jsp" class="dropdown-item">add new</a>
                            <a href="showproductadmin" class="dropdown-item">list product</a>
                            
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>manageraccount</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="manageraccount.jsp" class="dropdown-item">list account</a>
                            <a href="accountlock.jsp" class="dropdown-item">account lock</a>
                            
                        </div>
                    </div>
                      <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>managerorder</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="managerbillcustomer.jsp" class="dropdown-item">order by customer</a>
                            <a href="historyorder.jsp" class="dropdown-item">history order</a>
                            
                        </div>
                    </div>
                    <a href="managercategoryadmin.jsp" class="nav-item nav-link"><i class="fa fa-laptop me-2"></i>managercategory</a>
                     <a style="display:flex; align-items:center;" href="managerproducer.jsp" class="nav-item nav-link"><i class="fa fa-laptop me-2"></i>managerproducer</a>
                    <a href="chart.html" class="nav-item nav-link"><i class="fa fa-laptop me-2"></i>backtoshop</a>
                   
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->


        <!-- Content Start -->
     

</body>

  
</html>