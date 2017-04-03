package first.noticeboard.politics.NB_PoliticsMgt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.common.util.FileUtils;
import first.noticeboard.politics.NB_PoliticsMgt.service.IPoliticsBoardService;
import first.noticeboard.politics.NB_PoliticsMgt.service.dao.PoliticsBoardMgtDAO;
import first.noticeboard.politics.NB_PoliticsMgt.service.vo.PoliticsBoardInfoVO;

@Service("iPoliticsBoardService")
public class PoliticsBoardServiceImpl implements IPoliticsBoardService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Resource(name="politicsBoardMgtDAO")
	private PoliticsBoardMgtDAO politicsBoardMgtDAO;

	@Override
	public  List<Map<String, Object>> searchUserInfo(Map<String, Object> map)  {
		return politicsBoardMgtDAO.selectUserInfo(map);
	}
	
	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		int masterPk = (int)politicsBoardMgtDAO.insertBoard(map);
		log.debug(">>>>>"+map.get("headSeq"));
		//politicsBoardMgtDAO.insertBoardDetail(map);
	}

	@Override
	public  List<Map<String, Object>> searchPoliticsBoardInfo(Map<String, Object> map)  {
		return politicsBoardMgtDAO.selectPoliticsBoardInfo(map);
	}
	
	
	@Override
	public void insertBoardReply(Map<String, Object> map, HttpServletRequest request) throws Exception {
			politicsBoardMgtDAO.insertBoardReply(map);
	}
	
	@Override
	public  List<Map<String, Object>> searchPoliticsBoardReply(Map<String, Object> map)  {
		try {
		
		} catch (Exception e) {
			log.debug("Exception>>>"+e);
		}
		return politicsBoardMgtDAO.selectPoliticsBoardReply(map);
	}

	@Override
	public void updatePoliticsBoardHitCnt(Map<String, Object> map) throws Exception {
		politicsBoardMgtDAO.updatePoliticsBoardHitCnt(map);
	}
	
	@Override
	public void deletePoliticsBoard(Map<String, Object> map) throws Exception {
		politicsBoardMgtDAO.deletePoliticsBoard(map);
	}

	
}
