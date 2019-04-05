<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06</title>
</head>
<%!
// 다음과 같이 상속 받은 메서드를 오버라이딩 할 수 있다. 
public void jspInit() {
  System.out.println("ex06.jsp의 jspInit()");
}

public void jspDestroy() {
  System.out.println("ex06.jsp의 jspDestroy()");
}
%>
<body>
<h1>선언부</h1>

100,000,000 입금 = <%=calculate(100000000)%>

</body>

<%!
double interest = 0.025f;
private String calculate(long money) {
  return String.format("%.2f", money + (money * interest));
}
%>


</html>

<%--
용어 정리
1) 문장(statement)
	if () {...}
	else {...}
	for () {...}
	int a = 100;
	
2) 표현식(expression)
	- 값을 리턴하는 문장
	a * b     <-- 곱하기 결과 리턴
	(...)? a : b <-- 조건에 따라 a 또는 b 값 리턴
	plus(10, 20) <-- plus()의 실행 값 리턴
	
	out.println("okok") <-- 이 문장은 값을 리턴하지 않는다. 따라서 표현식이 아니다
	


표현식(expression element)
문법:
	<%= 표현식 %>
	자바 코드:
		out.print(표현식)
		또는
		out.write(표현식)
	

	
	--%>
	