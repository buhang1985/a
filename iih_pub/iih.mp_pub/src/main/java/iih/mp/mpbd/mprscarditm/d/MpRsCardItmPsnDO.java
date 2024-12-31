package iih.mp.mpbd.mprscarditm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mprscarditm.d.desc.MpRsCardItmPsnDODesc;
import java.math.BigDecimal;

/**
 * 滚屏卡人员 DO数据 
 * 
 */
public class MpRsCardItmPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//滚屏卡人员
	public static final String ID_RS_CARD_ITM_PSN= "Id_rs_card_itm_psn";
	//滚屏卡明细ID
	public static final String ID_RS_CARD_ITM= "Id_rs_card_itm";
	//滚屏人员ID
	public static final String ID_PSN= "Id_psn";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//滚屏人员编码
	public static final String CODE_RS_EMP= "Code_rs_emp";
	//滚屏人员姓名
	public static final String NAME_RS_EMP= "Name_rs_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 滚屏卡人员
	 * @return String
	 */
	public String getId_rs_card_itm_psn() {
		return ((String) getAttrVal("Id_rs_card_itm_psn"));
	}	
	/**
	 * 滚屏卡人员
	 * @param Id_rs_card_itm_psn
	 */
	public void setId_rs_card_itm_psn(String Id_rs_card_itm_psn) {
		setAttrVal("Id_rs_card_itm_psn", Id_rs_card_itm_psn);
	}
	/**
	 * 滚屏卡明细ID
	 * @return String
	 */
	public String getId_rs_card_itm() {
		return ((String) getAttrVal("Id_rs_card_itm"));
	}	
	/**
	 * 滚屏卡明细ID
	 * @param Id_rs_card_itm
	 */
	public void setId_rs_card_itm(String Id_rs_card_itm) {
		setAttrVal("Id_rs_card_itm", Id_rs_card_itm);
	}
	/**
	 * 滚屏人员ID
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}	
	/**
	 * 滚屏人员ID
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
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
	 * 滚屏人员编码
	 * @return String
	 */
	public String getCode_rs_emp() {
		return ((String) getAttrVal("Code_rs_emp"));
	}	
	/**
	 * 滚屏人员编码
	 * @param Code_rs_emp
	 */
	public void setCode_rs_emp(String Code_rs_emp) {
		setAttrVal("Code_rs_emp", Code_rs_emp);
	}
	/**
	 * 滚屏人员姓名
	 * @return String
	 */
	public String getName_rs_emp() {
		return ((String) getAttrVal("Name_rs_emp"));
	}	
	/**
	 * 滚屏人员姓名
	 * @param Name_rs_emp
	 */
	public void setName_rs_emp(String Name_rs_emp) {
		setAttrVal("Name_rs_emp", Name_rs_emp);
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
		return "Id_rs_card_itm_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_RS_CARD_ITM_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpRsCardItmPsnDODesc.class);
	}
	
}