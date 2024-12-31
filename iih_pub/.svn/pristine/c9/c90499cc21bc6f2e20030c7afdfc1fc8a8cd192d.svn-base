package iih.bl.prop.blproparoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.prop.blproparoep.d.desc.BlPropArItmOepDODesc;
import java.math.BigDecimal;

/**
 * 应收明细_门急体 DO数据 
 * 
 */
public class BlPropArItmOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//应收明细主键
	public static final String ID_PROPARITMOEP= "Id_proparitmoep";
	//应收
	public static final String ID_PROPAROEP= "Id_proparoep";
	//项目编码
	public static final String CODE= "Code";
	//项目名称
	public static final String NAME= "Name";
	//医保计划下编码
	public static final String CODE_HP= "Code_hp";
	//付款机构应付金额
	public static final String AMT_HP= "Amt_hp";
	//患者应付金额
	public static final String AMT_PAT= "Amt_pat";
	//数量
	public static final String QUAN= "Quan";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 应收明细主键
	 * @return String
	 */
	public String getId_proparitmoep() {
		return ((String) getAttrVal("Id_proparitmoep"));
	}	
	/**
	 * 应收明细主键
	 * @param Id_proparitmoep
	 */
	public void setId_proparitmoep(String Id_proparitmoep) {
		setAttrVal("Id_proparitmoep", Id_proparitmoep);
	}
	/**
	 * 应收
	 * @return String
	 */
	public String getId_proparoep() {
		return ((String) getAttrVal("Id_proparoep"));
	}	
	/**
	 * 应收
	 * @param Id_proparoep
	 */
	public void setId_proparoep(String Id_proparoep) {
		setAttrVal("Id_proparoep", Id_proparoep);
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
	 * 医保计划下编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保计划下编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 付款机构应付金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	/**
	 * 付款机构应付金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 患者应付金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	/**
	 * 患者应付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
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
		return "Id_proparitmoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prop_ar_itm_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPropArItmOepDODesc.class);
	}
	
}