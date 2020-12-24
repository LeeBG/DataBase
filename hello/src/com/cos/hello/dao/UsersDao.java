package com.cos.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cos.hello.config.DBConn;
import com.cos.hello.model.Users;

public class UsersDao {
	
	public int insert(Users user) {	//excuteUpdate = int반환
		//받을 데이터를 Beans에 넣고 한방에 받기
		StringBuffer sb = new StringBuffer();	//String전용 컬렉션: 장점 동기화 돼있다(해당 reference 주소에 동시접근x)
		sb.append("INSERT INTO users(username,password,email)");
		sb.append("VALUES(?,?,?)");
		String sql = sb.toString();
		Connection conn = DBConn.getInstance();	//커넥션을 얻음 선에 접근가능
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getEmail());
			int result = pstmt.executeUpdate();	//변경된 행의 갯수를 리턴, DML문장은 모두 update
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;	//insert가 제대로 안됐다는 것을 의미
	}
}
