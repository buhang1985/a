package iih.ci.mr.nu.intervopre.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.intervopre.d.desc.InterOperInfoDODesc;
import java.math.BigDecimal;

/**
 * 介入手术信息 DO数据 
 * 
 */
public class InterOperInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPER_PRE= "Id_oper_pre";
	public static final String ID_PATINFO= "Id_patinfo";
	public static final String INFU_NAME= "Infu_name";
	public static final String ID_SIG= "Id_sig";
	public static final String X_IRRADIATION= "X_irradiation";
	public static final String SYS_PRE= "Sys_pre";
	public static final String DIA_PRE= "Dia_pre";
	public static final String BREATH= "Breath";
	public static final String INFU_VOLUME= "Infu_volume";
	public static final String INFU_RATE= "Infu_rate";
	public static final String URINE_VOLUME= "Urine_volume";
	public static final String HEARTRATE= "Heartrate";
	public static final String SPO2= "Spo2";
	public static final String T_OPER= "T_oper";
	public static final String T_OPER_PROCESS= "T_oper_process";
	public static final String ID_CONSCIOUS= "Id_conscious";
	public static final String SD_CONSCIOUS= "Sd_conscious";
	public static final String ID_PUPIL_SHAPE= "Id_pupil_shape";
	public static final String SD_PUPIL_SHAPE= "Sd_pupil_shape";
	public static final String ID_PUPIL_REFLECT= "Id_pupil_reflect";
	public static final String SD_PUPIL_REFLECT= "Sd_pupil_reflect";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SIG= "Name_sig";
	public static final String NAME_CONSCIOUS= "Name_conscious";
	public static final String NAME_PUPIL_SHAPE= "Name_pupil_shape";
	public static final String NAME_PUPIL_REFLECT= "Name_pupil_reflect";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_oper_pre() {
		return ((String) getAttrVal("Id_oper_pre"));
	}	
	public void setId_oper_pre(String Id_oper_pre) {
		setAttrVal("Id_oper_pre", Id_oper_pre);
	}
	public String getId_patinfo() {
		return ((String) getAttrVal("Id_patinfo"));
	}	
	public void setId_patinfo(String Id_patinfo) {
		setAttrVal("Id_patinfo", Id_patinfo);
	}
	public String getInfu_name() {
		return ((String) getAttrVal("Infu_name"));
	}	
	public void setInfu_name(String Infu_name) {
		setAttrVal("Infu_name", Infu_name);
	}
	public String getId_sig() {
		return ((String) getAttrVal("Id_sig"));
	}	
	public void setId_sig(String Id_sig) {
		setAttrVal("Id_sig", Id_sig);
	}
	public Integer getX_irradiation() {
		return ((Integer) getAttrVal("X_irradiation"));
	}	
	public void setX_irradiation(Integer X_irradiation) {
		setAttrVal("X_irradiation", X_irradiation);
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
	public Integer getBreath() {
		return ((Integer) getAttrVal("Breath"));
	}	
	public void setBreath(Integer Breath) {
		setAttrVal("Breath", Breath);
	}
	public Integer getInfu_volume() {
		return ((Integer) getAttrVal("Infu_volume"));
	}	
	public void setInfu_volume(Integer Infu_volume) {
		setAttrVal("Infu_volume", Infu_volume);
	}
	public Integer getInfu_rate() {
		return ((Integer) getAttrVal("Infu_rate"));
	}	
	public void setInfu_rate(Integer Infu_rate) {
		setAttrVal("Infu_rate", Infu_rate);
	}
	public Integer getUrine_volume() {
		return ((Integer) getAttrVal("Urine_volume"));
	}	
	public void setUrine_volume(Integer Urine_volume) {
		setAttrVal("Urine_volume", Urine_volume);
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
	public FTime getT_oper() {
		return ((FTime) getAttrVal("T_oper"));
	}	
	public void setT_oper(FTime T_oper) {
		setAttrVal("T_oper", T_oper);
	}
	public FTime getT_oper_process() {
		return ((FTime) getAttrVal("T_oper_process"));
	}	
	public void setT_oper_process(FTime T_oper_process) {
		setAttrVal("T_oper_process", T_oper_process);
	}
	public String getId_conscious() {
		return ((String) getAttrVal("Id_conscious"));
	}	
	public void setId_conscious(String Id_conscious) {
		setAttrVal("Id_conscious", Id_conscious);
	}
	public String getSd_conscious() {
		return ((String) getAttrVal("Sd_conscious"));
	}	
	public void setSd_conscious(String Sd_conscious) {
		setAttrVal("Sd_conscious", Sd_conscious);
	}
	public String getId_pupil_shape() {
		return ((String) getAttrVal("Id_pupil_shape"));
	}	
	public void setId_pupil_shape(String Id_pupil_shape) {
		setAttrVal("Id_pupil_shape", Id_pupil_shape);
	}
	public String getSd_pupil_shape() {
		return ((String) getAttrVal("Sd_pupil_shape"));
	}	
	public void setSd_pupil_shape(String Sd_pupil_shape) {
		setAttrVal("Sd_pupil_shape", Sd_pupil_shape);
	}
	public String getId_pupil_reflect() {
		return ((String) getAttrVal("Id_pupil_reflect"));
	}	
	public void setId_pupil_reflect(String Id_pupil_reflect) {
		setAttrVal("Id_pupil_reflect", Id_pupil_reflect);
	}
	public String getSd_pupil_reflect() {
		return ((String) getAttrVal("Sd_pupil_reflect"));
	}	
	public void setSd_pupil_reflect(String Sd_pupil_reflect) {
		setAttrVal("Sd_pupil_reflect", Sd_pupil_reflect);
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
	public String getName_sig() {
		return ((String) getAttrVal("Name_sig"));
	}	
	public void setName_sig(String Name_sig) {
		setAttrVal("Name_sig", Name_sig);
	}
	public String getName_conscious() {
		return ((String) getAttrVal("Name_conscious"));
	}	
	public void setName_conscious(String Name_conscious) {
		setAttrVal("Name_conscious", Name_conscious);
	}
	public String getName_pupil_shape() {
		return ((String) getAttrVal("Name_pupil_shape"));
	}	
	public void setName_pupil_shape(String Name_pupil_shape) {
		setAttrVal("Name_pupil_shape", Name_pupil_shape);
	}
	public String getName_pupil_reflect() {
		return ((String) getAttrVal("Name_pupil_reflect"));
	}	
	public void setName_pupil_reflect(String Name_pupil_reflect) {
		setAttrVal("Name_pupil_reflect", Name_pupil_reflect);
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
		return "Id_oper_pre";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_INTEROPERINFO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InterOperInfoDODesc.class);
	}
	
}