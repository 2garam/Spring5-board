package soft.controller;

import javax.servlet.http.HttpServletRequest;

//import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import soft.beans.UserBean;

@Controller
public class HomeController {
	
//	@Resource(name = "loginUserBean") // 이름으로 주입 받을 때
//	private UserBean loginUserBean;
//	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
//		System.out.println(loginUserBean);
		
		System.out.println(request.getServletContext().getRealPath("/"));
		
		return "redirect:/main";
	}
	
	
}
