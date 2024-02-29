package practice.boarddao;
/*
 * Dao(Data[DataBase] Access Object)객체
 * 	- board(게시판) 데이타를 저장하고있는 테이블에
 *        CRUD(Create,Read,Update,Delete)작업을 할수있는 
 *        단위메쏘드를 가지고있는 클래스
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
/*
 * insert 		   o
 * selectAll
 * selectByBoardNo
 * deleteByBoardNo o
 * updateByBoardNo o
 */
	DataSource datasource;
	public BoardDao() {
		this.datasource = new DataSource();
	}
	public int insert(Board board) throws Exception {
		String insertSql = "insert into board(board_no,board_title,board_content) values(board_no_seq.nextval,'"+board.getBoard_title()+"','"+board.getBoard_content()+"')";
		Connection con = datasource.getConnetion();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:" + rowCount);
		stmt.close();
		datasource.close(con);
		return rowCount;		
	}
	
	public int updateByBoardNo(Board board) throws Exception {
		String updateSql = "update board set board_title='"+board.getBoard_title()+"',board_content='"+board.getBoard_content()+"' where board_no="+board.getBoard_no();
		Connection con = datasource.getConnetion();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> update row count:" + rowCount);
		stmt.close();
		datasource.close(con);
		return rowCount;
	}
	
	public int deleteByBoardNo(Board board) throws Exception {
		String deleteSql = "delete board where board_no="+board.getBoard_no();
		Connection con = datasource.getConnetion();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> delete row count:" + rowCount);
		stmt.close();
		datasource.close(con);
		return rowCount;
	}
	
	public Board selectByBoardNo(Board board) throws Exception {
		String selectSql = "select * from board where board_no="+board.getBoard_no();
		Connection con = datasource.getConnetion();
		Statement stmt = con.createStatement();
		Board tempboard = null;
		ResultSet rs = stmt.executeQuery(selectSql);
		if(rs.next()) {
			int no = rs.getInt("board_no");
			String title = rs.getString("board_title");
			String content = rs.getString("board_content");
			String wday = rs.getString("board_wday");
			int count = rs.getInt("board_read_count");
			tempboard = new Board(no,title,content,wday,count);
		} else {
			return tempboard;
		}
		rs.close();
		stmt.close();
		datasource.close(con);
		return tempboard;
	}
 public List<Board> selectAll() throws Exception {
	 	String selectSql = "select * from board";
		Connection con = datasource.getConnetion();
		Statement stmt = con.createStatement();
		List<Board> boardList = new ArrayList<Board>();
		ResultSet rs = stmt.executeQuery(selectSql);
		if(rs.next()) {
			do {
			int no = rs.getInt("board_no");
			String title = rs.getString("board_title");
			String content = rs.getString("board_content");
			String wday = rs.getString("board_wday");
			int count = rs.getInt("board_read_count");
			boardList.add(new Board(no, title, content, wday, count));
			}while(rs.next());
		}
		rs.close();
		stmt.close();
		datasource.close(con);
		return boardList;
	 
	 
	 /*
	  * (X) rs.getDate("board_wday");
	  * (O) rs.getString("board_wday");
	  */
	 
 } 	
	
}
