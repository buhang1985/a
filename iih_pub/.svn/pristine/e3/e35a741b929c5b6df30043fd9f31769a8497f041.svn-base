package iih.pe.pbd.pegreenchannel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pegreenchannel.d.desc.PeGreenChannelDODesc;
import java.math.BigDecimal;

/**
 * 体检就医绿色通道定义 DO数据 
 * 
 */
public class PeGreenChannelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEGREENCHANNEL= "Id_pegreenchannel";
	public static final String ID_PEGREENCHANNEL_PAR= "Id_pegreenchannel_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String CONTACTS= "Contacts";
	public static final String MOB= "Mob";
	public static final String ADDR= "Addr";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pegreenchannel() {
		return ((String) getAttrVal("Id_pegreenchannel"));
	}	
	public void setId_pegreenchannel(String Id_pegreenchannel) {
		setAttrVal("Id_pegreenchannel", Id_pegreenchannel);
	}
	public String getId_pegreenchannel_par() {
		return ((String) getAttrVal("Id_pegreenchannel_par"));
	}	
	public void setId_pegreenchannel_par(String Id_pegreenchannel_par) {
		setAttrVal("Id_pegreenchannel_par", Id_pegreenchannel_par);
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
	public String getContacts() {
		return ((String) getAttrVal("Contacts"));
	}	
	public void setContacts(String Contacts) {
		setAttrVal("Contacts", Contacts);
	}
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}	
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
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
		return "Id_pegreenchannel";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_pegreenchannel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeGreenChannelDODesc.class);
	}
	
}