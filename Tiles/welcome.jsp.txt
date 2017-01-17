<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<body>
	  
	Language : <a href="?language=en_US">English</a>|<a href="?language=zh_CN">Chinese</a>
	 
	<h3>
	welcome.springmvc : <spring:message code="welcome.springmvc" text="default text" />
	</h3>
	 
	<p> Current Locale : ${pageContext.response.locale}</p>
 
 </body>
</html>