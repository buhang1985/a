package iih.pe.pitm.penhcposi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.penhcposi.d.desc.PeNhcPosiDODesc;
import java.math.BigDecimal;

/**
 * 体检报表卫生局阳性统计 DO数据 
 * 
 */
public class PeNhcPosiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PENHCPOSI= "Id_penhcposi";
	public static final String ID_PENHCPOSI_PAR= "Id_penhcposi_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String SEXLIMIT= "Sexlimit";
	public static final String SUMTP= "Sumtp";
	public static final String ID_ILLNESS= "Id_illness";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_POSI= "Code_posi";
	public static final String NAME_POSI= "Name_posi";
	public static final String CODE_ILLNESS= "Code_illness";
	public static final String NAME_ILLNESS= "Name_illness";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_penhcposi() {
		return ((String) getAttrVal("Id_penhcposi"));
	}	
	public void setId_penhcposi(String Id_penhcposi) {
		setAttrVal("Id_penhcposi", Id_penhcposi);
	}
	public String getId_penhcposi_par() {
		return ((String) getAttrVal("Id_penhcposi_par"));
	}	
	public void setId_penhcposi_par(String Id_penhcposi_par) {
		setAttrVal("Id_penhcposi_par", Id_penhcposi_par);
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
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	public Integer getSumtp() {
		return ((Integer) getAttrVal("Sumtp"));
	}	
	public void setSumtp(Integer Sumtp) {
		setAttrVal("Sumtp", Sumtp);
	}
	public String getId_illness() {
		return ((String) getAttrVal("Id_illness"));
	}	
	public void setId_illness(String Id_illness) {
		setAttrVal("Id_illness", Id_illness);
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
	public String getCode_posi() {
		return ((String) getAttrVal("Code_posi"));
	}	
	public void setCode_posi(String Code_posi) {
		setAttrVal("Code_posi", Code_posi);
	}
	public String getName_posi() {
		return ((String) getAttrVal("Name_posi"));
	}	
	public void setName_posi(String Name_posi) {
		setAttrVal("Name_posi", Name_posi);
	}
	public String getCode_illness() {
		return ((String) getAttrVal("Code_illness"));
	}	
	public void setCode_illness(String Code_illness) {
		setAttrVal("Code_illness", Code_illness);
	}
	public String getName_illness() {
		return ((String) getAttrVal("Name_illness"));
	}	
	public void setName_illness(String Name_illness) {
		setAttrVal("Name_illness", Name_illness);
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
		return "Id_penhcposi";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_penhcposi";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeNhcPosiDODesc.class);
	}
	
}