package practice.boarddao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	/************ 데이타베이스 접속정보[124.198.47.195]를 저장할 필드*************/
	private String driverClass = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
	private String user = "jdeveloper17";
	private String password = "jdeveloper17";
	/**************************************************************/
	
	public Connection getConnetion()throws Exception {
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
	public void close(Connection con) throws Exception{
		con.close();
	}
}
