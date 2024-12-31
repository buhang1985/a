package iih.pe.pds.pedsdiag.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pds.pedsdiag.d.desc.PeDsDiagDODesc;
import java.math.BigDecimal;

/**
 * 体检诊断决策支持 DO数据 
 * 
 */
public class PeDsDiagDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDSDIAG= "Id_pedsdiag";
	public static final String ID_PEDSDIAG_PAR= "Id_pedsdiag_par";
	public static final String ENTROPY= "Entropy";
	public static final String CONDITIONAL_ENTROPY= "Conditional_entropy";
	public static final String GAIN= "Gain";
	public static final String GAIN_RATIO= "Gain_ratio";
	public static final String GINI= "Gini";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_PEDSDIAGDEF= "Id_pedsdiagdef";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedsdiag() {
		return ((String) getAttrVal("Id_pedsdiag"));
	}	
	public void setId_pedsdiag(String Id_pedsdiag) {
		setAttrVal("Id_pedsdiag", Id_pedsdiag);
	}
	public String getId_pedsdiag_par() {
		return ((String) getAttrVal("Id_pedsdiag_par"));
	}	
	public void setId_pedsdiag_par(String Id_pedsdiag_par) {
		setAttrVal("Id_pedsdiag_par", Id_pedsdiag_par);
	}
	public FDouble getEntropy() {
		return ((FDouble) getAttrVal("Entropy"));
	}	
	public void setEntropy(FDouble Entropy) {
		setAttrVal("Entropy", Entropy);
	}
	public FDouble getConditional_entropy() {
		return ((FDouble) getAttrVal("Conditional_entropy"));
	}	
	public void setConditional_entropy(FDouble Conditional_entropy) {
		setAttrVal("Conditional_entropy", Conditional_entropy);
	}
	public FDouble getGain() {
		return ((FDouble) getAttrVal("Gain"));
	}	
	public void setGain(FDouble Gain) {
		setAttrVal("Gain", Gain);
	}
	public FDouble getGain_ratio() {
		return ((FDouble) getAttrVal("Gain_ratio"));
	}	
	public void setGain_ratio(FDouble Gain_ratio) {
		setAttrVal("Gain_ratio", Gain_ratio);
	}
	public FDouble getGini() {
		return ((FDouble) getAttrVal("Gini"));
	}	
	public void setGini(FDouble Gini) {
		setAttrVal("Gini", Gini);
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
	public String getId_pedsdiagdef() {
		return ((String) getAttrVal("Id_pedsdiagdef"));
	}	
	public void setId_pedsdiagdef(String Id_pedsdiagdef) {
		setAttrVal("Id_pedsdiagdef", Id_pedsdiagdef);
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
		return "Id_pedsdiag";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ds_pedsdiag";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDsDiagDODesc.class);
	}
	
}