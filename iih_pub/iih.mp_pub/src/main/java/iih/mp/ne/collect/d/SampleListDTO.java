package iih.mp.ne.collect.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标签状态列表 DTO数据 
 * 
 */
public class SampleListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检验标本主键
	 * @return String
	 */
	public String getId_labsamp() {
		return ((String) getAttrVal("Id_labsamp"));
	}
	/**
	 * 检验标本主键
	 * @param Id_labsamp
	 */
	public void setId_labsamp(String Id_labsamp) {
		setAttrVal("Id_labsamp", Id_labsamp);
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
	 * 就诊类型
	 * @return String
	 */
	public String getSd_entp() {
		return ((String) getAttrVal("Sd_entp"));
	}
	/**
	 * 就诊类型
	 * @param Sd_entp
	 */
	public void setSd_entp(String Sd_entp) {
		setAttrVal("Sd_entp", Sd_entp);
	}
	/**
	 * 医嘱闭环状态
	 * @return String
	 */
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}
	/**
	 * 医嘱闭环状态
	 * @param Id_orpltpsta
	 */
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getSamstatus() {
		return ((String) getAttrVal("Samstatus"));
	}
	/**
	 * 状态
	 * @param Samstatus
	 */
	public void setSamstatus(String Samstatus) {
		setAttrVal("Samstatus", Samstatus);
	}
	/**
	 * 加急标识
	 * @return String
	 */
	public String getName_urgent() {
		return ((String) getAttrVal("Name_urgent"));
	}
	/**
	 * 加急标识
	 * @param Name_urgent
	 */
	public void setName_urgent(String Name_urgent) {
		setAttrVal("Name_urgent", Name_urgent);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 标本条码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 标本条码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 标本需求量
	 * @return String
	 */
	public String getQuan() {
		return ((String) getAttrVal("Quan"));
	}
	/**
	 * 标本需求量
	 * @param Quan
	 */
	public void setQuan(String Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 需求量单位
	 * @return String
	 */
	public String getId_unit_quan() {
		return ((String) getAttrVal("Id_unit_quan"));
	}
	/**
	 * 需求量单位
	 * @param Id_unit_quan
	 */
	public void setId_unit_quan(String Id_unit_quan) {
		setAttrVal("Id_unit_quan", Id_unit_quan);
	}
	/**
	 * 需求量单位名称
	 * @return String
	 */
	public String getName_quan() {
		return ((String) getAttrVal("Name_quan"));
	}
	/**
	 * 需求量单位名称
	 * @param Name_quan
	 */
	public void setName_quan(String Name_quan) {
		setAttrVal("Name_quan", Name_quan);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}
	/**
	 * 执行时间
	 * @param Dt_mp
	 */
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	/**
	 * 行选中状态
	 * @return FBoolean
	 */
	public FBoolean getChecked() {
		return ((FBoolean) getAttrVal("Checked"));
	}
	/**
	 * 行选中状态
	 * @param Checked
	 */
	public void setChecked(FBoolean Checked) {
		setAttrVal("Checked", Checked);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAttention() {
		return ((String) getAttrVal("Attention"));
	}
	/**
	 * 注意事项
	 * @param Attention
	 */
	public void setAttention(String Attention) {
		setAttrVal("Attention", Attention);
	}
}