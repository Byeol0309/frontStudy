package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/Hello") //http://192.168.111.101:80/Hello   ->대소문자 주의, class명과  달라도 됨
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=utf-8"); //html타입에 유니코드
		PrintWriter out = response.getWriter();
		out.println("<h3>안녕하세요? </h3>");
		out.println("<h3>서블릿 지옥에 오신걸 환영합니다? </h3>");
		out.println("<h3>태그를 이렇게 넣어야 한다고요? </h3>");
		out.println("<h3>만나서 반가웠습니다 수고하세요 </h3>");
		out.close();
	}

}
