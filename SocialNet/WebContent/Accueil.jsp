<%@page import="com.model.Invitation"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.user{
width: 200px;
height: 80px;
background-color: gold;
border: groove 1px;
margin: 5px;
padding: 5px;
float: left;
}

.vv{
width: 200px;
height: 80px;
background-color: green;
border: groove 1px;
margin: 5px;
padding: 5px;
float: left;
}
</style>
</head>
<body>

<%
UserDao dao=new UserDao();
User u=(User) session.getAttribute("user");
%>

<h1> Bienvenu <font color='red'>
<%= u.getLog()%> 

</font></h1>
<%
List<User> us=dao.allusers();
for(User ut : us)
{
%>
<div class="user">
<%= ut.getLog() %> <a href=''>Inviter</a>
</div>

<%} %>


<hr/>

<%
	List<Invitation>	vs=dao.allinvitation(u.getId(), false);
	
	for(Invitation v:vs)
	{
%>
<div class="vv"><%=v.getDate() %> - <%=v.getUs().getLog() %></div>
<%} %>
</body>
</html>