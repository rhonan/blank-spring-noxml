<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Blank Spring NO XML Project</title>
<jsp:include page="fragments/head.jsp" />
</head>
<body>
	<s:message code="hello"/> ${time}
	<br>
	<a href="javascript:logout()" class="btn-logout">Logout</a>
	<div>
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm"></form>
		<script>
			function logout() {
                $.ajax({
                    type : "POST",
                    url : "./userLogout401",
                    statusCode : {
	                    401 : function() {
		                    location.href = '<c:url value="/login?logout"/>'
	                    }
                    }
                });
               }
		</script>
	</div>
</body>
</html>