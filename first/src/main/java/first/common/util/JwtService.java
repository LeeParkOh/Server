package first.common.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component("jwtService")
public class JwtService   {
	protected Log log = LogFactory.getLog(EncryptionService.class);
	
	public String getToken(String userId) throws Exception{
		String token="";
		try{
			Algorithm algorithm = Algorithm.HMAC256("secret");
			Map<String, Object> headerClaims = new HashMap();
			headerClaims.put("owner", "LeeParkOh");
			     token = JWT.create()
						    .withIssuer("LeeParkOh")
						    .withHeader(headerClaims)
						    .withClaim("userId", userId)
						    .sign(algorithm);
			 log.debug("token>>>>>"+ token); 
		}catch(UnsupportedEncodingException exception){
			log.debug("UnsupportedEncodingException>>>");
			return "";
		}catch (JWTVerificationException exception){
			log.debug("JWTVerificationException>>>");
			return "";
		}
		return token;
	}
	
	public String verifyToken(String token) throws Exception{
		try{
			Algorithm algorithm = Algorithm.HMAC256("secret");
			 JWTVerifier verifier = JWT.require(algorithm)
								        .withIssuer("LeeParkOh")
								        .build(); //Reusable verifier instance
			 DecodedJWT jwt = verifier.verify(token);
			 log.debug("jwt>>>"+jwt);
		}catch(UnsupportedEncodingException exception){
			log.debug("UnsupportedEncodingException>>>"+exception);
			return "UnVerifiedToken";
		}catch(JWTDecodeException e){
			log.debug("JWTDecodeException>>>"+e);
			return "UnVerifiedToken";
		}catch (JWTVerificationException exception){
			log.debug("JWTVerificationException>>>"+exception);
			return "UnVerifiedToken";
		}
		return "VerifiedToken";
	}
	 
}