<%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 20.09.2023
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
  <f:parseDate value="20-10-2010" var="parsedEmpDate" pattern = "dd-MM-yyyy" />

  <div class="row">
    <c:forEach items="${users}" var="user">
      <div class="col-sm-3">
        <div class="card m-2">
          <img src="https://opengraph.githubassets.com/309c96372d37dc06480c8fcf83dd262d138e35098f825274a7990fe823e6dcd6/wxphp/wxphp/issues/76"
               class="card-img-top">
          <div class="card-body">
            <h5 class="card-title">${user}</h5>
            <p class="card-text">${parsedEmpDate}</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>
