<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.growtech.trade.web.form.UserFrm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Supplier</title>
<link href="<%=request.getContextPath()%>/resources/style/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<!--header-----------------------------------!-->
<div id="header">
	<div class="header_content">
	<div class="header_bg_content">
		<div class="login_div">
        <div class="link_logout"><a href="<%=request.getContextPath()%>/signout?UserId=${LoggedInUser.userId}"">[Logout]</a></div>
        	<div class="link_nametop"><c:out value="${LoggedInUser.userId}"></c:out></div>
    </div>
	</div>
	 
    </div>
	
</div>
<div class="cl"></div>
<div class="nav_bar">
	<div class="trading">Trading Dashboard</div>
	
</div>
<div class="cl"></div>
<div class="midcontainer">
	<div class="matter_box">
              <div class="left_box">
                		<div class="select_text">Select a task you want to perform now</div>
                        <div class="icon_box1">
                    		<ul class="active">
                            	<li><a href=""><img src="<%=request.getContextPath()%>/resources/images/sales-contracts.png" /><br /><span>Sale Contracts</span></a></li>	
                                <li><a href=""><img src="<%=request.getContextPath()%>/resources/images/purchase-cont..png" /><br /><span>Purchase Contracts</span></a></li>	
                                <li><a href="supplier_index.html"><img src="<%=request.getContextPath()%>/resources/images/Payment-img.png" /><br /><span>Payment Contracts</span></a></li>						
                           	</ul>
                    	</div>
                        <div class="straight_line"></div>
                        <div class="icon_box1">
                    		<ul class="active">
                            	<li><a href=""><img src="<%=request.getContextPath()%>/resources/images/shipping-contracts.png" /><br /><span>Shiping Contracts</span></a></li>	
                                <li><a href="<%=request.getContextPath()%>/SupplierFrameContractList"><img src="<%=request.getContextPath()%>/resources/images/supplier-img.png" /><br /><span>Supplier Contracts</span></a></li>	
						
                           	</ul>
                </div>
                         <div class="straight_line"></div>
   	  </div>
                    
                <div class="right_box">
                	<div class="alarts_text">Alerts</div>
                    <p>You may have to look these on priority</p>
                    <p style="color:#E1803E">You may have to look these on priority</p>
                    <p>You may have to look these on priority</p>
                    <p class="red_par">You may have to look these on priority</p>
                    <p>You may have to look these on priority</p>
                    <p >You may have to look these on priority</p>
                </div>
  </div>
			<div class="cl"></div>
			<div class="graph_box">
            	<ul class="active2">
                	<li><a href=""><img src="<%=request.getContextPath()%>/resources/images/graph.bg.png"><br><div>Purchase Contract</div></a></li>
                    <li><a href=""><img src="<%=request.getContextPath()%>/resources/images/graph.bg.png"><br><div>Sale Contract</div></a></li>
                    <li><a href=""><img src="<%=request.getContextPath()%>/resources/images/graph.bg.png"><br><div>Shiping Contract</div></a></li>
                    <li><a href=""><img src="<%=request.getContextPath()%>/resources/images/graph.bg.png"><br><div>Suppliar Contract</div></a></li>
                </ul>
            </div>
</div>
<div class="cl"></div>
<div class="footer_login">
	<div class="footer_content_box">
		<div class="footer_content_txt">copyright © 2010 djie.com</div>
	</div>
</div>
</body>
</html>
