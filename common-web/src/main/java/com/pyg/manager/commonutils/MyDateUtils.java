package com.pyg.manager.commonutils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtils {

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getDateTimeNow(String format) {
		if (format == null || "".equals(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		return new SimpleDateFormat(format)
				.format(Calendar.getInstance().getTime());
	}

	/**
	 * 获取两个时间差
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static Long getMinutes(String startDate, String endDate) {
		Long minute = 0L;
		try {

			if (startDate != null && startDate != "" && endDate != null
					&& endDate != "") {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date startDt = simpleDateFormat.parse(startDate);
				Date endDt = simpleDateFormat.parse(endDate);

				long newTime1 = startDt.getTime();
				long newTime2 = endDt.getTime();
				Long result = newTime2 - newTime1; // 获取两时间相差的毫秒数
				minute = result;

			}
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.Error,
					String.format("执行函数getMinutes发生异常:%s", e.getMessage()));
		}
		return minute;
	}

	public static String getTimeStr(Long time) {
		String timeStr = "";
		try {
			long nd = 1000 * 24 * 60 * 60;
			long nh = 1000 * 60 * 60;
			long nm = 1000 * 60;
			long hour = time % nd / nh; // 获取相差的小时数
			long min = time % nd % nh / nm; // 获取相差的分钟数
			long day = time / nd;
			timeStr=String.format("%s天 %s小时%s分 ", day,hour,min);
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.Error,
					String.format("执行函数getTimeStr发生异常:%s", e.getMessage()));
		}
		return timeStr;
	}
}
