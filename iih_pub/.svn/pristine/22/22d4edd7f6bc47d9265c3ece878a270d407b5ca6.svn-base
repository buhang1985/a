package iih.pis.phk.enguidmodtabdo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.phk.enguidmodtabdo.d.desc.EnGuidModTabDODesc;
import java.math.BigDecimal;

/**
 * 导诊模块页签配置 DO数据 
 * 
 */
public class EnGuidModTabDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_GUIDTAB= "Id_guidtab";
	public static final String ID_GUIDCOF= "Id_guidcof";
	public static final String CODE_TAB= "Code_tab";
	public static final String NAME_TAB= "Name_tab";
	public static final String IMG_TAB= "Img_tab";
	public static final String TEXT_TAB= "Text_tab";
	public static final String QRYSQL= "Qrysql";
	public static final String SEVICE= "Sevice";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String NAME_MOD= "Name_mod";
	public static final String CODE_MOD= "Code_mod";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_guidtab() {
		return ((String) getAttrVal("Id_guidtab"));
	}	
	public void setId_guidtab(String Id_guidtab) {
		setAttrVal("Id_guidtab", Id_guidtab);
	}
	public String getId_guidcof() {
		return ((String) getAttrVal("Id_guidcof"));
	}	
	public void setId_guidcof(String Id_guidcof) {
		setAttrVal("Id_guidcof", Id_guidcof);
	}
	public String getCode_tab() {
		return ((String) getAttrVal("Code_tab"));
	}	
	public void setCode_tab(String Code_tab) {
		setAttrVal("Code_tab", Code_tab);
	}
	public String getName_tab() {
		return ((String) getAttrVal("Name_tab"));
	}	
	public void setName_tab(String Name_tab) {
		setAttrVal("Name_tab", Name_tab);
	}
	public byte[] getImg_tab() {
		return ((byte[]) getAttrVal("Img_tab"));
	}	
	public void setImg_tab(byte[] Img_tab) {
		setAttrVal("Img_tab", Img_tab);
	}
	public String getText_tab() {
		return ((String) getAttrVal("Text_tab"));
	}	
	public void setText_tab(String Text_tab) {
		setAttrVal("Text_tab", Text_tab);
	}
	public String getQrysql() {
		return ((String) getAttrVal("Qrysql"));
	}	
	public void setQrysql(String Qrysql) {
		setAttrVal("Qrysql", Qrysql);
	}
	public String getSevice() {
		return ((String) getAttrVal("Sevice"));
	}	
	public void setSevice(String Sevice) {
		setAttrVal("Sevice", Sevice);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getName_mod() {
		return ((String) getAttrVal("Name_mod"));
	}	
	public void setName_mod(String Name_mod) {
		setAttrVal("Name_mod", Name_mod);
	}
	public String getCode_mod() {
		return ((String) getAttrVal("Code_mod"));
	}	
	public void setCode_mod(String Code_mod) {
		setAttrVal("Code_mod", Code_mod);
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
		return "Id_guidtab";
	}
	
	@Override
	public String getTableName() {	  
		return "en_guid_mode_tab";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnGuidModTabDODesc.class);
	}
	
}