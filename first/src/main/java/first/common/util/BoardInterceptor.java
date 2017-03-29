package first.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import first.common.logger.LoggerInterceptor;

public class BoardInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(BoardInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("BoardInterceptor>>>>preHandler");
			log.debug("BoardInterceptor>>>>Request URI \t:  " + request.getRequestURI());
			log.debug("BoardInterceptor>>>>Request getSession \t:  " + request.getSession());
		}
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("BoardInterceptor>>>>postHandleHandler\n");
		}
	}
}