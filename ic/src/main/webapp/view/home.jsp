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
<link href='<s:url value="/ressources/css/bootstrap.css"/>'
	rel="stylesheet">
<link href='<s:url value="/ressources/css/background.css"/>'
	rel="stylesheet">
<link href='<s:url value="/ressources/css/bootstrap-datepicker.min.css"/>'
	rel="stylesheet">
<link href='<s:url value="/ressources/css/jquery-ui.min.css"/>'
	rel="stylesheet">
	
<!-- datepicker, jquery a charger en premier avant le reste -->
<script type="text/javascript" src='<s:url value="/ressources/js/jquery-1.11.3.min.js"/>'></script>
<script type="text/javascript" src='<s:url value="/ressources/js/jquery-ui.min.js"/>'></script>
	
<script src='<s:url value="/ressources/js/turnUpDown.js"/>'></script>
<script src='<s:url value="/ressources/js/bootstrap-datepicker.js"/>'></script>
<script src='<s:url value="/ressources/js/bootstrap-datepicker.min.js"/>'></script>
<script src='<s:url value="/ressources/js/bootstrap.js"/>'></script>
<script src='<s:url value="/ressources/js/datepicker.js"/>'></script>

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
				<div class="col-md-9">
					<h1><s:text name="title.home"></s:text></h1>
					<br/>
					<br/>
				</div>
				<div class="row">
   					<s:form method="post" action="deconnexion">
   						<a href="languageHome.action?request_locale=en">
							<img src='<c:url value="/ressources/assets/en.gif"/>' alt="En"/> 
						</a> | 
						<a href="languageHome.action?request_locale=fr">
							<img src='<c:url value="/ressources/assets/fr.gif"/>' alt="Fr"/> 
						</a>
						<s:url namespace="/" var="linkDeconnexion" action="deconnexion"></s:url>
						<a class="btn btn-alert btn-default" href="${linkDeconnexion}">
							<span class="glyphicon glyphicon-log-out"></span>
							<s:text name="button.logout"></s:text>
						</a>
   					</s:form>
     				<br/>
	    		</div>
				<div id=createEvent>
					<a class="btn btn-alert btn-default" onclick="javascript:turnUpDown()"><s:text name="button.createEvent"></s:text></a><br/><br/>
					<div class="col-md-12">
						<h4><label><u><s:text name="label.myEvents"></s:text> :</u></label></h4><br/><br/>
						A remplir...
					</div>
				</div>
				<div id=newEvent style="DISPLAY:none">
					Insérer ici les champs du nouvel event	
					Créer la liste de Game, de Location, la date, le nombre de joueurs possibles et une description éventuelle
					<s:form method="post" action="saveEvent" acceptcharset="UTF-8">
						<br/>
						<label><u><s:text name="label.game"></s:text> :</u></label><br/>
						<select class="form-control">
						<c:forEach items="${listGames}" var="game">
<%-- 							<label><input type="radio" name="event.game"> ${game.name}</label> --%>
							<option value="event.game"> ${game.name}</option>
							<br/>
						</c:forEach>
						</select>
						<br/>
						<hr>
						
						<label><u><s:text name="label.location"></s:text> :</u></label><br/>
						<select class="form-control">
						<c:forEach items="${listLocations}" var="location">
<%-- 							<label><input type="radio" name="event.location"> ${location.name} ${location.address}</label> --%>
							<option value="event.location"> ${location.name}</option>
							<label>${location.address}</label>
							<br/>
						</c:forEach>
						</select>
						<br/>
						<hr>
						
						<label><u><s:text name="label.date"></s:text> :</u></label><br/>
						<input type="text" id="datepicker"/>
						<br/>
						<hr>
						
						<label><u><s:text name="label.nbMaxPlayers"></s:text> :</u></label><br/>
						
						<!-- game.nbPlayersPerMatch == 2 -->
						<label><input type="radio" name="event.nbPlayers"> 2</label><br/>
						<label><input type="radio" name="event.nbPlayers"> 4</label><br/>
						<label><input type="radio" name="event.nbPlayers"> 8</label><br/>
						<label><input type="radio" name="event.nbPlayers"> 16</label><br/>
						<label><input type="radio" name="event.nbPlayers"> 32</label><br/>
						<label><input type="radio" name="event.nbPlayers"> 64</label><br/>
						
						<!-- game.nbPlayersPerMatch == 6 -->
						<label><input type="radio" name="event.nbPlayers"> 6</label><br/>
						<label><input type="radio" name="event.nbPlayers"> 36</label><br/>
						
						<!-- game.nbPlayersPerMatch == 10 -->
						<label><input type="radio" name="event.nbPlayers"> 10</label><br/>
						<label><input type="radio" name="event.nbPlayers"> 100</label><br/>
						<br/>
						<hr>
						
						<label><u><s:text name="label.description"></s:text> (<s:text name="label.optional"></s:text>) :</u></label><br/>
						<textarea class="form-control" rows="5" name="event.description"></textarea>
						<br/>
						<hr>
						
 						<s:submit type="button" cssClass="btn btn-default btn-primary " onclick="turnUpDown()"><s:text name="button.createEvent"></s:text></s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>