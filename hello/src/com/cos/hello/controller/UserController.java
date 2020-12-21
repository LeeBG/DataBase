package com.cos.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//javax로 시작하는 패키지를 톰켓이 들고 있는 라이브러리
public class UserController extends HttpServlet {
	
	//req와 res는 톰켓이 만들어 줍니다. (클라이언트의 요청이 있을 때마다)
	//req는 BufferedReader(서버입장에서) 할 수 있는 ByteStream.
	//res는 BufferedWriter 할 수 있는 ByteStream
	//req,res 는 http프로토콜이 적용돼있다.
	
	//http://localhost:8000/hello/front 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserController실행됨");
		doProcess(request, response);
		String gubun = request.getParameter("gubun");				// /hello/front
		System.out.println(gubun);	
		if(gubun.equals("login")) {
			response.sendRedirect("auth/login.jsp");	//request를 하면 한번 더 req를 한다.
		}else if(gubun.equals("join")) {
			response.sendRedirect("auth/join.jsp");		//request를 하면 한번 더 req를 한다.
		}else if(gubun.equals("selectOne")) {
			response.sendRedirect("user/selectOne.jsp");
		}else if(gubun.equals("updateOne")) {
			response.sendRedirect("user/updateOne.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request , response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//http://localhost:8000/hello/user?gubun=login
		//라우팅 : 내가 만든 프로토콜
		
		System.out.println("User Process요청");
	}
}
