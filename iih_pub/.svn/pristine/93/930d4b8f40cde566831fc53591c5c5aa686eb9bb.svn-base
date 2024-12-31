package iih.en.pv.enres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enres.d.desc.EnPlcDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_地点 DO数据 
 * 
 */
public class EnPlcDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTPLC= "Id_entplc";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PLC= "Id_plc";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entplc() {
		return ((String) getAttrVal("Id_entplc"));
	}	
	public void setId_entplc(String Id_entplc) {
		setAttrVal("Id_entplc", Id_entplc);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_plc() {
		return ((String) getAttrVal("Id_plc"));
	}	
	public void setId_plc(String Id_plc) {
		setAttrVal("Id_plc", Id_plc);
	}
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
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
		return "Id_entplc";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_plc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnPlcDODesc.class);
	}
	
}