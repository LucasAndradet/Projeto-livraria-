<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar funcionario</title>

</head>
<h1>Buscar funcionario </h1>
<body>
<form action="SvBuscarFuncionario"method="get">
<label>cpf:<input type=text name ="cpf" > <br></label>

<input type="submit" name="buscar"value=buscar	>
<input type="reset"name = "redefinir" value= "limpar" >
</form>

<c:choose>
        <c:when test="${not empty alertMsg}">
            <p>${alertMsg}</p>
        </c:when>
    </c:choose>
    
</body>
</html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>