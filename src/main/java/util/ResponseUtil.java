package util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	public static void response(HttpServletResponse resp, Object message) {		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		try {
			resp.getWriter().print(message);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
