package iih.bl.hp.blhppatspec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.blhppatspec.d.desc.BlHpPatSpecDiDODesc;
import java.math.BigDecimal;

/**
 * 医保特殊病患者诊断 DO数据 
 * 
 */
public class BlHpPatSpecDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPPATSPECDI= "Id_hppatspecdi";
	public static final String ID_HPPATSPEC= "Id_hppatspec";
	public static final String CODE_DI= "Code_di";
	public static final String NAME_DI= "Name_di";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hppatspecdi() {
		return ((String) getAttrVal("Id_hppatspecdi"));
	}	
	public void setId_hppatspecdi(String Id_hppatspecdi) {
		setAttrVal("Id_hppatspecdi", Id_hppatspecdi);
	}
	public String getId_hppatspec() {
		return ((String) getAttrVal("Id_hppatspec"));
	}	
	public void setId_hppatspec(String Id_hppatspec) {
		setAttrVal("Id_hppatspec", Id_hppatspec);
	}
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
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
		return "Id_hppatspecdi";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_pat_spec_di";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlHpPatSpecDiDODesc.class);
	}
	
}