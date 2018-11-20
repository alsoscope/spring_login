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
			
			//result라는 변수가 저장되었다면 HttpSession 객체에 이를 보관하는 예
			Object result=modelAndView.getModel().get("result");
			
			/*HomeController의 코드에서 /doB를 호출하면 result라는 이름으로 하나의 문자열이 보관됨
			postHandle()에서 result라는 변수가 ModelAndView에 존재하면 이를 추출해서 HttpSession에 추가*/
			if(result!=null) {
				request.getSession().setAttribute("result", result);
				response.sendRedirect("/doA");
			}
			/*HomeController에서 /doB를 먼저 호출해서 HttpSession에 result라는 이름을 보관한 후
			/doA로 redirect를 수행하면 controller의 home.jsp에 ${result} 모델이 출력됨
			
			브라우저에서 /doB를 호출하면 doA로 이동하는데, HttpSession에 result라는 이름으로 보관된 객체가
			있으므로 화면에는 result에 해당하는 문자열이 보여지게 된다
			
			/doB실행하면 HttpSession에 필요한 객체가 담기게 되고 /doA URI를 호출하면 home.jsp에서
			Model 객체에서 전달된 객체는 없지만 HttpSession 객체에 필요한 정보가 보관되었기 EL문법으로 문자열 보여짐*/
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle--------------");
		
		//handler는 HandlerMethod 타입으로 캐스팅한 후 원래의 메소드와 객체(빈) 확인
		HandlerMethod method=(HandlerMethod) handler;
		Method methodObj=method.getMethod();
		
		System.out.println("Bean : " + method.getBean());
		System.out.println("Method : " + methodObj);
		
		//리턴 타입 boolean으로 설계. 이를 이용해서 다음 interceptor나 대상 컨트롤러를 호출하도록 할 것인지를 결정
		return true;
	}

}
