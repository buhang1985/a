package iih.en.pv.enfee.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enfee.d.desc.EnFixedFeeItemDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_固定费用明细 DO数据 
 * 
 */
public class EnFixedFeeItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTDCGITM= "Id_entdcgitm";
	public static final String ID_ENTDCG= "Id_entdcg";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_MM= "Id_mm";
	public static final String QUAN= "Quan";
	public static final String ID_UNIT= "Id_unit";
	public static final String ID_SRV_CODE= "Id_srv_code";
	public static final String ID_SRV_NAME= "Id_srv_name";
	public static final String FG_MM= "Fg_mm";
	public static final String ID_MM_CODE= "Id_mm_code";
	public static final String ID_MM_NAME= "Id_mm_name";
	public static final String FG_CHARGE= "Fg_charge";
	public static final String UNIT_NAME= "Unit_name";
	public static final String UNIT_CODE= "Unit_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entdcgitm() {
		return ((String) getAttrVal("Id_entdcgitm"));
	}	
	public void setId_entdcgitm(String Id_entdcgitm) {
		setAttrVal("Id_entdcgitm", Id_entdcgitm);
	}
	public String getId_entdcg() {
		return ((String) getAttrVal("Id_entdcg"));
	}	
	public void setId_entdcg(String Id_entdcg) {
		setAttrVal("Id_entdcg", Id_entdcg);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public String getId_srv_code() {
		return ((String) getAttrVal("Id_srv_code"));
	}	
	public void setId_srv_code(String Id_srv_code) {
		setAttrVal("Id_srv_code", Id_srv_code);
	}
	public String getId_srv_name() {
		return ((String) getAttrVal("Id_srv_name"));
	}	
	public void setId_srv_name(String Id_srv_name) {
		setAttrVal("Id_srv_name", Id_srv_name);
	}
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	public String getId_mm_code() {
		return ((String) getAttrVal("Id_mm_code"));
	}	
	public void setId_mm_code(String Id_mm_code) {
		setAttrVal("Id_mm_code", Id_mm_code);
	}
	public String getId_mm_name() {
		return ((String) getAttrVal("Id_mm_name"));
	}	
	public void setId_mm_name(String Id_mm_name) {
		setAttrVal("Id_mm_name", Id_mm_name);
	}
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}	
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}	
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
	}
	public String getUnit_code() {
		return ((String) getAttrVal("Unit_code"));
	}	
	public void setUnit_code(String Unit_code) {
		setAttrVal("Unit_code", Unit_code);
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
		return "Id_entdcgitm";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_dcg_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnFixedFeeItemDODesc.class);
	}
	
}