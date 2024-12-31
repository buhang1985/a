package iih.bl.cg.blcghist.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blcghist.d.desc.BlCgIpHistDODesc;
import java.math.BigDecimal;

/**
 * 住院记账自费标识修改历史 DO数据 
 * 
 */
public class BlCgIpHistDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//住院记账自费标识修改主键
	public static final String ID_CGIPHIST= "Id_cgiphist";
	//记账主键
	public static final String ID_CGIP= "Id_cgip";
	//活动来源编码
	public static final String SD_ACTSRC= "Sd_actsrc";
	//活动时间
	public static final String DT_ACT= "Dt_act";
	//操作科室
	public static final String ID_DEP_ACT= "Id_dep_act";
	//操作人员
	public static final String ID_EMP_ACT= "Id_emp_act";
	//操作方式
	public static final String EU_ACT= "Eu_act";
	//描述
	public static final String NOTE= "Note";
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
	 * 住院记账自费标识修改主键
	 * @return String
	 */
	public String getId_cgiphist() {
		return ((String) getAttrVal("Id_cgiphist"));
	}	
	/**
	 * 住院记账自费标识修改主键
	 * @param Id_cgiphist
	 */
	public void setId_cgiphist(String Id_cgiphist) {
		setAttrVal("Id_cgiphist", Id_cgiphist);
	}
	/**
	 * 记账主键
	 * @return String
	 */
	public String getId_cgip() {
		return ((String) getAttrVal("Id_cgip"));
	}	
	/**
	 * 记账主键
	 * @param Id_cgip
	 */
	public void setId_cgip(String Id_cgip) {
		setAttrVal("Id_cgip", Id_cgip);
	}
	/**
	 * 活动来源编码
	 * @return String
	 */
	public String getSd_actsrc() {
		return ((String) getAttrVal("Sd_actsrc"));
	}	
	/**
	 * 活动来源编码
	 * @param Sd_actsrc
	 */
	public void setSd_actsrc(String Sd_actsrc) {
		setAttrVal("Sd_actsrc", Sd_actsrc);
	}
	/**
	 * 活动时间
	 * @return FDateTime
	 */
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	/**
	 * 活动时间
	 * @param Dt_act
	 */
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	/**
	 * 操作科室
	 * @return String
	 */
	public String getId_dep_act() {
		return ((String) getAttrVal("Id_dep_act"));
	}	
	/**
	 * 操作科室
	 * @param Id_dep_act
	 */
	public void setId_dep_act(String Id_dep_act) {
		setAttrVal("Id_dep_act", Id_dep_act);
	}
	/**
	 * 操作人员
	 * @return String
	 */
	public String getId_emp_act() {
		return ((String) getAttrVal("Id_emp_act"));
	}	
	/**
	 * 操作人员
	 * @param Id_emp_act
	 */
	public void setId_emp_act(String Id_emp_act) {
		setAttrVal("Id_emp_act", Id_emp_act);
	}
	/**
	 * 操作方式
	 * @return Integer
	 */
	public Integer getEu_act() {
		return ((Integer) getAttrVal("Eu_act"));
	}	
	/**
	 * 操作方式
	 * @param Eu_act
	 */
	public void setEu_act(Integer Eu_act) {
		setAttrVal("Eu_act", Eu_act);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 描述
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_cgiphist";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cg_ip_hist";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCgIpHistDODesc.class);
	}
	
}