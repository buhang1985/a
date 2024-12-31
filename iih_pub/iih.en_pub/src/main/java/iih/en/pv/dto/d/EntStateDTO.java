package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊状况DTO DTO数据 
 * 
 */
public class EntStateDTO extends BaseDTO {
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
	 * 状况类型id
	 * @return String
	 */
	public String getId_enstatetp() {
		return ((String) getAttrVal("Id_enstatetp"));
	}
	/**
	 * 状况类型id
	 * @param Id_enstatetp
	 */
	public void setId_enstatetp(String Id_enstatetp) {
		setAttrVal("Id_enstatetp", Id_enstatetp);
	}
	/**
	 * 状况类型编码
	 * @return String
	 */
	public String getSd_enstatetp() {
		return ((String) getAttrVal("Sd_enstatetp"));
	}
	/**
	 * 状况类型编码
	 * @param Sd_enstatetp
	 */
	public void setSd_enstatetp(String Sd_enstatetp) {
		setAttrVal("Sd_enstatetp", Sd_enstatetp);
	}
	/**
	 * 值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}
	/**
	 * 值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 医疗服务ID，病情、护理、营养、发烧需指定
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务ID，病情、护理、营养、发烧需指定
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 是否删除，默认修改
	 * @return FBoolean
	 */
	public FBoolean getFg_del() {
		return ((FBoolean) getAttrVal("Fg_del"));
	}
	/**
	 * 是否删除，默认修改
	 * @param Fg_del
	 */
	public void setFg_del(FBoolean Fg_del) {
		setAttrVal("Fg_del", Fg_del);
	}
	/**
	 * 发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_occ() {
		return ((FDateTime) getAttrVal("Dt_occ"));
	}
	/**
	 * 发生时间
	 * @param Dt_occ
	 */
	public void setDt_occ(FDateTime Dt_occ) {
		setAttrVal("Dt_occ", Dt_occ);
	}
	/**
	 * 状况ID
	 * @return String
	 */
	public String getId_entstatedef() {
		return ((String) getAttrVal("Id_entstatedef"));
	}
	/**
	 * 状况ID
	 * @param Id_entstatedef
	 */
	public void setId_entstatedef(String Id_entstatedef) {
		setAttrVal("Id_entstatedef", Id_entstatedef);
	}
	/**
	 * 触发源id
	 * @return String
	 */
	public String getId_key_sourse() {
		return ((String) getAttrVal("Id_key_sourse"));
	}
	/**
	 * 触发源id
	 * @param Id_key_sourse
	 */
	public void setId_key_sourse(String Id_key_sourse) {
		setAttrVal("Id_key_sourse", Id_key_sourse);
	}
}