package first.user.UserOperatingMgt.service.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import first.common.dao.AbstractDAO;
import first.noticeboard.politics.NB_PoliticsMgt.service.vo.PoliticsBoardInfoVO;

@Repository("userOperatingMgtDAO")
public class UserOperatingMgtDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public   List<Map<String, Object>> selectUserInfo(Map<String, Object> map) {
		return (List<Map<String, Object>>) selectList("userOperatingMgtDAO.selectUserInfo", map);
	}

	public void insertUserInfo(Map<String, Object> map) throws Exception{
		insert("userOperatingMgtDAO.insertUserInfo", map);
	}
	
	public void updateUserInfo(Map<String, Object> map) throws Exception{
		update("userOperatingMgtDAO.updateUserInfo", map);
	}
	
}
