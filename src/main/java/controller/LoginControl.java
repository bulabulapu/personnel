package controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Admin;
import service.AdminService;

@Controller
public class LoginControl {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/login")
	@ResponseBody
	public loginMessage<Admin> login(Admin admin, HttpServletResponse resp, HttpSession session) {
		loginMessage<Admin> message = new loginMessage<>(false,null);
		Admin temp = adminService.identifyAdmin(admin);
		if (temp != null) {
			message.setFlag(true);
			message.setUser(temp);
			temp.setAdminPWord("");
			session.setAttribute("admin", temp);
		}
		return message;

	}
}

class loginMessage<T> {
	private boolean flag;
	private T user;

	public loginMessage() {

	}

	public loginMessage(boolean flag, T user) {
		this.flag = flag;
		this.user = user;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public T getUser() {
		return user;
	}

	public void setUser(T user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "loginMessage [flag=" + flag + ", user=" + user + "]";
	}

}
