package com.keppelcontest.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keppelcontest.data.UserCommentsDAO;
import com.keppelcontest.model.UserComments;
import com.keppelcontest.utils.Utils;

/**
 * Servlet implementation class CheckUserComments
 * Get user comments made.  This should contain only 1 comment per facebook user
 */
@WebServlet("/FBUserComments")
public class FBUserComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FBUserComments() {
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
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("userfbappid");
		UserCommentsDAO d = new UserCommentsDAO(id, "", "");
		try {
			UserComments comments = new UserComments();
			d = comments.find(id);
			//response.sendRedirect("formcomplete.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print(d.toString());
	}
}
