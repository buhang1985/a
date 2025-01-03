package iih.ci.mrqc.divide.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.divide.d.desc.DivideDODesc;
import java.math.BigDecimal;

/**
 * 质控评分表 DO数据 
 * 
 */
public class DivideDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//评分编码
	public static final String ID_QA_DIVIDE= "Id_qa_divide";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//质控项
	public static final String ID_QA_ITM= "Id_qa_itm";
	//自动质控项主键
	public static final String ID_QA_ITM_CONFIG= "Id_qa_itm_config";
	//质控类型
	public static final String ID_QA_TY= "Id_qa_ty";
	//质控类型编码
	public static final String SD_QA_TY= "Sd_qa_ty";
	//提出时间
	public static final String SBMT_TIME= "Sbmt_time";
	//提出人
	public static final String ID_SBMT_USER= "Id_sbmt_user";
	//提出科室
	public static final String ID_SBMT_DEPT= "Id_sbmt_dept";
	//整改要求
	public static final String RFM_REQ= "Rfm_req";
	//扣分说明
	public static final String DRP_DES= "Drp_des";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//扣分次数
	public static final String DEDUCT_SCR_TIMES= "Deduct_scr_times";
	//最后得分
	public static final String QA_SCR= "Qa_scr";
	//是否自查
	public static final String FG_CHECKSELF= "Fg_checkself";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//实际扣分值
	public static final String REAL_SCORE= "Real_score";
	//质控工作记录id
	public static final String ID_QA= "Id_qa";
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
	 * 评分编码
	 * @return String
	 */
	public String getId_qa_divide() {
		return ((String) getAttrVal("Id_qa_divide"));
	}	
	/**
	 * 评分编码
	 * @param Id_qa_divide
	 */
	public void setId_qa_divide(String Id_qa_divide) {
		setAttrVal("Id_qa_divide", Id_qa_divide);
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
	 * 自动质控项主键
	 * @return String
	 */
	public String getId_qa_itm_config() {
		return ((String) getAttrVal("Id_qa_itm_config"));
	}	
	/**
	 * 自动质控项主键
	 * @param Id_qa_itm_config
	 */
	public void setId_qa_itm_config(String Id_qa_itm_config) {
		setAttrVal("Id_qa_itm_config", Id_qa_itm_config);
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
	 * 提出时间
	 * @return FDateTime
	 */
	public FDateTime getSbmt_time() {
		return ((FDateTime) getAttrVal("Sbmt_time"));
	}	
	/**
	 * 提出时间
	 * @param Sbmt_time
	 */
	public void setSbmt_time(FDateTime Sbmt_time) {
		setAttrVal("Sbmt_time", Sbmt_time);
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
	 * 扣分次数
	 * @return Integer
	 */
	public Integer getDeduct_scr_times() {
		return ((Integer) getAttrVal("Deduct_scr_times"));
	}	
	/**
	 * 扣分次数
	 * @param Deduct_scr_times
	 */
	public void setDeduct_scr_times(Integer Deduct_scr_times) {
		setAttrVal("Deduct_scr_times", Deduct_scr_times);
	}
	/**
	 * 最后得分
	 * @return Integer
	 */
	public Integer getQa_scr() {
		return ((Integer) getAttrVal("Qa_scr"));
	}	
	/**
	 * 最后得分
	 * @param Qa_scr
	 */
	public void setQa_scr(Integer Qa_scr) {
		setAttrVal("Qa_scr", Qa_scr);
	}
	/**
	 * 是否自查
	 * @return FBoolean
	 */
	public FBoolean getFg_checkself() {
		return ((FBoolean) getAttrVal("Fg_checkself"));
	}	
	/**
	 * 是否自查
	 * @param Fg_checkself
	 */
	public void setFg_checkself(FBoolean Fg_checkself) {
		setAttrVal("Fg_checkself", Fg_checkself);
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
	 * 实际扣分值
	 * @return FDouble
	 */
	public FDouble getReal_score() {
		return ((FDouble) getAttrVal("Real_score"));
	}	
	/**
	 * 实际扣分值
	 * @param Real_score
	 */
	public void setReal_score(FDouble Real_score) {
		setAttrVal("Real_score", Real_score);
	}
	/**
	 * 质控工作记录id
	 * @return String
	 */
	public String getId_qa() {
		return ((String) getAttrVal("Id_qa"));
	}	
	/**
	 * 质控工作记录id
	 * @param Id_qa
	 */
	public void setId_qa(String Id_qa) {
		setAttrVal("Id_qa", Id_qa);
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
		return "Id_qa_divide";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_divide";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DivideDODesc.class);
	}
	
}