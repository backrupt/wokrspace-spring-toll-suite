package statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class PreparedStatementMain {

	public static void main(String[] args)throws Exception {
		/************ 데이타베이스 접속정보[124.198.47.195] *************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper17";
		String password = "jdeveloper17";
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
		
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("%%%%%%%%%%%%%%% [select] %%%%%%%%%%%%%%%%%%%");
		String selectSql = 
		"select empno,ename,job,sal,hiredate from emp where sal>=? and sal<=? and job=? or job=?";
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		
		int sal1=1000;
		int sal2=4000;
		String job1="SALESMAN";
		String job2="CLERK";
		
		pstmt.setInt(1, sal1);
		pstmt.setInt(2, sal2);
		pstmt.setString(3, job1);
		pstmt.setString(4, job2);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int empno=rs.getInt("empno");
			String ename=rs.getString("ename");
			String job=rs.getString("job");
			double sal=rs.getDouble("sal");
			Date hireDate= rs.getDate("hiredate");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+hireDate);
		}
		rs.close();
		
		sal1=2000;
		sal2=5000;
		job1="MANAGER";
		job2="ANALYST";
		
		pstmt.setInt(1, sal1);
		pstmt.setInt(2, sal2);
		pstmt.setString(3, job1);
		pstmt.setString(4, job2);
		rs=pstmt.executeQuery();
		System.out.println("-----------------------------");
		while(rs.next()) {
			int empno=rs.getInt("empno");
			String ename=rs.getString("ename");
			String job=rs.getString("job");
			double sal=rs.getDouble("sal");
			Date hireDate= rs.getDate("hiredate");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+hireDate);
		}
		rs.close();
		pstmt.close();
		
		System.out.println("%%%%%%%%%%%%%%% [delete] %%%%%%%%%%%%%%%%%%%");
		String deleteSql = "delete from emp where empno=?";
		PreparedStatement pstmt5=con.prepareStatement(deleteSql);
		pstmt5.setInt(1, 9001);
		int rowCount5=pstmt5.executeUpdate();
		System.out.println(">>>delete 9001 -->"+rowCount5+" 행");
		
		pstmt5.setInt(1, 9002);
		rowCount5=pstmt5.executeUpdate();
		System.out.println(">>>delete 9002 -->"+rowCount5+" 행");
		
		pstmt5.setInt(1, 9003);
		rowCount5=pstmt5.executeUpdate();
		System.out.println(">>>delete 9003 -->"+rowCount5+" 행");
		
		pstmt5.setInt(1, 9004);
		rowCount5=pstmt5.executeUpdate();
		System.out.println(">>>delete 9004 -->"+rowCount5+" 행");
		
		System.out.println("%%%%%%%%%%%%%%% [insert] %%%%%%%%%%%%%%%%%%%");
		String insertSql1 = 
			"insert into emp values(?,?,?,?, to_date(?,?),?, ?,?)";
		
		PreparedStatement pstmt1 = con.prepareStatement(insertSql1);
		pstmt1.setInt(1, 9001);
		pstmt1.setString(2, "심윤보");
		pstmt1.setString(3, "MANAGER");
		pstmt1.setInt(4, 7369);
		pstmt1.setString(5, "2020/08/08");
		pstmt1.setString(6, "YYYY/MM/DD");
		pstmt1.setDouble(7, 5900.9898);
		pstmt1.setInt(8, 60);
		pstmt1.setInt(9, 40);
		
		int rowCount1=pstmt1.executeUpdate();
		System.out.println(">>insert 9001 -->"+rowCount1+ "행 insert");
		pstmt1.close();
		
		String insertSql2 = 
				"insert into emp values(?,?,?,?,sysdate,?, ?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(insertSql2);
		pstmt2.setInt(1, 9002);
		pstmt2.setString(2, "김태희");
		pstmt2.setString(3, "CLERK");
		pstmt2.setInt(4, 7369);
		pstmt2.setDouble(5, 5956.31);
		pstmt2.setInt(6, 600);
		pstmt2.setInt(7, 40);
		int rowCount2 = pstmt2.executeUpdate();
		System.out.println(">>insert 9002 -->"+rowCount2+ "행 insert");
		pstmt2.close();
		
	    String insertSql3 = 
				"insert into emp values(?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt3 = con.prepareStatement(insertSql3);
	    pstmt3.setInt(1, 9003);
		pstmt3.setString(2, "DIM");
		pstmt3.setString(3, "SALESMAN");
		pstmt3.setInt(4, 7369);
		java.util.Date utilDate= new SimpleDateFormat("yyyy/MM/dd").parse("2010/10/10");
		pstmt3.setDate(5, new java.sql.Date(utilDate.getTime()));
		pstmt3.setDouble(6, 5900.9898);
		pstmt3.setInt(7, 6000);
		pstmt3.setInt(8, 40);
		int rowCount3 = pstmt3.executeUpdate();
		System.out.println(">>insert 9003 -->"+rowCount3+ "행 insert");
		pstmt3.close();
		
		System.out.println("%%%%%%%%%%%%%%% [insert] %%%%%%%%%%%%%%%%%%%");
		//String updateSql = "update emp set sal=sal*1.3 where empno >= 7369 and empno<=7600";
		String updateSql = "update emp set sal=sal*? where empno >= ? and empno<=?";
		PreparedStatement pstmt4 = con.prepareStatement(updateSql);
		pstmt4.setDouble(1, 1.3);
		pstmt4.setInt(2, 9001);
		pstmt4.setInt(3, 9003);
		int rowCount4 = pstmt4.executeUpdate();
		System.out.println(">>update -->"+rowCount4+ "행 update");
		pstmt4.close();
		
		
		
		
		
	}

}