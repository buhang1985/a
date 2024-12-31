package iih.ci.mr.nu.perioperativenurrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.perioperativenurrec.d.desc.PpNurRecDODesc;
import java.math.BigDecimal;

/**
 * 围手术期护理记录 DO数据 
 * 
 */
public class PpNurRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PPNUR_REC= "Id_ppnur_rec";
	public static final String ID_PPNUR= "Id_ppnur";
	public static final String DT_OPERREC= "Dt_operrec";
	public static final String TEM= "Tem";
	public static final String PAULSE= "Paulse";
	public static final String BREATH= "Breath";
	public static final String SYS_PRE= "Sys_pre";
	public static final String DIA_PRE= "Dia_pre";
	public static final String SPO2= "Spo2";
	public static final String WOUND= "Wound";
	public static final String ID_VEINPIPE= "Id_veinpipe";
	public static final String SD_VEINPIPE= "Sd_veinpipe";
	public static final String ID_CARE_VEINPIPE= "Id_care_veinpipe";
	public static final String SD_CARE_VEINPIPE= "Sd_care_veinpipe";
	public static final String ID_PIPE= "Id_pipe";
	public static final String SD_PIPE= "Sd_pipe";
	public static final String ID_PIPE_STATE= "Id_pipe_state";
	public static final String SD_PIPE_STATE= "Sd_pipe_state";
	public static final String PIPE_VOLUME= "Pipe_volume";
	public static final String OTHERS= "Others";
	public static final String CHANGEMEA= "Changemea";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_VEINPIPE= "Name_veinpipe";
	public static final String NAME_CARE_VEINPIPE= "Name_care_veinpipe";
	public static final String NAME_PIPE= "Name_pipe";
	public static final String NAME_PIPE_STATE= "Name_pipe_state";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public PpNurRecDO () {
		super();
	}
	
	public String getId_ppnur_rec() {
		return ((String) getAttrVal("Id_ppnur_rec"));
	}	
	public void setId_ppnur_rec(String Id_ppnur_rec) {
		setAttrVal("Id_ppnur_rec", Id_ppnur_rec);
	}
	public String getId_ppnur() {
		return ((String) getAttrVal("Id_ppnur"));
	}	
	public void setId_ppnur(String Id_ppnur) {
		setAttrVal("Id_ppnur", Id_ppnur);
	}
	public FDateTime getDt_operrec() {
		return ((FDateTime) getAttrVal("Dt_operrec"));
	}	
	public void setDt_operrec(FDateTime Dt_operrec) {
		setAttrVal("Dt_operrec", Dt_operrec);
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
	public FDouble getSpo2() {
		return ((FDouble) getAttrVal("Spo2"));
	}	
	public void setSpo2(FDouble Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	public String getWound() {
		return ((String) getAttrVal("Wound"));
	}	
	public void setWound(String Wound) {
		setAttrVal("Wound", Wound);
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
	public String getId_pipe() {
		return ((String) getAttrVal("Id_pipe"));
	}	
	public void setId_pipe(String Id_pipe) {
		setAttrVal("Id_pipe", Id_pipe);
	}
	public String getSd_pipe() {
		return ((String) getAttrVal("Sd_pipe"));
	}	
	public void setSd_pipe(String Sd_pipe) {
		setAttrVal("Sd_pipe", Sd_pipe);
	}
	public String getId_pipe_state() {
		return ((String) getAttrVal("Id_pipe_state"));
	}	
	public void setId_pipe_state(String Id_pipe_state) {
		setAttrVal("Id_pipe_state", Id_pipe_state);
	}
	public String getSd_pipe_state() {
		return ((String) getAttrVal("Sd_pipe_state"));
	}	
	public void setSd_pipe_state(String Sd_pipe_state) {
		setAttrVal("Sd_pipe_state", Sd_pipe_state);
	}
	public Integer getPipe_volume() {
		return ((Integer) getAttrVal("Pipe_volume"));
	}	
	public void setPipe_volume(Integer Pipe_volume) {
		setAttrVal("Pipe_volume", Pipe_volume);
	}
	public String getOthers() {
		return ((String) getAttrVal("Others"));
	}	
	public void setOthers(String Others) {
		setAttrVal("Others", Others);
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
	public String getName_pipe() {
		return ((String) getAttrVal("Name_pipe"));
	}	
	public void setName_pipe(String Name_pipe) {
		setAttrVal("Name_pipe", Name_pipe);
	}
	public String getName_pipe_state() {
		return ((String) getAttrVal("Name_pipe_state"));
	}	
	public void setName_pipe_state(String Name_pipe_state) {
		setAttrVal("Name_pipe_state", Name_pipe_state);
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
		return "Id_ppnur_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_PPNUR_REC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PpNurRecDODesc.class);
	}
	
}