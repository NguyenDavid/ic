<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<a href='<c:url value="/home"/>'><s:text name="left.home"></s:text></a><br/>
	<a href='<c:url value="/listGames"/>'><s:text name="left.listGames"></s:text></a><br/>
	<a href='<c:url value="/listEvents"/>'><s:text name="left.listEvents"></s:text></a><br/>
	<br/><br/>
	<div class="col-md-10">
		<hr>
		<label><u><s:text name="label.members"></s:text> :</u></label><br/>
		<c:forEach items="${listUsers}" var="user">
			<label>${user.login}</label><br/>
		</c:forEach>
	</div>
</body>
</html>