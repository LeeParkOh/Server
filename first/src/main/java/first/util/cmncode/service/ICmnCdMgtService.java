package first.util.cmncode.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ICmnCdMgtService {
	public List<Map<String, Object>> searchCmnCd(Map<String, Object> map);
}
