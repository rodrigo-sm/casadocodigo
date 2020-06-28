<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<div class="container">
	
		<h1><s:message code="usuarios.alterar.titulo" arguments="${usuario.nome}" /></h1>
		
		<form:form action="${s:mvcUrl('UC#atualizar').build() }" method="post" commandName="usuario">
		
			<input type="hidden" value="${usuario.email }" name="email" >
		
			Permissões: <form:checkboxes items="${roles}" itemLabel="nome" itemValue="nome" path="roles"/>
			
			<button type="submit" class="btn btn-primary">Atualizar</button>
			
		</form:form>
	</div>
		
</tags:pageTemplate>