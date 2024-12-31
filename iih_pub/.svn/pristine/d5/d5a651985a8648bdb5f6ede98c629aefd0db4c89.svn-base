package iih.bd.mhi.hpentpcomp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.hpentpcomp.d.desc.HpEntpCompDODesc;
import java.math.BigDecimal;

/**
 * 医保产品就诊类型对照 DO数据 
 * 
 */
public class HpEntpCompDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTPCOMP= "Id_entpcomp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String ID_HPENTP= "Id_hpentp";
	public static final String ID_ENTP= "Id_entp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HP_CODE= "Hp_code";
	public static final String HP_NAME= "Hp_name";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ENTP_CODE= "Entp_code";
	public static final String ENTP_NAME= "Entp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entpcomp() {
		return ((String) getAttrVal("Id_entpcomp"));
	}	
	public void setId_entpcomp(String Id_entpcomp) {
		setAttrVal("Id_entpcomp", Id_entpcomp);
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
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getId_hpentp() {
		return ((String) getAttrVal("Id_hpentp"));
	}	
	public void setId_hpentp(String Id_hpentp) {
		setAttrVal("Id_hpentp", Id_hpentp);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
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
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
	}
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
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
		return "Id_entpcomp";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MHI_COMP_ENTP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpEntpCompDODesc.class);
	}
	
}