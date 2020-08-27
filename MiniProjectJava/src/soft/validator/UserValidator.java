package soft.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import soft.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserBean userBean = (UserBean)target;
		
		String beanName = errors.getObjectName(); // 주입받은 빈의 이름가지고 분기 시키기 위함

		if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) { // 객체 이름이 조인유저빈일때만 접근
			if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false ) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}
			
			if(beanName.equals("joinUserBean")) {
				if(userBean.isUserIdExist() == false) {
					errors.rejectValue("user_id", "DontCheckUserIdExist");
				}
			}
		}
	}
	

}
