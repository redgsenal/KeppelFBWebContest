package com.keppelcontest.data;

public class UserCommentsDAO {
	private String fullname;
	private String usercomments;
	
	public UserCommentsDAO(String fullname, String usercomments) {
		this.fullname = fullname;
		this.usercomments = usercomments;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsercomments() {
		return usercomments;
	}

	public void setUsercomments(String usercomments) {
		this.usercomments = usercomments;
	}
}