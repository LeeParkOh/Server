package first.user.UserOperatingMgt.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import first.common.common.CommandMap;
import first.common.util.service.KctcMsgUtilService;
import first.user.UserOperatingMgt.service.IUserOperatingMgtService;;

@Controller
public class UserOperatingMgtController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="iUserOperatingMgtService")
	private IUserOperatingMgtService iUserOperatingMgtService;
	
	/**
	  * Description : 사용자 정보 조회 
	  * @author  박종국 
	  * @since   2017.03.29
	  * @param  commandMap
	  * @return  ModelAndView
	*/
	@RequestMapping("/user/searchUserInfo.do")
	public ModelAndView searchUserInfo(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			List<Map<String,Object>> list = iUserOperatingMgtService.searchUserInfo(commandMap.getMap());
			mav.addObject("list", list);
		}catch(DataAccessException de){
			mav = new ModelAndView("jsonView");
		}catch ( Exception e ){
			log.debug(">>>> JK E: "+e.getMessage());
			mav = new ModelAndView("jsonView");
		}
		return mav;
	}

	/**
	  * Description : 사용자 신규 등록 
	  * @author  박종국 
	  * @since   2017.03.29
	  * @param  commandMap
	  * @return  ModelAndView
	*/
	@RequestMapping(value="/user/saveUserInfo.do")
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
	try{
		iUserOperatingMgtService.saveUserInfo(commandMap.getMap(), request);
		mav = KctcMsgUtilService.getSuccMsg("SCMC001", mav);
	}catch(DataAccessException de){
		mav = new ModelAndView("jsonView");
		mav = KctcMsgUtilService.getErrMsg("ECMC001", mav);
	}catch ( Exception e ){
		mav = new ModelAndView("jsonView");
		mav = KctcMsgUtilService.getErrMsg("ECMC001", mav);
	}
		return mav;
	}
	
	
	/**
	  * Description : 사용자 신규 등록 
	  * @author  박종국 
	  * @since   2017.03.29
	  * @param  commandMap
	  * @return  ModelAndView
	*/
	@RequestMapping(value="/user/updateUserInfo.do")
	public ModelAndView updateUserInfo(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
	try{
		iUserOperatingMgtService.updateUserInfo(commandMap.getMap());
		mav = KctcMsgUtilService.getSuccMsg("SCMC001", mav);
	}catch(DataAccessException de){
		mav = new ModelAndView("jsonView");
		mav = KctcMsgUtilService.getErrMsg("ECMC001", mav);
	}catch ( Exception e ){
		mav = new ModelAndView("jsonView");
		mav = KctcMsgUtilService.getErrMsg("ECMC001", mav);
	}
		return mav;
	}
	
	
	/**
	  * Description : 사용자 정보 조회 
	  * @author  박종국 
	  * @since   2017.03.29
	  * @param  commandMap
	  * @return  ModelAndView
	*/
	@RequestMapping("/user/userLoginRequest.do")
	public ModelAndView userLoginRequest(CommandMap commandMap
									 , HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			  
			Algorithm algorithm = Algorithm.HMAC256("secret");
			Map<String, Object> headerClaims2 = new HashMap();
			headerClaims2.put("owner", "JK");
			    String token = JWT.create()
						        .withIssuer("LeeParkOh")
						        .withHeader(headerClaims2)
						        .sign(algorithm);
			    
			 log.debug("algorithm>>>>>"+ algorithm);  
			 log.debug("token>>>>>"+ token); 
			 
			 ///////////////////////////////
			 Algorithm algorithm2 = Algorithm.HMAC256("secret");
			    JWTVerifier verifier = JWT.require(algorithm2)
								        .withIssuer("LeeParkOh")
								        .build(); //Reusable verifier instance
			 DecodedJWT jwt = verifier.verify(token);
			 log.debug("algorithm2>>>"+algorithm2);
			 log.debug("jwt>>>"+jwt);
			 
			 ////////////////////////////
			DecodedJWT jwt3 = JWT.decode(token);
			 
			log.debug("jwt3>>>"+jwt3);
			////////////////////////////////////////
			
			Map<String, Object> headerClaims = new HashMap();
			headerClaims.put("owner", "auth0");
			String token5 = JWT.create()
			        .withHeader(headerClaims)
			        .sign(algorithm);
			
			DecodedJWT jwt8 = JWT.decode(token5);
			
			log.debug("token5>>>"+token5);
			log.debug("jwt8>>>"+jwt8);
			
		}catch (UnsupportedEncodingException exception){
			log.debug("UnsupportedEncodingException>>>"+exception);
		} catch (JWTVerificationException exception){
			log.debug("JWTVerificationException>>>"+exception);
		}catch(DataAccessException de){
			mav = new ModelAndView("jsonView");
		}catch ( Exception e ){
			log.debug(">>>> JK E: "+e.getMessage());
			mav = new ModelAndView("jsonView");
		}
		return mav;
	}
	
	
}
