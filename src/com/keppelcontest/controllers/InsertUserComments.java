package com.keppelcontest.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keppelcontest.model.UserComments;

/**
 * Servlet implementation class InsertUserComments
 */
@WebServlet("/InsertUserComments")
public class InsertUserComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserComments() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn = request.getParameter("fullname");
		String uc = request.getParameter("usercomments");
		String id = request.getParameter("userfbappid");
		UserComments comments = null;
		try {
			comments = new UserComments();
			comments.insert(id, fn, uc);
			response.sendRedirect("formcomplete.jsp");
		} catch (SQLException e) {
			if (comments != null)
				comments.close();
			e.printStackTrace();
		}		
	}
}