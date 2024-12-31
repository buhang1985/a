package iih.pe.pitm.pesrvitemroom.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitemroom.d.desc.PeSrvitmRoomDODesc;
import java.math.BigDecimal;

/**
 * 体检诊间项目设定 DO数据 
 * 
 */
public class PeSrvitmRoomDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PESRVITEMROOM= "Id_pesrvitemroom";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	public static final String ID_PEDIROOM= "Id_pediroom";
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	public static final String REL= "Rel";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_DEP= "Code_dep";
	public static final String NAME_DEP= "Name_dep";
	public static final String CODE_ROOM= "Code_room";
	public static final String NAME_ROOM= "Name_room";
	public static final String CODE_PESRVITM= "Code_pesrvitm";
	public static final String NAME_PESRVITM= "Name_pesrvitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pesrvitemroom() {
		return ((String) getAttrVal("Id_pesrvitemroom"));
	}	
	public void setId_pesrvitemroom(String Id_pesrvitemroom) {
		setAttrVal("Id_pesrvitemroom", Id_pesrvitemroom);
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
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	public String getId_pediroom() {
		return ((String) getAttrVal("Id_pediroom"));
	}	
	public void setId_pediroom(String Id_pediroom) {
		setAttrVal("Id_pediroom", Id_pediroom);
	}
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	public Integer getRel() {
		return ((Integer) getAttrVal("Rel"));
	}	
	public void setRel(Integer Rel) {
		setAttrVal("Rel", Rel);
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
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getCode_room() {
		return ((String) getAttrVal("Code_room"));
	}	
	public void setCode_room(String Code_room) {
		setAttrVal("Code_room", Code_room);
	}
	public String getName_room() {
		return ((String) getAttrVal("Name_room"));
	}	
	public void setName_room(String Name_room) {
		setAttrVal("Name_room", Name_room);
	}
	public String getCode_pesrvitm() {
		return ((String) getAttrVal("Code_pesrvitm"));
	}	
	public void setCode_pesrvitm(String Code_pesrvitm) {
		setAttrVal("Code_pesrvitm", Code_pesrvitm);
	}
	public String getName_pesrvitm() {
		return ((String) getAttrVal("Name_pesrvitm"));
	}	
	public void setName_pesrvitm(String Name_pesrvitm) {
		setAttrVal("Name_pesrvitm", Name_pesrvitm);
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
		return "Id_pesrvitemroom";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvitmroom";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvitmRoomDODesc.class);
	}
	
}