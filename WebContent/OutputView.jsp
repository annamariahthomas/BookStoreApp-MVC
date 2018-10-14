<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="olive">
	<h1 style="text-align: center">BookStore</h1>
	<table border="1" align="center">
		<tr>
			<td>BOOK_ID</td>
			<td>BOOK_NAME</td>
			<td>BOOK_AUTHOR</td>
			<td>BOOK_PRICE</td>
		</tr>
		<tr>
			<td><%=request.getAttribute("id")%></td>
			<td><%=request.getAttribute("name")%></td>
			<td><%=request.getAttribute("author")%></td>
			<td><%=request.getAttribute("price")%></td>
		</tr>
	</table>
</body>
</html>