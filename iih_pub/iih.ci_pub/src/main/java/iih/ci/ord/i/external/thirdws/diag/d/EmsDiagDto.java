package iih.ci.ord.i.external.thirdws.diag.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方诊断入参 DTO数据 
 * 
 */
public class EmsDiagDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开立医生编码
	 * @return String
	 */
	public String getCode_emp_create() {
		return ((String) getAttrVal("Code_emp_create"));
	}
	/**
	 * 开立医生编码
	 * @param Code_emp_create
	 */
	public void setCode_emp_create(String Code_emp_create) {
		setAttrVal("Code_emp_create", Code_emp_create);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getCode_dep_create() {
		return ((String) getAttrVal("Code_dep_create"));
	}
	/**
	 * 开立科室
	 * @param Code_dep_create
	 */
	public void setCode_dep_create(String Code_dep_create) {
		setAttrVal("Code_dep_create", Code_dep_create);
	}
	/**
	 * 开立时间
	 * @return String
	 */
	public String getDt_create() {
		return ((String) getAttrVal("Dt_create"));
	}
	/**
	 * 开立时间
	 * @param Dt_create
	 */
	public void setDt_create(String Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	 * 疾病诊断诊断编码
	 * @return String
	 */
	public String getCode_didef() {
		return ((String) getAttrVal("Code_didef"));
	}
	/**
	 * 疾病诊断诊断编码
	 * @param Code_didef
	 */
	public void setCode_didef(String Code_didef) {
		setAttrVal("Code_didef", Code_didef);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}
	/**
	 * 诊断名称
	 * @param Name_didef
	 */
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
	/**
	 * 证候诊断编码
	 * @return String
	 */
	public String getCode_didef_syn() {
		return ((String) getAttrVal("Code_didef_syn"));
	}
	/**
	 * 证候诊断编码
	 * @param Code_didef_syn
	 */
	public void setCode_didef_syn(String Code_didef_syn) {
		setAttrVal("Code_didef_syn", Code_didef_syn);
	}
	/**
	 * 证候诊断名称
	 * @return String
	 */
	public String getName_didef_syn() {
		return ((String) getAttrVal("Name_didef_syn"));
	}
	/**
	 * 证候诊断名称
	 * @param Name_didef_syn
	 */
	public void setName_didef_syn(String Name_didef_syn) {
		setAttrVal("Name_didef_syn", Name_didef_syn);
	}
	/**
	 * 主要诊断标识
	 * @return String
	 */
	public String getFg_majdi() {
		return ((String) getAttrVal("Fg_majdi"));
	}
	/**
	 * 主要诊断标识
	 * @param Fg_majdi
	 */
	public void setFg_majdi(String Fg_majdi) {
		setAttrVal("Fg_majdi", Fg_majdi);
	}
	/**
	 * 疑似诊断标识
	 * @return String
	 */
	public String getFg_suspdi() {
		return ((String) getAttrVal("Fg_suspdi"));
	}
	/**
	 * 疑似诊断标识
	 * @param Fg_suspdi
	 */
	public void setFg_suspdi(String Fg_suspdi) {
		setAttrVal("Fg_suspdi", Fg_suspdi);
	}
	/**
	 * 传染病标识
	 * @return String
	 */
	public String getFg_infedi() {
		return ((String) getAttrVal("Fg_infedi"));
	}
	/**
	 * 传染病标识
	 * @param Fg_infedi
	 */
	public void setFg_infedi(String Fg_infedi) {
		setAttrVal("Fg_infedi", Fg_infedi);
	}
	/**
	 * 父诊断序号
	 * @return String
	 */
	public String getSortno_parent() {
		return ((String) getAttrVal("Sortno_parent"));
	}
	/**
	 * 父诊断序号
	 * @param Sortno_parent
	 */
	public void setSortno_parent(String Sortno_parent) {
		setAttrVal("Sortno_parent", Sortno_parent);
	}
	/**
	 * 补充说明
	 * @return String
	 */
	public String getSupplement() {
		return ((String) getAttrVal("Supplement"));
	}
	/**
	 * 补充说明
	 * @param Supplement
	 */
	public void setSupplement(String Supplement) {
		setAttrVal("Supplement", Supplement);
	}
	/**
	 * 自定义诊断标识
	 * @return String
	 */
	public String getFg_self() {
		return ((String) getAttrVal("Fg_self"));
	}
	/**
	 * 自定义诊断标识
	 * @param Fg_self
	 */
	public void setFg_self(String Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 上报标识
	 * @return String
	 */
	public String getFg_ur() {
		return ((String) getAttrVal("Fg_ur"));
	}
	/**
	 * 上报标识
	 * @param Fg_ur
	 */
	public void setFg_ur(String Fg_ur) {
		setAttrVal("Fg_ur", Fg_ur);
	}
	/**
	 * 慢性病标志
	 * @return String
	 */
	public String getFg_chronic() {
		return ((String) getAttrVal("Fg_chronic"));
	}
	/**
	 * 慢性病标志
	 * @param Fg_chronic
	 */
	public void setFg_chronic(String Fg_chronic) {
		setAttrVal("Fg_chronic", Fg_chronic);
	}
	/**
	 * 特种病标志
	 * @return String
	 */
	public String getFg_special() {
		return ((String) getAttrVal("Fg_special"));
	}
	/**
	 * 特种病标志
	 * @param Fg_special
	 */
	public void setFg_special(String Fg_special) {
		setAttrVal("Fg_special", Fg_special);
	}
	/**
	 * 保外诊断标识
	 * @return String
	 */
	public String getEu_hpbeyond() {
		return ((String) getAttrVal("Eu_hpbeyond"));
	}
	/**
	 * 保外诊断标识
	 * @param Eu_hpbeyond
	 */
	public void setEu_hpbeyond(String Eu_hpbeyond) {
		setAttrVal("Eu_hpbeyond", Eu_hpbeyond);
	}
	/**
	 * 传染病种类编码
	 * @return String
	 */
	public String getSd_infectiontp() {
		return ((String) getAttrVal("Sd_infectiontp"));
	}
	/**
	 * 传染病种类编码
	 * @param Sd_infectiontp
	 */
	public void setSd_infectiontp(String Sd_infectiontp) {
		setAttrVal("Sd_infectiontp", Sd_infectiontp);
	}
}