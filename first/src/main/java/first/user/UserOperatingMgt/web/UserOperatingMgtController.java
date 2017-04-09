package first.user.UserOperatingMgt.web;

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
import first.common.util.JwtService;
import first.common.util.service.KctcMsgUtilService;
import first.user.UserOperatingMgt.service.IUserOperatingMgtService;;

@Controller
public class UserOperatingMgtController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="iUserOperatingMgtService")
	private IUserOperatingMgtService iUserOperatingMgtService;
	
	@Resource(name="jwtService")
	private JwtService jwtService;
	
	
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
	  * Description : 로그인 기능  
	  * @author  박종국 
	  * @since   2017.03.29
	  * @param  commandMap
	  * @return  ModelAndView
	*/
	@RequestMapping("/user/userLoginRequest.do")
	public ModelAndView userLoginRequest(CommandMap commandMap
									 , HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		String token="";
		try {
			
			String userId = (String) commandMap.get("userId");
			String userPw = (String) commandMap.get("userPw");
			List<Map<String,Object>> list = iUserOperatingMgtService.searchLoginInfo(userId);
			
			int chkListSize = list.size();
			String chkUserId = (String)list.get(0).get("userId");
			String chkUserPw = (String)list.get(0).get("userPw");
			
			log.debug("chkListSize>>>"+chkListSize);
			log.debug("userId>>>"+userId);
			log.debug("userPw>>>"+userPw);
			
			log.debug("chkUserId>>>"+chkUserId);
			log.debug("chkUserPw>>>"+chkUserPw);
			
			if(chkListSize > 0){		//사용자 존재 
				if(userPw.equals(chkUserPw)){
					token = jwtService.getToken(userId);
					log.debug("token>>>>"+token);
					if(token.length() > 0){
						mav = KctcMsgUtilService.getSuccMsg("SCMR001", mav);
						mav.addObject("token", token);
					}else{
						mav = KctcMsgUtilService.getErrMsg("ECMR001", mav);
						mav.addObject("token", "fail");
					}
				}else{//userPw==chkUserPw 끝 
					mav = KctcMsgUtilService.getErrMsg("ITSE002", mav);
					mav.addObject("token", "fail");
				} 
			}else{
				mav = KctcMsgUtilService.getErrMsg("ITSE001", mav);
				mav.addObject("token", "fail");
			}
		}catch (JWTVerificationException exception){
			log.debug("JWTVerificationException>>>"+exception);
			mav.addObject("token", exception);
		}catch(DataAccessException de){
			mav = new ModelAndView("jsonView");
		}catch ( Exception e ){
			log.debug(">>>> JK E: "+e.getMessage());
			mav = new ModelAndView("jsonView");
		}
		return mav;
	}
}
