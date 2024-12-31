package iih.bd.bs.workcalendar.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.bs.workcalendar.d.desc.WorkCalendDateDODesc;
import java.math.BigDecimal;

/**
 * 日期信息 DO数据 
 * 
 */
public class WorkCalendDateDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//日期信息主键标识
	public static final String ID_WORKCALENDDATE= "Id_workcalenddate";
	//日历日期
	public static final String CALENDARDATE= "Calendardate";
	//日期类型
	public static final String DATEWORKTYPE= "Dateworktype";
	//上班时间
	public static final String ONDUTYTIME= "Ondutytime";
	//下班时间
	public static final String OFFDUTYTIME= "Offdutytime";
	//备注说明
	public static final String DES= "Des";
	//数据来源方式
	public static final String DATAFROMTYPE= "Datafromtype";
	//工作日历
	public static final String ID_WORKCALENDAR= "Id_workcalendar";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 日期信息主键标识
	 * @return String
	 */
	public String getId_workcalenddate() {
		return ((String) getAttrVal("Id_workcalenddate"));
	}	
	/**
	 * 日期信息主键标识
	 * @param Id_workcalenddate
	 */
	public void setId_workcalenddate(String Id_workcalenddate) {
		setAttrVal("Id_workcalenddate", Id_workcalenddate);
	}
	/**
	 * 日历日期
	 * @return FDate
	 */
	public FDate getCalendardate() {
		return ((FDate) getAttrVal("Calendardate"));
	}	
	/**
	 * 日历日期
	 * @param Calendardate
	 */
	public void setCalendardate(FDate Calendardate) {
		setAttrVal("Calendardate", Calendardate);
	}
	/**
	 * 日期类型
	 * @return Integer
	 */
	public Integer getDateworktype() {
		return ((Integer) getAttrVal("Dateworktype"));
	}	
	/**
	 * 日期类型
	 * @param Dateworktype
	 */
	public void setDateworktype(Integer Dateworktype) {
		setAttrVal("Dateworktype", Dateworktype);
	}
	/**
	 * 上班时间
	 * @return FTime
	 */
	public FTime getOndutytime() {
		return ((FTime) getAttrVal("Ondutytime"));
	}	
	/**
	 * 上班时间
	 * @param Ondutytime
	 */
	public void setOndutytime(FTime Ondutytime) {
		setAttrVal("Ondutytime", Ondutytime);
	}
	/**
	 * 下班时间
	 * @return FTime
	 */
	public FTime getOffdutytime() {
		return ((FTime) getAttrVal("Offdutytime"));
	}	
	/**
	 * 下班时间
	 * @param Offdutytime
	 */
	public void setOffdutytime(FTime Offdutytime) {
		setAttrVal("Offdutytime", Offdutytime);
	}
	/**
	 * 备注说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 工作日历
	 * @return String
	 */
	public String getId_workcalendar() {
		return ((String) getAttrVal("Id_workcalendar"));
	}	
	/**
	 * 工作日历
	 * @param Id_workcalendar
	 */
	public void setId_workcalendar(String Id_workcalendar) {
		setAttrVal("Id_workcalendar", Id_workcalendar);
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
		return "Id_workcalenddate";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_workcalenddate";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WorkCalendDateDODesc.class);
	}
	
}