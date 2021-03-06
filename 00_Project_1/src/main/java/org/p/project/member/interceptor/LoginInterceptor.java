package org.p.project.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	//private static final String LOGIN="login";
	private static final Logger logger=LoggerFactory.getLogger(LoginInterceptor.class);
	
	//컨트롤러의 메서드 처리가 끝나 return 되고 화면을 띄워주는 처리(view)가 되기 직전에 이 메서드가 수행된다
	//ModelAndView 객체에 컨트롤러에서 전달해 온 Model 객체가 전달됨으로 컨트롤러에서 작업 후 postHandle()에서 작업할 것이 있다면 ModelAndView 이용
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("postHandle.................");
		
		HttpSession session = request.getSession();
		ModelMap modelMap=modelAndView.getModelMap();
		Object MemberVO = modelMap.get("MemberVO");
		
		//새로 로그인하는 사용자의 정보가 일치한다면, 해당 사용자 정보를 DB에서 가져와 세션에 저장
		if(MemberVO != null) {
			logger.info("new login success");
			session.setAttribute("login", MemberVO);
			
/*			if (request.getParameter("useCookie") != null) {
				logger.info("use cookie........");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(loginCookie);
			}
			
			String dest = (String) session.getAttribute("dest");
*/			
			/*response.sendRedirect(dest != null ? dest : "/");*/
			/*response.sendRedirect("/");*/
			response.sendRedirect("/member/list.do");
		}
	}
	
	//Controller로 요청이 들어가기 전 수행됨
	//preHandle() 메소드를 수행하고 수행될 컨트롤러 메서드에 대한 정보를 담고 있는 매개변수 handler
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle--------------");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login")!=null) { //새로 로그인 요청이 들어올 때 기존에 세션에 저장되어 있던 이전의 session LOGIN 사용자 정보 제거
			logger.info("clear login data before");
			session.removeAttribute("login");
		}		
		return true;
	}
}
