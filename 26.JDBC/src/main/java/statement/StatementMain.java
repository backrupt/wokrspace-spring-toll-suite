package statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementMain {
	public static void main(String[] args)throws Exception {
		/***************데이터베이스 접속정보[localhost]******************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user="jdeveloper17";
		String password="jdeveloper17";
		
		/*
		이름       널?       유형           
		-------- -------- ------------ 
		EMPNO    NOT NULL NUMBER(4)    
		ENAME             VARCHAR2(10) 
		JOB               VARCHAR2(9)  
		MGR               NUMBER(4)    
		HIREDATE          DATE         
		SAL               NUMBER(7,2)  
		COMM              NUMBER(7,2)  
		DEPTNO            NUMBER(2)    
		*/
		String selectSql="select empno,ename,job,sal,hiredate  from emp where sal >=1000 and sal <= 4000 and job = 'SALSMAN' or job = 'CLERK'";
		String insertSql="insert into emp values(9000,'JUNG','MANAGER',7369,to_date('2000/01/10','YYYY/MM/DD'),3000.34,30,40)";
		String updateSql="update emp set sal = sal*1.3 where empno>=7369 and empno<=7600";
		String deleteSql="delete from emp where empno=9000";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		System.out.println("--------------------Statement.executeQuery(selectSql)---------------------");
		ResultSet rs = stmt.executeQuery(selectSql);
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			double sal = rs.getDouble("sal");
			Date hiredate = rs.getDate("hiredate");
			System.out.println(empno+"\t"+empno+"\t"+job+"\t"+hiredate);
		}
		rs.close();
		System.out.println("--------------------Statement.executeUpdate(dml)---------------------");
		
		int rowCount = 0;
		rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:"+rowCount);
		rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> update row count:"+rowCount);
		rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> delete row count:"+rowCount);
		stmt.close();
		con.close();
		
		
	}
}
