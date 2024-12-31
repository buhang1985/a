package iih.bd.bs.workcalendar.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.bs.workcalendar.d.desc.WorkCalendYearDODesc;
import java.math.BigDecimal;

/**
 * 年度信息 DO数据 
 * 
 */
public class WorkCalendYearDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//年度信息主键标识
	public static final String ID_WORKCALENDYEAR= "Id_workcalendyear";
	//工作年度
	public static final String WORKYEAR= "Workyear";
	//年度起始日
	public static final String WORKYEARSTARTDATE= "Workyearstartdate";
	//周数
	public static final String WORKAMOUNT= "Workamount";
	//显示年度
	public static final String SHOWYEAR= "Showyear";
	//数据来源方式
	public static final String DATAFROMTYPE= "Datafromtype";
	//工作日历
	public static final String ID_WORKCALENDAR= "Id_workcalendar";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 年度信息主键标识
	 * @return String
	 */
	public String getId_workcalendyear() {
		return ((String) getAttrVal("Id_workcalendyear"));
	}	
	/**
	 * 年度信息主键标识
	 * @param Id_workcalendyear
	 */
	public void setId_workcalendyear(String Id_workcalendyear) {
		setAttrVal("Id_workcalendyear", Id_workcalendyear);
	}
	/**
	 * 工作年度
	 * @return Integer
	 */
	public Integer getWorkyear() {
		return ((Integer) getAttrVal("Workyear"));
	}	
	/**
	 * 工作年度
	 * @param Workyear
	 */
	public void setWorkyear(Integer Workyear) {
		setAttrVal("Workyear", Workyear);
	}
	/**
	 * 年度起始日
	 * @return FDate
	 */
	public FDate getWorkyearstartdate() {
		return ((FDate) getAttrVal("Workyearstartdate"));
	}	
	/**
	 * 年度起始日
	 * @param Workyearstartdate
	 */
	public void setWorkyearstartdate(FDate Workyearstartdate) {
		setAttrVal("Workyearstartdate", Workyearstartdate);
	}
	/**
	 * 周数
	 * @return Integer
	 */
	public Integer getWorkamount() {
		return ((Integer) getAttrVal("Workamount"));
	}	
	/**
	 * 周数
	 * @param Workamount
	 */
	public void setWorkamount(Integer Workamount) {
		setAttrVal("Workamount", Workamount);
	}
	/**
	 * 显示年度
	 * @return String
	 */
	public String getShowyear() {
		return ((String) getAttrVal("Showyear"));
	}	
	/**
	 * 显示年度
	 * @param Showyear
	 */
	public void setShowyear(String Showyear) {
		setAttrVal("Showyear", Showyear);
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
		return "Id_workcalendyear";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_workcalendyear";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WorkCalendYearDODesc.class);
	}
	
}