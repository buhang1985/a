package iih.ci.mr.nu.inpatientrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.inpatientrecord.d.desc.InPatientRecordDODesc;
import java.math.BigDecimal;

/**
 * 内科住院患者护理记录单 DO数据 
 * 
 */
public class InPatientRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REC= "Id_rec";
	public static final String ID_INTMED= "Id_intmed";
	public static final String D_REC= "D_rec";
	public static final String T_REC= "T_rec";
	public static final String TEM= "Tem";
	public static final String PAULSE= "Paulse";
	public static final String BREATH= "Breath";
	public static final String SYS_PRE= "Sys_pre";
	public static final String DIA_PRE= "Dia_pre";
	public static final String PAIN= "Pain";
	public static final String SPO2= "Spo2";
	public static final String OXY_FLOW= "Oxy_flow";
	public static final String ID_OXY_TYPE= "Id_oxy_type";
	public static final String SD_OXY_TYPE= "Sd_oxy_type";
	public static final String SPUTUM_SUCTION= "Sputum_suction";
	public static final String ID_VEINPIPE= "Id_veinpipe";
	public static final String SD_VEINPIPE= "Sd_veinpipe";
	public static final String ID_CARE_VEINPIPE= "Id_care_veinpipe";
	public static final String SD_CARE_VEINPIPE= "Sd_care_veinpipe";
	public static final String OTHERS= "Others";
	public static final String ILLCONDCHANGESANDSOLVE= "Illcondchangesandsolve";
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_OXY_TP= "Name_oxy_tp";
	public static final String NAME_VEINPIPE= "Name_veinpipe";
	public static final String NAME_CARE_VEINPIPE= "Name_care_veinpipe";
	public static final String NAME_EMP_SIGN= "Name_emp_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rec() {
		return ((String) getAttrVal("Id_rec"));
	}	
	public void setId_rec(String Id_rec) {
		setAttrVal("Id_rec", Id_rec);
	}
	public String getId_intmed() {
		return ((String) getAttrVal("Id_intmed"));
	}	
	public void setId_intmed(String Id_intmed) {
		setAttrVal("Id_intmed", Id_intmed);
	}
	public FDate getD_rec() {
		return ((FDate) getAttrVal("D_rec"));
	}	
	public void setD_rec(FDate D_rec) {
		setAttrVal("D_rec", D_rec);
	}
	public FTime getT_rec() {
		return ((FTime) getAttrVal("T_rec"));
	}	
	public void setT_rec(FTime T_rec) {
		setAttrVal("T_rec", T_rec);
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
	public Integer getPain() {
		return ((Integer) getAttrVal("Pain"));
	}	
	public void setPain(Integer Pain) {
		setAttrVal("Pain", Pain);
	}
	public FDouble getSpo2() {
		return ((FDouble) getAttrVal("Spo2"));
	}	
	public void setSpo2(FDouble Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	public FDouble getOxy_flow() {
		return ((FDouble) getAttrVal("Oxy_flow"));
	}	
	public void setOxy_flow(FDouble Oxy_flow) {
		setAttrVal("Oxy_flow", Oxy_flow);
	}
	public String getId_oxy_type() {
		return ((String) getAttrVal("Id_oxy_type"));
	}	
	public void setId_oxy_type(String Id_oxy_type) {
		setAttrVal("Id_oxy_type", Id_oxy_type);
	}
	public String getSd_oxy_type() {
		return ((String) getAttrVal("Sd_oxy_type"));
	}	
	public void setSd_oxy_type(String Sd_oxy_type) {
		setAttrVal("Sd_oxy_type", Sd_oxy_type);
	}
	public String getSputum_suction() {
		return ((String) getAttrVal("Sputum_suction"));
	}	
	public void setSputum_suction(String Sputum_suction) {
		setAttrVal("Sputum_suction", Sputum_suction);
	}
	public String getId_veinpipe() {
		return ((String) getAttrVal("Id_veinpipe"));
	}	
	public void setId_veinpipe(String Id_veinpipe) {
		setAttrVal("Id_veinpipe", Id_veinpipe);
	}
	public String getSd_veinpipe() {
		return ((String) getAttrVal("Sd_veinpipe"));
	}	
	public void setSd_veinpipe(String Sd_veinpipe) {
		setAttrVal("Sd_veinpipe", Sd_veinpipe);
	}
	public String getId_care_veinpipe() {
		return ((String) getAttrVal("Id_care_veinpipe"));
	}	
	public void setId_care_veinpipe(String Id_care_veinpipe) {
		setAttrVal("Id_care_veinpipe", Id_care_veinpipe);
	}
	public String getSd_care_veinpipe() {
		return ((String) getAttrVal("Sd_care_veinpipe"));
	}	
	public void setSd_care_veinpipe(String Sd_care_veinpipe) {
		setAttrVal("Sd_care_veinpipe", Sd_care_veinpipe);
	}
	public String getOthers() {
		return ((String) getAttrVal("Others"));
	}	
	public void setOthers(String Others) {
		setAttrVal("Others", Others);
	}
	public String getIllcondchangesandsolve() {
		return ((String) getAttrVal("Illcondchangesandsolve"));
	}	
	public void setIllcondchangesandsolve(String Illcondchangesandsolve) {
		setAttrVal("Illcondchangesandsolve", Illcondchangesandsolve);
	}
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
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
	public String getName_oxy_tp() {
		return ((String) getAttrVal("Name_oxy_tp"));
	}	
	public void setName_oxy_tp(String Name_oxy_tp) {
		setAttrVal("Name_oxy_tp", Name_oxy_tp);
	}
	public String getName_veinpipe() {
		return ((String) getAttrVal("Name_veinpipe"));
	}	
	public void setName_veinpipe(String Name_veinpipe) {
		setAttrVal("Name_veinpipe", Name_veinpipe);
	}
	public String getName_care_veinpipe() {
		return ((String) getAttrVal("Name_care_veinpipe"));
	}	
	public void setName_care_veinpipe(String Name_care_veinpipe) {
		setAttrVal("Name_care_veinpipe", Name_care_veinpipe);
	}
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}	
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
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
		return "Id_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_inpatrcd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InPatientRecordDODesc.class);
	}
	
}