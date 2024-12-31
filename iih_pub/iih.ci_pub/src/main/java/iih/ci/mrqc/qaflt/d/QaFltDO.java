package iih.ci.mrqc.qaflt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.qaflt.d.desc.QaFltDODesc;
import java.math.BigDecimal;

/**
 * 质控缺陷 DO数据 
 * 
 */
public class QaFltDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_QA_FLT= "Id_qa_flt";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//整改通知
	public static final String ID_REVISION= "Id_revision";
	//质控项
	public static final String ID_QA_ITM= "Id_qa_itm";
	//质控类型
	public static final String ID_QA_TY= "Id_qa_ty";
	//质控类型编码
	public static final String SD_QA_TY= "Sd_qa_ty";
	//缺陷状态
	public static final String ID_FLT_STA= "Id_flt_sta";
	//缺陷状态编码
	public static final String SD_FLT_STA= "Sd_flt_sta";
	//提出时间
	public static final String DT_SBMT= "Dt_sbmt";
	//提出人
	public static final String ID_SBMT_USER= "Id_sbmt_user";
	//提出科室
	public static final String ID_SBMT_DEPT= "Id_sbmt_dept";
	//整改要求
	public static final String RFM_REQ= "Rfm_req";
	//整改时间
	public static final String DT_RFM= "Dt_rfm";
	//整改人
	public static final String ID_RFM_USER= "Id_rfm_user";
	//整改科室
	public static final String ID_RFM_DEPT= "Id_rfm_dept";
	//整改说明
	public static final String RFM_DES= "Rfm_des";
	//审核时间
	public static final String DT_VRF= "Dt_vrf";
	//审核人
	public static final String ID_VRF_USER= "Id_vrf_user";
	//审核科室
	public static final String ID_VRF_DEPT= "Id_vrf_dept";
	//扣分说明
	public static final String DRP_DES= "Drp_des";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//病历文书编码
	public static final String ID_MR= "Id_mr";
	//缺陷扣分次数
	public static final String DEDUCT_SCR_TIMES= "Deduct_scr_times";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//实际扣分的分值
	public static final String REAL_SCORE= "Real_score";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String QA_TY_CODE= "Qa_ty_code";
	//名称
	public static final String QA_TY_NAME= "Qa_ty_name";
	//编码
	public static final String FLT_STA_CODE= "Flt_sta_code";
	//名称
	public static final String FLT_STA_NAME= "Flt_sta_name";
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
	public String getId_qa_flt() {
		return ((String) getAttrVal("Id_qa_flt"));
	}	
	/**
	 * 主键
	 * @param Id_qa_flt
	 */
	public void setId_qa_flt(String Id_qa_flt) {
		setAttrVal("Id_qa_flt", Id_qa_flt);
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
	 * 整改通知
	 * @return String
	 */
	public String getId_revision() {
		return ((String) getAttrVal("Id_revision"));
	}	
	/**
	 * 整改通知
	 * @param Id_revision
	 */
	public void setId_revision(String Id_revision) {
		setAttrVal("Id_revision", Id_revision);
	}
	/**
	 * 质控项
	 * @return String
	 */
	public String getId_qa_itm() {
		return ((String) getAttrVal("Id_qa_itm"));
	}	
	/**
	 * 质控项
	 * @param Id_qa_itm
	 */
	public void setId_qa_itm(String Id_qa_itm) {
		setAttrVal("Id_qa_itm", Id_qa_itm);
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
	 * 缺陷状态
	 * @return String
	 */
	public String getId_flt_sta() {
		return ((String) getAttrVal("Id_flt_sta"));
	}	
	/**
	 * 缺陷状态
	 * @param Id_flt_sta
	 */
	public void setId_flt_sta(String Id_flt_sta) {
		setAttrVal("Id_flt_sta", Id_flt_sta);
	}
	/**
	 * 缺陷状态编码
	 * @return String
	 */
	public String getSd_flt_sta() {
		return ((String) getAttrVal("Sd_flt_sta"));
	}	
	/**
	 * 缺陷状态编码
	 * @param Sd_flt_sta
	 */
	public void setSd_flt_sta(String Sd_flt_sta) {
		setAttrVal("Sd_flt_sta", Sd_flt_sta);
	}
	/**
	 * 提出时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sbmt() {
		return ((FDateTime) getAttrVal("Dt_sbmt"));
	}	
	/**
	 * 提出时间
	 * @param Dt_sbmt
	 */
	public void setDt_sbmt(FDateTime Dt_sbmt) {
		setAttrVal("Dt_sbmt", Dt_sbmt);
	}
	/**
	 * 提出人
	 * @return String
	 */
	public String getId_sbmt_user() {
		return ((String) getAttrVal("Id_sbmt_user"));
	}	
	/**
	 * 提出人
	 * @param Id_sbmt_user
	 */
	public void setId_sbmt_user(String Id_sbmt_user) {
		setAttrVal("Id_sbmt_user", Id_sbmt_user);
	}
	/**
	 * 提出科室
	 * @return String
	 */
	public String getId_sbmt_dept() {
		return ((String) getAttrVal("Id_sbmt_dept"));
	}	
	/**
	 * 提出科室
	 * @param Id_sbmt_dept
	 */
	public void setId_sbmt_dept(String Id_sbmt_dept) {
		setAttrVal("Id_sbmt_dept", Id_sbmt_dept);
	}
	/**
	 * 整改要求
	 * @return String
	 */
	public String getRfm_req() {
		return ((String) getAttrVal("Rfm_req"));
	}	
	/**
	 * 整改要求
	 * @param Rfm_req
	 */
	public void setRfm_req(String Rfm_req) {
		setAttrVal("Rfm_req", Rfm_req);
	}
	/**
	 * 整改时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rfm() {
		return ((FDateTime) getAttrVal("Dt_rfm"));
	}	
	/**
	 * 整改时间
	 * @param Dt_rfm
	 */
	public void setDt_rfm(FDateTime Dt_rfm) {
		setAttrVal("Dt_rfm", Dt_rfm);
	}
	/**
	 * 整改人
	 * @return String
	 */
	public String getId_rfm_user() {
		return ((String) getAttrVal("Id_rfm_user"));
	}	
	/**
	 * 整改人
	 * @param Id_rfm_user
	 */
	public void setId_rfm_user(String Id_rfm_user) {
		setAttrVal("Id_rfm_user", Id_rfm_user);
	}
	/**
	 * 整改科室
	 * @return String
	 */
	public String getId_rfm_dept() {
		return ((String) getAttrVal("Id_rfm_dept"));
	}	
	/**
	 * 整改科室
	 * @param Id_rfm_dept
	 */
	public void setId_rfm_dept(String Id_rfm_dept) {
		setAttrVal("Id_rfm_dept", Id_rfm_dept);
	}
	/**
	 * 整改说明
	 * @return String
	 */
	public String getRfm_des() {
		return ((String) getAttrVal("Rfm_des"));
	}	
	/**
	 * 整改说明
	 * @param Rfm_des
	 */
	public void setRfm_des(String Rfm_des) {
		setAttrVal("Rfm_des", Rfm_des);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vrf() {
		return ((FDateTime) getAttrVal("Dt_vrf"));
	}	
	/**
	 * 审核时间
	 * @param Dt_vrf
	 */
	public void setDt_vrf(FDateTime Dt_vrf) {
		setAttrVal("Dt_vrf", Dt_vrf);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_vrf_user() {
		return ((String) getAttrVal("Id_vrf_user"));
	}	
	/**
	 * 审核人
	 * @param Id_vrf_user
	 */
	public void setId_vrf_user(String Id_vrf_user) {
		setAttrVal("Id_vrf_user", Id_vrf_user);
	}
	/**
	 * 审核科室
	 * @return String
	 */
	public String getId_vrf_dept() {
		return ((String) getAttrVal("Id_vrf_dept"));
	}	
	/**
	 * 审核科室
	 * @param Id_vrf_dept
	 */
	public void setId_vrf_dept(String Id_vrf_dept) {
		setAttrVal("Id_vrf_dept", Id_vrf_dept);
	}
	/**
	 * 扣分说明
	 * @return String
	 */
	public String getDrp_des() {
		return ((String) getAttrVal("Drp_des"));
	}	
	/**
	 * 扣分说明
	 * @param Drp_des
	 */
	public void setDrp_des(String Drp_des) {
		setAttrVal("Drp_des", Drp_des);
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
	 * 病历文书编码
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	/**
	 * 病历文书编码
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 缺陷扣分次数
	 * @return Integer
	 */
	public Integer getDeduct_scr_times() {
		return ((Integer) getAttrVal("Deduct_scr_times"));
	}	
	/**
	 * 缺陷扣分次数
	 * @param Deduct_scr_times
	 */
	public void setDeduct_scr_times(Integer Deduct_scr_times) {
		setAttrVal("Deduct_scr_times", Deduct_scr_times);
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
	 * 实际扣分的分值
	 * @return FDouble
	 */
	public FDouble getReal_score() {
		return ((FDouble) getAttrVal("Real_score"));
	}	
	/**
	 * 实际扣分的分值
	 * @param Real_score
	 */
	public void setReal_score(FDouble Real_score) {
		setAttrVal("Real_score", Real_score);
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
	 * 编码
	 * @return String
	 */
	public String getQa_ty_code() {
		return ((String) getAttrVal("Qa_ty_code"));
	}	
	/**
	 * 编码
	 * @param Qa_ty_code
	 */
	public void setQa_ty_code(String Qa_ty_code) {
		setAttrVal("Qa_ty_code", Qa_ty_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getQa_ty_name() {
		return ((String) getAttrVal("Qa_ty_name"));
	}	
	/**
	 * 名称
	 * @param Qa_ty_name
	 */
	public void setQa_ty_name(String Qa_ty_name) {
		setAttrVal("Qa_ty_name", Qa_ty_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getFlt_sta_code() {
		return ((String) getAttrVal("Flt_sta_code"));
	}	
	/**
	 * 编码
	 * @param Flt_sta_code
	 */
	public void setFlt_sta_code(String Flt_sta_code) {
		setAttrVal("Flt_sta_code", Flt_sta_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFlt_sta_name() {
		return ((String) getAttrVal("Flt_sta_name"));
	}	
	/**
	 * 名称
	 * @param Flt_sta_name
	 */
	public void setFlt_sta_name(String Flt_sta_name) {
		setAttrVal("Flt_sta_name", Flt_sta_name);
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
		return "Id_qa_flt";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_flt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QaFltDODesc.class);
	}
	
}