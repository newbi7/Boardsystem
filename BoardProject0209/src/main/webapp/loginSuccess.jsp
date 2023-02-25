<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	  $('.like-button').click(function() {
	    var likeCount = $(this).siblings('.like-count');
	    var dislikeButton = $(this).siblings('.dislike-button');
	    var count = parseInt(likeCount.text());
	    if ($(this).hasClass('liked')) {
	      count = count - 1;
	      $(this).removeClass('liked');
	    } else {
	      count = count + 1;
	      $(this).addClass('liked');
	      dislikeButton.removeClass('disliked');
	    }
	    likeCount.text(count);
	    updateLikeStatus('liked');
	  });

	  $('.dislike-button').click(function() {
	    var dislikeCount = $(this).siblings('.dislike-count');
	    var likeButton = $(this).siblings('.like-button');
	    var count = parseInt(dislikeCount.text());
	    if ($(this).hasClass('disliked')) {
	      count = count - 1;
	      $(this).removeClass('disliked');
	    } else {
	      count = count + 1;
	      $(this).addClass('disliked');
	      likeButton.removeClass('liked');
	    }
	    dislikeCount.text(count);
	    updateLikeStatus('disliked');
	  });
	});

		$('.delete-button').click(function() {
			var boardNum = $(this).data('boardNum');

			$.ajax({
				url : 'deleteBoard',
				type : 'POST',
				data : {
					boardNum : boardNum
				},
				success : function(result) {
					location.reload();
				},
				error : function(xhr, status, error) {
					alert("삭제가 안 되었습니다. " + error + boardNum);
				}
			});

		});

		$('.out-button').click(function() {
			var memberId = $(this).data('memberId');

			$.ajax({
				url : 'memberout',
				type : 'GET',
				data : {
					memberId : memberId
				},
				success : function(result) {
					window.location.replace("login.jsp");
				},
				error : function(xhr, status, error) {
					alert("삭제가 안 되었습니다. " + error);
				}
			});

		});
	});
</script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<style>
body {
	font-family: Arial, sans-serif;
}

h1 {
	text-align: center;
	font-size: 36px;
	margin: 50px 0;
}

h3 {
	text-align: center;
	margin: 30px 0;
	font-size: 24px;
}

table {
	width: 90%;
	margin: 10px auto;
}

th, td {
	padding: 10px;
	text-align: center;
}

th {
	background-color: #ddd;
	font-size: 20px;
}

.out-button, .update-button {
	background-color: #7FFFD4;
	padding: 10px 20px;
	border-radius: 5px;
	border: none;
	cursor: pointer;
	button-align: right;
	font-size: small;
}

.like-button {
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 4px;
	padding: 5px 10px;
	font-size: 18px;
	cursor: pointer;
}

.edit-button, .delete-button {
	background-color: #7FFFD4;
	border: 1px solid #7FFFD4;
	border-radius: 4px;
	padding: 10px 20px;
	font-size: 18px;
	cursor: pointer;
	margin-left: 10px;
	color: #000;
}

.regist-button {
	background-color: #7FFFD4;
	padding: 10px 20px;
	border-radius: 5px;
	border: none;
	cursor: pointer;
	margin-top: 20px;
	margin-left: 45%;
}

a {
	color: #000;
	text-decoration: none;
}

a:hover {
	color: #ddd;
}
</style>

<body>
	<h1><%=((Member) session.getAttribute("member")).getMemberName()%>님
		환영합니다. <br>
		<button class="out-button" onclick='location.href="login.jsp"'>로그아웃</button>
		<a class="update-button"
			href="memberupdatename?memberId=
		<%=((Member) session.getAttribute("member")).getMemberId()%>">회원정보수정</a>
		<button class="out-button">회원탈퇴</button>
	</h1>

	<h3>게시글 목록</h3>
	<table border="2">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>댓글수</th>
				<th>좋아요</th>
				<th>글수정</th>
				<th>글삭제</th>
			</tr>
		</thead>
		<tbody>

			<%
			@SuppressWarnings("unchecked")
			List<Board> list = (List<Board>) request.getAttribute("boardList");

			for (Board board : list) {
			%>

			<tr>
				<td><%=board.getBoardNum()%></td>
				<td><a href="detail?boardNum=<%=board.getBoardNum()%>"><%=board.getBoardTitle()%></a></td>
				<td><%=board.getBoardAuthor()%></td>
				<td><%=board.getBoardDate()%></td>
				<td>0</td>
				<td>
					<button class="like-button">
						<i class="fa fa-thumbs-up"></i>
					</button> <span class="like-count">0</span>

					<button class="dislike-button">
						<i class="fa fa-thumbs-down"></i>
				</td>
				<td><button class="edit-button"
						onclick='location.href="nameupdateboard?boardNum=<%=board.getBoardNum()%>"'>수정</button></td>
				<td><button class="delete-button"
						data-board-num="<%=board.getBoardNum()%>">삭제</button></td>
			</tr>

			<%
			}
			%>


		</tbody>
	</table>
	<a class="regist-button"
		href="name?memberId=<%=((Member) session.getAttribute("member")).getMemberId()%>">글
		등록</a>
</body>
</html>