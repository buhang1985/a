package iih.bd.srv.freqdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.freqdef.d.desc.FreqTimeDODesc;
import java.math.BigDecimal;

/**
 * 频次执行时刻 DO数据 
 * 
 */
public class FreqTimeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱频次时刻主键标识
	public static final String ID_FREQTIME= "Id_freqtime";
	//医嘱频次
	public static final String ID_FREQ= "Id_freq";
	//序号
	public static final String SORTNO= "Sortno";
	//对应星期或日
	public static final String WDNO= "Wdno";
	//执行时刻
	public static final String TIME_MP= "Time_mp";
	//星期几
	public static final String WEEK= "Week";
	//第几天
	public static final String DAY= "Day";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱频次时刻主键标识
	 * @return String
	 */
	public String getId_freqtime() {
		return ((String) getAttrVal("Id_freqtime"));
	}	
	/**
	 * 医嘱频次时刻主键标识
	 * @param Id_freqtime
	 */
	public void setId_freqtime(String Id_freqtime) {
		setAttrVal("Id_freqtime", Id_freqtime);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
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
	 * 对应星期或日
	 * @return Integer
	 */
	public Integer getWdno() {
		return ((Integer) getAttrVal("Wdno"));
	}	
	/**
	 * 对应星期或日
	 * @param Wdno
	 */
	public void setWdno(Integer Wdno) {
		setAttrVal("Wdno", Wdno);
	}
	/**
	 * 执行时刻
	 * @return FTime
	 */
	public FTime getTime_mp() {
		return ((FTime) getAttrVal("Time_mp"));
	}	
	/**
	 * 执行时刻
	 * @param Time_mp
	 */
	public void setTime_mp(FTime Time_mp) {
		setAttrVal("Time_mp", Time_mp);
	}
	/**
	 * 星期几
	 * @return Integer
	 */
	public Integer getWeek() {
		return ((Integer) getAttrVal("Week"));
	}	
	/**
	 * 星期几
	 * @param Week
	 */
	public void setWeek(Integer Week) {
		setAttrVal("Week", Week);
	}
	/**
	 * 第几天
	 * @return Integer
	 */
	public Integer getDay() {
		return ((Integer) getAttrVal("Day"));
	}	
	/**
	 * 第几天
	 * @param Day
	 */
	public void setDay(Integer Day) {
		setAttrVal("Day", Day);
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
		return "Id_freqtime";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_freq_time";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(FreqTimeDODesc.class);
	}
	
}