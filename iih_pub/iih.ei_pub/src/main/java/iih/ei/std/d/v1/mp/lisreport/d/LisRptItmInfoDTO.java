package iih.ei.std.d.v1.mp.lisreport.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验报告明细项目信息 DTO数据 
 * 
 */
public class LisRptItmInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检验项目代码
	 * @return String
	 */
	public String getCode_srv_itm() {
		return ((String) getAttrVal("Code_srv_itm"));
	}	
	/**
	 * 检验项目代码
	 * @param Code_srv_itm
	 */
	public void setCode_srv_itm(String Code_srv_itm) {
		setAttrVal("Code_srv_itm", Code_srv_itm);
	}
	/**
	 * 检验项目名称
	 * @return String
	 */
	public String getName_srv_itm() {
		return ((String) getAttrVal("Name_srv_itm"));
	}	
	/**
	 * 检验项目名称
	 * @param Name_srv_itm
	 */
	public void setName_srv_itm(String Name_srv_itm) {
		setAttrVal("Name_srv_itm", Name_srv_itm);
	}
	/**
	 * 检验结果值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}	
	/**
	 * 检验结果值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 检验结果值单位
	 * @return String
	 */
	public String getUnit_value() {
		return ((String) getAttrVal("Unit_value"));
	}	
	/**
	 * 检验结果值单位
	 * @param Unit_value
	 */
	public void setUnit_value(String Unit_value) {
		setAttrVal("Unit_value", Unit_value);
	}
	/**
	 * 参考范围
	 * @return String
	 */
	public String getReference() {
		return ((String) getAttrVal("Reference"));
	}	
	/**
	 * 参考范围
	 * @param Reference
	 */
	public void setReference(String Reference) {
		setAttrVal("Reference", Reference);
	}
	/**
	 * 危急值标记
	 * @return String
	 */
	public String getFg_crisis() {
		return ((String) getAttrVal("Fg_crisis"));
	}	
	/**
	 * 危急值标记
	 * @param Fg_crisis
	 */
	public void setFg_crisis(String Fg_crisis) {
		setAttrVal("Fg_crisis", Fg_crisis);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 报告状态编码
	 * @return String
	 */
	public String getSta_report() {
		return ((String) getAttrVal("Sta_report"));
	}	
	/**
	 * 报告状态编码
	 * @param Sta_report
	 */
	public void setSta_report(String Sta_report) {
		setAttrVal("Sta_report", Sta_report);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 最大值
	 * @return String
	 */
	public String getMaxvalue() {
		return ((String) getAttrVal("Maxvalue"));
	}	
	/**
	 * 最大值
	 * @param Maxvalue
	 */
	public void setMaxvalue(String Maxvalue) {
		setAttrVal("Maxvalue", Maxvalue);
	}
	/**
	 * 最小值
	 * @return String
	 */
	public String getMinvalue() {
		return ((String) getAttrVal("Minvalue"));
	}	
	/**
	 * 最小值
	 * @param Minvalue
	 */
	public void setMinvalue(String Minvalue) {
		setAttrVal("Minvalue", Minvalue);
	}
}