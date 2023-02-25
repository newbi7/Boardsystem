<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="member.vo.Member, board.vo.Board,commentboard.vo.commentBoard, java.util.List, java.util.*"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
  <title>Login Error</title>
</head>
<body>
  <div class="container mt-5">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <div class="card">
          <div class="card-header">
            <h2 class="text-center">로그인 에러</h2>
          </div>
          <div class="card-body">
            <p class="text-danger text-center">로그인에 실패하였습니다.</p>
            <div class="text-center">
              <a href="login.jsp" class="btn btn-primary">재시도하기</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
