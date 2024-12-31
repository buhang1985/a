package iih.ci.mr.nu.ipobstetricnur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.ipobstetricnur.d.desc.IpobstetricnurDODesc;
import java.math.BigDecimal;

/**
 * 产科住院患者护理记录单 DO数据 
 * 
 */
public class IpobstetricnurDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OBSINPA= "Id_obsinpa";
	public static final String ID_OBSINFO= "Id_obsinfo";
	public static final String DT_RECORD= "Dt_record";
	public static final String TEM= "Tem";
	public static final String PAULSE= "Paulse";
	public static final String BREATH= "Breath";
	public static final String SYS_PRE= "Sys_pre";
	public static final String DIA_PRE= "Dia_pre";
	public static final String PAINSCORE= "Painscore";
	public static final String SPO2= "Spo2";
	public static final String EU_INCCON= "Eu_inccon";
	public static final String ENTRYITEM= "Entryitem";
	public static final String AMOUNT= "Amount";
	public static final String URIOUT= "Uriout";
	public static final String OTHEROUT= "Otherout";
	public static final String NAVELHEIGHT= "Navelheight";
	public static final String UPPERHEIGHT= "Upperheight";
	public static final String LOWERHEIGHT= "Lowerheight";
	public static final String EU_UTERCON= "Eu_utercon";
	public static final String EU_BLEEDING= "Eu_bleeding";
	public static final String BLEEDINGAM= "Bleedingam";
	public static final String OTHER= "Other";
	public static final String CHANGEMEA= "Changemea";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_obsinpa() {
		return ((String) getAttrVal("Id_obsinpa"));
	}	
	public void setId_obsinpa(String Id_obsinpa) {
		setAttrVal("Id_obsinpa", Id_obsinpa);
	}
	public String getId_obsinfo() {
		return ((String) getAttrVal("Id_obsinfo"));
	}	
	public void setId_obsinfo(String Id_obsinfo) {
		setAttrVal("Id_obsinfo", Id_obsinfo);
	}
	public FDateTime getDt_record() {
		return ((FDateTime) getAttrVal("Dt_record"));
	}	
	public void setDt_record(FDateTime Dt_record) {
		setAttrVal("Dt_record", Dt_record);
	}
	public FDouble getTem() {
		return ((FDouble) getAttrVal("Tem"));
	}	
	public void setTem(FDouble Tem) {
		setAttrVal("Tem", Tem);
	}
	public Integer getPaulse() {
		return ((Integer) getAttrVal("Paulse"));
	}	
	public void setPaulse(Integer Paulse) {
		setAttrVal("Paulse", Paulse);
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
	public FDouble getPainscore() {
		return ((FDouble) getAttrVal("Painscore"));
	}	
	public void setPainscore(FDouble Painscore) {
		setAttrVal("Painscore", Painscore);
	}
	public FDouble getSpo2() {
		return ((FDouble) getAttrVal("Spo2"));
	}	
	public void setSpo2(FDouble Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	public Integer getEu_inccon() {
		return ((Integer) getAttrVal("Eu_inccon"));
	}	
	public void setEu_inccon(Integer Eu_inccon) {
		setAttrVal("Eu_inccon", Eu_inccon);
	}
	public String getEntryitem() {
		return ((String) getAttrVal("Entryitem"));
	}	
	public void setEntryitem(String Entryitem) {
		setAttrVal("Entryitem", Entryitem);
	}
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}	
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	public FDouble getUriout() {
		return ((FDouble) getAttrVal("Uriout"));
	}	
	public void setUriout(FDouble Uriout) {
		setAttrVal("Uriout", Uriout);
	}
	public FDouble getOtherout() {
		return ((FDouble) getAttrVal("Otherout"));
	}	
	public void setOtherout(FDouble Otherout) {
		setAttrVal("Otherout", Otherout);
	}
	public Integer getNavelheight() {
		return ((Integer) getAttrVal("Navelheight"));
	}	
	public void setNavelheight(Integer Navelheight) {
		setAttrVal("Navelheight", Navelheight);
	}
	public Integer getUpperheight() {
		return ((Integer) getAttrVal("Upperheight"));
	}	
	public void setUpperheight(Integer Upperheight) {
		setAttrVal("Upperheight", Upperheight);
	}
	public Integer getLowerheight() {
		return ((Integer) getAttrVal("Lowerheight"));
	}	
	public void setLowerheight(Integer Lowerheight) {
		setAttrVal("Lowerheight", Lowerheight);
	}
	public Integer getEu_utercon() {
		return ((Integer) getAttrVal("Eu_utercon"));
	}	
	public void setEu_utercon(Integer Eu_utercon) {
		setAttrVal("Eu_utercon", Eu_utercon);
	}
	public Integer getEu_bleeding() {
		return ((Integer) getAttrVal("Eu_bleeding"));
	}	
	public void setEu_bleeding(Integer Eu_bleeding) {
		setAttrVal("Eu_bleeding", Eu_bleeding);
	}
	public FDouble getBleedingam() {
		return ((FDouble) getAttrVal("Bleedingam"));
	}	
	public void setBleedingam(FDouble Bleedingam) {
		setAttrVal("Bleedingam", Bleedingam);
	}
	public String getOther() {
		return ((String) getAttrVal("Other"));
	}	
	public void setOther(String Other) {
		setAttrVal("Other", Other);
	}
	public String getChangemea() {
		return ((String) getAttrVal("Changemea"));
	}	
	public void setChangemea(String Changemea) {
		setAttrVal("Changemea", Changemea);
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
		return "Id_obsinpa";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_ipobstinfo_iotc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(IpobstetricnurDODesc.class);
	}
	
}