package iih.bd.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import iih.bd.base.validator.ParamValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;

/**
 * 日期时间帮助类
 * 
 * @author yankan
 *
 */
public class DateTimeUtils {

	public static FTime TIME_BEGIN = new FTime("00:00:00");
	public static FTime TIME_END = new FTime("23:59:59");
	public static FDouble MS_OF_DAY = new FDouble(86400000L);// 一天的毫秒数
	public static FDouble MS_OF_SEC = new FDouble(1000L);// 一秒的毫秒数
	
	/**
	 * 是否已经过去
	 * 
	 * @param time
	 *            日期时间
	 * @return
	 */
	public static boolean isPast(FDateTime time) {
		FDateTime currentTime = AppUtils.getServerDateTime();
		return currentTime.before(time);
	}

	/**
	 * 是否是今天
	 * 
	 * @param time
	 * @return
	 */
	public static boolean isToday(FDateTime time) {
		FDateTime currentTime = AppUtils.getServerDateTime();
		return currentTime.getDate().isSameDate(time.getDate());
	}

	/**
	 * 是否是今天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(FDate date) {
		FDateTime currentTime = AppUtils.getServerDateTime();
		return currentTime.getDate().isSameDate(date);
	}

	/**
	 * 计算某个日期之前多个自然日的日期
	 * 
	 * @param date
	 *            日期
	 * @param days
	 *            自然日
	 * @return 计算得到的日期
	 */
	public static FDate getDateBefore(FDate date, int days) throws BizException {
		ParamValidator.validateNotNull("date", date);
		if (days == 0) {
			return date;
		}
		return date.getDateBefore(days);
	}

	/**
	 * 获取几天前的时间
	 * 
	 * @param dateTime
	 *            日期
	 * @param days
	 *            自然日
	 * @return 计算得到的日期
	 */
	public static FDateTime getDateTimeBefore(FDateTime dateTime, int days)
			throws BizException {
		ParamValidator.validateNotNull("datetime", dateTime);
		return dateTime.getDateTimeBefore(days);
	}

	/**
	 * 获取几天后的时间
	 * @param dateTime
	 * @param days
	 * @return
	 * @throws BizException
	 */
	public static FDateTime getDateTimeAfter(FDateTime dateTime, int days)
			throws BizException {
		ParamValidator.validateNotNull("datetime", dateTime);
		return dateTime.getDateTimeAfter(days);
	}
	
	
	/**
	 * 获取较大时间
	 * 
	 * @param time1
	 *            时间1
	 * @param time2
	 *            时间2
	 * @return
	 */
	public static FDateTime getLarger(FDateTime time1, FDateTime time2) {
		return time1.compareTo(time2) >= 0 ? time1 : time2;
	}

	/**
	 * 获取较小时间
	 * 
	 * @param time1
	 *            时间1
	 * @param time2
	 *            时间2
	 * @return
	 */
	public static FDateTime getSmaller(FDateTime time1, FDateTime time2) {
		return time1.compareTo(time2) >= 0 ? time2 : time1;
	}

	/**
	 * 获取某日的开始时间 如：2010-09-21 00:00:00
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static FDateTime getDayBeginTime(FDate date) {
		return new FDateTime(date.asLocalBegin(), TIME_BEGIN);
	}

	/**
	 * 获取某日的结束时间 如：2010-09-21 23:59:59
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static FDateTime getDayEndTime(FDate date) {
		return new FDateTime(date.asLocalBegin(), TIME_END);
	}

	/**
	 * 获取某日的开始时间 如：2010-09-21 00:00:00
	 * 
	 * @param datetime
	 *            日期时间
	 * @return
	 */
	public static FDateTime getDayBeginTime(FDateTime datetime) {
		return new FDateTime(datetime.getBeginDate(), TIME_BEGIN);
	}

	/**
	 * 获取某日的开始时间 如：2010-09-21 23:59:59
	 * 
	 * @param datetime
	 *            日期时间
	 * @return
	 */
	public static FDateTime getDayEndTime(FDateTime datetime) {
		return new FDateTime(datetime.getEndDate(), TIME_END);
	}

	/**
	 * 是否同一天
	 * 
	 * @param time1
	 *            时间1
	 * @param time2
	 *            时间2
	 * @return boolean
	 */
	public static Boolean isSameDay(FDateTime time1, FDateTime time2) {
		if (time1 == null || time2 == null) {
			return false;
		}
		return time1.getDate().toLocalString()
				.equals(time2.getDate().toLocalString());
	}

	/**
	 * 计算几个自然天前的时间 (当天也算一天)
	 * 
	 * @param dateTime
	 * @param days
	 * @return
	 */
	public static FDateTime getDateTimeBeforeNatureDays(FDateTime dateTime,
			int days) {
		if (days == 0) {
			return dateTime;
		} else if (days == 1) {
			return new FDateTime(dateTime.getDate().toLocalString()
					+ " 00:00:00");
		} else {
			FDateTime dateVal = dateTime.getDateTimeBefore(days - 1);
			return new FDateTime(dateVal.getDate().toLocalString()
					+ " 00:00:00");
		}
	}

	/**
	 * 获取日期开始时间
	 * 
	 * @param dateTime
	 * @return
	 */
	public static FDateTime getDateBegin(FDateTime dateTime) {
		return new FDateTime(dateTime.getDate().toLocalString());
	}

	/**
	 * 获取间隔自然天
	 * 
	 * @param begin
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 */
	public static Integer getNatDaysBetween(FDateTime begin, FDateTime end) {
		if (begin == null || end == null) {
			return 0;
		}
		return getNatDaysBetween(begin.getDate(), end.getDate());
	}

	/**
	 * 获取间隔自然天
	 * 
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return
	 */
	public static Integer getNatDaysBetween(FDate begin, FDate end) {
		if (begin == null || end == null) {
			return 0;
		}
		return end.asBegin().getDaysAfter(begin.asBegin());
	}

	/**
	 * 是否相同
	 * 
	 * @param time1
	 *            时间1
	 * @param time2
	 *            时间2
	 * @return boolean
	 */
	public static Boolean isEqual(FTime time1, FTime time2) {
		if (time1 == null) {
			return time2 == null;
		}

		return time1.equals(time2);
	}

	/**
	 * 是否每天开始时间
	 * 
	 * @param time1
	 *            时间
	 * @return boolean
	 */
	public static Boolean isDayBegin(FTime time1) {
		return isEqual(TIME_BEGIN, time1);
	}

	/**
	 * 是否在特定某一天
	 * 
	 * @param time
	 * @param date
	 * @return
	 */
	public static Boolean isInThisDay(FDateTime time, FDate date) {
		if (time == null) {
			return false;
		}
		return time.getDate().toLocalString().equals(date.toLocalString());
	}

	/**
	 * 获取指定相差日期天数，比如前一天后一天
	 * 
	 * @param date
	 * @param day
	 * @return
	 * @author ly
	 */
	public static Date getDifferDate(Date date, int day) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int nowDay = c.get(Calendar.DATE);
		c.set(Calendar.DATE, nowDay + day);

		return c.getTime();
	}
	
	/** 
	* 获得指定日期的前一天 
	* @param specifiedDay 
	* @return 
	* @author ly
	*/ 
	public static String getSpecifiedDayBefore(String specifiedDay){ 
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try { 
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
		} catch (ParseException e) { 
			e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day-1); 
	
		String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
		return dayBefore; 
	} 
	/**
	 * 把日期转化为yyyyMMddHHmmss样式字符串
	 * 
	 * @param dateTime
	 * @return
	 * @author ly
	 */
	public static String toStringFDateTimeFormat(FDateTime dateTime){
		if(dateTime == null || dateTime.getDate() == null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(dateTime.getDate().toDate());
	}
	
	/**
	 * 获取当月第一天
	 * @param dateTime
	 * @param days
	 * @return
	 * @throws BizException
	 */
	public static FDateTime getCurrentMonthBeginDate(FDateTime datetime)
			throws BizException {
		ParamValidator.validateNotNull("datetime", datetime);
		return new FDateTime(datetime.getYear()+"-"+datetime.getMonth()+"-01 00:00:00");
	}
}
