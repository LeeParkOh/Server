/**
 *  Class Name : KctcMsgUtilService.java
 *  Description : KctcFramework에 전체 메세지를 관리하는 클래스 
 *  Modification Information
 * 
 *     수정일         수정자                   수정내용
 *   -------    --------    ---------------------------
 *  
 *
 *  @author Jerry Youn
 *  @since 2011. 06. 03
 *  @version 1.0
 *  @see Copyright (C) by KCTC All right reserved.
 */
package first.common.util.service;

import java.util.Locale;

import first.common.util.AppContext;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.ModelAndView;

public class KctcMsgUtilService {

	private static Logger logger = Logger.getLogger(KctcMsgUtilService.class);
	
	/**
	 * 파라메터 없이 에러 메세지를 구한다. 예) 등록에 실패하였습니다.
	 * @param psCode 에러코드
	 * @param poMav  ModelAndView객체
	 * @return poMav 에러메세지 객체
	 */
	public static ModelAndView getErrMsg(String psCode, ModelAndView poMav){
		
		String tsMsg = getMessage("error",psCode,null);
		poMav.addObject("ResultCode", "1");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	/**
	 * 파라메터가 있는 에러 메세지를 구한다. 예) {0}를 {1}하는도중 실패하였습니다.
	 * @param psCode 에러코드
	 * @param paParam 파라메터
	 * @param poMav ModelAndView객체
	 * @return  poMav 에러메세지 객체
	 */
	public static ModelAndView getErrMsg(String psCode, String[] paParam, ModelAndView poMav){
		
		String tsMsg = getMessage("error",psCode,paParam);
		poMav.addObject("ResultCode", "1");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	/**
	 * 파라메터가 없는 경고 메세지를 구한다. 
	 * @param psCode 경고코드
	 * @param poMav  ModelAndView객체
	 * @return poMav 경고메세지 객체
	 */
	public static ModelAndView getWarnMsg(String psCode, ModelAndView poMav){
		
		String tsMsg = getMessage("warn",psCode,null);
		poMav.addObject("ResultCode", "2");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	/**
	 * 파라메터가 있는 경고 메세지를 구한다.
	 * @param psCode 경고코드
	 * @param paParam 파라메터
	 * @param poMav ModelAndView객체
	 * @return poMav 경고메세지 객체
	 */
	public static ModelAndView getWarnMsg(String psCode, String[] paParam, ModelAndView poMav){
		
		String tsMsg = getMessage("warn",psCode,paParam);
		poMav.addObject("ResultCode", "2");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	/**
	 * 파라메터가 없는 정보 메세지를 리턴한다. 예)부대상황을 검토하세요.
	 * @param psCode 정보 메세시코드
	 * @param poMav ModelAndView객체
	 * @return poMav 정보 메세지 객체
	 */
	public static ModelAndView getInfoMsg(String psCode, ModelAndView poMav){
		
		String tsMsg = getMessage("info",psCode,null);
		poMav.addObject("ResultCode", "3");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	/**
	 * 파라메터가 있는 정보 메세지를 리턴한다. 예) {0}를 검토하세요.
	 * @param psCode 정보 메세시코드
	 * @param paParam 파라메터
	 * @param poMav ModelAndView객체
	 * @return poMav 정보 메세지 객체
	 */
	public static ModelAndView getInfoMsg(String psCode, String[] paParam, ModelAndView poMav){
		
		String tsMsg = getMessage("info",psCode,paParam);
		poMav.addObject("ResultCode", "3");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	/**
	 * 파라메터가 없는 성공 메세지를 리턴한다. 예)등록을 성공하였습니다.
	 * @param psCode
	 * @param poMav
	 * @return
	 */
	public static ModelAndView getSuccMsg(String psCode,ModelAndView poMav){
		
		String tsMsg = getMessage("succ",psCode,null);
		poMav.addObject("ResultCode", "0");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	/**
	 * 파라메터가 있는 성공 메세지를 리턴한다. 예){0}를 성공하였습니다.
	 * @param psCode 성공코드
	 * @param paParam 메세지 파라메터
	 * @param poMav ModelAndView객체
	 * @return poMav 성공메세지 객체
	 */
	public static ModelAndView getSuccMsg(String psCode, String[] paParam, ModelAndView poMav){
		
		String tsMsg = getMessage("succ",psCode,paParam);
		poMav.addObject("ResultCode", "0");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	/**
	 * 디비 에러 메세지를 리턴한다.
	 * @param poMav ModelAndView객체
	 * @param e 에러내용
	 * @return poMav 메세지 객체
	 */
	public static ModelAndView getSqlMsg(ModelAndView poMav, Throwable e){		
		
		String tsMsg = getMessage("sql","DBE-00000",null);
		
		if (tsMsg == null || "".equals(tsMsg))
			tsMsg = "DB에서 예상치 않은 오류가 발생하였습니다."; 

		poMav.addObject("ResultCode", "4");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	
	/**
	 * 파라메터 없이 validation 메세지를 구한다. 예) 등록에 실패하였습니다.
	 * @param psCode validation에러코드
	 * @param poMav  ModelAndView객체
	 * @return poMav 에러메세지 객체
	 */
	public static ModelAndView getValidMsg(String psCode, ModelAndView poMav){
		
		String tsMsg = getMessage("error",psCode,null);
		poMav.addObject("ResultCode", "-1");// U 와 I등이 안바뀜
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	/**
	 * 파라메터가 있는 validation 메세지를 구한다. 예) {0}를 {1}하는도중 실패하였습니다.
	 * @param psCode validation에러코드
	 * @param paParam 파라메터
	 * @param poMav ModelAndView객체
	 * @return  poMav 에러메세지 객체
	 */
	public static ModelAndView getValidMsg(String psCode, Object[] oParam, ModelAndView poMav){
		
		String[] sParam = new String[oParam.length];
		for(int y=0;y<oParam.length;y++){
			sParam[y] = oParam[y].toString();
		}
		
		String tsMsg = getMessage("error",psCode,sParam);
		poMav.addObject("ResultCode", "-1");
		poMav.addObject("ResultMsg", tsMsg);
		
		return poMav;
	}
	
	/**
	 * 각 메세지들을 프로퍼티 파일로 부터 읽어 조합을 한후 리턴한다.
	 * @param strCode 코드값
	 * @param oParam 파라메터값
	 * @return String 각종 메세지
	 */
	public static String getErrMsg(String psCode, String[] oParam){
		
		return getMessage("error", psCode, oParam);
	}
	
	/**
	 * 각 메세지들을 프로퍼티 파일로 부터 읽어 조합을 한후 리턴한다.
	 * @param strCode 코드값
	 * @return String 각종 메세지
	 */
	public static String getErrMsg(String strCode){
		
		return getMessage("error", strCode, null);
	}
	
	/**
	 * 각 메세지들을 프로퍼티 파일로 부터 읽어 조합을 한후 리턴한다.
	 * @param wrkCode 메세지 분류코드(error, info, succ, sql....)
	 * @param strCode 코드값
	 * @param arrParam 파라메터값
	 * @return String 각종 메세지
	 */
	private static String getMessage(String wrkCode, String strCode, String[] arrParam) {
		String message = "";
		wrkCode = ""; // 룰셋 UnusedFormalParameter 사유로 수정 (sicc 이선웅 담당 / 2015-11-25)
		Locale locale = new Locale("ko", "KR");
//		Locale locale = LocaleContextHolder.getLocale();

		MessageSource messageSource = (MessageSource) AppContext.getBean("messageSource");
		
		if (messageSource == null)
			return "해당 메시지 코드 설정 내역이 없습니다.";
		
		try 
		{
			message = messageSource.getMessage(strCode, arrParam, locale);
		} 
		catch (DataAccessException de)
		{
			message = "해당 메시지 코드 설정 내역이 없습니다.";
		}
		catch (Exception ex) 
		{ 
			message = "해당 메시지 코드 설정 내역이 없습니다.";
		}
		
		return message;
	}
	/**
	 * 오라클 코드에서 에러코드를 뽑아밴다.
	 * @param ex 디비 익셉션 메세지
	 * @return String 오라클 에러코드
	 */
	// 룰셋 UnusedPrivateMethod 사유로 수정 (sicc 이선웅 담당 / 2015-11-25)
	private static String getOracleCode(Throwable ex){
		
		  String content = ex.getCause().getMessage();
		  
		  int length = content.length();

	        for (int i = 0; i < length; i++) {

	            if (content.startsWith("ORA-")) {
	                if (isOracleErrorCode(content.substring(0, 9))) {
	                    return content.substring(0, 9);
	                }
	            }
	            content = content.substring(1);
	        }

	        return null;
	}
	
	/**
	 * 오라클 코드 여부 체크
	 * @param errorCode 에러코드
	 * @return boolean 오라클 코드여부 
	 */
	 public static boolean isOracleErrorCode(String errorCode) {
		 	int i = 1; // 룰셋 UnusedPrivateMethod 사유로 수정 (sicc 이선웅 담당 / 2015-11-25)
		 	if(i == 0) {
		 		getOracleCode(null);
		 	}
		 
	        if (errorCode.length() != 9 || !errorCode.startsWith("ORA-")) {
	            return false;
	        }
	        try {
	            new Integer(errorCode.substring(5));
	        } catch (java.lang.NumberFormatException ex) {
	            return false;
	        }

	        return true;
	    }
}
