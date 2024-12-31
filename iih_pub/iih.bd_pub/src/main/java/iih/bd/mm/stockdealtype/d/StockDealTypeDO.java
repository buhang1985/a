package iih.bd.mm.stockdealtype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.stockdealtype.d.desc.StockDealTypeDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_库存交易分类 DO数据 
 * 
 */
public class StockDealTypeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MMSTCA= "Id_mmstca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_STTP= "Id_sttp";
	public static final String SD_STTP= "Sd_sttp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String INSTR= "Instr";
	public static final String ID_DIRECT= "Id_direct";
	public static final String SD_DIRECT= "Sd_direct";
	public static final String ID_MMTP= "Id_mmtp";
	public static final String SD_MMTP= "Sd_mmtp";
	public static final String FLAG_SYS= "Flag_sys";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_NAME= "Org_name";
	public static final String STTP_NAME= "Sttp_name";
	public static final String DIRECT_NAME= "Direct_name";
	public static final String MMTP_NAME= "Mmtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mmstca() {
		return ((String) getAttrVal("Id_mmstca"));
	}	
	public void setId_mmstca(String Id_mmstca) {
		setAttrVal("Id_mmstca", Id_mmstca);
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
	public String getId_sttp() {
		return ((String) getAttrVal("Id_sttp"));
	}	
	public void setId_sttp(String Id_sttp) {
		setAttrVal("Id_sttp", Id_sttp);
	}
	public String getSd_sttp() {
		return ((String) getAttrVal("Sd_sttp"));
	}	
	public void setSd_sttp(String Sd_sttp) {
		setAttrVal("Sd_sttp", Sd_sttp);
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
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}	
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
	}
	public String getId_direct() {
		return ((String) getAttrVal("Id_direct"));
	}	
	public void setId_direct(String Id_direct) {
		setAttrVal("Id_direct", Id_direct);
	}
	public String getSd_direct() {
		return ((String) getAttrVal("Sd_direct"));
	}	
	public void setSd_direct(String Sd_direct) {
		setAttrVal("Sd_direct", Sd_direct);
	}
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}	
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}	
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	public FBoolean getFlag_sys() {
		return ((FBoolean) getAttrVal("Flag_sys"));
	}	
	public void setFlag_sys(FBoolean Flag_sys) {
		setAttrVal("Flag_sys", Flag_sys);
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
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getSttp_name() {
		return ((String) getAttrVal("Sttp_name"));
	}	
	public void setSttp_name(String Sttp_name) {
		setAttrVal("Sttp_name", Sttp_name);
	}
	public String getDirect_name() {
		return ((String) getAttrVal("Direct_name"));
	}	
	public void setDirect_name(String Direct_name) {
		setAttrVal("Direct_name", Direct_name);
	}
	public String getMmtp_name() {
		return ((String) getAttrVal("Mmtp_name"));
	}	
	public void setMmtp_name(String Mmtp_name) {
		setAttrVal("Mmtp_name", Mmtp_name);
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
		return "Id_mmstca";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_STCA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockDealTypeDODesc.class);
	}
	
}