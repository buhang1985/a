package iih.mp.mb.keyboard.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mb.keyboard.d.desc.KeyBoardSrvDODesc;
import java.math.BigDecimal;

/**
 * 键盘所属服务 DO数据 
 * 
 */
public class KeyBoardSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MB_KB_SRV= "Id_mb_kb_srv";
	public static final String ID_MB_KB= "Id_mb_kb";
	public static final String ID_MRTPL_VS_ITM= "Id_mrtpl_vs_itm";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MRTPL_VS_ITM= "Name_mrtpl_vs_itm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mb_kb_srv() {
		return ((String) getAttrVal("Id_mb_kb_srv"));
	}	
	public void setId_mb_kb_srv(String Id_mb_kb_srv) {
		setAttrVal("Id_mb_kb_srv", Id_mb_kb_srv);
	}
	public String getId_mb_kb() {
		return ((String) getAttrVal("Id_mb_kb"));
	}	
	public void setId_mb_kb(String Id_mb_kb) {
		setAttrVal("Id_mb_kb", Id_mb_kb);
	}
	public String getId_mrtpl_vs_itm() {
		return ((String) getAttrVal("Id_mrtpl_vs_itm"));
	}	
	public void setId_mrtpl_vs_itm(String Id_mrtpl_vs_itm) {
		setAttrVal("Id_mrtpl_vs_itm", Id_mrtpl_vs_itm);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	public String getName_mrtpl_vs_itm() {
		return ((String) getAttrVal("Name_mrtpl_vs_itm"));
	}	
	public void setName_mrtpl_vs_itm(String Name_mrtpl_vs_itm) {
		setAttrVal("Name_mrtpl_vs_itm", Name_mrtpl_vs_itm);
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
		return "Id_mb_kb_srv";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_mb_kb_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(KeyBoardSrvDODesc.class);
	}
	
}