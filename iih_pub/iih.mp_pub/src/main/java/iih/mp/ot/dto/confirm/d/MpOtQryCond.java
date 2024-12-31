package iih.mp.ot.dto.confirm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技补费查询 DTO数据 
 * 
 */
public class MpOtQryCond extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getEnt_type() {
		return ((String) getAttrVal("Ent_type"));
	}
	/**
	 * 就诊类型
	 * @param Ent_type
	 */
	public void setEnt_type(String Ent_type) {
		setAttrVal("Ent_type", Ent_type);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 开始时间
	 * @return String
	 */
	public String getDt_begin() {
		return ((String) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(String Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}
	/**
	 * 就诊卡号
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}
	/**
	 * 操作员
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 记账开始时间
	 * @return String
	 */
	public String getDt_begin_acc() {
		return ((String) getAttrVal("Dt_begin_acc"));
	}
	/**
	 * 记账开始时间
	 * @param Dt_begin_acc
	 */
	public void setDt_begin_acc(String Dt_begin_acc) {
		setAttrVal("Dt_begin_acc", Dt_begin_acc);
	}
	/**
	 * 记账结束时间
	 * @return String
	 */
	public String getDt_end_acc() {
		return ((String) getAttrVal("Dt_end_acc"));
	}
	/**
	 * 记账结束时间
	 * @param Dt_end_acc
	 */
	public void setDt_end_acc(String Dt_end_acc) {
		setAttrVal("Dt_end_acc", Dt_end_acc);
	}
}