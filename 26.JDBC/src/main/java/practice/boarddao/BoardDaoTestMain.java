package practice.boarddao;

import java.util.List;

public class BoardDaoTestMain {

	public static void main(String[] args) throws Exception{
		BoardDao bd = new BoardDao();
		Board board1 = new Board(0, "아무제목", "아무설명", "sysdate", 1);
		Board board2 = new Board(1, "아무제목", "아무설명", "sysdate", 1);
		Board board3 = new Board(2, "아무제목", "아무설명", "sysdate", 1);
		//bd.insert(board1);
		//bd.insert(board2);
		//bd.insert(board3);
		
		bd.updateByBoardNo(new Board(4, "바꿔버리기", "바꾼설명", "sysdate", 0));
		 
		bd.deleteByBoardNo(board3);
		System.out.println(bd.selectByBoardNo(board3));
		System.out.println(bd.selectByBoardNo(board2));
		System.out.println(bd.selectByBoardNo(new Board(4,"바꿔버리기", "바꾼설명", "sysdate",0)));
		List<Board> boardList = bd.selectAll();
		for (Board board : boardList) {
			board.toString();
			System.out.println(board);
		}
		

	}

}
