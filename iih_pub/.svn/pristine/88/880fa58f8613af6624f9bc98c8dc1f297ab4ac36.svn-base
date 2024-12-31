package iih.ci.preip.order.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.preip.order.d.desc.CiOrPipDODesc;
import java.math.BigDecimal;

/**
 * 医嘱_预住院 DO数据 
 * 
 */
public class CiOrPipDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_ORPIP= "Id_orpip";
	//医嘱ID
	public static final String ID_OR= "Id_or";
	//预住院标志
	public static final String FG_PIP= "Fg_pip";
	//医嘱原生效时间
	public static final String DT_EFFE_OLD= "Dt_effe_old";
	//操作人
	public static final String ID_EMP_OPER= "Id_emp_oper";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//操作科室
	public static final String ID_DEP_OPER= "Id_dep_oper";
	//医嘱生效时间是否修改
	public static final String FG_EFFE_UPDATE= "Fg_effe_update";
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
	 * 主键
	 * @return String
	 */
	public String getId_orpip() {
		return ((String) getAttrVal("Id_orpip"));
	}	
	/**
	 * 主键
	 * @param Id_orpip
	 */
	public void setId_orpip(String Id_orpip) {
		setAttrVal("Id_orpip", Id_orpip);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 预住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pip() {
		return ((FBoolean) getAttrVal("Fg_pip"));
	}	
	/**
	 * 预住院标志
	 * @param Fg_pip
	 */
	public void setFg_pip(FBoolean Fg_pip) {
		setAttrVal("Fg_pip", Fg_pip);
	}
	/**
	 * 医嘱原生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe_old() {
		return ((FDateTime) getAttrVal("Dt_effe_old"));
	}	
	/**
	 * 医嘱原生效时间
	 * @param Dt_effe_old
	 */
	public void setDt_effe_old(FDateTime Dt_effe_old) {
		setAttrVal("Dt_effe_old", Dt_effe_old);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	/**
	 * 操作人
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 操作科室
	 * @return String
	 */
	public String getId_dep_oper() {
		return ((String) getAttrVal("Id_dep_oper"));
	}	
	/**
	 * 操作科室
	 * @param Id_dep_oper
	 */
	public void setId_dep_oper(String Id_dep_oper) {
		setAttrVal("Id_dep_oper", Id_dep_oper);
	}
	/**
	 * 医嘱生效时间是否修改
	 * @return FBoolean
	 */
	public FBoolean getFg_effe_update() {
		return ((FBoolean) getAttrVal("Fg_effe_update"));
	}	
	/**
	 * 医嘱生效时间是否修改
	 * @param Fg_effe_update
	 */
	public void setFg_effe_update(FBoolean Fg_effe_update) {
		setAttrVal("Fg_effe_update", Fg_effe_update);
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
		return "Id_orpip";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_pip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrPipDODesc.class);
	}
	
}