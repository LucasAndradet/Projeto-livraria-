<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIÇÃO DE CLIENTES</title>

</head>
<h1>EDIÇÃO DE CLIENTES</h1>
<body>
<form action="SvAtualizarFuncionario"method="get">
<label>nome:<input type=text name =nome  value=${cliente.nome }> </label><br>
<label>cpf:<input type=text name=cpf value=${cliente.cpf } > </label><br>
<label>sexo:<input type="tel" name=tel value=${cliente.sexo }> </label><br>
<label>idade:<input type=text name=cel value=${cliente.idt } > </label><br>

<input type="submit" name="salvar"value=salvar	>
<input type="reset"name = "redefinir" value= "limpar" >
</form>
<c:choose>
        <c:when test="${not empty alertMsg}">
            <p >${alertMsg}</p>
        </c:when>
    </c:choose>

</body>
</html>