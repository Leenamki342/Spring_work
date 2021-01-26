package com.gura.spring04.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
/*
 *  예외가 발생하면 직접 에러페이지를 응답하기 위해 예외 컨트롤러를
 *  정의해서 응답할 수 있다.
 *  예외 컨트롤러를 만들때는 @ControllerAdvice 어노테이션을 붙여서 만든다.
 */
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ExceptionController {
	/*
	 *  스프링 프레임워크가 동작하는 중에 DBFailException type 의 예외가
	 *  발생하면 호출되는 메소드
	 *  @ExceptionHandler(예외 클래스 type)
	 */
	@ExceptionHandler(DBFailException.class)
	public ModelAndView dbFail(DBFailException e) { // 발생한 예외 객체가 전달.
		// ModelAndView 객체를 생성
		ModelAndView mView=new ModelAndView();
		// exception 이라는 키값으로 예외 객체 담고
		mView.addObject("exception", e);
		// view page 로 forward 이동해서 에러 정보 응답
		mView.setViewName("error/db_fail");
		return mView;
	}
}
