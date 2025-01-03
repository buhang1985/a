package iih.pe.pwf.dto.persthistdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检历史检查结果 DTO数据 
 * 
 */
public class PeRstHistDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 上次体检时间
	 * @return String
	 */
	public String getDt_pe_1() {
		return ((String) getAttrVal("Dt_pe_1"));
	}
	/**
	 * 上次体检时间
	 * @param DT_PE_1
	 */
	public void setDt_pe_1(String Dt_pe_1) {
		setAttrVal("Dt_pe_1", Dt_pe_1);
	}
	/**
	 * 上上次体检时间
	 * @return String
	 */
	public String getDt_pe_2() {
		return ((String) getAttrVal("Dt_pe_2"));
	}
	/**
	 * 上上次体检时间
	 * @param DT_PE_2
	 */
	public void setDt_pe_2(String Dt_pe_2) {
		setAttrVal("Dt_pe_2", Dt_pe_2);
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
	 * 所属科室ID
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}
	/**
	 * 所属科室ID
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 所属科室父ID
	 * @return String
	 */
	public String getId_pedeptset_par() {
		return ((String) getAttrVal("Id_pedeptset_par"));
	}
	/**
	 * 所属科室父ID
	 * @param Id_pedeptset_par
	 */
	public void setId_pedeptset_par(String Id_pedeptset_par) {
		setAttrVal("Id_pedeptset_par", Id_pedeptset_par);
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
	 * 本次结果
	 * @return String
	 */
	public String getRst_0() {
		return ((String) getAttrVal("Rst_0"));
	}
	/**
	 * 本次结果
	 * @param Rst_0
	 */
	public void setRst_0(String Rst_0) {
		setAttrVal("Rst_0", Rst_0);
	}
	/**
	 * 前一次结果
	 * @return String
	 */
	public String getRst_1() {
		return ((String) getAttrVal("Rst_1"));
	}
	/**
	 * 前一次结果
	 * @param Rst_1
	 */
	public void setRst_1(String Rst_1) {
		setAttrVal("Rst_1", Rst_1);
	}
	/**
	 * 前两次结果
	 * @return String
	 */
	public String getRst_2() {
		return ((String) getAttrVal("Rst_2"));
	}
	/**
	 * 前两次结果
	 * @param Rst_2
	 */
	public void setRst_2(String Rst_2) {
		setAttrVal("Rst_2", Rst_2);
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
}