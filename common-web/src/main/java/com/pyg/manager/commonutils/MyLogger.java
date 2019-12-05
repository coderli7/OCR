package com.pyg.manager.commonutils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

@SuppressWarnings("rawtypes")
public class MyLogger {

	private static HashMap<String, Logger> loggers;

	private static Logger defaultLogger;

	static {
		initLoggers();
		initDefaultLogger();
	}

	private static void initDefaultLogger() {
		try {
			defaultLogger = Logger.getLogger(Logger.class);
			PatternLayout patternLayout = new PatternLayout(
					"%-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n");
			// File fileTmp = new File("");
			String basePath = "";
			// try {
			// basePath = fileTmp.getCanonicalPath();
			basePath = MyLogger.class.getResource("/").getPath();
			// System.out.println("log路径:" + basePath);
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			String logPath = String.format("%s\\logs\\%s\\%s\\info.txt",
					basePath, "default",
					MyDateUtils.getDateTimeNow("yyyy-MM-dd"));
			RollingFileAppender fileAppender = null;
			try {
				fileAppender = new RollingFileAppender(patternLayout, logPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			defaultLogger.addAppender(fileAppender);
			defaultLogger.setLevel(Level.DEBUG);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void initLoggers() {
		loggers = new HashMap<String, Logger>();
		LoggerEnum[] values = LoggerEnum.values();
		for (LoggerEnum loggerEnum : values) {
			String curLoggerName = loggerEnum.name();
			Logger curLogger = Logger.getLogger(curLoggerName);
			try {
				PatternLayout patternLayout = new PatternLayout(
						"%-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n");
				// File fileTmp = new File("");
				// String basePath = fileTmp.getCanonicalPath();
				String basePath = "";
				basePath = MyLogger.class.getResource("/").getPath();
				String logPath = String.format("%s\\logs\\%s\\%s\\info.txt",
						basePath, curLoggerName,
						MyDateUtils.getDateTimeNow("yyyy-MM-dd"));
				RollingFileAppender fileAppender = new RollingFileAppender(
						patternLayout, logPath);
				curLogger.addAppender(fileAppender);
				curLogger.setLevel(Level.DEBUG);
				loggers.put(curLoggerName, curLogger);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 分模块写入日志
	 * @param loggerEnum 模块儿枚举
	 * @param info 日志信息
	 */
	public static void log(LoggerEnum loggerEnum, String info) {
		try {
			Logger wrLogger = null;
			if (loggerEnum != null) {
				String loggerName = loggerEnum.name();
				Logger curLogger = loggers.get(loggerName);
				if (curLogger != null) {
					wrLogger = curLogger;
				} else {
					wrLogger = defaultLogger;
				}
			} else {
				wrLogger = defaultLogger;
			}
			Enumeration allAppenders = wrLogger.getAllAppenders();
			RollingFileAppender appender = (RollingFileAppender) allAppenders
					.nextElement();
			//实现替换文本文件
			if (appender != null) {
				String orgFilePath = appender.getFile();
				String newFilePath = orgFilePath.replaceFirst(
						"[\\d]{4}-[\\d]{2}-[\\d]{2}",
						MyDateUtils.getDateTimeNow("yyyy-MM-dd"));
				appender.setFile(newFilePath);
			}
			wrLogger.info(info);
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.Error,
					String.format("执行函数log发生异常:%s", e.getMessage()));
		}

	}

}
