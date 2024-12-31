package iih.bd.srv.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊诊断字典DTO DTO数据 
 * 
 */
public class IEOpDiagDictDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE门诊诊断字典主键标识
	 * @return String
	 */
	public String getId_ieopdiagdict() {
		return ((String) getAttrVal("Id_ieopdiagdict"));
	}
	/**
	 * IE门诊诊断字典主键标识
	 * @param Id_ieopdiagdict
	 */
	public void setId_ieopdiagdict(String Id_ieopdiagdict) {
		setAttrVal("Id_ieopdiagdict", Id_ieopdiagdict);
	}
	/**
	 * 操作类型
	 * @return String
	 */
	public String getAction() {
		return ((String) getAttrVal("Action"));
	}
	/**
	 * 操作类型
	 * @param Action
	 */
	public void setAction(String Action) {
		setAttrVal("Action", Action);
	}
	/**
	 * 门诊诊断编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 门诊诊断编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 门诊诊断名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 门诊诊断名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getIcd_code() {
		return ((String) getAttrVal("Icd_code"));
	}
	/**
	 * 诊断编码
	 * @param Icd_code
	 */
	public void setIcd_code(String Icd_code) {
		setAttrVal("Icd_code", Icd_code);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}
	/**
	 * 拼音码
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getDept_sn() {
		return ((String) getAttrVal("Dept_sn"));
	}
	/**
	 * 科室
	 * @param Dept_sn
	 */
	public void setDept_sn(String Dept_sn) {
		setAttrVal("Dept_sn", Dept_sn);
	}
	/**
	 * 系统id
	 * @return String
	 */
	public String getSubsys_id() {
		return ((String) getAttrVal("Subsys_id"));
	}
	/**
	 * 系统id
	 * @param Subsys_id
	 */
	public void setSubsys_id(String Subsys_id) {
		setAttrVal("Subsys_id", Subsys_id);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getDoctor_sn() {
		return ((String) getAttrVal("Doctor_sn"));
	}
	/**
	 * 医生编码
	 * @param Doctor_sn
	 */
	public void setDoctor_sn(String Doctor_sn) {
		setAttrVal("Doctor_sn", Doctor_sn);
	}
	/**
	 * 用户分组
	 * @return String
	 */
	public String getShare_flag() {
		return ((String) getAttrVal("Share_flag"));
	}
	/**
	 * 用户分组
	 * @param Share_flag
	 */
	public void setShare_flag(String Share_flag) {
		setAttrVal("Share_flag", Share_flag);
	}
	/**
	 * 分组标记
	 * @return String
	 */
	public String getSeparate_flag() {
		return ((String) getAttrVal("Separate_flag"));
	}
	/**
	 * 分组标记
	 * @param Separate_flag
	 */
	public void setSeparate_flag(String Separate_flag) {
		setAttrVal("Separate_flag", Separate_flag);
	}
	/**
	 * 慢性病标记
	 * @return String
	 */
	public String getMxb_flag() {
		return ((String) getAttrVal("Mxb_flag"));
	}
	/**
	 * 慢性病标记
	 * @param Mxb_flag
	 */
	public void setMxb_flag(String Mxb_flag) {
		setAttrVal("Mxb_flag", Mxb_flag);
	}
	/**
	 * 特种病标记
	 * @return String
	 */
	public String getTzb_flag() {
		return ((String) getAttrVal("Tzb_flag"));
	}
	/**
	 * 特种病标记
	 * @param Tzb_flag
	 */
	public void setTzb_flag(String Tzb_flag) {
		setAttrVal("Tzb_flag", Tzb_flag);
	}
	/**
	 * 传染病标记
	 * @return String
	 */
	public String getContagion_flag() {
		return ((String) getAttrVal("Contagion_flag"));
	}
	/**
	 * 传染病标记
	 * @param Contagion_flag
	 */
	public void setContagion_flag(String Contagion_flag) {
		setAttrVal("Contagion_flag", Contagion_flag);
	}
	/**
	 * 类别
	 * @return String
	 */
	public String getClass_code() {
		return ((String) getAttrVal("Class_code"));
	}
	/**
	 * 类别
	 * @param Class_code
	 */
	public void setClass_code(String Class_code) {
		setAttrVal("Class_code", Class_code);
	}
	/**
	 * 排序
	 * @return String
	 */
	public String getSort_order() {
		return ((String) getAttrVal("Sort_order"));
	}
	/**
	 * 排序
	 * @param Sort_order
	 */
	public void setSort_order(String Sort_order) {
		setAttrVal("Sort_order", Sort_order);
	}
	/**
	 * 原编码
	 * @return String
	 */
	public String getOld_code() {
		return ((String) getAttrVal("Old_code"));
	}
	/**
	 * 原编码
	 * @param Old_code
	 */
	public void setOld_code(String Old_code) {
		setAttrVal("Old_code", Old_code);
	}
	/**
	 * 原名称
	 * @return String
	 */
	public String getOld_name() {
		return ((String) getAttrVal("Old_name"));
	}
	/**
	 * 原名称
	 * @param Old_name
	 */
	public void setOld_name(String Old_name) {
		setAttrVal("Old_name", Old_name);
	}
	/**
	 * 专用分组
	 * @return String
	 */
	public String getSyx_flag() {
		return ((String) getAttrVal("Syx_flag"));
	}
	/**
	 * 专用分组
	 * @param Syx_flag
	 */
	public void setSyx_flag(String Syx_flag) {
		setAttrVal("Syx_flag", Syx_flag);
	}
	/**
	 * 对照ICD码
	 * @return String
	 */
	public String getOther_icd() {
		return ((String) getAttrVal("Other_icd"));
	}
	/**
	 * 对照ICD码
	 * @param Other_icd
	 */
	public void setOther_icd(String Other_icd) {
		setAttrVal("Other_icd", Other_icd);
	}
	/**
	 * 监听标识
	 * @return String
	 */
	public String getMonitor_flag() {
		return ((String) getAttrVal("Monitor_flag"));
	}
	/**
	 * 监听标识
	 * @param Monitor_flag
	 */
	public void setMonitor_flag(String Monitor_flag) {
		setAttrVal("Monitor_flag", Monitor_flag);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
}