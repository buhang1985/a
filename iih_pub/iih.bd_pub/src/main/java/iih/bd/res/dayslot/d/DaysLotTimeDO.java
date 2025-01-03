package iih.bd.res.dayslot.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.dayslot.d.desc.DaysLotTimeDODesc;
import java.math.BigDecimal;

/**
 * 日期分组工作时间 DO数据 
 * 
 */
public class DaysLotTimeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//日期分组工作时间ID
	public static final String ID_DAYSLOTTIME= "Id_dayslottime";
	//日期分组
	public static final String ID_DAYSLOT= "Id_dayslot";
	//序号
	public static final String SORTNO= "Sortno";
	//有效期开始月
	public static final String VALIDMONTH_B= "Validmonth_b";
	//有效期开始日
	public static final String VALIDDAY_B= "Validday_b";
	//有效期结束月
	public static final String VALIDMONTH_E= "Validmonth_e";
	//有效期结束日
	public static final String VALIDDAY_E= "Validday_e";
	//日期分组上班时间
	public static final String TIME_B= "Time_b";
	//日期分组下班时间
	public static final String TIME_E= "Time_e";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 日期分组工作时间ID
	 * @return String
	 */
	public String getId_dayslottime() {
		return ((String) getAttrVal("Id_dayslottime"));
	}	
	/**
	 * 日期分组工作时间ID
	 * @param Id_dayslottime
	 */
	public void setId_dayslottime(String Id_dayslottime) {
		setAttrVal("Id_dayslottime", Id_dayslottime);
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
	 * 有效期开始月
	 * @return Integer
	 */
	public Integer getValidmonth_b() {
		return ((Integer) getAttrVal("Validmonth_b"));
	}	
	/**
	 * 有效期开始月
	 * @param Validmonth_b
	 */
	public void setValidmonth_b(Integer Validmonth_b) {
		setAttrVal("Validmonth_b", Validmonth_b);
	}
	/**
	 * 有效期开始日
	 * @return Integer
	 */
	public Integer getValidday_b() {
		return ((Integer) getAttrVal("Validday_b"));
	}	
	/**
	 * 有效期开始日
	 * @param Validday_b
	 */
	public void setValidday_b(Integer Validday_b) {
		setAttrVal("Validday_b", Validday_b);
	}
	/**
	 * 有效期结束月
	 * @return Integer
	 */
	public Integer getValidmonth_e() {
		return ((Integer) getAttrVal("Validmonth_e"));
	}	
	/**
	 * 有效期结束月
	 * @param Validmonth_e
	 */
	public void setValidmonth_e(Integer Validmonth_e) {
		setAttrVal("Validmonth_e", Validmonth_e);
	}
	/**
	 * 有效期结束日
	 * @return Integer
	 */
	public Integer getValidday_e() {
		return ((Integer) getAttrVal("Validday_e"));
	}	
	/**
	 * 有效期结束日
	 * @param Validday_e
	 */
	public void setValidday_e(Integer Validday_e) {
		setAttrVal("Validday_e", Validday_e);
	}
	/**
	 * 日期分组上班时间
	 * @return FTime
	 */
	public FTime getTime_b() {
		return ((FTime) getAttrVal("Time_b"));
	}	
	/**
	 * 日期分组上班时间
	 * @param Time_b
	 */
	public void setTime_b(FTime Time_b) {
		setAttrVal("Time_b", Time_b);
	}
	/**
	 * 日期分组下班时间
	 * @return FTime
	 */
	public FTime getTime_e() {
		return ((FTime) getAttrVal("Time_e"));
	}	
	/**
	 * 日期分组下班时间
	 * @param Time_e
	 */
	public void setTime_e(FTime Time_e) {
		setAttrVal("Time_e", Time_e);
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
		return "Id_dayslottime";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_dayslot_time";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DaysLotTimeDODesc.class);
	}
	
}