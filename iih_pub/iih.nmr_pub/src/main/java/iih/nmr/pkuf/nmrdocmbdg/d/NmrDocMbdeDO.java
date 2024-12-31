package iih.nmr.pkuf.nmrdocmbdg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.nmrdocmbdg.d.desc.NmrDocMbdeDODesc;
import java.math.BigDecimal;

/**
 * 护理文书_移动_数据元 DO数据 
 * 
 */
public class NmrDocMbdeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NMR_DOC_MBDE= "Id_nmr_doc_mbde";
	public static final String ID_NMR_DOC_MBDG= "Id_nmr_doc_mbdg";
	public static final String ID_DE= "Id_de";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String NAME_ATTR= "Name_attr";
	public static final String ID_CONTROLTP= "Id_controltp";
	public static final String SD_CONTROLTP= "Sd_controltp";
	public static final String FG_KBCTM= "Fg_kbctm";
	public static final String ID_MB_KB= "Id_mb_kb";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String FG_SHOW= "Fg_show";
	public static final String FG_EDIT= "Fg_edit";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_REQUIRED= "Fg_required";
	public static final String NAME_DE= "Name_de";
	public static final String NAME_CONTROLTP= "Name_controltp";
	public static final String NAME_KB= "Name_kb";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nmr_doc_mbde() {
		return ((String) getAttrVal("Id_nmr_doc_mbde"));
	}	
	public void setId_nmr_doc_mbde(String Id_nmr_doc_mbde) {
		setAttrVal("Id_nmr_doc_mbde", Id_nmr_doc_mbde);
	}
	public String getId_nmr_doc_mbdg() {
		return ((String) getAttrVal("Id_nmr_doc_mbdg"));
	}	
	public void setId_nmr_doc_mbdg(String Id_nmr_doc_mbdg) {
		setAttrVal("Id_nmr_doc_mbdg", Id_nmr_doc_mbdg);
	}
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName_attr() {
		return ((String) getAttrVal("Name_attr"));
	}	
	public void setName_attr(String Name_attr) {
		setAttrVal("Name_attr", Name_attr);
	}
	public String getId_controltp() {
		return ((String) getAttrVal("Id_controltp"));
	}	
	public void setId_controltp(String Id_controltp) {
		setAttrVal("Id_controltp", Id_controltp);
	}
	public String getSd_controltp() {
		return ((String) getAttrVal("Sd_controltp"));
	}	
	public void setSd_controltp(String Sd_controltp) {
		setAttrVal("Sd_controltp", Sd_controltp);
	}
	public FBoolean getFg_kbctm() {
		return ((FBoolean) getAttrVal("Fg_kbctm"));
	}	
	public void setFg_kbctm(FBoolean Fg_kbctm) {
		setAttrVal("Fg_kbctm", Fg_kbctm);
	}
	public String getId_mb_kb() {
		return ((String) getAttrVal("Id_mb_kb"));
	}	
	public void setId_mb_kb(String Id_mb_kb) {
		setAttrVal("Id_mb_kb", Id_mb_kb);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FBoolean getFg_show() {
		return ((FBoolean) getAttrVal("Fg_show"));
	}	
	public void setFg_show(FBoolean Fg_show) {
		setAttrVal("Fg_show", Fg_show);
	}
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}	
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	public FBoolean getFg_required() {
		return ((FBoolean) getAttrVal("Fg_required"));
	}	
	public void setFg_required(FBoolean Fg_required) {
		setAttrVal("Fg_required", Fg_required);
	}
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}	
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
	}
	public String getName_controltp() {
		return ((String) getAttrVal("Name_controltp"));
	}	
	public void setName_controltp(String Name_controltp) {
		setAttrVal("Name_controltp", Name_controltp);
	}
	public String getName_kb() {
		return ((String) getAttrVal("Name_kb"));
	}	
	public void setName_kb(String Name_kb) {
		setAttrVal("Name_kb", Name_kb);
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
		return "Id_nmr_doc_mbde";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_DOC_MBDE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmrDocMbdeDODesc.class);
	}
	
}