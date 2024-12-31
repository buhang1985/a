package iih.pe.pqc.peqcrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqc.peqcrecord.d.desc.PeQCRecordDODesc;
import java.math.BigDecimal;

/**
 * 体检质量记录 DO数据 
 * 
 */
public class PeQCRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEQCRECORD= "Id_peqcrecord";
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_INSPECTOR= "Id_inspector";
	public static final String ID_NOTIFIER= "Id_notifier";
	public static final String ID_PEQCLEVEL= "Id_peqclevel";
	public static final String DT_INSPECTOR= "Dt_inspector";
	public static final String DT_DEAL= "Dt_deal";
	public static final String FG_DEAL= "Fg_deal";
	public static final String ISSUSECA= "Issuseca";
	public static final String ISSUSE= "Issuse";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CARD_PE= "Card_pe";
	public static final String DT_PE= "Dt_pe";
	public static final String NAME_PSN= "Name_psn";
	public static final String SD_SEX_PSN= "Sd_sex_psn";
	public static final String NAME_INSPECTOR= "Name_inspector";
	public static final String CODE_INSPECTOR= "Code_inspector";
	public static final String NAME_NOTIFIER= "Name_notifier";
	public static final String CODE_NOTIFIER= "Code_notifier";
	public static final String CODE_QCLEVEL= "Code_qclevel";
	public static final String NAME_QCLEVEL= "Name_qclevel";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peqcrecord() {
		return ((String) getAttrVal("Id_peqcrecord"));
	}	
	public void setId_peqcrecord(String Id_peqcrecord) {
		setAttrVal("Id_peqcrecord", Id_peqcrecord);
	}
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
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
	public String getId_inspector() {
		return ((String) getAttrVal("Id_inspector"));
	}	
	public void setId_inspector(String Id_inspector) {
		setAttrVal("Id_inspector", Id_inspector);
	}
	public String getId_notifier() {
		return ((String) getAttrVal("Id_notifier"));
	}	
	public void setId_notifier(String Id_notifier) {
		setAttrVal("Id_notifier", Id_notifier);
	}
	public String getId_peqclevel() {
		return ((String) getAttrVal("Id_peqclevel"));
	}	
	public void setId_peqclevel(String Id_peqclevel) {
		setAttrVal("Id_peqclevel", Id_peqclevel);
	}
	public FDateTime getDt_inspector() {
		return ((FDateTime) getAttrVal("Dt_inspector"));
	}	
	public void setDt_inspector(FDateTime Dt_inspector) {
		setAttrVal("Dt_inspector", Dt_inspector);
	}
	public FDateTime getDt_deal() {
		return ((FDateTime) getAttrVal("Dt_deal"));
	}	
	public void setDt_deal(FDateTime Dt_deal) {
		setAttrVal("Dt_deal", Dt_deal);
	}
	public FBoolean getFg_deal() {
		return ((FBoolean) getAttrVal("Fg_deal"));
	}	
	public void setFg_deal(FBoolean Fg_deal) {
		setAttrVal("Fg_deal", Fg_deal);
	}
	public Integer getIssuseca() {
		return ((Integer) getAttrVal("Issuseca"));
	}	
	public void setIssuseca(Integer Issuseca) {
		setAttrVal("Issuseca", Issuseca);
	}
	public String getIssuse() {
		return ((String) getAttrVal("Issuse"));
	}	
	public void setIssuse(String Issuse) {
		setAttrVal("Issuse", Issuse);
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
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}	
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}	
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	public Integer getSd_sex_psn() {
		return ((Integer) getAttrVal("Sd_sex_psn"));
	}	
	public void setSd_sex_psn(Integer Sd_sex_psn) {
		setAttrVal("Sd_sex_psn", Sd_sex_psn);
	}
	public String getName_inspector() {
		return ((String) getAttrVal("Name_inspector"));
	}	
	public void setName_inspector(String Name_inspector) {
		setAttrVal("Name_inspector", Name_inspector);
	}
	public String getCode_inspector() {
		return ((String) getAttrVal("Code_inspector"));
	}	
	public void setCode_inspector(String Code_inspector) {
		setAttrVal("Code_inspector", Code_inspector);
	}
	public String getName_notifier() {
		return ((String) getAttrVal("Name_notifier"));
	}	
	public void setName_notifier(String Name_notifier) {
		setAttrVal("Name_notifier", Name_notifier);
	}
	public String getCode_notifier() {
		return ((String) getAttrVal("Code_notifier"));
	}	
	public void setCode_notifier(String Code_notifier) {
		setAttrVal("Code_notifier", Code_notifier);
	}
	public String getCode_qclevel() {
		return ((String) getAttrVal("Code_qclevel"));
	}	
	public void setCode_qclevel(String Code_qclevel) {
		setAttrVal("Code_qclevel", Code_qclevel);
	}
	public String getName_qclevel() {
		return ((String) getAttrVal("Name_qclevel"));
	}	
	public void setName_qclevel(String Name_qclevel) {
		setAttrVal("Name_qclevel", Name_qclevel);
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
		return "Id_peqcrecord";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qc_peqcrecord";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeQCRecordDODesc.class);
	}
	
}