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
<title>ex16</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean (계속)</h1>

<%-- type 속성 대신에 class 속성을 사용하면
     id로 지정한 객체를 찾지 못했을 때 해당 객체를 만들고,
      그 id로 보관소에 저장한다.
      단 class 속성에는 generic 문법을 사용할 수 없다. --%>
<jsp:useBean id="list" type="java.util.ArrayList<String>" scope="page"/>
<%-- 자바코드로 표현해보면,
    type 속성에 인터페이스를 지정해도 된다. 위 태그는 다음의 자바 코드와 같다.
    java.util.List<String> list = 
      (java.util.List<String>) application.getAttribute
  
 --%>

<%
for (String n : list) {
  out.println(n + "<br>");
}
%>

</body>
</html>


