package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 口腔排班查询DTO DTO数据 
 * 
 */
public class OralSchQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班计划id
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 排班计划id
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_b() {
		return ((FDate) getAttrVal("Dt_b"));
	}
	/**
	 * 开始日期
	 * @param Dt_b
	 */
	public void setDt_b(FDate Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 排班计划name
	 * @return String
	 */
	public String getName_scpl() {
		return ((String) getAttrVal("Name_scpl"));
	}
	/**
	 * 排班计划name
	 * @param Name_scpl
	 */
	public void setName_scpl(String Name_scpl) {
		setAttrVal("Name_scpl", Name_scpl);
	}
	/**
	 * 排班计划sd
	 * @return String
	 */
	public String getSd_scpl() {
		return ((String) getAttrVal("Sd_scpl"));
	}
	/**
	 * 排班计划sd
	 * @param Sd_scpl
	 */
	public void setSd_scpl(String Sd_scpl) {
		setAttrVal("Sd_scpl", Sd_scpl);
	}
	/**
	 * 诊间
	 * @return String
	 */
	public String getDia_room() {
		return ((String) getAttrVal("Dia_room"));
	}
	/**
	 * 诊间
	 * @param Dia_room
	 */
	public void setDia_room(String Dia_room) {
		setAttrVal("Dia_room", Dia_room);
	}
	/**
	 * 所在周一
	 * @return FDate
	 */
	public FDate getDt_week() {
		return ((FDate) getAttrVal("Dt_week"));
	}
	/**
	 * 所在周一
	 * @param Dt_week
	 */
	public void setDt_week(FDate Dt_week) {
		setAttrVal("Dt_week", Dt_week);
	}
	/**
	 * 是否新增
	 * @return FBoolean
	 */
	public FBoolean getIsadd() {
		return ((FBoolean) getAttrVal("Isadd"));
	}
	/**
	 * 是否新增
	 * @param Isadd
	 */
	public void setIsadd(FBoolean Isadd) {
		setAttrVal("Isadd", Isadd);
	}
	/**
	 * 诊间名称
	 * @return String
	 */
	public String getName_room() {
		return ((String) getAttrVal("Name_room"));
	}
	/**
	 * 诊间名称
	 * @param Name_room
	 */
	public void setName_room(String Name_room) {
		setAttrVal("Name_room", Name_room);
	}
	/**
	 * 护士
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}
	/**
	 * 护士
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 护士名称
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 护士名称
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 科室参数
	 * @return String
	 */
	public String getId_depparam() {
		return ((String) getAttrVal("Id_depparam"));
	}
	/**
	 * 科室参数
	 * @param Id_depparam
	 */
	public void setId_depparam(String Id_depparam) {
		setAttrVal("Id_depparam", Id_depparam);
	}
	/**
	 * 科室参数名称
	 * @return String
	 */
	public String getName_depparam() {
		return ((String) getAttrVal("Name_depparam"));
	}
	/**
	 * 科室参数名称
	 * @param Name_depparam
	 */
	public void setName_depparam(String Name_depparam) {
		setAttrVal("Name_depparam", Name_depparam);
	}
}