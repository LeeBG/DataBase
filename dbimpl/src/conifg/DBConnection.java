package conifg;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.security.o3logon.O3LoginClientHelper;

public class DBConnection {
	
	public static Connection getInstance() {//new할 필요가 없기에 static
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//프로젝트한번 할때 연결 한 번 
		String username = "SCOTT";
		String password = "TIGER";
		
		
		//OracleDriver 클래스를 메모리에 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//모든 클래스 다 사용가능
			//생성자를 때려줌 
			//동적 프로세스가 실행한 이후에 
			//			OracleDriver c = new OracleDriver();
			conn = DriverManager.getConnection(url,username,password);// 바이트 스트림에 연결
			//getConnection은 내부에 reflection이 메모리에 떠있는것을 찾아줌
			System.out.println("DB연결 성공");
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("연결 실패");
		}
		/*
		 * oracle.jdbc.driver. > 패키지
		 * oracle.jdbc.driver.OracleDriver를 new해서 띄워줌
		 */
		return null;
		 
		/*
		 * thin or oci 차이
		 * 
		 * thin은 순수 자바 패키지(클래스들)만으로 바로 DB연결
		 * 범용성이 좋다. 상대적으로 OCI보다는 느리다
		 * 
		 * OCI => Oracle Call Interface 
		 * .DLL .SO 파일과 같이 특정 운영체제 내에서만 돌아가는..
		 */
		
		
	}
}
