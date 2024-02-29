package dao.address;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileLoadMain {
	public static void main(String[] args)throws Exception {
		/*
		 *  *.properties 설정파일을 읽어서 Properties[map] 객체 생성
		 */
		
		Properties properties = new Properties();
		System.out.println(properties.size());
		/*
		 * <<절대경로>>
		FileInputStream fis = 
				new FileInputStream("C:\\Users\\itwill\\Desktop\\wokrspace-spring-toll-suite\\26.JDBC\\src\\main\\java\\a.properties");
		properties.load(fis);
		System.out.println(properties);
		/*
		/*
		 * <<상대경로>>
		 */
		InputStream fis = PropertiesFileLoadMain.class.getResourceAsStream("/a.properties");
		properties.load(fis);
		/*
		<<Properties객체>>
		------------------------------------------------------
		 key(String)| value(String)
		------------------------------------------------------
		driverClass | oracle.jdbc.OracleDriver
		url         | jdbc:oracle:thin:@124.198.47.195:1521:xe
		user        | jdeveloper30
		password    | jdeveloper30
		-------------------------------------------------------
		 */
		System.out.println("Properties size:"+properties.size());
		System.out.println(properties);
		//String driverClass = (String) properties.get("driverClass");
		String driverClass = properties.getProperty("driverClass");
		String url = properties.getProperty("url");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}
}
