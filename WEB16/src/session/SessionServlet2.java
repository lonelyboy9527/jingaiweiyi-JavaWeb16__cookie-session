package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从session中获得存储的数据
		//注意，在一次会话中，session创建了一个，除非JSESSIONID改变，导致找不到服务器端的session区域
		HttpSession session = request.getSession();
		String attribute = (String)session.getAttribute("name");
		if (attribute!=null) {
			response.getWriter().write(attribute);
		} else {
			response.getWriter().write("没有找到该session中的name对应值");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
