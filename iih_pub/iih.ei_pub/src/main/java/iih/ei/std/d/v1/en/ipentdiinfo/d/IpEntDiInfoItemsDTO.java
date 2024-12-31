package iih.ei.std.d.v1.en.ipentdiinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊断dto DTO数据 
 * 
 */
public class IpEntDiInfoItemsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 编号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 编号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 诊断学科类型编码
	 * @return String
	 */
	public String getSd_cdsystp() {
		return ((String) getAttrVal("Sd_cdsystp"));
	}	
	/**
	 * 诊断学科类型编码
	 * @param Sd_cdsystp
	 */
	public void setSd_cdsystp(String Sd_cdsystp) {
		setAttrVal("Sd_cdsystp", Sd_cdsystp);
	}
	/**
	 * 诊断学科类型
	 * @return String
	 */
	public String getName_cdsystp() {
		return ((String) getAttrVal("Name_cdsystp"));
	}	
	/**
	 * 诊断学科类型
	 * @param Name_cdsystp
	 */
	public void setName_cdsystp(String Name_cdsystp) {
		setAttrVal("Name_cdsystp", Name_cdsystp);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_didef_dis() {
		return ((String) getAttrVal("Code_didef_dis"));
	}	
	/**
	 * 诊断编码
	 * @param Code_didef_dis
	 */
	public void setCode_didef_dis(String Code_didef_dis) {
		setAttrVal("Code_didef_dis", Code_didef_dis);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}	
	/**
	 * 诊断名称
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 诊断补充说明
	 * @return String
	 */
	public String getSupplement() {
		return ((String) getAttrVal("Supplement"));
	}	
	/**
	 * 诊断补充说明
	 * @param Supplement
	 */
	public void setSupplement(String Supplement) {
		setAttrVal("Supplement", Supplement);
	}
	/**
	 * 主要诊断标志
	 * @return FBoolean
	 */
	public FBoolean getFg_maj() {
		return ((FBoolean) getAttrVal("Fg_maj"));
	}	
	/**
	 * 主要诊断标志
	 * @param Fg_maj
	 */
	public void setFg_maj(FBoolean Fg_maj) {
		setAttrVal("Fg_maj", Fg_maj);
	}
	/**
	 * 诊断时间
	 * @return FDateTime
	 */
	public FDateTime getDt_diag() {
		return ((FDateTime) getAttrVal("Dt_diag"));
	}	
	/**
	 * 诊断时间
	 * @param Dt_diag
	 */
	public void setDt_diag(FDateTime Dt_diag) {
		setAttrVal("Dt_diag", Dt_diag);
	}
	/**
	 * 诊断医生编码
	 * @return String
	 */
	public String getCode_emp_phy() {
		return ((String) getAttrVal("Code_emp_phy"));
	}	
	/**
	 * 诊断医生编码
	 * @param Code_emp_phy
	 */
	public void setCode_emp_phy(String Code_emp_phy) {
		setAttrVal("Code_emp_phy", Code_emp_phy);
	}
	/**
	 * 诊断医生名称
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	/**
	 * 诊断医生名称
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 治愈标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cured() {
		return ((FBoolean) getAttrVal("Fg_cured"));
	}	
	/**
	 * 治愈标识
	 * @param Fg_cured
	 */
	public void setFg_cured(FBoolean Fg_cured) {
		setAttrVal("Fg_cured", Fg_cured);
	}
	/**
	 * 诊断过程状态编码
	 * @return String
	 */
	public String getSd_ditp() {
		return ((String) getAttrVal("Sd_ditp"));
	}	
	/**
	 * 诊断过程状态编码
	 * @param Sd_ditp
	 */
	public void setSd_ditp(String Sd_ditp) {
		setAttrVal("Sd_ditp", Sd_ditp);
	}
	/**
	 * 诊断过程名称
	 * @return String
	 */
	public String getName_ditp() {
		return ((String) getAttrVal("Name_ditp"));
	}	
	/**
	 * 诊断过程名称
	 * @param Name_ditp
	 */
	public void setName_ditp(String Name_ditp) {
		setAttrVal("Name_ditp", Name_ditp);
	}
	/**
	 * 疑似诊断标志
	 * @return FBoolean
	 */
	public FBoolean getFg_suspdi() {
		return ((FBoolean) getAttrVal("Fg_suspdi"));
	}	
	/**
	 * 疑似诊断标志
	 * @param Fg_suspdi
	 */
	public void setFg_suspdi(FBoolean Fg_suspdi) {
		setAttrVal("Fg_suspdi", Fg_suspdi);
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
	 * 诊断科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 诊断科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 诊断科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 诊断科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 自定义标识
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	/**
	 * 自定义标识
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 慢性病标志
	 * @return FBoolean
	 */
	public FBoolean getFg_chronic() {
		return ((FBoolean) getAttrVal("Fg_chronic"));
	}	
	/**
	 * 慢性病标志
	 * @param Fg_chronic
	 */
	public void setFg_chronic(FBoolean Fg_chronic) {
		setAttrVal("Fg_chronic", Fg_chronic);
	}
	/**
	 * 特种病标志
	 * @return FBoolean
	 */
	public FBoolean getFg_special() {
		return ((FBoolean) getAttrVal("Fg_special"));
	}	
	/**
	 * 特种病标志
	 * @param Fg_special
	 */
	public void setFg_special(FBoolean Fg_special) {
		setAttrVal("Fg_special", Fg_special);
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
	/**
	 * 传染病种类
	 * @return String
	 */
	public String getName_infectiontp() {
		return ((String) getAttrVal("Name_infectiontp"));
	}	
	/**
	 * 传染病种类
	 * @param Name_infectiontp
	 */
	public void setName_infectiontp(String Name_infectiontp) {
		setAttrVal("Name_infectiontp", Name_infectiontp);
	}
	/**
	 * 上报标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ur() {
		return ((FBoolean) getAttrVal("Fg_ur"));
	}	
	/**
	 * 上报标识
	 * @param Fg_ur
	 */
	public void setFg_ur(FBoolean Fg_ur) {
		setAttrVal("Fg_ur", Fg_ur);
	}
}