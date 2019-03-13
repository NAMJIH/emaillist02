package com.jihoon.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jihoon.emaillist.vo.EmaillistVo;

public class EmaillistDao {
	public void insert(EmaillistVo ev ) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?sslMode=DISABLED&characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. 쿼리 준비
			String sql = "insert into emaillist values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setString(1, ev.getFirstName());
			pstmt.setString(2, ev.getLastName());
			pstmt.setString(3, ev.getEmail());
			
			//5. sql 실행
			pstmt.executeUpdate();
			
		} catch( ClassNotFoundException e ) {
			System.out.println( "드러이버 로딩 실패:" + e );
		} catch(SQLException e) {
			System.out.println( "error:" + e );
		}

	}
	
	public List<EmaillistVo> getList(){
		
		List<EmaillistVo> list = new ArrayList<EmaillistVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?sslMode=DISABLED&characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. 쿼리 준비
			String sql = "select no, first_name, last_name, email from emaillist";
			pstmt = conn.prepareStatement(sql);
			
			//4. sql 실행
			rs = pstmt.executeQuery();
			
			//5. 결과 받아오기
			while(rs.next()) {
				long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				EmaillistVo emaillistVo = new EmaillistVo();
				emaillistVo.setNo(no);
				emaillistVo.setFirstName(firstName);
				emaillistVo.setLastName(lastName);
				emaillistVo.setEmail(email);
				
				list.add(emaillistVo);
			}
			
		} catch( ClassNotFoundException e ) {
			System.out.println( "드러이버 로딩 실패:" + e );
		} catch(SQLException e) {
			System.out.println( "error:" + e );
		}
		
		return list;
	}
}
