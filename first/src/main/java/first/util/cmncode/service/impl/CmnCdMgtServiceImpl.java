package first.util.cmncode.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.common.util.FileUtils;
import first.noticeboard.politics.NB_PoliticsMgt.service.IPoliticsBoardService;
import first.noticeboard.politics.NB_PoliticsMgt.service.dao.PoliticsBoardMgtDAO;
import first.util.cmncode.service.ICmnCdMgtService;
import first.util.cmncode.service.dao.CmnCdMgtDAO;

@Service("iCmnCdMgtService")
public class CmnCdMgtServiceImpl implements ICmnCdMgtService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Resource(name="cmnCdMgtDAO")
	private CmnCdMgtDAO cmnCdMgtDAO;

	@Override
	public  List<Map<String, Object>> searchCmnCd(Map<String, Object> map)  {
		log.debug("grpCd>>>"+map.get("grpCd"));
		return cmnCdMgtDAO.selectCmnCd(map);
	}
	

}
