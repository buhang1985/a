package iih.bl.inc.blincoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blincoep.d.desc.BlIncItmOepDODesc;
import java.math.BigDecimal;

/**
 * 发票账单项_门急体 DO数据 
 * 
 */
public class BlIncItmOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//发票明细主键
	public static final String ID_INCITMOEP= "Id_incitmoep";
	//发票
	public static final String ID_INCOEP= "Id_incoep";
	//项目编码
	public static final String CODE= "Code";
	//项目名称
	public static final String NAME= "Name";
	//金额_标准
	public static final String AMT_STD= "Amt_std";
	//金额_折扣
	public static final String AMT_RATIO= "Amt_ratio";
	//金额_医保计划
	public static final String AMT_HP= "Amt_hp";
	//金额_患者自付
	public static final String AMT_PAT= "Amt_pat";
	//金额_减免
	public static final String AMT_FREE= "Amt_free";
	//医保自付减免金额
	public static final String AMT_HP_FREE= "Amt_hp_free";
	//项目减免金额
	public static final String AMT_PAT_FREE= "Amt_pat_free";
	//金额
	public static final String AMT= "Amt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 发票明细主键
	 * @return String
	 */
	public String getId_incitmoep() {
		return ((String) getAttrVal("Id_incitmoep"));
	}	
	/**
	 * 发票明细主键
	 * @param Id_incitmoep
	 */
	public void setId_incitmoep(String Id_incitmoep) {
		setAttrVal("Id_incitmoep", Id_incitmoep);
	}
	/**
	 * 发票
	 * @return String
	 */
	public String getId_incoep() {
		return ((String) getAttrVal("Id_incoep"));
	}	
	/**
	 * 发票
	 * @param Id_incoep
	 */
	public void setId_incoep(String Id_incoep) {
		setAttrVal("Id_incoep", Id_incoep);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 项目编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 金额_标准
	 * @return FDouble
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}	
	/**
	 * 金额_标准
	 * @param Amt_std
	 */
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 金额_折扣
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}	
	/**
	 * 金额_折扣
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 金额_医保计划
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	/**
	 * 金额_医保计划
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 金额_患者自付
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	/**
	 * 金额_患者自付
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 金额_减免
	 * @return FDouble
	 */
	public FDouble getAmt_free() {
		return ((FDouble) getAttrVal("Amt_free"));
	}	
	/**
	 * 金额_减免
	 * @param Amt_free
	 */
	public void setAmt_free(FDouble Amt_free) {
		setAttrVal("Amt_free", Amt_free);
	}
	/**
	 * 医保自付减免金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp_free() {
		return ((FDouble) getAttrVal("Amt_hp_free"));
	}	
	/**
	 * 医保自付减免金额
	 * @param Amt_hp_free
	 */
	public void setAmt_hp_free(FDouble Amt_hp_free) {
		setAttrVal("Amt_hp_free", Amt_hp_free);
	}
	/**
	 * 项目减免金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat_free() {
		return ((FDouble) getAttrVal("Amt_pat_free"));
	}	
	/**
	 * 项目减免金额
	 * @param Amt_pat_free
	 */
	public void setAmt_pat_free(FDouble Amt_pat_free) {
		setAttrVal("Amt_pat_free", Amt_pat_free);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
		return "Id_incitmoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_inc_itm_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlIncItmOepDODesc.class);
	}
	
}