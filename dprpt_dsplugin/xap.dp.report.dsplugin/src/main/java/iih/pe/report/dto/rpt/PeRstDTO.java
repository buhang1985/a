package iih.pe.report.dto.rpt;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检检查结果列表 DTO数据 
 * 
 */
public class PeRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检时间
	 * @return String
	 */
	public String getDt_pe() {
		return ((String) getAttrVal("Dt_pe"));
	}
	/**
	 * 体检时间
	 * @param Dt_pe
	 */
	public void setDt_pe(String Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}
	/**
	 * 体检项目ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}
	/**
	 * 体检结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 体检结果主键标识
	 * @return String
	 */
	public String getId_perst() {
		return ((String) getAttrVal("Id_perst"));
	}
	/**
	 * 体检结果主键标识
	 * @param Id_perst
	 */
	public void setId_perst(String Id_perst) {
		setAttrVal("Id_perst", Id_perst);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}
	/**
	 * 所属科室
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 科室状态
	 * @return Integer
	 */
	public Integer getDepst() {
		return ((Integer) getAttrVal("Depst"));
	}
	/**
	 * 科室状态
	 * @param Depst
	 */
	public void setDepst(Integer Depst) {
		setAttrVal("Depst", Depst);
	}
	/**
	 * 体检项目名称
	 * @return String
	 */
	public String getName_catlog() {
		return ((String) getAttrVal("Name_catlog"));
	}
	/**
	 * 体检项目名称
	 * @param Name_catlog
	 */
	public void setName_catlog(String Name_catlog) {
		setAttrVal("Name_catlog", Name_catlog);
	}
	/**
	 * 体检结果名称
	 * @return String
	 */
	public String getName_item() {
		return ((String) getAttrVal("Name_item"));
	}
	/**
	 * 体检结果名称
	 * @param Name_item
	 */
	public void setName_item(String Name_item) {
		setAttrVal("Name_item", Name_item);
	}
	/**
	 * 检查结果状态
	 * @return Integer
	 */
	public Integer getPeitemstatus() {
		return ((Integer) getAttrVal("Peitemstatus"));
	}
	/**
	 * 检查结果状态
	 * @param Peitemstatus
	 */
	public void setPeitemstatus(Integer Peitemstatus) {
		setAttrVal("Peitemstatus", Peitemstatus);
	}
	/**
	 * 检查结果内容
	 * @return String
	 */
	public String getRst() {
		return ((String) getAttrVal("Rst"));
	}
	/**
	 * 检查结果内容
	 * @param Rst
	 */
	public void setRst(String Rst) {
		setAttrVal("Rst", Rst);
	}
	/**
	 * 检查描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 检查描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 参考范围
	 * @return String
	 */
	public String getRef() {
		return ((String) getAttrVal("Ref"));
	}
	/**
	 * 参考范围
	 * @param Ref
	 */
	public void setRef(String Ref) {
		setAttrVal("Ref", Ref);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}
	/**
	 * 计量单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 异常标识符号
	 * @return String
	 */
	public String getMark() {
		return ((String) getAttrVal("Mark"));
	}
	/**
	 * 异常标识符号
	 * @param Mark
	 */
	public void setMark(String Mark) {
		setAttrVal("Mark", Mark);
	}
	/**
	 * 异常标识
	 * @return FBoolean
	 */
	public FBoolean getFg_abn() {
		return ((FBoolean) getAttrVal("Fg_abn"));
	}
	/**
	 * 异常标识
	 * @param Fg_abn
	 */
	public void setFg_abn(FBoolean Fg_abn) {
		setAttrVal("Fg_abn", Fg_abn);
	}
	/**
	 * 阳性标识
	 * @return FBoolean
	 */
	public FBoolean getFg_posi() {
		return ((FBoolean) getAttrVal("Fg_posi"));
	}
	/**
	 * 阳性标识
	 * @param Fg_posi
	 */
	public void setFg_posi(FBoolean Fg_posi) {
		setAttrVal("Fg_posi", Fg_posi);
	}
	/**
	 * 录入护士
	 * @return String
	 */
	public String getEmp_nur() {
		return ((String) getAttrVal("Emp_nur"));
	}
	/**
	 * 录入护士
	 * @param Emp_nur
	 */
	public void setEmp_nur(String Emp_nur) {
		setAttrVal("Emp_nur", Emp_nur);
	}
	/**
	 * 录入科室
	 * @return String
	 */
	public String getDep_nur() {
		return ((String) getAttrVal("Dep_nur"));
	}
	/**
	 * 录入科室
	 * @param Dep_nur
	 */
	public void setDep_nur(String Dep_nur) {
		setAttrVal("Dep_nur", Dep_nur);
	}
	/**
	 * 录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_nur() {
		return ((FDateTime) getAttrVal("Dt_nur"));
	}
	/**
	 * 录入时间
	 * @param Dt_nur
	 */
	public void setDt_nur(FDateTime Dt_nur) {
		setAttrVal("Dt_nur", Dt_nur);
	}
	/**
	 * 检查医生
	 * @return String
	 */
	public String getEmp_doc() {
		return ((String) getAttrVal("Emp_doc"));
	}
	/**
	 * 检查医生
	 * @param Emp_doc
	 */
	public void setEmp_doc(String Emp_doc) {
		setAttrVal("Emp_doc", Emp_doc);
	}
	/**
	 * 检查医生姓名
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}
	/**
	 * 检查医生姓名
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	/**
	 * 检查科室
	 * @return String
	 */
	public String getDep_doc() {
		return ((String) getAttrVal("Dep_doc"));
	}
	/**
	 * 检查科室
	 * @param Dep_doc
	 */
	public void setDep_doc(String Dep_doc) {
		setAttrVal("Dep_doc", Dep_doc);
	}
	/**
	 * 检查时间
	 * @return FDateTime
	 */
	public FDateTime getDt_doc() {
		return ((FDateTime) getAttrVal("Dt_doc"));
	}
	/**
	 * 检查时间
	 * @param Dt_doc
	 */
	public void setDt_doc(FDateTime Dt_doc) {
		setAttrVal("Dt_doc", Dt_doc);
	}
	/**
	 * 正异常判断规则
	 * @return String
	 */
	public String getId_ruleref() {
		return ((String) getAttrVal("Id_ruleref"));
	}
	/**
	 * 正异常判断规则
	 * @param Id_ruleref
	 */
	public void setId_ruleref(String Id_ruleref) {
		setAttrVal("Id_ruleref", Id_ruleref);
	}
	/**
	 * 数据合法性规则
	 * @return String
	 */
	public String getId_rulelegal() {
		return ((String) getAttrVal("Id_rulelegal"));
	}
	/**
	 * 数据合法性规则
	 * @param Id_rulelegal
	 */
	public void setId_rulelegal(String Id_rulelegal) {
		setAttrVal("Id_rulelegal", Id_rulelegal);
	}
	/**
	 * 所属目录
	 * @return Integer
	 */
	public Integer getCatlog() {
		return ((Integer) getAttrVal("Catlog"));
	}
	/**
	 * 所属目录
	 * @param Catlog
	 */
	public void setCatlog(Integer Catlog) {
		setAttrVal("Catlog", Catlog);
	}
	/**
	 * 检查医生编码
	 * @return String
	 */
	public String getSd_doc() {
		return ((String) getAttrVal("Sd_doc"));
	}
	/**
	 * 检查医生编码
	 * @param Sd_doc
	 */
	public void setSd_doc(String Sd_doc) {
		setAttrVal("Sd_doc", Sd_doc);
	}
}