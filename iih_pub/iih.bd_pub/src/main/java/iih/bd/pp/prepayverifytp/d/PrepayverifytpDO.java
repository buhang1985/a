package iih.bd.pp.prepayverifytp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.prepayverifytp.d.desc.PrepayverifytpDODesc;
import java.math.BigDecimal;

/**
 * 预交金支付身份校验类型 DO数据 
 * 
 */
public class PrepayverifytpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PREPAY_VERIFYTP= "Id_prepay_verifytp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_VERIFYTP= "Id_verifytp";
	public static final String SD_VERIFYTP= "Sd_verifytp";
	public static final String ID_SCENE= "Id_scene";
	public static final String SD_SCENE= "Sd_scene";
	public static final String VERIFYTP_LV= "Verifytp_lv";
	public static final String FG_MUST= "Fg_must";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PREPAYVERIFYTYPE_NAME= "Prepayverifytype_name";
	public static final String NAME_SCENE= "Name_scene";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prepay_verifytp() {
		return ((String) getAttrVal("Id_prepay_verifytp"));
	}	
	public void setId_prepay_verifytp(String Id_prepay_verifytp) {
		setAttrVal("Id_prepay_verifytp", Id_prepay_verifytp);
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
	public String getId_verifytp() {
		return ((String) getAttrVal("Id_verifytp"));
	}	
	public void setId_verifytp(String Id_verifytp) {
		setAttrVal("Id_verifytp", Id_verifytp);
	}
	public String getSd_verifytp() {
		return ((String) getAttrVal("Sd_verifytp"));
	}	
	public void setSd_verifytp(String Sd_verifytp) {
		setAttrVal("Sd_verifytp", Sd_verifytp);
	}
	public String getId_scene() {
		return ((String) getAttrVal("Id_scene"));
	}	
	public void setId_scene(String Id_scene) {
		setAttrVal("Id_scene", Id_scene);
	}
	public String getSd_scene() {
		return ((String) getAttrVal("Sd_scene"));
	}	
	public void setSd_scene(String Sd_scene) {
		setAttrVal("Sd_scene", Sd_scene);
	}
	public Integer getVerifytp_lv() {
		return ((Integer) getAttrVal("Verifytp_lv"));
	}	
	public void setVerifytp_lv(Integer Verifytp_lv) {
		setAttrVal("Verifytp_lv", Verifytp_lv);
	}
	public FBoolean getFg_must() {
		return ((FBoolean) getAttrVal("Fg_must"));
	}	
	public void setFg_must(FBoolean Fg_must) {
		setAttrVal("Fg_must", Fg_must);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	public String getPrepayverifytype_name() {
		return ((String) getAttrVal("Prepayverifytype_name"));
	}	
	public void setPrepayverifytype_name(String Prepayverifytype_name) {
		setAttrVal("Prepayverifytype_name", Prepayverifytype_name);
	}
	public String getName_scene() {
		return ((String) getAttrVal("Name_scene"));
	}	
	public void setName_scene(String Name_scene) {
		setAttrVal("Name_scene", Name_scene);
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
		return "Id_prepay_verifytp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_prepay_verifytp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PrepayverifytpDODesc.class);
	}
	
}