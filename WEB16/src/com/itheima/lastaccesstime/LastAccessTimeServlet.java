package com.itheima.lastaccesstime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LastAccessTimeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		//获得当前时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);
		//1.创建一个cookie，记录当前最新的访问时间
		Cookie cookie = new Cookie("lastAccessTime", currentTime);
		cookie.setMaxAge(60 * 10 * 500);
		response.addCookie(cookie);
		
		
		//2.获得客户端携带的cookie
		String lastAccessTime = null;
		Cookie[] cookies = request.getCookies();
		if (cookies!=null) {
			for (Cookie coo : cookies) {
				String cookieName = coo.getName();
				if (cookieName.equals("lastAccessTime")) {
					lastAccessTime = coo.getValue();
				}
			}
		}
		if (lastAccessTime == null) {
			response.getWriter().write("欢迎你，你是第一次访问");
		} else {
			response.getWriter().write("欢迎你，上次访问时间是:" + lastAccessTime);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
