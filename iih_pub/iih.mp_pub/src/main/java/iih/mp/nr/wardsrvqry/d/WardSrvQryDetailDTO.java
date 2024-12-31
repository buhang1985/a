package iih.mp.nr.wardsrvqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病区诊疗项目明细查询 DTO数据 
 * 
 */
public class WardSrvQryDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 服务数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 服务数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 服务单位id
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 服务单位id
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 服务单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 服务单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 服务频次
	 * @return String
	 */
	public String getFreq() {
		return ((String) getAttrVal("Freq"));
	}
	/**
	 * 服务频次
	 * @param Freq
	 */
	public void setFreq(String Freq) {
		setAttrVal("Freq", Freq);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 计划执行状态
	 * @return String
	 */
	public String getEu_su() {
		return ((String) getAttrVal("Eu_su"));
	}
	/**
	 * 计划执行状态
	 * @param Eu_su
	 */
	public void setEu_su(String Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}
	/**
	 * 执行人
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_confirm() {
		return ((FDateTime) getAttrVal("Dt_mp_confirm"));
	}
	/**
	 * 执行时间
	 * @param Dt_mp_confirm
	 */
	public void setDt_mp_confirm(FDateTime Dt_mp_confirm) {
		setAttrVal("Dt_mp_confirm", Dt_mp_confirm);
	}
}