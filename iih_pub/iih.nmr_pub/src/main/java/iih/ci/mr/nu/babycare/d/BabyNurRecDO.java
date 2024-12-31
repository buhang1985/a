package iih.ci.mr.nu.babycare.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.babycare.d.desc.BabyNurRecDODesc;
import java.math.BigDecimal;

/**
 * 新生儿护理记录 DO数据 
 * 
 */
public class BabyNurRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUR_REC= "Id_nur_rec";
	public static final String ID_BABY= "Id_baby";
	public static final String DT_REC= "Dt_rec";
	public static final String SUCK_TIME= "Suck_time";
	public static final String FECES= "Feces";
	public static final String PEE= "Pee";
	public static final String ID_FUNICLE= "Id_funicle";
	public static final String SD_FUNICLE= "Sd_funicle";
	public static final String ID_SKIN= "Id_skin";
	public static final String SD_SKIN= "Sd_skin";
	public static final String HEAD= "Head";
	public static final String EU_VOMIT= "Eu_vomit";
	public static final String OBSER_TREAT= "Obser_treat";
	public static final String NAME_PSN_SIGN= "Name_psn_sign";
	public static final String ID_PSN_SIGN= "Id_psn_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_FUNICLE= "Name_funicle";
	public static final String NAME_SKIN= "Name_skin";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nur_rec() {
		return ((String) getAttrVal("Id_nur_rec"));
	}	
	public void setId_nur_rec(String Id_nur_rec) {
		setAttrVal("Id_nur_rec", Id_nur_rec);
	}
	public String getId_baby() {
		return ((String) getAttrVal("Id_baby"));
	}	
	public void setId_baby(String Id_baby) {
		setAttrVal("Id_baby", Id_baby);
	}
	public FDateTime getDt_rec() {
		return ((FDateTime) getAttrVal("Dt_rec"));
	}	
	public void setDt_rec(FDateTime Dt_rec) {
		setAttrVal("Dt_rec", Dt_rec);
	}
	public Integer getSuck_time() {
		return ((Integer) getAttrVal("Suck_time"));
	}	
	public void setSuck_time(Integer Suck_time) {
		setAttrVal("Suck_time", Suck_time);
	}
	public Integer getFeces() {
		return ((Integer) getAttrVal("Feces"));
	}	
	public void setFeces(Integer Feces) {
		setAttrVal("Feces", Feces);
	}
	public Integer getPee() {
		return ((Integer) getAttrVal("Pee"));
	}	
	public void setPee(Integer Pee) {
		setAttrVal("Pee", Pee);
	}
	public String getId_funicle() {
		return ((String) getAttrVal("Id_funicle"));
	}	
	public void setId_funicle(String Id_funicle) {
		setAttrVal("Id_funicle", Id_funicle);
	}
	public String getSd_funicle() {
		return ((String) getAttrVal("Sd_funicle"));
	}	
	public void setSd_funicle(String Sd_funicle) {
		setAttrVal("Sd_funicle", Sd_funicle);
	}
	public String getId_skin() {
		return ((String) getAttrVal("Id_skin"));
	}	
	public void setId_skin(String Id_skin) {
		setAttrVal("Id_skin", Id_skin);
	}
	public String getSd_skin() {
		return ((String) getAttrVal("Sd_skin"));
	}	
	public void setSd_skin(String Sd_skin) {
		setAttrVal("Sd_skin", Sd_skin);
	}
	public String getHead() {
		return ((String) getAttrVal("Head"));
	}	
	public void setHead(String Head) {
		setAttrVal("Head", Head);
	}
	public Integer getEu_vomit() {
		return ((Integer) getAttrVal("Eu_vomit"));
	}	
	public void setEu_vomit(Integer Eu_vomit) {
		setAttrVal("Eu_vomit", Eu_vomit);
	}
	public String getObser_treat() {
		return ((String) getAttrVal("Obser_treat"));
	}	
	public void setObser_treat(String Obser_treat) {
		setAttrVal("Obser_treat", Obser_treat);
	}
	public String getName_psn_sign() {
		return ((String) getAttrVal("Name_psn_sign"));
	}	
	public void setName_psn_sign(String Name_psn_sign) {
		setAttrVal("Name_psn_sign", Name_psn_sign);
	}
	public String getId_psn_sign() {
		return ((String) getAttrVal("Id_psn_sign"));
	}	
	public void setId_psn_sign(String Id_psn_sign) {
		setAttrVal("Id_psn_sign", Id_psn_sign);
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
	public String getName_funicle() {
		return ((String) getAttrVal("Name_funicle"));
	}	
	public void setName_funicle(String Name_funicle) {
		setAttrVal("Name_funicle", Name_funicle);
	}
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
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
		return "Id_nur_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_BABYNURREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BabyNurRecDODesc.class);
	}
	
}