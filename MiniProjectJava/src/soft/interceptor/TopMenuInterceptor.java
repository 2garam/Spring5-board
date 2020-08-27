package soft.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import soft.beans.BoardInfoBean;
import soft.beans.UserBean;
import soft.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{
	
	//XML프로젝트는 빈을 주입 받을 수 있기때문에 사용하지만 , Java프로젝트는 바로 주입이 안되기 때문에 생성자를 통해서 주입 받아야 한다.
	private TopMenuService topMenuService;
	private UserBean loginUserBean;
	
	public TopMenuInterceptor(TopMenuService topMenuService, UserBean loginUserBean) {
		this.topMenuService = topMenuService;
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean);
		
		return true;
	}
}
