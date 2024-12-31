package iih.pe.pbd.pelockerroom.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pelockerroom.d.desc.PeLockerRoomDODesc;
import java.math.BigDecimal;

/**
 * 体检中心更衣室维护 DO数据 
 * 
 */
public class PeLockerRoomDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PELOCKERROOM= "Id_pelockerroom";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String AREA= "Area";
	public static final String SEXLIMIT= "Sexlimit";
	public static final String CLOTHESSIZE= "Clothessize";
	public static final String LOCKER_POS= "Locker_pos";
	public static final String FG_UPDOWN= "Fg_updown";
	public static final String SORTNO= "Sortno";
	public static final String RMK= "Rmk";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pelockerroom() {
		return ((String) getAttrVal("Id_pelockerroom"));
	}	
	public void setId_pelockerroom(String Id_pelockerroom) {
		setAttrVal("Id_pelockerroom", Id_pelockerroom);
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
	public String getArea() {
		return ((String) getAttrVal("Area"));
	}	
	public void setArea(String Area) {
		setAttrVal("Area", Area);
	}
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	public String getClothessize() {
		return ((String) getAttrVal("Clothessize"));
	}	
	public void setClothessize(String Clothessize) {
		setAttrVal("Clothessize", Clothessize);
	}
	public String getLocker_pos() {
		return ((String) getAttrVal("Locker_pos"));
	}	
	public void setLocker_pos(String Locker_pos) {
		setAttrVal("Locker_pos", Locker_pos);
	}
	public FDouble getFg_updown() {
		return ((FDouble) getAttrVal("Fg_updown"));
	}	
	public void setFg_updown(FDouble Fg_updown) {
		setAttrVal("Fg_updown", Fg_updown);
	}
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getRmk() {
		return ((String) getAttrVal("Rmk"));
	}	
	public void setRmk(String Rmk) {
		setAttrVal("Rmk", Rmk);
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
		return "Id_pelockerroom";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_pelockerroom";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeLockerRoomDODesc.class);
	}
	
}