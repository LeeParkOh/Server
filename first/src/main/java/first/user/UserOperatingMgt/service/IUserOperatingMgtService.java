package first.user.UserOperatingMgt.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
public interface IUserOperatingMgtService {

	public List<Map<String, Object>> searchUserInfo(Map<String, Object> map);

	void saveUserInfo(Map<String, Object> map, HttpServletRequest request) throws Exception;
	
	void updateUserInfo(Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> searchLoginInfo(String userId);	
	
}
