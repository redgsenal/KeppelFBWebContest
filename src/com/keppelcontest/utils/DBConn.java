package com.keppelcontest.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.*;
import javax.sql.DataSource;
import javax.naming.*;

public class DBConn {
	static DataSource pool; // Database connection pool
	public DBConn() throws ServletException {
		try {
			// Create a JNDI Initial context to be able to lookup the DataSource
			InitialContext ctx = new InitialContext();
			// Lookup the DataSource, which will be backed by a pool
			// that the application server provides.
			pool = (DataSource) ctx.lookup("java:comp/env/jdbc/dbkeppelcontest");
			if (pool == null)
				throw new ServletException("Unknown DataSource");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}
	
	public DataSource getPool() {
		return pool;
	}
	
	public void close(Connection conn){
		if (conn == null)
			return;
		try {
			if (!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utils.log("error closing db connection");
		}
	}
}
