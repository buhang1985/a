package iih.nmr.ha.tcho.hemodiasis.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.ha.tcho.hemodiasis.d.desc.HemodialrecDODesc;
import java.math.BigDecimal;

/**
 * 血液透析护理记录项 DO数据 
 * 
 */
public class HemodialrecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HEMOREC= "Id_hemorec";
	public static final String ID_HEMODIA= "Id_hemodia";
	public static final String SYMSIGNSTREAT= "Symsignstreat";
	public static final String NUM_CVP= "Num_cvp";
	public static final String TRANSM_PRESSURE_HIS= "Transm_pressure_his";
	public static final String TEM_MACHINE= "Tem_machine";
	public static final String NUM_MAINTENDOSE= "Num_maintendose";
	public static final String NUM_UFV= "Num_ufv";
	public static final String BLOOD_FLOW_BF= "Blood_flow_bf";
	public static final String DT_HEMODIALYTIME= "Dt_hemodialytime";
	public static final String INT_PULSE= "Int_pulse";
	public static final String INT_BREATHING= "Int_breathing";
	public static final String INT_SBP= "Int_sbp";
	public static final String INT_DBP= "Int_dbp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hemorec() {
		return ((String) getAttrVal("Id_hemorec"));
	}	
	public void setId_hemorec(String Id_hemorec) {
		setAttrVal("Id_hemorec", Id_hemorec);
	}
	public String getId_hemodia() {
		return ((String) getAttrVal("Id_hemodia"));
	}	
	public void setId_hemodia(String Id_hemodia) {
		setAttrVal("Id_hemodia", Id_hemodia);
	}
	public String getSymsignstreat() {
		return ((String) getAttrVal("Symsignstreat"));
	}	
	public void setSymsignstreat(String Symsignstreat) {
		setAttrVal("Symsignstreat", Symsignstreat);
	}
	public Integer getNum_cvp() {
		return ((Integer) getAttrVal("Num_cvp"));
	}	
	public void setNum_cvp(Integer Num_cvp) {
		setAttrVal("Num_cvp", Num_cvp);
	}
	public Integer getTransm_pressure_his() {
		return ((Integer) getAttrVal("Transm_pressure_his"));
	}	
	public void setTransm_pressure_his(Integer Transm_pressure_his) {
		setAttrVal("Transm_pressure_his", Transm_pressure_his);
	}
	public FDouble getTem_machine() {
		return ((FDouble) getAttrVal("Tem_machine"));
	}	
	public void setTem_machine(FDouble Tem_machine) {
		setAttrVal("Tem_machine", Tem_machine);
	}
	public FDouble getNum_maintendose() {
		return ((FDouble) getAttrVal("Num_maintendose"));
	}	
	public void setNum_maintendose(FDouble Num_maintendose) {
		setAttrVal("Num_maintendose", Num_maintendose);
	}
	public FDouble getNum_ufv() {
		return ((FDouble) getAttrVal("Num_ufv"));
	}	
	public void setNum_ufv(FDouble Num_ufv) {
		setAttrVal("Num_ufv", Num_ufv);
	}
	public FDouble getBlood_flow_bf() {
		return ((FDouble) getAttrVal("Blood_flow_bf"));
	}	
	public void setBlood_flow_bf(FDouble Blood_flow_bf) {
		setAttrVal("Blood_flow_bf", Blood_flow_bf);
	}
	public FTime getDt_hemodialytime() {
		return ((FTime) getAttrVal("Dt_hemodialytime"));
	}	
	public void setDt_hemodialytime(FTime Dt_hemodialytime) {
		setAttrVal("Dt_hemodialytime", Dt_hemodialytime);
	}
	public Integer getInt_pulse() {
		return ((Integer) getAttrVal("Int_pulse"));
	}	
	public void setInt_pulse(Integer Int_pulse) {
		setAttrVal("Int_pulse", Int_pulse);
	}
	public Integer getInt_breathing() {
		return ((Integer) getAttrVal("Int_breathing"));
	}	
	public void setInt_breathing(Integer Int_breathing) {
		setAttrVal("Int_breathing", Int_breathing);
	}
	public Integer getInt_sbp() {
		return ((Integer) getAttrVal("Int_sbp"));
	}	
	public void setInt_sbp(Integer Int_sbp) {
		setAttrVal("Int_sbp", Int_sbp);
	}
	public Integer getInt_dbp() {
		return ((Integer) getAttrVal("Int_dbp"));
	}	
	public void setInt_dbp(Integer Int_dbp) {
		setAttrVal("Int_dbp", Int_dbp);
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
		return "Id_hemorec";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_TCHO_HEMOREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HemodialrecDODesc.class);
	}
	
}