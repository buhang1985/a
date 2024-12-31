package iih.ci.sdk.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.Calendars;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.coreitf.d.ICalendar;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;

public class CiDateUtils {
	public static final FDateTime MAX_SYS_DATETIME = new FDateTime(
			"2099-01-01 00:00:00");
	public static final String MAX_AGEMONTH_NULL = "9999999";
	public static String dateTimeFormatStr="yyyy-MM-dd HH:mm:ss";
	public static String dateFormatStr="yyyy-MM-dd";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static SimpleDateFormat dayFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

	private static SimpleDateFormat monthFormat = new SimpleDateFormat(
			"yyyy-MM");

	private static SimpleDateFormat hourFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:00");

	private static SimpleDateFormat minuteFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");

	private static SimpleDateFormat shortTimeFormat = new SimpleDateFormat(
			"HH:mm:ss");

	private static SimpleDateFormat millisecondFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss SSS");
	
	
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	public static FDateTime getServerDateTime(){
		TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
		return  ts.getUFDateTime();
	}

	public static String getCurYear() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat fmt = (SimpleDateFormat) yearFormat.clone();
		String date = fmt.format(calendar.getTime());
		return date;
	}

	public static String getCurMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat fmt = (SimpleDateFormat) monthFormat.clone();
		String date = fmt.format(calendar.getTime());
		return date;
	}

	public static String getCurQuarter() {
		String year = getCurYear();
		String yearMonth = getCurMonth();
		int monthCount = yearMonth.length();

		String month = yearMonth.substring(monthCount - 2, monthCount);

		int intMonth = Integer.valueOf(month).intValue();
		int intQuarter = (intMonth % 3 == 0) ? intMonth / 3 : intMonth / 3 + 1;

		return year + "-Q-" + intQuarter;
	}

	public static String getCurTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat fmt = (SimpleDateFormat) dateFormat.clone();
		String date = fmt.format(calendar.getTime());
		return date;
	}

	public static String getCurShortTime() {
		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat fmt = (SimpleDateFormat) shortTimeFormat.clone();
		String time = fmt.format(calendar.getTime());
		return time;
	}

	public static SimpleDateFormat getDateFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) dateFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getMonthFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) monthFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getMinuteFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) minuteFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getDayFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) dayFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getYearFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) yearFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getHourFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) hourFormat.clone();
		return fmt;
	}

	public static SimpleDateFormat getMillisecondFormat() {
		SimpleDateFormat fmt = (SimpleDateFormat) millisecondFormat.clone();
		return fmt;
	}

	public static String getCurTimeWithMillisecond() {
		Calendar calendar = Calendar.getInstance();
		String date = getMillisecondFormat().format(calendar.getTime());
		return date;
	}

	public static long getCurTimeInt() {
		return System.currentTimeMillis();
	}

	public static String getCurDay() {
		Calendar calendar = Calendar.getInstance();
		String day = getDayFormat().format(calendar.getTime());
		return day;
	}

	public static String getCurHour() {
		Calendar calendar = Calendar.getInstance();
		String day = getHourFormat().format(calendar.getTime());
		return day;
	}

	public static boolean checkDate(String pDateObj) {
		boolean ret = true;
		if ((pDateObj == null) || (pDateObj.length() < 1)) {
			ret = false;
		}
		try {
			String[] arr = pDateObj.split("-");

			int year = new Integer(arr[0]).intValue();

			int month = new Integer(arr[1]).intValue();

			int day = new Integer(arr[2]).intValue();

			Calendar cal = Calendar.getInstance();

			cal.setLenient(false);
			cal.set(year, month - 1, day);

			cal.getTime();
		} catch (Exception e) {
			ret = false;
		}
		return ret;
	}

	public static long diffMillisecond(String startTime, String endTime)
			throws ParseException {
		SimpleDateFormat format = getMillisecondFormat();
		Date dstartTime = format.parse(startTime);
		Date dendTime = format.parse(endTime);
		return dendTime.getTime() - dstartTime.getTime();
	}

	public static Date convertStrToDate(String srcDateStr) {
		if ((srcDateStr == null) || (srcDateStr.trim().length() == 0))
			return null;
		try {
			SimpleDateFormat format = getDayFormat();
			if (srcDateStr.indexOf("/") > 0) {
				format = new SimpleDateFormat("yyyy/MM/dd");
			}

			return format.parse(srcDateStr);
		} catch (ParseException e) {
		}
		return null;
	}

	public static String millis2Str(long time) {
		if (time < 0L) {
			return null;
		}
		return getMillisecondFormat().format(new Date(time));
	}

	public static int getDayNum(int year, int month) {
		boolean leapYear = isLeapYear(year);
		int dayMount = 31;
		switch (month) {
		case 2:
			dayMount = (leapYear) ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dayMount = 30;
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		}
		return dayMount;
	}

	public static boolean isAllowDate(String strDate) {
		if ((strDate == null) || (strDate.trim().length() == 0)) {
			return true;
		}
		if (strDate.trim().length() != 10) {
			return false;
		}
		for (int i = 0; i < 10; ++i) {
			char c = strDate.trim().charAt(i);
			if ((i == 4) || (i == 7)) {
				if (c != '-')
					return false;
			} else if ((c < '0') || (c > '9')) {
				return false;
			}
		}
		int year = Integer.parseInt(strDate.trim().substring(0, 4));
		int month = Integer.parseInt(strDate.trim().substring(5, 7));
		if ((month < 1) || (month > 12)) {
			return false;
		}
		int day = Integer.parseInt(strDate.trim().substring(8, 10));
		int[] MONTH_LENGTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] LEAP_MONTH_LENGTH = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30,
				31 };
		int daymax = (isLeapYear(year)) ? LEAP_MONTH_LENGTH[(month - 1)]
				: MONTH_LENGTH[(month - 1)];

		return ((day >= 1) && (day <= daymax));
	}

	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (((year % 100 != 0) || (year % 400 == 0))));
	}

	public static String getValidUFODateString(String sDate) {
		try {
			if (isAllowDate(sDate)) {
				return sDate;
			}

			int index = sDate.indexOf("-");
			if (index < 1) {
				return null;
			}
			int year = Integer.parseInt(sDate.trim().substring(0, index));

			String sTemp = sDate.trim().substring(index + 1);
			index = sTemp.indexOf("-");
			if (index < 1) {
				return null;
			}
			String strMonth = sTemp.trim().substring(0, index);
			if (strMonth.startsWith("0")) {
				strMonth = strMonth.substring(1);
			}
			int month = Integer.parseInt(strMonth);

			if ((month < 1) || (month > 12)) {
				return null;
			}
			String strDay = sTemp.trim().substring(index + 1);
			if (strDay.startsWith("0")) {
				strDay = strDay.substring(1);
			}
			int day = Integer.parseInt(strDay);

			int[] MONTH_LENGTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
					31 };
			int[] LEAP_MONTH_LENGTH = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31,
					30, 31 };
			int daymax = (isLeapYear(year)) ? LEAP_MONTH_LENGTH[(month - 1)]
					: MONTH_LENGTH[(month - 1)];
			if ((day < 1) || (day > daymax)) {
				day = daymax;
			}
			String strYear = String.valueOf(year);
			for (int i = strYear.length(); i < 4; ++i) {
				strYear = "0" + strYear;
			}
			strMonth = String.valueOf(month);
			if (strMonth.length() < 2) {
				strMonth = "0" + strMonth;
			}
			strDay = String.valueOf(day);
			if (strDay.length() < 2) {
				strDay = "0" + strDay;
			}
			return strYear + "-" + strMonth + "-" + strDay;
		} catch (Exception e) {
		}
		return null;
	}

	public static String getStrFullDate(String strDate) {
		int index = strDate.indexOf("-");
		if (index < 1) {
			index = strDate.indexOf("/");
			if (index < 1) {
				return strDate;
			}
		}

		String year = strDate.trim().substring(0, index);

		String strMonth = null;
		String strDay = null;
		String sTemp = strDate.trim().substring(index + 1);
		index = sTemp.indexOf("-");
		if (index < 1) {
			index = sTemp.indexOf("/");
			if (index < 1) {
				strMonth = sTemp;
				strDay = "01";
			}
		}

		if (strMonth == null) {
			strMonth = sTemp.trim().substring(0, index);
		}

		if (strDay == null) {
			strDay = sTemp.trim().substring(index + 1);
		}

		return year + "-" + strMonth + "-" + strDay;
	}

	/**
	 * 按格式获得时间串
	 * 
	 * @param sDate
	 * @param formatStr
	 * @return
	 */
	public static String getDateTimeStr(Object oDate, String formatStr) {
		if (oDate == null)
			return "";
		try {
			return getDateTimeStr(oDate.toString(), formatStr);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 按格式获得时间串
	 * 
	 * @param sDate
	 * @param formatStr
	 * @return
	 */
	public static String getDateTimeStr(String sDate, String formatStr) {
		try {
			if (StringUtils.isBlank(sDate))
				return "";
			if (StringUtils.isBlank(formatStr))
				return sDate;
			DateFormat dfa = new SimpleDateFormat(formatStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(stringToDate(sDate));
			return dfa.format(cal.getTime());
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 按格式获得时间串
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String getDateTimeStr(Date date, String formatStr) {
		if (StringUtils.isBlank(formatStr))
			return date.toString();
		DateFormat dfa = new SimpleDateFormat(formatStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return dfa.format(cal.getTime());
	}

	/**
	 * 按格式获得时间串
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String getDateTimeStr(FDate date, String formatStr) {
		if (StringUtils.isBlank(formatStr))
			return date.toString();
		DateFormat dfa = new SimpleDateFormat(formatStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date.toDate());
		return dfa.format(cal.getTime());
	}

	public static Date stringToDate(String sDate) throws Exception {
		DateFormat dfa = dateFormat;// new
									// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dfa.parse(sDate);
	}

	public static int getDayOfWeek(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(7);
	}

	public static String getCurrentTime() {
		return getFormatDateTime(new java.util.Date(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String getFormatDateTime(java.util.Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static FDateTime getDateTimeAfter(FDateTime dt, int hours) {
		long utcTime = Calendars.getMillis(dt.getBeginDate(), dt.getUFTime(),
				Calendars.getGMTDefault());
		return new FDateTime(utcTime + ICalendar.MILLIS_PER_HOUR * hours);
	}
	
	public static FDateTime getDateTime(Integer year,Integer month,Integer day){
		String monthstr="";
		if(month==null || month==0){
			monthstr="01";
		}else{
			if(month<10){
				monthstr="0"+Integer.toString(month);
			}else{
				monthstr=Integer.toString(month);
			}
		}
		String daystr="";
		if(day==null || day==0){
			daystr="01";
		}else{
			if(day<10){
				daystr="0"+Integer.toString(day);
			}else{
				daystr=Integer.toString(day);
			}
		}
		return new FDateTime(Integer.toString(year)+"-"+monthstr+"-"+daystr+" 00:00:00");
	}
	
	/**
	 * 获得日期时间对应的时间对象
	 * @param dt
	 * @return
	 */
	public static FTime getFTime8Dt(FDateTime dt){
		if(dt==null)return null;
		return dt.getUFTime();
	}
	
	/**
	 * 获得日期时间所在周的周次串
	 * @param dt
	 * @return
	 */
	public static String getWeekNoStr4Dt(FDateTime dt){
		if(dt==null)return null;
		return Integer.toString(dt.getWeek());
	}
	
	/**
	 * 获取时间区间之间相差的天数
	 * @param b
	 * @param e
	 * @return
	 * @throws CiOrDataUtilNullException
	 * @author xuxing2016-09-13（由于系统的getDaysAfter：相隔时间满24小时才返回相差一天）
	 */
	public static int getDaysBetweenInterval(FDateTime b,FDateTime e)
	{
		if (b==null||e==null) {
			return -1;
		}
		
		return e.getBeginDate().getDaysAfter(b.getBeginDate());
	}
	
	/***
	 * 取时间两者小者
	 * 
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static FDateTime getMinDT(FDateTime dt1, FDateTime dt2) {
		if(dt1 == null) return dt2;
		if(dt2 == null) return dt1;
		long days = dt1.getMillisAfter(dt2);
		if (days >= 0)
			return dt2;
		return dt1;
	}

	/***
	 * 取时间两者大者
	 * 
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static FDateTime getMaxDT(FDateTime dt1, FDateTime dt2) {
		if(dt2 == null)	return dt1;
		if(dt1 == null) return dt2;
		if(dt1.before(dt2)){
			return dt2;
		}
		return dt1;
	}

	/***
	 * 根据传入的时间区间获得实际有效时间区间
	 * 
	 * @param effectiveDTs
	 *            有效的开始结束时间区间
	 * @param inputDTs
	 *            查询或分析的开始结束区间
	 * @return
	 */
	public static FDateTime[] getValidStartEndDT(FDateTime[] effectiveDTs, FDateTime[] inputDTs) {
		FDateTime[] rtns = new FDateTime[2];
		rtns[0] = getMaxDT(effectiveDTs[0], inputDTs[0]);
		rtns[1] = getMinDT(effectiveDTs[1], inputDTs[1]);
		if (isDtValidate(rtns))
			return rtns;
		return null;
	}
	
	/***
	 * 区间时间有效性校验
	 * 
	 * @param dts
	 * @return
	 */
	public static boolean isDtValidate(FDateTime[] dts) {
		return isDtValidate(dts[0], dts[1]);
	}
	
	/***
	 * 区间时间有效性校验
	 * 
	 * @param dtstart
	 * @param dtend
	 * @return
	 */
	public static boolean isDtValidate(FDateTime dtstart, FDateTime dtend) {
		if (dtstart == null || dtend == null)
			return true;
		long days = dtend.getMillisAfter(dtstart);
		if (days >= 0)
			return true;
		return false;
	}
	
	/**
	 * 计算停止时间（已使用）
	 * @param statTime
	 * @param usedays
	 * @return
	 */
	public static FDateTime GetEndDateTime(FDateTime statTime, int usedays) {
		if (statTime == null || usedays == 0)
			return null;

		return statTime.getDateTimeAfter(usedays);
	}

	/**
	 * 开始时间默认赋值规则
	 * @param id_ent
	 * @param ipLoginDt
	 * @return
	 * @throws BizException 
	 */
	public static FDateTime GetEffeDateTime(String id_ent,FDateTime ipLoginDt) throws BizException{
		String effeparam=SysParamUtils.getSysParam().getSYS_PARAM_IpOrdDtEentryDefaultSet().getOrgParam();
		FDateTime dt_effe=CiOrdAppUtils.getServerDateTime();
		
		if(ObjectUtils.isEmpty(effeparam))return CiOrdAppUtils.getServerDateTime();
		switch(effeparam){

		case ICiOrdNSysParamConst.PARAM_IPORDDTEENTRYDEFAULTSET_CUR:
			//当【开始时间默认赋值规则】 = 0 当前时间 , 医嘱默认开始时间=当前系统时间
			return dt_effe.addSeconds(2);
		case ICiOrdNSysParamConst.PARAM_IPORDDTEENTRYDEFAULTSET_SET:
			//当【开始时间默认赋值规则】 =1配置时间 , 医嘱默认开始时间 = 当天日期 + 【开始时间默认配置时间】。
			String defTime=SysParamUtils.getSysParam().getSYS_PARAM_IpOrdDtEentryDefaultTime().getOrgParam();//开始时间默认配置时间
			if(ObjectUtils.isEmpty(defTime))return dt_effe;
			String datetime=dt_effe.getDate().toString()+" "+defTime;
			return new FDateTime(datetime);
		case ICiOrdNSysParamConst.PARAM_IPORDDTEENTRYDEFAULTSET_FRONT:
			//当【开始时间默认赋值规则】 =2上条时间 , 以一次医生站打开为一个区间,若在该区间内，没有新开医嘱时，新开的第一条医嘱，开始时间默认为当前系统时间,再次新开一条医嘱时，医嘱的默认开始时间 = 最新修改的开立医嘱的开始时间
			Object obj=getNextOrdDtEntry(id_ent,ipLoginDt);
			if(obj!=null) return new FDateTime(((Map<String, Object>)obj).get("dt_effe").toString());
			return dt_effe;
		}
		return null;
	}
	
	private static Object getNextOrdDtEntry(String id_ent,FDateTime ipLoginDt) throws BizException{
		String wherestr=String.format("select ord.dt_effe from ci_order ord where ord.id_en = '%s'  and ord.dt_entry > '%s'  and rownum = 1 order by ord.code_or desc",id_ent,ipLoginDt);
		return new DAFacade().execQuery(wherestr, new MapHandler());
	}
	
	/**
	 * 获得日期对应年月日数据信息
	 * 
	 * @param dt
	 * @return
	 */
	public static int[] getDateYMD(FDate dt) {
		if (dt == null)
			return null;
		int year = dt.getYear();
		int month = dt.getMonth();
		int day = dt.getDay();
		return new int[] { year, month, day };
	}

	/**
	 * 获得日期对应年月日数据信息
	 * 
	 * @param dt
	 * @return
	 */
	public static int[] getDateYMD(FDateTime dt) {
		if (dt == null)
			return null;
		int year = dt.getYear();
		int month = dt.getMonth();
		int day = dt.getDay();
		return new int[] { year, month, day };
	}

	
	/**
	 * 
	 * @param dt_birth
	 * @param CutoutMode
	 *            天进位方式： 0 截去天数据 1 天数不空按月计 2 四舍五入
	 * @return
	 * @throws BizException
	 */
	public static int getAgeMonth(FDate dt_birth, int iDayCutoutMode)
			throws BizException {
		int[] ymd = getAgeYMDInfo(dt_birth);
		int month = 12 * ymd[0] + ymd[1];

		if (ymd[2] == 0)
			return month;
		if (iDayCutoutMode == 0)
			return month;
		if (iDayCutoutMode == 1 && ymd[2] > 0)
			return month + 1;
		double d = (ymd[2] * 1.0) / 30.0;
		return month + (int) (Math.round(d));
	}

	/**
	 * 获得年月日年龄数据信息 年、月、日数组信息
	 * 
	 * @param dt_birth
	 * @return
	 * @throws BizException
	 */
	public static int[] getAgeYMDInfo(FDate dt_birth) throws BizException {
		if (dt_birth == null)
			return null;
		FDateTime sysDate = CiOrdAppUtils.getServerDateTime();
		int[] sysYMD = getDateYMD(sysDate);
		int[] birthYMD = getDateYMD(dt_birth);
		int[] ymd = substractYMD(sysYMD, birthYMD);
		return ageAbsHandle(ymd);
	}

	/**
	 * 数组减法运算 年月日
	 * 
	 * @param sysYMD
	 * @param birthYMD
	 * @return
	 */
	private static int[] substractYMD(int[] sysYMD, int[] birthYMD) {
		int[] rtn = new int[3];
		rtn[0] = sysYMD[0] - birthYMD[0];
		rtn[1] = sysYMD[1] - birthYMD[1];
		rtn[2] = sysYMD[2] - birthYMD[2];
		return rtn;
	}

	/**
	 * 获得进制后的岁月日数组数据
	 * 
	 * @param ymd
	 * @return
	 * @throws BizException
	 */
	private static int[] ageAbsHandle(int[] ymd) throws BizException {
		int[] rtn = new int[3];
		int years = ymd[0];
		int months = ymd[1];
		int days = ymd[2];
		if (days < 0) {
			rtn[2] = 30 + days;
			months = months - 1;
		} else {
			rtn[2] = days;
		}

		if (months < 0) {
			rtn[1] = 12 + months;
			years = years - 1;
		} else {
			rtn[1] = months;
		}

		rtn[0] = years;
		if (years < 0) {
			throw new BizException("年龄计算时，出生日期不能大于系统时间！");
		}

		return rtn;
	}

}
