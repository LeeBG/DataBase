package com.cos.hello.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharFilter implements Filter {

	//web.xml에서 필터 타입만 사용할수 있도록 설정
	//doFilter
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터 걸림!!!!");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//모든응답이 html 아니냐?? --> 내가 부분적으로setContentType을 걸어주면 됨(덮어쓰기) 
		chain.doFilter(request, response);
		
	}
	
}
