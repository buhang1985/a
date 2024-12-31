package iih.pe.pwf.pewfsamp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pewfsamp.d.desc.PeWfSampDODesc;
import java.math.BigDecimal;

/**
 * 体检标本采集记录 DO数据 
 * 
 */
public class PeWfSampDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEWFSAMPLES= "Id_pewfsamples";
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	public static final String ID_PESRVSAMPLECA= "Id_pesrvsampleca";
	public static final String SAMPLEST= "Samplest";
	public static final String DT_SAMPLING= "Dt_sampling";
	public static final String CREATEDBY= "Createdby";
	public static final String ID_NUR= "Id_nur";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_SAMP= "Code_samp";
	public static final String NAME_SAMP= "Name_samp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pewfsamples() {
		return ((String) getAttrVal("Id_pewfsamples"));
	}	
	public void setId_pewfsamples(String Id_pewfsamples) {
		setAttrVal("Id_pewfsamples", Id_pewfsamples);
	}
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	public String getId_pesrvsampleca() {
		return ((String) getAttrVal("Id_pesrvsampleca"));
	}	
	public void setId_pesrvsampleca(String Id_pesrvsampleca) {
		setAttrVal("Id_pesrvsampleca", Id_pesrvsampleca);
	}
	public Integer getSamplest() {
		return ((Integer) getAttrVal("Samplest"));
	}	
	public void setSamplest(Integer Samplest) {
		setAttrVal("Samplest", Samplest);
	}
	public FDateTime getDt_sampling() {
		return ((FDateTime) getAttrVal("Dt_sampling"));
	}	
	public void setDt_sampling(FDateTime Dt_sampling) {
		setAttrVal("Dt_sampling", Dt_sampling);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
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
	public String getCode_samp() {
		return ((String) getAttrVal("Code_samp"));
	}	
	public void setCode_samp(String Code_samp) {
		setAttrVal("Code_samp", Code_samp);
	}
	public String getName_samp() {
		return ((String) getAttrVal("Name_samp"));
	}	
	public void setName_samp(String Name_samp) {
		setAttrVal("Name_samp", Name_samp);
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
		return "Id_pewfsamples";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_pewfsamp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeWfSampDODesc.class);
	}
	
}