package com.cos.hello.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	
	public static void href(HttpServletResponse response,String url,String msg) throws IOException{
//		response.setHeader("Content-Type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+msg+"')");
		out.println("location.href='"+url+"'");
		out.println("</script>");
		out.flush();
	}
	public static void msg() {
		
	}
	public static void back(HttpServletResponse response,String msg) throws IOException{
		PrintWriter out = response.getWriter();		//BufferedWriter하는 것
		out.println("<script>");
		out.println("alert('"+msg+"')");
		out.println("hostory.back()");
		out.println("</script>");
		out.flush();
	}
}
