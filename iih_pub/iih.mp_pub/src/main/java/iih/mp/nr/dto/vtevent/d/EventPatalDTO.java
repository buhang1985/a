package iih.mp.nr.dto.vtevent.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 过敏史体征事件 DTO数据 
 * 
 */
public class EventPatalDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 过敏史ID
	 * @return String
	 */
	public String getId_patal() {
		return ((String) getAttrVal("Id_patal"));
	}
	/**
	 * 过敏史ID
	 * @param Id_patal
	 */
	public void setId_patal(String Id_patal) {
		setAttrVal("Id_patal", Id_patal);
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
	 * 物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 过敏分类名称
	 * @return String
	 */
	public String getName_alcla() {
		return ((String) getAttrVal("Name_alcla"));
	}
	/**
	 * 过敏分类名称
	 * @param Name_alcla
	 */
	public void setName_alcla(String Name_alcla) {
		setAttrVal("Name_alcla", Name_alcla);
	}
	/**
	 * 过敏分类描述名称
	 * @return String
	 */
	public String getName_desc_alcla() {
		return ((String) getAttrVal("Name_desc_alcla"));
	}
	/**
	 * 过敏分类描述名称
	 * @param Name_desc_alcla
	 */
	public void setName_desc_alcla(String Name_desc_alcla) {
		setAttrVal("Name_desc_alcla", Name_desc_alcla);
	}
}