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
<title>E-sport</title>
</head>
<body>
	<div id="content-wrapper">
		<div id="page-inner">
			<div class="col-md-4 col-centered margin-top-xl">
				<div class="row">
    				<div class="col-md-2 col-md-offset-5">
<!--     					<button type = "button" class = "btn btn-default">mon bouton</button> -->
    				</div>
    			</div>
			
				<div class="panel panel-back noti-box">
					<s:form cssClass="navbar-form navbar-right" action="login">
						<div class="form-group">
							<s:textfield type="text" name="login" placeholder="Login"
								cssClass="form-control" />
						</div>
						<div class="form-group">
							<s:textfield type="password" name="password"
								placeholder="Mot de passe" cssClass="form-control" />
						</div>
						<s:actionerror />
						<br/>
						<s:submit cssClass="btn btn-success" value="S'authentifier"></s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>