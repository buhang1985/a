package iih.pe.pbd.pewfregqueuedef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pewfregqueuedef.d.desc.PeWfRegQDefDODesc;
import java.math.BigDecimal;

/**
 * 体检登记队列定义 DO数据 
 * 
 */
public class PeWfRegQDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEWFREGQDEF= "Id_pewfregqdef";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String QUEUEST= "Queuest";
	public static final String QUEUECA= "Queueca";
	public static final String CAPACITY= "Capacity";
	public static final String SEGMENT= "Segment";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pewfregqdef() {
		return ((String) getAttrVal("Id_pewfregqdef"));
	}	
	public void setId_pewfregqdef(String Id_pewfregqdef) {
		setAttrVal("Id_pewfregqdef", Id_pewfregqdef);
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
	public FBoolean getQueuest() {
		return ((FBoolean) getAttrVal("Queuest"));
	}	
	public void setQueuest(FBoolean Queuest) {
		setAttrVal("Queuest", Queuest);
	}
	public Integer getQueueca() {
		return ((Integer) getAttrVal("Queueca"));
	}	
	public void setQueueca(Integer Queueca) {
		setAttrVal("Queueca", Queueca);
	}
	public Integer getCapacity() {
		return ((Integer) getAttrVal("Capacity"));
	}	
	public void setCapacity(Integer Capacity) {
		setAttrVal("Capacity", Capacity);
	}
	public Integer getSegment() {
		return ((Integer) getAttrVal("Segment"));
	}	
	public void setSegment(Integer Segment) {
		setAttrVal("Segment", Segment);
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
		return "Id_pewfregqdef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_pewfregqdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeWfRegQDefDODesc.class);
	}
	
}