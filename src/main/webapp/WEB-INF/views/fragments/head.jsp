<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/webjars/jquery/2.1.1/jquery.js" var="jQuery" />
<script src="${jQuery}"></script>
<spring:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js" var="bootstrapJs" />
<script src="${bootstrapJs}"></script>
<spring:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />