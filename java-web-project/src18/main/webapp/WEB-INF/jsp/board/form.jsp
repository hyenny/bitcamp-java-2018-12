<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>새 글</title>
<jsp:include page="../commonCss.jsp"/>
</head>
<body>

  <jsp:include page="../header.jsp" />

  <div class="container">
    <h1>새 글</h1>
    <form action='add' method='post'>
      <div class="form-group row">
        <label for="contents" class="col-sm-2 col-form-label">내용</label>
        <div class="col-sm-10">
          <textarea class="form-control" id="contents" name="contents"
            rows="3" cols="50">${board.contents}</textarea>
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
  <jsp:include page="../javascript.jsp" />
</body>
</html>
