package iih.en.pv.enres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enres.d.desc.EnExtVipDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_扩展_VIP DO数据 
 * 
 */
public class EnExtVipDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键id
	public static final String ID_ENTEXTVIP= "Id_entextvip";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//Vip说明
	public static final String REASON= "Reason";
	//开始时间
	public static final String DT_B= "Dt_b";
	//设置人员
	public static final String ID_EMP_INSERT= "Id_emp_insert";
	//有效标志
	public static final String FG_VALID= "Fg_valid";
	//取消人员
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//取消时间
	public static final String DT_CANC= "Dt_canc";
	//设置人员姓名
	public static final String NAME_EMP_INSERT= "Name_emp_insert";
	//取消人员姓名
	public static final String NAME_EMP_CANC= "Name_emp_canc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键id
	 * @return String
	 */
	public String getId_entextvip() {
		return ((String) getAttrVal("Id_entextvip"));
	}	
	/**
	 * 主键id
	 * @param Id_entextvip
	 */
	public void setId_entextvip(String Id_entextvip) {
		setAttrVal("Id_entextvip", Id_entextvip);
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
	 * Vip说明
	 * @return String
	 */
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}	
	/**
	 * Vip说明
	 * @param Reason
	 */
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 设置人员
	 * @return String
	 */
	public String getId_emp_insert() {
		return ((String) getAttrVal("Id_emp_insert"));
	}	
	/**
	 * 设置人员
	 * @param Id_emp_insert
	 */
	public void setId_emp_insert(String Id_emp_insert) {
		setAttrVal("Id_emp_insert", Id_emp_insert);
	}
	/**
	 * 有效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_valid() {
		return ((FBoolean) getAttrVal("Fg_valid"));
	}	
	/**
	 * 有效标志
	 * @param Fg_valid
	 */
	public void setFg_valid(FBoolean Fg_valid) {
		setAttrVal("Fg_valid", Fg_valid);
	}
	/**
	 * 取消人员
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 取消人员
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 取消时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 设置人员姓名
	 * @return String
	 */
	public String getName_emp_insert() {
		return ((String) getAttrVal("Name_emp_insert"));
	}	
	/**
	 * 设置人员姓名
	 * @param Name_emp_insert
	 */
	public void setName_emp_insert(String Name_emp_insert) {
		setAttrVal("Name_emp_insert", Name_emp_insert);
	}
	/**
	 * 取消人员姓名
	 * @return String
	 */
	public String getName_emp_canc() {
		return ((String) getAttrVal("Name_emp_canc"));
	}	
	/**
	 * 取消人员姓名
	 * @param Name_emp_canc
	 */
	public void setName_emp_canc(String Name_emp_canc) {
		setAttrVal("Name_emp_canc", Name_emp_canc);
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
		return "Id_entextvip";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_EXT_VIP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnExtVipDODesc.class);
	}
	
}