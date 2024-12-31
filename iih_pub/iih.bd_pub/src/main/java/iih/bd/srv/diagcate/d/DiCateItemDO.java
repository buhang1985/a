package iih.bd.srv.diagcate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.diagcate.d.desc.DiCateItemDODesc;
import java.math.BigDecimal;

/**
 * 疾病诊断分类项目 DO数据 
 * 
 */
public class DiCateItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DICAITMREL= "Id_dicaitmrel";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DICA= "Id_dica";
	public static final String ID_DIDEF= "Id_didef";
	public static final String ID_CDSYS= "Id_cdsys";
	public static final String ID_CDSYSTP= "Id_cdsystp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DICA_NAME= "Dica_name";
	public static final String DIAG_NAME= "Diag_name";
	public static final String CODE_DIAG= "Code_diag";
	public static final String SD_CDSYSTP_DIAG= "Sd_cdsystp_diag";
	public static final String ID_DISTDCA_DIAG= "Id_distdca_diag";
	public static final String ID_CDSYS_DIAG= "Id_cdsys_diag";
	public static final String DT_ID_CDSYSTP= "Dt_id_cdsystp";
	public static final String CDSYS_NAME= "Cdsys_name";
	public static final String CDSYS_CODE= "Cdsys_code";
	public static final String TP_NAME= "Tp_name";
	public static final String TP_CODE= "Tp_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dicaitmrel() {
		return ((String) getAttrVal("Id_dicaitmrel"));
	}	
	public void setId_dicaitmrel(String Id_dicaitmrel) {
		setAttrVal("Id_dicaitmrel", Id_dicaitmrel);
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
	public String getId_dica() {
		return ((String) getAttrVal("Id_dica"));
	}	
	public void setId_dica(String Id_dica) {
		setAttrVal("Id_dica", Id_dica);
	}
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	public String getId_cdsys() {
		return ((String) getAttrVal("Id_cdsys"));
	}	
	public void setId_cdsys(String Id_cdsys) {
		setAttrVal("Id_cdsys", Id_cdsys);
	}
	public String getId_cdsystp() {
		return ((String) getAttrVal("Id_cdsystp"));
	}	
	public void setId_cdsystp(String Id_cdsystp) {
		setAttrVal("Id_cdsystp", Id_cdsystp);
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
	public String getDica_name() {
		return ((String) getAttrVal("Dica_name"));
	}	
	public void setDica_name(String Dica_name) {
		setAttrVal("Dica_name", Dica_name);
	}
	public String getDiag_name() {
		return ((String) getAttrVal("Diag_name"));
	}	
	public void setDiag_name(String Diag_name) {
		setAttrVal("Diag_name", Diag_name);
	}
	public String getCode_diag() {
		return ((String) getAttrVal("Code_diag"));
	}	
	public void setCode_diag(String Code_diag) {
		setAttrVal("Code_diag", Code_diag);
	}
	public String getSd_cdsystp_diag() {
		return ((String) getAttrVal("Sd_cdsystp_diag"));
	}	
	public void setSd_cdsystp_diag(String Sd_cdsystp_diag) {
		setAttrVal("Sd_cdsystp_diag", Sd_cdsystp_diag);
	}
	public String getId_distdca_diag() {
		return ((String) getAttrVal("Id_distdca_diag"));
	}	
	public void setId_distdca_diag(String Id_distdca_diag) {
		setAttrVal("Id_distdca_diag", Id_distdca_diag);
	}
	public String getId_cdsys_diag() {
		return ((String) getAttrVal("Id_cdsys_diag"));
	}	
	public void setId_cdsys_diag(String Id_cdsys_diag) {
		setAttrVal("Id_cdsys_diag", Id_cdsys_diag);
	}
	public String getDt_id_cdsystp() {
		return ((String) getAttrVal("Dt_id_cdsystp"));
	}	
	public void setDt_id_cdsystp(String Dt_id_cdsystp) {
		setAttrVal("Dt_id_cdsystp", Dt_id_cdsystp);
	}
	public String getCdsys_name() {
		return ((String) getAttrVal("Cdsys_name"));
	}	
	public void setCdsys_name(String Cdsys_name) {
		setAttrVal("Cdsys_name", Cdsys_name);
	}
	public String getCdsys_code() {
		return ((String) getAttrVal("Cdsys_code"));
	}	
	public void setCdsys_code(String Cdsys_code) {
		setAttrVal("Cdsys_code", Cdsys_code);
	}
	public String getTp_name() {
		return ((String) getAttrVal("Tp_name"));
	}	
	public void setTp_name(String Tp_name) {
		setAttrVal("Tp_name", Tp_name);
	}
	public String getTp_code() {
		return ((String) getAttrVal("Tp_code"));
	}	
	public void setTp_code(String Tp_code) {
		setAttrVal("Tp_code", Tp_code);
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
		return "Id_dicaitmrel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_dica_itm_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DiCateItemDODesc.class);
	}
	
}