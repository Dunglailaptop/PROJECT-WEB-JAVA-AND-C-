<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="Servlets.*"%>
<%@page import="object.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
	if (cart_list != null) {
		DBUtils db= new DBUtils();
	
			cartProduct = db.getCartProducts(cart_list);
	
		double total;
		
			total = db.getTotalCartPrice(cart_list);
		
		request.setAttribute("total", total);
		request.setAttribute("cart_list", cart_list);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 5 Checkout Form Example</title>
    <!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">


	<!-- Demo CSS (No need to include it into your project) -->
	<link rel="stylesheet" href="assets/css/demo1.css">
  
</head>
<body>
    <jsp:include page="headerweb.jsp"/>
  
 <main style=" margin-top: 100px;">

     <!-- DEMO HTML -->
     <div class="container">
  <div class="py-5 text-center">
    
    <h2>thanh toán</h2>
  
  </div>

  <div class="row">
    <div class="col-md-4 order-md-2 mb-4">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">giỏ hàng</span>
        <span class="badge badge-secondary badge-pill">${cart_list.size()}</span>
      </h4>
       <form action="bill" method="GET" class="needs-validation" novalidate>
      <ul class="list-group mb-3">
                  <%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
        <li class="list-group-item d-flex justify-content-between lh-condensed">
          <div>
          <input name="idp" hidden value="<%=c.getId()%>">
          <input name="quantity" hidden value="<%=c.getQuantity()%>">
          <input name="price" hidden value="<%= dcf.format(c.getPrice())%>">
          <input name="nameproduct" hidden value="<%=c.getName()%>">
          <img style="width:50px;" src="<%=c.getImage()%>">
            <h6 class="my-0"><%=c.getName()%></h6>
            <small class="text-muted">quantity:<%=c.getQuantity()%></small>
          </div>
          <span class="text-muted"><%= dcf.format(c.getPrice())%></span>
        </li>
                         <%
				}
					}%>
        <li class="list-group-item d-flex justify-content-between">
          <span>Total:</span>
          <strong>${(total>0)?dcf.format(total):0}</strong>
        </li>
      </ul>

     
    </div>
    <div class="col-md-8 order-md-1">
      <h4 class="mb-3">thông tin giao hàng</h4>
     
        <div class="row">
        
        
        </div>

        <div class="mb-3">
          <label for="username">họ và tên</label>
          <div class="input-group">
           
            <input name="name" type="text" class="form-control" id="username" placeholder="họ và tên người nhận" required>
            <div class="invalid-feedback" style="width: 100%;">
              Your username is required.
            </div>
          </div>
        </div>

        <div class="mb-3">
          <label for="email">Email <span class="text-muted">(Optional)</span></label>
          <input name="email" type="email" class="form-control" id="email" placeholder="email">
          <div class="invalid-feedback">
            Please enter a valid email address for shipping updates.
          </div>
        </div>
   <div class="mb-3">
          <label for="address">số điện thoại</label>
          <input name="sdt" type="text" class="form-control" id="address" placeholder="your phone " required>
          <div class="invalid-feedback">
            Please enter your phone
          </div>
        </div>
        <div class="mb-3">
          <label for="address">địa chỉ</label>
          <input name="address" type="text" class="form-control" id="address" placeholder="số nhà/số đường quận huyện " required>
          <div class="invalid-feedback">
            Please enter your shipping address.
          </div>
        </div>

        

        <div class="row">
          <div class="col-md-5 mb-3">
            <label for="country">đất nước</label>
            <select class="custom-select d-block w-100" id="country" required>
              <option value="">Choose...</option>
              <option>việt nam</option>
            </select>
            <div class="invalid-feedback">
              Please select a valid country.
            </div>
          </div>
          <div class="col-md-4 mb-3">
            <label for="state">quận</label>
            <select class="custom-select d-block w-100" id="state" required>
              <option value="">Choose...</option>
              <option></option>
            </select>
            <div class="invalid-feedback">
              Please provide a valid state.
            </div>
          </div>
         
        </div>
        <hr class="mb-4">
        

        <h4 class="mb-3">Payment</h4>

        <div class="d-block my-3">
         
        <div class="custom-control custom-radio">
            <input name="pay" id="credit" value="tructiep" type="radio" class="custom-control-input" checked required>
            <label class="custom-control-label" for="credit">thanh toán khi nhận hàng</label>
          </div>
        
        </div>
    
        
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
      </form>
    </div>
  </div>

 
</div>
     <!-- End Demo HTML -->
     
 </main>
 

    <jsp:include page="footerweb.jsp"/>
<!-- Bootstrap 5 JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
  </body>
</html>