package iih.mp.nr.orsplitdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 合管实体 DTO数据 
 * 
 */
public class SampleSplitDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务套标识
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}
	/**
	 * 服务套标识
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 执行计划
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
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
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 签署时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}
	/**
	 * 签署时间
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
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
	 * 分组规则
	 * @return String
	 */
	public String getSd_labgroup() {
		return ((String) getAttrVal("Sd_labgroup"));
	}
	/**
	 * 分组规则
	 * @param Sd_labgroup
	 */
	public void setSd_labgroup(String Sd_labgroup) {
		setAttrVal("Sd_labgroup", Sd_labgroup);
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
	 * 标本类型
	 * @return String
	 */
	public String getSd_labsamptp() {
		return ((String) getAttrVal("Sd_labsamptp"));
	}
	/**
	 * 标本类型
	 * @param Sd_labsamptp
	 */
	public void setSd_labsamptp(String Sd_labsamptp) {
		setAttrVal("Sd_labsamptp", Sd_labsamptp);
	}
	/**
	 * 采集方法ID
	 * @return String
	 */
	public String getId_colltp() {
		return ((String) getAttrVal("Id_colltp"));
	}
	/**
	 * 采集方法ID
	 * @param Id_colltp
	 */
	public void setId_colltp(String Id_colltp) {
		setAttrVal("Id_colltp", Id_colltp);
	}
	/**
	 * 采集方法
	 * @return String
	 */
	public String getSd_colltp() {
		return ((String) getAttrVal("Sd_colltp"));
	}
	/**
	 * 采集方法
	 * @param Sd_colltp
	 */
	public void setSd_colltp(String Sd_colltp) {
		setAttrVal("Sd_colltp", Sd_colltp);
	}
	/**
	 * 容器类型ID
	 * @return String
	 */
	public String getId_tubetp() {
		return ((String) getAttrVal("Id_tubetp"));
	}
	/**
	 * 容器类型ID
	 * @param Id_tubetp
	 */
	public void setId_tubetp(String Id_tubetp) {
		setAttrVal("Id_tubetp", Id_tubetp);
	}
	/**
	 * 容器类型
	 * @return String
	 */
	public String getSd_tubetp() {
		return ((String) getAttrVal("Sd_tubetp"));
	}
	/**
	 * 容器类型
	 * @param Sd_tubetp
	 */
	public void setSd_tubetp(String Sd_tubetp) {
		setAttrVal("Sd_tubetp", Sd_tubetp);
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
	 * 标本需求量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 标本需求量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getId_unit_quan() {
		return ((String) getAttrVal("Id_unit_quan"));
	}
	/**
	 * 计量单位
	 * @param Id_unit_quan
	 */
	public void setId_unit_quan(String Id_unit_quan) {
		setAttrVal("Id_unit_quan", Id_unit_quan);
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
	 * 标本关系
	 * @return FArrayList
	 */
	public FArrayList getRelationarry() {
		return ((FArrayList) getAttrVal("Relationarry"));
	}
	/**
	 * 标本关系
	 * @param Relationarry
	 */
	public void setRelationarry(FArrayList Relationarry) {
		setAttrVal("Relationarry", Relationarry);
	}
}