<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>새 회원</title>
<jsp:include page="../commonCss.jsp"/>
</head>
<body>

  <jsp:include page="../header.jsp" />

  <div class="container">
    <h1>새 회원</h1>
    <form action='add' method='post' enctype='multipart/form-data'>
      <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">이름</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="name">
        </div>
      </div>
      <div class="form-group row">
        <label for="email" class="col-sm-2 col-form-label">이메일</label>
        <div class="col-sm-10">
          <input type="email" class="form-control"
            name="email">
        </div>
      </div>
      <div class="form-group row">
        <label for="password" class="col-sm-2 col-form-label">암호</label>
        <div class="col-sm-10">
          <input type="password" class="form-control"
            name="password">
        </div>
      </div>
      <div class="form-group row">
        <label for="photo" class="col-sm-2 col-form-label">사진</label>
        <div class="col-sm-10">
          <input type="file" class="form-control" name="photo">
        </div>
      </div>
      <div class="form-group row">
        <label for="tel" class="col-sm-2 col-form-label">전화</label>
        <div class="col-sm-10">
          <input type="tel" class="form-control" name="tel">
        </div>
      </div>

      <div class="form-group row">
        <div class="col-sm-10">
          <button type="submit" class="btn btn-primary">등록</button>
          <a class="btn btn-primary" href='.'>목록</a>
        </div>
      </div>
    </form>
  </div>
  <!-- container -->
  <jsp:include page="../javascript.jsp" />
</body>
</html>

