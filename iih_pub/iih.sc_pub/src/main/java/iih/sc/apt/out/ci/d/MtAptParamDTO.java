package iih.sc.apt.out.ci.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技预约参数 DTO数据 
 * 
 */
public class MtAptParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 医嘱申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 预约申请开始日期
	 * @return FDate
	 */
	public FDate getD_begin() {
		return ((FDate) getAttrVal("D_begin"));
	}
	/**
	 * 预约申请开始日期
	 * @param D_begin
	 */
	public void setD_begin(FDate D_begin) {
		setAttrVal("D_begin", D_begin);
	}
	/**
	 * 医嘱开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe_or() {
		return ((FDateTime) getAttrVal("Dt_effe_or"));
	}
	/**
	 * 医嘱开立时间
	 * @param Dt_effe_or
	 */
	public void setDt_effe_or(FDateTime Dt_effe_or) {
		setAttrVal("Dt_effe_or", Dt_effe_or);
	}
	/**
	 * 预约申请描述
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 预约申请描述
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 医嘱加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 医嘱加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
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
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 预约申请名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 预约申请名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
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
	 * 预约申请人
	 * @return String
	 */
	public String getId_emp_appl() {
		return ((String) getAttrVal("Id_emp_appl"));
	}
	/**
	 * 预约申请人
	 * @param Id_emp_appl
	 */
	public void setId_emp_appl(String Id_emp_appl) {
		setAttrVal("Id_emp_appl", Id_emp_appl);
	}
	/**
	 * 预约医嘱类型
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}
	/**
	 * 预约医嘱类型
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	/**
	 * 预约模式
	 * @return String
	 */
	public String getSc_mt_mode() {
		return ((String) getAttrVal("Sc_mt_mode"));
	}
	/**
	 * 预约模式
	 * @param Sc_mt_mode
	 */
	public void setSc_mt_mode(String Sc_mt_mode) {
		setAttrVal("Sc_mt_mode", Sc_mt_mode);
	}
	/**
	 * 渠道id
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}
	/**
	 * 渠道id
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	/**
	 * 渠道编码
	 * @return String
	 */
	public String getCode_scchl() {
		return ((String) getAttrVal("Code_scchl"));
	}
	/**
	 * 渠道编码
	 * @param Code_scchl
	 */
	public void setCode_scchl(String Code_scchl) {
		setAttrVal("Code_scchl", Code_scchl);
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
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 申请部门
	 * @return String
	 */
	public String getId_dep_apply() {
		return ((String) getAttrVal("Id_dep_apply"));
	}
	/**
	 * 申请部门
	 * @param Id_dep_apply
	 */
	public void setId_dep_apply(String Id_dep_apply) {
		setAttrVal("Id_dep_apply", Id_dep_apply);
	}
}