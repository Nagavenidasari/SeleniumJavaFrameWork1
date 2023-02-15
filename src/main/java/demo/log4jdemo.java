package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jdemo {
	
	static Logger logger = LogManager.getLogger(log4jdemo.class);

	public static void main(String[] args) {
		System.out.println("Hello World !");
		
		logger.trace("This is trace message");
		logger.info("This is an error message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		logger.fatal("This is fatal message");

	}

}
