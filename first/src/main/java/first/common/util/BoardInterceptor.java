package first.common.util;

import java.util.Map;

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

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import first.common.util.service.BoardStringUtil;

public class BoardInterceptor extends HandlerInterceptorAdapter implements HttpSessionListener{
	protected Log log = LogFactory.getLog(BoardInterceptor.class);
	private HttpSession session;
	@Resource(name = "jwtService")
	private JwtService jwtService;
	
	@Override
	public boolean preHandle(HttpServletRequest request
							, HttpServletResponse response
							, Object handler) throws Exception {
		boolean isRequest = false;
		if (log.isDebugEnabled()) {
			log.debug("BoardInterceptor>>>>preHandler");
			log.debug("BoardInterceptor>>>>Request URI \t:  " + request.getRequestURI());
			log.debug("BoardInterceptor>>>>Request getSession \t:  " + request.getSession());
			log.debug("");
			String chkRequestUri = request.getRequestURI();
			
			if(chkRequestUri.equals("/user/searchUserInfo.do")||
			    chkRequestUri.equals("/user/userLoginRequest.do")||											
			    chkRequestUri.equals("/politics/insertBoard.do")||		
			    chkRequestUri.equals("/politics/insertBoardReply.do")||
			    chkRequestUri.equals("/politics/deletePoliticsBoard.do")
																		){
				String headerToken = request.getHeader("token");
				log.debug("String headerToken>>>>>"+headerToken);
				
				
				//토큰검증 
				String chkVeriToken = BoardStringUtil.isNullToString(jwtService.verifyToken(headerToken));
				DecodedJWT jwt = JWT.decode(chkVeriToken);
				String chkId = jwt.getId();
				Map<String, Claim> chkClaims = jwt.getClaims();
				String chkSubject = jwt.getSubject();
				String chkIssuer = jwt.getIssuer();
				String chkGetToken = jwt.getToken();
				
				log.debug("chkClaims>>>"+chkClaims);
				log.debug("chkSubject>>>"+chkSubject);
				log.debug("chkIssuer>>>"+chkIssuer);
				log.debug("chkGetToken>>>"+chkGetToken);
				
				log.debug("chkId>>>>"+chkId);
				if(chkVeriToken.equals("VerifiedToken")){//토큰 검증 ok
					log.debug("VerifiedToken ok");
					request.setAttribute("testVauleOk", "testVaule");
					isRequest = true;
				}else{
					log.debug("VerifiedToken nono");
					request.setAttribute("testVauleNo", "testVaule");
					response.sendRedirect("/user/userLoginForm.do");
					isRequest = false;
					
				}
			}else{
				isRequest = true;
			}
			
		}//log.isdebug end
		return isRequest;
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