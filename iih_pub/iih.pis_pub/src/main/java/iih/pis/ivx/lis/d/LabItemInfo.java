package iih.pis.ivx.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验报告项目信息 DTO数据 
 * 
 */
public class LabItemInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检验指标代码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 检验指标代码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 报告项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 报告项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}
	/**
	 * 序号
	 * @param Orderno
	 */
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	/**
	 * 检验结果值
	 * @return String
	 */
	public String getVal_rptlab() {
		return ((String) getAttrVal("Val_rptlab"));
	}
	/**
	 * 检验结果值
	 * @param Val_rptlab
	 */
	public void setVal_rptlab(String Val_rptlab) {
		setAttrVal("Val_rptlab", Val_rptlab);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 参考值范围
	 * @return String
	 */
	public String getVal_range() {
		return ((String) getAttrVal("Val_range"));
	}
	/**
	 * 参考值范围
	 * @param Val_range
	 */
	public void setVal_range(String Val_range) {
		setAttrVal("Val_range", Val_range);
	}
	/**
	 * 报告时间
	 * @return String
	 */
	public String getDt_rpt() {
		return ((String) getAttrVal("Dt_rpt"));
	}
	/**
	 * 报告时间
	 * @param Dt_rpt
	 */
	public void setDt_rpt(String Dt_rpt) {
		setAttrVal("Dt_rpt", Dt_rpt);
	}
}