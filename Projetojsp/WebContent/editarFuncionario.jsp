<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIÇÃO DE FUNCIONARIOS</title>

</head>
<h1>EDIÇÃO DE FUNCIONARIOS</h1>
<body>
<form action="SvAtualizarFuncionario"method="get">
<label>nome:<input type=text name =nome  value=${funcionario.nome }> </label><br>
<label>cpf:<input type=text name=cpf value=${funcionario.cpf } > </label><br>
<label>tel:<input type="tel" name=tel value=${funcionario.tel }> </label><br>
<label>cel:<input type=text name=cel value=${funcionario.cel } > </label><br>
<label>idt:<input type=text name=idt value=${funcionario.idt } > </label> <br>
<label>email:<input type=text name=email  value=${funcionario.email }> <br></label>
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