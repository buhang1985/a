package iih.cssd.dpp.stz.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpp.stz.d.desc.CssdDfpStzItmDODesc;
import java.math.BigDecimal;

/**
 * 包灭菌子项 DO数据 
 * 
 */
public class CssdDfpStzItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//包灭菌子项
	public static final String ID_DFP_STZ_ITM= "Id_dfp_stz_itm";
	//包灭菌
	public static final String ID_DFP_STZ= "Id_dfp_stz";
	//消毒包主键
	public static final String ID_DFP= "Id_dfp";
	//核对人
	public static final String ID_EMP_CHK= "Id_emp_chk";
	//核对科室
	public static final String ID_DEP_CHK= "Id_dep_chk";
	//核对时间
	public static final String DT_CHK= "Dt_chk";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//消毒包名称
	public static final String NAME_DFP= "Name_dfp";
	//核对人姓名
	public static final String NAME_EMP_CHK= "Name_emp_chk";
	//核对科室名称
	public static final String NAME_DEP_CHK= "Name_dep_chk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 包灭菌子项
	 * @return String
	 */
	public String getId_dfp_stz_itm() {
		return ((String) getAttrVal("Id_dfp_stz_itm"));
	}	
	/**
	 * 包灭菌子项
	 * @param Id_dfp_stz_itm
	 */
	public void setId_dfp_stz_itm(String Id_dfp_stz_itm) {
		setAttrVal("Id_dfp_stz_itm", Id_dfp_stz_itm);
	}
	/**
	 * 包灭菌
	 * @return String
	 */
	public String getId_dfp_stz() {
		return ((String) getAttrVal("Id_dfp_stz"));
	}	
	/**
	 * 包灭菌
	 * @param Id_dfp_stz
	 */
	public void setId_dfp_stz(String Id_dfp_stz) {
		setAttrVal("Id_dfp_stz", Id_dfp_stz);
	}
	/**
	 * 消毒包主键
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}	
	/**
	 * 消毒包主键
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 核对人
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}	
	/**
	 * 核对人
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 核对科室
	 * @return String
	 */
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}	
	/**
	 * 核对科室
	 * @param Id_dep_chk
	 */
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	/**
	 * 核对时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 核对时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
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
	 * 消毒包名称
	 * @return String
	 */
	public String getName_dfp() {
		return ((String) getAttrVal("Name_dfp"));
	}	
	/**
	 * 消毒包名称
	 * @param Name_dfp
	 */
	public void setName_dfp(String Name_dfp) {
		setAttrVal("Name_dfp", Name_dfp);
	}
	/**
	 * 核对人姓名
	 * @return String
	 */
	public String getName_emp_chk() {
		return ((String) getAttrVal("Name_emp_chk"));
	}	
	/**
	 * 核对人姓名
	 * @param Name_emp_chk
	 */
	public void setName_emp_chk(String Name_emp_chk) {
		setAttrVal("Name_emp_chk", Name_emp_chk);
	}
	/**
	 * 核对科室名称
	 * @return String
	 */
	public String getName_dep_chk() {
		return ((String) getAttrVal("Name_dep_chk"));
	}	
	/**
	 * 核对科室名称
	 * @param Name_dep_chk
	 */
	public void setName_dep_chk(String Name_dep_chk) {
		setAttrVal("Name_dep_chk", Name_dep_chk);
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
		return "Id_dfp_stz_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_STZ_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssdDfpStzItmDODesc.class);
	}
	
}