package com.keppelcontest.model;

import java.sql.SQLException;

import com.keppelcontest.data.UserCommentsDAO;

public interface CommentImpl {
	public void update(int commentid, String fullname, String usercomment) throws SQLException;
	public void insert(String userfbappid, String fullname, String usercomment) throws SQLException;
	public void delete(int commentid) throws SQLException;
	public UserCommentsDAO find(String userappuserid) throws SQLException;
}
