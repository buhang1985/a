package iih.mp.nr.mpordperformstate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.mpordperformstate.d.desc.MpOrdPerformStateDODesc;
import java.math.BigDecimal;

/**
 * 医嘱执行状态记录 DO数据 
 * 
 */
public class MpOrdPerformStateDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱执行状态记录id
	public static final String ID_ORPRSTA= "Id_orprsta";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//上一个状态
	public static final String ID_PREVIOUS= "Id_previous";
	//医嘱执行记录id
	public static final String ID_OR_PR= "Id_or_pr";
	//医嘱
	public static final String ID_OR= "Id_or";
	//计划执行时间
	public static final String DT_MP_PLAN= "Dt_mp_plan";
	//执行状态
	public static final String EU_SU= "Eu_su";
	//服务类型
	public static final String SD_SRVTP= "Sd_srvtp";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String CODE_ENTP= "Code_entp";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//医嘱执行闭环分类状态ID
	public static final String ID_ORPLTPSTA= "Id_orpltpsta";
	//医嘱执行闭环分类状态名称
	public static final String NAME_ORPLTPSTA= "Name_orpltpsta";
	//不执行原因ID
	public static final String ID_SKIP_REASON= "Id_skip_reason";
	//不执行原因编码
	public static final String SD_SKIP_REASON= "Sd_skip_reason";
	//不执行原因
	public static final String SKIP_REASON= "Skip_reason";
	//执行时间
	public static final String DT_MP= "Dt_mp";
	//执行人
	public static final String ID_EMP= "Id_emp";
	//执行科室
	public static final String ID_DEP= "Id_dep";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否取消
	public static final String FG_CANCEL= "Fg_cancel";
	//同一人复核配液标志
	public static final String FG_SELFREVIEW= "Fg_selfreview";
	//同一复核配液原因
	public static final String SD_SELFREVIEW= "Sd_selfreview";
	//扩展字段
	public static final String DEF1= "Def1";
	//可取消标志
	public static final String FG_CANCELABLE= "Fg_cancelable";
	//闭环状态编码
	public static final String CODE= "Code";
	//序号
	public static final String SORTNO= "Sortno";
	//可退费标志
	public static final String FG_FEERTNABLE= "Fg_feertnable";
	//用户编码
	public static final String USERCODE= "Usercode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱执行状态记录id
	 * @return String
	 */
	public String getId_orprsta() {
		return ((String) getAttrVal("Id_orprsta"));
	}	
	/**
	 * 医嘱执行状态记录id
	 * @param Id_orprsta
	 */
	public void setId_orprsta(String Id_orprsta) {
		setAttrVal("Id_orprsta", Id_orprsta);
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
	 * 上一个状态
	 * @return String
	 */
	public String getId_previous() {
		return ((String) getAttrVal("Id_previous"));
	}	
	/**
	 * 上一个状态
	 * @param Id_previous
	 */
	public void setId_previous(String Id_previous) {
		setAttrVal("Id_previous", Id_previous);
	}
	/**
	 * 医嘱执行记录id
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	/**
	 * 医嘱执行记录id
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}	
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 执行状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}	
	/**
	 * 执行状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	 * 医嘱执行闭环分类状态ID
	 * @return String
	 */
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}	
	/**
	 * 医嘱执行闭环分类状态ID
	 * @param Id_orpltpsta
	 */
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	/**
	 * 医嘱执行闭环分类状态名称
	 * @return String
	 */
	public String getName_orpltpsta() {
		return ((String) getAttrVal("Name_orpltpsta"));
	}	
	/**
	 * 医嘱执行闭环分类状态名称
	 * @param Name_orpltpsta
	 */
	public void setName_orpltpsta(String Name_orpltpsta) {
		setAttrVal("Name_orpltpsta", Name_orpltpsta);
	}
	/**
	 * 不执行原因ID
	 * @return String
	 */
	public String getId_skip_reason() {
		return ((String) getAttrVal("Id_skip_reason"));
	}	
	/**
	 * 不执行原因ID
	 * @param Id_skip_reason
	 */
	public void setId_skip_reason(String Id_skip_reason) {
		setAttrVal("Id_skip_reason", Id_skip_reason);
	}
	/**
	 * 不执行原因编码
	 * @return String
	 */
	public String getSd_skip_reason() {
		return ((String) getAttrVal("Sd_skip_reason"));
	}	
	/**
	 * 不执行原因编码
	 * @param Sd_skip_reason
	 */
	public void setSd_skip_reason(String Sd_skip_reason) {
		setAttrVal("Sd_skip_reason", Sd_skip_reason);
	}
	/**
	 * 不执行原因
	 * @return String
	 */
	public String getSkip_reason() {
		return ((String) getAttrVal("Skip_reason"));
	}	
	/**
	 * 不执行原因
	 * @param Skip_reason
	 */
	public void setSkip_reason(String Skip_reason) {
		setAttrVal("Skip_reason", Skip_reason);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}	
	/**
	 * 执行时间
	 * @param Dt_mp
	 */
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 执行人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	 * 是否取消
	 * @return FBoolean
	 */
	public FBoolean getFg_cancel() {
		return ((FBoolean) getAttrVal("Fg_cancel"));
	}	
	/**
	 * 是否取消
	 * @param Fg_cancel
	 */
	public void setFg_cancel(FBoolean Fg_cancel) {
		setAttrVal("Fg_cancel", Fg_cancel);
	}
	/**
	 * 同一人复核配液标志
	 * @return FBoolean
	 */
	public FBoolean getFg_selfreview() {
		return ((FBoolean) getAttrVal("Fg_selfreview"));
	}	
	/**
	 * 同一人复核配液标志
	 * @param Fg_selfreview
	 */
	public void setFg_selfreview(FBoolean Fg_selfreview) {
		setAttrVal("Fg_selfreview", Fg_selfreview);
	}
	/**
	 * 同一复核配液原因
	 * @return String
	 */
	public String getSd_selfreview() {
		return ((String) getAttrVal("Sd_selfreview"));
	}	
	/**
	 * 同一复核配液原因
	 * @param Sd_selfreview
	 */
	public void setSd_selfreview(String Sd_selfreview) {
		setAttrVal("Sd_selfreview", Sd_selfreview);
	}
	/**
	 * 扩展字段
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 可取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cancelable() {
		return ((FBoolean) getAttrVal("Fg_cancelable"));
	}	
	/**
	 * 可取消标志
	 * @param Fg_cancelable
	 */
	public void setFg_cancelable(FBoolean Fg_cancelable) {
		setAttrVal("Fg_cancelable", Fg_cancelable);
	}
	/**
	 * 闭环状态编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 闭环状态编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 可退费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}	
	/**
	 * 可退费标志
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getUsercode() {
		return ((String) getAttrVal("Usercode"));
	}	
	/**
	 * 用户编码
	 * @param Usercode
	 */
	public void setUsercode(String Usercode) {
		setAttrVal("Usercode", Usercode);
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
		return "Id_orprsta";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_OR_PR_STA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOrdPerformStateDODesc.class);
	}
	
}