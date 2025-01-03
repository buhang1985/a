package iih.pe.por.pelogpsnbinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pelogpsnbinfo.d.desc.PeLogPsnBInfoDODesc;
import java.math.BigDecimal;

/**
 * 体检日志客户基本资料 DO数据 
 * 
 */
public class PeLogPsnBInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PELOGPSNBINFO= "Id_pelogpsnbinfo";
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ENAME= "Ename";
	public static final String SD_IDTP= "Sd_idtp";
	public static final String ID_IDTP= "Id_idtp";
	public static final String IDCODE= "Idcode";
	public static final String SD_SEX= "Sd_sex";
	public static final String ID_SEX= "Id_sex";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String SD_MARRY= "Sd_marry";
	public static final String ID_MARRY= "Id_marry";
	public static final String MOB= "Mob";
	public static final String TEL= "Tel";
	public static final String EMAIL= "Email";
	public static final String ADDR_STR= "Addr_str";
	public static final String ZIP= "Zip";
	public static final String WX= "Wx";
	public static final String NO_HP= "No_hp";
	public static final String HEALTH_RESP= "Health_resp";
	public static final String SD_NATION= "Sd_nation";
	public static final String ID_NATION= "Id_nation";
	public static final String SD_COUTRY= "Sd_coutry";
	public static final String ID_COUTRY= "Id_coutry";
	public static final String SD_BELIEF= "Sd_belief";
	public static final String ID_BELIEF= "Id_belief";
	public static final String NATIVE_PLACE= "Native_place";
	public static final String IDENTITY= "Identity";
	public static final String SD_OCCU= "Sd_occu";
	public static final String ID_OCCU= "Id_occu";
	public static final String SD_EDUC= "Sd_educ";
	public static final String ID_EDUC= "Id_educ";
	public static final String PRIVACY= "Privacy";
	public static final String WORKUNIT= "Workunit";
	public static final String PASSWORD= "Password";
	public static final String ID_PAT= "Id_pat";
	public static final String BARCODE_CHIS= "Barcode_chis";
	public static final String PHO= "Pho";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
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
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_ID= "Code_id";
	public static final String NAME_ID= "Name_id";
	public static final String CODE_SEX= "Code_sex";
	public static final String NAME_SEX= "Name_sex";
	public static final String CODE_MARRY= "Code_marry";
	public static final String NAME_MARRY= "Name_marry";
	public static final String CODE_NATION= "Code_nation";
	public static final String NAME_NATION= "Name_nation";
	public static final String NAME_CONTRY= "Name_contry";
	public static final String CODETH_CONTRY= "Codeth_contry";
	public static final String CODE_BELIEF= "Code_belief";
	public static final String NAME_BELIEF= "Name_belief";
	public static final String CODE_OCCU= "Code_occu";
	public static final String NAME_OCCU= "Name_occu";
	public static final String CODE_EDUC= "Code_educ";
	public static final String NAME_EDUC= "Name_educ";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pelogpsnbinfo() {
		return ((String) getAttrVal("Id_pelogpsnbinfo"));
	}	
	public void setId_pelogpsnbinfo(String Id_pelogpsnbinfo) {
		setAttrVal("Id_pelogpsnbinfo", Id_pelogpsnbinfo);
	}
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
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
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}	
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}	
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}	
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	public String getEmail() {
		return ((String) getAttrVal("Email"));
	}	
	public void setEmail(String Email) {
		setAttrVal("Email", Email);
	}
	public String getAddr_str() {
		return ((String) getAttrVal("Addr_str"));
	}	
	public void setAddr_str(String Addr_str) {
		setAttrVal("Addr_str", Addr_str);
	}
	public String getZip() {
		return ((String) getAttrVal("Zip"));
	}	
	public void setZip(String Zip) {
		setAttrVal("Zip", Zip);
	}
	public String getWx() {
		return ((String) getAttrVal("Wx"));
	}	
	public void setWx(String Wx) {
		setAttrVal("Wx", Wx);
	}
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	public String getHealth_resp() {
		return ((String) getAttrVal("Health_resp"));
	}	
	public void setHealth_resp(String Health_resp) {
		setAttrVal("Health_resp", Health_resp);
	}
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}	
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	public String getSd_coutry() {
		return ((String) getAttrVal("Sd_coutry"));
	}	
	public void setSd_coutry(String Sd_coutry) {
		setAttrVal("Sd_coutry", Sd_coutry);
	}
	public String getId_coutry() {
		return ((String) getAttrVal("Id_coutry"));
	}	
	public void setId_coutry(String Id_coutry) {
		setAttrVal("Id_coutry", Id_coutry);
	}
	public String getSd_belief() {
		return ((String) getAttrVal("Sd_belief"));
	}	
	public void setSd_belief(String Sd_belief) {
		setAttrVal("Sd_belief", Sd_belief);
	}
	public String getId_belief() {
		return ((String) getAttrVal("Id_belief"));
	}	
	public void setId_belief(String Id_belief) {
		setAttrVal("Id_belief", Id_belief);
	}
	public String getNative_place() {
		return ((String) getAttrVal("Native_place"));
	}	
	public void setNative_place(String Native_place) {
		setAttrVal("Native_place", Native_place);
	}
	public String getIdentity() {
		return ((String) getAttrVal("Identity"));
	}	
	public void setIdentity(String Identity) {
		setAttrVal("Identity", Identity);
	}
	public String getSd_occu() {
		return ((String) getAttrVal("Sd_occu"));
	}	
	public void setSd_occu(String Sd_occu) {
		setAttrVal("Sd_occu", Sd_occu);
	}
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}	
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
	}
	public String getSd_educ() {
		return ((String) getAttrVal("Sd_educ"));
	}	
	public void setSd_educ(String Sd_educ) {
		setAttrVal("Sd_educ", Sd_educ);
	}
	public String getId_educ() {
		return ((String) getAttrVal("Id_educ"));
	}	
	public void setId_educ(String Id_educ) {
		setAttrVal("Id_educ", Id_educ);
	}
	public String getPrivacy() {
		return ((String) getAttrVal("Privacy"));
	}	
	public void setPrivacy(String Privacy) {
		setAttrVal("Privacy", Privacy);
	}
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}	
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	public String getPassword() {
		return ((String) getAttrVal("Password"));
	}	
	public void setPassword(String Password) {
		setAttrVal("Password", Password);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}	
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	public byte[] getPho() {
		return ((byte[]) getAttrVal("Pho"));
	}	
	public void setPho(byte[] Pho) {
		setAttrVal("Pho", Pho);
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
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}	
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	public String getName_id() {
		return ((String) getAttrVal("Name_id"));
	}	
	public void setName_id(String Name_id) {
		setAttrVal("Name_id", Name_id);
	}
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}	
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getCode_marry() {
		return ((String) getAttrVal("Code_marry"));
	}	
	public void setCode_marry(String Code_marry) {
		setAttrVal("Code_marry", Code_marry);
	}
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	public String getCode_nation() {
		return ((String) getAttrVal("Code_nation"));
	}	
	public void setCode_nation(String Code_nation) {
		setAttrVal("Code_nation", Code_nation);
	}
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	public String getName_contry() {
		return ((String) getAttrVal("Name_contry"));
	}	
	public void setName_contry(String Name_contry) {
		setAttrVal("Name_contry", Name_contry);
	}
	public String getCodeth_contry() {
		return ((String) getAttrVal("Codeth_contry"));
	}	
	public void setCodeth_contry(String Codeth_contry) {
		setAttrVal("Codeth_contry", Codeth_contry);
	}
	public String getCode_belief() {
		return ((String) getAttrVal("Code_belief"));
	}	
	public void setCode_belief(String Code_belief) {
		setAttrVal("Code_belief", Code_belief);
	}
	public String getName_belief() {
		return ((String) getAttrVal("Name_belief"));
	}	
	public void setName_belief(String Name_belief) {
		setAttrVal("Name_belief", Name_belief);
	}
	public String getCode_occu() {
		return ((String) getAttrVal("Code_occu"));
	}	
	public void setCode_occu(String Code_occu) {
		setAttrVal("Code_occu", Code_occu);
	}
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}	
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	public String getCode_educ() {
		return ((String) getAttrVal("Code_educ"));
	}	
	public void setCode_educ(String Code_educ) {
		setAttrVal("Code_educ", Code_educ);
	}
	public String getName_educ() {
		return ((String) getAttrVal("Name_educ"));
	}	
	public void setName_educ(String Name_educ) {
		setAttrVal("Name_educ", Name_educ);
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
		return "Id_pelogpsnbinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_log_pepsnbinfo";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeLogPsnBInfoDODesc.class);
	}
	
}