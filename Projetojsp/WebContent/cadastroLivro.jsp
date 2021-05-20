<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CADASTRO DE LIVROS</title>

</head>
<h1> CADASTRO DE LIVROS</h1>
<body>
<form action="SvLivroCadastrar"method="get">
<label>nome:<input type=text name ="nome" > <br></label>
<label>autor:<input type=text name="autor" > <br></label>
<label>editora:<input type=text name="editora" > <br></label>
<label>Numero de paginas:<input type=text name="nrPaginas"><br> </label> 
<label>Preço<input type=text name="preco" > <br></label>
<input type="submit" name="salvar"value=salvar	>
<input type="reset"name = "redefinir" value= "limpar" >
</form>

<c:choose>
        <c:when test="${not empty alertMsg}">
            <p>${alertMsg}</p>
        </c:when>
    </c:choose>
    
</body>
</html>