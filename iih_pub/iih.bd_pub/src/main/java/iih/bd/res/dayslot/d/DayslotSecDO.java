package iih.bd.res.dayslot.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.dayslot.d.desc.DayslotSecDODesc;
import java.math.BigDecimal;

/**
 * 日期分组时段 DO数据 
 * 
 */
public class DayslotSecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//日期分组时段ID
	public static final String ID_DAYSLOTSEC= "Id_dayslotsec";
	//日期分组
	public static final String ID_DAYSLOT= "Id_dayslot";
	//序号
	public static final String SORTNO= "Sortno";
	//时段编码
	public static final String CODE= "Code";
	//时段名称
	public static final String NAME= "Name";
	//时段期间（分）
	public static final String PERIOD= "Period";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//时段开始时间
	public static final String TIME_BEGIN= "Time_begin";
	//时段结束时间
	public static final String TIME_END= "Time_end";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 日期分组时段ID
	 * @return String
	 */
	public String getId_dayslotsec() {
		return ((String) getAttrVal("Id_dayslotsec"));
	}	
	/**
	 * 日期分组时段ID
	 * @param Id_dayslotsec
	 */
	public void setId_dayslotsec(String Id_dayslotsec) {
		setAttrVal("Id_dayslotsec", Id_dayslotsec);
	}
	/**
	 * 日期分组
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}	
	/**
	 * 日期分组
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 时段编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 时段编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 时段名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 时段名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 时段期间（分）
	 * @return Integer
	 */
	public Integer getPeriod() {
		return ((Integer) getAttrVal("Period"));
	}	
	/**
	 * 时段期间（分）
	 * @param Period
	 */
	public void setPeriod(Integer Period) {
		setAttrVal("Period", Period);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 时段开始时间
	 * @return FTime
	 */
	public FTime getTime_begin() {
		return ((FTime) getAttrVal("Time_begin"));
	}	
	/**
	 * 时段开始时间
	 * @param Time_begin
	 */
	public void setTime_begin(FTime Time_begin) {
		setAttrVal("Time_begin", Time_begin);
	}
	/**
	 * 时段结束时间
	 * @return FTime
	 */
	public FTime getTime_end() {
		return ((FTime) getAttrVal("Time_end"));
	}	
	/**
	 * 时段结束时间
	 * @param Time_end
	 */
	public void setTime_end(FTime Time_end) {
		setAttrVal("Time_end", Time_end);
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
		return "Id_dayslotsec";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_dayslot_sec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DayslotSecDODesc.class);
	}
	
}