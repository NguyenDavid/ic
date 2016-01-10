<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<a class="left_navigation" href='<s:url value="/home"/>'><s:text name="left.home"></s:text></a><br/>
	<a class="left_navigation" href='<s:url value="/listGames"/>'><s:text name="left.listGames"></s:text></a><br/>
	<a class="left_navigation" href='<s:url value="/listEvents"/>'><s:text name="left.listEvents"></s:text></a><br/>
	<br/><br/>
	<div class="col-md-12">
		<hr>
		<font color="white">
		<label><u><s:text name="label.members"></s:text> :</u></label><br/>
		<%-- <c:forEach items="${listUsers}" var="user">
			<label class="left_label">${user.login}</label><br/>
		</c:forEach> --%>
		
		<s:iterator value="listUsers">
			<label class="left_label"><s:property value="login"/></label><br/>
		</s:iterator>
		</font>
	</div>
</body>
</html>