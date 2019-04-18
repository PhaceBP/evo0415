<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ordering</title>
</head>
<body>
	<div align="center">

		<c:if test="${not empty totalPrice}">
			<h1>Total price is : ${totalPrice.discountPrice}</h1>
			<h1>Total price in EUR is : ${totalPriceInEur}</h1>
			<h1>Discount type is: ${totalPrice.discountType.discountName}</h1>
		</c:if>
		<form:form action="order" method="post" commandName="orderForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center">
						<h2>Please purcahse products</h2>
					</td>
				</tr>
				<tr>
					<td>Number of cucumbers:</td>
					<td><form:input path="numOfCucumber" /></td>
				</tr>
				<tr>
					<td>Number of chestnuts:</td>
					<td><form:input path="numOfChestnut" /></td>
				</tr>
				<tr>
					<td>Number of salamis:</td>
					<td><form:input path="numOfSalami" /></td>
				</tr>
				<tr>
					<td>Number of ducks:</td>
					<td><form:input path="numOfTireDuck" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Order" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>