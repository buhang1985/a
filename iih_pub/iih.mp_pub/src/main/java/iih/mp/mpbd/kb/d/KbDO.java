package iih.mp.mpbd.kb.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.kb.d.desc.KbDODesc;
import java.math.BigDecimal;

/**
 * 键盘 DO数据 
 * 
 */
public class KbDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_KB= "Id_kb";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_DATATP= "Id_datatp";
	public static final String SD_DATATP= "Sd_datatp";
	public static final String VAL_MIN= "Val_min";
	public static final String VAL_MAX= "Val_max";
	public static final String ID_KBTP= "Id_kbtp";
	public static final String SD_KBTP= "Sd_kbtp";
	public static final String NUM_ROW= "Num_row";
	public static final String NUM_COLUM= "Num_colum";
	public static final String ID_UDIDOCLIST= "Id_udidoclist";
	public static final String INDEX_JUMP= "Index_jump";
	public static final String EU_SELECT= "Eu_select";
	public static final String FG_SYS= "Fg_sys";
	public static final String ID_UDIDOC= "Id_udidoc";
	public static final String SD_DOC= "Sd_doc";
	public static final String NAME_DATATP= "Name_datatp";
	public static final String NAME_KBTP= "Name_kbtp";
	public static final String NAME_UDI= "Name_udi";
	public static final String NAME_DOC= "Name_doc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_kb() {
		return ((String) getAttrVal("Id_kb"));
	}	
	public void setId_kb(String Id_kb) {
		setAttrVal("Id_kb", Id_kb);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	public String getId_datatp() {
		return ((String) getAttrVal("Id_datatp"));
	}	
	public void setId_datatp(String Id_datatp) {
		setAttrVal("Id_datatp", Id_datatp);
	}
	public String getSd_datatp() {
		return ((String) getAttrVal("Sd_datatp"));
	}	
	public void setSd_datatp(String Sd_datatp) {
		setAttrVal("Sd_datatp", Sd_datatp);
	}
	public FDouble getVal_min() {
		return ((FDouble) getAttrVal("Val_min"));
	}	
	public void setVal_min(FDouble Val_min) {
		setAttrVal("Val_min", Val_min);
	}
	public FDouble getVal_max() {
		return ((FDouble) getAttrVal("Val_max"));
	}	
	public void setVal_max(FDouble Val_max) {
		setAttrVal("Val_max", Val_max);
	}
	public String getId_kbtp() {
		return ((String) getAttrVal("Id_kbtp"));
	}	
	public void setId_kbtp(String Id_kbtp) {
		setAttrVal("Id_kbtp", Id_kbtp);
	}
	public String getSd_kbtp() {
		return ((String) getAttrVal("Sd_kbtp"));
	}	
	public void setSd_kbtp(String Sd_kbtp) {
		setAttrVal("Sd_kbtp", Sd_kbtp);
	}
	public Integer getNum_row() {
		return ((Integer) getAttrVal("Num_row"));
	}	
	public void setNum_row(Integer Num_row) {
		setAttrVal("Num_row", Num_row);
	}
	public Integer getNum_colum() {
		return ((Integer) getAttrVal("Num_colum"));
	}	
	public void setNum_colum(Integer Num_colum) {
		setAttrVal("Num_colum", Num_colum);
	}
	public String getId_udidoclist() {
		return ((String) getAttrVal("Id_udidoclist"));
	}	
	public void setId_udidoclist(String Id_udidoclist) {
		setAttrVal("Id_udidoclist", Id_udidoclist);
	}
	public String getIndex_jump() {
		return ((String) getAttrVal("Index_jump"));
	}	
	public void setIndex_jump(String Index_jump) {
		setAttrVal("Index_jump", Index_jump);
	}
	public Integer getEu_select() {
		return ((Integer) getAttrVal("Eu_select"));
	}	
	public void setEu_select(Integer Eu_select) {
		setAttrVal("Eu_select", Eu_select);
	}
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	public String getId_udidoc() {
		return ((String) getAttrVal("Id_udidoc"));
	}	
	public void setId_udidoc(String Id_udidoc) {
		setAttrVal("Id_udidoc", Id_udidoc);
	}
	public String getSd_doc() {
		return ((String) getAttrVal("Sd_doc"));
	}	
	public void setSd_doc(String Sd_doc) {
		setAttrVal("Sd_doc", Sd_doc);
	}
	public String getName_datatp() {
		return ((String) getAttrVal("Name_datatp"));
	}	
	public void setName_datatp(String Name_datatp) {
		setAttrVal("Name_datatp", Name_datatp);
	}
	public String getName_kbtp() {
		return ((String) getAttrVal("Name_kbtp"));
	}	
	public void setName_kbtp(String Name_kbtp) {
		setAttrVal("Name_kbtp", Name_kbtp);
	}
	public String getName_udi() {
		return ((String) getAttrVal("Name_udi"));
	}	
	public void setName_udi(String Name_udi) {
		setAttrVal("Name_udi", Name_udi);
	}
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}	
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
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
		return "Id_kb";
	}
	
	@Override
	public String getTableName() {	  
		return "Mp_kb";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(KbDODesc.class);
	}
	
}