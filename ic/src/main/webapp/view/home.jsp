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

<script>
function turnUpDown(){
		if(document.getElementById('createEvent').style.display == 'none'){
    		document.getElementById('createEvent').style.display = 'block';
    		document.getElementById('newEvent').style.display = 'none';
  		}
  		else {
    		document.getElementById('createEvent').style.display = 'none';
    		document.getElementById('newEvent').style.display = 'block';
		}
}
</script>

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
				</div>
			</div>
		</div>
	</div>
</body>
</html>