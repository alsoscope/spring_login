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
	
	//��Ʈ�ѷ��� �޼��� ó���� ���� return �ǰ� ȭ���� ����ִ� ó��(view)�� �Ǳ� ������ �� �޼��尡 ����ȴ�
	//ModelAndView ��ü�� ��Ʈ�ѷ����� ������ �� Model ��ü�� ���޵����� ��Ʈ�ѷ����� �۾� �� postHandle()���� �۾��� ���� �ִٸ� ModelAndView �̿�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("postHandle.................");
		
		HttpSession session = request.getSession();
		ModelMap modelMap=modelAndView.getModelMap();
		Object MemberVO = modelMap.get("MemberVO");
		
		//���� �α����ϴ� ������� ������ ��ġ�Ѵٸ�, �ش� ����� ������ DB���� ������ ���ǿ� ����
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
			response.sendRedirect("/");
		}
	}
	
	//Controller�� ��û�� ���� �� �����
	//preHandle() �޼ҵ带 �����ϰ� ����� ��Ʈ�ѷ� �޼��忡 ���� ������ ��� �ִ� �Ű����� handler
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle--------------");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login")!=null) { //���� �α��� ��û�� ���� �� ������ ���ǿ� ����Ǿ� �ִ� ������ session LOGIN ����� ���� ����
			logger.info("clear login data before");
			session.removeAttribute("login");
		}		
		return true;
	}
}
