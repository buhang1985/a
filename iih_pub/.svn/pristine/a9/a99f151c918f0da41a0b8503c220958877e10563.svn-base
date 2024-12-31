package iih.bl.hp.blhptransbankpay.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.blhptransbankpay.d.desc.BlHpTransBankPayDODesc;
import java.math.BigDecimal;

/**
 * 医保登记记录银行交易扩展 DO数据 
 * 
 */
public class BlHpTransBankPayDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TRANSACTBANKPAY= "Id_transactbankpay";
	public static final String ID_HPENTCODE= "Id_hpentcode";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE_ENTP= "Code_entp";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String BTINDEX= "Btindex";
	public static final String REFERNO= "Referno";
	public static final String POSNO= "Posno";
	public static final String DT_TRANS= "Dt_trans";
	public static final String FG_TRANS= "Fg_trans";
	public static final String BANKNO= "Bankno";
	public static final String AMT= "Amt";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_transactbankpay() {
		return ((String) getAttrVal("Id_transactbankpay"));
	}	
	public void setId_transactbankpay(String Id_transactbankpay) {
		setAttrVal("Id_transactbankpay", Id_transactbankpay);
	}
	public String getId_hpentcode() {
		return ((String) getAttrVal("Id_hpentcode"));
	}	
	public void setId_hpentcode(String Id_hpentcode) {
		setAttrVal("Id_hpentcode", Id_hpentcode);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public String getBtindex() {
		return ((String) getAttrVal("Btindex"));
	}	
	public void setBtindex(String Btindex) {
		setAttrVal("Btindex", Btindex);
	}
	public String getReferno() {
		return ((String) getAttrVal("Referno"));
	}	
	public void setReferno(String Referno) {
		setAttrVal("Referno", Referno);
	}
	public String getPosno() {
		return ((String) getAttrVal("Posno"));
	}	
	public void setPosno(String Posno) {
		setAttrVal("Posno", Posno);
	}
	public FDateTime getDt_trans() {
		return ((FDateTime) getAttrVal("Dt_trans"));
	}	
	public void setDt_trans(FDateTime Dt_trans) {
		setAttrVal("Dt_trans", Dt_trans);
	}
	public FBoolean getFg_trans() {
		return ((FBoolean) getAttrVal("Fg_trans"));
	}	
	public void setFg_trans(FBoolean Fg_trans) {
		setAttrVal("Fg_trans", Fg_trans);
	}
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}	
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_transactbankpay";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_transact_bankpay";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlHpTransBankPayDODesc.class);
	}
	
}