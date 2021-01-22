package com.gura.spring03;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
		
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		// DB에서 불러온 공지사항 목록이라고 가정하자
		List<String> noticeList=new ArrayList<String>();
		noticeList.add("불금이네요");
		noticeList.add("자자...");
		noticeList.add("빨래...");
		noticeList.add("여친 헤헤");
		// Model(데이터)를 request scope 에 담는다.
		request.setAttribute("noticeList", noticeList);
		// view page 로 forward 이동해서 응답하기
		
		return "home";
	}
	
}
