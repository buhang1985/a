package iih.bl.cc.ebs.erp;

import java.util.Calendar;

import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * erp sql条件帮助类
 * @author ly
 *
 */
public class ErpSqlCondHelper {

	/**
	 * 取得前一天开始
	 * @return
	 */
	public static String getLastDateBegin(){
		return new FDate().getDateBefore(1).toString() + " 00:00:00";
	}
	
	/**
	 * 取得前一天结束
	 * @return
	 */
	public static String getLastDateEnd(){
		return new FDate().getDateBefore(1).toString() + " 23:59:59";
	}
	/**
	 * 取得当前日期
	 * @return
	 */	
	public static String getCurrentDateBefore(){
		return new FDate().getDateBefore(1).toString();
	}	
}
