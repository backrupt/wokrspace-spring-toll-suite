package resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import dao.common.DataSource;

public class ResultSetMain {
	public static void main(String[] args)throws Exception {
		String selectSql="select no,name,short_desc,price,ipgo_date from product";
		Connection con = new DataSource().getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("----------------ResultSet.get타입(컬럼명)-------------");
		while(rs.next()) {
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String shortDesc = rs.getString("short_desc");
			double price = rs.getDouble("price");
			Date ipgoDate = rs.getDate("ipgo_date");
			System.out.println(no+"\t"+name+"\t"+shortDesc+"\t"+price+"\t"+ipgoDate);
		}
		rs.close();
		System.out.println("----------------ResultSet.get타입(컬럼index[1,2~])-------------");
		rs = pstmt.executeQuery(selectSql);
		while(rs.next()) {
			int no = rs.getInt(1);
			String name = rs.getString(2);
			String shortDesc = rs.getString(3);
			double price = rs.getDouble(4);
			Date ipgoDate = rs.getDate(5);
			System.out.println(no+"\t"+name+"\t"+shortDesc+"\t"+price+"\t"+ipgoDate);
		}
		rs.close();
		System.out.println("----------------ResultSet.getString타입(컬럼이름)-------------");
		rs = pstmt.executeQuery(selectSql);
		while(rs.next()) {
			String no = rs.getString("no");
			String name = rs.getString("name");
			String shortDesc = rs.getString("short_desc");
			String price = rs.getString("price");
			String ipgoDate = rs.getString("ipgo_date");
			System.out.println(no+"\t"+name+"\t"+shortDesc+"\t"+price+"\t"+ipgoDate);
		}
		rs.close();
		System.out.println("----------------ResultSet.getObject타입(컬럼이름)-------------");
		rs = pstmt.executeQuery(selectSql);
		while(rs.next()) {
			Object no = rs.getObject("no");
			String noClassTypeName = no.getClass().getSimpleName();
			System.out.println("db number타입 매핑객체 : "+noClassTypeName);
			Object name = rs.getObject("name");
			Object shortDesc = rs.getObject("short_desc");
			Object price = rs.getObject("price");
			Object ipgoDate = rs.getObject("ipgo_date");
			System.out.println(no+"\t"+name+"\t"+shortDesc+"\t"+price+"\t"+ipgoDate);
		}
		rs.close();
	}
}
