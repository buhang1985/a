package iih.bl.cg.blcgoeptf.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blcgoeptf.d.desc.BlCgItmOepTfRcdDODesc;
import java.math.BigDecimal;

/**
 * 门诊记账转移记录 DO数据 
 * 
 */
public class BlCgItmOepTfRcdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//门诊记账转移主键
	public static final String ID_CGTFRCD= "Id_cgtfrcd";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//就诊id
	public static final String ID_ENT_TF= "Id_ent_tf";
	//门诊记账id
	public static final String ID_CGITMOEP= "Id_cgitmoep";
	//转移目标id
	public static final String ID_CGTFIN= "Id_cgtfin";
	//转入时间
	public static final String DT_TF= "Dt_tf";
	//转入操作人员科室
	public static final String ID_DEP_TF= "Id_dep_tf";
	//转入操作员人
	public static final String ID_EMP_TF= "Id_emp_tf";
	//取消转入时间
	public static final String DT_TF_CANC= "Dt_tf_canc";
	//取消转入操作人员科室
	public static final String ID_DEP_TF_CANC= "Id_dep_tf_canc";
	//取消转入操作员人
	public static final String ID_EMP_TF_CANC= "Id_emp_tf_canc";
	//有效标志
	public static final String FG_ACTIVE= "Fg_active";
	//是否真实转入
	public static final String FG_REALTF= "Fg_realtf";
	//门诊转入数据是否已插入到住院记账表中
	public static final String FG_TL= "Fg_tl";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 门诊记账转移主键
	 * @return String
	 */
	public String getId_cgtfrcd() {
		return ((String) getAttrVal("Id_cgtfrcd"));
	}	
	/**
	 * 门诊记账转移主键
	 * @param Id_cgtfrcd
	 */
	public void setId_cgtfrcd(String Id_cgtfrcd) {
		setAttrVal("Id_cgtfrcd", Id_cgtfrcd);
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent_tf() {
		return ((String) getAttrVal("Id_ent_tf"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent_tf
	 */
	public void setId_ent_tf(String Id_ent_tf) {
		setAttrVal("Id_ent_tf", Id_ent_tf);
	}
	/**
	 * 门诊记账id
	 * @return String
	 */
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}	
	/**
	 * 门诊记账id
	 * @param Id_cgitmoep
	 */
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
	}
	/**
	 * 转移目标id
	 * @return String
	 */
	public String getId_cgtfin() {
		return ((String) getAttrVal("Id_cgtfin"));
	}	
	/**
	 * 转移目标id
	 * @param Id_cgtfin
	 */
	public void setId_cgtfin(String Id_cgtfin) {
		setAttrVal("Id_cgtfin", Id_cgtfin);
	}
	/**
	 * 转入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_tf() {
		return ((FDateTime) getAttrVal("Dt_tf"));
	}	
	/**
	 * 转入时间
	 * @param Dt_tf
	 */
	public void setDt_tf(FDateTime Dt_tf) {
		setAttrVal("Dt_tf", Dt_tf);
	}
	/**
	 * 转入操作人员科室
	 * @return String
	 */
	public String getId_dep_tf() {
		return ((String) getAttrVal("Id_dep_tf"));
	}	
	/**
	 * 转入操作人员科室
	 * @param Id_dep_tf
	 */
	public void setId_dep_tf(String Id_dep_tf) {
		setAttrVal("Id_dep_tf", Id_dep_tf);
	}
	/**
	 * 转入操作员人
	 * @return String
	 */
	public String getId_emp_tf() {
		return ((String) getAttrVal("Id_emp_tf"));
	}	
	/**
	 * 转入操作员人
	 * @param Id_emp_tf
	 */
	public void setId_emp_tf(String Id_emp_tf) {
		setAttrVal("Id_emp_tf", Id_emp_tf);
	}
	/**
	 * 取消转入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_tf_canc() {
		return ((FDateTime) getAttrVal("Dt_tf_canc"));
	}	
	/**
	 * 取消转入时间
	 * @param Dt_tf_canc
	 */
	public void setDt_tf_canc(FDateTime Dt_tf_canc) {
		setAttrVal("Dt_tf_canc", Dt_tf_canc);
	}
	/**
	 * 取消转入操作人员科室
	 * @return String
	 */
	public String getId_dep_tf_canc() {
		return ((String) getAttrVal("Id_dep_tf_canc"));
	}	
	/**
	 * 取消转入操作人员科室
	 * @param Id_dep_tf_canc
	 */
	public void setId_dep_tf_canc(String Id_dep_tf_canc) {
		setAttrVal("Id_dep_tf_canc", Id_dep_tf_canc);
	}
	/**
	 * 取消转入操作员人
	 * @return String
	 */
	public String getId_emp_tf_canc() {
		return ((String) getAttrVal("Id_emp_tf_canc"));
	}	
	/**
	 * 取消转入操作员人
	 * @param Id_emp_tf_canc
	 */
	public void setId_emp_tf_canc(String Id_emp_tf_canc) {
		setAttrVal("Id_emp_tf_canc", Id_emp_tf_canc);
	}
	/**
	 * 有效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 有效标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 是否真实转入
	 * @return FBoolean
	 */
	public FBoolean getFg_realtf() {
		return ((FBoolean) getAttrVal("Fg_realtf"));
	}	
	/**
	 * 是否真实转入
	 * @param Fg_realtf
	 */
	public void setFg_realtf(FBoolean Fg_realtf) {
		setAttrVal("Fg_realtf", Fg_realtf);
	}
	/**
	 * 门诊转入数据是否已插入到住院记账表中
	 * @return FBoolean
	 */
	public FBoolean getFg_tl() {
		return ((FBoolean) getAttrVal("Fg_tl"));
	}	
	/**
	 * 门诊转入数据是否已插入到住院记账表中
	 * @param Fg_tl
	 */
	public void setFg_tl(FBoolean Fg_tl) {
		setAttrVal("Fg_tl", Fg_tl);
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
		return "Id_cgtfrcd";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cg_itm_oep_tfrcd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCgItmOepTfRcdDODesc.class);
	}
	
}