package iih.mp.dg.dto.druginfudto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行信息查询 DTO数据 
 * 
 */
public class ActionMesQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 执行人
	 * @return String
	 */
	public String getPname() {
		return ((String) getAttrVal("Pname"));
	}
	/**
	 * 执行人
	 * @param Pname
	 */
	public void setPname(String Pname) {
		setAttrVal("Pname", Pname);
	}
	/**
	 * 巡视结果
	 * @return String
	 */
	public String getStatus_rst() {
		return ((String) getAttrVal("Status_rst"));
	}
	/**
	 * 巡视结果
	 * @param Status_rst
	 */
	public void setStatus_rst(String Status_rst) {
		setAttrVal("Status_rst", Status_rst);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getStatus_fin() {
		return ((String) getAttrVal("Status_fin"));
	}
	/**
	 * 执行状态
	 * @param Status_fin
	 */
	public void setStatus_fin(String Status_fin) {
		setAttrVal("Status_fin", Status_fin);
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
	 * 输液登记ID
	 * @return String
	 */
	public String getId_dginfu() {
		return ((String) getAttrVal("Id_dginfu"));
	}
	/**
	 * 输液登记ID
	 * @param Id_dginfu
	 */
	public void setId_dginfu(String Id_dginfu) {
		setAttrVal("Id_dginfu", Id_dginfu);
	}
	/**
	 * 执行类型编码
	 * @return String
	 */
	public String getSd_dgprtp() {
		return ((String) getAttrVal("Sd_dgprtp"));
	}
	/**
	 * 执行类型编码
	 * @param Sd_dgprtp
	 */
	public void setSd_dgprtp(String Sd_dgprtp) {
		setAttrVal("Sd_dgprtp", Sd_dgprtp);
	}
	/**
	 * 滴速
	 * @return Integer
	 */
	public Integer getIvgtt() {
		return ((Integer) getAttrVal("Ivgtt"));
	}
	/**
	 * 滴速
	 * @param Ivgtt
	 */
	public void setIvgtt(Integer Ivgtt) {
		setAttrVal("Ivgtt", Ivgtt);
	}
	/**
	 * 输液情况
	 * @return FBoolean
	 */
	public FBoolean getFg_matter() {
		return ((FBoolean) getAttrVal("Fg_matter"));
	}
	/**
	 * 输液情况
	 * @param Fg_matter
	 */
	public void setFg_matter(FBoolean Fg_matter) {
		setAttrVal("Fg_matter", Fg_matter);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getName_dj() {
		return ((String) getAttrVal("Name_dj"));
	}
	/**
	 * 登记人
	 * @param Name_dj
	 */
	public void setName_dj(String Name_dj) {
		setAttrVal("Name_dj", Name_dj);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 执行科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 医嘱执行id
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 医嘱执行id
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
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
}