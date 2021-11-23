package com.yash.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServletControllerClass
 */
public class CalculatorServletControllerClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServletControllerClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String expr = request.getParameter("expr");
		expr = expr.trim();
		expr = expr.replaceAll(" ","+");
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = engineManager.getEngineByName("nashorn");
		PrintWriter pw = response.getWriter();
		try {
			Object eval = scriptEngine.eval(expr);
			if(eval==null) {
				eval="";
			}
			pw.print(eval);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}
