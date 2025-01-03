package iih.mp.dg.dto.ipdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院药房请领摆药条件 DTO数据 
 * 
 */
public class IpDgConditionDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱类型
	 * @return Integer
	 */
	public Integer getOrder_type() {
		return ((Integer) getAttrVal("Order_type"));
	}
	/**
	 * 医嘱类型
	 * @param Order_type
	 */
	public void setOrder_type(Integer Order_type) {
		setAttrVal("Order_type", Order_type);
	}
	/**
	 * 用法类型
	 * @return String
	 */
	public String getId_srv_route() {
		return ((String) getAttrVal("Id_srv_route"));
	}
	/**
	 * 用法类型
	 * @param Id_srv_route
	 */
	public void setId_srv_route(String Id_srv_route) {
		setAttrVal("Id_srv_route", Id_srv_route);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 截止日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 摆药病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 摆药病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 库房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 库房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
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
	 * 患者条件类型
	 * @return String
	 */
	public String getPat_cond_type() {
		return ((String) getAttrVal("Pat_cond_type"));
	}
	/**
	 * 患者条件类型
	 * @param Pat_cond_type
	 */
	public void setPat_cond_type(String Pat_cond_type) {
		setAttrVal("Pat_cond_type", Pat_cond_type);
	}
	/**
	 * 患者条件值
	 * @return String
	 */
	public String getPat_cond_value() {
		return ((String) getAttrVal("Pat_cond_value"));
	}
	/**
	 * 患者条件值
	 * @param Pat_cond_value
	 */
	public void setPat_cond_value(String Pat_cond_value) {
		setAttrVal("Pat_cond_value", Pat_cond_value);
	}
	/**
	 * 摆药类型(21：发药  22：退药 23：出院带药)
	 * @return String
	 */
	public String getPut_type() {
		return ((String) getAttrVal("Put_type"));
	}
	/**
	 * 摆药类型(21：发药  22：退药 23：出院带药)
	 * @param Put_type
	 */
	public void setPut_type(String Put_type) {
		setAttrVal("Put_type", Put_type);
	}
	/**
	 * 发送状态(0:未发送1：已发送2：已确认)
	 * @return String
	 */
	public String getSend_state() {
		return ((String) getAttrVal("Send_state"));
	}
	/**
	 * 发送状态(0:未发送1：已发送2：已确认)
	 * @param Send_state
	 */
	public void setSend_state(String Send_state) {
		setAttrVal("Send_state", Send_state);
	}
	/**
	 * 摆药单号
	 * @return String
	 */
	public String getCode_dgipap() {
		return ((String) getAttrVal("Code_dgipap"));
	}
	/**
	 * 摆药单号
	 * @param Code_dgipap
	 */
	public void setCode_dgipap(String Code_dgipap) {
		setAttrVal("Code_dgipap", Code_dgipap);
	}
	/**
	 * 草药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_herb() {
		return ((FBoolean) getAttrVal("Fg_herb"));
	}
	/**
	 * 草药标志
	 * @param Fg_herb
	 */
	public void setFg_herb(FBoolean Fg_herb) {
		setAttrVal("Fg_herb", Fg_herb);
	}
	/**
	 * 摆药单类型
	 * @return Integer
	 */
	public Integer getSd_aptype() {
		return ((Integer) getAttrVal("Sd_aptype"));
	}
	/**
	 * 摆药单类型
	 * @param Sd_aptype
	 */
	public void setSd_aptype(Integer Sd_aptype) {
		setAttrVal("Sd_aptype", Sd_aptype);
	}
	/**
	 * 摆药或请领主键
	 * @return String
	 */
	public String getId_ipdeorap() {
		return ((String) getAttrVal("Id_ipdeorap"));
	}
	/**
	 * 摆药或请领主键
	 * @param Id_ipdeorap
	 */
	public void setId_ipdeorap(String Id_ipdeorap) {
		setAttrVal("Id_ipdeorap", Id_ipdeorap);
	}
	/**
	 * 药单类型主键
	 * @return String
	 */
	public String getId_dgshetp() {
		return ((String) getAttrVal("Id_dgshetp"));
	}
	/**
	 * 药单类型主键
	 * @param Id_dgshetp
	 */
	public void setId_dgshetp(String Id_dgshetp) {
		setAttrVal("Id_dgshetp", Id_dgshetp);
	}
	/**
	 * 退药原因
	 * @return String
	 */
	public String getBk_reason() {
		return ((String) getAttrVal("Bk_reason"));
	}
	/**
	 * 退药原因
	 * @param Bk_reason
	 */
	public void setBk_reason(String Bk_reason) {
		setAttrVal("Bk_reason", Bk_reason);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getName_pres() {
		return ((String) getAttrVal("Name_pres"));
	}
	/**
	 * 处方类型
	 * @param Name_pres
	 */
	public void setName_pres(String Name_pres) {
		setAttrVal("Name_pres", Name_pres);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 摆药天数
	 * @return Integer
	 */
	public Integer getDisp_days() {
		return ((Integer) getAttrVal("Disp_days"));
	}
	/**
	 * 摆药天数
	 * @param Disp_days
	 */
	public void setDisp_days(Integer Disp_days) {
		setAttrVal("Disp_days", Disp_days);
	}
	/**
	 * 数据权限
	 * @return String
	 */
	public String getData_prems() {
		return ((String) getAttrVal("Data_prems"));
	}
	/**
	 * 数据权限
	 * @param Data_prems
	 */
	public void setData_prems(String Data_prems) {
		setAttrVal("Data_prems", Data_prems);
	}
	/**
	 * 医嘱id集合
	 * @return String
	 */
	public String getId_ors() {
		return ((String) getAttrVal("Id_ors"));
	}
	/**
	 * 医嘱id集合
	 * @param Id_ors
	 */
	public void setId_ors(String Id_ors) {
		setAttrVal("Id_ors", Id_ors);
	}
	/**
	 * 是否支持医技发药
	 * @return FBoolean
	 */
	public FBoolean getFg_candispotdrug() {
		return ((FBoolean) getAttrVal("Fg_candispotdrug"));
	}
	/**
	 * 是否支持医技发药
	 * @param Fg_candispotdrug
	 */
	public void setFg_candispotdrug(FBoolean Fg_candispotdrug) {
		setAttrVal("Fg_candispotdrug", Fg_candispotdrug);
	}
}