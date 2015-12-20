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
<script src='<s:url value="/ressources/js/turnUpDown.js"/>'></script>
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
					<h2>Accueil</h2>
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
				<div id=createEvent>
					<a class="btn btn-alert btn-default" onclick="javascript:turnUpDown()">Créer un événement</a>
				</div>
				<div id=newEvent style="DISPLAY:none">
					Insérer ici les champs du nouvel event	
					Créer la liste de Game, de Location, la date et le nombre de joueurs possibles
					<s:form method="post" action="saveEvent" acceptcharset="UTF-8">
						<br/>
						<label><u>Jeu :</u></label>
						<br/>
						<c:forEach items="${listGames}" var="game">
							<label><input type="radio" name="optradio">${game.name}</label>
							<br/>
						</c:forEach>
						<hr>
						<label><u>Lieu :</u></label>
						<br/>
						<c:forEach items="${listLocations}" var="location">
							<label><input type="radio" name="optradio">${location.name} ${location.address}</label>
							<br/>
						</c:forEach>
						<br/>
						<hr>
						/////
						<div class="container">
						    <div class="row">
						        <div class='col-sm-6'>
						            <div class="form-group">
						                <div class='input-group date' id='datetimepicker2'>
						                    <input type='text' class="form-control" />
						                    <span class="input-group-addon">
						                        <span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
						            </div>
						        </div>
						        <script type="text/javascript">
						            $(function () {
						                $('#datetimepicker2').datetimepicker({
						                    locale: 'ru'
						                });
						            });
						        </script>
						    </div>
						</div>
						/////
						<hr>
 						<s:submit type="button" cssClass="btn btn-default btn-primary "
 							key="Créer l'événement">Créer un événement</s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>