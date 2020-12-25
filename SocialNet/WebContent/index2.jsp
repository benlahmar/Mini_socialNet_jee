<%@page import="com.model.Invitation"%>
<%@page import="com.dao.UserDao"%>
<%@page import="java.util.List"%>
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
background-color: gold;

border-style: groove;
float: left;
}
</style>
</head>
<body>
<%
UserDao dao=new UserDao();

User u=(User) session.getAttribute("user");
out.print("<h1> Bienvenu <font color='red'>"+ u.getLog()+"</font></h1>");
List<User> us = dao.allusers();
%>
<table  class="user">
<%
for (User user : us) {
	if(user.getId()!=u.getId()){
	%>
<tr>
<td><%=user.getLog() %></td>
<td><%=user.getRole() %> </td>
<td>
<%
if(dao.isinvited(u.getId(), user.getId(), false)==0)
{
%>
<a href='Inviter?idus=<%= u.getId()%>&idur=<%= user.getId() %>'>inviter</a> 
<%}
else
{
%>
<button> invitation en cours</button>
<%} %>
</td>
</tr>
<%
}}
%>
</table>

<div>
<table>
<%
List<Invitation> vs=dao.allinvitation(u.getId(), false);
for(Invitation v: vs)
	{
	int idd=v.getUs().getId();
	User uu=dao.finduser(idd);
%>
<tr>
<td><%= uu.getLog() %>  </td><td><%= v.getDate()%>  
</td><td><a href='Accepte?idus=<%= idd %>&idur=<%= v.getUr().getId() %>'>Accepter</a> </td>
</tr>
<%} %>
</table>
</div>
<hr/>
<div >
<table bgcolor='gold' border='1px'>
<thead>
<th>Amis</th>
</thead>
<%
List<Invitation> amis=dao.allinvitation(u.getId(), true);
for(Invitation v: amis)
	{
	int idd=v.getUs().getId();
	User uu=dao.finduser(idd);
%>
<tr>
<td><%= uu.getLog() %> </td>
</tr>

<%} %>
</table>
<hr/>

<form action="Addpost" >
<textarea rows="5" cols="15" name="contenu"></textarea>
<select name="visib">
<option>public</option>
<option>private</option>
<option>amis</option>
</select>
<input type="submit" value="poster"/>
</form>
</div>
</body>
</html>