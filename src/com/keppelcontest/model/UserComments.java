package com.keppelcontest.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.ServletException;

import com.keppelcontest.data.UserCommentsDAO;
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
	public void insert(String userfbappid, String fullname, String usercomment) throws SQLException {
		if (conn != null){
			CallableStatement stmt = conn.prepareCall("{call insertUserComment(?, ?, ?)}");
			stmt.setString(1, fullname);
			stmt.setString(2, usercomment);
			stmt.setString(3, userfbappid);
			stmt.executeUpdate();
			db.close(conn);
		}
	}
	@Override
	public void delete(int commentid) throws SQLException {
		// TODO Auto-generated method stub
	}
	@Override
	public UserCommentsDAO find(String userfbappid) throws SQLException {
		UserCommentsDAO d = null;
		if (conn != null){
			CallableStatement stmt = conn.prepareCall("{call findUserComments(?, ?, ?, ?)}");
			stmt.setString(1, userfbappid);
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.registerOutParameter(3, Types.LONGVARCHAR);
			stmt.registerOutParameter(4, Types.TIMESTAMP);
			stmt.execute();
			d = new UserCommentsDAO(userfbappid, stmt.getString("p_fullname"), stmt.getString("p_usercomments"));
			db.close(conn);
		}
		return d;
	}
	public void close(){
		if (conn != null)
			db.close(conn);
	}
}