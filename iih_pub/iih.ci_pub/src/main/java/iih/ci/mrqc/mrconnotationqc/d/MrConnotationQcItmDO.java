package iih.ci.mrqc.mrconnotationqc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.mrconnotationqc.d.desc.MrConnotationQcItmDODesc;
import java.math.BigDecimal;

/**
 * 内涵质控子表 DO数据 
 * 
 */
public class MrConnotationQcItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_QC_CONNONATION_ITM= "Id_mr_qc_connonation_itm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_MR_QC_CONNOTATION= "Id_mr_qc_connotation";
	public static final String ID_CONNO_REQ_ITEM= "Id_conno_req_item";
	public static final String FG_NONE= "Fg_none";
	public static final String REQ_CONNO= "Req_conno";
	public static final String REQ_CONNO_TXT= "Req_conno_txt";
	public static final String ID_REQ_ASSESS= "Id_req_assess";
	public static final String SD_REQ_ASSESS= "Sd_req_assess";
	public static final String NAME_REQ_ASSESS= "Name_req_assess";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_REQ_ASSESS_REF= "Code_req_assess_ref";
	public static final String NAME_REQ_ASSESS_REF= "Name_req_assess_ref";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr_qc_connonation_itm() {
		return ((String) getAttrVal("Id_mr_qc_connonation_itm"));
	}	
	public void setId_mr_qc_connonation_itm(String Id_mr_qc_connonation_itm) {
		setAttrVal("Id_mr_qc_connonation_itm", Id_mr_qc_connonation_itm);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_mr_qc_connotation() {
		return ((String) getAttrVal("Id_mr_qc_connotation"));
	}	
	public void setId_mr_qc_connotation(String Id_mr_qc_connotation) {
		setAttrVal("Id_mr_qc_connotation", Id_mr_qc_connotation);
	}
	public String getId_conno_req_item() {
		return ((String) getAttrVal("Id_conno_req_item"));
	}	
	public void setId_conno_req_item(String Id_conno_req_item) {
		setAttrVal("Id_conno_req_item", Id_conno_req_item);
	}
	public FBoolean getFg_none() {
		return ((FBoolean) getAttrVal("Fg_none"));
	}	
	public void setFg_none(FBoolean Fg_none) {
		setAttrVal("Fg_none", Fg_none);
	}
	public String getReq_conno() {
		return ((String) getAttrVal("Req_conno"));
	}	
	public void setReq_conno(String Req_conno) {
		setAttrVal("Req_conno", Req_conno);
	}
	public String getReq_conno_txt() {
		return ((String) getAttrVal("Req_conno_txt"));
	}	
	public void setReq_conno_txt(String Req_conno_txt) {
		setAttrVal("Req_conno_txt", Req_conno_txt);
	}
	public String getId_req_assess() {
		return ((String) getAttrVal("Id_req_assess"));
	}	
	public void setId_req_assess(String Id_req_assess) {
		setAttrVal("Id_req_assess", Id_req_assess);
	}
	public String getSd_req_assess() {
		return ((String) getAttrVal("Sd_req_assess"));
	}	
	public void setSd_req_assess(String Sd_req_assess) {
		setAttrVal("Sd_req_assess", Sd_req_assess);
	}
	public String getName_req_assess() {
		return ((String) getAttrVal("Name_req_assess"));
	}	
	public void setName_req_assess(String Name_req_assess) {
		setAttrVal("Name_req_assess", Name_req_assess);
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
	public String getCode_req_assess_ref() {
		return ((String) getAttrVal("Code_req_assess_ref"));
	}	
	public void setCode_req_assess_ref(String Code_req_assess_ref) {
		setAttrVal("Code_req_assess_ref", Code_req_assess_ref);
	}
	public String getName_req_assess_ref() {
		return ((String) getAttrVal("Name_req_assess_ref"));
	}	
	public void setName_req_assess_ref(String Name_req_assess_ref) {
		setAttrVal("Name_req_assess_ref", Name_req_assess_ref);
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
		return "Id_mr_qc_connonation_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_qc_conno_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrConnotationQcItmDODesc.class);
	}
	
}