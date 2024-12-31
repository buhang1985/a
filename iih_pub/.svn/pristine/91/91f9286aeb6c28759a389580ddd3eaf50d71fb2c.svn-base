package iih.bd.bs.workcalendar.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.bs.workcalendar.d.desc.WorkCalendarDODesc;
import java.math.BigDecimal;

/**
 * 工作日历 DO数据 
 * 
 */
public class WorkCalendarDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//工作日历主键标识
	public static final String ID_WORKCALENDAR= "Id_workcalendar";
	//所属集团
	public static final String ID_GROUP= "Id_group";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所依据日历规则
	public static final String ID_WORKCALENDRULE= "Id_workcalendrule";
	//工作日历编码
	public static final String CODE= "Code";
	//工作日历名称
	public static final String NAME= "Name";
	//默认工作日历
	public static final String ISDEFAULT= "Isdefault";
	//起始日期
	public static final String BEGINDATE= "Begindate";
	//结束日期
	public static final String ENDDATE= "Enddate";
	//年度起始日
	public static final String YEARSTARTDATE= "Yearstartdate";
	//启用状态
	public static final String ACTIVESTATE= "Activestate";
	//每周起始日
	public static final String FIRSTDAYPERWEEK= "Firstdayperweek";
	//数据来源方式
	public static final String DATAFROMTYPE= "Datafromtype";
	//假日类别
	public static final String ID_HOLIDAYCATE= "Id_holidaycate";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//工作日历规则编码
	public static final String WORKCALENDARRULE_CODE= "Workcalendarrule_code";
	//工作日历规则名称
	public static final String WORKCALENDARRULE_NAME= "Workcalendarrule_name";
	//编码
	public static final String HOLIDAYCATE_CODE= "Holidaycate_code";
	//名称
	public static final String HOLIDAYCATE_NAME= "Holidaycate_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 工作日历主键标识
	 * @return String
	 */
	public String getId_workcalendar() {
		return ((String) getAttrVal("Id_workcalendar"));
	}	
	/**
	 * 工作日历主键标识
	 * @param Id_workcalendar
	 */
	public void setId_workcalendar(String Id_workcalendar) {
		setAttrVal("Id_workcalendar", Id_workcalendar);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	/**
	 * 所属集团
	 * @param Id_group
	 */
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
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
	 * 所依据日历规则
	 * @return String
	 */
	public String getId_workcalendrule() {
		return ((String) getAttrVal("Id_workcalendrule"));
	}	
	/**
	 * 所依据日历规则
	 * @param Id_workcalendrule
	 */
	public void setId_workcalendrule(String Id_workcalendrule) {
		setAttrVal("Id_workcalendrule", Id_workcalendrule);
	}
	/**
	 * 工作日历编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 工作日历编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 工作日历名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 工作日历名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 默认工作日历
	 * @return FBoolean
	 */
	public FBoolean getIsdefault() {
		return ((FBoolean) getAttrVal("Isdefault"));
	}	
	/**
	 * 默认工作日历
	 * @param Isdefault
	 */
	public void setIsdefault(FBoolean Isdefault) {
		setAttrVal("Isdefault", Isdefault);
	}
	/**
	 * 起始日期
	 * @return FDate
	 */
	public FDate getBegindate() {
		return ((FDate) getAttrVal("Begindate"));
	}	
	/**
	 * 起始日期
	 * @param Begindate
	 */
	public void setBegindate(FDate Begindate) {
		setAttrVal("Begindate", Begindate);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getEnddate() {
		return ((FDate) getAttrVal("Enddate"));
	}	
	/**
	 * 结束日期
	 * @param Enddate
	 */
	public void setEnddate(FDate Enddate) {
		setAttrVal("Enddate", Enddate);
	}
	/**
	 * 年度起始日
	 * @return FDate
	 */
	public FDate getYearstartdate() {
		return ((FDate) getAttrVal("Yearstartdate"));
	}	
	/**
	 * 年度起始日
	 * @param Yearstartdate
	 */
	public void setYearstartdate(FDate Yearstartdate) {
		setAttrVal("Yearstartdate", Yearstartdate);
	}
	/**
	 * 启用状态
	 * @return Integer
	 */
	public Integer getActivestate() {
		return ((Integer) getAttrVal("Activestate"));
	}	
	/**
	 * 启用状态
	 * @param Activestate
	 */
	public void setActivestate(Integer Activestate) {
		setAttrVal("Activestate", Activestate);
	}
	/**
	 * 每周起始日
	 * @return Integer
	 */
	public Integer getFirstdayperweek() {
		return ((Integer) getAttrVal("Firstdayperweek"));
	}	
	/**
	 * 每周起始日
	 * @param Firstdayperweek
	 */
	public void setFirstdayperweek(Integer Firstdayperweek) {
		setAttrVal("Firstdayperweek", Firstdayperweek);
	}
	/**
	 * 数据来源方式
	 * @return Integer
	 */
	public Integer getDatafromtype() {
		return ((Integer) getAttrVal("Datafromtype"));
	}	
	/**
	 * 数据来源方式
	 * @param Datafromtype
	 */
	public void setDatafromtype(Integer Datafromtype) {
		setAttrVal("Datafromtype", Datafromtype);
	}
	/**
	 * 假日类别
	 * @return String
	 */
	public String getId_holidaycate() {
		return ((String) getAttrVal("Id_holidaycate"));
	}	
	/**
	 * 假日类别
	 * @param Id_holidaycate
	 */
	public void setId_holidaycate(String Id_holidaycate) {
		setAttrVal("Id_holidaycate", Id_holidaycate);
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
	 * 工作日历规则编码
	 * @return String
	 */
	public String getWorkcalendarrule_code() {
		return ((String) getAttrVal("Workcalendarrule_code"));
	}	
	/**
	 * 工作日历规则编码
	 * @param Workcalendarrule_code
	 */
	public void setWorkcalendarrule_code(String Workcalendarrule_code) {
		setAttrVal("Workcalendarrule_code", Workcalendarrule_code);
	}
	/**
	 * 工作日历规则名称
	 * @return String
	 */
	public String getWorkcalendarrule_name() {
		return ((String) getAttrVal("Workcalendarrule_name"));
	}	
	/**
	 * 工作日历规则名称
	 * @param Workcalendarrule_name
	 */
	public void setWorkcalendarrule_name(String Workcalendarrule_name) {
		setAttrVal("Workcalendarrule_name", Workcalendarrule_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHolidaycate_code() {
		return ((String) getAttrVal("Holidaycate_code"));
	}	
	/**
	 * 编码
	 * @param Holidaycate_code
	 */
	public void setHolidaycate_code(String Holidaycate_code) {
		setAttrVal("Holidaycate_code", Holidaycate_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHolidaycate_name() {
		return ((String) getAttrVal("Holidaycate_name"));
	}	
	/**
	 * 名称
	 * @param Holidaycate_name
	 */
	public void setHolidaycate_name(String Holidaycate_name) {
		setAttrVal("Holidaycate_name", Holidaycate_name);
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
		return "Id_workcalendar";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_workcalendar";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WorkCalendarDODesc.class);
	}
	
}