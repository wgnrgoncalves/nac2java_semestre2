<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAITH - Detalhes</title>
<%@include file="../partial/estilos.txt"%>
</head>
<body>
	<%@include file="../partial/header.txt"%>
	<h2>Detalhes do Paciente</h2>
<table class="table">
			<tr>
				<th>#</th>
				<th>Nome</th>
 				<th>DtEntrada</th>
 				<th>DtSaida</th>
 				<th>Leito</th>
 				<th>Motivo</th>
 			</tr>
			<c:forEach var="internacao" items="${lst}">
				<tr>
					<td>${internacao.id}</td>
 					<td>${internacao.paciente.nome}</td>
 					<td><fmt:formatDate value="${internacao.dte}" type="both" pattern="dd/MM/yyyy HH:mm:ss"/>
 					<td><fmt:formatDate value="${internacao.dts}" type="both" pattern="dd/MM/yyyy  HH:mm:ss"/>
 					<td>${internacao.leito.numero}</td>
 					<td>${internacao.motivo}</td>
					</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(lst) > 0}">
   		${fn:length(lst)} Registro(s)!
 		</c:if>
	<%@include file="../partial/footer.txt"%>
</body>
</html>