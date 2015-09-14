package com.keppelcontest.model;

import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.keppelcontest.utils.DBConn;

public class UserComments implements CommentImpl {
	
	private java.sql.Connection conn;
	private DBConn db = new DBConn();
	public UserComments() throws SQLException, ServletException {
		conn = db.getPool().getConnection();
	}
	@Override
	public void update(int commentid, String fullname, String usercomment)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insert(String fullname, String usercomment) throws SQLException {
		if (conn != null){
			CallableStatement stmt = conn.prepareCall("{call insertUserComment(?, ?)}");
			stmt.setString(1, fullname);
			stmt.setString(2, usercomment);
			stmt.executeUpdate();
			db.close(conn);
		}
	}
	@Override
	public void delete(int commentid) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void find(int commentid) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}