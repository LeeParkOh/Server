package first.util.cmncode.service.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import first.common.dao.AbstractDAO;

@Repository("cmnCdMgtDAO")
public class CmnCdMgtDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public   List<Map<String, Object>> selectCmnCd(Map<String, Object> map) {
		return selectList("cmnCdMgtDAO.selectCmnCd", map);
	}
}
