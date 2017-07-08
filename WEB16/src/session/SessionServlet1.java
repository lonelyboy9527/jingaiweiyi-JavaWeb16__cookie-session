package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionServlet1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建属于该客户端（会话）的私有的session区域
		
		/* 1.session区域的生命开始：
		 * request.getSession()方法内部会判断 该客户端是否在服务器已经存在session
		 * 如果该客户端在此服务器不存在session，那么就会创建一个新的session对象
		 * 如果该客户端在此服务器已经存在session，获得已经存在该session引用返回
		 * 
		 * 2.session区域的死亡：
		 * （1）可以在tomcat的 conf中，设置这一次会话服务器session区域的过期时间
		 * 我们可在web.xml中设置
		 * 过期时间倒计时-----是从我们不操作服务端资源开始计时;
		 * （2）手动销毁
		 * 	session.invalidate();
		 * （3）服务器非正常关闭
		 * 
		 * 
		 * session的作用范围：
		 * 	默认在一次会话中，也就是说在，一次会话中任何资源共用一个session对象
		 * */
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("name", "jerry");
		
		String id = session.getId();
		
		//优化：手动的创建一个存储JSESSIONID的cookie（不使用默认的会话级别的cokkie）
		//为该cookie设置持久化时间
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setPath("/WEB16/");
		cookie.setMaxAge(60 * 10);
		response.addCookie(cookie);
		
		response.getWriter().write("JSESSIONID:" + id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
