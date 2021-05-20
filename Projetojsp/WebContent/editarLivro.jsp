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
<form action="SvAtualizarLivro"method="get">
<label>nome:<input type=text name =nome  value=${livro.nome }> </label><br>
<label>autor:<input type=text name=cpf value=${livro.autor } > </label><br>
<label>editora:<input type="text" name=tel value=${livro.editora}> </label><br>
<label>Numero de paginas:<input type=text name=nrPaginas value=${livro.nrPaginas }  > </label><br>
<label>Preço:<input type=text name=preco value=${livro.preco} > </label> <br>
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