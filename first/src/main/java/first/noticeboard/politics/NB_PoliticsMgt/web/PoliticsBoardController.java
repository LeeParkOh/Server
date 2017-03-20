package first.noticeboard.politics.NB_PoliticsMgt.web;

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
import first.noticeboard.politics.NB_PoliticsMgt.service.IPoliticsBoardService;
import first.common.util.service.KctcMsgUtilService;

@Controller
public class PoliticsBoardController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="iPoliticsBoardService")
	private IPoliticsBoardService iPoliticsBoardService;
	
	/**
	  * Description :
	  * @author 
	  * @since 
	  * @param 
	  * @return 
	*/
	@RequestMapping("/politics/searchUserInfo.do")
	public ModelAndView searchUserInfo(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			List<Map<String,Object>> list = iPoliticsBoardService.searchUserInfo(commandMap.getMap());
			mav.addObject("list", list);
		}catch(DataAccessException de){
			mav = new ModelAndView("jsonView");
		}catch ( Exception e ){
			log.debug(">>>> KKONG E: "+e.getMessage());
			mav = new ModelAndView("jsonView");
		}
		return mav;
	}

	@RequestMapping(value="/politics/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
	try{
		iPoliticsBoardService.insertBoard(commandMap.getMap(), request);
	}catch(DataAccessException de){
		log.debug(">>>> KKONG E1: "+de.getMessage());
		mav = new ModelAndView("jsonView");
	}catch ( Exception e ){
		log.debug(">>>> KKONG E2: "+e.getMessage());
		mav = new ModelAndView("jsonView");
	}
		return mav;
	}
}
