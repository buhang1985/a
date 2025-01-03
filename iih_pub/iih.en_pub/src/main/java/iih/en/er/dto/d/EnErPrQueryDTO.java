package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊预检查询 DTO数据 
 * 
 */
public class EnErPrQueryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊最后一次就诊id
	 * @return String
	 */
	public String getId_ent_last() {
		return ((String) getAttrVal("Id_ent_last"));
	}
	/**
	 * 门诊最后一次就诊id
	 * @param Id_ent_last
	 */
	public void setId_ent_last(String Id_ent_last) {
		setAttrVal("Id_ent_last", Id_ent_last);
	}
	/**
	 * 患者信息id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者信息id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
	}
	/**
	 * 就诊日期开始
	 * @return FDate
	 */
	public FDate getBegin_time() {
		return ((FDate) getAttrVal("Begin_time"));
	}
	/**
	 * 就诊日期开始
	 * @param Begin_time
	 */
	public void setBegin_time(FDate Begin_time) {
		setAttrVal("Begin_time", Begin_time);
	}
	/**
	 * 就诊日期结束
	 * @return FDate
	 */
	public FDate getEnd_time() {
		return ((FDate) getAttrVal("End_time"));
	}
	/**
	 * 就诊日期结束
	 * @param End_time
	 */
	public void setEnd_time(FDate End_time) {
		setAttrVal("End_time", End_time);
	}
	/**
	 * 参照科室id
	 * @return String
	 */
	public String getId_dep_phy_ref() {
		return ((String) getAttrVal("Id_dep_phy_ref"));
	}
	/**
	 * 参照科室id
	 * @param Id_dep_phy_ref
	 */
	public void setId_dep_phy_ref(String Id_dep_phy_ref) {
		setAttrVal("Id_dep_phy_ref", Id_dep_phy_ref);
	}
	/**
	 * 参照科室编码
	 * @return String
	 */
	public String getSd_dep_phy_ref() {
		return ((String) getAttrVal("Sd_dep_phy_ref"));
	}
	/**
	 * 参照科室编码
	 * @param Sd_dep_phy_ref
	 */
	public void setSd_dep_phy_ref(String Sd_dep_phy_ref) {
		setAttrVal("Sd_dep_phy_ref", Sd_dep_phy_ref);
	}
	/**
	 * 参照科室名称
	 * @return String
	 */
	public String getName_dep_phy_ref() {
		return ((String) getAttrVal("Name_dep_phy_ref"));
	}
	/**
	 * 参照科室名称
	 * @param Name_dep_phy_ref
	 */
	public void setName_dep_phy_ref(String Name_dep_phy_ref) {
		setAttrVal("Name_dep_phy_ref", Name_dep_phy_ref);
	}
	/**
	 * 就诊状态参照
	 * @return String
	 */
	public String getSd_status_ref() {
		return ((String) getAttrVal("Sd_status_ref"));
	}
	/**
	 * 就诊状态参照
	 * @param Sd_status_ref
	 */
	public void setSd_status_ref(String Sd_status_ref) {
		setAttrVal("Sd_status_ref", Sd_status_ref);
	}
	/**
	 * 参照预检人员id
	 * @return String
	 */
	public String getId_createby_ref() {
		return ((String) getAttrVal("Id_createby_ref"));
	}
	/**
	 * 参照预检人员id
	 * @param Id_createby_ref
	 */
	public void setId_createby_ref(String Id_createby_ref) {
		setAttrVal("Id_createby_ref", Id_createby_ref);
	}
	/**
	 * 参照预检人员编码
	 * @return String
	 */
	public String getSd_createby_ref() {
		return ((String) getAttrVal("Sd_createby_ref"));
	}
	/**
	 * 参照预检人员编码
	 * @param Sd_createby_ref
	 */
	public void setSd_createby_ref(String Sd_createby_ref) {
		setAttrVal("Sd_createby_ref", Sd_createby_ref);
	}
	/**
	 * 参照预检人员
	 * @return String
	 */
	public String getCreateby_ref() {
		return ((String) getAttrVal("Createby_ref"));
	}
	/**
	 * 参照预检人员
	 * @param Createby_ref
	 */
	public void setCreateby_ref(String Createby_ref) {
		setAttrVal("Createby_ref", Createby_ref);
	}
	/**
	 * 参照预检分级id
	 * @return String
	 */
	public String getId_scale_hm_ref() {
		return ((String) getAttrVal("Id_scale_hm_ref"));
	}
	/**
	 * 参照预检分级id
	 * @param Id_scale_hm_ref
	 */
	public void setId_scale_hm_ref(String Id_scale_hm_ref) {
		setAttrVal("Id_scale_hm_ref", Id_scale_hm_ref);
	}
	/**
	 * 参照预检分级编码
	 * @return String
	 */
	public String getSd_scale_hm_ref() {
		return ((String) getAttrVal("Sd_scale_hm_ref"));
	}
	/**
	 * 参照预检分级编码
	 * @param Sd_scale_hm_ref
	 */
	public void setSd_scale_hm_ref(String Sd_scale_hm_ref) {
		setAttrVal("Sd_scale_hm_ref", Sd_scale_hm_ref);
	}
	/**
	 * 参照预检分级名称
	 * @return String
	 */
	public String getName_scale_hm_ref() {
		return ((String) getAttrVal("Name_scale_hm_ref"));
	}
	/**
	 * 参照预检分级名称
	 * @param Name_scale_hm_ref
	 */
	public void setName_scale_hm_ref(String Name_scale_hm_ref) {
		setAttrVal("Name_scale_hm_ref", Name_scale_hm_ref);
	}
	/**
	 * 参照分诊去向id
	 * @return String
	 */
	public String getId_triage_to_ref() {
		return ((String) getAttrVal("Id_triage_to_ref"));
	}
	/**
	 * 参照分诊去向id
	 * @param Id_triage_to_ref
	 */
	public void setId_triage_to_ref(String Id_triage_to_ref) {
		setAttrVal("Id_triage_to_ref", Id_triage_to_ref);
	}
	/**
	 * 参照分诊去向编码
	 * @return String
	 */
	public String getSd_triage_to_ref() {
		return ((String) getAttrVal("Sd_triage_to_ref"));
	}
	/**
	 * 参照分诊去向编码
	 * @param Sd_triage_to_ref
	 */
	public void setSd_triage_to_ref(String Sd_triage_to_ref) {
		setAttrVal("Sd_triage_to_ref", Sd_triage_to_ref);
	}
	/**
	 * 参照分诊去向名称
	 * @return String
	 */
	public String getName_triage_to_ref() {
		return ((String) getAttrVal("Name_triage_to_ref"));
	}
	/**
	 * 参照分诊去向名称
	 * @param Name_triage_to_ref
	 */
	public void setName_triage_to_ref(String Name_triage_to_ref) {
		setAttrVal("Name_triage_to_ref", Name_triage_to_ref);
	}
	/**
	 * 参照就诊去向id
	 * @return String
	 */
	public String getId_gowhere_er_ref() {
		return ((String) getAttrVal("Id_gowhere_er_ref"));
	}
	/**
	 * 参照就诊去向id
	 * @param Id_gowhere_er_ref
	 */
	public void setId_gowhere_er_ref(String Id_gowhere_er_ref) {
		setAttrVal("Id_gowhere_er_ref", Id_gowhere_er_ref);
	}
	/**
	 * 参照就诊去向编码
	 * @return String
	 */
	public String getSd_gowhere_er_ref() {
		return ((String) getAttrVal("Sd_gowhere_er_ref"));
	}
	/**
	 * 参照就诊去向编码
	 * @param Sd_gowhere_er_ref
	 */
	public void setSd_gowhere_er_ref(String Sd_gowhere_er_ref) {
		setAttrVal("Sd_gowhere_er_ref", Sd_gowhere_er_ref);
	}
	/**
	 * 参照就诊去向名称
	 * @return String
	 */
	public String getName_gowhere_er_ref() {
		return ((String) getAttrVal("Name_gowhere_er_ref"));
	}
	/**
	 * 参照就诊去向名称
	 * @param Name_gowhere_er_ref
	 */
	public void setName_gowhere_er_ref(String Name_gowhere_er_ref) {
		setAttrVal("Name_gowhere_er_ref", Name_gowhere_er_ref);
	}
	/**
	 * 到院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 到院日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编号
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 患者出生日期
	 * @return FDate
	 */
	public FDate getPat_birth() {
		return ((FDate) getAttrVal("Pat_birth"));
	}
	/**
	 * 患者出生日期
	 * @param Pat_birth
	 */
	public void setPat_birth(FDate Pat_birth) {
		setAttrVal("Pat_birth", Pat_birth);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}
	/**
	 * 患者年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	/**
	 * 预检码
	 * @return String
	 */
	public String getErpre_code() {
		return ((String) getAttrVal("Erpre_code"));
	}
	/**
	 * 预检码
	 * @param Erpre_code
	 */
	public void setErpre_code(String Erpre_code) {
		setAttrVal("Erpre_code", Erpre_code);
	}
	/**
	 * 三无人员
	 * @return FBoolean
	 */
	public FBoolean getFg_nonperson() {
		return ((FBoolean) getAttrVal("Fg_nonperson"));
	}
	/**
	 * 三无人员
	 * @param Fg_nonperson
	 */
	public void setFg_nonperson(FBoolean Fg_nonperson) {
		setAttrVal("Fg_nonperson", Fg_nonperson);
	}
	/**
	 * 预检分级id
	 * @return String
	 */
	public String getId_scale_hm() {
		return ((String) getAttrVal("Id_scale_hm"));
	}
	/**
	 * 预检分级id
	 * @param Id_scale_hm
	 */
	public void setId_scale_hm(String Id_scale_hm) {
		setAttrVal("Id_scale_hm", Id_scale_hm);
	}
	/**
	 * 预检分级编码
	 * @return String
	 */
	public String getSd_scale_hm() {
		return ((String) getAttrVal("Sd_scale_hm"));
	}
	/**
	 * 预检分级编码
	 * @param Sd_scale_hm
	 */
	public void setSd_scale_hm(String Sd_scale_hm) {
		setAttrVal("Sd_scale_hm", Sd_scale_hm);
	}
	/**
	 * 预检分级名称
	 * @return String
	 */
	public String getName_scale_hm() {
		return ((String) getAttrVal("Name_scale_hm"));
	}
	/**
	 * 预检分级名称
	 * @param Name_scale_hm
	 */
	public void setName_scale_hm(String Name_scale_hm) {
		setAttrVal("Name_scale_hm", Name_scale_hm);
	}
	/**
	 * 入科时间
	 * @return FDateTime
	 */
	public FDateTime getDt_pat() {
		return ((FDateTime) getAttrVal("Dt_pat"));
	}
	/**
	 * 入科时间
	 * @param Dt_pat
	 */
	public void setDt_pat(FDateTime Dt_pat) {
		setAttrVal("Dt_pat", Dt_pat);
	}
	/**
	 * 滞留时长
	 * @return String
	 */
	public String getDet_dura() {
		return ((String) getAttrVal("Det_dura"));
	}
	/**
	 * 滞留时长
	 * @param Det_dura
	 */
	public void setDet_dura(String Det_dura) {
		setAttrVal("Det_dura", Det_dura);
	}
	/**
	 * 分诊去向id
	 * @return String
	 */
	public String getId_triage_to() {
		return ((String) getAttrVal("Id_triage_to"));
	}
	/**
	 * 分诊去向id
	 * @param Id_triage_to
	 */
	public void setId_triage_to(String Id_triage_to) {
		setAttrVal("Id_triage_to", Id_triage_to);
	}
	/**
	 * 分诊去向编码
	 * @return String
	 */
	public String getSd_triage_to() {
		return ((String) getAttrVal("Sd_triage_to"));
	}
	/**
	 * 分诊去向编码
	 * @param Sd_triage_to
	 */
	public void setSd_triage_to(String Sd_triage_to) {
		setAttrVal("Sd_triage_to", Sd_triage_to);
	}
	/**
	 * 分诊去向名称
	 * @return String
	 */
	public String getName_triage_to() {
		return ((String) getAttrVal("Name_triage_to"));
	}
	/**
	 * 分诊去向名称
	 * @param Name_triage_to
	 */
	public void setName_triage_to(String Name_triage_to) {
		setAttrVal("Name_triage_to", Name_triage_to);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 科室编码
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_paticate() {
		return ((String) getAttrVal("Id_paticate"));
	}
	/**
	 * 患者分类id
	 * @param Id_paticate
	 */
	public void setId_paticate(String Id_paticate) {
		setAttrVal("Id_paticate", Id_paticate);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getSd_paticate() {
		return ((String) getAttrVal("Sd_paticate"));
	}
	/**
	 * 患者分类编码
	 * @param Sd_paticate
	 */
	public void setSd_paticate(String Sd_paticate) {
		setAttrVal("Sd_paticate", Sd_paticate);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_paticate() {
		return ((String) getAttrVal("Name_paticate"));
	}
	/**
	 * 患者分类名称
	 * @param Name_paticate
	 */
	public void setName_paticate(String Name_paticate) {
		setAttrVal("Name_paticate", Name_paticate);
	}
	/**
	 * 价格分类id
	 * @return String
	 */
	public String getId_patpritp() {
		return ((String) getAttrVal("Id_patpritp"));
	}
	/**
	 * 价格分类id
	 * @param Id_patpritp
	 */
	public void setId_patpritp(String Id_patpritp) {
		setAttrVal("Id_patpritp", Id_patpritp);
	}
	/**
	 * 价格分类编码
	 * @return String
	 */
	public String getSd_patpritp() {
		return ((String) getAttrVal("Sd_patpritp"));
	}
	/**
	 * 价格分类编码
	 * @param Sd_patpritp
	 */
	public void setSd_patpritp(String Sd_patpritp) {
		setAttrVal("Sd_patpritp", Sd_patpritp);
	}
	/**
	 * 价格分类名称
	 * @return String
	 */
	public String getName_patpritp() {
		return ((String) getAttrVal("Name_patpritp"));
	}
	/**
	 * 价格分类名称
	 * @param Name_patpritp
	 */
	public void setName_patpritp(String Name_patpritp) {
		setAttrVal("Name_patpritp", Name_patpritp);
	}
	/**
	 * 就诊序号
	 * @return String
	 */
	public String getTicketno() {
		return ((String) getAttrVal("Ticketno"));
	}
	/**
	 * 就诊序号
	 * @param Ticketno
	 */
	public void setTicketno(String Ticketno) {
		setAttrVal("Ticketno", Ticketno);
	}
	/**
	 * 日起分组id
	 * @return String
	 */
	public String getId_dateslot() {
		return ((String) getAttrVal("Id_dateslot"));
	}
	/**
	 * 日起分组id
	 * @param Id_dateslot
	 */
	public void setId_dateslot(String Id_dateslot) {
		setAttrVal("Id_dateslot", Id_dateslot);
	}
	/**
	 * 日起分组编码
	 * @return String
	 */
	public String getSd_dateslot() {
		return ((String) getAttrVal("Sd_dateslot"));
	}
	/**
	 * 日起分组编码
	 * @param Sd_dateslot
	 */
	public void setSd_dateslot(String Sd_dateslot) {
		setAttrVal("Sd_dateslot", Sd_dateslot);
	}
	/**
	 * 日起分组名称
	 * @return String
	 */
	public String getName_dateslot() {
		return ((String) getAttrVal("Name_dateslot"));
	}
	/**
	 * 日起分组名称
	 * @param Name_dateslot
	 */
	public void setName_dateslot(String Name_dateslot) {
		setAttrVal("Name_dateslot", Name_dateslot);
	}
	/**
	 * 就诊状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 就诊状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 预检人员id
	 * @return String
	 */
	public String getId_emp_operator() {
		return ((String) getAttrVal("Id_emp_operator"));
	}
	/**
	 * 预检人员id
	 * @param Id_emp_operator
	 */
	public void setId_emp_operator(String Id_emp_operator) {
		setAttrVal("Id_emp_operator", Id_emp_operator);
	}
	/**
	 * 预检人员编码
	 * @return String
	 */
	public String getSd_emp_operator() {
		return ((String) getAttrVal("Sd_emp_operator"));
	}
	/**
	 * 预检人员编码
	 * @param Sd_emp_operator
	 */
	public void setSd_emp_operator(String Sd_emp_operator) {
		setAttrVal("Sd_emp_operator", Sd_emp_operator);
	}
	/**
	 * 预检人员名称
	 * @return String
	 */
	public String getName_emp_operator() {
		return ((String) getAttrVal("Name_emp_operator"));
	}
	/**
	 * 预检人员名称
	 * @param Name_emp_operator
	 */
	public void setName_emp_operator(String Name_emp_operator) {
		setAttrVal("Name_emp_operator", Name_emp_operator);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getEnt_count() {
		return ((String) getAttrVal("Ent_count"));
	}
	/**
	 * 就诊次数
	 * @param Ent_count
	 */
	public void setEnt_count(String Ent_count) {
		setAttrVal("Ent_count", Ent_count);
	}
	/**
	 * 患者状态
	 * @return String
	 */
	public String getPat_status() {
		return ((String) getAttrVal("Pat_status"));
	}
	/**
	 * 患者状态
	 * @param Pat_status
	 */
	public void setPat_status(String Pat_status) {
		setAttrVal("Pat_status", Pat_status);
	}
	/**
	 * 病区状态
	 * @return FBoolean
	 */
	public FBoolean getFg_acpt_nur() {
		return ((FBoolean) getAttrVal("Fg_acpt_nur"));
	}
	/**
	 * 病区状态
	 * @param Fg_acpt_nur
	 */
	public void setFg_acpt_nur(FBoolean Fg_acpt_nur) {
		setAttrVal("Fg_acpt_nur", Fg_acpt_nur);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 状态名称
	 * @return String
	 */
	public String getOp_name_status() {
		return ((String) getAttrVal("Op_name_status"));
	}
	/**
	 * 状态名称
	 * @param Op_name_status
	 */
	public void setOp_name_status(String Op_name_status) {
		setAttrVal("Op_name_status", Op_name_status);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 是否取消挂号
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 是否取消挂号
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 预检状态
	 * @return String
	 */
	public String getErpre_status() {
		return ((String) getAttrVal("Erpre_status"));
	}
	/**
	 * 预检状态
	 * @param Erpre_status
	 */
	public void setErpre_status(String Erpre_status) {
		setAttrVal("Erpre_status", Erpre_status);
	}
	/**
	 * 留观id
	 * @return String
	 */
	public String getId_ent_ip() {
		return ((String) getAttrVal("Id_ent_ip"));
	}
	/**
	 * 留观id
	 * @param Id_ent_ip
	 */
	public void setId_ent_ip(String Id_ent_ip) {
		setAttrVal("Id_ent_ip", Id_ent_ip);
	}
	/**
	 * 预检状态名称
	 * @return String
	 */
	public String getName_erpre_status() {
		return ((String) getAttrVal("Name_erpre_status"));
	}
	/**
	 * 预检状态名称
	 * @param Name_erpre_status
	 */
	public void setName_erpre_status(String Name_erpre_status) {
		setAttrVal("Name_erpre_status", Name_erpre_status);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
}