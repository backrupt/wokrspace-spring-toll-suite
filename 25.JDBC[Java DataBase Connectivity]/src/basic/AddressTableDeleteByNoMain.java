package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressTableDeleteByNoMain {
	public static void main(String[] args) throws Exception{
		/***************데이터베이스 접속정보[localhost]******************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user="jdeveloper17";
		String password="jdeveloper17";
		
		String deleteSql = "delete from address where no = 6";
		
		/*
		 * 1.Driver class loading
		 * 2.Connection 객체생성
		 * 3.Statement 객체생성
		 * 4.SQL문전송(insert)
		 * 5.SQL문전송(insert) 결과 영향받은행의 수 반환
		 * 6.연결객체해지(resource해지) close
		 */
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> update row count:"+rowCount);
		
		stmt.close();
		con.close();
	}
}
