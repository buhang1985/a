package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 通用补费中就诊记录 DTO数据 
 * 
 */
public class EntRecrodDTO extends BaseDTO {
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
	 * 患者分类id
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者分类id
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 患者分类名称
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 就诊挂号日期
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}
	/**
	 * 就诊挂号日期
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 就诊科室id
	 * @return String
	 */
	public String getId_ent_dep() {
		return ((String) getAttrVal("Id_ent_dep"));
	}
	/**
	 * 就诊科室id
	 * @param Id_ent_dep
	 */
	public void setId_ent_dep(String Id_ent_dep) {
		setAttrVal("Id_ent_dep", Id_ent_dep);
	}
	/**
	 * 就诊科室名称
	 * @return String
	 */
	public String getName_entdep() {
		return ((String) getAttrVal("Name_entdep"));
	}
	/**
	 * 就诊科室名称
	 * @param Name_entdep
	 */
	public void setName_entdep(String Name_entdep) {
		setAttrVal("Name_entdep", Name_entdep);
	}
	/**
	 * 接诊医生id
	 * @return String
	 */
	public String getId_doctor() {
		return ((String) getAttrVal("Id_doctor"));
	}
	/**
	 * 接诊医生id
	 * @param Id_doctor
	 */
	public void setId_doctor(String Id_doctor) {
		setAttrVal("Id_doctor", Id_doctor);
	}
	/**
	 * 接诊医生名称
	 * @return String
	 */
	public String getName_doctor() {
		return ((String) getAttrVal("Name_doctor"));
	}
	/**
	 * 接诊医生名称
	 * @param Name_doctor
	 */
	public void setName_doctor(String Name_doctor) {
		setAttrVal("Name_doctor", Name_doctor);
	}
	/**
	 * 主诊断编码
	 * @return String
	 */
	public String getCode_dis_major() {
		return ((String) getAttrVal("Code_dis_major"));
	}
	/**
	 * 主诊断编码
	 * @param Code_dis_major
	 */
	public void setCode_dis_major(String Code_dis_major) {
		setAttrVal("Code_dis_major", Code_dis_major);
	}
	/**
	 * 主诊断名称
	 * @return String
	 */
	public String getName_dis_major() {
		return ((String) getAttrVal("Name_dis_major"));
	}
	/**
	 * 主诊断名称
	 * @param Name_dis_major
	 */
	public void setName_dis_major(String Name_dis_major) {
		setAttrVal("Name_dis_major", Name_dis_major);
	}
}