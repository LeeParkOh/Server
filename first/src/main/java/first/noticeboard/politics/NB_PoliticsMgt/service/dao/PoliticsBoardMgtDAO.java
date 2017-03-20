package first.noticeboard.politics.NB_PoliticsMgt.service.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import first.common.dao.AbstractDAO;

@Repository("politicsBoardMgtDAO")
public class PoliticsBoardMgtDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public   List<Map<String, Object>> selectUserInfo(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectPagingList("politicsBoardMgtDAO.selectUserInfo", map);
	}

	public int insertBoard(Map<String, Object> map) throws Exception{
		return (int)insert("politicsBoardMgtDAO.insertBoard", map);
	}

}
