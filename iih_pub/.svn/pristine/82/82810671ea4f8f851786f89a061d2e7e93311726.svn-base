package iih.en.pv.deptrans.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.deptrans.d.desc.EnDepTransDODesc;
import java.math.BigDecimal;

/**
 * 就诊转科 DO数据 
 * 
 */
public class EnDepTransDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//就诊转科id
	public static final String ID_DEP_TRANS= "Id_dep_trans";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//目标科室
	public static final String ID_DEP_TO= "Id_dep_to";
	//目标病区
	public static final String ID_DEP_NUR_TO= "Id_dep_nur_to";
	//目标床位
	public static final String ID_BED_TO= "Id_bed_to";
	//原科室
	public static final String ID_DEP_FROM= "Id_dep_from";
	//原病区
	public static final String ID_DEP_NUR_FROM= "Id_dep_nur_from";
	//原床位
	public static final String ID_BED_FROM= "Id_bed_from";
	//转科过程状态
	public static final String EU_TRANS= "Eu_trans";
	//医嘱id
	public static final String ID_OR= "Id_or";
	//转科申请时间
	public static final String DT_APPLY= "Dt_apply";
	//转科接收时间
	public static final String DT_ACPT= "Dt_acpt";
	//申请操作人
	public static final String ID_EMP_APPL= "Id_emp_appl";
	//接收操作人
	public static final String ID_EMP_ACPT= "Id_emp_acpt";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//预住院标识
	public static final String FG_IPPRE= "Fg_ippre";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 就诊转科id
	 * @return String
	 */
	public String getId_dep_trans() {
		return ((String) getAttrVal("Id_dep_trans"));
	}	
	/**
	 * 就诊转科id
	 * @param Id_dep_trans
	 */
	public void setId_dep_trans(String Id_dep_trans) {
		setAttrVal("Id_dep_trans", Id_dep_trans);
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
	 * 目标科室
	 * @return String
	 */
	public String getId_dep_to() {
		return ((String) getAttrVal("Id_dep_to"));
	}	
	/**
	 * 目标科室
	 * @param Id_dep_to
	 */
	public void setId_dep_to(String Id_dep_to) {
		setAttrVal("Id_dep_to", Id_dep_to);
	}
	/**
	 * 目标病区
	 * @return String
	 */
	public String getId_dep_nur_to() {
		return ((String) getAttrVal("Id_dep_nur_to"));
	}	
	/**
	 * 目标病区
	 * @param Id_dep_nur_to
	 */
	public void setId_dep_nur_to(String Id_dep_nur_to) {
		setAttrVal("Id_dep_nur_to", Id_dep_nur_to);
	}
	/**
	 * 目标床位
	 * @return String
	 */
	public String getId_bed_to() {
		return ((String) getAttrVal("Id_bed_to"));
	}	
	/**
	 * 目标床位
	 * @param Id_bed_to
	 */
	public void setId_bed_to(String Id_bed_to) {
		setAttrVal("Id_bed_to", Id_bed_to);
	}
	/**
	 * 原科室
	 * @return String
	 */
	public String getId_dep_from() {
		return ((String) getAttrVal("Id_dep_from"));
	}	
	/**
	 * 原科室
	 * @param Id_dep_from
	 */
	public void setId_dep_from(String Id_dep_from) {
		setAttrVal("Id_dep_from", Id_dep_from);
	}
	/**
	 * 原病区
	 * @return String
	 */
	public String getId_dep_nur_from() {
		return ((String) getAttrVal("Id_dep_nur_from"));
	}	
	/**
	 * 原病区
	 * @param Id_dep_nur_from
	 */
	public void setId_dep_nur_from(String Id_dep_nur_from) {
		setAttrVal("Id_dep_nur_from", Id_dep_nur_from);
	}
	/**
	 * 原床位
	 * @return String
	 */
	public String getId_bed_from() {
		return ((String) getAttrVal("Id_bed_from"));
	}	
	/**
	 * 原床位
	 * @param Id_bed_from
	 */
	public void setId_bed_from(String Id_bed_from) {
		setAttrVal("Id_bed_from", Id_bed_from);
	}
	/**
	 * 转科过程状态
	 * @return Integer
	 */
	public Integer getEu_trans() {
		return ((Integer) getAttrVal("Eu_trans"));
	}	
	/**
	 * 转科过程状态
	 * @param Eu_trans
	 */
	public void setEu_trans(Integer Eu_trans) {
		setAttrVal("Eu_trans", Eu_trans);
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
	 * 转科申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_apply() {
		return ((FDateTime) getAttrVal("Dt_apply"));
	}	
	/**
	 * 转科申请时间
	 * @param Dt_apply
	 */
	public void setDt_apply(FDateTime Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	/**
	 * 转科接收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 转科接收时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 申请操作人
	 * @return String
	 */
	public String getId_emp_appl() {
		return ((String) getAttrVal("Id_emp_appl"));
	}	
	/**
	 * 申请操作人
	 * @param Id_emp_appl
	 */
	public void setId_emp_appl(String Id_emp_appl) {
		setAttrVal("Id_emp_appl", Id_emp_appl);
	}
	/**
	 * 接收操作人
	 * @return String
	 */
	public String getId_emp_acpt() {
		return ((String) getAttrVal("Id_emp_acpt"));
	}	
	/**
	 * 接收操作人
	 * @param Id_emp_acpt
	 */
	public void setId_emp_acpt(String Id_emp_acpt) {
		setAttrVal("Id_emp_acpt", Id_emp_acpt);
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
	 * 预住院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ippre() {
		return ((FBoolean) getAttrVal("Fg_ippre"));
	}	
	/**
	 * 预住院标识
	 * @param Fg_ippre
	 */
	public void setFg_ippre(FBoolean Fg_ippre) {
		setAttrVal("Fg_ippre", Fg_ippre);
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
		return "Id_dep_trans";
	}
	
	@Override
	public String getTableName() {	  
		return "en_dep_trans";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnDepTransDODesc.class);
	}
	
}