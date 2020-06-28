<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<div class="container">
	
		<h1><fmt:message key="usuarios.cadastro.titulo"/></h1>
		
		<form:form action="${s:mvcUrl('UC#gravar').build() }" method="post" commandName="formUsuario">
		
			<div class="form-group">
				<label><fmt:message key="padrao.nome"/></label>
				<form:input path="usuario.nome" cssClass="form-control" />
				<form:errors path="usuario.nome" />
			</div>
			
			<div class="form-group">
				<label><fmt:message key="padrao.email"/></label>
				<form:input path="usuario.email" cssClass="form-control" />
				<form:errors path="usuario.email" />
			</div>
			
			<div class="form-group">
				<label><fmt:message key="padrao.senha"/></label>
				<form:password path="usuario.senha" cssClass="form-control" />
				<form:errors path="usuario.senha" />
			</div>
			
			<div class="form-group">
				<label><fmt:message key="padrao.senha.repetida"/></label>
				<form:password path="senhaRepetida" cssClass="form-control" />
				<form:errors path="senhaRepetida" />
			</div>
			
			<button type="submit" class="btn btn-primary"><fmt:message key="padrao.cadastrar"/></button>
			
		</form:form>
	</div>
		
</tags:pageTemplate>