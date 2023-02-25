<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="member.vo.Member, board.vo.Board, commentboard.vo.commentBoard, java.util.List, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.2/css/bootstrap.min.css">
<!-- Add Bootstrap JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.2/js/bootstrap.min.js"></script>
<style>
body {
	max-width: 400px;
	max-height: 200px;
	margin: 0 auto;
	padding: 20px;
	font-family: Arial, sans-serif;
}

.card {
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	margin-top: 20px;
}

.card-header {
	max-height: 50px;
	border-radius: 10px 10px 0 0;
	background-color: #007bff;
	color: #fff;
	padding: 20px;
}

.form-label {
	font-weight: bold;
}

.btn-primary {
	background-color: #7FFFD4;
	border-color: #7FFFD4;
	margin-top: 20px;
}

.btn-primary:hover {
	background-color: #7FFFD4;
	border-color: #7FFFD4;
}

.input {
	border-width: 10px;
}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-8 col-lg-6">
				<div class="card bg-light">
					<div class="card-header bg-primary text-light">
						<h1 class="text-center mb-0">댓글 수정</h1>
					</div>
					<%
					commentBoard commentboard = (commentBoard) request.getAttribute("commenteditBoard");
					%>
					<div class="card-body">
						<form action="comnameupdateboard" method="GET">

							<div class="form-group">
								<label for="commentBoardAuthor" class="form-label text-primary">작성자
									: <%=commentboard.getCommentBoardAuthor()%></label>
							</div>
							
							<div class="form-group">
								<label for="commentBoardAuthor" class="form-label text-primary">
								</label><input type="hidden" class="form-control"
									name="commentBoardAuthor" id="commentBoardAuthor"
									value="<%=commentboard.getCommentBoardAuthor()%>" required>
							</div>
							
							<div class="form-group">
								<label for="boardNum" class="form-label text-primary">
								</label><input type="hidden" class="form-control"
									name="boardNum" id="boardNum"
									value="<%=commentboard.getBoardNum()%>" required>
							</div>

							<div class="form-group">
								<label for="commentBoardNumber" class="form-label text-primary">
								</label><input type="hidden" class="form-control"
									name="commentBoardNumber" id="commentBoardNumber"
									value="<%=commentboard.getCommentBoardNumber()%>" required>
							</div>

							<div class="form-group">
								<label for="commentBoardTitle" class="form-label text-primary">제목
									: </label> <input type="text" class="form-control"
									name="commentBoardTitle" id="commentBoardTitle"
									value="<%=commentboard.getCommentBoardTitle()%>" required>
							</div>

							<div class="form-group">
								<label for="commentBoardContent" class="form-label text-primary">내용
									: </label>
								<textarea class="form-control" name="commentBoardContent"
									id="commentBoardContent" rows="10" required><%=commentboard.getCommentBoardContent()%></textarea>
							</div>

							<button type="submit" class="btn btn-primary mt-3">댓글 등록</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
