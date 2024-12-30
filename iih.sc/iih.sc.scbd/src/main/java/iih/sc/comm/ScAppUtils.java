package iih.sc.comm;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.sc.scbd.schedulesrv.d.ScSrvKindItm;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 应用帮助类
 * 
 * @author yankan
 * 
 */
public class ScAppUtils {
	/***
	 * 获得服务器日期时间
	 * 
	 * @return
	 */
	public static FDateTime getServerDateTime() {
		TimeService ts = ServiceFinder.find(TimeService.class);
		return ts.getUFDateTime();
	}

	/***
	 * 获得服务器日期
	 * 
	 * @return
	 */
	public static FDate getServerDate() {
		TimeService ts = ServiceFinder.find(TimeService.class);
		return new FDate (ts.getUFDateTime().toLocalString());
	}

	/**
	 * 根据日期和时间获取日期时间类型
	 * 
	 * @param date 日期
	 * @param time 时间
	 * @return
	 */
	public static FDateTime getFDateTime(FDate date, FTime time) {
		return new FDateTime(date.asLocalBegin(), time);
	}

	/**
	 * FTime 增加和减去 相关秒
	 * 
	 * @param fTime 目标FTime
	 * @param seconds 需要变更秒
	 * @return changeFTime 变更后的
	 */
	public static FTime addSecondsByFTime(FTime targetFTime, Integer seconds) {
		if (targetFTime == null || seconds == null || seconds == 0)
			return targetFTime;
		Long millisecond = targetFTime.getMillis(); // 毫秒数
		Long changeMillis = Long.valueOf(seconds * 1000);
		FTime changeFTime = new FTime(millisecond + changeMillis);
		return changeFTime;
	}

	/**
	 * FTime类型增加或减少指定分钟
	 *
	 * @param targetFTime 目标时间
	 * @param minutes 分钟增量
	 * @return 增量后的时间
	 * @author zhengcm
	 */
	public static FTime addMinutesByFTime(FTime targetFTime, Integer minutes) {
		if (targetFTime == null || minutes == null || minutes == 0) {
			return targetFTime;
		}
		Long millisecond = targetFTime.getMillis(); // 毫秒数
		Long changeMillis = Long.valueOf(minutes * 60 * 1000);
		FTime changeFTime = new FTime(millisecond + changeMillis);
		return changeFTime;
	}

	/**
	 * 时间+秒
	 * 
	 * @param c
	 * @param parameterDate
	 * @param addNUm
	 * @return
	 */
	public static Date addSecond(Calendar c, Date parameterDate, Integer addNUm) {
		c.setTime(parameterDate);
		c.add(Calendar.SECOND, addNUm);
		return c.getTime();
	}

	/**
	 * 获得当前周一的日期
	 * 
	 * @return
	 */
	public static String getMondayPlus() {
		FDate date = new FDate();
		int week = date.getWeek();
		FDate changeDate;
		if (week == 0) {
			// 周日特殊处理
			changeDate = date.getDateBefore(6);
		} else {
			changeDate = date.getDateBefore(week - 1);
		}
		return changeDate.toString();
	}

	/**
	 * 返回特定日期周一的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getMondayPlus(String date) {
		FDate date2 = new FDate(date);
		int week = date2.getWeek();
		FDate changeDate;
		if (week == 0) {
			// 周日特殊处理
			changeDate = date2.getDateBefore(6);
		} else {
			changeDate = date2.getDateBefore(week - 1);
		}
		return changeDate.toString();
	}

	/**
	 * 给定的参数日期往后算7天
	 * 
	 * @param bdate
	 * @return
	 */
	public static String[] getSevenDays(String bdate) {
		String[] days = new String[7];
		for (int i = 0; i < 7; i++) {
			days[i] = new FDate(bdate).getDateAfter(i).toString();
		}
		return days;
	}

	/**
	 * 获取指定日期所在一周内所有日期Arrays
	 * 
	 * @param fDate 指定日期
	 * @return
	 */
	public static String[] getOneWeekDateByTargetDate(String fDate) {
		if (StringUtils.isBlank(fDate))
			return null;
		String monday = getMondayPlus(fDate);
		return getSevenDays(monday);
	}

	/**
	 * 日期转星期数
	 * 
	 * @param c
	 * @param strDate
	 * @return
	 */
	public static String getWeek(String strDate) {
		int weekday = new FDate(strDate).getWeek();
		String retStr = "";
		switch (weekday) {
		case 0:
			retStr = "星期日";
			break;
		case 1:
			retStr = "星期一";
			break;
		case 2:
			retStr = "星期二";
			break;
		case 3:
			retStr = "星期三";
			break;
		case 4:
			retStr = "星期四";
			break;
		case 5:
			retStr = "星期五";
			break;
		case 6:
			retStr = "星期六";
			break;
		}
		return retStr;
	}

	/**
	 * 判断排班是否过期
	 * 
	 * @param bespeakDate 排班日期
	 * @return
	 */
	public static Boolean timeOverdue(FDate bespeakDate) {
		FDate currentDate = new FDate();
		if (bespeakDate.after(currentDate) || bespeakDate.isSameDate(currentDate)) {
			return Boolean.FALSE;
		} else if (bespeakDate.beforeDate(currentDate)) {
			return Boolean.TRUE;
		}
		return null;
	}

	/**
	 * 获取月份
	 * 
	 * @param c
	 * @param dateTime 参数日期时间
	 * @return
	 */
	public static String getMonth(String dateTime) {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
		Date someDate = null;
		try {
			someDate = dfs.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		FDate date = new FDate(someDate);
		String monthDay = date.getMonth() + "月" + date.getDay() + "日";
		return monthDay;
	}

	/**
	 * 时间+分钟数
	 * 
	 * @param c
	 * @param parameterDate
	 * @param addNUm
	 * @return
	 */
	public static Date addMinis(Calendar c, Date parameterDate, Integer addNUm) {
		c.setTime(parameterDate);
		c.add(Calendar.MINUTE, addNUm);
		return c.getTime();
	}

	/**
	 * 计算出生日期
	 * 
	 * @param event
	 * @throws ParseException
	 */
	public static String getAge(String date) {
		return AgeCalcUtil.getAge(new FDate(date));
	}

	/**
	 * 返回来个日期之前所有日期
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static String[] allDateBetween(FDate beginDate, FDate endDate) {
		int days = FDate.getDaysBetween(beginDate, endDate);
		List<String> list = new LinkedList<String>();
		for (int i = 0; i <= days; i++) {
			list.add(beginDate.getDateAfter(i).toString());
		}
		return list.toArray(new String[list.size()]);
	}

	/**
	 * 当前时间能否预约该日期分组
	 * 
	 * @param id_dayslot 日期分组id
	 * @return true 没有过时 false 过时
	 */
	public static FBoolean timeOver(String id_dayslot) {
		IDayslotMDORService dayslotMDORService = ServiceFinder.find(IDayslotMDORService.class);
		DaysLotDO daysLotDO = null;
		try {
			daysLotDO = dayslotMDORService.findById(id_dayslot);
		} catch (BizException e) {
			e.printStackTrace();
		}
		FTime currentTime = new FTime();
		// 当前时间在日期分组时间之内
		if ((currentTime.after(daysLotDO.getTime_begin()) && currentTime.before(daysLotDO
				.getTime_end())) || currentTime.before(daysLotDO.getTime_begin())) {
			return FBoolean.TRUE;
		} else {
			return FBoolean.FALSE;
		}
	}

	/**
	 * 排班日期是否过期
	 * 
	 * @param id_sch 排班id
	 * @return FBoolean true 过期 false 没过期
	 */
	public static FBoolean schDateIsOver(String id_sch) {
		IScschMDORService mdorService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = null;
		try {
			schDO = mdorService.findById(id_sch);
		} catch (BizException e) {
			e.printStackTrace();
		}
		FDate currentDate = new FDate(); // 当前日期
		if (currentDate.after(schDO.getD_sch())) {
			// 排班过时
			//PopDialog.showMessageDialog(IScMsgConst.SC_SCH_DATE_IS_OVER);
			return FBoolean.TRUE;
		} else if (currentDate.isSameDate(schDO.getD_sch())) {
			if (!timeOver(schDO.getId_dayslot()).booleanValue()) {
				//PopDialog.showMessageDialog(IScMsgConst.SC_SCH_DATE_IS_OVER);
				return FBoolean.TRUE;
			}
		}
		return FBoolean.FALSE;
	}

	/**
	 * 获取两个日期相差月数
	 * 
	 * @param beginCalendar 开始 日期 Calendar
	 * @param endCalendar 结束日期 Calendar
	 * @return
	 */
	public static int getDifferMonth(Calendar beginCalendar, Calendar endCalendar) {
		int begin_year = beginCalendar.get(Calendar.YEAR);
		int begin_month = beginCalendar.get(Calendar.MONTH);
		int end_year = endCalendar.get(Calendar.YEAR);
		int end_month = endCalendar.get(Calendar.MONTH);
		int result; // 相差月数
		if (begin_year == end_year) {
			result = end_month - begin_month;
		} else {
			result = 12 * (end_year - begin_year) + end_month - begin_month;
		}
		return result;
	}

	/**
	 * 判断两个时间段是否有交集
	 * 
	 * @param t_b
	 * @param t_e
	 * @param t_b_r
	 * @param t_e_r
	 * @return
	 */
	public static Boolean isMixedFTime(FTime t_b, FTime t_e, FTime t_b_r, FTime t_e_r) {
		if (t_b == null || t_e == null || t_b_r == null || t_e_r == null)
			return false;
		if (t_b.compareTo(t_e_r) >= 0 || t_e.compareTo(t_b_r) <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * 判断两个时间Ｂ是否包含Ａ
	 * 
	 * @param t_b
	 * @param t_e
	 * @param t_b_r
	 * @param t_e_r
	 * @return
	 */
	public static Boolean isContainFTime(FTime t_b, FTime t_e, FTime t_b_r, FTime t_e_r) {
		if (t_b == null || t_e == null || t_b_r == null || t_e_r == null)
			return false;
		if (t_b.compareTo(t_b_r) >= 0 && t_e.compareTo(t_e_r) <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断以“，”隔开的attrA和attrB是否包含重复的数据
	 * 
	 * @param attrA
	 * @param attrB
	 * @return
	 */
	public static Boolean isContainRepeat(String attrA, String attrB) {
		String[] attrAs = attrA.split(",");
		String[] attrBs = attrB.split(",");
		for (String attrAo : attrAs) {
			for (String attrBo : attrBs) {
				if (attrAo.equals(attrBo))
					return false;
			}
		}
		return true;
	}

	/**
	 * 截取FTiem类型 返回时分
	 * 
	 * @param FTime 时间类型
	 * @return 只有时分 没有秒 类型
	 */
	public static String subFTime(String FTime) {
		return FTime.substring(0, 5);

	}

	/**
	 * 在一周时间段内找到与源日期相同星期数的日期
	 * 
	 * @param oldDate 源日期
	 * @param targetDates 目标时间段
	 * @return
	 */
	public static String getSameWeekDate(FDate oldFDate, String[] targetDates) {
		if (oldFDate == null || ArrayUtils.isEmpty(targetDates))
			return null;
		int oldWeek = oldFDate.getWeek();
		for (String date : targetDates) {
			if (new FDate(date).getWeek() == oldWeek) {
				return date;
			}
		}
		return null;
	}

	/**
	 * 计算指定日期几天后的日期
	 * 
	 * @param date
	 * @param day
	 * @return
	 * @author zhengcm
	 */
	public static String getDateAfter(String date, int day) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar newDate = Calendar.getInstance();
		try {
			Date oldDate = df.parse(date);
			newDate.setTime(oldDate);
			newDate.set(Calendar.DATE, newDate.get(Calendar.DATE) + day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return df.format(newDate.getTime());
	}

	/**
	 * 根据日期获取该日期的星期一
	 * 
	 * @param fDate
	 * @return
	 */
	public static FDate GetFirstDateOfWeek(FDate fDate) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(fDate.toDate());
		ca.add(Calendar.DATE, (2 - ca.get(Calendar.DAY_OF_WEEK)));
		return new FDate(ca.getTime());
	}

	/**
	 * 根据日期获取该日期的星期日
	 * 
	 * @param fDate
	 * @return
	 */
	public static FDate GetLastDateOfWeek(FDate fDate) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(fDate.toDate());
		ca.add(Calendar.DATE, (8 - ca.get(Calendar.DAY_OF_WEEK)));
		return new FDate(ca.getTime());
	}

	/**
	 * DO集合转FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static FArrayList doArray2List(BaseDO... dos) {
		if (ScValidator.isNullOrEmpty(dos))
			return null;
		FArrayList list = new FArrayList();
		for (BaseDO d : dos)
			list.add(d);
		return list;
	}

	/**
	 * AggDO集合转FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static FArrayList aggDoArray2List(BaseAggDO... dos) {
		if (ScValidator.isNullOrEmpty(dos))
			return null;
		FArrayList list = new FArrayList();
		for (BaseAggDO d : dos)
			list.add(d);
		return list;
	}

	/**
	 * Object集合转FArrayList
	 * 
	 * @param objs
	 * @return
	 */
	public static FArrayList objArray2List(Object... objs) {
		if (ScValidator.isNullOrEmpty(objs))
			return null;
		FArrayList list = new FArrayList();
		for (Object obj : objs)
			list.add(obj);
		return list;
	}
	/**
	 * 用以将数组中的数据根据一个key值分组,key值对应的list是需要的数据,暂时只支持字符串
	 * @param keyFieldName
	 * @param valFieldName
	 * @param objs
	 * @author yzh
	 * @return
	 */
	public static Map<String,List<String>> extractStrMapFromObjs(String keyFieldName,String valFieldName,BaseDO[] objs){
		Map<String,List<String>> resultMap = new HashMap<String,List<String>>();
		for (BaseDO obj : objs) {
			if (resultMap.containsKey((String)obj.getAttrVal(keyFieldName))) {
				resultMap.get((String)obj.getAttrVal(keyFieldName)).add((String)obj.getAttrVal(valFieldName));
			}else{
				List<String> list = new ArrayList<String>();
				list.add((String)obj.getAttrVal(valFieldName));
				resultMap.put((String)obj.getAttrVal(keyFieldName), list);
			}
		}
		return resultMap;
	}
	/**
	 * 用以将数组中的数据根据一个key值分组,key值对应的list是需要的数据,暂时只支持字符串
	 * @param keyFieldName
	 * @param valFieldName
	 * @param objs
	 * @author yzh
	 * @return
	 */
	public static Map<String,String> extractStrMapFromObjs(String keyFieldName,String valFieldName,BaseDO[] objs,String schKindItms){
		Map<String,String> resultMap = new HashMap<String,String>();
		for (BaseDO obj : objs) {
			String val = "";
			if(StringUtils.isEmpty(schKindItms))
			{
				resultMap.put((String)obj.getAttrVal(keyFieldName), (String)obj.getAttrVal(valFieldName));
				continue;
			}
			
			if(obj.getAttrVal(valFieldName) != null){
				if(schKindItms.indexOf((String)obj.getAttrVal(valFieldName))<0){//需要释放的类别明细不在集合中增加
					val = (String)obj.getAttrVal(valFieldName);
				}
			}
			resultMap.put((String)obj.getAttrVal(keyFieldName), val);
		}
		return resultMap;
	}
	/**
	 * 用以将数组中的数据根据一个key值分组
	 * @param keyFieldName
	 * @param valFieldName
	 * @param objs
	 * @author yzh
	 * @return
	 */
	public static Map<String,List<BaseDO>> extractObjMapFromObjs(String keyFieldName,BaseDO[] objs){
		Map<String,List<BaseDO>> resultMap = new HashMap<String,List<BaseDO>>();
		for (BaseDO obj : objs) {
			if (resultMap.containsKey((String)obj.getAttrVal(keyFieldName))) {
				resultMap.get((String)obj.getAttrVal(keyFieldName)).add(obj);
			}else{
				List<BaseDO> list = new ArrayList<BaseDO>();
				list.add(obj);
				resultMap.put((String)obj.getAttrVal(keyFieldName), list);
			}
		}
		return resultMap;
	}
	
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		return false;
	}
	public static boolean isEmpty(FDateTime obj) {
		if (obj == null)
			return true;
		return false;
	}
	public static boolean isEmpty(FDouble obj) {
		if (obj == null)
			return true;
		return false;
	}
	public static boolean isEmpty(Object[] objs) {
		if (objs == null || objs.length <= 0)
			return true;
		return false;
	}
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Hashtable obj) {
		if (obj == null || obj.size() <= 0)
			return true;
		return false;
	}
	public static boolean isEmpty(FArrayList2 obj) {
		if(obj == null || obj.size() <=0) {
			return true;
		}
		return false;
	}
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(ArrayList obj) {
		if(obj == null || obj.size() <=0) {
			return true;
		}
		return false;
	}
	public static boolean isEmpty(String input) {
		return StringUtils.isBlank(input);
	}
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List obj) {
		if(obj == null || obj.size() <=0) {
			return true;
		}
		return false;
	}
}
