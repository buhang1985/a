package iih.ci.mr.nu.newborn24hobsrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.newborn24hobsrec.d.desc.New24ObsDODesc;
import java.math.BigDecimal;

/**
 * 观察记录单内容 DO数据 
 * 
 */
public class New24ObsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OBSREC= "Id_obsrec";
	public static final String ID_PATINFO= "Id_patinfo";
	public static final String NO_REC= "No_rec";
	public static final String T_NEWBORN= "T_newborn";
	public static final String ID_FACE_COLOR= "Id_face_color";
	public static final String SD_FACE_COLOR= "Sd_face_color";
	public static final String ID_CRY_SOUND= "Id_cry_sound";
	public static final String SD_CRY_SOUND= "Sd_cry_sound";
	public static final String ID_BREATH= "Id_breath";
	public static final String SD_BREATH= "Sd_breath";
	public static final String EN_OUTPUT= "En_output";
	public static final String BABY_SUCK= "Baby_suck";
	public static final String ID_SHIT_STATUS= "Id_shit_status";
	public static final String SD_SHIT_STATUS= "Sd_shit_status";
	public static final String EN_SHIT_VOLUME= "En_shit_volume";
	public static final String URINE_OUT= "Urine_out";
	public static final String NUM_VOMIT= "Num_vomit";
	public static final String ID_VOMIT_STATUS= "Id_vomit_status";
	public static final String SD_VOMIT_STATUS= "Sd_vomit_status";
	public static final String EN_VOMIT_VOLUME= "En_vomit_volume";
	public static final String OXYGEN_IN= "Oxygen_in";
	public static final String DES_HANDLE= "Des_handle";
	public static final String ID_SIG= "Id_sig";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_FACE_COLOR= "Name_face_color";
	public static final String NAME_CRY_SOUND= "Name_cry_sound";
	public static final String NAME_BREATH= "Name_breath";
	public static final String NAME_SHIT_STATUS= "Name_shit_status";
	public static final String NAME_VOMIT_STATUS= "Name_vomit_status";
	public static final String NAME_SIG= "Name_sig";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_obsrec() {
		return ((String) getAttrVal("Id_obsrec"));
	}	
	public void setId_obsrec(String Id_obsrec) {
		setAttrVal("Id_obsrec", Id_obsrec);
	}
	public String getId_patinfo() {
		return ((String) getAttrVal("Id_patinfo"));
	}	
	public void setId_patinfo(String Id_patinfo) {
		setAttrVal("Id_patinfo", Id_patinfo);
	}
	public Integer getNo_rec() {
		return ((Integer) getAttrVal("No_rec"));
	}	
	public void setNo_rec(Integer No_rec) {
		setAttrVal("No_rec", No_rec);
	}
	public FTime getT_newborn() {
		return ((FTime) getAttrVal("T_newborn"));
	}	
	public void setT_newborn(FTime T_newborn) {
		setAttrVal("T_newborn", T_newborn);
	}
	public String getId_face_color() {
		return ((String) getAttrVal("Id_face_color"));
	}	
	public void setId_face_color(String Id_face_color) {
		setAttrVal("Id_face_color", Id_face_color);
	}
	public String getSd_face_color() {
		return ((String) getAttrVal("Sd_face_color"));
	}	
	public void setSd_face_color(String Sd_face_color) {
		setAttrVal("Sd_face_color", Sd_face_color);
	}
	public String getId_cry_sound() {
		return ((String) getAttrVal("Id_cry_sound"));
	}	
	public void setId_cry_sound(String Id_cry_sound) {
		setAttrVal("Id_cry_sound", Id_cry_sound);
	}
	public String getSd_cry_sound() {
		return ((String) getAttrVal("Sd_cry_sound"));
	}	
	public void setSd_cry_sound(String Sd_cry_sound) {
		setAttrVal("Sd_cry_sound", Sd_cry_sound);
	}
	public String getId_breath() {
		return ((String) getAttrVal("Id_breath"));
	}	
	public void setId_breath(String Id_breath) {
		setAttrVal("Id_breath", Id_breath);
	}
	public String getSd_breath() {
		return ((String) getAttrVal("Sd_breath"));
	}	
	public void setSd_breath(String Sd_breath) {
		setAttrVal("Sd_breath", Sd_breath);
	}
	public Integer getEn_output() {
		return ((Integer) getAttrVal("En_output"));
	}	
	public void setEn_output(Integer En_output) {
		setAttrVal("En_output", En_output);
	}
	public String getBaby_suck() {
		return ((String) getAttrVal("Baby_suck"));
	}	
	public void setBaby_suck(String Baby_suck) {
		setAttrVal("Baby_suck", Baby_suck);
	}
	public String getId_shit_status() {
		return ((String) getAttrVal("Id_shit_status"));
	}	
	public void setId_shit_status(String Id_shit_status) {
		setAttrVal("Id_shit_status", Id_shit_status);
	}
	public String getSd_shit_status() {
		return ((String) getAttrVal("Sd_shit_status"));
	}	
	public void setSd_shit_status(String Sd_shit_status) {
		setAttrVal("Sd_shit_status", Sd_shit_status);
	}
	public Integer getEn_shit_volume() {
		return ((Integer) getAttrVal("En_shit_volume"));
	}	
	public void setEn_shit_volume(Integer En_shit_volume) {
		setAttrVal("En_shit_volume", En_shit_volume);
	}
	public String getUrine_out() {
		return ((String) getAttrVal("Urine_out"));
	}	
	public void setUrine_out(String Urine_out) {
		setAttrVal("Urine_out", Urine_out);
	}
	public Integer getNum_vomit() {
		return ((Integer) getAttrVal("Num_vomit"));
	}	
	public void setNum_vomit(Integer Num_vomit) {
		setAttrVal("Num_vomit", Num_vomit);
	}
	public String getId_vomit_status() {
		return ((String) getAttrVal("Id_vomit_status"));
	}	
	public void setId_vomit_status(String Id_vomit_status) {
		setAttrVal("Id_vomit_status", Id_vomit_status);
	}
	public String getSd_vomit_status() {
		return ((String) getAttrVal("Sd_vomit_status"));
	}	
	public void setSd_vomit_status(String Sd_vomit_status) {
		setAttrVal("Sd_vomit_status", Sd_vomit_status);
	}
	public Integer getEn_vomit_volume() {
		return ((Integer) getAttrVal("En_vomit_volume"));
	}	
	public void setEn_vomit_volume(Integer En_vomit_volume) {
		setAttrVal("En_vomit_volume", En_vomit_volume);
	}
	public String getOxygen_in() {
		return ((String) getAttrVal("Oxygen_in"));
	}	
	public void setOxygen_in(String Oxygen_in) {
		setAttrVal("Oxygen_in", Oxygen_in);
	}
	public String getDes_handle() {
		return ((String) getAttrVal("Des_handle"));
	}	
	public void setDes_handle(String Des_handle) {
		setAttrVal("Des_handle", Des_handle);
	}
	public String getId_sig() {
		return ((String) getAttrVal("Id_sig"));
	}	
	public void setId_sig(String Id_sig) {
		setAttrVal("Id_sig", Id_sig);
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
	public String getName_face_color() {
		return ((String) getAttrVal("Name_face_color"));
	}	
	public void setName_face_color(String Name_face_color) {
		setAttrVal("Name_face_color", Name_face_color);
	}
	public String getName_cry_sound() {
		return ((String) getAttrVal("Name_cry_sound"));
	}	
	public void setName_cry_sound(String Name_cry_sound) {
		setAttrVal("Name_cry_sound", Name_cry_sound);
	}
	public String getName_breath() {
		return ((String) getAttrVal("Name_breath"));
	}	
	public void setName_breath(String Name_breath) {
		setAttrVal("Name_breath", Name_breath);
	}
	public String getName_shit_status() {
		return ((String) getAttrVal("Name_shit_status"));
	}	
	public void setName_shit_status(String Name_shit_status) {
		setAttrVal("Name_shit_status", Name_shit_status);
	}
	public String getName_vomit_status() {
		return ((String) getAttrVal("Name_vomit_status"));
	}	
	public void setName_vomit_status(String Name_vomit_status) {
		setAttrVal("Name_vomit_status", Name_vomit_status);
	}
	public String getName_sig() {
		return ((String) getAttrVal("Name_sig"));
	}	
	public void setName_sig(String Name_sig) {
		setAttrVal("Name_sig", Name_sig);
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
		return "Id_obsrec";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_NEW24OBS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(New24ObsDODesc.class);
	}
	
}