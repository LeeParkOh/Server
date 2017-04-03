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

import first.noticeboard.politics.NB_PoliticsMgt.service.vo.PoliticsBoardInfoVO;;

@Controller
public class PoliticsBoardController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="iPoliticsBoardService")
	private IPoliticsBoardService iPoliticsBoardService;
	
	/**
	  * Description : 사용자 정보 조회 
	  * @author  박종국 
	  * @since   2017.03.21
	  * @param  commandMap
	  * @return  ModelAndView
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
			log.debug(">>>> JK E: "+e.getMessage());
			mav = new ModelAndView("jsonView");
		}
		return mav;
	}

	/**
	  * Description : 게시판 글쓰기 기능 
	  * @author  박종국 
	  * @since   2017.03.21
	  * @param  commandMap
	  * @return  ModelAndView
	*/
	@RequestMapping(value="/politics/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
	try{
		iPoliticsBoardService.insertBoard(commandMap.getMap(), request);
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
	  * Description :  게시판 조회 
	  * @author  박종국 
	  * @since   2017.03.22
	  * @param  commandMap
	  * @return  ModelAndView
	*/
	@RequestMapping("/politics/searchPoliticsBoardInfo.do")
	public ModelAndView searchPoliticsBoardInfo(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			List<Map<String,Object>> list = iPoliticsBoardService.searchPoliticsBoardInfo(commandMap.getMap());
			mav.addObject("PoliticsList", list);
			mav = KctcMsgUtilService.getSuccMsg("SCMR001", mav);
		}catch(DataAccessException de){
			mav = new ModelAndView("jsonView");
			mav = KctcMsgUtilService.getErrMsg("ECMR001", mav);
		}catch ( Exception e ){
			log.debug(">>>> JK E: "+e.getMessage());
			mav = new ModelAndView("jsonView");
			mav = KctcMsgUtilService.getErrMsg("ECMR001", mav);
		}
		return mav;
	}
	
	/**
	  * Description : 게시판 댓글달기 
	  * @author  박종국 
	  * @since   2017.03.21
	  * @param  commandMap
	  * @return  ModelAndView
	*/
	@RequestMapping(value="/politics/insertBoardReply.do")
	public ModelAndView insertBoardReply(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
	try{
		iPoliticsBoardService.insertBoardReply(commandMap.getMap(), request);
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
	  * Description :  댓글 조회 
	  * @author  박종국 
	  * @since   2017.03.22
	  * @param  commandMap
	  * @return  ModelAndView
	*/
	@RequestMapping("/politics/searchPoliticsBoardReply.do")
	public ModelAndView searchPoliticsBoardReply(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			 iPoliticsBoardService.updatePoliticsBoardHitCnt(commandMap.getMap());
			List<Map<String,Object>> listMain = iPoliticsBoardService.searchPoliticsBoardInfo(commandMap.getMap());
			List<Map<String,Object>> listDetail = iPoliticsBoardService.searchPoliticsBoardReply(commandMap.getMap());
			mav.addObject("listMain", listMain);
			mav.addObject("listDetail", listDetail);
			mav = KctcMsgUtilService.getSuccMsg("SCMR001", mav);
		}catch(DataAccessException de){
			mav = new ModelAndView("jsonView");
			mav = KctcMsgUtilService.getErrMsg("ECMR001", mav);
		}catch ( Exception e ){
			log.debug(">>>> JK E: "+e.getMessage());
			mav = new ModelAndView("jsonView");
			mav = KctcMsgUtilService.getErrMsg("ECMR001", mav);
		}
		return mav;
	}
	
	@RequestMapping(value="/politics/deletePoliticsBoard.do")
	public ModelAndView deletePoliticsBoard(CommandMap commandMap) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			iPoliticsBoardService.deletePoliticsBoard(commandMap.getMap());
			mav = KctcMsgUtilService.getSuccMsg("SCMD001", mav);
		}catch( Exception e ){
			mav = KctcMsgUtilService.getErrMsg("ECMR001", mav);
		}
		return mav;
	}
	
	
}
