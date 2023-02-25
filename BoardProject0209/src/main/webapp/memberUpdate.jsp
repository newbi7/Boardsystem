<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
    import="member.vo.Member, board.vo.Board,commentboard.vo.commentBoard, java.util.List, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap stylesheet link -->
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
        crossorigin="anonymous">
    <title>회원정보수정</title>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header bg-primary text-light">
                        <h2 class="text-center">회원정보수정</h2>
                    </div>
                    <div class="card-body">
                        <form action="memberupdate" method="GET">
                            <div class="form-group">
                                <label for="userID">ID : </label>
                                <%=((Member) session.getAttribute("member")).getMemberId()%>
                            </div>
                            <div class="form-group">
                                <label for="userPW">Password</label>
                                <input type="password" class="form-control" id="userPW" name="userPW">
                            </div>
                             <div class="form-group">
                                <label for="userName">Name</label>
                                <input type="text" class="form-control" id="userName" name="userName">
                            </div>
                            <div class="text-right">
                                <button type="submit" class="btn btn-primary">회원정보수정</button>
                            </div>
                        </form>
                        <button class="btn btn-primary" onclick='location.href="contentshow"'>뒤로가기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap script links -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
        integrity="sha384-TX0G2QTwIIf7c8KZtwx0ogFK+YJwwHt7/fO75g/QKykX4Zh13s0s0GJivZOnxu/P"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
