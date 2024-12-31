package iih.pe.phm.peinterveneplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.peinterveneplan.d.desc.PeIntervenePlanDODesc;
import java.math.BigDecimal;

/**
 * 健康干预个人计划 DO数据 
 * 
 */
public class PeIntervenePlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康干预个人计划主键标识
	public static final String ID_PEINTERVENEPLAN= "Id_peinterveneplan";
	//健康干预个人计划父ID
	public static final String ID_PEINTERVENEPLAN_PAR= "Id_peinterveneplan_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//计划编码
	public static final String CODE= "Code";
	//计划名称
	public static final String NAME= "Name";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//截止日期
	public static final String DT_END= "Dt_end";
	//周数
	public static final String WEEKS= "Weeks";
	//健康预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康干预个人计划主键标识
	 * @return String
	 */
	public String getId_peinterveneplan() {
		return ((String) getAttrVal("Id_peinterveneplan"));
	}	
	/**
	 * 健康干预个人计划主键标识
	 * @param Id_peinterveneplan
	 */
	public void setId_peinterveneplan(String Id_peinterveneplan) {
		setAttrVal("Id_peinterveneplan", Id_peinterveneplan);
	}
	/**
	 * 健康干预个人计划父ID
	 * @return String
	 */
	public String getId_peinterveneplan_par() {
		return ((String) getAttrVal("Id_peinterveneplan_par"));
	}	
	/**
	 * 健康干预个人计划父ID
	 * @param Id_peinterveneplan_par
	 */
	public void setId_peinterveneplan_par(String Id_peinterveneplan_par) {
		setAttrVal("Id_peinterveneplan_par", Id_peinterveneplan_par);
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
	 * 计划编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 计划编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 计划名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 计划名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 截止日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 周数
	 * @return Integer
	 */
	public Integer getWeeks() {
		return ((Integer) getAttrVal("Weeks"));
	}	
	/**
	 * 周数
	 * @param Weeks
	 */
	public void setWeeks(Integer Weeks) {
		setAttrVal("Weeks", Weeks);
	}
	/**
	 * 健康预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
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
	 * 预约日期
	 * @return FDate
	 */
	public FDate getDt_appt() {
		return ((FDate) getAttrVal("Dt_appt"));
	}	
	/**
	 * 预约日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDate Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约号
	 * @return Integer
	 */
	public Integer getNo_appt() {
		return ((Integer) getAttrVal("No_appt"));
	}	
	/**
	 * 预约号
	 * @param No_appt
	 */
	public void setNo_appt(Integer No_appt) {
		setAttrVal("No_appt", No_appt);
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
		return "Id_peinterveneplan";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_peinterveneplan";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIntervenePlanDODesc.class);
	}
	
}