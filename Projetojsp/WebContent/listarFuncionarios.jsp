<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Livraria Online</h1>

	<c:choose>
		<c:when test="${not empty usuarioLogado}">
			<p>
				Bem-vindo, <b>${usuarioLogado.username }</b>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				Bem-vindo. Realize o Login - <a
					href="/Projetowebdinamico/formLogin.jsp">Login</a>
			</p>
		</c:otherwise>
	</c:choose>
	
	<h2>Lista de Funcionários</h2>	
	
	<p><a href="/Projetowebdinamico/cadastrarFuncionario.jsp">Novo Funcionário</a></p>
	
	<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Nome</th>
          <th>CPF</th>
          <th>Telefone</th>
          <th>Celular</th>
          <th>Identidade</th>
          <th>Email</th>
       </tr>
       <c:forEach items="${funcionarios}" var="listaFuncionarios" >
          <tr>
             <td>${listaFuncionarios.nome}</td>
             <td>${listaFuncionarios.cpf}</td>
             <td>${listaFuncionarios.tel}</td>
             <td>${listaFuncionarios.cel}</td>
             <td>${listaFuncionarios.idt}</td>
             <td>${listaFuncionarios.email}</td>
             <td>
                <a href="/Projetowebdinamico/editarFuncionario?cpf=${listaFuncionarios.cpf}">Editar</a>
             </td>
             <td>
                <a href="/Projetowebdinamico/deletarFuncionario?cpf=${listaFuncionarios.cpf}">Deletar</a>
             </td>
          </tr>
       </c:forEach>
    </table>
    
</body>
</html>