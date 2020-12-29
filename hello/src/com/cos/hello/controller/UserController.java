package com.cos.hello.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.hello.config.DBConn;
import com.cos.hello.dao.UsersDao;
import com.cos.hello.model.Users;
import com.cos.hello.service.UsersService;

//javax로 시작하는 패키지를 톰켓이 들고 있는 라이브러리
//디스패쳐의 역할  = 분기 = 필요한 VIEW를 응답해주는것 
public class UserController extends HttpServlet {
	// request.getParameter == request에 있는데이터를 파싱해준다.

	// req와 res는 톰켓이 만들어 줍니다. (클라이언트의 요청이 있을 때마다)
	// req는 BufferedReader(서버입장에서) 할 수 있는 ByteStream.
	// res는 BufferedWriter 할 수 있는 ByteStream
	// req,res 는 http프로토콜이 적용돼있다.

	// http://localhost:8000/hello/front
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserController실행됨");
		// http://localhost:8000/hello/user?gubun=login
		// 라우팅 : 내가 만든 프로토콜
		String gubun = request.getParameter("gubun"); // /hello/front
		System.out.println(gubun);
		route(gubun, request, response);

	}

	private void route(String gubun, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersService usersService = new UsersService();
		if (gubun.equals("login")) {
			response.sendRedirect("auth/login.jsp"); // request를 하면 한번 더 req를 한다.
		} else if (gubun.equals("join")) {
			response.sendRedirect("auth/join.jsp"); // request를 하면 한번 더 req를 한다.
		} else if (gubun.equals("selectOne")) {
			usersService.유저정보보기(request, response);
		} else if (gubun.equals("updateOne")) {
			usersService.유저정보수정페이지(request, response);
		} else if (gubun.equals("joinProc")) { // 회원가입 수행해줘
			usersService.회원가입(request, response);
			// DAO만들어서 깔끔하게 처리하기
		} else if (gubun.equals("loginProc")) {
			usersService.로그인(request, response);
		} else if (gubun.equals("updateProc")) {
			usersService.유저정보수정완료(request, response);
		} else if (gubun.equals("deleteProc")) {
			usersService.유저정보삭제(request, response);
		}
	}
}
