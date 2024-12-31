package iih.hp.cp.app.qry.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 查询条件 DTO数据 
 * 
 */
public class QueryParamsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 计划所属类型
	 * @return String
	 */
	public String getEu_owtp() {
		return ((String) getAttrVal("Eu_owtp"));
	}
	/**
	 * 计划所属类型
	 * @param Eu_owtp
	 */
	public void setEu_owtp(String Eu_owtp) {
		setAttrVal("Eu_owtp", Eu_owtp);
	}
	/**
	 * 可用范围类型
	 * @return String
	 */
	public String getEu_enbltp() {
		return ((String) getAttrVal("Eu_enbltp"));
	}
	/**
	 * 可用范围类型
	 * @param Eu_enbltp
	 */
	public void setEu_enbltp(String Eu_enbltp) {
		setAttrVal("Eu_enbltp", Eu_enbltp);
	}
	/**
	 * 适用科室id
	 * @return String
	 */
	public String getId_apply_dep() {
		return ((String) getAttrVal("Id_apply_dep"));
	}
	/**
	 * 适用科室id
	 * @param Id_apply_dep
	 */
	public void setId_apply_dep(String Id_apply_dep) {
		setAttrVal("Id_apply_dep", Id_apply_dep);
	}
	/**
	 * 路径名称
	 * @return String
	 */
	public String getName_cp() {
		return ((String) getAttrVal("Name_cp"));
	}
	/**
	 * 路径名称
	 * @param Name_cp
	 */
	public void setName_cp(String Name_cp) {
		setAttrVal("Name_cp", Name_cp);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 就诊科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 就诊科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 就诊科室编码
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}
	/**
	 * 就诊科室编码
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	/**
	 * 就诊科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 就诊科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 在院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 在院标识
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 患者入径起始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_enter_start() {
		return ((FDateTime) getAttrVal("Dt_enter_start"));
	}
	/**
	 * 患者入径起始时间
	 * @param Dt_enter_start
	 */
	public void setDt_enter_start(FDateTime Dt_enter_start) {
		setAttrVal("Dt_enter_start", Dt_enter_start);
	}
	/**
	 * 患者入径截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_enter_end() {
		return ((FDateTime) getAttrVal("Dt_enter_end"));
	}
	/**
	 * 患者入径截止时间
	 * @param Dt_enter_end
	 */
	public void setDt_enter_end(FDateTime Dt_enter_end) {
		setAttrVal("Dt_enter_end", Dt_enter_end);
	}
}