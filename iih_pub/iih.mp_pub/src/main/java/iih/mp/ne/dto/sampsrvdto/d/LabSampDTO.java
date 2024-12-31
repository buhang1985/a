package iih.mp.ne.dto.sampsrvdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验标本 DTO数据 
 * 
 */
public class LabSampDTO extends BaseDTO {
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
	 * 标本名称
	 * @return String
	 */
	public String getName_lab() {
		return ((String) getAttrVal("Name_lab"));
	}
	/**
	 * 标本名称
	 * @param Name_lab
	 */
	public void setName_lab(String Name_lab) {
		setAttrVal("Name_lab", Name_lab);
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
	 * 标本类型ID
	 * @return String
	 */
	public String getId_labsamptp() {
		return ((String) getAttrVal("Id_labsamptp"));
	}
	/**
	 * 标本类型ID
	 * @param Id_labsamptp
	 */
	public void setId_labsamptp(String Id_labsamptp) {
		setAttrVal("Id_labsamptp", Id_labsamptp);
	}
	/**
	 * 标本类型名
	 * @return String
	 */
	public String getName_labsamptp() {
		return ((String) getAttrVal("Name_labsamptp"));
	}
	/**
	 * 标本类型名
	 * @param Name_labsamptp
	 */
	public void setName_labsamptp(String Name_labsamptp) {
		setAttrVal("Name_labsamptp", Name_labsamptp);
	}
	/**
	 * 作废标识
	 * @return FBoolean
	 */
	public FBoolean getFg_invalid() {
		return ((FBoolean) getAttrVal("Fg_invalid"));
	}
	/**
	 * 作废标识
	 * @param Fg_invalid
	 */
	public void setFg_invalid(FBoolean Fg_invalid) {
		setAttrVal("Fg_invalid", Fg_invalid);
	}
	/**
	 * 标本说明
	 * @return String
	 */
	public String getDes_labsamp() {
		return ((String) getAttrVal("Des_labsamp"));
	}
	/**
	 * 标本说明
	 * @param Des_labsamp
	 */
	public void setDes_labsamp(String Des_labsamp) {
		setAttrVal("Des_labsamp", Des_labsamp);
	}
	/**
	 * 标本状态
	 * @return String
	 */
	public String getEu_sta() {
		return ((String) getAttrVal("Eu_sta"));
	}
	/**
	 * 标本状态
	 * @param Eu_sta
	 */
	public void setEu_sta(String Eu_sta) {
		setAttrVal("Eu_sta", Eu_sta);
	}
	/**
	 * 标本状态名称
	 * @return String
	 */
	public String getName_eu_sta() {
		return ((String) getAttrVal("Name_eu_sta"));
	}
	/**
	 * 标本状态名称
	 * @param Name_eu_sta
	 */
	public void setName_eu_sta(String Name_eu_sta) {
		setAttrVal("Name_eu_sta", Name_eu_sta);
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
	 * 需求量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 需求量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 打印次数
	 * @return Integer
	 */
	public Integer getCt_prn() {
		return ((Integer) getAttrVal("Ct_prn"));
	}
	/**
	 * 打印次数
	 * @param Ct_prn
	 */
	public void setCt_prn(Integer Ct_prn) {
		setAttrVal("Ct_prn", Ct_prn);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室id
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
	 * 服务集合
	 * @return FArrayList
	 */
	public FArrayList getArraysrvs() {
		return ((FArrayList) getAttrVal("Arraysrvs"));
	}
	/**
	 * 服务集合
	 * @param Arraysrvs
	 */
	public void setArraysrvs(FArrayList Arraysrvs) {
		setAttrVal("Arraysrvs", Arraysrvs);
	}
}