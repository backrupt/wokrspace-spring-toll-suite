package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressTableInsertMain {
	public static void main(String[] args) throws Exception{
		/***************데이터베이스 접속정보[localhost]******************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user="jdeveloper17";
		String password="jdeveloper17";
		
		String insertSql = "insert into address values(address_no_seq.nextval,'김경호','123-4567','서울시여러분')";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:"+rowCount);
		
		stmt.close();
		con.close();
		
	}
}
