package commentboard.vo;

public class commentBoard {
	
	private int boardNum;
	private int commentBoardNumber;
	private String commentBoardTitle;
	private String commentBoardContent;
	private String commentBoardAuthor;
	private String commentBoardDate;
	private int commentboardLike;
	
	public commentBoard() {
		// TODO Auto-generated constructor stub
	}
	
	public commentBoard(int boardNum, int commentBoardNumber, String commentBoardTitle, String commentBoardContent,
			String commentBoardAuthor, String commentBoardDate, int commentboardLike) {
		super();
		this.boardNum = boardNum;
		this.commentBoardNumber = commentBoardNumber;
		this.commentBoardTitle = commentBoardTitle;
		this.commentBoardContent = commentBoardContent;
		this.commentBoardAuthor = commentBoardAuthor;
		this.commentBoardDate = commentBoardDate;
		this.commentboardLike = commentboardLike;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getCommentBoardNumber() {
		return commentBoardNumber;
	}

	public void setCommentBoardNumber(int commentBoardNumber) {
		this.commentBoardNumber = commentBoardNumber;
	}

	public String getCommentBoardTitle() {
		return commentBoardTitle;
	}

	public void setCommentBoardTitle(String commentBoardTitle) {
		this.commentBoardTitle = commentBoardTitle;
	}

	public String getCommentBoardContent() {
		return commentBoardContent;
	}

	public void setCommentBoardContent(String commentBoardContent) {
		this.commentBoardContent = commentBoardContent;
	}

	public String getCommentBoardAuthor() {
		return commentBoardAuthor;
	}

	public void setCommentBoardAuthor(String commentBoardAuthor) {
		this.commentBoardAuthor = commentBoardAuthor;
	}

	public String getCommentBoardDate() {
		return commentBoardDate;
	}

	public void setCommentBoardDate(String commentBoardDate) {
		this.commentBoardDate = commentBoardDate;
	}

	public int getCommentboardLike() {
		return commentboardLike;
	}

	public void setCommentboardLike(int commentboardLike) {
		this.commentboardLike = commentboardLike;
	}
	
}
