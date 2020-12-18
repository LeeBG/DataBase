package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conifg.DBConnection;
import model.Dept;

//Data Access Object(데이터에 접근하게 해주는 객체) - 재사용
public class DeptDao {
	public void 추가(int id) {
		String sql = "INSERT INTO test1(id) VALUES(?)";		//""내에세미콜론(;)절대 넣지 말것
		Connection conn = DBConnection.getInstance();		//바이트 스트림 연결
		try {
//			PrintWriter pw = new PrintWriter(conn.getInputStream());
//			pw.print("INSERT"+sql);
//			pw.flush();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);//준비해야하는 문장
			pstmt.setInt(1, id);//or, and, keyword, --, " " 다 막아줌
			int result = pstmt.executeUpdate();		//변경된 rowCount를 반환한다.
			// -값은 오류일시 return
			System.out.println("result:"+result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //인터페이스가 적용돼있는 버퍼 > 함수만 때리면 됨
	}
	
	public void 삭제(int id) {
		String sql = "DELETE FROM test1 WHERE id = ?";		//""내에세미콜론(;)절대 넣지 말것
		Connection conn = DBConnection.getInstance();		//바이트 스트림 연결
		try {
//			PrintWriter pw = new PrintWriter(conn.getInputStream());
//			pw.print("INSERT"+sql);
//			pw.flush();
			PreparedStatement pstmt = conn.prepareStatement(sql);//준비해야하는 문장
			pstmt.setInt(1, id);//or, and, keyword, --, " " 다 막아줌
			int result = pstmt.executeUpdate();		//변경된 rowCount를 반환한다. 내부적으로 커밋
			// -값은 오류일시 return
			System.out.println("result:"+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //인터페이스가 적용돼있는 버퍼 > 함수만 때리면 됨
	}
	
	public void 갱신(int id,int change) {
		String sql = "UPDATE test1 SET id = ? where id = ?";		//""내에세미콜론(;)절대 넣지 말것
		Connection conn = DBConnection.getInstance();		//바이트 스트림 연결
		try {
//			PrintWriter pw = new PrintWriter(conn.getInputStream());
//			pw.print("INSERT"+sql);
//			pw.flush();
			PreparedStatement pstmt = conn.prepareStatement(sql);//준비해야하는 문장
			pstmt.setInt(1, change);//or, and, keyword, --, " " 다 막아줌
			pstmt.setInt(2, id);
			int result = pstmt.executeUpdate();		//변경된 rowCount를 반환한다. 내부적으로커밋
			// -값은 오류일시 return
			System.out.println("result:"+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //인터페이스가 적용돼있는 버퍼 > 함수만 때리면 됨
	}
	public Dept 검색(int deptno) {
		String sql = "SELECT deptno,dname,loc FROM dept WHERE deptno = ?";		//""내에세미콜론(;)절대 넣지 말것
		Connection conn = DBConnection.getInstance();		//바이트 스트림 연결
		try {
//			PrintWriter pw = new PrintWriter(conn.getInputStream());
//			pw.print("INSERT"+sql);
//			pw.flush();
			PreparedStatement pstmt = conn.prepareStatement(sql);//준비해야하는 문장
			pstmt.setInt(1, deptno);//or, and, keyword, --, " " 다 막아줌	//primary key를 찾는다.
			ResultSet rs = pstmt.executeQuery();		//rs는 결과 집합 
			if(rs.next()) {			//커서를 한칸 내린다 return boolean(데이터있으면true,없으면false)
				Dept dept = Dept.builder()
						.deptno(rs.getInt("deptno"))
						.dname(rs.getString("dname"))
						.loc(rs.getString("loc"))
						.build();
				return dept;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Dept> 전체검색() {
		String sql = "SELECT deptno,dname,loc FROM dept";		//""내에세미콜론(;)절대 넣지 말것
		Connection conn = DBConnection.getInstance();		//바이트 스트림 연결
		List<Dept> deptList = new ArrayList<Dept>();
		try {
//			PrintWriter pw = new PrintWriter(conn.getInputStream());
//			pw.print("INSERT"+sql);
//			pw.flush();
			PreparedStatement pstmt = conn.prepareStatement(sql);//준비해야하는 문장
			ResultSet rs = pstmt.executeQuery();		//rs는 결과 집합 
			while(rs.next()) {			//커서를 한칸 내린다 return boolean(데이터있으면true,없으면false)
				Dept dept = Dept.builder()
						.deptno(rs.getInt("deptno"))
						.dname(rs.getString("dname"))
						.loc(rs.getString("loc"))
						.build();
				deptList.add(dept);
			}
			System.out.println(deptList);
			return deptList;
		} catch (Exception e) {
			System.out.println("펑");
			e.printStackTrace();
		}
		return null;
	}
}
