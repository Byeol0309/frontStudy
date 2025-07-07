package core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet") //http:// 192.168.111.101:80/FirstServlet 주소가 생긴다
public class FirstServlet extends HttpServlet { // 부모가 서블릿Servlet extends HttpServlet(톰켓)
	//필드
	private static final long serialVersionUID = 1L; //직렬화(외부데이터와 클래스 객체용
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//생성자
    public FirstServlet() { 
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //프론트에서 get메서드로 요청시 처리되는 메서드 (기본값)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//						요청에대한 통로					응답에대한 통로					예외처리
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//응답에 대한 처리 부분		크롬dom에 작성되는부분 					경로를 출력
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//프론트에서 post로 요청시 처리되는 메서드 (보안적인 요소가 강함)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//							요청에 대한 통로		응답에 대한 통로				예외처리
		doGet(request, response);
		// post메서드로 요청이 오면 같은 클래스에있는 get메서드를 호출하여 처리
	}

}
