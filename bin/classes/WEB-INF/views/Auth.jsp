<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Anam Engineering :: EMS </title>
<link href="<%=request.getContextPath()%>/resources/style/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<!--header-----------------------------------!-->
<div id="header">
  <div class="header_content">
	<div class="header_bg_content">
		
	</div>
	  
    </div>
</div>
<div class="cl"></div>
<div class="nav_bar">
	<div class="trading">EMS Employee Login</div>
	<div class="image_div_index"></div>
</div>
<div class="cl"></div>
<div class="midcontainer">
	<form:form method="post" commandName="userFrm" action="EmployeeSignin" cssStyle="margin:5px; padding-top:15px;">
	<form:hidden path="action" />
	<div class="box_login">
		<div class="content_txt_login">
			<div class="h1_login">Sign in</div>
			<div class="h1_login"><form:errors path="*" cssStyle="color : red;"/></div>
			<div class="label_container">
				<div class="label_txt_login">Username</div>
				<div class="cl"></div>
				<form:input path="userId" cssClass="login_txt_box"/>
			</div>
			<div class="cl"></div>
			<div class="label_container">
				<div class="label_txt_login">Password</div>
				<div class="cl"></div>
				<form:password path="password" cssClass="login_txt_box"/>
			</div>
			<div class="cl"></div>
			<input type="submit" class="input_button_login" value="Login" />
			<input type="checkbox" class="check_box_login" />
			<div class="login_txt_rem">Remember me</div>
			<div class="cl"></div>
			<div class="link_login_txt"><a href="#">Forgot password?</a></div>
		</div>
	</div>
	</form:form>
</div>
<div class="cl"></div>


 <!-- JSP include tag for Footer -->
<jsp:include page="MainFooter.jsp" />
 
</body>
</html>
