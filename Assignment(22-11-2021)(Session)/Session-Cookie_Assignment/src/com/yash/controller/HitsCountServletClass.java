package com.yash.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitsCountServletClass
 */
@WebServlet(name = "HitsCountServlet", urlPatterns = { "/count" })
public class HitsCountServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitsCountServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    int hits = 0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("Hits", ""+hits);
		cookie.setMaxAge(60*60);
		hits++;
		response.addCookie(cookie);
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome");
		dispatcher.forward(request, response);
	}

}
