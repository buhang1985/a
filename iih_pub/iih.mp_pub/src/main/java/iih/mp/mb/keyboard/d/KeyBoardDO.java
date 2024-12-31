package iih.mp.mb.keyboard.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mb.keyboard.d.desc.KeyBoardDODesc;
import java.math.BigDecimal;

/**
 * 移动护理键盘 DO数据 
 * 
 */
public class KeyBoardDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MB_KB= "Id_mb_kb";
	public static final String KEYBOARDID= "Keyboardid";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String KEYBOARDNAME= "Keyboardname";
	public static final String KEYBOARDTYPE= "Keyboardtype";
	public static final String JUMPCONDITION= "Jumpcondition";
	public static final String MIN= "Min";
	public static final String MAX= "Max";
	public static final String PAGES= "Pages";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_DEF= "Fg_def";
	public static final String ID_AUX= "Id_aux";
	public static final String SD_AUX= "Sd_aux";
	public static final String NAME_AUX= "Name_aux";
	public static final String CODE_AUX= "Code_aux";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mb_kb() {
		return ((String) getAttrVal("Id_mb_kb"));
	}	
	public void setId_mb_kb(String Id_mb_kb) {
		setAttrVal("Id_mb_kb", Id_mb_kb);
	}
	public Integer getKeyboardid() {
		return ((Integer) getAttrVal("Keyboardid"));
	}	
	public void setKeyboardid(Integer Keyboardid) {
		setAttrVal("Keyboardid", Keyboardid);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getKeyboardname() {
		return ((String) getAttrVal("Keyboardname"));
	}	
	public void setKeyboardname(String Keyboardname) {
		setAttrVal("Keyboardname", Keyboardname);
	}
	public String getKeyboardtype() {
		return ((String) getAttrVal("Keyboardtype"));
	}	
	public void setKeyboardtype(String Keyboardtype) {
		setAttrVal("Keyboardtype", Keyboardtype);
	}
	public Integer getJumpcondition() {
		return ((Integer) getAttrVal("Jumpcondition"));
	}	
	public void setJumpcondition(Integer Jumpcondition) {
		setAttrVal("Jumpcondition", Jumpcondition);
	}
	public FDouble getMin() {
		return ((FDouble) getAttrVal("Min"));
	}	
	public void setMin(FDouble Min) {
		setAttrVal("Min", Min);
	}
	public FDouble getMax() {
		return ((FDouble) getAttrVal("Max"));
	}	
	public void setMax(FDouble Max) {
		setAttrVal("Max", Max);
	}
	public String getPages() {
		return ((String) getAttrVal("Pages"));
	}	
	public void setPages(String Pages) {
		setAttrVal("Pages", Pages);
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
	public FBoolean getFg_def() {
		return ((FBoolean) getAttrVal("Fg_def"));
	}	
	public void setFg_def(FBoolean Fg_def) {
		setAttrVal("Fg_def", Fg_def);
	}
	public String getId_aux() {
		return ((String) getAttrVal("Id_aux"));
	}	
	public void setId_aux(String Id_aux) {
		setAttrVal("Id_aux", Id_aux);
	}
	public String getSd_aux() {
		return ((String) getAttrVal("Sd_aux"));
	}	
	public void setSd_aux(String Sd_aux) {
		setAttrVal("Sd_aux", Sd_aux);
	}
	public String getName_aux() {
		return ((String) getAttrVal("Name_aux"));
	}	
	public void setName_aux(String Name_aux) {
		setAttrVal("Name_aux", Name_aux);
	}
	public String getCode_aux() {
		return ((String) getAttrVal("Code_aux"));
	}	
	public void setCode_aux(String Code_aux) {
		setAttrVal("Code_aux", Code_aux);
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
		return "Id_mb_kb";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_mb_kb";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(KeyBoardDODesc.class);
	}
	
}