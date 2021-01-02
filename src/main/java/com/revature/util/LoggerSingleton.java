package com.revature.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerSingleton {
	
	private static Logger ersLogger = LogManager.getLogger("ERS");
	
	public static Logger getLogger() {
		return ersLogger;
	}

}
