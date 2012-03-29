package com.myjavasolutions.logging;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoginUtilImpl implements LoginUtil {
	
	public void log(LogLevel logLevel, Throwable throwable, LoggingPropBean loggingPropBean) {

		switch (logLevel) {

			case DEBUG:
				debug(throwable, loggingPropBean);
				break;
				
			case INFO:
				info(throwable, loggingPropBean);
				break;
				
			case WARN:
				warn(throwable, loggingPropBean);
				break;
		
			case ERROR:
				error(throwable, loggingPropBean);
				break;
	
			case FATAL:
				fatal(throwable, loggingPropBean);
				break;
	
		}
	}
	
	
	private void debug(Throwable throwable, LoggingPropBean loggingPropBean) {

		if (throwable != null) {
			getLogger(loggingPropBean.getClassName()).debug(loggingPropBean.toString() + " Exception --> " + throwable);
		} else {
			getLogger(loggingPropBean.getClassName()).debug(loggingPropBean.toString());
		}
	}
	
	private void info(Throwable throwable, LoggingPropBean loggingPropBean) {

		if (throwable != null) {
			getLogger(loggingPropBean.getClassName()).info(loggingPropBean.toString() + " Exception --> " + throwable);
		} else {
			getLogger(loggingPropBean.getClassName()).info(loggingPropBean.toString());
		}
	}
	
	private void warn(Throwable throwable, LoggingPropBean loggingPropBean) {

		if (throwable != null) {
			getLogger(loggingPropBean.getClassName()).warn(loggingPropBean.toString() + " Exception --> " + throwable);
		} else {
			getLogger(loggingPropBean.getClassName()).warn(loggingPropBean.toString());
		}
	}
	
	private void error(Throwable throwable, LoggingPropBean loggingPropBean) {
		
		if (throwable != null) {
			getLogger(loggingPropBean.getClassName()).error(loggingPropBean.toString() + " Exception --> " + throwable);
		} else {
			getLogger(loggingPropBean.getClassName()).error(loggingPropBean.toString());
		}
	}
	
	private void fatal(Throwable throwable, LoggingPropBean loggingPropBean) {
		
		if (throwable != null) {
			getLogger(loggingPropBean.getClassName()).fatal(loggingPropBean.toString() + " Exception --> " + throwable);
		} else {
			getLogger(loggingPropBean.getClassName()).fatal(loggingPropBean.toString());
		}
	}
	
	
	private Logger getLogger( Class<?> clazz) {

		return Logger.getLogger(clazz);
	}
	
}
