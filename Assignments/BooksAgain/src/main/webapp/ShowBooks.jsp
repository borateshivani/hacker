<%@page import="com.demo.bean.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>
	<form action="Total" method="post"> <!-- Wrap table in a form -->
	<table border="1px">
	<tr>
		<th>Id</th>
		<th>Book Name</th>
		<th>Author</th>
		<th>Price</th>
		<th>Category</th>
	</tr>
	<% List<Book> ans = (List<Book>) request.getAttribute("Books");
	
	for (Book b : ans) { %>
		<tr>
			<td><%= b.getId() %></td>
			<td><%= b.getName() %></td>
			<td><%= b.getAuthorName() %></td>
			<td><%= b.getPrice() %></td>
			<td><%= b.getCat() %></td>
			<td>
				<label for="<%= b.getId()%>">Select</label>
				<input id="<%= b.getId()%>" type="checkbox" name="btns" value="<%= b.getId() %>">
			</td>
		</tr>
	<% } %>

	</table>
    <button type="submit">Get total</button> 
    </form> <!-- Ensure form is closed here -->
    <a href="logout.html">Logout</a>
</body>
</html>