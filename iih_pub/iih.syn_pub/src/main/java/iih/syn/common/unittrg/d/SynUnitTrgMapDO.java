package iih.syn.common.unittrg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.syn.common.unittrg.d.desc.SynUnitTrgMapDODesc;
import java.math.BigDecimal;

/**
 * 数据同步对照 DO数据 
 * 
 */
public class SynUnitTrgMapDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_UNIT_TRG_MAP= "Id_unit_trg_map";
	public static final String ID_UNIT_TRG= "Id_unit_trg";
	public static final String ID_UNIT= "Id_unit";
	public static final String ID_PROP_SRC= "Id_prop_src";
	public static final String NAME_PROP_SRC= "Name_prop_src";
	public static final String ID_PROP_TRG= "Id_prop_trg";
	public static final String NAME_PROP_TRG= "Name_prop_trg";
	public static final String FG_CMPR= "Fg_cmpr";
	public static final String ID_MDM_CA= "Id_mdm_ca";
	public static final String ID_PROP_TRG_KEY= "Id_prop_trg_key";
	public static final String NAME_PROP_TRG_KEY= "Name_prop_trg_key";
	public static final String VAL_DEF= "Val_def";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ATTRSRC= "Name_attrsrc";
	public static final String SEQNO_ATTRSRC= "Seqno_attrsrc";
	public static final String NAME_ATTRTRG= "Name_attrtrg";
	public static final String NAME_MDMCA= "Name_mdmca";
	public static final String DISPLAYNAME_PROPTRG_KEY= "Displayname_proptrg_key";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_unit_trg_map() {
		return ((String) getAttrVal("Id_unit_trg_map"));
	}	
	public void setId_unit_trg_map(String Id_unit_trg_map) {
		setAttrVal("Id_unit_trg_map", Id_unit_trg_map);
	}
	public String getId_unit_trg() {
		return ((String) getAttrVal("Id_unit_trg"));
	}	
	public void setId_unit_trg(String Id_unit_trg) {
		setAttrVal("Id_unit_trg", Id_unit_trg);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public String getId_prop_src() {
		return ((String) getAttrVal("Id_prop_src"));
	}	
	public void setId_prop_src(String Id_prop_src) {
		setAttrVal("Id_prop_src", Id_prop_src);
	}
	public String getName_prop_src() {
		return ((String) getAttrVal("Name_prop_src"));
	}	
	public void setName_prop_src(String Name_prop_src) {
		setAttrVal("Name_prop_src", Name_prop_src);
	}
	public String getId_prop_trg() {
		return ((String) getAttrVal("Id_prop_trg"));
	}	
	public void setId_prop_trg(String Id_prop_trg) {
		setAttrVal("Id_prop_trg", Id_prop_trg);
	}
	public String getName_prop_trg() {
		return ((String) getAttrVal("Name_prop_trg"));
	}	
	public void setName_prop_trg(String Name_prop_trg) {
		setAttrVal("Name_prop_trg", Name_prop_trg);
	}
	public FBoolean getFg_cmpr() {
		return ((FBoolean) getAttrVal("Fg_cmpr"));
	}	
	public void setFg_cmpr(FBoolean Fg_cmpr) {
		setAttrVal("Fg_cmpr", Fg_cmpr);
	}
	public String getId_mdm_ca() {
		return ((String) getAttrVal("Id_mdm_ca"));
	}	
	public void setId_mdm_ca(String Id_mdm_ca) {
		setAttrVal("Id_mdm_ca", Id_mdm_ca);
	}
	public String getId_prop_trg_key() {
		return ((String) getAttrVal("Id_prop_trg_key"));
	}	
	public void setId_prop_trg_key(String Id_prop_trg_key) {
		setAttrVal("Id_prop_trg_key", Id_prop_trg_key);
	}
	public String getName_prop_trg_key() {
		return ((String) getAttrVal("Name_prop_trg_key"));
	}	
	public void setName_prop_trg_key(String Name_prop_trg_key) {
		setAttrVal("Name_prop_trg_key", Name_prop_trg_key);
	}
	public String getVal_def() {
		return ((String) getAttrVal("Val_def"));
	}	
	public void setVal_def(String Val_def) {
		setAttrVal("Val_def", Val_def);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	public String getName_attrsrc() {
		return ((String) getAttrVal("Name_attrsrc"));
	}	
	public void setName_attrsrc(String Name_attrsrc) {
		setAttrVal("Name_attrsrc", Name_attrsrc);
	}
	public Integer getSeqno_attrsrc() {
		return ((Integer) getAttrVal("Seqno_attrsrc"));
	}	
	public void setSeqno_attrsrc(Integer Seqno_attrsrc) {
		setAttrVal("Seqno_attrsrc", Seqno_attrsrc);
	}
	public String getName_attrtrg() {
		return ((String) getAttrVal("Name_attrtrg"));
	}	
	public void setName_attrtrg(String Name_attrtrg) {
		setAttrVal("Name_attrtrg", Name_attrtrg);
	}
	public String getName_mdmca() {
		return ((String) getAttrVal("Name_mdmca"));
	}	
	public void setName_mdmca(String Name_mdmca) {
		setAttrVal("Name_mdmca", Name_mdmca);
	}
	public String getDisplayname_proptrg_key() {
		return ((String) getAttrVal("Displayname_proptrg_key"));
	}	
	public void setDisplayname_proptrg_key(String Displayname_proptrg_key) {
		setAttrVal("Displayname_proptrg_key", Displayname_proptrg_key);
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
		return "Id_unit_trg_map";
	}
	
	@Override
	public String getTableName() {	  
		return "SYN_UNIT_TRG_MAP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SynUnitTrgMapDODesc.class);
	}
	
}