package first.user.UserOperatingMgt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.common.util.EncryptionService;
import first.common.util.FileUtils;
import first.user.UserOperatingMgt.service.IUserOperatingMgtService;
import first.user.UserOperatingMgt.service.dao.UserOperatingMgtDAO;

@Service("iUserOperatingMgtService")
public class UserOperatingMgtServiceImpl implements IUserOperatingMgtService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Resource(name="encryptionService")
	private EncryptionService encryptionService;
	
	@Resource(name="userOperatingMgtDAO")
	private UserOperatingMgtDAO userOperatingMgtDAO;

	@Override
	public  List<Map<String, Object>> searchUserInfo(Map<String, Object> map)  {
		List<Map<String, Object>> vList = userOperatingMgtDAO.selectUserInfo(map);
		String  userPw =  (String) vList.get(0).get("userPw");
		vList.get(0).put("userPw",encryptionService.getDecipherPw(userPw));
		return vList;
	}
	
	@Override
	public void saveUserInfo(Map<String, Object> map, HttpServletRequest request) throws Exception {
		String userPw = (String) map.get("userPw") ;
		map.put("userPw",encryptionService.getEncryptPw(userPw));
		userOperatingMgtDAO.insertUserInfo(map);
	}

	@Override
	public void updateUserInfo(Map<String, Object> map) throws Exception {
		String userPw = (String) map.get("userPw") ;
		if(userPw.length() > 0){
			map.put("userPw",encryptionService.getEncryptPw(userPw));
		}
		userOperatingMgtDAO.updateUserInfo(map);
	}
}
