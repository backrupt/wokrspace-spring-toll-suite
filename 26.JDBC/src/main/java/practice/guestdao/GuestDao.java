package practice.guestdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.common.DataSource;
import practice.guestdao.erd.GuestSQL;

public class GuestDao {
	/*
	3. Dao클래스작성
 	- 테이블에 insert,deleteByPk,updatePk,selectByPk,selectAll 단위메쏘드만들기
    - 단위메쏘드(인자 반환타입정의)생성
    */
	private DataSource datasource;
	public GuestDao() throws Exception {
		datasource = new DataSource();
	}

	public int insert(Guest guest)throws Exception {
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1, guest.getGuestName());
		pstmt.setString(2, guest.getGuestEmail());
		pstmt.setString(3, guest.getGuestHomepage());
		pstmt.setString(4, guest.getGuestTitle());
		pstmt.setString(5, guest.getGuestContent());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		datasource.close(con);
		return rowCount;
	}
	
	public int deleteByPk(Guest guest)throws Exception {
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, guest.getGuestNo());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	public int deleteByPk(int no)throws Exception {
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		datasource.close(con);
		return rowCount;
	}
	
	public int updateByPk(Guest guest) throws Exception{
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1, guest.getGuestName());
		pstmt.setString(2, guest.getGuestEmail());
		pstmt.setString(3, guest.getGuestHomepage());
		pstmt.setString(4, guest.getGuestTitle());
		pstmt.setString(5, guest.getGuestContent());
		pstmt.setInt(6, guest.getGuestNo());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		datasource.close(con);
		return rowCount;
	}
	public Guest findByGuestNo(int guestNo) throws Exception{
		Guest guest = null;
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NO);
		pstmt.setInt(1, guestNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			guest = new Guest(rs.getInt("guest_no"),
					rs.getString("guest_name"),
					rs.getDate("guest_date"),
					rs.getString("guest_email"),
					rs.getString("guest_homepage"),
					rs.getString("guest_title"),
					rs.getString("guest_content"));
		}
		rs.close();
		pstmt.close();
		datasource.close(con);
		return guest;
	}
	
	public List<Guest> findByAll() throws Exception{
		List<Guest> guestList = new ArrayList<Guest>();
		Connection con = datasource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			guestList.add(new Guest(rs.getInt("guest_no"),
									rs.getString("guest_name"),
									rs.getDate("guest_date"),
									rs.getString("guest_email"),
									rs.getString("guest_homepage"),
									rs.getString("guest_title"),
									rs.getString("guest_content")));
			}
		rs.close();
		pstmt.close();
		datasource.close(con);
		return guestList;
	}
}
