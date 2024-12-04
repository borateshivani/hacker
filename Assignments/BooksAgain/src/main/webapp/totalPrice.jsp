<%@page import="com.demo.bean.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Total Price</title>
</head>
<body>

<h1>Marked Books</h1>
<table border="1px">
	<tr>
		<th>Id</th>
		<th>Book Name</th>
		<th>Author</th>
		<th>Price</th>
		<th>Category</th>
	</tr>
	<% List<Book> ans = (List<Book>) request.getSession().getAttribute("markedBook");
	
	for (Book b : ans) { %>
		<tr>
			<td><%= b.getId() %></td>
			<td><%= b.getName() %></td>
			<td><%= b.getAuthorName() %></td>
			<td><%= b.getPrice() %></td>
			<td><%= b.getCat() %></td>
		</tr>
	<% } %>

	</table>
	
<%
    int totalP = (Integer) request.getAttribute("total");
%>

<h2>Total Price : <%=totalP %></h2>

<a href="category.jsp">Back to Book List</a> <!-- Link back to previous page -->
	
</body>
</html>