package com.keppelcontest.data;

import com.keppelcontest.utils.json.JSONObject;

public class UserCommentsDAO {
	private String userfbappid;
	private String fullname;
	private String usercomments;
	
	public UserCommentsDAO(String userfbappid, String fullname, String usercomments) {
		this.fullname = fullname;
		this.usercomments = usercomments;
		this.userfbappid = userfbappid;  
	}

	public UserCommentsDAO() {
		// TODO Auto-generated constructor stub
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

	public String getUserfbappid() {
		return userfbappid;
	}

	public void setUserfbappid(String userfbappid) {
		this.userfbappid = userfbappid;
	}
	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("userfbappid", this.userfbappid);
		json.put("fullname", this.fullname);
		json.put("usercomments", this.usercomments);
		return json.toString();
	}
}