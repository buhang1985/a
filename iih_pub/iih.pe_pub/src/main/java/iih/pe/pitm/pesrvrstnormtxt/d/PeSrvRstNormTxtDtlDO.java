package iih.pe.pitm.pesrvrstnormtxt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvrstnormtxt.d.desc.PeSrvRstNormTxtDtlDODesc;
import java.math.BigDecimal;

/**
 * 体检结果正常时报告内容明细 DO数据 
 * 
 */
public class PeSrvRstNormTxtDtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ID_PESRVRSTNORMTXTDTL= "Id_id_pesrvrstnormtxtdtl";
	public static final String ID_PESRVRSTNORMTXT= "Id_pesrvrstnormtxt";
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_PEITM= "Code_peitm";
	public static final String NAME_PETIM= "Name_petim";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_id_pesrvrstnormtxtdtl() {
		return ((String) getAttrVal("Id_id_pesrvrstnormtxtdtl"));
	}	
	public void setId_id_pesrvrstnormtxtdtl(String Id_id_pesrvrstnormtxtdtl) {
		setAttrVal("Id_id_pesrvrstnormtxtdtl", Id_id_pesrvrstnormtxtdtl);
	}
	public String getId_pesrvrstnormtxt() {
		return ((String) getAttrVal("Id_pesrvrstnormtxt"));
	}	
	public void setId_pesrvrstnormtxt(String Id_pesrvrstnormtxt) {
		setAttrVal("Id_pesrvrstnormtxt", Id_pesrvrstnormtxt);
	}
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
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
	public String getCode_peitm() {
		return ((String) getAttrVal("Code_peitm"));
	}	
	public void setCode_peitm(String Code_peitm) {
		setAttrVal("Code_peitm", Code_peitm);
	}
	public String getName_petim() {
		return ((String) getAttrVal("Name_petim"));
	}	
	public void setName_petim(String Name_petim) {
		setAttrVal("Name_petim", Name_petim);
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
		return "Id_id_pesrvrstnormtxtdtl";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvrstnormtxtdtl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvRstNormTxtDtlDODesc.class);
	}
	
}