package iih.ci.mrqc.mrcompletestatusdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历完成情况DTO DTO数据 
 * 
 */
public class MrCompleteStatusDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗记录id
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}
	/**
	 * 医疗记录id
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 患者code
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}
	/**
	 * 患者code
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
	}
	/**
	 * 患者name
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者name
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 入院科室id
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科室id
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 入院科室code
	 * @return String
	 */
	public String getSd_dep_phyadm() {
		return ((String) getAttrVal("Sd_dep_phyadm"));
	}
	/**
	 * 入院科室code
	 * @param Sd_dep_phyadm
	 */
	public void setSd_dep_phyadm(String Sd_dep_phyadm) {
		setAttrVal("Sd_dep_phyadm", Sd_dep_phyadm);
	}
	/**
	 * 入院科室name
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 入院科室name
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 主管医生id
	 * @return String
	 */
	public String getId_doc() {
		return ((String) getAttrVal("Id_doc"));
	}
	/**
	 * 主管医生id
	 * @param Id_doc
	 */
	public void setId_doc(String Id_doc) {
		setAttrVal("Id_doc", Id_doc);
	}
	/**
	 * 主管医生code
	 * @return String
	 */
	public String getSd_doc() {
		return ((String) getAttrVal("Sd_doc"));
	}
	/**
	 * 主管医生code
	 * @param Sd_doc
	 */
	public void setSd_doc(String Sd_doc) {
		setAttrVal("Sd_doc", Sd_doc);
	}
	/**
	 * 主管医生name
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}
	/**
	 * 主管医生name
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	/**
	 * 病床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 病床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 入院次数
	 * @return Integer
	 */
	public Integer getTimes_inhos() {
		return ((Integer) getAttrVal("Times_inhos"));
	}
	/**
	 * 入院次数
	 * @param Times_inhos
	 */
	public void setTimes_inhos(Integer Times_inhos) {
		setAttrVal("Times_inhos", Times_inhos);
	}
	/**
	 * 医疗记录类型id
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}
	/**
	 * 医疗记录类型id
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 医疗记录类型code
	 * @return String
	 */
	public String getSd_mrtp() {
		return ((String) getAttrVal("Sd_mrtp"));
	}
	/**
	 * 医疗记录类型code
	 * @param Sd_mrtp
	 */
	public void setSd_mrtp(String Sd_mrtp) {
		setAttrVal("Sd_mrtp", Sd_mrtp);
	}
	/**
	 * 医疗记录类型name
	 * @return String
	 */
	public String getName_mrtp() {
		return ((String) getAttrVal("Name_mrtp"));
	}
	/**
	 * 医疗记录类型name
	 * @param Name_mrtp
	 */
	public void setName_mrtp(String Name_mrtp) {
		setAttrVal("Name_mrtp", Name_mrtp);
	}
	/**
	 * 医疗记录模板id
	 * @return String
	 */
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}
	/**
	 * 医疗记录模板id
	 * @param Id_mrtpl
	 */
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	/**
	 * 医疗记录模板code
	 * @return String
	 */
	public String getSd_mrtpl() {
		return ((String) getAttrVal("Sd_mrtpl"));
	}
	/**
	 * 医疗记录模板code
	 * @param Sd_mrtpl
	 */
	public void setSd_mrtpl(String Sd_mrtpl) {
		setAttrVal("Sd_mrtpl", Sd_mrtpl);
	}
	/**
	 * 医疗记录模板name
	 * @return String
	 */
	public String getName_mrtpl() {
		return ((String) getAttrVal("Name_mrtpl"));
	}
	/**
	 * 医疗记录模板name
	 * @param Name_mrtpl
	 */
	public void setName_mrtpl(String Name_mrtpl) {
		setAttrVal("Name_mrtpl", Name_mrtpl);
	}
	/**
	 * 医疗记录状态id
	 * @return String
	 */
	public String getId_su_mr() {
		return ((String) getAttrVal("Id_su_mr"));
	}
	/**
	 * 医疗记录状态id
	 * @param Id_su_mr
	 */
	public void setId_su_mr(String Id_su_mr) {
		setAttrVal("Id_su_mr", Id_su_mr);
	}
	/**
	 * 医疗记录状态code
	 * @return String
	 */
	public String getSd_su_mr() {
		return ((String) getAttrVal("Sd_su_mr"));
	}
	/**
	 * 医疗记录状态code
	 * @param Sd_su_mr
	 */
	public void setSd_su_mr(String Sd_su_mr) {
		setAttrVal("Sd_su_mr", Sd_su_mr);
	}
	/**
	 * 医疗记录状态name
	 * @return String
	 */
	public String getName_su_mr() {
		return ((String) getAttrVal("Name_su_mr"));
	}
	/**
	 * 医疗记录状态name
	 * @param Name_su_mr
	 */
	public void setName_su_mr(String Name_su_mr) {
		setAttrVal("Name_su_mr", Name_su_mr);
	}
	/**
	 * 提交标识
	 * @return FBoolean
	 */
	public FBoolean getFg_submit() {
		return ((FBoolean) getAttrVal("Fg_submit"));
	}
	/**
	 * 提交标识
	 * @param Fg_submit
	 */
	public void setFg_submit(FBoolean Fg_submit) {
		setAttrVal("Fg_submit", Fg_submit);
	}
	/**
	 * 完成标识
	 * @return FBoolean
	 */
	public FBoolean getFg_complete() {
		return ((FBoolean) getAttrVal("Fg_complete"));
	}
	/**
	 * 完成标识
	 * @param Fg_complete
	 */
	public void setFg_complete(FBoolean Fg_complete) {
		setAttrVal("Fg_complete", Fg_complete);
	}
	/**
	 * 病历任务id
	 * @return String
	 */
	public String getId_mrtask() {
		return ((String) getAttrVal("Id_mrtask"));
	}
	/**
	 * 病历任务id
	 * @param Id_mrtask
	 */
	public void setId_mrtask(String Id_mrtask) {
		setAttrVal("Id_mrtask", Id_mrtask);
	}
	/**
	 * 病历创建时间
	 * @return String
	 */
	public String getDt_creat() {
		return ((String) getAttrVal("Dt_creat"));
	}
	/**
	 * 病历创建时间
	 * @param Dt_creat
	 */
	public void setDt_creat(String Dt_creat) {
		setAttrVal("Dt_creat", Dt_creat);
	}
	/**
	 * 病历提交时间
	 * @return String
	 */
	public String getDt_submit() {
		return ((String) getAttrVal("Dt_submit"));
	}
	/**
	 * 病历提交时间
	 * @param Dt_submit
	 */
	public void setDt_submit(String Dt_submit) {
		setAttrVal("Dt_submit", Dt_submit);
	}
	/**
	 * 书写超时时长
	 * @return String
	 */
	public String getOvertime() {
		return ((String) getAttrVal("Overtime"));
	}
	/**
	 * 书写超时时长
	 * @param Overtime
	 */
	public void setOvertime(String Overtime) {
		setAttrVal("Overtime", Overtime);
	}
	/**
	 * 病历任务状态id
	 * @return String
	 */
	public String getId_mrtask_sta() {
		return ((String) getAttrVal("Id_mrtask_sta"));
	}
	/**
	 * 病历任务状态id
	 * @param Id_mrtask_sta
	 */
	public void setId_mrtask_sta(String Id_mrtask_sta) {
		setAttrVal("Id_mrtask_sta", Id_mrtask_sta);
	}
	/**
	 * 病历任务状态code
	 * @return String
	 */
	public String getSd_mrtask_sta() {
		return ((String) getAttrVal("Sd_mrtask_sta"));
	}
	/**
	 * 病历任务状态code
	 * @param Sd_mrtask_sta
	 */
	public void setSd_mrtask_sta(String Sd_mrtask_sta) {
		setAttrVal("Sd_mrtask_sta", Sd_mrtask_sta);
	}
	/**
	 * 病历任务状态name
	 * @return String
	 */
	public String getName_mrtask_sta() {
		return ((String) getAttrVal("Name_mrtask_sta"));
	}
	/**
	 * 病历任务状态name
	 * @param Name_mrtask_sta
	 */
	public void setName_mrtask_sta(String Name_mrtask_sta) {
		setAttrVal("Name_mrtask_sta", Name_mrtask_sta);
	}
	/**
	 * 病历任务开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_start() {
		return ((FDateTime) getAttrVal("Dt_start"));
	}
	/**
	 * 病历任务开始时间
	 * @param Dt_start
	 */
	public void setDt_start(FDateTime Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	/**
	 * 病历任务结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_finish() {
		return ((FDateTime) getAttrVal("Dt_finish"));
	}
	/**
	 * 病历任务结束时间
	 * @param Dt_finish
	 */
	public void setDt_finish(FDateTime Dt_finish) {
		setAttrVal("Dt_finish", Dt_finish);
	}
	/**
	 * 病历超时未完成标识
	 * @return FBoolean
	 */
	public FBoolean getFg_over_uncomp() {
		return ((FBoolean) getAttrVal("Fg_over_uncomp"));
	}
	/**
	 * 病历超时未完成标识
	 * @param Fg_over_uncomp
	 */
	public void setFg_over_uncomp(FBoolean Fg_over_uncomp) {
		setAttrVal("Fg_over_uncomp", Fg_over_uncomp);
	}
	/**
	 * 病历超时已完成标识
	 * @return FBoolean
	 */
	public FBoolean getFg_over_comp() {
		return ((FBoolean) getAttrVal("Fg_over_comp"));
	}
	/**
	 * 病历超时已完成标识
	 * @param Fg_over_comp
	 */
	public void setFg_over_comp(FBoolean Fg_over_comp) {
		setAttrVal("Fg_over_comp", Fg_over_comp);
	}
	/**
	 * 病历已完成标识
	 * @return FBoolean
	 */
	public FBoolean getFg_comp() {
		return ((FBoolean) getAttrVal("Fg_comp"));
	}
	/**
	 * 病历已完成标识
	 * @param Fg_comp
	 */
	public void setFg_comp(FBoolean Fg_comp) {
		setAttrVal("Fg_comp", Fg_comp);
	}
	/**
	 * 病历待书写标识
	 * @return FBoolean
	 */
	public FBoolean getFg_uncreat() {
		return ((FBoolean) getAttrVal("Fg_uncreat"));
	}
	/**
	 * 病历待书写标识
	 * @param Fg_uncreat
	 */
	public void setFg_uncreat(FBoolean Fg_uncreat) {
		setAttrVal("Fg_uncreat", Fg_uncreat);
	}
	/**
	 * 医疗记录类型自定义分类id
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}
	/**
	 * 医疗记录类型自定义分类id
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 医疗记录类型自定义分类code
	 * @return String
	 */
	public String getSd_mrcactm() {
		return ((String) getAttrVal("Sd_mrcactm"));
	}
	/**
	 * 医疗记录类型自定义分类code
	 * @param Sd_mrcactm
	 */
	public void setSd_mrcactm(String Sd_mrcactm) {
		setAttrVal("Sd_mrcactm", Sd_mrcactm);
	}
	/**
	 * 医疗记录类型自定义分类name
	 * @return String
	 */
	public String getName_mrcactm() {
		return ((String) getAttrVal("Name_mrcactm"));
	}
	/**
	 * 医疗记录类型自定义分类name
	 * @param Name_mrcactm
	 */
	public void setName_mrcactm(String Name_mrcactm) {
		setAttrVal("Name_mrcactm", Name_mrcactm);
	}
}