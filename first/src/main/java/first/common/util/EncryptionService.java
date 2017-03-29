package first.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Component;

@Component("encryptionService")
public class EncryptionService   {
	protected Log log = LogFactory.getLog(EncryptionService.class);
	
	//복호화 
	public String getDecipherPw(String encrypPw){
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword("BRACE_PASS");
		String decodedPass = pbeEnc.decrypt(encrypPw);
		return decodedPass;
	}
	//암호
	public String getEncryptPw(String decryptPw){
		StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();  
		standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");  
		standardPBEStringEncryptor.setPassword("BRACE_PASS");  
		String encodedPass = standardPBEStringEncryptor.encrypt(decryptPw);  
		return encodedPass;
	}
}