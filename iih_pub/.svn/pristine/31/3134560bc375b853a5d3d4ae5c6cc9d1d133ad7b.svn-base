package iih.nm.nqm.nqmchk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmchk.d.desc.NqmChkDODesc;
import java.math.BigDecimal;

/**
 * 质量检查 DO数据 
 * 
 */
public class NqmChkDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//质量检查主键
	public static final String ID_NQM_CHK= "Id_nqm_chk";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//受检科室id
	public static final String ID_DEP= "Id_dep";
	//检查任务
	public static final String ID_NQM_TASK= "Id_nqm_task";
	//检查日期
	public static final String DT_CHK= "Dt_chk";
	//指控级别id
	public static final String ID_CHK_LVL= "Id_chk_lvl";
	//质控级别编码
	public static final String SD_CHK_LVL= "Sd_chk_lvl";
	//受检单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//受检单元编码
	public static final String CODE_DEP_NUR= "Code_dep_nur";
	//检查标准
	public static final String ID_NQM_CS= "Id_nqm_cs";
	//质控标准编码
	public static final String CODE_NQM_CS= "Code_nqm_cs";
	//检查模板
	public static final String ID_NQM_CSTMPL= "Id_nqm_cstmpl";
	//标准总分
	public static final String SCORE_CS= "Score_cs";
	//检查得分
	public static final String SCORE_CHK= "Score_chk";
	//标准得分
	public static final String SCORE_CSCHK= "Score_cschk";
	//模板合格分
	public static final String PASSGRADE= "Passgrade";
	//合格标识
	public static final String FG_PASS= "Fg_pass";
	//检查状态
	public static final String ID_STATUS= "Id_status";
	//检查状态编码
	public static final String SD_STATUS= "Sd_status";
	//检查者
	public static final String ID_CHK_PSN= "Id_chk_psn";
	//质控组
	public static final String ID_QC_GRP= "Id_qc_grp";
	//其他检查者
	public static final String ID_CHK_PSN_OTH= "Id_chk_psn_oth";
	//满分标记
	public static final String FG_AC= "Fg_ac";
	//扣分原因
	public static final String REA_POINTS= "Rea_points";
	//床号
	public static final String CODE_BED= "Code_bed";
	//患者
	public static final String NAME_PAT= "Name_pat";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//描述
	public static final String DES= "Des";
	//符合率
	public static final String RATE_CONFORM= "Rate_conform";
	//问题总结
	public static final String ISSUE_SMY= "Issue_smy";
	//原因分析
	public static final String REAS_ANLY= "Reas_anly";
	//整改措施
	public static final String MEND_MEAS= "Mend_meas";
	//整改状态id
	public static final String ID_MEND_STATUS= "Id_mend_status";
	//整改状态编码
	public static final String SD_MEND_STATUS= "Sd_mend_status";
	//预期目标
	public static final String EXP_GOAL= "Exp_goal";
	//执行情况
	public static final String EXEC_COND= "Exec_cond";
	//效果评价
	public static final String EFFEC_EVAL= "Effec_eval";
	//片区意见
	public static final String AREA_ADVICE= "Area_advice";
	//护理部意见
	public static final String NURDEP_ADVICE= "Nurdep_advice";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	// 流程任务ID
	public static final String ID_TASK= "Id_task";
	//申请状态ID
	public static final String ID_APY_STATUS= "Id_apy_status";
	//申请状态编码
	public static final String SD_APY_STATUS= "Sd_apy_status";
	//审核人
	public static final String ID_AUDIT_PSN= "Id_audit_psn";
	//审核时间
	public static final String DT_AUDIT= "Dt_audit";
	//审核意见
	public static final String AUDIT_COMMENT= "Audit_comment";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_DEP= "Name_dep";
	//编码
	public static final String CODE_DEP= "Code_dep";
	//检查任务名称
	public static final String NAME_NQM_TASK= "Name_nqm_task";
	//质控级别
	public static final String NAME_CHK_LVL= "Name_chk_lvl";
	//护理单元名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//护理单元编码
	public static final String CODE_DEPNUR= "Code_depnur";
	//标准名称
	public static final String NAME_NQM_CS= "Name_nqm_cs";
	//标准总分
	public static final String SCORE_NQM_CS= "Score_nqm_cs";
	//标准合格比率
	public static final String FPY_NQM_CS= "Fpy_nqm_cs";
	//模板名称
	public static final String NAME_NQM_CSTMPL= "Name_nqm_cstmpl";
	//编码
	public static final String CODE_STATUS= "Code_status";
	//名称
	public static final String NAME_STATUS= "Name_status";
	//人员姓名
	public static final String NAME_CHK_PSN= "Name_chk_psn";
	//小组名称
	public static final String NAME_QC_GRP= "Name_qc_grp";
	//人员姓名
	public static final String NAME= "Name";
	//名称
	public static final String NAME_APY_STATUS= "Name_apy_status";
	//审核人
	public static final String NAME_AUDIT_PSN= "Name_audit_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 质量检查主键
	 * @return String
	 */
	public String getId_nqm_chk() {
		return ((String) getAttrVal("Id_nqm_chk"));
	}	
	/**
	 * 质量检查主键
	 * @param Id_nqm_chk
	 */
	public void setId_nqm_chk(String Id_nqm_chk) {
		setAttrVal("Id_nqm_chk", Id_nqm_chk);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 受检科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 受检科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 检查任务
	 * @return String
	 */
	public String getId_nqm_task() {
		return ((String) getAttrVal("Id_nqm_task"));
	}	
	/**
	 * 检查任务
	 * @param Id_nqm_task
	 */
	public void setId_nqm_task(String Id_nqm_task) {
		setAttrVal("Id_nqm_task", Id_nqm_task);
	}
	/**
	 * 检查日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 检查日期
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 指控级别id
	 * @return String
	 */
	public String getId_chk_lvl() {
		return ((String) getAttrVal("Id_chk_lvl"));
	}	
	/**
	 * 指控级别id
	 * @param Id_chk_lvl
	 */
	public void setId_chk_lvl(String Id_chk_lvl) {
		setAttrVal("Id_chk_lvl", Id_chk_lvl);
	}
	/**
	 * 质控级别编码
	 * @return String
	 */
	public String getSd_chk_lvl() {
		return ((String) getAttrVal("Sd_chk_lvl"));
	}	
	/**
	 * 质控级别编码
	 * @param Sd_chk_lvl
	 */
	public void setSd_chk_lvl(String Sd_chk_lvl) {
		setAttrVal("Sd_chk_lvl", Sd_chk_lvl);
	}
	/**
	 * 受检单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 受检单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 受检单元编码
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	/**
	 * 受检单元编码
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 检查标准
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	/**
	 * 检查标准
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 质控标准编码
	 * @return String
	 */
	public String getCode_nqm_cs() {
		return ((String) getAttrVal("Code_nqm_cs"));
	}	
	/**
	 * 质控标准编码
	 * @param Code_nqm_cs
	 */
	public void setCode_nqm_cs(String Code_nqm_cs) {
		setAttrVal("Code_nqm_cs", Code_nqm_cs);
	}
	/**
	 * 检查模板
	 * @return String
	 */
	public String getId_nqm_cstmpl() {
		return ((String) getAttrVal("Id_nqm_cstmpl"));
	}	
	/**
	 * 检查模板
	 * @param Id_nqm_cstmpl
	 */
	public void setId_nqm_cstmpl(String Id_nqm_cstmpl) {
		setAttrVal("Id_nqm_cstmpl", Id_nqm_cstmpl);
	}
	/**
	 * 标准总分
	 * @return FDouble
	 */
	public FDouble getScore_cs() {
		return ((FDouble) getAttrVal("Score_cs"));
	}	
	/**
	 * 标准总分
	 * @param Score_cs
	 */
	public void setScore_cs(FDouble Score_cs) {
		setAttrVal("Score_cs", Score_cs);
	}
	/**
	 * 检查得分
	 * @return FDouble
	 */
	public FDouble getScore_chk() {
		return ((FDouble) getAttrVal("Score_chk"));
	}	
	/**
	 * 检查得分
	 * @param Score_chk
	 */
	public void setScore_chk(FDouble Score_chk) {
		setAttrVal("Score_chk", Score_chk);
	}
	/**
	 * 标准得分
	 * @return FDouble
	 */
	public FDouble getScore_cschk() {
		return ((FDouble) getAttrVal("Score_cschk"));
	}	
	/**
	 * 标准得分
	 * @param Score_cschk
	 */
	public void setScore_cschk(FDouble Score_cschk) {
		setAttrVal("Score_cschk", Score_cschk);
	}
	/**
	 * 模板合格分
	 * @return FDouble
	 */
	public FDouble getPassgrade() {
		return ((FDouble) getAttrVal("Passgrade"));
	}	
	/**
	 * 模板合格分
	 * @param Passgrade
	 */
	public void setPassgrade(FDouble Passgrade) {
		setAttrVal("Passgrade", Passgrade);
	}
	/**
	 * 合格标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pass() {
		return ((FBoolean) getAttrVal("Fg_pass"));
	}	
	/**
	 * 合格标识
	 * @param Fg_pass
	 */
	public void setFg_pass(FBoolean Fg_pass) {
		setAttrVal("Fg_pass", Fg_pass);
	}
	/**
	 * 检查状态
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	/**
	 * 检查状态
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 检查状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 检查状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 检查者
	 * @return String
	 */
	public String getId_chk_psn() {
		return ((String) getAttrVal("Id_chk_psn"));
	}	
	/**
	 * 检查者
	 * @param Id_chk_psn
	 */
	public void setId_chk_psn(String Id_chk_psn) {
		setAttrVal("Id_chk_psn", Id_chk_psn);
	}
	/**
	 * 质控组
	 * @return String
	 */
	public String getId_qc_grp() {
		return ((String) getAttrVal("Id_qc_grp"));
	}	
	/**
	 * 质控组
	 * @param Id_qc_grp
	 */
	public void setId_qc_grp(String Id_qc_grp) {
		setAttrVal("Id_qc_grp", Id_qc_grp);
	}
	/**
	 * 其他检查者
	 * @return String
	 */
	public String getId_chk_psn_oth() {
		return ((String) getAttrVal("Id_chk_psn_oth"));
	}	
	/**
	 * 其他检查者
	 * @param Id_chk_psn_oth
	 */
	public void setId_chk_psn_oth(String Id_chk_psn_oth) {
		setAttrVal("Id_chk_psn_oth", Id_chk_psn_oth);
	}
	/**
	 * 满分标记
	 * @return FBoolean
	 */
	public FBoolean getFg_ac() {
		return ((FBoolean) getAttrVal("Fg_ac"));
	}	
	/**
	 * 满分标记
	 * @param Fg_ac
	 */
	public void setFg_ac(FBoolean Fg_ac) {
		setAttrVal("Fg_ac", Fg_ac);
	}
	/**
	 * 扣分原因
	 * @return String
	 */
	public String getRea_points() {
		return ((String) getAttrVal("Rea_points"));
	}	
	/**
	 * 扣分原因
	 * @param Rea_points
	 */
	public void setRea_points(String Rea_points) {
		setAttrVal("Rea_points", Rea_points);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}	
	/**
	 * 床号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 符合率
	 * @return FDouble
	 */
	public FDouble getRate_conform() {
		return ((FDouble) getAttrVal("Rate_conform"));
	}	
	/**
	 * 符合率
	 * @param Rate_conform
	 */
	public void setRate_conform(FDouble Rate_conform) {
		setAttrVal("Rate_conform", Rate_conform);
	}
	/**
	 * 问题总结
	 * @return String
	 */
	public String getIssue_smy() {
		return ((String) getAttrVal("Issue_smy"));
	}	
	/**
	 * 问题总结
	 * @param Issue_smy
	 */
	public void setIssue_smy(String Issue_smy) {
		setAttrVal("Issue_smy", Issue_smy);
	}
	/**
	 * 原因分析
	 * @return String
	 */
	public String getReas_anly() {
		return ((String) getAttrVal("Reas_anly"));
	}	
	/**
	 * 原因分析
	 * @param Reas_anly
	 */
	public void setReas_anly(String Reas_anly) {
		setAttrVal("Reas_anly", Reas_anly);
	}
	/**
	 * 整改措施
	 * @return String
	 */
	public String getMend_meas() {
		return ((String) getAttrVal("Mend_meas"));
	}	
	/**
	 * 整改措施
	 * @param Mend_meas
	 */
	public void setMend_meas(String Mend_meas) {
		setAttrVal("Mend_meas", Mend_meas);
	}
	/**
	 * 整改状态id
	 * @return String
	 */
	public String getId_mend_status() {
		return ((String) getAttrVal("Id_mend_status"));
	}	
	/**
	 * 整改状态id
	 * @param Id_mend_status
	 */
	public void setId_mend_status(String Id_mend_status) {
		setAttrVal("Id_mend_status", Id_mend_status);
	}
	/**
	 * 整改状态编码
	 * @return String
	 */
	public String getSd_mend_status() {
		return ((String) getAttrVal("Sd_mend_status"));
	}	
	/**
	 * 整改状态编码
	 * @param Sd_mend_status
	 */
	public void setSd_mend_status(String Sd_mend_status) {
		setAttrVal("Sd_mend_status", Sd_mend_status);
	}
	/**
	 * 预期目标
	 * @return String
	 */
	public String getExp_goal() {
		return ((String) getAttrVal("Exp_goal"));
	}	
	/**
	 * 预期目标
	 * @param Exp_goal
	 */
	public void setExp_goal(String Exp_goal) {
		setAttrVal("Exp_goal", Exp_goal);
	}
	/**
	 * 执行情况
	 * @return String
	 */
	public String getExec_cond() {
		return ((String) getAttrVal("Exec_cond"));
	}	
	/**
	 * 执行情况
	 * @param Exec_cond
	 */
	public void setExec_cond(String Exec_cond) {
		setAttrVal("Exec_cond", Exec_cond);
	}
	/**
	 * 效果评价
	 * @return String
	 */
	public String getEffec_eval() {
		return ((String) getAttrVal("Effec_eval"));
	}	
	/**
	 * 效果评价
	 * @param Effec_eval
	 */
	public void setEffec_eval(String Effec_eval) {
		setAttrVal("Effec_eval", Effec_eval);
	}
	/**
	 * 片区意见
	 * @return String
	 */
	public String getArea_advice() {
		return ((String) getAttrVal("Area_advice"));
	}	
	/**
	 * 片区意见
	 * @param Area_advice
	 */
	public void setArea_advice(String Area_advice) {
		setAttrVal("Area_advice", Area_advice);
	}
	/**
	 * 护理部意见
	 * @return String
	 */
	public String getNurdep_advice() {
		return ((String) getAttrVal("Nurdep_advice"));
	}	
	/**
	 * 护理部意见
	 * @param Nurdep_advice
	 */
	public void setNurdep_advice(String Nurdep_advice) {
		setAttrVal("Nurdep_advice", Nurdep_advice);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 *  流程任务ID
	 * @return String
	 */
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}	
	/**
	 *  流程任务ID
	 * @param Id_task
	 */
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	/**
	 * 申请状态ID
	 * @return String
	 */
	public String getId_apy_status() {
		return ((String) getAttrVal("Id_apy_status"));
	}	
	/**
	 * 申请状态ID
	 * @param Id_apy_status
	 */
	public void setId_apy_status(String Id_apy_status) {
		setAttrVal("Id_apy_status", Id_apy_status);
	}
	/**
	 * 申请状态编码
	 * @return String
	 */
	public String getSd_apy_status() {
		return ((String) getAttrVal("Sd_apy_status"));
	}	
	/**
	 * 申请状态编码
	 * @param Sd_apy_status
	 */
	public void setSd_apy_status(String Sd_apy_status) {
		setAttrVal("Sd_apy_status", Sd_apy_status);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_audit_psn() {
		return ((String) getAttrVal("Id_audit_psn"));
	}	
	/**
	 * 审核人
	 * @param Id_audit_psn
	 */
	public void setId_audit_psn(String Id_audit_psn) {
		setAttrVal("Id_audit_psn", Id_audit_psn);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}	
	/**
	 * 审核时间
	 * @param Dt_audit
	 */
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	/**
	 * 审核意见
	 * @return String
	 */
	public String getAudit_comment() {
		return ((String) getAttrVal("Audit_comment"));
	}	
	/**
	 * 审核意见
	 * @param Audit_comment
	 */
	public void setAudit_comment(String Audit_comment) {
		setAttrVal("Audit_comment", Audit_comment);
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
	 * 名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 检查任务名称
	 * @return String
	 */
	public String getName_nqm_task() {
		return ((String) getAttrVal("Name_nqm_task"));
	}	
	/**
	 * 检查任务名称
	 * @param Name_nqm_task
	 */
	public void setName_nqm_task(String Name_nqm_task) {
		setAttrVal("Name_nqm_task", Name_nqm_task);
	}
	/**
	 * 质控级别
	 * @return String
	 */
	public String getName_chk_lvl() {
		return ((String) getAttrVal("Name_chk_lvl"));
	}	
	/**
	 * 质控级别
	 * @param Name_chk_lvl
	 */
	public void setName_chk_lvl(String Name_chk_lvl) {
		setAttrVal("Name_chk_lvl", Name_chk_lvl);
	}
	/**
	 * 护理单元名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 护理单元名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 护理单元编码
	 * @return String
	 */
	public String getCode_depnur() {
		return ((String) getAttrVal("Code_depnur"));
	}	
	/**
	 * 护理单元编码
	 * @param Code_depnur
	 */
	public void setCode_depnur(String Code_depnur) {
		setAttrVal("Code_depnur", Code_depnur);
	}
	/**
	 * 标准名称
	 * @return String
	 */
	public String getName_nqm_cs() {
		return ((String) getAttrVal("Name_nqm_cs"));
	}	
	/**
	 * 标准名称
	 * @param Name_nqm_cs
	 */
	public void setName_nqm_cs(String Name_nqm_cs) {
		setAttrVal("Name_nqm_cs", Name_nqm_cs);
	}
	/**
	 * 标准总分
	 * @return FDouble
	 */
	public FDouble getScore_nqm_cs() {
		return ((FDouble) getAttrVal("Score_nqm_cs"));
	}	
	/**
	 * 标准总分
	 * @param Score_nqm_cs
	 */
	public void setScore_nqm_cs(FDouble Score_nqm_cs) {
		setAttrVal("Score_nqm_cs", Score_nqm_cs);
	}
	/**
	 * 标准合格比率
	 * @return FDouble
	 */
	public FDouble getFpy_nqm_cs() {
		return ((FDouble) getAttrVal("Fpy_nqm_cs"));
	}	
	/**
	 * 标准合格比率
	 * @param Fpy_nqm_cs
	 */
	public void setFpy_nqm_cs(FDouble Fpy_nqm_cs) {
		setAttrVal("Fpy_nqm_cs", Fpy_nqm_cs);
	}
	/**
	 * 模板名称
	 * @return String
	 */
	public String getName_nqm_cstmpl() {
		return ((String) getAttrVal("Name_nqm_cstmpl"));
	}	
	/**
	 * 模板名称
	 * @param Name_nqm_cstmpl
	 */
	public void setName_nqm_cstmpl(String Name_nqm_cstmpl) {
		setAttrVal("Name_nqm_cstmpl", Name_nqm_cstmpl);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_status() {
		return ((String) getAttrVal("Code_status"));
	}	
	/**
	 * 编码
	 * @param Code_status
	 */
	public void setCode_status(String Code_status) {
		setAttrVal("Code_status", Code_status);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	/**
	 * 名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_chk_psn() {
		return ((String) getAttrVal("Name_chk_psn"));
	}	
	/**
	 * 人员姓名
	 * @param Name_chk_psn
	 */
	public void setName_chk_psn(String Name_chk_psn) {
		setAttrVal("Name_chk_psn", Name_chk_psn);
	}
	/**
	 * 小组名称
	 * @return String
	 */
	public String getName_qc_grp() {
		return ((String) getAttrVal("Name_qc_grp"));
	}	
	/**
	 * 小组名称
	 * @param Name_qc_grp
	 */
	public void setName_qc_grp(String Name_qc_grp) {
		setAttrVal("Name_qc_grp", Name_qc_grp);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 人员姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_apy_status() {
		return ((String) getAttrVal("Name_apy_status"));
	}	
	/**
	 * 名称
	 * @param Name_apy_status
	 */
	public void setName_apy_status(String Name_apy_status) {
		setAttrVal("Name_apy_status", Name_apy_status);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getName_audit_psn() {
		return ((String) getAttrVal("Name_audit_psn"));
	}	
	/**
	 * 审核人
	 * @param Name_audit_psn
	 */
	public void setName_audit_psn(String Name_audit_psn) {
		setAttrVal("Name_audit_psn", Name_audit_psn);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_nqm_chk";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_CHK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmChkDODesc.class);
	}
	
}