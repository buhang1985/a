package iih.ci.ord.dto.quanfirstdaymprst.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 计算首日执行次数返回值 DTO数据 
 * 
 */
public class QuanFirstDayMpRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 首日执行次数
	 * @return Integer
	 */
	public Integer getQuan_firday_mp() {
		return ((Integer) getAttrVal("Quan_firday_mp"));
	}
	/**
	 * 首日执行次数
	 * @param Quan_firday_mp
	 */
	public void setQuan_firday_mp(Integer Quan_firday_mp) {
		setAttrVal("Quan_firday_mp", Quan_firday_mp);
	}
	/**
	 * 最大首日执行次数
	 * @return Integer
	 */
	public Integer getMax_times() {
		return ((Integer) getAttrVal("Max_times"));
	}
	/**
	 * 最大首日执行次数
	 * @param Max_times
	 */
	public void setMax_times(Integer Max_times) {
		setAttrVal("Max_times", Max_times);
	}
	/**
	 * 首日执行时刻
	 * @return String
	 */
	public String getWorktime() {
		return ((String) getAttrVal("Worktime"));
	}
	/**
	 * 首日执行时刻
	 * @param Worktime
	 */
	public void setWorktime(String Worktime) {
		setAttrVal("Worktime", Worktime);
	}
}