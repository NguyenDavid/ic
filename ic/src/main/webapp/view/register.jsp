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
			<br/><br/>
			<div class="col-md-4">
			</div>
			<div class="col-md-4 col-centered margin-top-xl">
				<div class="row">
					<h2>Register</h2>
<!--     				<div class="col-md-2 col-md-offset-5"> -->
<!--     					<button type = "button" class = "btn btn-default">mon bouton</button> -->
<!--     				</div> -->
    			</div>
			
				<div class="panel panel-back noti-box">
					<s:form method="post" action="saveUser" acceptcharset="UTF-8" cssClass="well">
						<div class="form-group">
							<label for="adresse">Adresse mail</label>
							<s:textfield type="email" cssClass="form-control"
								key="Email" name="user.email" />
						</div>
						<div class="form-group">
							<label for="description">Login</label>
							<s:textfield type="text" cssClass="form-control" key="Login"
								name="user.login" />
						</div>
						<div class="form-group">
							<label for="url">Mot de passe</label>
							<s:textfield type="password" cssClass="form-control" key="Mot de passe"
								name="user.password" />
						</div>
						<s:submit type="button" cssClass="btn btn-default btn-success "
							key="Ajouter l'utilisateur">Creer un compte</s:submit>
						<br/><br/>
						<a href='<c:url value="/login"/>'>Login</a>
					</s:form>			
				</div>
			</div>
		</div>
	</div>
</body>
</html>