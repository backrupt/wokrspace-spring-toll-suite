package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressTableUpdateByNoMain {
	public static void main(String[] args) throws Exception{
		/***************데이터베이스 접속정보[localhost]******************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user="jdeveloper17";
		String password="jdeveloper17";
		
		String updateSql = "update address set name='김변경',phone='888-8888', address='부산시여러분' where no =1";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> update row count:"+rowCount);
		
		stmt.close();
		con.close();
	}
}
