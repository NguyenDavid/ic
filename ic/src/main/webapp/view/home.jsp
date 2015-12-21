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
<script src='<s:url value="/ressources/js/turnUpDown.js"/>'></script>
<script src='<s:url value="/ressources/js/bootstrap-datepicker.js"/>'></script>
<script src='<s:url value="/ressources/js/bootstrap-datepicker.min.js"/>'></script>
<script src='<s:url value="/ressources/js/jquery-1.7.1.min.js"/>'></script>
<script src='<s:url value="/ressources/js/bootstrap.js"/>'></script>
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
					<h2><s:text name="title.home"></s:text></h2>
					<br/>
					<br/>
				</div>
				<div class="row">
   					<s:form method="post" action="deconnexion">
						<s:url namespace="/" var="linkDeconnexion" action="deconnexion"></s:url>
						<a class="btn btn-alert btn-default" href="${linkDeconnexion}"><s:text name="button.logout"></s:text></a>
   					</s:form>
   					<br/>
   					<a href="language.action?request_locale=en">En</a> |  
     				<a href="language.action?request_locale=fr">Fr</a>
	    		</div>
<!-- 			</div> -->
				<div id=createEvent>
					<a class="btn btn-alert btn-default" onclick="javascript:turnUpDown()"><s:text name="button.createEvent"></s:text></a><br/><br/>
					<div class="col-md-5">
						<label><u><s:text name="label.myEvents"></s:text> :</u></label><br/><br/>
						A remplir...
					</div>
				</div>
				<div id=newEvent style="DISPLAY:none">
					Insérer ici les champs du nouvel event	
					Créer la liste de Game, de Location, la date, le nombre de joueurs possibles et une description éventuelle
					<s:form method="post" action="saveEvent" acceptcharset="UTF-8">
						<br/>
						<div class="col-md-4">
						<label><u><s:text name="label.game"></s:text> :</u></label><br/>
						<select class="form-control">
						<c:forEach items="${listGames}" var="game">
<%-- 							<label><input type="radio" name="event.game"> ${game.name}</label> --%>
							<option value="event.game"> ${game.name}</option>
							<br/>
						</c:forEach>
						</select>
						</div>
						<br/><br/><br/>
						<hr>
						<div class="col-md-4">
						<label><u><s:text name="label.location"></s:text> :</u></label><br/>
						<select class="form-control">
						<c:forEach items="${listLocations}" var="location">
<%-- 							<label><input type="radio" name="event.location"> ${location.name} ${location.address}</label> --%>
							<option value="event.location"> ${location.name}</option>
							<label>${location.address}</label>
							<br/>
						</c:forEach>
						</select>
						</div>
						<br/><br/><br/>
						<hr>
						/////
						<label><u><s:text name="label.date"></s:text> :</u></label><br/>
						<div class="container">
						    <div class="row">
						        <div class='col-sm-6'>
						            <div class="form-group">
						                <div class='input-group date' id='datetimepicker2'>
						                    <input type='text' class="form-control"/>
						                    <span class="input-group-addon">
						                        <span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
						            </div>
						        </div>
						        <script type="text/javascript">
						            $(function () {
						                $('#datetimepicker2').datetimepicker({
						                    locale: 'ru',
						                    dateFormat: "yy-mm-dd"
						                });
						            });
 						        </script>
 						    </div>
 						</div>


						
						/////
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
						<hr>
						<label><u><s:text name="label.description"></s:text> (<s:text name="label.optional"></s:text>) :</u></label><br/>
						<textarea class="form-control" rows="5" name="event.description"></textarea>
						<hr>
 						<s:submit type="button" cssClass="btn btn-default btn-primary "
 							key="Créer l'événement" onclick="turnUpDown()"><s:text name="button.createEvent"></s:text></s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>