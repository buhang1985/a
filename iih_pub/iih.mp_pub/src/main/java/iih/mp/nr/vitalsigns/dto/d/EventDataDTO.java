package iih.mp.nr.vitalsigns.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体征事件 DTO数据 
 * 
 */
public class EventDataDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体征事件
	 * @return String
	 */
	public String getId_mrvtev() {
		return ((String) getAttrVal("Id_mrvtev"));
	}
	/**
	 * 体征事件
	 * @param Id_mrvtev
	 */
	public void setId_mrvtev(String Id_mrvtev) {
		setAttrVal("Id_mrvtev", Id_mrvtev);
	}
	/**
	 * 医疗体征记录ID
	 * @return String
	 */
	public String getId_mrvt() {
		return ((String) getAttrVal("Id_mrvt"));
	}
	/**
	 * 医疗体征记录ID
	 * @param Id_mrvt
	 */
	public void setId_mrvt(String Id_mrvt) {
		setAttrVal("Id_mrvt", Id_mrvt);
	}
	/**
	 * 测量时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 测量时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 事件ID
	 * @return String
	 */
	public String getId_vt_ev() {
		return ((String) getAttrVal("Id_vt_ev"));
	}
	/**
	 * 事件ID
	 * @param Id_vt_ev
	 */
	public void setId_vt_ev(String Id_vt_ev) {
		setAttrVal("Id_vt_ev", Id_vt_ev);
	}
	/**
	 * 事件名字
	 * @return String
	 */
	public String getName_vt_ev() {
		return ((String) getAttrVal("Name_vt_ev"));
	}
	/**
	 * 事件名字
	 * @param Name_vt_ev
	 */
	public void setName_vt_ev(String Name_vt_ev) {
		setAttrVal("Name_vt_ev", Name_vt_ev);
	}
	/**
	 * 事件编码
	 * @return String
	 */
	public String getSd_vt_ev() {
		return ((String) getAttrVal("Sd_vt_ev"));
	}
	/**
	 * 事件编码
	 * @param Sd_vt_ev
	 */
	public void setSd_vt_ev(String Sd_vt_ev) {
		setAttrVal("Sd_vt_ev", Sd_vt_ev);
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
	 * 是否只读
	 * @return FBoolean
	 */
	public FBoolean getReadonly() {
		return ((FBoolean) getAttrVal("Readonly"));
	}
	/**
	 * 是否只读
	 * @param Readonly
	 */
	public void setReadonly(FBoolean Readonly) {
		setAttrVal("Readonly", Readonly);
	}
}