package iih.ci.mr.cimrcontext.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历内容 DTO数据 
 * 
 */
public class CiMrContext extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病历主键
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}
	/**
	 * 病历主键
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * displaynam12
	 * @return String
	 */
	public String getName_mr() {
		return ((String) getAttrVal("Name_mr"));
	}
	/**
	 * displaynam12
	 * @param Name_mr
	 */
	public void setName_mr(String Name_mr) {
		setAttrVal("Name_mr", Name_mr);
	}
	/**
	 * 组织主键
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织主键
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
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
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getN_times_inhospital() {
		return ((String) getAttrVal("N_times_inhospital"));
	}
	/**
	 * 住院次数
	 * @param N_times_inhospital
	 */
	public void setN_times_inhospital(String N_times_inhospital) {
		setAttrVal("N_times_inhospital", N_times_inhospital);
	}
	/**
	 * 病历完整的文本内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}
	/**
	 * 病历完整的文本内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 元素编码
	 * @return FArrayList
	 */
	public FArrayList getCode_elem() {
		return ((FArrayList) getAttrVal("Code_elem"));
	}
	/**
	 * 元素编码
	 * @param Code_elem
	 */
	public void setCode_elem(FArrayList Code_elem) {
		setAttrVal("Code_elem", Code_elem);
	}
	/**
	 * 元素内容
	 * @return FArrayList
	 */
	public FArrayList getCon_elem() {
		return ((FArrayList) getAttrVal("Con_elem"));
	}
	/**
	 * 元素内容
	 * @param Con_elem
	 */
	public void setCon_elem(FArrayList Con_elem) {
		setAttrVal("Con_elem", Con_elem);
	}
	/**
	 * 病历状态id
	 * @return String
	 */
	public String getId_su_mr() {
		return ((String) getAttrVal("Id_su_mr"));
	}
	/**
	 * 病历状态id
	 * @param Id_su_mr
	 */
	public void setId_su_mr(String Id_su_mr) {
		setAttrVal("Id_su_mr", Id_su_mr);
	}
	/**
	 * 病历状态sd
	 * @return String
	 */
	public String getSd_su_mr() {
		return ((String) getAttrVal("Sd_su_mr"));
	}
	/**
	 * 病历状态sd
	 * @param Sd_su_mr
	 */
	public void setSd_su_mr(String Sd_su_mr) {
		setAttrVal("Sd_su_mr", Sd_su_mr);
	}
	/**
	 * 病历状态name
	 * @return String
	 */
	public String getName_su_mr() {
		return ((String) getAttrVal("Name_su_mr"));
	}
	/**
	 * 病历状态name
	 * @param Name_su_mr
	 */
	public void setName_su_mr(String Name_su_mr) {
		setAttrVal("Name_su_mr", Name_su_mr);
	}
	/**
	 * 病历业务时间
	 * @return String
	 */
	public String getDt_rd() {
		return ((String) getAttrVal("Dt_rd"));
	}
	/**
	 * 病历业务时间
	 * @param Dt_rd
	 */
	public void setDt_rd(String Dt_rd) {
		setAttrVal("Dt_rd", Dt_rd);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreateby() {
		return ((String) getAttrVal("Createby"));
	}
	/**
	 * 创建人
	 * @param Createby
	 */
	public void setCreateby(String Createby) {
		setAttrVal("Createby", Createby);
	}
	/**
	 * 创建时间
	 * @return String
	 */
	public String getCreatetime() {
		return ((String) getAttrVal("Createtime"));
	}
	/**
	 * 创建时间
	 * @param Createtime
	 */
	public void setCreatetime(String Createtime) {
		setAttrVal("Createtime", Createtime);
	}
	/**
	 * 创建人姓名
	 * @return String
	 */
	public String getName_createby() {
		return ((String) getAttrVal("Name_createby"));
	}
	/**
	 * 创建人姓名
	 * @param Name_createby
	 */
	public void setName_createby(String Name_createby) {
		setAttrVal("Name_createby", Name_createby);
	}
	/**
	 * 提交时间
	 * @return String
	 */
	public String getDt_submit() {
		return ((String) getAttrVal("Dt_submit"));
	}
	/**
	 * 提交时间
	 * @param Dt_submit
	 */
	public void setDt_submit(String Dt_submit) {
		setAttrVal("Dt_submit", Dt_submit);
	}
	/**
	 * 提交人id
	 * @return String
	 */
	public String getId_submit_emp() {
		return ((String) getAttrVal("Id_submit_emp"));
	}
	/**
	 * 提交人id
	 * @param Id_submit_emp
	 */
	public void setId_submit_emp(String Id_submit_emp) {
		setAttrVal("Id_submit_emp", Id_submit_emp);
	}
	/**
	 * 提交人名称
	 * @return String
	 */
	public String getName_submit() {
		return ((String) getAttrVal("Name_submit"));
	}
	/**
	 * 提交人名称
	 * @param Name_submit
	 */
	public void setName_submit(String Name_submit) {
		setAttrVal("Name_submit", Name_submit);
	}
	/**
	 * 创建科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 创建科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 创建科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 创建科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 病历最后更新人id
	 * @return String
	 */
	public String getId_lastedit() {
		return ((String) getAttrVal("Id_lastedit"));
	}
	/**
	 * 病历最后更新人id
	 * @param Id_lastedit
	 */
	public void setId_lastedit(String Id_lastedit) {
		setAttrVal("Id_lastedit", Id_lastedit);
	}
	/**
	 * 病历最后更新人姓名
	 * @return String
	 */
	public String getName_lastedit() {
		return ((String) getAttrVal("Name_lastedit"));
	}
	/**
	 * 病历最后更新人姓名
	 * @param Name_lastedit
	 */
	public void setName_lastedit(String Name_lastedit) {
		setAttrVal("Name_lastedit", Name_lastedit);
	}
}