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
					<h2>Liste des événements</h2>
					<br/>
					<br/>
				</div>
				<div class="row">
   					<s:form method="post" action="deconnexion">
						<s:url namespace="/" var="linkDeconnexion" action="deconnexion"></s:url>
						<a class="btn btn-alert btn-default" href="${linkDeconnexion}">Se déconnecter</a>
   					</s:form>
	    		</div>
<!-- 			</div> -->
				
				<div class="col-md-12">
					<label><u>Evénements :</u></label><br/><br/>
					A remplir...
					<c:forEach items="${listEvents}" var="event">
						<label>Game : ${event.game}</label><br/>
						<label>Date : ${event.date}</label><br/>
						<label>Number of players : ${event.nbPlayers}/${event.nbMaxPlayers}</label><br/>
						<label>Location : ${event.location}</label><br/>
					</c:forEach>
				</div>
				<br/><br/><br/>
			</div>
		</div>
	</div>
</body>
</html>