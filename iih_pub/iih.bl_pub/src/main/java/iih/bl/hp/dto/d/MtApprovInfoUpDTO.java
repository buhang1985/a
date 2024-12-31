package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊特殊病审批信息上报dto DTO数据 
 * 
 */
public class MtApprovInfoUpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保卡号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保卡号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 审批类别
	 * @return String
	 */
	public String getApprove_type() {
		return ((String) getAttrVal("Approve_type"));
	}
	/**
	 * 审批类别
	 * @param Approve_type
	 */
	public void setApprove_type(String Approve_type) {
		setAttrVal("Approve_type", Approve_type);
	}
	/**
	 * 就诊医院编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}
	/**
	 * 就诊医院编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 就诊医院名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 就诊医院名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 病种编码
	 * @return String
	 */
	public String getCode_ill() {
		return ((String) getAttrVal("Code_ill"));
	}
	/**
	 * 病种编码
	 * @param Code_ill
	 */
	public void setCode_ill(String Code_ill) {
		setAttrVal("Code_ill", Code_ill);
	}
	/**
	 * 病种名称
	 * @return String
	 */
	public String getName_ill() {
		return ((String) getAttrVal("Name_ill"));
	}
	/**
	 * 病种名称
	 * @param Name_ill
	 */
	public void setName_ill(String Name_ill) {
		setAttrVal("Name_ill", Name_ill);
	}
	/**
	 * 鉴定医生编码
	 * @return String
	 */
	public String getCode_emp_jd() {
		return ((String) getAttrVal("Code_emp_jd"));
	}
	/**
	 * 鉴定医生编码
	 * @param Code_emp_jd
	 */
	public void setCode_emp_jd(String Code_emp_jd) {
		setAttrVal("Code_emp_jd", Code_emp_jd);
	}
	/**
	 * 鉴定医生名称
	 * @return String
	 */
	public String getName_emp_jd() {
		return ((String) getAttrVal("Name_emp_jd"));
	}
	/**
	 * 鉴定医生名称
	 * @param Name_emp_jd
	 */
	public void setName_emp_jd(String Name_emp_jd) {
		setAttrVal("Name_emp_jd", Name_emp_jd);
	}
	/**
	 * 审批标志
	 * @return FBoolean
	 */
	public FBoolean getFg_approve() {
		return ((FBoolean) getAttrVal("Fg_approve"));
	}
	/**
	 * 审批标志
	 * @param Fg_approve
	 */
	public void setFg_approve(FBoolean Fg_approve) {
		setAttrVal("Fg_approve", Fg_approve);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 终止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 终止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getCode_operator() {
		return ((String) getAttrVal("Code_operator"));
	}
	/**
	 * 经办人
	 * @param Code_operator
	 */
	public void setCode_operator(String Code_operator) {
		setAttrVal("Code_operator", Code_operator);
	}
	/**
	 * 医院鉴定意见
	 * @return String
	 */
	public String getHos_expert_opinion() {
		return ((String) getAttrVal("Hos_expert_opinion"));
	}
	/**
	 * 医院鉴定意见
	 * @param Hos_expert_opinion
	 */
	public void setHos_expert_opinion(String Hos_expert_opinion) {
		setAttrVal("Hos_expert_opinion", Hos_expert_opinion);
	}
	/**
	 * 医保鉴定意见
	 * @return String
	 */
	public String getHp_expert_opinion() {
		return ((String) getAttrVal("Hp_expert_opinion"));
	}
	/**
	 * 医保鉴定意见
	 * @param Hp_expert_opinion
	 */
	public void setHp_expert_opinion(String Hp_expert_opinion) {
		setAttrVal("Hp_expert_opinion", Hp_expert_opinion);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
}