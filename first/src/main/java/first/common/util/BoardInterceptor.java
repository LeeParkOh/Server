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
		session = request.getSession();
		if (log.isDebugEnabled()) {
			log.debug("BoardInterceptor>>>>preHandler");
			log.debug("BoardInterceptor>>>>Request URI \t:   " + request.getRequestURI());
			log.debug("BoardInterceptor>>>>Request getSession \t:  " + request.getSession());
			log.debug("");
			String chkRequestUri = request.getRequestURI();
			
			if(chkRequestUri.equals("/user/searchUserInfo.do")||
			    //chkRequestUri.equals("/user/userLoginRequest.do")||											
			    chkRequestUri.equals("/politics/insertBoard.do")||		
			    chkRequestUri.equals("/politics/insertBoardReply.do")||
			    chkRequestUri.equals("/politics/deletePoliticsBoard.do")
																		){
				String headerToken = request.getHeader("token");
				
				headerToken = BoardStringUtil.isNullToString(headerToken);
				log.debug("String headerToken>>>>>"+headerToken);
				if(!(headerToken == null)&&!(headerToken.equals(""))){
					//토큰검증 
					String chkVeriToken = BoardStringUtil.isNullToString(jwtService.verifyToken(headerToken));
					DecodedJWT jwt = JWT.decode(headerToken);
					
					String chkId = jwt.getId();
					Map<String, Claim> chkClaims = jwt.getClaims();
					String chkSubject = jwt.getSubject();
					String chkIssuer = jwt.getIssuer();
					String chkGetToken = jwt.getToken();
					
					Claim claim = jwt.getClaim("userId");
					
					log.debug("claim>>userId>>>"+claim);
					log.debug("chkClaims>>>"+chkClaims);
					log.debug("chkSubject>>>"+chkSubject);
					log.debug("chkIssuer>>>"+chkIssuer);
					log.debug("chkGetToken>>>"+chkGetToken);
					log.debug("chkId>>>>"+chkId);
					
					
					if(chkVeriToken.equals("VerifiedToken")){//토큰 검증 ok
						log.debug("VerifiedToken ok");
						session.setAttribute("IsVerifiedToken", "Y");
						isRequest = true;
					}else{
						log.debug("VerifiedToken nono");
						session.setAttribute("IsVerifiedToken", "N");
						response.sendRedirect("/user/userLoginForm.do");
						isRequest = false;
						
					}
				}else{//토큰이 null이면  
					log.debug("VerifiedToken nono2");
					session.setAttribute("IsVerifiedToken", "N");  //앞: 변수명 뒤:value  
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