package test.config;

import static org.junit.Assert.assertNotNull;
import java.sql.Connection;
import org.junit.Test;
import conifg.DBConnection;

public class DBConnectionTest {
	@Test
	public void 데이터베이스연결_테스트(){
		Connection conn = DBConnection.getInstance();
//		Connection conn2 = null;
		assertNotNull(conn);
		
	}
	
//	public static void main(String[] args) {
//		DBConnectionTest d = new DBConnectionTest();
//		d.데이터베이스연결_테스트();
//	}
}
