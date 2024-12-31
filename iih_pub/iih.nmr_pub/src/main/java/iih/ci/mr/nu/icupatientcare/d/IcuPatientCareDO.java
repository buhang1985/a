package iih.ci.mr.nu.icupatientcare.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.icupatientcare.d.desc.IcuPatientCareDODesc;
import java.math.BigDecimal;

/**
 * ICU患者护理记录 DO数据 
 * 
 */
public class IcuPatientCareDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ICUPATIENTCARE= "Id_icupatientcare";
	public static final String ID_PATINFOR= "Id_patinfor";
	public static final String PATTERN= "Pattern";
	public static final String KPOSITION_SITUATION= "Kposition_situation";
	public static final String ILL_OBSERVEANALYSE= "Ill_observeanalyse";
	public static final String ASS_GRADE= "Ass_grade";
	public static final String LEFTPUPSIZE= "Leftpupsize";
	public static final String RIGHTPUPSIZE= "Rightpupsize";
	public static final String CVP= "Cvp";
	public static final String DAMP_AMOUNT= "Damp_amount";
	public static final String FREQUENCY_TIMES= "Frequency_times";
	public static final String PEEP= "Peep";
	public static final String TAKEIN_AMOUNT= "Takein_amount";
	public static final String PASSWATER_AMOUNT= "Passwater_amount";
	public static final String PASWATEROTH_AMOUNT= "Paswateroth_amount";
	public static final String DRAIN_TUBE_GRADUATE= "Drain_tube_graduate";
	public static final String VEIN_TUBE_GRADUATE= "Vein_tube_graduate";
	public static final String INTUBATE_DEPTH= "Intubate_depth";
	public static final String BREATH= "Breath";
	public static final String SYS_PRE= "Sys_pre";
	public static final String DIA_PRE= "Dia_pre";
	public static final String OXYGEN_POTENCY= "Oxygen_potency";
	public static final String OXYGEN_TAKE_POTENCY= "Oxygen_take_potency";
	public static final String TEM= "Tem";
	public static final String HEARTRATE= "Heartrate";
	public static final String SPO2= "Spo2";
	public static final String IS_PRESS= "Is_press";
	public static final String IS_UNOBSTRUCTE= "Is_unobstructe";
	public static final String IS_REPLACE= "Is_replace";
	public static final String IS_VEINCARE= "Is_veincare";
	public static final String VEIN_FLUIDVOLUM= "Vein_fluidvolum";
	public static final String VTUBE_ISUNOBSTRUCTE= "Vtube_isunobstructe";
	public static final String IS_CHANGEDRUG= "Is_changedrug";
	public static final String ATOMIZE= "Atomize";
	public static final String SPUTUM= "Sputum";
	public static final String IS_ORALCARE= "Is_oralcare";
	public static final String IS_PERINEUMCARE= "Is_perineumcare";
	public static final String IS_BEDBATH= "Is_bedbath";
	public static final String IS_BACKEXPECTORATE= "Is_backexpectorate";
	public static final String IS_VIBRATEXPECTORATE= "Is_vibratexpectorate";
	public static final String IS_SKINCARE= "Is_skincare";
	public static final String MDATE= "Mdate";
	public static final String FILL_TIME= "Fill_time";
	public static final String MTIME= "Mtime";
	public static final String IS_BREATHCLEAR= "Is_breathclear";
	public static final String IS_SKINOK= "Is_skinok";
	public static final String SPUTUM_AMOUNT= "Sputum_amount";
	public static final String ID_SENSE= "Id_sense";
	public static final String SD_SENSE= "Sd_sense";
	public static final String ID_LEFTPUPREFLECT= "Id_leftpupreflect";
	public static final String SD_LEFTPUPREFLECT= "Sd_leftpupreflect";
	public static final String ID_RIGHTPUPREFLECT= "Id_rightpupreflect";
	public static final String SD_RIGHTPUPREFLECT= "Sd_rightpupreflect";
	public static final String ID_ARTI_AIRWAY_MODE= "Id_arti_airway_mode";
	public static final String SD_ARTI_AIRWAY_MODE= "Sd_arti_airway_mode";
	public static final String ID_LEFT_BREATH_SOUND= "Id_left_breath_sound";
	public static final String SD_LEFT_BREATH_SOUND= "Sd_left_breath_sound";
	public static final String ID_RIGHT_BREATH_SOUND= "Id_right_breath_sound";
	public static final String SD_RIGHT_BREATH_SOUND= "Sd_right_breath_sound";
	public static final String ID_OXYGEN_TAKEWAY= "Id_oxygen_takeway";
	public static final String SD_OXYGEN_TAKEWAY= "Sd_oxygen_takeway";
	public static final String ID_DRAIN_TUBE_NAME= "Id_drain_tube_name";
	public static final String SD_DRAIN_TUBE_NAME= "Sd_drain_tube_name";
	public static final String ID_DRAINAGE_COLOR= "Id_drainage_color";
	public static final String SD_DRAINAGE_COLOR= "Sd_drainage_color";
	public static final String ID_VEIN_TUBE_NAME= "Id_vein_tube_name";
	public static final String SD_VEIN_TUBE_NAME= "Sd_vein_tube_name";
	public static final String ID_SPUTUM_COLOR= "Id_sputum_color";
	public static final String SD_SPUTUM_COLOR= "Sd_sputum_color";
	public static final String ID_KEEP_POSITION= "Id_keep_position";
	public static final String SD_KEEP_POSITION= "Sd_keep_position";
	public static final String ID_SKIN_CARE= "Id_skin_care";
	public static final String SD_SKIN_CARE= "Sd_skin_care";
	public static final String ID_OTHER_CARE= "Id_other_care";
	public static final String SD_OTHER_CARE= "Sd_other_care";
	public static final String ID_BODY_POSITION= "Id_body_position";
	public static final String SD_BODY_POSITION= "Sd_body_position";
	public static final String FILL_PEOPLE= "Fill_people";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SENSE= "Name_sense";
	public static final String NAME_LEFTPUPREFLECT= "Name_leftpupreflect";
	public static final String NAME_RIGHTPUPREFLECT= "Name_rightpupreflect";
	public static final String NAME_ARTIAIRMODE= "Name_artiairmode";
	public static final String NAME_LEFTBTHSOUND= "Name_leftbthsound";
	public static final String NAME_RIGHTBTHSOUND= "Name_rightbthsound";
	public static final String NAME_OXYGENTAKEW= "Name_oxygentakew";
	public static final String NAME_DRAIN_TUBE= "Name_drain_tube";
	public static final String NAME_DRAINAGECOLOR= "Name_drainagecolor";
	public static final String NAME_VEINTUBE= "Name_veintube";
	public static final String NAME_SPUTUMCOLOR= "Name_sputumcolor";
	public static final String NAME_KEEPPOSITION= "Name_keepposition";
	public static final String NAME_SKINCARE= "Name_skincare";
	public static final String NAME_OTHERCARE= "Name_othercare";
	public static final String NAME_BODY_POSITION= "Name_body_position";
	public static final String NAME_PEOPLE= "Name_people";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_icupatientcare() {
		return ((String) getAttrVal("Id_icupatientcare"));
	}	
	public void setId_icupatientcare(String Id_icupatientcare) {
		setAttrVal("Id_icupatientcare", Id_icupatientcare);
	}
	public String getId_patinfor() {
		return ((String) getAttrVal("Id_patinfor"));
	}	
	public void setId_patinfor(String Id_patinfor) {
		setAttrVal("Id_patinfor", Id_patinfor);
	}
	public String getPattern() {
		return ((String) getAttrVal("Pattern"));
	}	
	public void setPattern(String Pattern) {
		setAttrVal("Pattern", Pattern);
	}
	public String getKposition_situation() {
		return ((String) getAttrVal("Kposition_situation"));
	}	
	public void setKposition_situation(String Kposition_situation) {
		setAttrVal("Kposition_situation", Kposition_situation);
	}
	public String getIll_observeanalyse() {
		return ((String) getAttrVal("Ill_observeanalyse"));
	}	
	public void setIll_observeanalyse(String Ill_observeanalyse) {
		setAttrVal("Ill_observeanalyse", Ill_observeanalyse);
	}
	public Integer getAss_grade() {
		return ((Integer) getAttrVal("Ass_grade"));
	}	
	public void setAss_grade(Integer Ass_grade) {
		setAttrVal("Ass_grade", Ass_grade);
	}
	public Integer getLeftpupsize() {
		return ((Integer) getAttrVal("Leftpupsize"));
	}	
	public void setLeftpupsize(Integer Leftpupsize) {
		setAttrVal("Leftpupsize", Leftpupsize);
	}
	public Integer getRightpupsize() {
		return ((Integer) getAttrVal("Rightpupsize"));
	}	
	public void setRightpupsize(Integer Rightpupsize) {
		setAttrVal("Rightpupsize", Rightpupsize);
	}
	public Integer getCvp() {
		return ((Integer) getAttrVal("Cvp"));
	}	
	public void setCvp(Integer Cvp) {
		setAttrVal("Cvp", Cvp);
	}
	public Integer getDamp_amount() {
		return ((Integer) getAttrVal("Damp_amount"));
	}	
	public void setDamp_amount(Integer Damp_amount) {
		setAttrVal("Damp_amount", Damp_amount);
	}
	public Integer getFrequency_times() {
		return ((Integer) getAttrVal("Frequency_times"));
	}	
	public void setFrequency_times(Integer Frequency_times) {
		setAttrVal("Frequency_times", Frequency_times);
	}
	public Integer getPeep() {
		return ((Integer) getAttrVal("Peep"));
	}	
	public void setPeep(Integer Peep) {
		setAttrVal("Peep", Peep);
	}
	public Integer getTakein_amount() {
		return ((Integer) getAttrVal("Takein_amount"));
	}	
	public void setTakein_amount(Integer Takein_amount) {
		setAttrVal("Takein_amount", Takein_amount);
	}
	public Integer getPasswater_amount() {
		return ((Integer) getAttrVal("Passwater_amount"));
	}	
	public void setPasswater_amount(Integer Passwater_amount) {
		setAttrVal("Passwater_amount", Passwater_amount);
	}
	public Integer getPaswateroth_amount() {
		return ((Integer) getAttrVal("Paswateroth_amount"));
	}	
	public void setPaswateroth_amount(Integer Paswateroth_amount) {
		setAttrVal("Paswateroth_amount", Paswateroth_amount);
	}
	public Integer getDrain_tube_graduate() {
		return ((Integer) getAttrVal("Drain_tube_graduate"));
	}	
	public void setDrain_tube_graduate(Integer Drain_tube_graduate) {
		setAttrVal("Drain_tube_graduate", Drain_tube_graduate);
	}
	public Integer getVein_tube_graduate() {
		return ((Integer) getAttrVal("Vein_tube_graduate"));
	}	
	public void setVein_tube_graduate(Integer Vein_tube_graduate) {
		setAttrVal("Vein_tube_graduate", Vein_tube_graduate);
	}
	public Integer getIntubate_depth() {
		return ((Integer) getAttrVal("Intubate_depth"));
	}	
	public void setIntubate_depth(Integer Intubate_depth) {
		setAttrVal("Intubate_depth", Intubate_depth);
	}
	public Integer getBreath() {
		return ((Integer) getAttrVal("Breath"));
	}	
	public void setBreath(Integer Breath) {
		setAttrVal("Breath", Breath);
	}
	public Integer getSys_pre() {
		return ((Integer) getAttrVal("Sys_pre"));
	}	
	public void setSys_pre(Integer Sys_pre) {
		setAttrVal("Sys_pre", Sys_pre);
	}
	public Integer getDia_pre() {
		return ((Integer) getAttrVal("Dia_pre"));
	}	
	public void setDia_pre(Integer Dia_pre) {
		setAttrVal("Dia_pre", Dia_pre);
	}
	public FDouble getOxygen_potency() {
		return ((FDouble) getAttrVal("Oxygen_potency"));
	}	
	public void setOxygen_potency(FDouble Oxygen_potency) {
		setAttrVal("Oxygen_potency", Oxygen_potency);
	}
	public FDouble getOxygen_take_potency() {
		return ((FDouble) getAttrVal("Oxygen_take_potency"));
	}	
	public void setOxygen_take_potency(FDouble Oxygen_take_potency) {
		setAttrVal("Oxygen_take_potency", Oxygen_take_potency);
	}
	public FDouble getTem() {
		return ((FDouble) getAttrVal("Tem"));
	}	
	public void setTem(FDouble Tem) {
		setAttrVal("Tem", Tem);
	}
	public Integer getHeartrate() {
		return ((Integer) getAttrVal("Heartrate"));
	}	
	public void setHeartrate(Integer Heartrate) {
		setAttrVal("Heartrate", Heartrate);
	}
	public FDouble getSpo2() {
		return ((FDouble) getAttrVal("Spo2"));
	}	
	public void setSpo2(FDouble Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	public FBoolean getIs_press() {
		return ((FBoolean) getAttrVal("Is_press"));
	}	
	public void setIs_press(FBoolean Is_press) {
		setAttrVal("Is_press", Is_press);
	}
	public FBoolean getIs_unobstructe() {
		return ((FBoolean) getAttrVal("Is_unobstructe"));
	}	
	public void setIs_unobstructe(FBoolean Is_unobstructe) {
		setAttrVal("Is_unobstructe", Is_unobstructe);
	}
	public FBoolean getIs_replace() {
		return ((FBoolean) getAttrVal("Is_replace"));
	}	
	public void setIs_replace(FBoolean Is_replace) {
		setAttrVal("Is_replace", Is_replace);
	}
	public FBoolean getIs_veincare() {
		return ((FBoolean) getAttrVal("Is_veincare"));
	}	
	public void setIs_veincare(FBoolean Is_veincare) {
		setAttrVal("Is_veincare", Is_veincare);
	}
	public Integer getVein_fluidvolum() {
		return ((Integer) getAttrVal("Vein_fluidvolum"));
	}	
	public void setVein_fluidvolum(Integer Vein_fluidvolum) {
		setAttrVal("Vein_fluidvolum", Vein_fluidvolum);
	}
	public FBoolean getVtube_isunobstructe() {
		return ((FBoolean) getAttrVal("Vtube_isunobstructe"));
	}	
	public void setVtube_isunobstructe(FBoolean Vtube_isunobstructe) {
		setAttrVal("Vtube_isunobstructe", Vtube_isunobstructe);
	}
	public FBoolean getIs_changedrug() {
		return ((FBoolean) getAttrVal("Is_changedrug"));
	}	
	public void setIs_changedrug(FBoolean Is_changedrug) {
		setAttrVal("Is_changedrug", Is_changedrug);
	}
	public FBoolean getAtomize() {
		return ((FBoolean) getAttrVal("Atomize"));
	}	
	public void setAtomize(FBoolean Atomize) {
		setAttrVal("Atomize", Atomize);
	}
	public FBoolean getSputum() {
		return ((FBoolean) getAttrVal("Sputum"));
	}	
	public void setSputum(FBoolean Sputum) {
		setAttrVal("Sputum", Sputum);
	}
	public FBoolean getIs_oralcare() {
		return ((FBoolean) getAttrVal("Is_oralcare"));
	}	
	public void setIs_oralcare(FBoolean Is_oralcare) {
		setAttrVal("Is_oralcare", Is_oralcare);
	}
	public FBoolean getIs_perineumcare() {
		return ((FBoolean) getAttrVal("Is_perineumcare"));
	}	
	public void setIs_perineumcare(FBoolean Is_perineumcare) {
		setAttrVal("Is_perineumcare", Is_perineumcare);
	}
	public FBoolean getIs_bedbath() {
		return ((FBoolean) getAttrVal("Is_bedbath"));
	}	
	public void setIs_bedbath(FBoolean Is_bedbath) {
		setAttrVal("Is_bedbath", Is_bedbath);
	}
	public FBoolean getIs_backexpectorate() {
		return ((FBoolean) getAttrVal("Is_backexpectorate"));
	}	
	public void setIs_backexpectorate(FBoolean Is_backexpectorate) {
		setAttrVal("Is_backexpectorate", Is_backexpectorate);
	}
	public FBoolean getIs_vibratexpectorate() {
		return ((FBoolean) getAttrVal("Is_vibratexpectorate"));
	}	
	public void setIs_vibratexpectorate(FBoolean Is_vibratexpectorate) {
		setAttrVal("Is_vibratexpectorate", Is_vibratexpectorate);
	}
	public FBoolean getIs_skincare() {
		return ((FBoolean) getAttrVal("Is_skincare"));
	}	
	public void setIs_skincare(FBoolean Is_skincare) {
		setAttrVal("Is_skincare", Is_skincare);
	}
	public FDate getMdate() {
		return ((FDate) getAttrVal("Mdate"));
	}	
	public void setMdate(FDate Mdate) {
		setAttrVal("Mdate", Mdate);
	}
	public FDateTime getFill_time() {
		return ((FDateTime) getAttrVal("Fill_time"));
	}	
	public void setFill_time(FDateTime Fill_time) {
		setAttrVal("Fill_time", Fill_time);
	}
	public FTime getMtime() {
		return ((FTime) getAttrVal("Mtime"));
	}	
	public void setMtime(FTime Mtime) {
		setAttrVal("Mtime", Mtime);
	}
	public FBoolean getIs_breathclear() {
		return ((FBoolean) getAttrVal("Is_breathclear"));
	}	
	public void setIs_breathclear(FBoolean Is_breathclear) {
		setAttrVal("Is_breathclear", Is_breathclear);
	}
	public FBoolean getIs_skinok() {
		return ((FBoolean) getAttrVal("Is_skinok"));
	}	
	public void setIs_skinok(FBoolean Is_skinok) {
		setAttrVal("Is_skinok", Is_skinok);
	}
	public Integer getSputum_amount() {
		return ((Integer) getAttrVal("Sputum_amount"));
	}	
	public void setSputum_amount(Integer Sputum_amount) {
		setAttrVal("Sputum_amount", Sputum_amount);
	}
	public String getId_sense() {
		return ((String) getAttrVal("Id_sense"));
	}	
	public void setId_sense(String Id_sense) {
		setAttrVal("Id_sense", Id_sense);
	}
	public String getSd_sense() {
		return ((String) getAttrVal("Sd_sense"));
	}	
	public void setSd_sense(String Sd_sense) {
		setAttrVal("Sd_sense", Sd_sense);
	}
	public String getId_leftpupreflect() {
		return ((String) getAttrVal("Id_leftpupreflect"));
	}	
	public void setId_leftpupreflect(String Id_leftpupreflect) {
		setAttrVal("Id_leftpupreflect", Id_leftpupreflect);
	}
	public String getSd_leftpupreflect() {
		return ((String) getAttrVal("Sd_leftpupreflect"));
	}	
	public void setSd_leftpupreflect(String Sd_leftpupreflect) {
		setAttrVal("Sd_leftpupreflect", Sd_leftpupreflect);
	}
	public String getId_rightpupreflect() {
		return ((String) getAttrVal("Id_rightpupreflect"));
	}	
	public void setId_rightpupreflect(String Id_rightpupreflect) {
		setAttrVal("Id_rightpupreflect", Id_rightpupreflect);
	}
	public String getSd_rightpupreflect() {
		return ((String) getAttrVal("Sd_rightpupreflect"));
	}	
	public void setSd_rightpupreflect(String Sd_rightpupreflect) {
		setAttrVal("Sd_rightpupreflect", Sd_rightpupreflect);
	}
	public String getId_arti_airway_mode() {
		return ((String) getAttrVal("Id_arti_airway_mode"));
	}	
	public void setId_arti_airway_mode(String Id_arti_airway_mode) {
		setAttrVal("Id_arti_airway_mode", Id_arti_airway_mode);
	}
	public String getSd_arti_airway_mode() {
		return ((String) getAttrVal("Sd_arti_airway_mode"));
	}	
	public void setSd_arti_airway_mode(String Sd_arti_airway_mode) {
		setAttrVal("Sd_arti_airway_mode", Sd_arti_airway_mode);
	}
	public String getId_left_breath_sound() {
		return ((String) getAttrVal("Id_left_breath_sound"));
	}	
	public void setId_left_breath_sound(String Id_left_breath_sound) {
		setAttrVal("Id_left_breath_sound", Id_left_breath_sound);
	}
	public String getSd_left_breath_sound() {
		return ((String) getAttrVal("Sd_left_breath_sound"));
	}	
	public void setSd_left_breath_sound(String Sd_left_breath_sound) {
		setAttrVal("Sd_left_breath_sound", Sd_left_breath_sound);
	}
	public String getId_right_breath_sound() {
		return ((String) getAttrVal("Id_right_breath_sound"));
	}	
	public void setId_right_breath_sound(String Id_right_breath_sound) {
		setAttrVal("Id_right_breath_sound", Id_right_breath_sound);
	}
	public String getSd_right_breath_sound() {
		return ((String) getAttrVal("Sd_right_breath_sound"));
	}	
	public void setSd_right_breath_sound(String Sd_right_breath_sound) {
		setAttrVal("Sd_right_breath_sound", Sd_right_breath_sound);
	}
	public String getId_oxygen_takeway() {
		return ((String) getAttrVal("Id_oxygen_takeway"));
	}	
	public void setId_oxygen_takeway(String Id_oxygen_takeway) {
		setAttrVal("Id_oxygen_takeway", Id_oxygen_takeway);
	}
	public String getSd_oxygen_takeway() {
		return ((String) getAttrVal("Sd_oxygen_takeway"));
	}	
	public void setSd_oxygen_takeway(String Sd_oxygen_takeway) {
		setAttrVal("Sd_oxygen_takeway", Sd_oxygen_takeway);
	}
	public String getId_drain_tube_name() {
		return ((String) getAttrVal("Id_drain_tube_name"));
	}	
	public void setId_drain_tube_name(String Id_drain_tube_name) {
		setAttrVal("Id_drain_tube_name", Id_drain_tube_name);
	}
	public String getSd_drain_tube_name() {
		return ((String) getAttrVal("Sd_drain_tube_name"));
	}	
	public void setSd_drain_tube_name(String Sd_drain_tube_name) {
		setAttrVal("Sd_drain_tube_name", Sd_drain_tube_name);
	}
	public String getId_drainage_color() {
		return ((String) getAttrVal("Id_drainage_color"));
	}	
	public void setId_drainage_color(String Id_drainage_color) {
		setAttrVal("Id_drainage_color", Id_drainage_color);
	}
	public String getSd_drainage_color() {
		return ((String) getAttrVal("Sd_drainage_color"));
	}	
	public void setSd_drainage_color(String Sd_drainage_color) {
		setAttrVal("Sd_drainage_color", Sd_drainage_color);
	}
	public String getId_vein_tube_name() {
		return ((String) getAttrVal("Id_vein_tube_name"));
	}	
	public void setId_vein_tube_name(String Id_vein_tube_name) {
		setAttrVal("Id_vein_tube_name", Id_vein_tube_name);
	}
	public String getSd_vein_tube_name() {
		return ((String) getAttrVal("Sd_vein_tube_name"));
	}	
	public void setSd_vein_tube_name(String Sd_vein_tube_name) {
		setAttrVal("Sd_vein_tube_name", Sd_vein_tube_name);
	}
	public String getId_sputum_color() {
		return ((String) getAttrVal("Id_sputum_color"));
	}	
	public void setId_sputum_color(String Id_sputum_color) {
		setAttrVal("Id_sputum_color", Id_sputum_color);
	}
	public String getSd_sputum_color() {
		return ((String) getAttrVal("Sd_sputum_color"));
	}	
	public void setSd_sputum_color(String Sd_sputum_color) {
		setAttrVal("Sd_sputum_color", Sd_sputum_color);
	}
	public String getId_keep_position() {
		return ((String) getAttrVal("Id_keep_position"));
	}	
	public void setId_keep_position(String Id_keep_position) {
		setAttrVal("Id_keep_position", Id_keep_position);
	}
	public String getSd_keep_position() {
		return ((String) getAttrVal("Sd_keep_position"));
	}	
	public void setSd_keep_position(String Sd_keep_position) {
		setAttrVal("Sd_keep_position", Sd_keep_position);
	}
	public String getId_skin_care() {
		return ((String) getAttrVal("Id_skin_care"));
	}	
	public void setId_skin_care(String Id_skin_care) {
		setAttrVal("Id_skin_care", Id_skin_care);
	}
	public String getSd_skin_care() {
		return ((String) getAttrVal("Sd_skin_care"));
	}	
	public void setSd_skin_care(String Sd_skin_care) {
		setAttrVal("Sd_skin_care", Sd_skin_care);
	}
	public String getId_other_care() {
		return ((String) getAttrVal("Id_other_care"));
	}	
	public void setId_other_care(String Id_other_care) {
		setAttrVal("Id_other_care", Id_other_care);
	}
	public String getSd_other_care() {
		return ((String) getAttrVal("Sd_other_care"));
	}	
	public void setSd_other_care(String Sd_other_care) {
		setAttrVal("Sd_other_care", Sd_other_care);
	}
	public String getId_body_position() {
		return ((String) getAttrVal("Id_body_position"));
	}	
	public void setId_body_position(String Id_body_position) {
		setAttrVal("Id_body_position", Id_body_position);
	}
	public String getSd_body_position() {
		return ((String) getAttrVal("Sd_body_position"));
	}	
	public void setSd_body_position(String Sd_body_position) {
		setAttrVal("Sd_body_position", Sd_body_position);
	}
	public String getFill_people() {
		return ((String) getAttrVal("Fill_people"));
	}	
	public void setFill_people(String Fill_people) {
		setAttrVal("Fill_people", Fill_people);
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
	public String getName_sense() {
		return ((String) getAttrVal("Name_sense"));
	}	
	public void setName_sense(String Name_sense) {
		setAttrVal("Name_sense", Name_sense);
	}
	public String getName_leftpupreflect() {
		return ((String) getAttrVal("Name_leftpupreflect"));
	}	
	public void setName_leftpupreflect(String Name_leftpupreflect) {
		setAttrVal("Name_leftpupreflect", Name_leftpupreflect);
	}
	public String getName_rightpupreflect() {
		return ((String) getAttrVal("Name_rightpupreflect"));
	}	
	public void setName_rightpupreflect(String Name_rightpupreflect) {
		setAttrVal("Name_rightpupreflect", Name_rightpupreflect);
	}
	public String getName_artiairmode() {
		return ((String) getAttrVal("Name_artiairmode"));
	}	
	public void setName_artiairmode(String Name_artiairmode) {
		setAttrVal("Name_artiairmode", Name_artiairmode);
	}
	public String getName_leftbthsound() {
		return ((String) getAttrVal("Name_leftbthsound"));
	}	
	public void setName_leftbthsound(String Name_leftbthsound) {
		setAttrVal("Name_leftbthsound", Name_leftbthsound);
	}
	public String getName_rightbthsound() {
		return ((String) getAttrVal("Name_rightbthsound"));
	}	
	public void setName_rightbthsound(String Name_rightbthsound) {
		setAttrVal("Name_rightbthsound", Name_rightbthsound);
	}
	public String getName_oxygentakew() {
		return ((String) getAttrVal("Name_oxygentakew"));
	}	
	public void setName_oxygentakew(String Name_oxygentakew) {
		setAttrVal("Name_oxygentakew", Name_oxygentakew);
	}
	public String getName_drain_tube() {
		return ((String) getAttrVal("Name_drain_tube"));
	}	
	public void setName_drain_tube(String Name_drain_tube) {
		setAttrVal("Name_drain_tube", Name_drain_tube);
	}
	public String getName_drainagecolor() {
		return ((String) getAttrVal("Name_drainagecolor"));
	}	
	public void setName_drainagecolor(String Name_drainagecolor) {
		setAttrVal("Name_drainagecolor", Name_drainagecolor);
	}
	public String getName_veintube() {
		return ((String) getAttrVal("Name_veintube"));
	}	
	public void setName_veintube(String Name_veintube) {
		setAttrVal("Name_veintube", Name_veintube);
	}
	public String getName_sputumcolor() {
		return ((String) getAttrVal("Name_sputumcolor"));
	}	
	public void setName_sputumcolor(String Name_sputumcolor) {
		setAttrVal("Name_sputumcolor", Name_sputumcolor);
	}
	public String getName_keepposition() {
		return ((String) getAttrVal("Name_keepposition"));
	}	
	public void setName_keepposition(String Name_keepposition) {
		setAttrVal("Name_keepposition", Name_keepposition);
	}
	public String getName_skincare() {
		return ((String) getAttrVal("Name_skincare"));
	}	
	public void setName_skincare(String Name_skincare) {
		setAttrVal("Name_skincare", Name_skincare);
	}
	public String getName_othercare() {
		return ((String) getAttrVal("Name_othercare"));
	}	
	public void setName_othercare(String Name_othercare) {
		setAttrVal("Name_othercare", Name_othercare);
	}
	public String getName_body_position() {
		return ((String) getAttrVal("Name_body_position"));
	}	
	public void setName_body_position(String Name_body_position) {
		setAttrVal("Name_body_position", Name_body_position);
	}
	public String getName_people() {
		return ((String) getAttrVal("Name_people"));
	}	
	public void setName_people(String Name_people) {
		setAttrVal("Name_people", Name_people);
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
		return "Id_icupatientcare";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_icupatientinfo_rec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(IcuPatientCareDODesc.class);
	}
	
}