package iih.mp.ne.transfusion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ne.transfusion.d.desc.NeBtrItmDODesc;
import java.math.BigDecimal;

/**
 * 输血记录明细 DO数据 
 * 
 */
public class NeBtrItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NEBTRITM= "Id_nebtritm";
	public static final String ID_NEBTR= "Id_nebtr";
	public static final String CODE= "Code";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_BLOOD_ABO= "Id_blood_abo";
	public static final String SD_BLOOD_ABO= "Sd_blood_abo";
	public static final String BLD_CON= "Bld_con";
	public static final String ID_BLOOD_RH= "Id_blood_rh";
	public static final String SD_BLOOD_RH= "Sd_blood_rh";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nebtritm() {
		return ((String) getAttrVal("Id_nebtritm"));
	}	
	public void setId_nebtritm(String Id_nebtritm) {
		setAttrVal("Id_nebtritm", Id_nebtritm);
	}
	public String getId_nebtr() {
		return ((String) getAttrVal("Id_nebtr"));
	}	
	public void setId_nebtr(String Id_nebtr) {
		setAttrVal("Id_nebtr", Id_nebtr);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_blood_abo() {
		return ((String) getAttrVal("Id_blood_abo"));
	}	
	public void setId_blood_abo(String Id_blood_abo) {
		setAttrVal("Id_blood_abo", Id_blood_abo);
	}
	public String getSd_blood_abo() {
		return ((String) getAttrVal("Sd_blood_abo"));
	}	
	public void setSd_blood_abo(String Sd_blood_abo) {
		setAttrVal("Sd_blood_abo", Sd_blood_abo);
	}
	public String getBld_con() {
		return ((String) getAttrVal("Bld_con"));
	}	
	public void setBld_con(String Bld_con) {
		setAttrVal("Bld_con", Bld_con);
	}
	public String getId_blood_rh() {
		return ((String) getAttrVal("Id_blood_rh"));
	}	
	public void setId_blood_rh(String Id_blood_rh) {
		setAttrVal("Id_blood_rh", Id_blood_rh);
	}
	public String getSd_blood_rh() {
		return ((String) getAttrVal("Sd_blood_rh"));
	}	
	public void setSd_blood_rh(String Sd_blood_rh) {
		setAttrVal("Sd_blood_rh", Sd_blood_rh);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_nebtritm";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_NE_BTR_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NeBtrItmDODesc.class);
	}
	
}