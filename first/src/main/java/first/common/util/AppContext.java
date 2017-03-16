package first.common.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContext implements ApplicationContextAware 
{
	private static ApplicationContext CONTEXT;
	private static Logger logger = Logger.getLogger(AppContext.class);
		
	public AppContext() {
		logger.info("=================================================================================================");
		logger.info(">>>>>>>                         init AppContext                                           <<<<<<<");
		logger.info("=================================================================================================");
	}
		
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		CONTEXT = context;
	}
 
	public static Object getBean(String beanName) {
		return CONTEXT.getBean(beanName);
	}
}