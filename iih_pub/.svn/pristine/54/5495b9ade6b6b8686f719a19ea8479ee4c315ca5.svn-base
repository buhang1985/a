package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorder.d.desc.OrdFreqTimeDODesc;
import java.math.BigDecimal;

/**
 * 医嘱频次执行时刻 DO数据 
 * 
 */
public class OrdFreqTimeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱执行时刻主键标识
	public static final String ID_ORFREQTIME= "Id_orfreqtime";
	//医嘱
	public static final String ID_OR= "Id_or";
	//序号
	public static final String SORTNO= "Sortno";
	//计划日期
	public static final String WDNO= "Wdno";
	//执行时刻
	public static final String TIME_MP= "Time_mp";
	//执行时刻描述
	public static final String DES_MP= "Des_mp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱执行时刻主键标识
	 * @return String
	 */
	public String getId_orfreqtime() {
		return ((String) getAttrVal("Id_orfreqtime"));
	}	
	/**
	 * 医嘱执行时刻主键标识
	 * @param Id_orfreqtime
	 */
	public void setId_orfreqtime(String Id_orfreqtime) {
		setAttrVal("Id_orfreqtime", Id_orfreqtime);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 计划日期
	 * @return FDate
	 */
	public FDate getWdno() {
		return ((FDate) getAttrVal("Wdno"));
	}	
	/**
	 * 计划日期
	 * @param Wdno
	 */
	public void setWdno(FDate Wdno) {
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
	 * 执行时刻描述
	 * @return String
	 */
	public String getDes_mp() {
		return ((String) getAttrVal("Des_mp"));
	}	
	/**
	 * 执行时刻描述
	 * @param Des_mp
	 */
	public void setDes_mp(String Des_mp) {
		setAttrVal("Des_mp", Des_mp);
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
		return "Id_orfreqtime";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_freq";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdFreqTimeDODesc.class);
	}
	
}