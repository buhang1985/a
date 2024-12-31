package iih.nm.Utils;

import java.util.Calendar;
import java.util.Date;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;

/**
 * 日期辅助类
 * 
 * @author lijm
 *
 */
public class NmDateUtil {

	/**
	 * 获取当前周周一日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrWeekMonday(Date date) throws BizException {
		if (date == null) {
			throw new BizException("当前日期获取失败，无法计算当前周周一日期！");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 获得当前日期是一个星期的第几天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		return cal.getTime();
	}
}
