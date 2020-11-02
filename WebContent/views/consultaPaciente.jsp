<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAITH - Consulta Paciente</title>
<%@include file="../partial/estilos.txt"%>
</head>
<body>
	<%@include file="../partial/header.txt"%>
	<h2>Consulta</h2>
	
	<div class="alert alert-primary">
		<p>${erro}</p>
	</div>
	<div class="alert alert-primary">
		<p>${msg}</p>
	</div>
		<form action="PacienteConsultaController" method="get">
			<div class="row">
				<div class="form-group col-md-8">
					<label for="pesquisa">Pesquisa</label>
					<input type="text" class="form-control" name="pesquisa" id="pesquisa" placeholder="Pesquisa" />
				</div>
				<div class="form-group col-md-2">
					<label for="pesquisa">&nbsp;</label> 
					<input type="submit" id="pesquisa" class="btn btn-primary form-control" value="ok" />
				</div>
			</div>
		</form>

<div>
<table class="table">
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>Nascimento</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>CPF</th>
				<th>Responsável</th>
				<th>Telefone</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="paciente" items="${lst}">
				<tr>
					<td>${paciente.id}</td>
					<td>${paciente.nome}</td>
					<td><fmt:formatDate value="${paciente.dt}" type="both" pattern="dd/MM/yyyy"/>
					<td>${paciente.telefone}</td>
					<td>${paciente.email}</td>
					<td>${paciente.cpf}</td>
					<td>${paciente.responsavel}</td>
					<td>${paciente.telefone}</td>
					<td><a href="PacienteDetalhesController?acao=RandInternacao&id=${paciente.id}">Rand</a></td>
					<td><a href="PacienteDetalhesController?acao=Detalhes&id=${paciente.id}">Detalhes</a></td>
					
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(lst) > 0}">
   		A consulta retornou ${fn:length(lst)} Paciente(s)!
 		</c:if>


</div>






	<%@include file="../partial/footer.txt"%>
</body>
</html>