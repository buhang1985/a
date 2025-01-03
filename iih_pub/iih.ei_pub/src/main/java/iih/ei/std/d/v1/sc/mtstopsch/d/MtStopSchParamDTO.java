package iih.ei.std.d.v1.sc.mtstopsch.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技停诊列表入参 DTO数据 
 * 
 */
public class MtStopSchParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDate_begin() {
		return ((FDate) getAttrVal("Date_begin"));
	}	
	/**
	 * 开始日期
	 * @param Date_begin
	 */
	public void setDate_begin(FDate Date_begin) {
		setAttrVal("Date_begin", Date_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDate_end() {
		return ((FDate) getAttrVal("Date_end"));
	}	
	/**
	 * 结束日期
	 * @param Date_end
	 */
	public void setDate_end(FDate Date_end) {
		setAttrVal("Date_end", Date_end);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public FArrayList getPageinfo() {
		return ((FArrayList) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(FArrayList Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}