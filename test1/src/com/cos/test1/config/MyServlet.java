package com.cos.test1.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿파일 
// 호출할 수 있는방법은 필터(Filter)를 걸어야한다.
@WebServlet("/hello")
public class MyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req:바이트 스트림에 접근가능한 선 reader에서 읽는 쪽
		System.out.println("GET 요청됨");
		PrintWriter out = resp.getWriter();
		out.println("<h1>Servlet Test Page</h1>");
		int n1 =1;
		int n2 =2;
		int sum =n1+n2;
		
		out.println("<table border=\"1\">");
		out.println("<tr><td>SUM</td></tr>");
		out.println("<tr><td>");
		out.println(sum);
		out.println("</tr></td></table>");
		out.flush();
	}
}
