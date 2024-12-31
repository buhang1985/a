package iih.nmr.pkuf.nmrdocitmrcd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.nmrdocitmrcd.d.desc. NmrCollRecordDODesc;
import java.math.BigDecimal;

/**
 * 护理文书采集审核记录 DO数据 
 * 
 */
public class  NmrCollRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NMR_DOC_ITM_RCD= "Id_nmr_doc_itm_rcd";
	public static final String ID_NMR_DOC_ITM= "Id_nmr_doc_itm";
	public static final String ID_ASSESSOR= "Id_assessor";
	public static final String DT_ASSESS= "Dt_assess";
	public static final String ID_NMR_STATUS= "Id_nmr_status";
	public static final String SD_NMR_STATUS= "Sd_nmr_status";
	public static final String ID_NMR_OPER= "Id_nmr_oper";
	public static final String SD_NMR_OPER= "Sd_nmr_oper";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ASSESSOR= "Name_assessor";
	public static final String NAME_NMR_STATUS= "Name_nmr_status";
	public static final String NAME_NMR_OPER= "Name_nmr_oper";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nmr_doc_itm_rcd() {
		return ((String) getAttrVal("Id_nmr_doc_itm_rcd"));
	}	
	public void setId_nmr_doc_itm_rcd(String Id_nmr_doc_itm_rcd) {
		setAttrVal("Id_nmr_doc_itm_rcd", Id_nmr_doc_itm_rcd);
	}
	public String getId_nmr_doc_itm() {
		return ((String) getAttrVal("Id_nmr_doc_itm"));
	}	
	public void setId_nmr_doc_itm(String Id_nmr_doc_itm) {
		setAttrVal("Id_nmr_doc_itm", Id_nmr_doc_itm);
	}
	public String getId_assessor() {
		return ((String) getAttrVal("Id_assessor"));
	}	
	public void setId_assessor(String Id_assessor) {
		setAttrVal("Id_assessor", Id_assessor);
	}
	public FDateTime getDt_assess() {
		return ((FDateTime) getAttrVal("Dt_assess"));
	}	
	public void setDt_assess(FDateTime Dt_assess) {
		setAttrVal("Dt_assess", Dt_assess);
	}
	public String getId_nmr_status() {
		return ((String) getAttrVal("Id_nmr_status"));
	}	
	public void setId_nmr_status(String Id_nmr_status) {
		setAttrVal("Id_nmr_status", Id_nmr_status);
	}
	public String getSd_nmr_status() {
		return ((String) getAttrVal("Sd_nmr_status"));
	}	
	public void setSd_nmr_status(String Sd_nmr_status) {
		setAttrVal("Sd_nmr_status", Sd_nmr_status);
	}
	public String getId_nmr_oper() {
		return ((String) getAttrVal("Id_nmr_oper"));
	}	
	public void setId_nmr_oper(String Id_nmr_oper) {
		setAttrVal("Id_nmr_oper", Id_nmr_oper);
	}
	public String getSd_nmr_oper() {
		return ((String) getAttrVal("Sd_nmr_oper"));
	}	
	public void setSd_nmr_oper(String Sd_nmr_oper) {
		setAttrVal("Sd_nmr_oper", Sd_nmr_oper);
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
	public String getName_assessor() {
		return ((String) getAttrVal("Name_assessor"));
	}	
	public void setName_assessor(String Name_assessor) {
		setAttrVal("Name_assessor", Name_assessor);
	}
	public String getName_nmr_status() {
		return ((String) getAttrVal("Name_nmr_status"));
	}	
	public void setName_nmr_status(String Name_nmr_status) {
		setAttrVal("Name_nmr_status", Name_nmr_status);
	}
	public String getName_nmr_oper() {
		return ((String) getAttrVal("Name_nmr_oper"));
	}	
	public void setName_nmr_oper(String Name_nmr_oper) {
		setAttrVal("Name_nmr_oper", Name_nmr_oper);
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
		return "Id_nmr_doc_itm_rcd";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_DOC_COLL_RECORD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc( NmrCollRecordDODesc.class);
	}
	
}