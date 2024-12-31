package iih.en.comm.util;

import iih.en.comm.validator.EnValidator;

import java.text.SimpleDateFormat;
import java.util.Date;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 日期时间帮助类
 * @author yank
 *
 */
public class DateTimeUtils {
	/**
	 * 是否已经过去
	 * @param time 日期时间
	 * @return
	 */
	public static boolean isPast(FDateTime time){
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		return currentTime.before(time);
	}
	/**
	 * 是否是今天
	 * @param time
	 * @return
	 */
	public static boolean isToday(FDateTime time){
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		return currentTime.getDate().isSameDate(time.getDate());
	}
	/**
	 * 是否是今天
	 * @param date
	 * @return
	 */
	public static boolean isToday(FDate date){
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		return currentTime.getDate().isSameDate(date);
	}
	/**
	 * 日期转换(String转为FDate)
	 * 
	 * @param dateStr
	 * @return
	 * @throws BizException
	 */
	public static FDate convertToFDate(String dateStr) throws BizException{
		try{
			if(EnValidator.isEmpty(dateStr))
				return null;
			return new FDate(dateStr);
		}catch(Exception e){
			throw new BizException("日期转换出错，格式必须为：yyyy-MM-dd");
		}
	}
	/**
	 * 取得当前时间字符串格式,带毫秒
	 * @return
	 */
	public static String getNow(){
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		return format.format(date);
	}
	/**
	 *两个FDateTime类型变量,算时差,结果为字符串:"xx小时xx分钟"
	 * @return
	 */
	public static String getTimeLength(FDateTime start,FDateTime end){
		if(start == null || end == null)
			return null;
		int time_different = FDateTime.getMinutesBetween(start, end);//结果为分钟
	    int hour = time_different / 60;
		int minute = time_different % 60;
		String dtstatus = hour+"小时"+minute+"分钟";
		return dtstatus;
	}
}
