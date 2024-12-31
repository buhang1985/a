package iih.mp.nr.hdvrcd.dto;

import xap.mw.core.data.BaseDTO;

/**
 * 交班报告汇总DTO DTO数据 
 * 
 */
public class HdvRcdSumDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 汇总id
	 * @return String
	 */
	public String getId_hdv_sum() {
		return ((String) getAttrVal("Id_hdv_sum"));
	}
	/**
	 * 汇总id
	 * @param Id_hdv_sum
	 */
	public void setId_hdv_sum(String Id_hdv_sum) {
		setAttrVal("Id_hdv_sum", Id_hdv_sum);
	}
	/**
	 * 交接班id
	 * @return String
	 */
	public String getId_hdv() {
		return ((String) getAttrVal("Id_hdv"));
	}
	/**
	 * 交接班id
	 * @param Id_hdv
	 */
	public void setId_hdv(String Id_hdv) {
		setAttrVal("Id_hdv", Id_hdv);
	}
	/**
	 * 指标id
	 * @return String
	 */
	public String getId_tagt() {
		return ((String) getAttrVal("Id_tagt"));
	}
	/**
	 * 指标id
	 * @param Id_tagt
	 */
	public void setId_tagt(String Id_tagt) {
		setAttrVal("Id_tagt", Id_tagt);
	}
	/**
	 * 指标名称
	 * @return String
	 */
	public String getName_tagt() {
		return ((String) getAttrVal("Name_tagt"));
	}
	/**
	 * 指标名称
	 * @param Name_tagt
	 */
	public void setName_tagt(String Name_tagt) {
		setAttrVal("Name_tagt", Name_tagt);
	}
	/**
	 * 实际数量
	 * @return Integer
	 */
	public Integer getVal() {
		return ((Integer) getAttrVal("Val"));
	}
	/**
	 * 实际数量
	 * @param Val
	 */
	public void setVal(Integer Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 系统计算值
	 * @return Integer
	 */
	public Integer getVal_auto() {
		return ((Integer) getAttrVal("Val_auto"));
	}
	/**
	 * 系统计算值
	 * @param Val_auto
	 */
	public void setVal_auto(Integer Val_auto) {
		setAttrVal("Val_auto", Val_auto);
	}
}