package iih.nm.nit.nitlv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitlv.d.desc.NitLvDODesc;
import java.math.BigDecimal;

/**
 * 实习生请假 DO数据 
 * 
 */
public class NitLvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//实习生请假主键
	public static final String ID_NUR_LV= "Id_nur_lv";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//院校id
	public static final String ID_NIT_SRO= "Id_nit_sro";
	//批次
	public static final String ID_NIT_SRO_BCH= "Id_nit_sro_bch";
	//实习进修人员
	public static final String ID_NUR= "Id_nur";
	//申请开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//申请结束时间
	public static final String DT_END= "Dt_end";
	//申请天数
	public static final String DAYS_LV= "Days_lv";
	//申请事由
	public static final String REASION_LV= "Reasion_lv";
	//登记人
	public static final String ID_REG= "Id_reg";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//申请状态id
	public static final String ID_STATUS= "Id_status";
	//申请状态
	public static final String SD_STATUS= "Sd_status";
	//审批意见
	public static final String APPROVALOP= "Approvalop";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//流程任务ID
	public static final String ID_TASK= "Id_task";
	//审核人
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
	//审核时间
	public static final String DT_AUDIT= "Dt_audit";
	//审意见核
	public static final String APCOMMENTS= "Apcomments";
	//是否多版本
	public static final String FG_MULTIVER= "Fg_multiver";
	//实习进修主键
	public static final String ID_NIT_PSNINFO= "Id_nit_psninfo";
	//院校名称
	public static final String NAME_ID_NIT_SRO= "Name_id_nit_sro";
	//批次名称
	public static final String NAME_ID_NIT_SRO_BCH= "Name_id_nit_sro_bch";
	//姓名
	public static final String NAME_NUR= "Name_nur";
	//登记人
	public static final String NAME_REG= "Name_reg";
	//申请状态
	public static final String NAME_STATUS= "Name_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 实习生请假主键
	 * @return String
	 */
	public String getId_nur_lv() {
		return ((String) getAttrVal("Id_nur_lv"));
	}	
	/**
	 * 实习生请假主键
	 * @param Id_nur_lv
	 */
	public void setId_nur_lv(String Id_nur_lv) {
		setAttrVal("Id_nur_lv", Id_nur_lv);
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
	 * 院校id
	 * @return String
	 */
	public String getId_nit_sro() {
		return ((String) getAttrVal("Id_nit_sro"));
	}	
	/**
	 * 院校id
	 * @param Id_nit_sro
	 */
	public void setId_nit_sro(String Id_nit_sro) {
		setAttrVal("Id_nit_sro", Id_nit_sro);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getId_nit_sro_bch() {
		return ((String) getAttrVal("Id_nit_sro_bch"));
	}	
	/**
	 * 批次
	 * @param Id_nit_sro_bch
	 */
	public void setId_nit_sro_bch(String Id_nit_sro_bch) {
		setAttrVal("Id_nit_sro_bch", Id_nit_sro_bch);
	}
	/**
	 * 实习进修人员
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 实习进修人员
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 申请开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 申请开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 申请结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 申请结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 申请天数
	 * @return FDouble
	 */
	public FDouble getDays_lv() {
		return ((FDouble) getAttrVal("Days_lv"));
	}	
	/**
	 * 申请天数
	 * @param Days_lv
	 */
	public void setDays_lv(FDouble Days_lv) {
		setAttrVal("Days_lv", Days_lv);
	}
	/**
	 * 申请事由
	 * @return String
	 */
	public String getReasion_lv() {
		return ((String) getAttrVal("Reasion_lv"));
	}	
	/**
	 * 申请事由
	 * @param Reasion_lv
	 */
	public void setReasion_lv(String Reasion_lv) {
		setAttrVal("Reasion_lv", Reasion_lv);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg() {
		return ((String) getAttrVal("Id_reg"));
	}	
	/**
	 * 登记人
	 * @param Id_reg
	 */
	public void setId_reg(String Id_reg) {
		setAttrVal("Id_reg", Id_reg);
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
	 * 申请状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	/**
	 * 申请状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 申请状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 申请状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 审批意见
	 * @return String
	 */
	public String getApprovalop() {
		return ((String) getAttrVal("Approvalop"));
	}	
	/**
	 * 审批意见
	 * @param Approvalop
	 */
	public void setApprovalop(String Approvalop) {
		setAttrVal("Approvalop", Approvalop);
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
	 * 流程任务ID
	 * @return String
	 */
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}	
	/**
	 * 流程任务ID
	 * @param Id_task
	 */
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getName_emp_audit() {
		return ((String) getAttrVal("Name_emp_audit"));
	}	
	/**
	 * 审核人
	 * @param Name_emp_audit
	 */
	public void setName_emp_audit(String Name_emp_audit) {
		setAttrVal("Name_emp_audit", Name_emp_audit);
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
	 * 审意见核
	 * @return String
	 */
	public String getApcomments() {
		return ((String) getAttrVal("Apcomments"));
	}	
	/**
	 * 审意见核
	 * @param Apcomments
	 */
	public void setApcomments(String Apcomments) {
		setAttrVal("Apcomments", Apcomments);
	}
	/**
	 * 是否多版本
	 * @return FBoolean
	 */
	public FBoolean getFg_multiver() {
		return ((FBoolean) getAttrVal("Fg_multiver"));
	}	
	/**
	 * 是否多版本
	 * @param Fg_multiver
	 */
	public void setFg_multiver(FBoolean Fg_multiver) {
		setAttrVal("Fg_multiver", Fg_multiver);
	}
	/**
	 * 实习进修主键
	 * @return String
	 */
	public String getId_nit_psninfo() {
		return ((String) getAttrVal("Id_nit_psninfo"));
	}	
	/**
	 * 实习进修主键
	 * @param Id_nit_psninfo
	 */
	public void setId_nit_psninfo(String Id_nit_psninfo) {
		setAttrVal("Id_nit_psninfo", Id_nit_psninfo);
	}
	/**
	 * 院校名称
	 * @return String
	 */
	public String getName_id_nit_sro() {
		return ((String) getAttrVal("Name_id_nit_sro"));
	}	
	/**
	 * 院校名称
	 * @param Name_id_nit_sro
	 */
	public void setName_id_nit_sro(String Name_id_nit_sro) {
		setAttrVal("Name_id_nit_sro", Name_id_nit_sro);
	}
	/**
	 * 批次名称
	 * @return String
	 */
	public String getName_id_nit_sro_bch() {
		return ((String) getAttrVal("Name_id_nit_sro_bch"));
	}	
	/**
	 * 批次名称
	 * @param Name_id_nit_sro_bch
	 */
	public void setName_id_nit_sro_bch(String Name_id_nit_sro_bch) {
		setAttrVal("Name_id_nit_sro_bch", Name_id_nit_sro_bch);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getName_reg() {
		return ((String) getAttrVal("Name_reg"));
	}	
	/**
	 * 登记人
	 * @param Name_reg
	 */
	public void setName_reg(String Name_reg) {
		setAttrVal("Name_reg", Name_reg);
	}
	/**
	 * 申请状态
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	/**
	 * 申请状态
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
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
		return "Id_nur_lv";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_LV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitLvDODesc.class);
	}
	
}