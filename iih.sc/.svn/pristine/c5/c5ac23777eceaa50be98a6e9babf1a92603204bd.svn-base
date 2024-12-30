package iih.sc.comm;

import java.text.SimpleDateFormat;
import java.util.Date;

import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;

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
		FDateTime currentTime = ScAppUtils.getServerDateTime();
		return currentTime.before(time);
	}
	/**
	 * 是否是今天
	 * @param time
	 * @return
	 */
	public static boolean isToday(FDateTime time){
		FDateTime currentTime = ScAppUtils.getServerDateTime();
		return currentTime.getDate().isSameDate(time.getDate());
	}
	/**
	 * 是否是今天
	 * @param date
	 * @return
	 */
	public static boolean isToday(FDate date){
		FDateTime currentTime = ScAppUtils.getServerDateTime();
		return currentTime.getDate().isSameDate(date);
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
	 * 获取两个时间之间的分钟数
	 * 
	 * @author liubin
	 * 
	 * @param t_b
	 * @param t_e
	 * @return
	 */
	public static int getMins(FTime t_b, FTime t_e){
		if(t_b == null || t_e == null || t_b.after(t_e))
			return 0;
		int mins = 60 * (t_e.getHour() - t_b.getHour()) + (t_e.getMinute() - t_b.getMinute());
		return mins < 0 ? 0 : mins;
	}
	/**
	 * 判断两个日期时间是否有交际 
	 * @param t_b
	 * @param t_e
	 * @param t_b_r
	 * @param t_e_r
	 * @return
	 * @auther yaohl
	 * @date 2018年12月14日
	 */
	public static Boolean isMixedFDateTime(FDateTime t_b,FDateTime t_e,FDateTime t_b_r,FDateTime t_e_r){
		if (t_b == null || t_e == null || t_b_r == null || t_e_r == null)
			return false;
		if (t_b.compareTo(t_e_r) >= 0 || t_e.compareTo(t_b_r) <= 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * 根据分钟数返回 小时:分钟:00
	 * @param mins
	 * @return
	 */
	public static FTime getFTime(int mins){
		if(mins <= 0) return new FTime("00:00:00");
        int hours = (int) Math.floor(mins / 60);
        int minutes = mins % 60;
        String hour = "";
        String minute = "";
        if(hours < 10){
        	hour = "0"+hours;
        }else{
        	hour += hours;
        }
        if(minutes < 10){
        	minute = "0"+minutes;
        }else{
        	minute += minutes;
        }
        return new FTime(hour + ":"+minute+":00");
	}
}
