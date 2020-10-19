package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import model.Admin;


/*
 * 登录过滤器，未登录无法访问动态资源
 */
public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = true;

		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			response.sendRedirect(request.getContextPath()+"/static/html/login.html");
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

}
