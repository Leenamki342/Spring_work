package com.gura.spring01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* component scan 될때 PersonController 객체가 생성이 되고 관리가 된다. */
@Controller
public class PersonController {
	
		@RequestMapping("/person.do")
		public String person(HttpServletRequest request) { // 리턴 type 은 String, 메소드명은 마음대로 지울 수 있다.
			// view page 에 전달할 data (Model)
			String personToday="오늘의 인물은 덩어리입니다.";
			// request scope 에 담는다.
			request.setAttribute("personToday", personToday);
			
			/*
			 *  3. forward 이동할 jsp 페이지의 위치를 문자열로 리턴해준다.
			 *  
			 *  리턴된 문자열의 접두어(prefix) 는 "WEB-INF/views/" 가 되고
			 *  리턴된 문자열의 접미어(suffix) 는 ".jsp" 가 된다.
			 *  따라서 "fortune" 을 리턴하면
			 *  "WEB-INF/views/"+"fortune"+".jsp" 문자열이 만들어져서
			 *  결과는 
			 *  "/WEB-INF/views/fortune.jsp" 가 jsp 페이지의 위치가 된다.
			 *  
			 *  그럼으로 해당 위치를 찾아서 jsp 파일을 만들어
			 */
			
			// forward 이동할 view page 의 위치를 리턴해준다.
			return "person"; // /WEB-INF/view/person.jsp
		}
}
