package iih.ci.mr.nu.opermatlist.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.opermatlist.d.desc.OpermatEquipDODesc;
import java.math.BigDecimal;

/**
 * 手术患者术中器械 DO数据 
 * 
 */
public class OpermatEquipDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPEREQUIP= "Id_operequip";
	public static final String ID_OPERMATLIST= "Id_opermatlist";
	public static final String ID_EQUIPMENT= "Id_equipment";
	public static final String SD_EQUIPMENT= "Sd_equipment";
	public static final String NUM_BEFORE_OPR= "Num_before_opr";
	public static final String NUM_BEFORE_COELOM= "Num_before_coelom";
	public static final String NUM_AFTER_COELOM= "Num_after_coelom";
	public static final String NUM_AFTER_SEW= "Num_after_sew";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_EQUIPMENT= "Name_equipment";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_operequip() {
		return ((String) getAttrVal("Id_operequip"));
	}	
	public void setId_operequip(String Id_operequip) {
		setAttrVal("Id_operequip", Id_operequip);
	}
	public String getId_opermatlist() {
		return ((String) getAttrVal("Id_opermatlist"));
	}	
	public void setId_opermatlist(String Id_opermatlist) {
		setAttrVal("Id_opermatlist", Id_opermatlist);
	}
	public String getId_equipment() {
		return ((String) getAttrVal("Id_equipment"));
	}	
	public void setId_equipment(String Id_equipment) {
		setAttrVal("Id_equipment", Id_equipment);
	}
	public String getSd_equipment() {
		return ((String) getAttrVal("Sd_equipment"));
	}	
	public void setSd_equipment(String Sd_equipment) {
		setAttrVal("Sd_equipment", Sd_equipment);
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
	public String getName_equipment() {
		return ((String) getAttrVal("Name_equipment"));
	}	
	public void setName_equipment(String Name_equipment) {
		setAttrVal("Name_equipment", Name_equipment);
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
		return "Id_operequip";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_OPERMATEQUIP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpermatEquipDODesc.class);
	}
	
}