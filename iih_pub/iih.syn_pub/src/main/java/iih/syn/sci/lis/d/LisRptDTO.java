package iih.syn.sci.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验报告 DTO数据 
 * 
 */
public class LisRptDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 仪器编码
	 * @return String
	 */
	public String getSd_insmt() {
		return ((String) getAttrVal("Sd_insmt"));
	}
	/**
	 * 仪器编码
	 * @param Sd_insmt
	 */
	public void setSd_insmt(String Sd_insmt) {
		setAttrVal("Sd_insmt", Sd_insmt);
	}
	/**
	 * 仪器名称
	 * @return String
	 */
	public String getName_insmt() {
		return ((String) getAttrVal("Name_insmt"));
	}
	/**
	 * 仪器名称
	 * @param Name_insmt
	 */
	public void setName_insmt(String Name_insmt) {
		setAttrVal("Name_insmt", Name_insmt);
	}
	/**
	 * 报告时间
	 * @return String
	 */
	public String getDt_rptlab() {
		return ((String) getAttrVal("Dt_rptlab"));
	}
	/**
	 * 报告时间
	 * @param Dt_rptlab
	 */
	public void setDt_rptlab(String Dt_rptlab) {
		setAttrVal("Dt_rptlab", Dt_rptlab);
	}
	/**
	 * 报告人员编码
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}
	/**
	 * 报告人员编码
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	/**
	 * 报告科室
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 报告科室
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 报告项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 报告项目编码
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
	 * 检验结果值
	 * @return String
	 */
	public String getVal_rstrptlab() {
		return ((String) getAttrVal("Val_rstrptlab"));
	}
	/**
	 * 检验结果值
	 * @param Val_rstrptlab
	 */
	public void setVal_rstrptlab(String Val_rstrptlab) {
		setAttrVal("Val_rstrptlab", Val_rstrptlab);
	}
	/**
	 * 参考值范围
	 * @return String
	 */
	public String getVal_reference() {
		return ((String) getAttrVal("Val_reference"));
	}
	/**
	 * 参考值范围
	 * @param Val_reference
	 */
	public void setVal_reference(String Val_reference) {
		setAttrVal("Val_reference", Val_reference);
	}
	/**
	 * 最大值
	 * @return String
	 */
	public String getVal_max() {
		return ((String) getAttrVal("Val_max"));
	}
	/**
	 * 最大值
	 * @param Val_max
	 */
	public void setVal_max(String Val_max) {
		setAttrVal("Val_max", Val_max);
	}
	/**
	 * 最小值
	 * @return String
	 */
	public String getVal_min() {
		return ((String) getAttrVal("Val_min"));
	}
	/**
	 * 最小值
	 * @param Val_min
	 */
	public void setVal_min(String Val_min) {
		setAttrVal("Val_min", Val_min);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode_unit() {
		return ((String) getAttrVal("Code_unit"));
	}
	/**
	 * 单位编码
	 * @param Code_unit
	 */
	public void setCode_unit(String Code_unit) {
		setAttrVal("Code_unit", Code_unit);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 报告结果情况编码
	 * @return String
	 */
	public String getCode_deviate() {
		return ((String) getAttrVal("Code_deviate"));
	}
	/**
	 * 报告结果情况编码
	 * @param Code_deviate
	 */
	public void setCode_deviate(String Code_deviate) {
		setAttrVal("Code_deviate", Code_deviate);
	}
	/**
	 * 报告结果情况
	 * @return String
	 */
	public String getName_deviate() {
		return ((String) getAttrVal("Name_deviate"));
	}
	/**
	 * 报告结果情况
	 * @param Name_deviate
	 */
	public void setName_deviate(String Name_deviate) {
		setAttrVal("Name_deviate", Name_deviate);
	}
	/**
	 * 危急值标志
	 * @return String
	 */
	public String getFg_crisis() {
		return ((String) getAttrVal("Fg_crisis"));
	}
	/**
	 * 危急值标志
	 * @param Fg_crisis
	 */
	public void setFg_crisis(String Fg_crisis) {
		setAttrVal("Fg_crisis", Fg_crisis);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getPrintord() {
		return ((Integer) getAttrVal("Printord"));
	}
	/**
	 * 序号
	 * @param Printord
	 */
	public void setPrintord(Integer Printord) {
		setAttrVal("Printord", Printord);
	}
	/**
	 * 报告号
	 * @return String
	 */
	public String getNo_rptlab() {
		return ((String) getAttrVal("No_rptlab"));
	}
	/**
	 * 报告号
	 * @param No_rptlab
	 */
	public void setNo_rptlab(String No_rptlab) {
		setAttrVal("No_rptlab", No_rptlab);
	}
	/**
	 * 完成时间
	 * @return String
	 */
	public String getFinishtime() {
		return ((String) getAttrVal("Finishtime"));
	}
	/**
	 * 完成时间
	 * @param Finishtime
	 */
	public void setFinishtime(String Finishtime) {
		setAttrVal("Finishtime", Finishtime);
	}
}