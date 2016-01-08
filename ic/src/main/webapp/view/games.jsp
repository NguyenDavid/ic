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
<script src='<s:url value="/ressources/js/turnUpDown.js"/>'></script>
<title>E-sport</title>
</head>
<% int cpt=0; %>

<body>
	<div id="content-wrapper">
		<div id="content-left" class="hidden-xs">
			<div id="left-navigation">
				<jsp:include page="left_navigation.jsp"></jsp:include>
			</div>
		</div>
	
		<div id="content-ban">
	    	<img src='<s:url value="/ressources/assets/Banniere 3.jpg"/>' alt=""/>
	    </div>
	    <div id="content-title">
	    	<h1><s:text name="title.games"></s:text></h1>
	    </div>
	
		<div id="content-right">
			<div id="page-inner">
				<br/>
				<div id="content-logout">
	    			<s:form method="post" action="deconnexion">
   						<a href="languageGame.action?request_locale=en">
							<img src='<s:url value="/ressources/assets/en.gif"/>' alt="En"/> 
						</a> | 
						<a href="languageGame.action?request_locale=fr">
							<img src='<s:url value="/ressources/assets/fr.gif"/>' alt="Fr"/> 
						</a>
						<s:url namespace="/" var="linkDeconnexion" action="deconnexion"></s:url>
						<a class="btn btn-alert btn-default" href="${linkDeconnexion}">
							<span class="glyphicon glyphicon-log-out"></span>
							<s:text name="button.logout"></s:text>
						</a>
   					</s:form>
     				<br/>
	    		</div>
				
				<div class="col-md-12">
					<h4><label><u><s:text name="label.games"></s:text> :</u></label></h4><br/><br/>
					<c:forEach items="${listGames}" var="game">
						<% cpt = cpt + 1; %>
						<label>${game.name}</label><br/>
						<a onclick="javascript:turnUpDownInformations(<%=cpt%>)">
							<img src='<c:url value="/ressources/assets/Ban_${game.name}.jpg"/>' alt="" class="img-responsive"/>
						</a>
						<div class="informationsEvent" style="DISPLAY:none" id='<%=cpt%>'>
							<c:forEach items="${game.events}" var="event">
								<label><s:text name="label.description"></s:text> : ${event.description}</label><br/>
								<label><s:text name="label.date"></s:text> : ${event.date}</label><br/>
								<label><s:text name="label.players"></s:text> : ${event.nbPlayers}/${event.nbMaxPlayers}</label><br/>
								<br/>
							</c:forEach>
						</div>
						<br/><br/><br/>
					</c:forEach>
					
				</div>
				<br/><br/><br/>
			</div>
		</div>
	</div>
</body>
</html>