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
<% int cpt=0; %>

<body>
	<div id="content-wrapper">
		<div id="content-left" class="hidden-xs"><!-- id="content-left" -->
			<div id="left-navigation">
				<jsp:include page="left_navigation.jsp"></jsp:include>
			</div>
		</div>
		
		<div id="content-ban">
	    	<img src='<c:url value="/ressources/assets/Banniere 3.jpg"/>' alt=""/>
	    </div>
	    <div id="content-title">
	    	<h1><s:text name="title.home"></s:text></h1>
	    </div>
		
		<div id="content-right">
			<div id="page-inner">
	    		<br/>
	    		<div id="content-logout">
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
					<s:form method="post" action="saveEvent" acceptcharset="UTF-8">
						<br/>
						<label><u><s:text name="label.game"></s:text> :</u></label><br/>
						<select class="form-control" name="event.game" onchange="updateNbMaxPlayers(this.selectedIndex);updateLocation(this.selectedIndex)">
						<c:forEach items="${listGames}" var="game">
							<% cpt = cpt + 1; %>
<%-- 							<label><input type="radio" name="event.game"> ${game.name}</label> --%>
							<option id='<%=cpt%>' value="${game.name}"> ${game.name}</option>
							
							<br/>
						</c:forEach>
						</select>
						<hr>
						
						<label><u><s:text name="label.location"></s:text> :</u></label><br/>
<%-- 						<select class="form-control" name="location"> --%>
<%-- 						<c:forEach items="${listLocations}" var="location"> --%>
<%-- 							<option value="${location.name}"> ${location.name}</option> --%>
<%-- 							<label>${location.address}</label> --%>
<!-- 							<br/> -->
<%-- 						</c:forEach> --%>
<%-- 						</select> --%>

						<s:select list="listLocations" name="event.location" listKey="idLocation" listValue="name"/>
<%-- 							<option value="${location.name}"> ${location.name}</option> --%>
						<hr>
						
						<label><u><s:text name="label.date"></s:text> :</u></label><br/>
<!-- 						<input type="text" id="datepicker" name="event.date"/> -->
						<label><s:text name="label.year"></s:text> :</label>
						<input type="text" name="year"/><br/>
						<label><s:text name="label.month"></s:text> :</label>
						<input type="text" name="month"/><br/>
						<label><s:text name="label.day"></s:text> :</label>
						<input type="text" name="day"/><br/>
						<br/>
						<hr>
						
						<label><u><s:text name="label.nbMaxPlayers"></s:text> :</u></label><br/>
						
						<!-- game.nbPlayersPerMatch == 2 -->
						<div id='twoPlayers' style="DISPLAY:none">
							<label><input type="radio" name="event.nbMaxPlayers" value="2"> 2</label><br/>
							<label><input type="radio" name="event.nbMaxPlayers" value="4"> 4</label><br/>
							<label><input type="radio" name="event.nbMaxPlayers" value="8"> 8</label><br/>
							<label><input type="radio" name="event.nbMaxPlayers" value="16"> 16</label><br/>
							<label><input type="radio" name="event.nbMaxPlayers" value="32"> 32</label><br/>
							<label><input type="radio" name="event.nbMaxPlayers" value="64"> 64</label><br/>
						</div>
						
						<!-- game.nbPlayersPerMatch == 6 -->
						<div id='sixPlayers'>
							<label><input type="radio" name="event.nbMaxPlayers" value="6"> 6</label><br/>
							<label><input type="radio" name="event.nbMaxPlayers" value="36"> 36</label><br/>
						</div>
						
						<!-- game.nbPlayersPerMatch == 10 -->
						<div id='tenPlayers' style="DISPLAY:none">
							<label><input type="radio" name="event.nbMaxPlayers" value="10"> 10</label><br/>
							<label><input type="radio" name="event.nbMaxPlayers" value="100"> 100</label><br/>
						</div>
						<hr>
						
						<label><u><s:text name="label.description"></s:text> (<s:text name="label.optional"></s:text>) :</u></label><br/>
						<textarea class="form-control" rows="5" name="event.description"></textarea>
						<hr>
						
 						<s:submit type="button" cssClass="btn btn-default btn-primary " onclick="turnUpDown()"><s:text name="button.createEvent"></s:text></s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>