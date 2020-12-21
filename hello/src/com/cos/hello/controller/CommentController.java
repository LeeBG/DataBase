package com.cos.hello.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/comment")	//XML의 필터를 만드는 마법의 문장 '/comment'의 주소값이 들어오면
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentController() {
	}

	/*
	 * http 1.0 프로토콜 = SELECT(get),DELETE,UPDATE,INSERT(POST)
	 *
	 * http 1.1 프로토콜 = SELECT(get),DELETE(delete),UPDATE(put),INSERT(POST)
	 */
	// get요청은 브라우저에 주소적고 엔터!! = select하겠다는 것(http1.0기준)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Comment get요청");
		doProcess(request, response);
	}

	// POST요청은 무조건 FORM태그를 만들어서 값넣고 버튼 클릭 = insert delete update (http1.0기준)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 어 ? 포스트 요청왔네, 그럼 내가 디비 연결 인서트 하면 되겠네
		System.out.println("Comment POST요청");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Comment Process요청");
	}

}
