<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${list}" var="item">
  {
    "no":${b.no}, 
    "title":"${b.title}", 
    "writer":"${b.writer}", 
    "viewCount":${b.viewCount},
    "createdDate":${createdDate}
  },
</c:forEach>