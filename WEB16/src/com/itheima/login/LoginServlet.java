package com.itheima.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//验证码的校验
		//1.获得页面输入的验证码
		//2.获得生成图片的验证码和页面的比对是否一致
		String checkCode = request.getParameter("checkCode");
		
		HttpSession session = request.getSession();
		String checkcode_session = (String)session.getAttribute("checkcode_session");
		if (checkcode_session != null) {
			if (!checkcode_session.equals(checkCode)) {
				request.setAttribute("loginInfo", "您的验证码不正确");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
				requestDispatcher.forward(request, response);
				return;
			} else {
				
			}
		}
		
		
		//获得页面的用户名和密码进行数据库的校验
		//...
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
