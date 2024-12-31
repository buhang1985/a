package iih.mm.qy.stockdealtypeconfig.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.stockdealtypeconfig.d.desc.StockDealTypeConfigDODesc;
import java.math.BigDecimal;

/**
 * 库存交易分类方案 DO数据 
 * 
 */
public class StockDealTypeConfigDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SDT= "Id_sdt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME= "Name";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String SUM_NAME= "Sum_name";
	public static final String DIRECTION= "Direction";
	public static final String TYPE_CODE= "Type_code";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_sdt() {
		return ((String) getAttrVal("Id_sdt"));
	}	
	public void setId_sdt(String Id_sdt) {
		setAttrVal("Id_sdt", Id_sdt);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getSum_name() {
		return ((String) getAttrVal("Sum_name"));
	}	
	public void setSum_name(String Sum_name) {
		setAttrVal("Sum_name", Sum_name);
	}
	public String getDirection() {
		return ((String) getAttrVal("Direction"));
	}	
	public void setDirection(String Direction) {
		setAttrVal("Direction", Direction);
	}
	public String getType_code() {
		return ((String) getAttrVal("Type_code"));
	}	
	public void setType_code(String Type_code) {
		setAttrVal("Type_code", Type_code);
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
		return "Id_sdt";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_SDT_CONFIG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockDealTypeConfigDODesc.class);
	}
	
}