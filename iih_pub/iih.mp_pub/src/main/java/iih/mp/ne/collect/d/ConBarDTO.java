package iih.mp.ne.collect.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本采集条件Bar DTO数据 
 * 
 */
public class ConBarDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getBegindate() {
		return ((FDate) getAttrVal("Begindate"));
	}
	/**
	 * 开始日期
	 * @param Begindate
	 */
	public void setBegindate(FDate Begindate) {
		setAttrVal("Begindate", Begindate);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getEnddate() {
		return ((FDate) getAttrVal("Enddate"));
	}
	/**
	 * 结束日期
	 * @param Enddate
	 */
	public void setEnddate(FDate Enddate) {
		setAttrVal("Enddate", Enddate);
	}
	/**
	 * 条码扫描区
	 * @return String
	 */
	public String getNobar() {
		return ((String) getAttrVal("Nobar"));
	}
	/**
	 * 条码扫描区
	 * @param Nobar
	 */
	public void setNobar(String Nobar) {
		setAttrVal("Nobar", Nobar);
	}
}