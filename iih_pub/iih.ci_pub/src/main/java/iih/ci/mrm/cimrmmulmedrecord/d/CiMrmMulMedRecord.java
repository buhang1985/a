package iih.ci.mrm.cimrmmulmedrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.cimrmmulmedrecord.d.desc.CiMrmMulMedRecordDesc;
import java.math.BigDecimal;

/**
 * 多媒体文件记录分类 DO数据 
 * 
 */
public class CiMrmMulMedRecord extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MMRECORD= "Id_mmrecord";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MRCACTM= "Id_mrcactm";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_MR= "Id_mr";
	public static final String ID_EDITSTATUS= "Id_editstatus";
	public static final String NAME_EDITSTATUS= "Name_editstatus";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String DEF7= "Def7";
	public static final String DEF8= "Def8";
	public static final String DEF9= "Def9";
	public static final String DEF10= "Def10";
	public static final String GROUP_NAME= "Group_name";
	public static final String GROUP_CODE= "Group_code";
	public static final String ORG_NAME= "Org_name";
	public static final String ORG_CODE= "Org_code";
	public static final String MRCACTM_CODE= "Mrcactm_code";
	public static final String MRCACTM_NAME= "Mrcactm_name";
	public static final String MRTP_NAME= "Mrtp_name";
	public static final String MRTP_CODE= "Mrtp_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mmrecord() {
		return ((String) getAttrVal("Id_mmrecord"));
	}	
	public void setId_mmrecord(String Id_mmrecord) {
		setAttrVal("Id_mmrecord", Id_mmrecord);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	public String getId_editstatus() {
		return ((String) getAttrVal("Id_editstatus"));
	}	
	public void setId_editstatus(String Id_editstatus) {
		setAttrVal("Id_editstatus", Id_editstatus);
	}
	public String getName_editstatus() {
		return ((String) getAttrVal("Name_editstatus"));
	}	
	public void setName_editstatus(String Name_editstatus) {
		setAttrVal("Name_editstatus", Name_editstatus);
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
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	public String getGroup_name() {
		return ((String) getAttrVal("Group_name"));
	}	
	public void setGroup_name(String Group_name) {
		setAttrVal("Group_name", Group_name);
	}
	public String getGroup_code() {
		return ((String) getAttrVal("Group_code"));
	}	
	public void setGroup_code(String Group_code) {
		setAttrVal("Group_code", Group_code);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getMrcactm_code() {
		return ((String) getAttrVal("Mrcactm_code"));
	}	
	public void setMrcactm_code(String Mrcactm_code) {
		setAttrVal("Mrcactm_code", Mrcactm_code);
	}
	public String getMrcactm_name() {
		return ((String) getAttrVal("Mrcactm_name"));
	}	
	public void setMrcactm_name(String Mrcactm_name) {
		setAttrVal("Mrcactm_name", Mrcactm_name);
	}
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
	}
	public String getMrtp_code() {
		return ((String) getAttrVal("Mrtp_code"));
	}	
	public void setMrtp_code(String Mrtp_code) {
		setAttrVal("Mrtp_code", Mrtp_code);
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
		return "Id_mmrecord";
	}
	
	@Override
	public String getTableName() {	  
		return "Ci_Mr_mmRecord";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrmMulMedRecordDesc.class);
	}
	
}