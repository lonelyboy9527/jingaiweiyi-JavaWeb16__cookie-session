package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendCookieServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.创建cookie对象
		Cookie cookie = new Cookie("name", "zhangsan");
		
		//1.1为cookie设置持久化时间----cookie在硬盘上保存的时间
		cookie.setMaxAge(10 * 60); //10分钟 ------设置设置为0代表删除该cookie
		
		//1.2为cookie设置携带的路径
		//cookie.setPath("/WEB16/sendCookie"); //设置当访问SendCookie资源时，携带cookie进行传输
		cookie.setPath("/WEB16"); //当访问WEB16下任何资源时候，都携带cookie
		//cookie.setPath("/"); //访问服务器下的所有的资源都携带cookie
		//如果不设置setPath，默认在访问设置该cookie资源下的 所在的路径下所有WEB资源都携带cookie
		
		//2.将cookie中存储的信息发送到客户端
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
