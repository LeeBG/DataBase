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
		if (gubun.equals("login")) {
			response.sendRedirect("auth/login.jsp"); // request를 하면 한번 더 req를 한다.
		} else if (gubun.equals("join")) {
			response.sendRedirect("auth/join.jsp"); // request를 하면 한번 더 req를 한다.
		} else if (gubun.equals("selectOne")) {
			// 유저 정보 보기
			// 인증이 필요한 페이지
			String result;
			HttpSession session = request.getSession();
			if (session.getAttribute("sessionUser") != null) {// 인증 끝
				Users user = (Users) session.getAttribute("sessionUser");
				result = "인증되었습니다.";
				System.out.println(user);
			} else {
				result = "인증되지 않았습니다.";
			}
			request.setAttribute("result", result);
			
			//request유지기법
			RequestDispatcher dis = request.getRequestDispatcher("user/selectOne.jsp");
			dis.forward(request, response);	//데이터를 뿌림

//			response.sendRedirect("user/selectOne.jsp");

		} else if (gubun.equals("updateOne")) {
			response.sendRedirect("user/updateOne.jsp");
		} else if (gubun.equals("joinProc")) {	//회원가입 수행해줘
			// 데이터 원형 : username=ssar&password=1234&email=ssar@nate.com

			// 1번 form의 input태그에 있는 세가지 값 username, password, email을 받기

			// request.getParameter == request에 있는데이터를 파싱해준다.

			// 단 POST방식에서는 데이터타입이 x-www-form-urlencoded 방식만 받을 수 있음.

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");

//			System.out.println("=========JoinProc Start==========");
//			System.out.println(username);
//			System.out.println(password);
//			System.out.println(email);
//			System.out.println("=========JoinProc End==========");
			// 2번 데이터베이스에 연결해서 저 세가지를 insert해야한다.
			Users user = Users.builder()
					.username(username)
					.password(password)
					.email(email)
					.build();
			
			UsersDao usersdao = new UsersDao();
			int result = usersdao.insert(user);
			if(result==1) {
				// 3번 insert가 정상적으로 되었다면 index.jsp를 응답.
				response.sendRedirect("auth/login.jsp");
			}else {
				response.sendRedirect("auth/join.jsp");
			}			
			//DAO만들어서 깔끔하게 처리하기
		} else if (gubun.equals("loginProc")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("========loginProc Start=======");
			System.out.println(username);
			System.out.println(password);
			System.out.println("========loginProc End=======");
			// 2번 데이터베이스 값이 있는 select 해서 확인
			// 생략
			Users user = Users.builder().id(1).username(username).build();
			// 3번
			HttpSession session = request.getSession();
			// session에는 사용자 패스워드는 절대 넣지 않는다!
			session.setAttribute("sessionUser", user);
			// 모든 응답에는 jSessionId가 쿠키로 추가된다.

			// 4번 index.jsp페이지로 이동
			response.sendRedirect("index.jsp");
		}
	}
}
