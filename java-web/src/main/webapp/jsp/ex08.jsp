<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.Connection"%>

<%@ page import="java.sql.Statement"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex07</title>
</head>
<body>
<h1>지시문(directive element) - include</h1>
<%@ include file="./ex08_header.txt"%>
<p>테스트</p>
<%@ include file="./ex08_footer.txt"%>
</body>
</html>
<%--
include 지시문
1). file="JSP에 포함시킬 파일 경로"
   
--%>








