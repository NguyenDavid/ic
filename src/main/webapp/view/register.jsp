<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<div class="col-md-6">
						<h1><s:text name="title.register"></s:text></h1>
					</div>
					<div class="col-md-4">
					</div>
					<div class="col-md-2">
						<a href="languageRegister.action?request_locale=en">
							<img src='<s:url value="/ressources/assets/en.gif"/>' alt="En"/> 
						</a> | 
						<a href="languageRegister.action?request_locale=fr">
							<img src='<s:url value="/ressources/assets/fr.gif"/>' alt="Fr"/> 
						</a>
					</div>
    			</div>
			
				<div class="panel panel-back noti-box">
					<s:form method="post" action="saveUser" acceptcharset="UTF-8" cssClass="well">
						<div class="form-group">
							<label for="adresse"><s:text name="label.mail"></s:text></label>
							<s:textfield type="email" cssClass="form-control"
								key="Email" name="user.email" />
						</div>
						<div class="form-group">
							<label for="description"><s:text name="label.login"></s:text></label>
							<s:textfield type="text" cssClass="form-control" key="Login"
								name="user.login" />
						</div>
						<div class="form-group">
							<label for="url"><s:text name="label.password"></s:text></label>
							<s:textfield type="password" cssClass="form-control" key="Mot de passe"
								name="user.password" />
						</div>
						<s:submit type="button" cssClass="btn btn-default btn-success" value="%{getText('button.register')}"></s:submit>
						<br/><br/>
						<a href='<s:url value="/login"/>'><s:text name="a.login"></s:text></a>
					</s:form>			
				</div>
			</div>
		</div>
	</div>
</body>
</html>