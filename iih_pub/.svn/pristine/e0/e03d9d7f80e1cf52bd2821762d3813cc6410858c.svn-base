package iih.mm.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

public class MmDateUtil {

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
	 * 将FDateTime转为普通Calendar类型
	 * 舍掉毫秒
	 * @param dateTime
	 * @return
	 */
	public static Calendar changeToCalendar(FDateTime dateTime){
		
		if(dateTime == null)
			return null;
		
		return new GregorianCalendar(dateTime.getYear(), dateTime.getMonth() - 1 , dateTime.getDaysMonth(),
				dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond());
	}
	
	/**
	 * 将FDateTime转为普通Calendar类型
	 * 舍掉毫秒
	 * @param dateTime
	 * @return
	 */
	public static Date changeToSqlDate(FDateTime dateTime){
		
		if(dateTime == null)
			return null;
		
		return new Date(dateTime.getMillis());
	}
	
	/**
	 * 将FDate转为普通Date类型
	 * @param dateTime
	 * @return
	 */
	public static Date changeToSqlDate(FDate dateTime){
		
		if(dateTime == null)
			return null;
		
		return new Date(dateTime.getMillis());
	}
	
	/**
	 * 将FDate转为普通Calendar类型
	 * @param dateTime
	 * @return
	 */
	public static Calendar changeToCalendar(FDate date){
		
		if(date == null)
			return null;
		
		return new GregorianCalendar(date.getYear(), date.getMonth() - 1 , date.getDaysMonth());
	}
	
	/**
	 * FDateTime toString
	 * @param dateTime
	 * @return
	 */
	public static String toString(FDateTime dateTime){
		
		if(dateTime == null)
			return null;
		return dateTime.toString();
	}
	
	/**
	 * 查询模版日期格式条件添加后缀
	 * @param dateStr 查询条件
	 * @param isBegin 是否开始日期
	 * @return
	 * @throws BizException
	 */
	public static String FormatDate(String dateStr,boolean isBegin) {	
		String reg = "";
		if(isBegin)
			reg =  ">= '\\d{4}-\\d{2}-\\d{2}";
		else
			reg =  "<= '\\d{4}-\\d{2}-\\d{2}";

		
		String[] arr = dateStr.split(reg);
		Pattern pat = Pattern.compile(reg);
		Matcher matcher = pat.matcher(dateStr);
		List<String> words = new ArrayList<String>();
		while (matcher.find()) {
			String temp = dateStr.substring(matcher.start(), matcher.end());
			words.add(temp);
		}
		List<String> newWords = new ArrayList<String>();
		for (String word : words) {
			matcher = pat.matcher(word);
			while (matcher.find()) {
				String temp = word.substring(matcher.start(), matcher.end());
				if(isBegin)
					word = word.replaceAll(temp, temp + " 00:00:00");
				else
					word = word.replaceAll(temp, temp + " 23:59:59");
				newWords.add(word);
			}
		}
		String formats = "";
		for (int i = 0; i < arr.length; i++) {
			formats = formats + arr[i];
			if (i != arr.length - 1) {
				formats = formats + newWords.get(i);
			}
		}
		return formats;
	}
	
	public static String toString(FDate dateTime){
		if(dateTime == null)
			return null;
		return dateTime.toString();
	}

	/**
	 * 转换时间格式  输出标准格式 yyyy-MM-dd hh:mm:ss
	 * @param time
	 * @return
	 */
	public static String changeTimeFormat(String time){
		try {
			FDateTime t = new FDateTime(time);
			return t.toString();
		} catch (Exception e) {
			return null;
		}
	}
}
