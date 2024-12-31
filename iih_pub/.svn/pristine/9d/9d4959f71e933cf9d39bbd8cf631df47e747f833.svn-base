package iih.bd.base.utils;

import xap.lui.core.cluster.XapCluster;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 应用帮助类
 * 
 * @author yankan
 *
 */
public class AppUtils {
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
		return ts.getUFDateTime().getDate().asLocalBegin();
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
	 * 获取拼音码 TODO 后续框架提供支持
	 * 
	 * @param name 名称
	 * @return
	 */
	public static String getPyCode(String name) {
		String py = CnToPy.getPyFirstCode(name);
		return py;
	}

	/**
	 * 获取五笔码 TODO 后续框架提供支持
	 * 
	 * @param name 名称
	 * @return
	 */
	public static String getWbCode(String name) {
		String wb = CnToWB.getWBCode(name);
		return wb;
	}

	/**
	 * 获取指定小时前的服务器时间
	 * 
	 * @param hours 小时数
	 * @return
	 */
	public static FDateTime getFDateTimeBeforeHours(Integer hours) {
		return getServerDateTime().addSeconds(hours * 60 * 60 * -1);
	}

	/**
	 * 获取服务器IP
	 * 
	 * @return
	 */
	public static String getHostIp() {
		String ip = XapCluster.getHostIp();
		if (org.apache.commons.lang.StringUtils.isNotBlank(ip)) {
			ip = ip.replace("-", ".");
		}
		return ip;
	}
}
