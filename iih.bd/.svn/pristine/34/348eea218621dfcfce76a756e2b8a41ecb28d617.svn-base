package iih.bd.base.util;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 应用帮助类
 * @author yankan
 *
 */
public class AppUtils {
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	public static FDateTime getServerDateTime(){
		TimeService ts = ServiceFinder.find(TimeService.class);
		return  ts.getUFDateTime();
	}
	/***
	 * 获得服务器日期
	 * @return
	 */
	public static FDate getServerDate(){
		TimeService ts = ServiceFinder.find(TimeService.class);
		return  ts.getUFDateTime().getDate().asLocalBegin();
	}
	/**
	 * 根据日期和时间获取日期时间类型
	 * @param date 日期
	 * @param time 时间
	 * @return
	 */
	public static FDateTime getFDateTime(FDate date,FTime time){
		return new FDateTime(date.asLocalBegin(),time);
	}
	
	/**
	 * 获取拼音码
	 * TODO 后续框架提供支持
	 * @param name 名称
	 * @return
	 */
	public static String getPyCode(String name){
		String py=CnToPy.getPyFirstCode(name);
		return py;
	}
	/**
	 * 获取五笔码
	 * TODO 后续框架提供支持
	 * @param name 名称
	 * @return
	 */
	public static String getWbCode(String name){
		String wb=CnToWB.getWBCode(name);
		return wb;
	}	
}
