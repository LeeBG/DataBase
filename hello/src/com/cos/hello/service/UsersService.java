package com.cos.hello.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.hello.dao.UsersDao;
import com.cos.hello.dto.JoinDto;
import com.cos.hello.dto.LoginDto;
import com.cos.hello.model.Users;
import com.cos.hello.util.Script;

public class UsersService {
	public void 회원가입(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 데이터 원형 : username=ssar&password=1234&email=ssar@nate.com

		// 1번 form의 input태그에 있는 세가지 값 username, password, email을 받기

		// request.getParameter == request에 있는데이터를 파싱해준다.

		// 단 POST방식에서는 데이터타입이 x-www-form-urlencoded 방식만 받을 수 있음.

//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
//		// 2번 데이터베이스에 연결해서 저 세가지를 insert해야한다.
//		Users user = Users.builder().username(username).password(password).email(email).build();

		JoinDto joinDto = (JoinDto)request.getAttribute("dto");
		
		UsersDao usersDao = new UsersDao();
		int result = usersDao.insert(joinDto);
		
		if (result == 1) {
			// 3번 insert가 정상적으로 되었다면 index.jsp를 응답.
			response.sendRedirect("auth/login.jsp");
		} else {
			response.sendRedirect("auth/join.jsp");
		}
	}

	public void 로그인(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 데이터 원형 : username=ssar&password=1234&email=ssar@nate.com

		// 1번 form의 input태그에 있는 세가지 값 username, password, email을 받기

		// request.getParameter == request에 있는데이터를 파싱해준다.

		// 단 POST방식에서는 데이터타입이 x-www-form-urlencoded 방식만 받을 수 있음.



		LoginDto loginDto = (LoginDto)request.getAttribute("dto");
		UsersDao usersDao = new UsersDao();
		Users userEntity = usersDao.login(loginDto);

		// 4번 index.jsp페이지로 이동
		if (userEntity != null) {
			// 3번 insert가 정상적으로 되었다면 index.jsp를 응답.
			HttpSession session = request.getSession(); // 서버의 힙영역 접근
			// session에는 사용자 패스워드는 절대 넣지 않는다!
			session.setAttribute("sessionUser", userEntity);
			// 모든 응답에는 jSessionId가 쿠키로 추가된다.
			// 한글 처리를 위해 resp객체를 건드린다.
			// MIME 타입
			// HTTP HEADER에 CONTENT-TYPE을 건드린다.
			Script.href(response, "index.jsp", "로그인 성공");
		} else {
			Script.back(response, "뒤로");
		}
	}

	public void 유저정보보기(HttpServletRequest request, HttpServletResponse response) {
		// 유저 정보 보기 - 유저의 모든 정보
		// 인증이 필요한 페이지
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("sessionUser");
		UsersDao usersDao = new UsersDao();

		if (user != null) {
			Users userEntity = usersDao.selectById(user.getId());
			// 유저 ENTITY를 화면view에 뿌려야함
			// request에 담아야함
			request.setAttribute("user", userEntity);
			RequestDispatcher dis = request.getRequestDispatcher("user/selectOne.jsp");

			try {
				dis.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void 유저정보수정페이지(HttpServletRequest request, HttpServletResponse response) {
		// 유저 정보 보기 - 유저의 모든 정보
		// 인증이 필요한 페이지
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("sessionUser");
		UsersDao usersDao = new UsersDao();

		if (user != null) {
			Users userEntity = usersDao.selectById(user.getId());
			// 유저 ENTITY를 화면view에 뿌려야함
			// request에 담아야함
			request.setAttribute("user", userEntity);
			RequestDispatcher dis = request.getRequestDispatcher("user/updateOne.jsp");
			try {
				dis.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void 유저정보수정완료(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("id"));

		Users user = Users.builder().id(id).password(password).email(email).build();

		UsersDao usersDao = new UsersDao();

		int result = usersDao.update(user);
		System.out.println(user.getId());

		if (result == 1) {
			response.sendRedirect("user?gubun=selectOne");
		} else {
			response.sendRedirect("user?gubun=updateOne");
		}
	}

	public void 유저정보삭제(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Users user = Users.builder().id(id).build();
		UsersDao usersDao = new UsersDao();

		int result = usersDao.delete(id);
		// 4번 index.jsp페이지로 이동

		if (result == 1) {
			HttpSession session = request.getSession();
			session.invalidate();		//세션 무효화
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("user?gubun=selectOne");
		}
	}

}
