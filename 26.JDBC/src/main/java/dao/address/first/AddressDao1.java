package dao.address.first;
/*
  Dao(Data Access Object)클래스
    - address 테이블에 CRUD(Create,Read,Update,Delete) 작업을하는 
      단위메쏘드를 가지고있는 클래스
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDao1 {
	/************ 데이타베이스 접속정보[124.198.47.195] *************/
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
	String user = "jdeveloper30";
	String password = "jdeveloper30";

	/**************************************************************/
	public void insert() throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval,'김경호','123-4567','서울시여러분')";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:" + rowCount);
		stmt.close();
		con.close();
	}

	public void updateByNo() throws Exception {
		String updateSql = "update address set name='김변경' ,phone='888-8888', address='부산시여러분' where no=2";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> update row count:" + rowCount);
		stmt.close();
		con.close();
	}

	public void deleteByNo() throws Exception {

		String deleteSql = "delete from address where no=2";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();

		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> delete row count:" + rowCount);

		stmt.close();
		con.close();
	}

	public void selectByNo() throws Exception {

		String selectSql = "select no,name,phone,address from address where no=1";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no + "\t" + name + "\t" + phone + "\t" + address);
		} else {
			System.out.println(">>주소록 친구없다~~~");
		}
		rs.close();
		stmt.close();
		con.close();
	}

	public void selectAll() throws Exception {

		String selectSql = "select no,name,phone,address from address";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(selectSql);

		if (rs.next()) {
			do {

				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				System.out.println(no + "\t" + name + "\t" + phone + "\t" + address);
			} while (rs.next());
		} else {
			System.out.println(">> 주소록친구없다~~~");
		}
		rs.close();
		stmt.close();
		con.close();
	}

}