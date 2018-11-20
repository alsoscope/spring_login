package org.p.Interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
			System.out.println("postHandle.................");
			
			//result라는 변수가 저장되었다면 HttpSession 객체에 이를 보관
			Object result=modelAndView.getModel().get("result");
			
			if(result!=null) {
				request.getSession().setAttribute("result", result);
				response.sendRedirect("/doA");
			}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle--------------");
		
		HandlerMethod method=(HandlerMethod) handler;
		Method methodObj=method.getMethod();
		
		System.out.println("Bean : " + method.getBean());
		System.out.println("Method : " + methodObj);
		
		//리턴 타입 boolean으로 설계. 이를 이용해서 다음 interceptor나 대상 컨트롤러를 호출하도록 할 것인지를 결정
		return true;
	}

}
