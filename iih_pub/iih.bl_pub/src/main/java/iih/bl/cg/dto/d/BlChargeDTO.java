package iih.bl.cg.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 实体 DTO数据 
 * 
 */
public class BlChargeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方主键
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方主键
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 患者主索引
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主索引
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊流程ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊流程ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 诊断编码
	 * @return String
	 */
	public String getDidef_code() {
		return ((String) getAttrVal("Didef_code"));
	}
	/**
	 * 诊断编码
	 * @param Didef_code
	 */
	public void setDidef_code(String Didef_code) {
		setAttrVal("Didef_code", Didef_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDidef_name() {
		return ((String) getAttrVal("Didef_name"));
	}
	/**
	 * 诊断名称
	 * @param Didef_name
	 */
	public void setDidef_name(String Didef_name) {
		setAttrVal("Didef_name", Didef_name);
	}
	/**
	 * 病历信息
	 * @return String
	 */
	public String getMr_content() {
		return ((String) getAttrVal("Mr_content"));
	}
	/**
	 * 病历信息
	 * @param Mr_content
	 */
	public void setMr_content(String Mr_content) {
		setAttrVal("Mr_content", Mr_content);
	}
	/**
	 * 开方科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开方科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开方科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开方科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 处方类型ID
	 * @return String
	 */
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}
	/**
	 * 处方类型ID
	 * @param Id_prestp
	 */
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 开方医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开方医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开方医生姓名
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开方医生姓名
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 处方开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 处方开立时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 挂号交易流水号
	 * @return String
	 */
	public String getRegistertradeno() {
		return ((String) getAttrVal("Registertradeno"));
	}
	/**
	 * 挂号交易流水号
	 * @param Registertradeno
	 */
	public void setRegistertradeno(String Registertradeno) {
		setAttrVal("Registertradeno", Registertradeno);
	}
	/**
	 * 医保处方标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_pres() {
		return ((FBoolean) getAttrVal("Fg_hp_pres"));
	}
	/**
	 * 医保处方标识
	 * @param Fg_hp_pres
	 */
	public void setFg_hp_pres(FBoolean Fg_hp_pres) {
		setAttrVal("Fg_hp_pres", Fg_hp_pres);
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
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	
	
	/**
	 * 收费明细
	 * @return
	 */
	public FArrayList getBlChargeItemDTOLst()
	{
		return ((FArrayList)getAttrVal("BlChargeItemLst"));
	}
	
	/**
	 * 收费明细项目
	 * @param blChargeItemDTOLst
	 */
	public void SetBlChargeItemDTOLst(FArrayList blChargeItemDTOLst)
	{
		setAttrVal("BlChargeItemLst", blChargeItemDTOLst);
	}
}