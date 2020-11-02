<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../partial/estilos.txt" %>
</head>
<body>
<%@include file="../partial/header.txt" %>
 <h2>${msg}</h2>
   
   <table class="table">
     <tr><td>Nome</td><td>${paciente.nome}</td></tr>
     <tr><td>CPF</td><td>${paciente.cpf}</td></tr>
     <tr><td>Email</td><td>${paciente.email}</td></tr>
     <tr><td>Responsavel</td><td>${paciente.responsavel}</td></tr>
     <tr><td>ID</td><td>${paciente.id}</td></tr>   
   </table>
   
   <%@include file="../partial/footer.txt" %>
</body>
</html>