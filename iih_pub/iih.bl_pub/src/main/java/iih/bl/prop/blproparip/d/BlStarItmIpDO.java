package iih.bl.prop.blproparip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.prop.blproparip.d.desc.BlStarItmIpDODesc;
import java.math.BigDecimal;

/**
 * 应收明细_住院 DO数据 
 * 
 */
public class BlStarItmIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PROPARITMIP= "Id_proparitmip";
	public static final String ID_PROPARIP= "Id_proparip";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String CODE_HP= "Code_hp";
	public static final String AMT_HP= "Amt_hp";
	public static final String AMT_PAT= "Amt_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_proparitmip() {
		return ((String) getAttrVal("Id_proparitmip"));
	}	
	public void setId_proparitmip(String Id_proparitmip) {
		setAttrVal("Id_proparitmip", Id_proparitmip);
	}
	public String getId_proparip() {
		return ((String) getAttrVal("Id_proparip"));
	}	
	public void setId_proparip(String Id_proparip) {
		setAttrVal("Id_proparip", Id_proparip);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
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
		return "Id_proparitmip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_st_ar_itm_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlStarItmIpDODesc.class);
	}
	
}