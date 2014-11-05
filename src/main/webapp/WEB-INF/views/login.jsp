<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<jsp:include page="fragments/head.jsp" />
<title>Login</title>
</head>
<body>
	<div class="container container-login">
		<form class="form-signin" name='loginForm' action="<c:url value='/login' />" method='POST'>
			<input class="form-control" type='name' name='username' placeholder="Name" required autofocus>
			<input class="form-control" type='password'
				name='password' placeholder="Password" required />

			<c:if test="${not empty error}">
				<div class="alert alert-danger alert-dismissable">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					<s:message code="${error}" />
				</div>
			</c:if>
			<button class="btn btn-lg btn-primary btn-block btn-login" name="submit" type="submit" value="Login">
				Login
			</button>
		</form>
	</div>

</body>
</html>