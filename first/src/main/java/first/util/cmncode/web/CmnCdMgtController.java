package first.util.cmncode.web;

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
import first.util.cmncode.service.ICmnCdMgtService;
import first.common.util.service.KctcMsgUtilService;

@Controller
public class CmnCdMgtController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="iCmnCdMgtService")
	private ICmnCdMgtService iCmnCdMgtService;
	
	/**
	  * Description : 공통코드를 불러온다.
	  * @author 
	  * @since 
	  * @param 
	  * @return 
	*/
	@RequestMapping("/util/searchCmnCd.do")
	public ModelAndView searchCmnCd(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			List<Map<String,Object>> list = iCmnCdMgtService.searchCmnCd(commandMap.getMap());
			mav.addObject("cmnCdList", list);
			mav = KctcMsgUtilService.getSuccMsg("SCMR006", mav);
		}catch(DataAccessException de){
			log.debug(">>>> DataAccessException E: "+de.getMessage());
			mav = new ModelAndView("jsonView");
		}catch ( Exception e ){
			log.debug(">>>> Exception E: "+e.getMessage());
			mav = new ModelAndView("jsonView");
		}
		return mav;
	}
}
