package com.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("Text/html");
		PrintWriter out=res.getWriter();
		ServletContext ctx=getServletContext();
		String uname = ctx.getInitParameter("userId");
		String pass = ctx.getInitParameter("psw");
		
		if(uname.equals(req.getParameter("uname"))) {
			if(pass.equals(req.getParameter("psw"))) {
				out.println("<center><h1>Welcome "+uname+"</h1></center>");
			}
			else {
				out.println("Please enter correct Password");
			}
		}
		else {
			out.println("Please enter your correct userId");
		}
	}
}
