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
		
		String masterPk = (String)politicsBoardMgtDAO.insertBoard(map);
		log.debug("masterPk>>"+masterPk);
		
		
		//politicsBoardMgtDAO.insertBoardDetail(map);
	}

}
