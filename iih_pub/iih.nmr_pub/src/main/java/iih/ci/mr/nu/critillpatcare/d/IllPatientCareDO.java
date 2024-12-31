package iih.ci.mr.nu.critillpatcare.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.critillpatcare.d.desc.IllPatientCareDODesc;
import java.math.BigDecimal;

/**
 * 病危患者护理记录 DO数据 
 * 
 */
public class IllPatientCareDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATCARE= "Id_patcare";
	public static final String ID_ILLPAT= "Id_illpat";
	public static final String SYS_PRE= "Sys_pre";
	public static final String DIA_PRE= "Dia_pre";
	public static final String NOTIFYDOC= "Notifydoc";
	public static final String TEM= "Tem";
	public static final String HEARTRATE= "Heartrate";
	public static final String BREATH= "Breath";
	public static final String PAINSCORE= "Painscore";
	public static final String SPO2= "Spo2";
	public static final String LEFTPUPSIZE= "Leftpupsize";
	public static final String RIGHTPUPSIZE= "Rightpupsize";
	public static final String OXYRATE= "Oxyrate";
	public static final String EXUDEAM= "Exudeam";
	public static final String DOSAGE= "Dosage";
	public static final String OTHDOSAGE= "Othdosage";
	public static final String URIOUTPUT= "Urioutput";
	public static final String OTHOUTPUT= "Othoutput";
	public static final String SPUTUM= "Sputum";
	public static final String ATOMIZER= "Atomizer";
	public static final String EXUDE= "Exude";
	public static final String DATI= "Dati";
	public static final String ID_SENSE= "Id_sense";
	public static final String SD_SENSE= "Sd_sense";
	public static final String ID_OXYGEN= "Id_oxygen";
	public static final String SD_OXYGEN= "Sd_oxygen";
	public static final String ID_PIPENAME= "Id_pipename";
	public static final String SD_PIPENAME= "Sd_pipename";
	public static final String ID_VENOUSNUR= "Id_venousnur";
	public static final String SD_VENOUSNUR= "Sd_venousnur";
	public static final String ID_TREPUMP= "Id_trepump";
	public static final String SD_TREPUMP= "Sd_trepump";
	public static final String ID_MORCARE= "Id_morcare";
	public static final String SD_MORCARE= "Sd_morcare";
	public static final String ID_NIGHTCARE= "Id_nightcare";
	public static final String SD_NIGHTCARE= "Sd_nightcare";
	public static final String ID_NURGUID= "Id_nurguid";
	public static final String SD_NURGUID= "Sd_nurguid";
	public static final String ID_DRAIN= "Id_drain";
	public static final String SD_DRAIN= "Sd_drain";
	public static final String ID_SKIN= "Id_skin";
	public static final String SD_SKIN= "Sd_skin";
	public static final String ID_LEFTPUPIL= "Id_leftpupil";
	public static final String SD_LEFTPUPIL= "Sd_leftpupil";
	public static final String ID_RIGHTPUPIL= "Id_rightpupil";
	public static final String SD_RIGHTPUPIL= "Sd_rightpupil";
	public static final String ID_VENOUSNAME= "Id_venousname";
	public static final String SD_VENOUSNAME= "Sd_venousname";
	public static final String ID_POSITION= "Id_position";
	public static final String SD_POSITION= "Sd_position";
	public static final String ENUMCONSTRAINT= "Enumconstraint";
	public static final String DES_STATETEND= "Des_statetend";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SENSE= "Name_sense";
	public static final String NAME_OXYGEN= "Name_oxygen";
	public static final String NAME_PIPENAME= "Name_pipename";
	public static final String NAME_VENOUSNUR= "Name_venousnur";
	public static final String NAME_TREPUMP= "Name_trepump";
	public static final String NAME_MORCARE= "Name_morcare";
	public static final String NAME_NIGHTCARE= "Name_nightcare";
	public static final String NAME_NURGUID= "Name_nurguid";
	public static final String NAME_DRAIN= "Name_drain";
	public static final String NAME_SKIN= "Name_skin";
	public static final String NAME_LEFTPUPIL= "Name_leftpupil";
	public static final String NAME_RIGHTPUPIL= "Name_rightpupil";
	public static final String NAME_VENOUSNAME= "Name_venousname";
	public static final String NAME_POSITION= "Name_position";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patcare() {
		return ((String) getAttrVal("Id_patcare"));
	}	
	public void setId_patcare(String Id_patcare) {
		setAttrVal("Id_patcare", Id_patcare);
	}
	public String getId_illpat() {
		return ((String) getAttrVal("Id_illpat"));
	}	
	public void setId_illpat(String Id_illpat) {
		setAttrVal("Id_illpat", Id_illpat);
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
	public FBoolean getNotifydoc() {
		return ((FBoolean) getAttrVal("Notifydoc"));
	}	
	public void setNotifydoc(FBoolean Notifydoc) {
		setAttrVal("Notifydoc", Notifydoc);
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
	public Integer getBreath() {
		return ((Integer) getAttrVal("Breath"));
	}	
	public void setBreath(Integer Breath) {
		setAttrVal("Breath", Breath);
	}
	public Integer getPainscore() {
		return ((Integer) getAttrVal("Painscore"));
	}	
	public void setPainscore(Integer Painscore) {
		setAttrVal("Painscore", Painscore);
	}
	public FDouble getSpo2() {
		return ((FDouble) getAttrVal("Spo2"));
	}	
	public void setSpo2(FDouble Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	public FDouble getLeftpupsize() {
		return ((FDouble) getAttrVal("Leftpupsize"));
	}	
	public void setLeftpupsize(FDouble Leftpupsize) {
		setAttrVal("Leftpupsize", Leftpupsize);
	}
	public FDouble getRightpupsize() {
		return ((FDouble) getAttrVal("Rightpupsize"));
	}	
	public void setRightpupsize(FDouble Rightpupsize) {
		setAttrVal("Rightpupsize", Rightpupsize);
	}
	public FDouble getOxyrate() {
		return ((FDouble) getAttrVal("Oxyrate"));
	}	
	public void setOxyrate(FDouble Oxyrate) {
		setAttrVal("Oxyrate", Oxyrate);
	}
	public FDouble getExudeam() {
		return ((FDouble) getAttrVal("Exudeam"));
	}	
	public void setExudeam(FDouble Exudeam) {
		setAttrVal("Exudeam", Exudeam);
	}
	public FDouble getDosage() {
		return ((FDouble) getAttrVal("Dosage"));
	}	
	public void setDosage(FDouble Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	public FDouble getOthdosage() {
		return ((FDouble) getAttrVal("Othdosage"));
	}	
	public void setOthdosage(FDouble Othdosage) {
		setAttrVal("Othdosage", Othdosage);
	}
	public FDouble getUrioutput() {
		return ((FDouble) getAttrVal("Urioutput"));
	}	
	public void setUrioutput(FDouble Urioutput) {
		setAttrVal("Urioutput", Urioutput);
	}
	public FDouble getOthoutput() {
		return ((FDouble) getAttrVal("Othoutput"));
	}	
	public void setOthoutput(FDouble Othoutput) {
		setAttrVal("Othoutput", Othoutput);
	}
	public FBoolean getSputum() {
		return ((FBoolean) getAttrVal("Sputum"));
	}	
	public void setSputum(FBoolean Sputum) {
		setAttrVal("Sputum", Sputum);
	}
	public FBoolean getAtomizer() {
		return ((FBoolean) getAttrVal("Atomizer"));
	}	
	public void setAtomizer(FBoolean Atomizer) {
		setAttrVal("Atomizer", Atomizer);
	}
	public FBoolean getExude() {
		return ((FBoolean) getAttrVal("Exude"));
	}	
	public void setExude(FBoolean Exude) {
		setAttrVal("Exude", Exude);
	}
	public FDateTime getDati() {
		return ((FDateTime) getAttrVal("Dati"));
	}	
	public void setDati(FDateTime Dati) {
		setAttrVal("Dati", Dati);
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
	public String getId_oxygen() {
		return ((String) getAttrVal("Id_oxygen"));
	}	
	public void setId_oxygen(String Id_oxygen) {
		setAttrVal("Id_oxygen", Id_oxygen);
	}
	public String getSd_oxygen() {
		return ((String) getAttrVal("Sd_oxygen"));
	}	
	public void setSd_oxygen(String Sd_oxygen) {
		setAttrVal("Sd_oxygen", Sd_oxygen);
	}
	public String getId_pipename() {
		return ((String) getAttrVal("Id_pipename"));
	}	
	public void setId_pipename(String Id_pipename) {
		setAttrVal("Id_pipename", Id_pipename);
	}
	public String getSd_pipename() {
		return ((String) getAttrVal("Sd_pipename"));
	}	
	public void setSd_pipename(String Sd_pipename) {
		setAttrVal("Sd_pipename", Sd_pipename);
	}
	public String getId_venousnur() {
		return ((String) getAttrVal("Id_venousnur"));
	}	
	public void setId_venousnur(String Id_venousnur) {
		setAttrVal("Id_venousnur", Id_venousnur);
	}
	public String getSd_venousnur() {
		return ((String) getAttrVal("Sd_venousnur"));
	}	
	public void setSd_venousnur(String Sd_venousnur) {
		setAttrVal("Sd_venousnur", Sd_venousnur);
	}
	public String getId_trepump() {
		return ((String) getAttrVal("Id_trepump"));
	}	
	public void setId_trepump(String Id_trepump) {
		setAttrVal("Id_trepump", Id_trepump);
	}
	public String getSd_trepump() {
		return ((String) getAttrVal("Sd_trepump"));
	}	
	public void setSd_trepump(String Sd_trepump) {
		setAttrVal("Sd_trepump", Sd_trepump);
	}
	public String getId_morcare() {
		return ((String) getAttrVal("Id_morcare"));
	}	
	public void setId_morcare(String Id_morcare) {
		setAttrVal("Id_morcare", Id_morcare);
	}
	public String getSd_morcare() {
		return ((String) getAttrVal("Sd_morcare"));
	}	
	public void setSd_morcare(String Sd_morcare) {
		setAttrVal("Sd_morcare", Sd_morcare);
	}
	public String getId_nightcare() {
		return ((String) getAttrVal("Id_nightcare"));
	}	
	public void setId_nightcare(String Id_nightcare) {
		setAttrVal("Id_nightcare", Id_nightcare);
	}
	public String getSd_nightcare() {
		return ((String) getAttrVal("Sd_nightcare"));
	}	
	public void setSd_nightcare(String Sd_nightcare) {
		setAttrVal("Sd_nightcare", Sd_nightcare);
	}
	public String getId_nurguid() {
		return ((String) getAttrVal("Id_nurguid"));
	}	
	public void setId_nurguid(String Id_nurguid) {
		setAttrVal("Id_nurguid", Id_nurguid);
	}
	public String getSd_nurguid() {
		return ((String) getAttrVal("Sd_nurguid"));
	}	
	public void setSd_nurguid(String Sd_nurguid) {
		setAttrVal("Sd_nurguid", Sd_nurguid);
	}
	public String getId_drain() {
		return ((String) getAttrVal("Id_drain"));
	}	
	public void setId_drain(String Id_drain) {
		setAttrVal("Id_drain", Id_drain);
	}
	public String getSd_drain() {
		return ((String) getAttrVal("Sd_drain"));
	}	
	public void setSd_drain(String Sd_drain) {
		setAttrVal("Sd_drain", Sd_drain);
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
	public String getId_leftpupil() {
		return ((String) getAttrVal("Id_leftpupil"));
	}	
	public void setId_leftpupil(String Id_leftpupil) {
		setAttrVal("Id_leftpupil", Id_leftpupil);
	}
	public String getSd_leftpupil() {
		return ((String) getAttrVal("Sd_leftpupil"));
	}	
	public void setSd_leftpupil(String Sd_leftpupil) {
		setAttrVal("Sd_leftpupil", Sd_leftpupil);
	}
	public String getId_rightpupil() {
		return ((String) getAttrVal("Id_rightpupil"));
	}	
	public void setId_rightpupil(String Id_rightpupil) {
		setAttrVal("Id_rightpupil", Id_rightpupil);
	}
	public String getSd_rightpupil() {
		return ((String) getAttrVal("Sd_rightpupil"));
	}	
	public void setSd_rightpupil(String Sd_rightpupil) {
		setAttrVal("Sd_rightpupil", Sd_rightpupil);
	}
	public String getId_venousname() {
		return ((String) getAttrVal("Id_venousname"));
	}	
	public void setId_venousname(String Id_venousname) {
		setAttrVal("Id_venousname", Id_venousname);
	}
	public String getSd_venousname() {
		return ((String) getAttrVal("Sd_venousname"));
	}	
	public void setSd_venousname(String Sd_venousname) {
		setAttrVal("Sd_venousname", Sd_venousname);
	}
	public String getId_position() {
		return ((String) getAttrVal("Id_position"));
	}	
	public void setId_position(String Id_position) {
		setAttrVal("Id_position", Id_position);
	}
	public String getSd_position() {
		return ((String) getAttrVal("Sd_position"));
	}	
	public void setSd_position(String Sd_position) {
		setAttrVal("Sd_position", Sd_position);
	}
	public Integer getEnumconstraint() {
		return ((Integer) getAttrVal("Enumconstraint"));
	}	
	public void setEnumconstraint(Integer Enumconstraint) {
		setAttrVal("Enumconstraint", Enumconstraint);
	}
	public String getDes_statetend() {
		return ((String) getAttrVal("Des_statetend"));
	}	
	public void setDes_statetend(String Des_statetend) {
		setAttrVal("Des_statetend", Des_statetend);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
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
	public String getName_oxygen() {
		return ((String) getAttrVal("Name_oxygen"));
	}	
	public void setName_oxygen(String Name_oxygen) {
		setAttrVal("Name_oxygen", Name_oxygen);
	}
	public String getName_pipename() {
		return ((String) getAttrVal("Name_pipename"));
	}	
	public void setName_pipename(String Name_pipename) {
		setAttrVal("Name_pipename", Name_pipename);
	}
	public String getName_venousnur() {
		return ((String) getAttrVal("Name_venousnur"));
	}	
	public void setName_venousnur(String Name_venousnur) {
		setAttrVal("Name_venousnur", Name_venousnur);
	}
	public String getName_trepump() {
		return ((String) getAttrVal("Name_trepump"));
	}	
	public void setName_trepump(String Name_trepump) {
		setAttrVal("Name_trepump", Name_trepump);
	}
	public String getName_morcare() {
		return ((String) getAttrVal("Name_morcare"));
	}	
	public void setName_morcare(String Name_morcare) {
		setAttrVal("Name_morcare", Name_morcare);
	}
	public String getName_nightcare() {
		return ((String) getAttrVal("Name_nightcare"));
	}	
	public void setName_nightcare(String Name_nightcare) {
		setAttrVal("Name_nightcare", Name_nightcare);
	}
	public String getName_nurguid() {
		return ((String) getAttrVal("Name_nurguid"));
	}	
	public void setName_nurguid(String Name_nurguid) {
		setAttrVal("Name_nurguid", Name_nurguid);
	}
	public String getName_drain() {
		return ((String) getAttrVal("Name_drain"));
	}	
	public void setName_drain(String Name_drain) {
		setAttrVal("Name_drain", Name_drain);
	}
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
	}
	public String getName_leftpupil() {
		return ((String) getAttrVal("Name_leftpupil"));
	}	
	public void setName_leftpupil(String Name_leftpupil) {
		setAttrVal("Name_leftpupil", Name_leftpupil);
	}
	public String getName_rightpupil() {
		return ((String) getAttrVal("Name_rightpupil"));
	}	
	public void setName_rightpupil(String Name_rightpupil) {
		setAttrVal("Name_rightpupil", Name_rightpupil);
	}
	public String getName_venousname() {
		return ((String) getAttrVal("Name_venousname"));
	}	
	public void setName_venousname(String Name_venousname) {
		setAttrVal("Name_venousname", Name_venousname);
	}
	public String getName_position() {
		return ((String) getAttrVal("Name_position"));
	}	
	public void setName_position(String Name_position) {
		setAttrVal("Name_position", Name_position);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
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
		return "Id_patcare";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_illpatcare";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(IllPatientCareDODesc.class);
	}
	
}