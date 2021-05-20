<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>
</head>
<h1>CADASTRO DE CLIENTES</h1>
<body>
<form action= "SvClienteCadastrar"method="get">
<label>nome:<input type=text name="nome">  <br></label>
<label>cpf:<input type=text name="cpf" > <br></label>
<label> sexo: <input type=text name="sexo"  ><br></label>
 <label >idade:<input type=text name="idade"> <br></label>
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
