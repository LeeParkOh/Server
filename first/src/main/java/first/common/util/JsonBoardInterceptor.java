package first.common.util;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.jonpeterson.jackson.module.interceptor.JsonInterceptor;

import first.common.common.CommandMap;

public class JsonBoardInterceptor implements JsonInterceptor{
	protected Log log = LogFactory.getLog(JsonBoardInterceptor.class);
	@Resource(name = "jwtService")
	private JwtService jwtService;
	
	@Override
	public	JsonNode intercept(JsonNode node, JsonNodeFactory nodeFactory) {

		return node;
	}
	

}