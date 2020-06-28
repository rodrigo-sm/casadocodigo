<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section style="margin:20px;">
	
		<c:if test="${usuarioCadastrado != ''}">
			<h1><fmt:message key="usuarios.cadastrado.sucesso"/></h1>
		</c:if>
	
		<h1><a href="${s:mvcUrl('UC#form').build()}"><fmt:message key="usuarios.novo"/></a></h1>
		
		<h1><fmt:message key="usuarios.titulo"/></h1>
	
		<table>
			<tr>
				<th><fmt:message key="padrao.nome"/></th>
				<th><fmt:message key="padrao.email"/></th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
				</tr>
			</c:forEach>
		</table>
	
	</section>
		
</tags:pageTemplate>