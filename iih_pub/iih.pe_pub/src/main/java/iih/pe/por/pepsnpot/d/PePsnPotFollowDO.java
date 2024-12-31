package iih.pe.por.pepsnpot.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pepsnpot.d.desc.PePsnPotFollowDODesc;
import java.math.BigDecimal;

/**
 * 体检客户跟进记录 DO数据 
 * 
 */
public class PePsnPotFollowDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检潜在客户跟进主键标识
	public static final String ID_PEPSNPOTFOLLOW= "Id_pepsnpotfollow";
	//体检潜在客户ID
	public static final String ID_PEPSNPOT= "Id_pepsnpot";
	//跟进时间
	public static final String DT_FOLLOW= "Dt_follow";
	//跟进人ID
	public static final String ID_FOLLOW= "Id_follow";
	//跟进人
	public static final String NAME_FOLLOW= "Name_follow";
	//跟进记录
	public static final String NOTE= "Note";
	//跟进完成标识
	public static final String FG_FOLLOW= "Fg_follow";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检潜在客户跟进主键标识
	 * @return String
	 */
	public String getId_pepsnpotfollow() {
		return ((String) getAttrVal("Id_pepsnpotfollow"));
	}	
	/**
	 * 体检潜在客户跟进主键标识
	 * @param Id_pepsnpotfollow
	 */
	public void setId_pepsnpotfollow(String Id_pepsnpotfollow) {
		setAttrVal("Id_pepsnpotfollow", Id_pepsnpotfollow);
	}
	/**
	 * 体检潜在客户ID
	 * @return String
	 */
	public String getId_pepsnpot() {
		return ((String) getAttrVal("Id_pepsnpot"));
	}	
	/**
	 * 体检潜在客户ID
	 * @param Id_pepsnpot
	 */
	public void setId_pepsnpot(String Id_pepsnpot) {
		setAttrVal("Id_pepsnpot", Id_pepsnpot);
	}
	/**
	 * 跟进时间
	 * @return FDateTime
	 */
	public FDateTime getDt_follow() {
		return ((FDateTime) getAttrVal("Dt_follow"));
	}	
	/**
	 * 跟进时间
	 * @param Dt_follow
	 */
	public void setDt_follow(FDateTime Dt_follow) {
		setAttrVal("Dt_follow", Dt_follow);
	}
	/**
	 * 跟进人ID
	 * @return String
	 */
	public String getId_follow() {
		return ((String) getAttrVal("Id_follow"));
	}	
	/**
	 * 跟进人ID
	 * @param Id_follow
	 */
	public void setId_follow(String Id_follow) {
		setAttrVal("Id_follow", Id_follow);
	}
	/**
	 * 跟进人
	 * @return String
	 */
	public String getName_follow() {
		return ((String) getAttrVal("Name_follow"));
	}	
	/**
	 * 跟进人
	 * @param Name_follow
	 */
	public void setName_follow(String Name_follow) {
		setAttrVal("Name_follow", Name_follow);
	}
	/**
	 * 跟进记录
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 跟进记录
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 跟进完成标识
	 * @return FBoolean
	 */
	public FBoolean getFg_follow() {
		return ((FBoolean) getAttrVal("Fg_follow"));
	}	
	/**
	 * 跟进完成标识
	 * @param Fg_follow
	 */
	public void setFg_follow(FBoolean Fg_follow) {
		setAttrVal("Fg_follow", Fg_follow);
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
		return "Id_pepsnpotfollow";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pepsnpotfollow";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnPotFollowDODesc.class);
	}
	
}