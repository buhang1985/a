package iih.mp.nr.dto.orderview.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱查看查询条件 DTO数据 
 * 
 */
public class OrderCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱显示状态ID
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 医嘱显示状态ID
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 医嘱显示状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 医嘱显示状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 医嘱显示状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 医嘱显示状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
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
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 长临
	 * @return Integer
	 */
	public Integer getEu_tp() {
		return ((Integer) getAttrVal("Eu_tp"));
	}
	/**
	 * 长临
	 * @param Eu_tp
	 */
	public void setEu_tp(Integer Eu_tp) {
		setAttrVal("Eu_tp", Eu_tp);
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
	 * 医嘱服务类型ID
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 医嘱服务类型ID
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 医嘱服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 医嘱服务类型名称
	 * @return String
	 */
	public String getName_srvtps() {
		return ((String) getAttrVal("Name_srvtps"));
	}
	/**
	 * 医嘱服务类型名称
	 * @param Name_srvtps
	 */
	public void setName_srvtps(String Name_srvtps) {
		setAttrVal("Name_srvtps", Name_srvtps);
	}
	/**
	 * 医嘱来源id
	 * @return String
	 */
	public String getId_orsrcfun() {
		return ((String) getAttrVal("Id_orsrcfun"));
	}
	/**
	 * 医嘱来源id
	 * @param Id_orsrcfun
	 */
	public void setId_orsrcfun(String Id_orsrcfun) {
		setAttrVal("Id_orsrcfun", Id_orsrcfun);
	}
	/**
	 * 医嘱来源编码
	 * @return String
	 */
	public String getSd_orsrcfun() {
		return ((String) getAttrVal("Sd_orsrcfun"));
	}
	/**
	 * 医嘱来源编码
	 * @param Sd_orsrcfun
	 */
	public void setSd_orsrcfun(String Sd_orsrcfun) {
		setAttrVal("Sd_orsrcfun", Sd_orsrcfun);
	}
	/**
	 * 患者就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 患者就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 活动医嘱
	 * @return Integer
	 */
	public Integer getFg_active() {
		return ((Integer) getAttrVal("Fg_active"));
	}
	/**
	 * 活动医嘱
	 * @param Fg_active
	 */
	public void setFg_active(Integer Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}