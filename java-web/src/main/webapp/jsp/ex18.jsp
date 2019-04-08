<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 
  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex18</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean (계속)</h1>

<%--  --%>
<jsp:useBean id="list" type="java.util.ArrayList<String>" scope="page"/>
<%-- 자바코드로 표현해보면,
    type 속성에 인터페이스를 지정해도 된다. 위 태그는 다음의 자바 코드와 같다.
    java.util.List<String> list = 
      (java.util.List<String>) application.getAttribute
  
 --%>

<%
// type 속성에서 제네릭으로 String을 지정했기 때문에 항목의 타입을 String으로 선언할 수 있다.
for (String n : list) {
  out.println(n + "<br>");
}
%>

</body>
</html>


