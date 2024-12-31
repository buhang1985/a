package iih.nmr.pkuf.nmrbase.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.nmrbase.d.desc.NmrBaseAttrDODesc;
import java.math.BigDecimal;

/**
 * 文书基础属性动作 DO数据 
 * 
 */
public class NmrBaseAttrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NMR_BASE_ATTR= "Id_nmr_base_attr";
	public static final String ID_NMR_BASE= "Id_nmr_base";
	public static final String ID_ATTR_ACTION= "Id_attr_action";
	public static final String SD_ATTR_ACTION= "Sd_attr_action";
	public static final String ID_DE= "Id_de";
	public static final String ID_VALTP_NATIONAL= "Id_valtp_national";
	public static final String SD_VALTP_NATIONAL= "Sd_valtp_national";
	public static final String NAME_ATTR= "Name_attr";
	public static final String FG_REF= "Fg_ref";
	public static final String FG_READONLY= "Fg_readonly";
	public static final String ID_QUOTE= "Id_quote";
	public static final String SD_QUOTE= "Sd_quote";
	public static final String ID_DEFAULT= "Id_default";
	public static final String NAME_DEFAULT= "Name_default";
	public static final String SD_DEFAULT= "Sd_default";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FIELDNAME= "Fieldname";
	public static final String NAME_NMR_DOC= "Name_nmr_doc";
	public static final String NAME_ATTR_ACTION= "Name_attr_action";
	public static final String NAME_DE= "Name_de";
	public static final String NAME_VALTP_NATIONAL= "Name_valtp_national";
	public static final String NAME_QUOTE= "Name_quote";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nmr_base_attr() {
		return ((String) getAttrVal("Id_nmr_base_attr"));
	}	
	public void setId_nmr_base_attr(String Id_nmr_base_attr) {
		setAttrVal("Id_nmr_base_attr", Id_nmr_base_attr);
	}
	public String getId_nmr_base() {
		return ((String) getAttrVal("Id_nmr_base"));
	}	
	public void setId_nmr_base(String Id_nmr_base) {
		setAttrVal("Id_nmr_base", Id_nmr_base);
	}
	public String getId_attr_action() {
		return ((String) getAttrVal("Id_attr_action"));
	}	
	public void setId_attr_action(String Id_attr_action) {
		setAttrVal("Id_attr_action", Id_attr_action);
	}
	public String getSd_attr_action() {
		return ((String) getAttrVal("Sd_attr_action"));
	}	
	public void setSd_attr_action(String Sd_attr_action) {
		setAttrVal("Sd_attr_action", Sd_attr_action);
	}
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	public String getId_valtp_national() {
		return ((String) getAttrVal("Id_valtp_national"));
	}	
	public void setId_valtp_national(String Id_valtp_national) {
		setAttrVal("Id_valtp_national", Id_valtp_national);
	}
	public String getSd_valtp_national() {
		return ((String) getAttrVal("Sd_valtp_national"));
	}	
	public void setSd_valtp_national(String Sd_valtp_national) {
		setAttrVal("Sd_valtp_national", Sd_valtp_national);
	}
	public String getName_attr() {
		return ((String) getAttrVal("Name_attr"));
	}	
	public void setName_attr(String Name_attr) {
		setAttrVal("Name_attr", Name_attr);
	}
	public FBoolean getFg_ref() {
		return ((FBoolean) getAttrVal("Fg_ref"));
	}	
	public void setFg_ref(FBoolean Fg_ref) {
		setAttrVal("Fg_ref", Fg_ref);
	}
	public FBoolean getFg_readonly() {
		return ((FBoolean) getAttrVal("Fg_readonly"));
	}	
	public void setFg_readonly(FBoolean Fg_readonly) {
		setAttrVal("Fg_readonly", Fg_readonly);
	}
	public String getId_quote() {
		return ((String) getAttrVal("Id_quote"));
	}	
	public void setId_quote(String Id_quote) {
		setAttrVal("Id_quote", Id_quote);
	}
	public String getSd_quote() {
		return ((String) getAttrVal("Sd_quote"));
	}	
	public void setSd_quote(String Sd_quote) {
		setAttrVal("Sd_quote", Sd_quote);
	}
	public String getId_default() {
		return ((String) getAttrVal("Id_default"));
	}	
	public void setId_default(String Id_default) {
		setAttrVal("Id_default", Id_default);
	}
	public String getName_default() {
		return ((String) getAttrVal("Name_default"));
	}	
	public void setName_default(String Name_default) {
		setAttrVal("Name_default", Name_default);
	}
	public String getSd_default() {
		return ((String) getAttrVal("Sd_default"));
	}	
	public void setSd_default(String Sd_default) {
		setAttrVal("Sd_default", Sd_default);
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
	public String getFieldname() {
		return ((String) getAttrVal("Fieldname"));
	}	
	public void setFieldname(String Fieldname) {
		setAttrVal("Fieldname", Fieldname);
	}
	public String getName_nmr_doc() {
		return ((String) getAttrVal("Name_nmr_doc"));
	}	
	public void setName_nmr_doc(String Name_nmr_doc) {
		setAttrVal("Name_nmr_doc", Name_nmr_doc);
	}
	public String getName_attr_action() {
		return ((String) getAttrVal("Name_attr_action"));
	}	
	public void setName_attr_action(String Name_attr_action) {
		setAttrVal("Name_attr_action", Name_attr_action);
	}
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}	
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
	}
	public String getName_valtp_national() {
		return ((String) getAttrVal("Name_valtp_national"));
	}	
	public void setName_valtp_national(String Name_valtp_national) {
		setAttrVal("Name_valtp_national", Name_valtp_national);
	}
	public String getName_quote() {
		return ((String) getAttrVal("Name_quote"));
	}	
	public void setName_quote(String Name_quote) {
		setAttrVal("Name_quote", Name_quote);
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
		return "Id_nmr_base_attr";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_BASE_ATTR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmrBaseAttrDODesc.class);
	}
	
}