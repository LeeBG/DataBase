package com.cos.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.hello.config.DBConn;
import com.cos.hello.dto.JoinDto;
import com.cos.hello.dto.LoginDto;
import com.cos.hello.model.Users;

public class UsersDao {
	
	public int insert(JoinDto joinDto) {	//excuteUpdate = int반환
		//받을 데이터를 Beans에 넣고 한방에 받기
		StringBuffer sb = new StringBuffer();	//String전용 컬렉션: 장점 동기화 돼있다(해당 reference 주소에 동시접근x)
		sb.append("INSERT INTO users(username,password,email)");
		sb.append("VALUES(?,?,?)");
		String sql = sb.toString();
		
		Connection conn = DBConn.getInstance();	//커넥션을 얻음 선에 접근가능
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,joinDto.getUsername());
			pstmt.setString(2,joinDto.getPassword());
			pstmt.setString(3,joinDto.getEmail());
			int result = pstmt.executeUpdate();	//변경된 행의 갯수를 리턴, DML문장은 모두 update
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;	//insert가 제대로 안됐다는 것을 의미
	}
	public Users login(LoginDto loginDto) {
		StringBuffer sb = new StringBuffer();	//String전용 컬렉션: 장점 동기화 돼있다(해당 reference 주소에 동시접근x)
		sb.append("SELECT id,username,email FROM users WHERE username = ? AND password = ?");
		String sql = sb.toString();
		
		Connection conn = DBConn.getInstance();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,loginDto.getUsername());
			pstmt.setString(2,loginDto.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Users userEntity = Users.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.email(rs.getString("email"))
						.build();
				return userEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Users selectById(int id) {
		StringBuffer sb = new StringBuffer();	//String전용 컬렉션: 장점 동기화 돼있다(해당 reference 주소에 동시접근x)
		sb.append("SELECT id,password,username,email FROM users WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getInstance();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);	
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Users userEntity = Users.builder()
						.id(rs.getInt("id"))
						.password(rs.getString("password"))
						.username(rs.getString("username"))
						.email(rs.getString("email"))
						.build();
				return userEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(Users users) {
		StringBuffer sb = new StringBuffer();	//String전용 컬렉션: 장점 동기화 돼있다(해당 reference 주소에 동시접근x)
		sb.append("UPDATE users SET password = ?, email = ? where id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getInstance();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,users.getPassword());
			pstmt.setString(2,users.getEmail());
			pstmt.setInt(3,users.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int delete(int id) {
		StringBuffer sb = new StringBuffer();	//String전용 컬렉션: 장점 동기화 돼있다(해당 reference 주소에 동시접근x)
		sb.append("DELETE from users where id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
