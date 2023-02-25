<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="member.vo.Member, board.vo.Board, commentboard.vo.commentBoard, java.util.List, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<title>글 내용</title>

<style>
table {
	width: 80%; /* Reduced width */
	border-collapse: collapse;
}

th, td {
	border: 1px solid #dddddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #dddddd;
}

h2 {
	color: black;
	text-align: left;
}

h3 {
	color: black;
	text-align: left;
}

button {
	background-color: lightblue;
	color: white;
	padding: 8px 15px;
	border-radius: 5px;
	border: none;
	cursor: pointer;
}
/* Reduced font size */
td, th, button {
	font-size: 12px;
}
</style>
</head>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('.delete-button').click(function() {
					var commentNumber = $(this).data('board-num');

					$.ajax({
						url : 'commentdeleteBoard',
						type : 'GET',
						data : {
							commentNumber : commentNumber
						},
						success : function(result) {
							location.reload();
							console.log("ㅇㅇ");
						},
						error : function(xhr, status, error) {
							alert("업데이트가 안 되었습니다. " + error + commentNumber);
						}
					});

				});

				$('.commentadd-button').click(
						function(e) {
							e.preventDefault();
							var form = $(this).closest('.commentregistboard');
							var boardNum = form.find('input[name="boardNum"]')
									.val();
							var commentBoardAuthor = form.find(
									'input[name="commentBoardAuthor"]').val();
							var commentBoardTitle = form.find(
									'input[name="commentBoardTitle"]').val();
							var commentBoardContent = form.find(
									'textarea[name="commentBoardContent"]')
									.val();

							$.ajax({
								url : 'commentadd',
								type : 'POST',
								data : {
									boardNum : boardNum,
									commentBoardAuthor : commentBoardAuthor,
									commentBoardTitle : commentBoardTitle,
									commentBoardContent : commentBoardContent
								},

								success : function(result) {
									location.reload();
									console.log("Success");
								},

								error : function(xhr, status, error) {
									alert("등록이 안 되었습니다. " + error + boardNum
											+ commentBoardAuthor
											+ commentBoardTitle
											+ commentBoardContent);
								}
							});
						});
			});
</script>


<body>
	<%
	@SuppressWarnings("unchecked")
	Board boards = (Board) request.getAttribute("board");
	%>

	<h2>글 내용</h2>
	<table>
		<tr>
			<th style="width: 10%;">글번호:</th>
			<td style="width: 90%;"><%=boards.getBoardNum()%></td>
		</tr>
		<tr>
			<th style="width: 10%;">제목:</th>
			<td style="width: 90%;"><%=boards.getBoardTitle()%></td>
		</tr>
		<tr>
			<th style="width: 10%;">작성자:</th>
			<td style="width: 90%;"><%=boards.getBoardAuthor()%></td>
		</tr>
		<tr>
			<th style="width: 10%;">날짜:</th>
			<td style="width: 90%;"><%=boards.getBoardDate()%></td>
		</tr>
		<tr>
			<th style="width: 10%;">내용:</th>
			<td style="width: 90%;"><%=boards.getBoardContent()%></td>
		</tr>
	</table>
	<br>
	<br>

	<%
	@SuppressWarnings("unchecked")
	List<commentBoard> list = (List<commentBoard>) request.getAttribute("commentList");

	if (list == null || list.isEmpty()) {
	%>
	<p>댓글 목록</p>
	<table>
		<tr>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</table>
	<%
	} else {
	%>
	<table>
		<tr>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>

		<%
		for (commentBoard commentboard : list) {
		%>
		<tr>
			<td><%=commentboard.getCommentBoardAuthor()%></td>
			<td><%=commentboard.getCommentBoardTitle()%></td>
			<td><%=commentboard.getCommentBoardContent()%></td>
			<td><%=commentboard.getCommentBoardDate()%></td>
			<td><button class="edit-button"
					onclick='location.href="commenteditshow?commentNumber=<%=commentboard.getCommentBoardNumber()%>"'>수정</button></td>
			<td><button class="delete-button" id="commentNumber"
					name="commentNumber"
					data-board-num="<%=commentboard.getCommentBoardNumber()%>">삭제</button></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>


	<h4>댓글을 남겨보세요.</h4>
	<form class="commentregistboard" action="commentregistboard"
		method="post">
		<table>
			<tr>
				<th>제목 :</th>
				<td><input type="text" name="commentBoardTitle"></td>
				<th>내용 :</th>
				<td><textarea name="commentBoardContent" rows="5" cols="50"></textarea></td>
				<td><button type="button" class="commentadd-button" name="commentAdd">댓글남기기</button></td>
			</tr>
		</table>
		
		<br> <input type="hidden" name="commentBoardAuthor"
			value="<%=((Member) session.getAttribute("member")).getMemberId()%>">
		<input type="hidden" name="boardNum" value="<%=boards.getBoardNum()%>">
	</form>
	<button onclick='location.href="contentshow"'>뒤로가기 </button>

</body>
</html>