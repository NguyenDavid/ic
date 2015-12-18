<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='<s:url value="/ressources/css/bootstrap.min.css"/>'
	rel="stylesheet">
<link href='<s:url value="/ressources/css/background.css"/>'
	rel="stylesheet">
<title>E-sport</title>
</head>
<body>
	<div id="content-wrapper">
		<div id="content-left" class="hidden-xs">
			<ul id="left-navigation">
				<jsp:include page="left_navigation.jsp"></jsp:include>
			</ul>
		</div>
	
		<div id="content-right">
			<div id="page-inner">
<!-- 				<div class="col-md-4 col-centered margin-top-xl"> -->
				<div class="col-md-9"></div>
					<div class="row">
	    				<div class="col-md-2 col-md-offset-5">
	    					<s:form method="post" action="deconnexion">
								<s:url namespace="/" var="linkDeconnexion" action="deconnexion"></s:url>
								<a class="btn btn-alert btn-danger" href="${linkDeconnexion}"
								role="button">Se déconnecter</a>
	    					</s:form>
	    				</div>
	    			</div>
<!-- 				</div> -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>