package com.yash.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServletControllerClass
 */
@WebServlet(name = "LoginServletController", urlPatterns = { "/doAuth" })
public class LoginServletControllerClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServletControllerClass() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    int attempt=0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user_name");
		String password = request.getParameter("passWord");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		if(username.equals("kinshuk.jain") && password.equals("kinshu123")) {
			session.setAttribute("attempt", ""+attempt);
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome");
			dispatcher.forward(request, response);
		}
		else {
			attempt++;
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
			dispatcher.include(request, response);
			out.println("<script>alert('Invalid username/password')</script>");
		}
		
		if(attempt > 3) {			
			out.println("<script>alert('Account is locked')</script>");
		}
		
	}

}
