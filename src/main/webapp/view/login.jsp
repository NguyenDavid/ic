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
						<h1><s:text name="title.login"></s:text></h1>
					</div>
					<div class="col-md-4">
					</div>
					<div class="col-md-2">
						<a href="languageLogin.action?request_locale=en">
							<img src='<s:url value="/ressources/assets/en.gif"/>' alt="En"/> 
						</a> | 
						<a href="languageLogin.action?request_locale=fr">
							<img src='<s:url value="/ressources/assets/fr.gif"/>' alt="Fr"/> 
						</a>
					</div>
    			</div>
			
				<div class="panel panel-back noti-box">
					<s:form method="post" action="connexion" acceptcharset="UTF-8" cssClass="well">
						<div class="form-group">
							<label for="login"><s:text name="label.login"></s:text></label>
							<s:textfield type="text" name="login"
								cssClass="form-control" />
						</div>
						<div class="form-group">
							<label for="url"><s:text name="label.password"></s:text></label>
							<s:textfield type="password" name="password"
								cssClass="form-control" />
						</div>
						<s:actionerror />
						<br/>
						<br/>
						<s:submit cssClass="btn btn-success" value="%{getText('button.login')}"></s:submit>
						<br/><br/>
						<a href='<s:url value="/register"/>'><s:text name="a.register"></s:text></a>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>