package iih.pe.pitm.pesrvcapridef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvcapridef.d.desc.PeSrvCaPriDefDODesc;
import java.math.BigDecimal;

/**
 * 体检项目分类价格表 DO数据 
 * 
 */
public class PeSrvCaPriDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PESRVCAPRIDEF= "Id_pesrvcapridef";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PEMEMCARD= "Id_pememcard";
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	public static final String PRI_ITM= "Pri_itm";
	public static final String DIS_ITM= "Dis_itm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MEMCARD= "Name_memcard";
	public static final String NAME_SVRITM= "Name_svritm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pesrvcapridef() {
		return ((String) getAttrVal("Id_pesrvcapridef"));
	}	
	public void setId_pesrvcapridef(String Id_pesrvcapridef) {
		setAttrVal("Id_pesrvcapridef", Id_pesrvcapridef);
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
	public String getId_pememcard() {
		return ((String) getAttrVal("Id_pememcard"));
	}	
	public void setId_pememcard(String Id_pememcard) {
		setAttrVal("Id_pememcard", Id_pememcard);
	}
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	public FDouble getPri_itm() {
		return ((FDouble) getAttrVal("Pri_itm"));
	}	
	public void setPri_itm(FDouble Pri_itm) {
		setAttrVal("Pri_itm", Pri_itm);
	}
	public FDouble getDis_itm() {
		return ((FDouble) getAttrVal("Dis_itm"));
	}	
	public void setDis_itm(FDouble Dis_itm) {
		setAttrVal("Dis_itm", Dis_itm);
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
	public String getName_memcard() {
		return ((String) getAttrVal("Name_memcard"));
	}	
	public void setName_memcard(String Name_memcard) {
		setAttrVal("Name_memcard", Name_memcard);
	}
	public String getName_svritm() {
		return ((String) getAttrVal("Name_svritm"));
	}	
	public void setName_svritm(String Name_svritm) {
		setAttrVal("Name_svritm", Name_svritm);
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
		return "Id_pesrvcapridef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvcapridef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvCaPriDefDODesc.class);
	}
	
}