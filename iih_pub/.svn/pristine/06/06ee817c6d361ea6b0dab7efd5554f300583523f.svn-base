package iih.ci.mr.nu.opermatlist.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.opermatlist.d.desc.OpermatDutyDODesc;
import java.math.BigDecimal;

/**
 * 手术责任人 DO数据 
 * 
 */
public class OpermatDutyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPERDUTY= "Id_operduty";
	public static final String ID_OPERMATLIST= "Id_opermatlist";
	public static final String NUM_BEFORE_OPR= "Num_before_opr";
	public static final String NUM_BEFORE_COELOM= "Num_before_coelom";
	public static final String NUM_AFTER_COELOM= "Num_after_coelom";
	public static final String NUM_AFTER_SEW= "Num_after_sew";
	public static final String ID_HANDOVER= "Id_handover";
	public static final String SD_HANDOVER= "Sd_handover";
	public static final String DT_HANDOVER= "Dt_handover";
	public static final String ENUM_DUTYPS= "Enum_dutyps";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_HANDOVER= "Name_handover";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_operduty() {
		return ((String) getAttrVal("Id_operduty"));
	}	
	public void setId_operduty(String Id_operduty) {
		setAttrVal("Id_operduty", Id_operduty);
	}
	public String getId_opermatlist() {
		return ((String) getAttrVal("Id_opermatlist"));
	}	
	public void setId_opermatlist(String Id_opermatlist) {
		setAttrVal("Id_opermatlist", Id_opermatlist);
	}
	public Integer getNum_before_opr() {
		return ((Integer) getAttrVal("Num_before_opr"));
	}	
	public void setNum_before_opr(Integer Num_before_opr) {
		setAttrVal("Num_before_opr", Num_before_opr);
	}
	public Integer getNum_before_coelom() {
		return ((Integer) getAttrVal("Num_before_coelom"));
	}	
	public void setNum_before_coelom(Integer Num_before_coelom) {
		setAttrVal("Num_before_coelom", Num_before_coelom);
	}
	public Integer getNum_after_coelom() {
		return ((Integer) getAttrVal("Num_after_coelom"));
	}	
	public void setNum_after_coelom(Integer Num_after_coelom) {
		setAttrVal("Num_after_coelom", Num_after_coelom);
	}
	public Integer getNum_after_sew() {
		return ((Integer) getAttrVal("Num_after_sew"));
	}	
	public void setNum_after_sew(Integer Num_after_sew) {
		setAttrVal("Num_after_sew", Num_after_sew);
	}
	public String getId_handover() {
		return ((String) getAttrVal("Id_handover"));
	}	
	public void setId_handover(String Id_handover) {
		setAttrVal("Id_handover", Id_handover);
	}
	public String getSd_handover() {
		return ((String) getAttrVal("Sd_handover"));
	}	
	public void setSd_handover(String Sd_handover) {
		setAttrVal("Sd_handover", Sd_handover);
	}
	public FDateTime getDt_handover() {
		return ((FDateTime) getAttrVal("Dt_handover"));
	}	
	public void setDt_handover(FDateTime Dt_handover) {
		setAttrVal("Dt_handover", Dt_handover);
	}
	public Integer getEnum_dutyps() {
		return ((Integer) getAttrVal("Enum_dutyps"));
	}	
	public void setEnum_dutyps(Integer Enum_dutyps) {
		setAttrVal("Enum_dutyps", Enum_dutyps);
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
	public String getName_handover() {
		return ((String) getAttrVal("Name_handover"));
	}	
	public void setName_handover(String Name_handover) {
		setAttrVal("Name_handover", Name_handover);
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
		return "Id_operduty";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_OPERMATDUTY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpermatDutyDODesc.class);
	}
	
}