package core;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FlowServlet
 */
@WebServlet("/FlowServlet") // url생성
public class FlowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// was(톰켓 시작시 초기화 코드)
		System.out.println("init()메서드 호출"); //브라우저가 아닌 콘솔에 출력
		System.out.println("실무에서는 ojdbc1단계, 2단계용");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// was(톰켓 종료 전에 실행코드)
		System.out.println("destory() 메서드 호출");
		System.out.println("실무에서는 ojdbc 5단계용");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 요청시 처리
		System.out.println("service() 메서드 호출");
		System.out.println("실무에서는 3,4단계용");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
