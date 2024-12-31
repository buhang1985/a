package iih.pi.acc.piaccbank.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.acc.piaccbank.d.desc.PiPatCredBankDODesc;
import java.math.BigDecimal;

/**
 * 患者信用与与银行卡关联 DO数据 
 * 
 */
public class PiPatCredBankDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATACCBANK= "Id_pataccbank";
	public static final String ID_PATACC= "Id_patacc";
	public static final String SD_BANK= "Sd_bank";
	public static final String ID_BANK= "Id_bank";
	public static final String BANKACC= "Bankacc";
	public static final String FG_ACT= "Fg_act";
	public static final String ACCBANK_CODE= "Accbank_code";
	public static final String ACCBANK_NAME= "Accbank_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pataccbank() {
		return ((String) getAttrVal("Id_pataccbank"));
	}	
	public void setId_pataccbank(String Id_pataccbank) {
		setAttrVal("Id_pataccbank", Id_pataccbank);
	}
	
	public String getId_patacc() {
		return ((String) getAttrVal("Id_patacc"));
	}	
	public void setId_patacc(String Id_patacc) {
		setAttrVal("Id_patacc", Id_patacc);
	}
	
	public String getSd_bank() {
		return ((String) getAttrVal("Sd_bank"));
	}	
	public void setSd_bank(String Sd_bank) {
		setAttrVal("Sd_bank", Sd_bank);
	}
	
	public String getId_bank() {
		return ((String) getAttrVal("Id_bank"));
	}	
	public void setId_bank(String Id_bank) {
		setAttrVal("Id_bank", Id_bank);
	}
	
	public String getBankacc() {
		return ((String) getAttrVal("Bankacc"));
	}	
	public void setBankacc(String Bankacc) {
		setAttrVal("Bankacc", Bankacc);
	}
	
	public FBoolean getFg_act() {
		return ((FBoolean) getAttrVal("Fg_act"));
	}	
	public void setFg_act(FBoolean Fg_act) {
		setAttrVal("Fg_act", Fg_act);
	}
	
	public String getAccbank_code() {
		return ((String) getAttrVal("Accbank_code"));
	}	
	public void setAccbank_code(String Accbank_code) {
		setAttrVal("Accbank_code", Accbank_code);
	}
	
	public String getAccbank_name() {
		return ((String) getAttrVal("Accbank_name"));
	}	
	public void setAccbank_name(String Accbank_name) {
		setAttrVal("Accbank_name", Accbank_name);
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
		return "Id_pataccbank";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_cred_bank";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(PiPatCredBankDODesc.class);
	}
	
}