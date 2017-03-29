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
}
