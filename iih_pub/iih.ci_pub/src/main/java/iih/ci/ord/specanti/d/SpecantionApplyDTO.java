package iih.ci.ord.specanti.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 特殊级抗菌药会诊申请单DTO DTO数据 
 * 
 */
public class SpecantionApplyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单ID
	 * @return String
	 */
	public String getId_apspecanticons() {
		return ((String) getAttrVal("Id_apspecanticons"));
	}
	/**
	 * 申请单ID
	 * @param Id_apspecanticons
	 */
	public void setId_apspecanticons(String Id_apspecanticons) {
		setAttrVal("Id_apspecanticons", Id_apspecanticons);
	}
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
	 * 医嘱服务项目ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务项目ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
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
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 受邀科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 受邀科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 受邀科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 受邀科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 受邀科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 受邀科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 受邀人id
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 受邀人id
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 受邀人code
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}
	/**
	 * 受邀人code
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	/**
	 * 受邀人名称
	 * @return String
	 */
	public String getName_invited_emp() {
		return ((String) getAttrVal("Name_invited_emp"));
	}
	/**
	 * 受邀人名称
	 * @param Name_invited_emp
	 */
	public void setName_invited_emp(String Name_invited_emp) {
		setAttrVal("Name_invited_emp", Name_invited_emp);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cons_app() {
		return ((FDateTime) getAttrVal("Dt_cons_app"));
	}
	/**
	 * 申请时间
	 * @param Dt_cons_app
	 */
	public void setDt_cons_app(FDateTime Dt_cons_app) {
		setAttrVal("Dt_cons_app", Dt_cons_app);
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
	 * 科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}
	/**
	 * 床号
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 临床诊断明细id拼接
	 * @return String
	 */
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}
	/**
	 * 临床诊断明细id拼接
	 * @param Str_id_diitm
	 */
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	/**
	 * 临床诊断明细编码拼接
	 * @return String
	 */
	public String getStr_code_diitm() {
		return ((String) getAttrVal("Str_code_diitm"));
	}
	/**
	 * 临床诊断明细编码拼接
	 * @param Str_code_diitm
	 */
	public void setStr_code_diitm(String Str_code_diitm) {
		setAttrVal("Str_code_diitm", Str_code_diitm);
	}
	/**
	 * 临床诊断明细拼接
	 * @return String
	 */
	public String getStr_name_diitm() {
		return ((String) getAttrVal("Str_name_diitm"));
	}
	/**
	 * 临床诊断明细拼接
	 * @param Str_name_diitm
	 */
	public void setStr_name_diitm(String Str_name_diitm) {
		setAttrVal("Str_name_diitm", Str_name_diitm);
	}
	/**
	 * 病情描述
	 * @return String
	 */
	public String getDes_sympsign() {
		return ((String) getAttrVal("Des_sympsign"));
	}
	/**
	 * 病情描述
	 * @param Des_sympsign
	 */
	public void setDes_sympsign(String Des_sympsign) {
		setAttrVal("Des_sympsign", Des_sympsign);
	}
	/**
	 * 病原体检查
	 * @return FBoolean
	 */
	public FBoolean getFg_microbeinspection() {
		return ((FBoolean) getAttrVal("Fg_microbeinspection"));
	}
	/**
	 * 病原体检查
	 * @param Fg_microbeinspection
	 */
	public void setFg_microbeinspection(FBoolean Fg_microbeinspection) {
		setAttrVal("Fg_microbeinspection", Fg_microbeinspection);
	}
	/**
	 * 病原体检查结果
	 * @return String
	 */
	public String getMicrobeinspection() {
		return ((String) getAttrVal("Microbeinspection"));
	}
	/**
	 * 病原体检查结果
	 * @param Microbeinspection
	 */
	public void setMicrobeinspection(String Microbeinspection) {
		setAttrVal("Microbeinspection", Microbeinspection);
	}
	/**
	 * 患者过敏信息
	 * @return String
	 */
	public String getAllerhyhistory() {
		return ((String) getAttrVal("Allerhyhistory"));
	}
	/**
	 * 患者过敏信息
	 * @param Allerhyhistory
	 */
	public void setAllerhyhistory(String Allerhyhistory) {
		setAttrVal("Allerhyhistory", Allerhyhistory);
	}
	/**
	 * 申请抗菌药品种
	 * @return String
	 */
	public String getType_apspe() {
		return ((String) getAttrVal("Type_apspe"));
	}
	/**
	 * 申请抗菌药品种
	 * @param Type_apspe
	 */
	public void setType_apspe(String Type_apspe) {
		setAttrVal("Type_apspe", Type_apspe);
	}
	/**
	 * 用药目的
	 * @return FBoolean
	 */
	public FBoolean getDes_feasons() {
		return ((FBoolean) getAttrVal("Des_feasons"));
	}
	/**
	 * 用药目的
	 * @param Des_feasons
	 */
	public void setDes_feasons(FBoolean Des_feasons) {
		setAttrVal("Des_feasons", Des_feasons);
	}
	/**
	 * 申请用药理由
	 * @return String
	 */
	public String getDes_pps() {
		return ((String) getAttrVal("Des_pps"));
	}
	/**
	 * 申请用药理由
	 * @param Des_pps
	 */
	public void setDes_pps(String Des_pps) {
		setAttrVal("Des_pps", Des_pps);
	}
	/**
	 * 申请医生
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 申请医生
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 职称ID
	 * @return String
	 */
	public String getId_emp_title() {
		return ((String) getAttrVal("Id_emp_title"));
	}
	/**
	 * 职称ID
	 * @param Id_emp_title
	 */
	public void setId_emp_title(String Id_emp_title) {
		setAttrVal("Id_emp_title", Id_emp_title);
	}
	/**
	 *  职称
	 * @return String
	 */
	public String getName_emp_title() {
		return ((String) getAttrVal("Name_emp_title"));
	}
	/**
	 *  职称
	 * @param Name_emp_title
	 */
	public void setName_emp_title(String Name_emp_title) {
		setAttrVal("Name_emp_title", Name_emp_title);
	}
	/**
	 * 会诊专家意见
	 * @return String
	 */
	public String getAdvice() {
		return ((String) getAttrVal("Advice"));
	}
	/**
	 * 会诊专家意见
	 * @param Advice
	 */
	public void setAdvice(String Advice) {
		setAttrVal("Advice", Advice);
	}
	/**
	 * 会诊专家签名
	 * @return String
	 */
	public String getExper_signature() {
		return ((String) getAttrVal("Exper_signature"));
	}
	/**
	 * 会诊专家签名
	 * @param Exper_signature
	 */
	public void setExper_signature(String Exper_signature) {
		setAttrVal("Exper_signature", Exper_signature);
	}
	/**
	 * 会诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cons() {
		return ((FDateTime) getAttrVal("Dt_cons"));
	}
	/**
	 * 会诊时间
	 * @param Dt_cons
	 */
	public void setDt_cons(FDateTime Dt_cons) {
		setAttrVal("Dt_cons", Dt_cons);
	}
	/**
	 * 会诊意见记录者签名
	 * @return String
	 */
	public String getReporter_signature() {
		return ((String) getAttrVal("Reporter_signature"));
	}
	/**
	 * 会诊意见记录者签名
	 * @param Reporter_signature
	 */
	public void setReporter_signature(String Reporter_signature) {
		setAttrVal("Reporter_signature", Reporter_signature);
	}
	/**
	 * 记录时间
	 * @return FDateTime
	 */
	public FDateTime getDt_record() {
		return ((FDateTime) getAttrVal("Dt_record"));
	}
	/**
	 * 记录时间
	 * @param Dt_record
	 */
	public void setDt_record(FDateTime Dt_record) {
		setAttrVal("Dt_record", Dt_record);
	}
	/**
	 * 医务部审核结果ID
	 * @return String
	 */
	public String getId_approve_meddep() {
		return ((String) getAttrVal("Id_approve_meddep"));
	}
	/**
	 * 医务部审核结果ID
	 * @param Id_approve_meddep
	 */
	public void setId_approve_meddep(String Id_approve_meddep) {
		setAttrVal("Id_approve_meddep", Id_approve_meddep);
	}
	/**
	 * 医务部审核结果SD
	 * @return String
	 */
	public String getSd_approve_meddep() {
		return ((String) getAttrVal("Sd_approve_meddep"));
	}
	/**
	 * 医务部审核结果SD
	 * @param Sd_approve_meddep
	 */
	public void setSd_approve_meddep(String Sd_approve_meddep) {
		setAttrVal("Sd_approve_meddep", Sd_approve_meddep);
	}
	/**
	 * 专家审核结果SD
	 * @return String
	 */
	public String getSd_approve_emp() {
		return ((String) getAttrVal("Sd_approve_emp"));
	}
	/**
	 * 专家审核结果SD
	 * @param Sd_approve_meddep
	 */
	public void setSd_approve_emp(String Sd_approve_emp) {
		setAttrVal("Sd_approve_emp", Sd_approve_emp);
	}
	/**
	 * 医务部审核签字
	 * @return String
	 */
	public String getMed_dep_signature() {
		return ((String) getAttrVal("Med_dep_signature"));
	}
	/**
	 * 医务部审核签字
	 * @param Med_dep_signature
	 */
	public void setMed_dep_signature(String Med_dep_signature) {
		setAttrVal("Med_dep_signature", Med_dep_signature);
	}
	/**
	 * 会诊状态ID
	 * @return String
	 */
	public String getId_su_speccons() {
		return ((String) getAttrVal("Id_su_speccons"));
	}
	/**
	 * 会诊状态ID
	 * @param Id_su_speccons
	 */
	public void setId_su_speccons(String Id_su_speccons) {
		setAttrVal("Id_su_speccons", Id_su_speccons);
	}
	/**
	 * 会诊状态SD
	 * @return String
	 */
	public String getSd_su_speccons() {
		return ((String) getAttrVal("Sd_su_speccons"));
	}
	/**
	 * 会诊状态SD
	 * @param Sd_su_speccons
	 */
	public void setSd_su_speccons(String Sd_su_speccons) {
		setAttrVal("Sd_su_speccons", Sd_su_speccons);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 会诊方式id
	 * @return FBoolean
	 */
	public FBoolean getId_consmd() {
		return ((FBoolean) getAttrVal("Id_consmd"));
	}
	/**
	 * 会诊方式id
	 * @param Id_consmd
	 */
	public void setId_consmd(FBoolean Id_consmd) {
		setAttrVal("Id_consmd", Id_consmd);
	}
	/**
	 * 会诊方式编码
	 * @return String
	 */
	public String getSd_consmd() {
		return ((String) getAttrVal("Sd_consmd"));
	}
	/**
	 * 会诊方式编码
	 * @param Sd_consmd
	 */
	public void setSd_consmd(String Sd_consmd) {
		setAttrVal("Sd_consmd", Sd_consmd);
	}
	/**
	 * 审批类型
	 * @return String
	 */
	public String getApprovetp() {
		return ((String) getAttrVal("Approvetp"));
	}
	/**
	 * 审批类型
	 * @param Approvetp
	 */
	public void setApprovetp(String Approvetp) {
		setAttrVal("Approvetp", Approvetp);
	}
	/**
	 * 审批结果
	 * @return String
	 */
	public String getApprovrst() {
		return ((String) getAttrVal("Approvrst"));
	}
	/**
	 * 审批结果
	 * @param Approvrst
	 */
	public void setApprovrst(String Approvrst) {
		setAttrVal("Approvrst", Approvrst);
	}
	/**
	 * 诊断定义ID
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * 诊断定义ID
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 主诊断
	 * @return String
	 */
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}
	/**
	 * 主诊断
	 * @param Name_didef
	 */
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
}