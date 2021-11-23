package com.yash.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServletClass
 */
@WebServlet(name = "WelcomeServlet", urlPatterns = { "/welcome" })
public class WelcomeServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if(session == null) {
			out.print("Welcome to next step");
			out.print("\nUser Logged in : Kinshuk Jain");
			int hits = 0;
			Cookie[] cookies = request.getCookies();
			if(cookies.length!=0) {
				for (Cookie cookie : cookies) {
					if(cookie.getName().equals("Hits")) {
						String value = cookie.getValue();
						hits = Integer.parseInt(value);
					}
				}
			}
			
			out.println("\nHit Count : "+hits);
			return;
		}
		String code = (String)session.getAttribute("attempt");
		 int attempt = Integer.parseInt(code);
		 if(attempt > 3) {
			 out.print("Unable to login Account is locked");
		 }
		 else {
			 out.print("Welcome to next step");
			 out.print("\nUser Logged in : Kinshuk Jain");
			 out.println("\nHit Count");
		 }
	}

}
