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
<link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

<link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js">
<link rel="stylesheet" href="assets/css/cart2.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</head>
<body>
 <jsp:include page="headerweb.jsp"/>
	<div class="cart_section">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-10 offset-lg-1">
                    <div class="cart_container">
                        <div class="cart_title">Shopping Cart<small> (${cart_list.size()} item in your cart) </small></div>
                        <div class="cart_items">
                            <ul class="cart_list">
                            <%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
                                <li class="cart_item clearfix">
                                    <div class="cart_item_image"><img src="<%=c.getImage()%>" alt=""></div>
                                    <div class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
                                        <div class="cart_item_name cart_info_col">
                                            <div class="cart_item_title">Name</div>
                                            <div class="cart_item_text"><%=c.getName()%></div>
                                        </div>
                                        <div class="cart_item_color cart_info_col">
                                            <div class="cart_item_title">Color</div>
                                            <div class="cart_item_text"><span style="background-color:#999999;"></span>Silver</div>
                                        </div>
                                        <div class="cart_item_quantity cart_info_col">
                                            <div class="cart_item_title">Quantity</div>
                                            
                                            <div class="cart_item_text">
                                            <a class="btn bnt-sm btn-incre" style="background-color: blue;color: white;font-weight: bold;" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>">+</a>
                                            <input type="text" value="<%=c.getQuantity()%>">
                                            <a class="btn bnt-sm btn-incre" style="background-color: blue;color: white;font-weight: bold;" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>">-</a>
                                            </div>
                                            	
                                        </div>
                                        <div class="cart_item_price cart_info_col">
                                            <div class="cart_item_title">Price</div>
                                            <div class="cart_item_text"><%= dcf.format(c.getPrice())%></div>
                                        </div>
                                        <div class="cart_item_total cart_info_col">
                                            <div class="cart_item_title">delete</div>
                                            <div class="cart_item_text"><a href="remove-from-cart?id=<%=c.getId()%>">delete</a></div>
                                        </div>
                                    </div>
                                </li>
                                <%
				}
					}%>
                            </ul>
                        </div>
                        <div class="order_total">
                            <div class="order_total_content text-md-right">
                                <div class="order_total_title">Order Total:</div>
                                <div class="order_total_amount"> ${(total>0)?dcf.format(total):0}</div>
                            </div>
                        </div>
                        <div class="cart_buttons"> <button type="button" class="button cart_button_clear">Continue Shopping</button> <button type="button" class="button cart_button_checkout"><a href="chechout.jsp">Add to Cart</a></button> </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
      <jsp:include page="footerweb.jsp"/>
</body>
</html>