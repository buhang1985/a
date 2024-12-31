package iih.ci.rcm.reportcarddoc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.reportcarddoc.d.desc.ReportCardDocDoDesc;
import java.math.BigDecimal;

/**
 * 报卡文书DO DO数据 
 * 
 */
public class ReportCardDocDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_CI_RCM_RD= "Id_ci_rcm_rd";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//患者编码
	public static final String ID_ENT= "Id_ent";
	//名称
	public static final String NAME= "Name";
	//医疗记录状态Id
	public static final String ID_STATE= "Id_state";
	//医疗记录状态
	public static final String SD_STATE= "Sd_state";
	//医疗记录状态名称
	public static final String NAME_STATE= "Name_state";
	//报卡类型表主键
	public static final String ID_BD_RCM_TP= "Id_bd_rcm_tp";
	//报卡模板表主键
	public static final String ID_BD_RCM_TPL= "Id_bd_rcm_tpl";
	//编辑器主键
	public static final String ID_MRED= "Id_mred";
	//存贮方式
	public static final String SD_TPLSTMD= "Sd_tplstmd";
	//存贮方式Id
	public static final String ID_TPLSTMD= "Id_tplstmd";
	//存贮方式名称
	public static final String NAME_TPLSTMD= "Name_tplstmd";
	//文件地址
	public static final String URL_FILE= "Url_file";
	//提交时间
	public static final String DT_SUB= "Dt_sub";
	//提交人（人员表）
	public static final String ID_SUB= "Id_sub";
	//取回时间
	public static final String DT_WITHDRAW= "Dt_withdraw";
	//取回人
	public static final String ID_WITHDRAW= "Id_withdraw";
	//驳回时间
	public static final String DT_REJECT= "Dt_reject";
	//驳回人（人员表）
	public static final String ID_REJECT= "Id_reject";
	//驳回原因
	public static final String REASON_REJECT= "Reason_reject";
	//审核时间
	public static final String DT_PASS= "Dt_pass";
	//审核人（人员表）
	public static final String ID_PASS= "Id_pass";
	//创建者
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//修改者
	public static final String MODIFIEDBY= "Modifiedby";
	//修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否匿名上报
	public static final String ISHIDENAME= "Ishidename";
	//既往已报标识
	public static final String FG_REPORTED_HISTORY= "Fg_reported_history";
	//报告疾病诊断
	public static final String ID_DI= "Id_di";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_ci_rcm_rd() {
		return ((String) getAttrVal("Id_ci_rcm_rd"));
	}	
	/**
	 * 主键
	 * @param Id_ci_rcm_rd
	 */
	public void setId_ci_rcm_rd(String Id_ci_rcm_rd) {
		setAttrVal("Id_ci_rcm_rd", Id_ci_rcm_rd);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者编码
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医疗记录状态Id
	 * @return String
	 */
	public String getId_state() {
		return ((String) getAttrVal("Id_state"));
	}	
	/**
	 * 医疗记录状态Id
	 * @param Id_state
	 */
	public void setId_state(String Id_state) {
		setAttrVal("Id_state", Id_state);
	}
	/**
	 * 医疗记录状态
	 * @return String
	 */
	public String getSd_state() {
		return ((String) getAttrVal("Sd_state"));
	}	
	/**
	 * 医疗记录状态
	 * @param Sd_state
	 */
	public void setSd_state(String Sd_state) {
		setAttrVal("Sd_state", Sd_state);
	}
	/**
	 * 医疗记录状态名称
	 * @return String
	 */
	public String getName_state() {
		return ((String) getAttrVal("Name_state"));
	}	
	/**
	 * 医疗记录状态名称
	 * @param Name_state
	 */
	public void setName_state(String Name_state) {
		setAttrVal("Name_state", Name_state);
	}
	/**
	 * 报卡类型表主键
	 * @return String
	 */
	public String getId_bd_rcm_tp() {
		return ((String) getAttrVal("Id_bd_rcm_tp"));
	}	
	/**
	 * 报卡类型表主键
	 * @param Id_bd_rcm_tp
	 */
	public void setId_bd_rcm_tp(String Id_bd_rcm_tp) {
		setAttrVal("Id_bd_rcm_tp", Id_bd_rcm_tp);
	}
	/**
	 * 报卡模板表主键
	 * @return String
	 */
	public String getId_bd_rcm_tpl() {
		return ((String) getAttrVal("Id_bd_rcm_tpl"));
	}	
	/**
	 * 报卡模板表主键
	 * @param Id_bd_rcm_tpl
	 */
	public void setId_bd_rcm_tpl(String Id_bd_rcm_tpl) {
		setAttrVal("Id_bd_rcm_tpl", Id_bd_rcm_tpl);
	}
	/**
	 * 编辑器主键
	 * @return String
	 */
	public String getId_mred() {
		return ((String) getAttrVal("Id_mred"));
	}	
	/**
	 * 编辑器主键
	 * @param Id_mred
	 */
	public void setId_mred(String Id_mred) {
		setAttrVal("Id_mred", Id_mred);
	}
	/**
	 * 存贮方式
	 * @return String
	 */
	public String getSd_tplstmd() {
		return ((String) getAttrVal("Sd_tplstmd"));
	}	
	/**
	 * 存贮方式
	 * @param Sd_tplstmd
	 */
	public void setSd_tplstmd(String Sd_tplstmd) {
		setAttrVal("Sd_tplstmd", Sd_tplstmd);
	}
	/**
	 * 存贮方式Id
	 * @return String
	 */
	public String getId_tplstmd() {
		return ((String) getAttrVal("Id_tplstmd"));
	}	
	/**
	 * 存贮方式Id
	 * @param Id_tplstmd
	 */
	public void setId_tplstmd(String Id_tplstmd) {
		setAttrVal("Id_tplstmd", Id_tplstmd);
	}
	/**
	 * 存贮方式名称
	 * @return String
	 */
	public String getName_tplstmd() {
		return ((String) getAttrVal("Name_tplstmd"));
	}	
	/**
	 * 存贮方式名称
	 * @param Name_tplstmd
	 */
	public void setName_tplstmd(String Name_tplstmd) {
		setAttrVal("Name_tplstmd", Name_tplstmd);
	}
	/**
	 * 文件地址
	 * @return String
	 */
	public String getUrl_file() {
		return ((String) getAttrVal("Url_file"));
	}	
	/**
	 * 文件地址
	 * @param Url_file
	 */
	public void setUrl_file(String Url_file) {
		setAttrVal("Url_file", Url_file);
	}
	/**
	 * 提交时间
	 * @return String
	 */
	public String getDt_sub() {
		return ((String) getAttrVal("Dt_sub"));
	}	
	/**
	 * 提交时间
	 * @param Dt_sub
	 */
	public void setDt_sub(String Dt_sub) {
		setAttrVal("Dt_sub", Dt_sub);
	}
	/**
	 * 提交人（人员表）
	 * @return String
	 */
	public String getId_sub() {
		return ((String) getAttrVal("Id_sub"));
	}	
	/**
	 * 提交人（人员表）
	 * @param Id_sub
	 */
	public void setId_sub(String Id_sub) {
		setAttrVal("Id_sub", Id_sub);
	}
	/**
	 * 取回时间
	 * @return String
	 */
	public String getDt_withdraw() {
		return ((String) getAttrVal("Dt_withdraw"));
	}	
	/**
	 * 取回时间
	 * @param Dt_withdraw
	 */
	public void setDt_withdraw(String Dt_withdraw) {
		setAttrVal("Dt_withdraw", Dt_withdraw);
	}
	/**
	 * 取回人
	 * @return String
	 */
	public String getId_withdraw() {
		return ((String) getAttrVal("Id_withdraw"));
	}	
	/**
	 * 取回人
	 * @param Id_withdraw
	 */
	public void setId_withdraw(String Id_withdraw) {
		setAttrVal("Id_withdraw", Id_withdraw);
	}
	/**
	 * 驳回时间
	 * @return String
	 */
	public String getDt_reject() {
		return ((String) getAttrVal("Dt_reject"));
	}	
	/**
	 * 驳回时间
	 * @param Dt_reject
	 */
	public void setDt_reject(String Dt_reject) {
		setAttrVal("Dt_reject", Dt_reject);
	}
	/**
	 * 驳回人（人员表）
	 * @return String
	 */
	public String getId_reject() {
		return ((String) getAttrVal("Id_reject"));
	}	
	/**
	 * 驳回人（人员表）
	 * @param Id_reject
	 */
	public void setId_reject(String Id_reject) {
		setAttrVal("Id_reject", Id_reject);
	}
	/**
	 * 驳回原因
	 * @return String
	 */
	public String getReason_reject() {
		return ((String) getAttrVal("Reason_reject"));
	}	
	/**
	 * 驳回原因
	 * @param Reason_reject
	 */
	public void setReason_reject(String Reason_reject) {
		setAttrVal("Reason_reject", Reason_reject);
	}
	/**
	 * 审核时间
	 * @return String
	 */
	public String getDt_pass() {
		return ((String) getAttrVal("Dt_pass"));
	}	
	/**
	 * 审核时间
	 * @param Dt_pass
	 */
	public void setDt_pass(String Dt_pass) {
		setAttrVal("Dt_pass", Dt_pass);
	}
	/**
	 * 审核人（人员表）
	 * @return String
	 */
	public String getId_pass() {
		return ((String) getAttrVal("Id_pass"));
	}	
	/**
	 * 审核人（人员表）
	 * @param Id_pass
	 */
	public void setId_pass(String Id_pass) {
		setAttrVal("Id_pass", Id_pass);
	}
	/**
	 * 创建者
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建者
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return String
	 */
	public String getCreatedtime() {
		return ((String) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(String Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 修改者
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 修改者
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 修改时间
	 * @return String
	 */
	public String getModifiedtime() {
		return ((String) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(String Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 是否匿名上报
	 * @return FBoolean
	 */
	public FBoolean getIshidename() {
		return ((FBoolean) getAttrVal("Ishidename"));
	}	
	/**
	 * 是否匿名上报
	 * @param Ishidename
	 */
	public void setIshidename(FBoolean Ishidename) {
		setAttrVal("Ishidename", Ishidename);
	}
	/**
	 * 既往已报标识
	 * @return FBoolean
	 */
	public FBoolean getFg_reported_history() {
		return ((FBoolean) getAttrVal("Fg_reported_history"));
	}	
	/**
	 * 既往已报标识
	 * @param Fg_reported_history
	 */
	public void setFg_reported_history(FBoolean Fg_reported_history) {
		setAttrVal("Fg_reported_history", Fg_reported_history);
	}
	/**
	 * 报告疾病诊断
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 报告疾病诊断
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
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
		return "Id_ci_rcm_rd";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_rd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ReportCardDocDoDesc.class);
	}
	
}