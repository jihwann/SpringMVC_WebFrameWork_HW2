package kr.ac.hansung.controller;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // @Component --> HomeController 라는 클래스를 bean으로 등록
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Locale locale, Model model) { // controller에서 수행되는 method
		
		return "home"; // 이 메소드가 수행되면 home.jsp로 넘김
	}
	
}
