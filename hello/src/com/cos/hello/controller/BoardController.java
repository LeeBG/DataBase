package com.cos.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardController 실행됨");
		doProcess(request, response);
		String gubun = request.getParameter("gubun"); //
		System.out.println(gubun);

		if (gubun.equals("deleteOne")) {
			response.sendRedirect("board/deleteOne.jsp"); // request를 하면 한번 더 req를 한다.
		} else if (gubun.equals("insertOne")) {
			response.sendRedirect("board/insertOne.jsp"); // request를 하면 한번 더 req를 한다.
		} else if (gubun.equals("selectAll")) {
			response.sendRedirect("board/selectAll.jsp");
		} else if (gubun.equals("updateOne")) {
			response.sendRedirect("board/updateOne.jsp");
		}
		
	}

	// POST요청은 무조건 FORM태그를 만들어서 값넣고 버튼 클릭 = insert delete update (http1.0기준)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 어 ? 포스트 요청왔네, 그럼 내가 디비 연결 인서트 하면 되겠네
		System.out.println("Board POST요청");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Board Process요청");
	}
}
