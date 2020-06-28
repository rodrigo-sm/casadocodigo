<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section style="margin:20px;">
		
		<h1><fmt:message key="pedidos.titulo"/></h1>
	
		<table>
			<tr>
				<th>ID</th>
				<th>Valor</th>
				<th>Data Pedido</th> 
				<th>Titulos</th>
			</tr>
			<c:forEach items="${pedidos}" var="pedido">
				<tr>
					<td>${pedido.id}</td>
					<td>${pedido.valor}</td>
					<td><fmt:formatDate value="${pedido.data}" pattern="dd/MM/yy"/></td>
					<td>${pedido.produtos.toString().replace("[", "").replace("]", "")}</td>
				</tr>
			</c:forEach>
		</table>
	
	</section>
		
</tags:pageTemplate>