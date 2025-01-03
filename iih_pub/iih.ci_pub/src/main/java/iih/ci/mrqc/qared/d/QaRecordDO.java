package iih.ci.mrqc.qared.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.qared.d.desc.QaRecordDODesc;
import java.math.BigDecimal;

/**
 * 质控工作记录 DO数据 
 * 
 */
public class QaRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_QA= "Id_qa";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//质控类型
	public static final String ID_QA_TY= "Id_qa_ty";
	//质控类型编码
	public static final String SD_QA_TY= "Sd_qa_ty";
	//计划开始时间
	public static final String DT_PLAN= "Dt_plan";
	//实际开始时间
	public static final String DT_EXEC_BEGIN= "Dt_exec_begin";
	//实际结束时间
	public static final String DT_EXEC_END= "Dt_exec_end";
	//实际执行人
	public static final String ID_EXEC_USER= "Id_exec_user";
	//实际执行科室
	public static final String ID_EXEC_DEPT= "Id_exec_dept";
	//完成标志
	public static final String FG_CMPL= "Fg_cmpl";
	//有缺陷标志
	public static final String FG_HAVE_FLT= "Fg_have_flt";
	//有需整改标志
	public static final String FG_NEED_RFM_FLT= "Fg_need_rfm_flt";
	//整改期限
	public static final String RFM_DEADLINE= "Rfm_deadline";
	//整改截止日期
	public static final String DEADLINE= "Deadline";
	//整改通知编码
	public static final String ID_REVISION= "Id_revision";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//质控得分
	public static final String SCORE_QA_TY= "Score_qa_ty";
	//病历质量等级id
	public static final String ID_DIVIDE_LEVEL= "Id_divide_level";
	//病历质量等级
	public static final String NAME_DIVIDE_LEVEL= "Name_divide_level";
	//终末评分标识
	public static final String FG_SCORE= "Fg_score";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//用户名称
	public static final String CREATEBY_NAME= "Createby_name";
	//用户编码
	public static final String CREATEBY_CODE= "Createby_code";
	//用户名称
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	//用户编码
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_qa() {
		return ((String) getAttrVal("Id_qa"));
	}	
	/**
	 * 主键
	 * @param Id_qa
	 */
	public void setId_qa(String Id_qa) {
		setAttrVal("Id_qa", Id_qa);
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
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 质控类型
	 * @return String
	 */
	public String getId_qa_ty() {
		return ((String) getAttrVal("Id_qa_ty"));
	}	
	/**
	 * 质控类型
	 * @param Id_qa_ty
	 */
	public void setId_qa_ty(String Id_qa_ty) {
		setAttrVal("Id_qa_ty", Id_qa_ty);
	}
	/**
	 * 质控类型编码
	 * @return String
	 */
	public String getSd_qa_ty() {
		return ((String) getAttrVal("Sd_qa_ty"));
	}	
	/**
	 * 质控类型编码
	 * @param Sd_qa_ty
	 */
	public void setSd_qa_ty(String Sd_qa_ty) {
		setAttrVal("Sd_qa_ty", Sd_qa_ty);
	}
	/**
	 * 计划开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	/**
	 * 计划开始时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 实际开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exec_begin() {
		return ((FDateTime) getAttrVal("Dt_exec_begin"));
	}	
	/**
	 * 实际开始时间
	 * @param Dt_exec_begin
	 */
	public void setDt_exec_begin(FDateTime Dt_exec_begin) {
		setAttrVal("Dt_exec_begin", Dt_exec_begin);
	}
	/**
	 * 实际结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exec_end() {
		return ((FDateTime) getAttrVal("Dt_exec_end"));
	}	
	/**
	 * 实际结束时间
	 * @param Dt_exec_end
	 */
	public void setDt_exec_end(FDateTime Dt_exec_end) {
		setAttrVal("Dt_exec_end", Dt_exec_end);
	}
	/**
	 * 实际执行人
	 * @return String
	 */
	public String getId_exec_user() {
		return ((String) getAttrVal("Id_exec_user"));
	}	
	/**
	 * 实际执行人
	 * @param Id_exec_user
	 */
	public void setId_exec_user(String Id_exec_user) {
		setAttrVal("Id_exec_user", Id_exec_user);
	}
	/**
	 * 实际执行科室
	 * @return String
	 */
	public String getId_exec_dept() {
		return ((String) getAttrVal("Id_exec_dept"));
	}	
	/**
	 * 实际执行科室
	 * @param Id_exec_dept
	 */
	public void setId_exec_dept(String Id_exec_dept) {
		setAttrVal("Id_exec_dept", Id_exec_dept);
	}
	/**
	 * 完成标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cmpl() {
		return ((FBoolean) getAttrVal("Fg_cmpl"));
	}	
	/**
	 * 完成标志
	 * @param Fg_cmpl
	 */
	public void setFg_cmpl(FBoolean Fg_cmpl) {
		setAttrVal("Fg_cmpl", Fg_cmpl);
	}
	/**
	 * 有缺陷标志
	 * @return FBoolean
	 */
	public FBoolean getFg_have_flt() {
		return ((FBoolean) getAttrVal("Fg_have_flt"));
	}	
	/**
	 * 有缺陷标志
	 * @param Fg_have_flt
	 */
	public void setFg_have_flt(FBoolean Fg_have_flt) {
		setAttrVal("Fg_have_flt", Fg_have_flt);
	}
	/**
	 * 有需整改标志
	 * @return FBoolean
	 */
	public FBoolean getFg_need_rfm_flt() {
		return ((FBoolean) getAttrVal("Fg_need_rfm_flt"));
	}	
	/**
	 * 有需整改标志
	 * @param Fg_need_rfm_flt
	 */
	public void setFg_need_rfm_flt(FBoolean Fg_need_rfm_flt) {
		setAttrVal("Fg_need_rfm_flt", Fg_need_rfm_flt);
	}
	/**
	 * 整改期限
	 * @return Integer
	 */
	public Integer getRfm_deadline() {
		return ((Integer) getAttrVal("Rfm_deadline"));
	}	
	/**
	 * 整改期限
	 * @param Rfm_deadline
	 */
	public void setRfm_deadline(Integer Rfm_deadline) {
		setAttrVal("Rfm_deadline", Rfm_deadline);
	}
	/**
	 * 整改截止日期
	 * @return FDateTime
	 */
	public FDateTime getDeadline() {
		return ((FDateTime) getAttrVal("Deadline"));
	}	
	/**
	 * 整改截止日期
	 * @param Deadline
	 */
	public void setDeadline(FDateTime Deadline) {
		setAttrVal("Deadline", Deadline);
	}
	/**
	 * 整改通知编码
	 * @return String
	 */
	public String getId_revision() {
		return ((String) getAttrVal("Id_revision"));
	}	
	/**
	 * 整改通知编码
	 * @param Id_revision
	 */
	public void setId_revision(String Id_revision) {
		setAttrVal("Id_revision", Id_revision);
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
	 * 质控得分
	 * @return FDouble
	 */
	public FDouble getScore_qa_ty() {
		return ((FDouble) getAttrVal("Score_qa_ty"));
	}	
	/**
	 * 质控得分
	 * @param Score_qa_ty
	 */
	public void setScore_qa_ty(FDouble Score_qa_ty) {
		setAttrVal("Score_qa_ty", Score_qa_ty);
	}
	/**
	 * 病历质量等级id
	 * @return String
	 */
	public String getId_divide_level() {
		return ((String) getAttrVal("Id_divide_level"));
	}	
	/**
	 * 病历质量等级id
	 * @param Id_divide_level
	 */
	public void setId_divide_level(String Id_divide_level) {
		setAttrVal("Id_divide_level", Id_divide_level);
	}
	/**
	 * 病历质量等级
	 * @return String
	 */
	public String getName_divide_level() {
		return ((String) getAttrVal("Name_divide_level"));
	}	
	/**
	 * 病历质量等级
	 * @param Name_divide_level
	 */
	public void setName_divide_level(String Name_divide_level) {
		setAttrVal("Name_divide_level", Name_divide_level);
	}
	/**
	 * 终末评分标识
	 * @return FBoolean
	 */
	public FBoolean getFg_score() {
		return ((FBoolean) getAttrVal("Fg_score"));
	}	
	/**
	 * 终末评分标识
	 * @param Fg_score
	 */
	public void setFg_score(FBoolean Fg_score) {
		setAttrVal("Fg_score", Fg_score);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreateby_name() {
		return ((String) getAttrVal("Createby_name"));
	}	
	/**
	 * 用户名称
	 * @param Createby_name
	 */
	public void setCreateby_name(String Createby_name) {
		setAttrVal("Createby_name", Createby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreateby_code() {
		return ((String) getAttrVal("Createby_code"));
	}	
	/**
	 * 用户编码
	 * @param Createby_code
	 */
	public void setCreateby_code(String Createby_code) {
		setAttrVal("Createby_code", Createby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	/**
	 * 用户名称
	 * @param Modifiedby_name
	 */
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	/**
	 * 用户编码
	 * @param Modifiedby_code
	 */
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
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
		return "Id_qa";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_record";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QaRecordDODesc.class);
	}
	
}