package iih.syn.sen.entdep.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者转科信息 DTO数据 
 * 
 */
public class VwEntDepDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 转科唯一标识
	 * @return String
	 */
	public String getTrans_id() {
		return ((String) getAttrVal("Trans_id"));
	}
	/**
	 * 转科唯一标识
	 * @param Trans_id
	 */
	public void setTrans_id(String Trans_id) {
		setAttrVal("Trans_id", Trans_id);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者ID
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTime_cur() {
		return ((String) getAttrVal("Time_cur"));
	}
	/**
	 * 就诊次数
	 * @param Time_cur
	 */
	public void setTime_cur(String Time_cur) {
		setAttrVal("Time_cur", Time_cur);
	}
	/**
	 * 住院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 住院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 申请转科时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 申请转科时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 转科日期
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 转科日期
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 转科类型ID
	 * @return String
	 */
	public String getId_trans() {
		return ((String) getAttrVal("Id_trans"));
	}
	/**
	 * 转科类型ID
	 * @param Id_trans
	 */
	public void setId_trans(String Id_trans) {
		setAttrVal("Id_trans", Id_trans);
	}
	/**
	 * 转科类型
	 * @return String
	 */
	public String getSd_trans() {
		return ((String) getAttrVal("Sd_trans"));
	}
	/**
	 * 转科类型
	 * @param Sd_trans
	 */
	public void setSd_trans(String Sd_trans) {
		setAttrVal("Sd_trans", Sd_trans);
	}
	/**
	 * 原科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 原科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 原科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 原科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 原病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 原病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 原病区编码
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}
	/**
	 * 原病区编码
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 原房间号
	 * @return String
	 */
	public String getRoom() {
		return ((String) getAttrVal("Room"));
	}
	/**
	 * 原房间号
	 * @param Room
	 */
	public void setRoom(String Room) {
		setAttrVal("Room", Room);
	}
	/**
	 * 原床位
	 * @return String
	 */
	public String getBed_name() {
		return ((String) getAttrVal("Bed_name"));
	}
	/**
	 * 原床位
	 * @param Bed_name
	 */
	public void setBed_name(String Bed_name) {
		setAttrVal("Bed_name", Bed_name);
	}
	/**
	 * 操作人编码
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}
	/**
	 * 操作人编码
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	/**
	 * 操作人名称
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 操作人名称
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 入院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_entry() {
		return ((FBoolean) getAttrVal("Fg_entry"));
	}
	/**
	 * 入院标识
	 * @param Fg_entry
	 */
	public void setFg_entry(FBoolean Fg_entry) {
		setAttrVal("Fg_entry", Fg_entry);
	}
	/**
	 * 出院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_end() {
		return ((FBoolean) getAttrVal("Fg_end"));
	}
	/**
	 * 出院标识
	 * @param Fg_end
	 */
	public void setFg_end(FBoolean Fg_end) {
		setAttrVal("Fg_end", Fg_end);
	}
	/**
	 * 删除标记
	 * @return String
	 */
	public String getFg_del() {
		return ((String) getAttrVal("Fg_del"));
	}
	/**
	 * 删除标记
	 * @param Fg_del
	 */
	public void setFg_del(String Fg_del) {
		setAttrVal("Fg_del", Fg_del);
	}
}