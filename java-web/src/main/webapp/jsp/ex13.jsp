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
<title>ex11</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean (계속)</h1>
<%-- 보관소에 저장된 객체 꺼내기 --%>
<%
ArrayList<String> names = new ArrayList<>();
names.add("홍길동");
names.add("임꺽정");
names.add("안중근");
names.add("윤봉길");

pageContext.setAttribute("list", names);
%>

<jsp:useBean id="list" type="java.util.ArrayList<String>" scope="page"/>
<%-- 자바코드로 표현해보면,
    java.util.ArrayList<String> list = 
      (java.util.ArrayList<String>) application.getAttribute("list");
 --%>

<%
for (String n : list) {
  out.println(n + "<br>");
}
%>

</body>
</html>


