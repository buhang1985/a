package iih.pis.phk.enguidmoddo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.phk.enguidmoddo.d.desc.EnGuidModDODesc;
import java.math.BigDecimal;

/**
 * 导诊模块 DO数据 
 * 
 */
public class EnGuidModDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_GUIDCOF= "Id_guidcof";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String NAME_ENGLISH= "Name_english";
	public static final String IMG_MODEL= "Img_model";
	public static final String COL_MODEL= "Col_model";
	public static final String TYPE= "Type";
	public static final String NOTE= "Note";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_guidcof() {
		return ((String) getAttrVal("Id_guidcof"));
	}	
	public void setId_guidcof(String Id_guidcof) {
		setAttrVal("Id_guidcof", Id_guidcof);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getName_english() {
		return ((String) getAttrVal("Name_english"));
	}	
	public void setName_english(String Name_english) {
		setAttrVal("Name_english", Name_english);
	}
	public byte[] getImg_model() {
		return ((byte[]) getAttrVal("Img_model"));
	}	
	public void setImg_model(byte[] Img_model) {
		setAttrVal("Img_model", Img_model);
	}
	public String getCol_model() {
		return ((String) getAttrVal("Col_model"));
	}	
	public void setCol_model(String Col_model) {
		setAttrVal("Col_model", Col_model);
	}
	public Integer getType() {
		return ((Integer) getAttrVal("Type"));
	}	
	public void setType(Integer Type) {
		setAttrVal("Type", Type);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
		return "Id_guidcof";
	}
	
	@Override
	public String getTableName() {	  
		return "en_guid_mod";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnGuidModDODesc.class);
	}
	
}