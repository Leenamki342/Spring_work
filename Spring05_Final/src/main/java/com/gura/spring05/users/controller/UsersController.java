package com.gura.spring05.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dto.UsersDto;
import com.gura.spring05.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	// 비밀번호 수정 요청처리
	@RequestMapping("/users/private/pwd_update")
	public ModelAndView pwd_update(ModelAndView mView,
			UsersDto dto, HttpSession session) {
		// UsersDto 에는 폼전송된 아이디, 구 비밀번호, 새 비밀번호가 담겨있다.
		service.updateUserPwd(mView, dto, session);
		mView.setViewName("users/private/pwd_update");
		return mView;
	}
	
	// 비밀번호 수정 폼 요청 처리
	@RequestMapping("users/private/pwd_updateform")
	public String pwd_updateform() {
		return "users/private/pwd_updateform";
	}
	
	// 회원 탈퇴 요청처리
	@RequestMapping("users/private/delete")
	public String delete(HttpSession session) {
		service.deleteUser(session);
		return "users/private/delete";
	}
	
	// 개인정보 보기 요청처리
	@RequestMapping("/users/private/info")
	public ModelAndView info(ModelAndView mView, HttpSession session) {
		service.getInfo(mView, session);
		mView.setViewName("users/private/info");
		return mView;
		
	}
	
	// 로그아웃 요청 처리
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		// session.invalidate(); // 세션 초기화
		session.removeAttribute("id"); // 세션에서 id 삭제
		
		return "users/logout";
	}
	
	// 로그인 요청 처리
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			HttpServletResponse response) {
		// 로그인에 관련된 로직을 서비스를 통해 처리한다.
		service.loginLogic(request, response);
		// view page 로 forward 이동해서 응답
		return "users/login";
	}
	
	// 로그인 폼 요청 처리
	@RequestMapping("/users/loginform")
	public ModelAndView loginform(HttpServletRequest request,
			ModelAndView mView) {
		// 로그인 폼에 관련된 로직을 서비스를 통해 처리한다.
		service.loginformLogic(request, mView);
		// view page 정보도 담는다.
		mView.setViewName("users/loginform");
		// 리턴
		return mView;
	}
	
	
	/*
	 * 	String id = request.getParameter("id");
	    String pwd = request.getParameter("pwd");
	    String email = request.getParameter("email");
	    UsersDto dto = new UsersDto();
	    dto.setId(id);
	    dto.setPwd(pwd);
	    dto.setEmail(email);
	    
	    위의 작업을 @ModelAttribute UsersDto dto 이렇게 간소화 시킨다.
	    
    */
	
	// 회원 가입 요청처리
	// form 전송은 보통 post 방식 요청인데 post 방식 요청만 받아들이도록
	// 컨트롤러에 설정하는게 일반적이다.
	@RequestMapping(value = "/users/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("dto") UsersDto dto) {
		/*
		 *  Dto 인 경우에 @ModelAttribute("key 값")으로 설정하면
		 *  해당 Dto 가 request 영역에 설정한 "key 값" 으로 담긴다.
		 */
		service.addUser(dto);
		return "users/signup";
	}
	
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		return "users/signup_form";
	}
	
	// ajax 요청 처리
	@RequestMapping("/users/checkid")
	public ModelAndView checkid(@RequestParam String inputId, 
			ModelAndView mView) {
		/*
		 *  (@RequestParam String inputId) 는
		 *  String inputId=request.getParameter("inputId")
		 *  와 같다.
		 */
		// 서비스를 이용해서 해당 아이디가 존재하는지 여부를 알아낸다.
		boolean isExist=service.isExistId(inputId);
		// ModelAndView 객체에 해당 정보를 담고 view page 로 forward 이동해서 응답
		mView.addObject("isExist", isExist);
		mView.setViewName("users/checkid");
		return mView;
	}
}
