package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control {

	@RequestMapping("/h1")
	public String result1(HttpServletRequest req, HttpServletResponse resp) {
		return "forward:/static/hh1.html";
	}

	@RequestMapping("/h2")
	public String result2(HttpServletRequest req, HttpServletResponse resp) {
		return "redirect:/static/hh1.html";
	}

	@RequestMapping(value = "{q}")
	public String result3(@PathVariable("q") String s) {
		return "redirect:/static/hh1.html";
	}

}
