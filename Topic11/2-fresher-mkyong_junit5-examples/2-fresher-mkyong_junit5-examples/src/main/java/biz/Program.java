package biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.stream.IntStream;

public class Program {

	private static final Logger logger = LoggerFactory.getLogger(
			MethodHandles.lookup().lookupClass().getSimpleName());

	public static void performLogging() {  
		logger.debug("This is a debug message");  
		logger.info("This is an info message");  
		
		logger.warn("This is a warn message");  
		logger.error("This is an error message");  		
		
		//logger.fatal("This is a fatal message");
	}
	public static void main(String[] args) {		
		System.out.println("Hello JUnit");
		
		performLogging();
	}
}
