<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='<s:url value="/ressources/css/bootstrap.css"/>'
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
<!-- 			<div class="col-md-4 col-centered margin-top-xl"> -->
				<div class="col-md-9">
					<h2><s:text name="title.events"></s:text></h2>
					<br/>
					<br/>
				</div>
				<div class="row">
   					<s:form method="post" action="deconnexion">
						<s:url namespace="/" var="linkDeconnexion" action="deconnexion"></s:url>
						<a class="btn btn-alert btn-default" href="${linkDeconnexion}">
							<span class="glyphicon glyphicon-log-out"></span>
							<s:text name="button.logout"></s:text>
						</a>
   					</s:form>
   					<br/>
   					<a href="languageEvent.action?request_locale=en">En</a> |  
     				<a href="languageEvent.action?request_locale=fr">Fr</a>
	    		</div>
<!-- 			</div> -->
				
				<div class="col-md-12">
					<label><u><s:text name="label.events"></s:text> :</u></label><br/><br/>
					A remplir...
					<c:forEach items="${listEvents}" var="event">
						<label><s:text name="label.game"></s:text> : ${event.game}</label><br/>
						<label><s:text name="label.date"></s:text> : ${event.date}</label><br/>
						<label><s:text name="label.nbPlayers"></s:text> : ${event.nbPlayers}/${event.nbMaxPlayers}</label><br/>
						<label><s:text name="label.location"></s:text> : ${event.location}</label><br/>
					</c:forEach>
				</div>
				<br/><br/><br/>
			</div>
		</div>
	</div>
</body>
</html>