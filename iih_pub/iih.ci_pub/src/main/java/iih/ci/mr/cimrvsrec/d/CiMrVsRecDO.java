package iih.ci.mr.cimrvsrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrvsrec.d.desc.CiMrVsRecDODesc;
import java.math.BigDecimal;

/**
 * 体征事件时间修改记录 DO数据 
 * 
 */
public class CiMrVsRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体征时间修改记录ID
	public static final String ID_MR_VS_REC= "Id_mr_vs_rec";
	//体征记录ID
	public static final String ID_MR_VS= "Id_mr_vs";
	//组织ID
	public static final String ID_ORG= "Id_org";
	//集团ID
	public static final String ID_GRP= "Id_grp";
	//修改前时间
	public static final String DT_VT_OLD= "Dt_vt_old";
	//修改后时间
	public static final String DT_VT_NEW= "Dt_vt_new";
	//修改人id
	public static final String ID_EMP_MODIFY= "Id_emp_modify";
	//修改时间
	public static final String DT_MODIFY= "Dt_modify";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//姓名
	public static final String NAME_EMP_MODIFY= "Name_emp_modify";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体征时间修改记录ID
	 * @return String
	 */
	public String getId_mr_vs_rec() {
		return ((String) getAttrVal("Id_mr_vs_rec"));
	}	
	/**
	 * 体征时间修改记录ID
	 * @param Id_mr_vs_rec
	 */
	public void setId_mr_vs_rec(String Id_mr_vs_rec) {
		setAttrVal("Id_mr_vs_rec", Id_mr_vs_rec);
	}
	/**
	 * 体征记录ID
	 * @return String
	 */
	public String getId_mr_vs() {
		return ((String) getAttrVal("Id_mr_vs"));
	}	
	/**
	 * 体征记录ID
	 * @param Id_mr_vs
	 */
	public void setId_mr_vs(String Id_mr_vs) {
		setAttrVal("Id_mr_vs", Id_mr_vs);
	}
	/**
	 * 组织ID
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织ID
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团ID
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团ID
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 修改前时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt_old() {
		return ((FDateTime) getAttrVal("Dt_vt_old"));
	}	
	/**
	 * 修改前时间
	 * @param Dt_vt_old
	 */
	public void setDt_vt_old(FDateTime Dt_vt_old) {
		setAttrVal("Dt_vt_old", Dt_vt_old);
	}
	/**
	 * 修改后时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt_new() {
		return ((FDateTime) getAttrVal("Dt_vt_new"));
	}	
	/**
	 * 修改后时间
	 * @param Dt_vt_new
	 */
	public void setDt_vt_new(FDateTime Dt_vt_new) {
		setAttrVal("Dt_vt_new", Dt_vt_new);
	}
	/**
	 * 修改人id
	 * @return String
	 */
	public String getId_emp_modify() {
		return ((String) getAttrVal("Id_emp_modify"));
	}	
	/**
	 * 修改人id
	 * @param Id_emp_modify
	 */
	public void setId_emp_modify(String Id_emp_modify) {
		setAttrVal("Id_emp_modify", Id_emp_modify);
	}
	/**
	 * 修改时间
	 * @return String
	 */
	public String getDt_modify() {
		return ((String) getAttrVal("Dt_modify"));
	}	
	/**
	 * 修改时间
	 * @param Dt_modify
	 */
	public void setDt_modify(String Dt_modify) {
		setAttrVal("Dt_modify", Dt_modify);
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
	 * 姓名
	 * @return String
	 */
	public String getName_emp_modify() {
		return ((String) getAttrVal("Name_emp_modify"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_modify
	 */
	public void setName_emp_modify(String Name_emp_modify) {
		setAttrVal("Name_emp_modify", Name_emp_modify);
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
		return "Id_mr_vs_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_vs_rec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrVsRecDODesc.class);
	}
	
}