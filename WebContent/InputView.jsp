<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="cyan">
	<h1 style="text-align: center">
		<font color="black"> BOOKSTORE </font>
	</h1>
	<form action="Controller" method="get">
		<div style="text-align: center">
			Filter by name: <select name="nameList">
				<option selected disabled>Choose here</option>
				<option value="Servlets">Servlets</option>
				<option value="JSP">JSP</option>
				<option value="MYSQL">MYSQL</option>
			</select>
		</div>
		<br>
		<div style="text-align: center">
			Filter by author: <select name="authorList">
				<option selected disabled>Choose here</option>
				<option value="Sudhanshu">Sudhanshu</option>
				<option value="Shankar">Shankar</option>
				<option value="Anna">Anna</option>
			</select>
		</div>
		<br>
		<div style="text-align: center">
			Filter by price: <select name="priceList">
				<option selected disabled>Choose here</option>
				<option value="47">47</option>
				<option value="52">52</option>
				<option value="60">60</option>
			</select>
		</div>
		<br>
		<div style="text-align: center">
			<input type="submit" />
		</div>
	</form>
</body>
</html>