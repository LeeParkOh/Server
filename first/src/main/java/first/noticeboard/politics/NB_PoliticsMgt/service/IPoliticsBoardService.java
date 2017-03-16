package first.noticeboard.politics.NB_PoliticsMgt.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IPoliticsBoardService {

	public List<Map<String, Object>> searchUserInfo(Map<String, Object> map);

	void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception;
}
