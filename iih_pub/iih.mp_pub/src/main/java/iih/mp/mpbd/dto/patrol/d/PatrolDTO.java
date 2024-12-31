package iih.mp.mpbd.dto.patrol.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者巡房记录 DTO数据 
 * 
 */
public class PatrolDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 护理巡房主键ID
	 * @return String
	 */
	public String getId_patrol() {
		return ((String) getAttrVal("Id_patrol"));
	}
	/**
	 * 护理巡房主键ID
	 * @param Id_patrol
	 */
	public void setId_patrol(String Id_patrol) {
		setAttrVal("Id_patrol", Id_patrol);
	}
	/**
	 * 患者床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 患者床号
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
	 * 患者性别
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}
	/**
	 * 患者性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 护理等级
	 * @return String
	 */
	public String getCarelevel() {
		return ((String) getAttrVal("Carelevel"));
	}
	/**
	 * 护理等级
	 * @param Carelevel
	 */
	public void setCarelevel(String Carelevel) {
		setAttrVal("Carelevel", Carelevel);
	}
	/**
	 * 巡护护士id
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}
	/**
	 * 巡护护士id
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 巡视护士名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 巡视护士名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 巡视时间
	 * @return FDateTime
	 */
	public FDateTime getDt_patrol() {
		return ((FDateTime) getAttrVal("Dt_patrol"));
	}
	/**
	 * 巡视时间
	 * @param Dt_patrol
	 */
	public void setDt_patrol(FDateTime Dt_patrol) {
		setAttrVal("Dt_patrol", Dt_patrol);
	}
	/**
	 * 患者去向
	 * @return String
	 */
	public String getName_patgoing() {
		return ((String) getAttrVal("Name_patgoing"));
	}
	/**
	 * 患者去向
	 * @param Name_patgoing
	 */
	public void setName_patgoing(String Name_patgoing) {
		setAttrVal("Name_patgoing", Name_patgoing);
	}
	/**
	 * 患者体位
	 * @return String
	 */
	public String getName_patpos() {
		return ((String) getAttrVal("Name_patpos"));
	}
	/**
	 * 患者体位
	 * @param Name_patpos
	 */
	public void setName_patpos(String Name_patpos) {
		setAttrVal("Name_patpos", Name_patpos);
	}
	/**
	 * 保护性约束
	 * @return String
	 */
	public String getName_procon() {
		return ((String) getAttrVal("Name_procon"));
	}
	/**
	 * 保护性约束
	 * @param Name_procon
	 */
	public void setName_procon(String Name_procon) {
		setAttrVal("Name_procon", Name_procon);
	}
	/**
	 * 患者就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 患者就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge_pat() {
		return ((String) getAttrVal("Age_pat"));
	}
	/**
	 * 患者年龄
	 * @param Age_pat
	 */
	public void setAge_pat(String Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
}