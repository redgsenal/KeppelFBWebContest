package com.keppelcontest.model;

import java.sql.SQLException;

public interface CommentImpl {
	public void update(int commentid, String fullname, String usercomment) throws SQLException;
	public void insert(String fullname, String usercomment) throws SQLException;
	public void delete(int commentid) throws SQLException;
	void find(int commentid) throws SQLException;
}
