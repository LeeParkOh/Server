package first.common.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import first.common.common.CommandMap;

public class BoardInterceptor extends HandlerInterceptorAdapter implements HttpSessionListener{
	protected Log log = LogFactory.getLog(BoardInterceptor.class);
	private HttpSession session;
	@Resource(name = "jwtService")
	private JwtService jwtService;
	
	@Override
	public boolean preHandle(HttpServletRequest request
							, HttpServletResponse response
							, Object handler) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("BoardInterceptor>>>>preHandler");
			log.debug("BoardInterceptor>>>>Request URI \t:  " + request.getRequestURI());
			log.debug("BoardInterceptor>>>>Request getSession \t:  " + request.getSession());
			log.debug("");
			boolean isSession = false;
			session = request.getSession();
			CommandMap commandMap = new CommandMap();
			CommandMap commandMap2 = new CommandMap();
			CommandMap commandMap3 = new CommandMap();
			CommandMap commandMap4 = new CommandMap();
			CommandMap commandMap5 = new CommandMap();
			CommandMap commandMap6 = new CommandMap();
			commandMap = (CommandMap) session.getAttribute("json");
			commandMap2 = (CommandMap) session.getAttribute("jsonView");
			commandMap3 = (CommandMap) session.getAttribute("service");
			commandMap4 = (CommandMap) session.getAttribute("call");
			commandMap5 = (CommandMap) session.getAttribute("retrofit");
			commandMap6 = (CommandMap) session.getAttribute("boardCd");
			log.debug("commandMap>>>>"+commandMap);
			log.debug("commandMap2>>>>"+commandMap2);
			log.debug("commandMap3>>>>"+commandMap3);
			log.debug("commandMap4>>>>"+commandMap4);
			log.debug("commandMap5>>>>"+commandMap5);
			log.debug("commandMap6>>>>"+commandMap6);
			
			log.debug("getAttributeNames>>"+session.getAttributeNames());
			log.debug("getId>>"+session.getId());
			
		}
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("BoardInterceptor>>>>postHandleHandler\n");
		}
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}
}