package soft.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import soft.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
	
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		if(loginUserBean.isUserLogin() == false ) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_login");
			
			return false; //인터셉터에서 리턴값을 false로 주면 다음 단계인 controller로 넘어가지 않는다.
		}
		
		return true;
	}
}
