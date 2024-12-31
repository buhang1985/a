package iih.pi.dic.patientcategory.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.dic.patientcategory.d.desc.PiPatCaDODesc;
import java.math.BigDecimal;

/**
 * 患者分类 DO数据 
 * 
 */
public class PiPatCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATCA= "Id_patca";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DES= "Des";
	public static final String ID_PATPRITP= "Id_patpritp";
	public static final String ID_PATCRETTP= "Id_patcrettp";
	public static final String ID_PARENT= "Id_parent";
	public static final String INNERCODE= "Innercode";
	public static final String FG_DEF= "Fg_def";
	public static final String CODE_CHIS= "Code_chis";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_PATCAHP= "Id_patcahp";
	public static final String ID_HP= "Id_hp";
	public static final String NAME_HP= "Name_hp";
	public static final String ID_HPKIND= "Id_hpkind";
	public static final String NAME_HPKIND= "Name_hpkind";
	public static final String FG_FUNDPAY= "Fg_fundpay";
	public static final String FG_HP_CARD= "Fg_hp_card";
	public static final String FG_OP= "Fg_op";
	public static final String FG_ER= "Fg_er";
	public static final String FG_USE_ER1= "Fg_use_er1";
	public static final String FG_USE_ER2= "Fg_use_er2";
	public static final String FG_IP= "Fg_ip";
	public static final String FG_PE= "Fg_pe";
	public static final String FG_FM= "Fg_fm";
	public static final String SORTNO= "Sortno";
	public static final String PATPRITP_CODE= "Patpritp_code";
	public static final String PATPRITP_NAME= "Patpritp_name";
	public static final String PATCRETTP_CODE= "Patcrettp_code";
	public static final String PATCRETTP_NAME= "Patcrettp_name";
	public static final String PATENT_CODE= "Patent_code";
	public static final String PATENT_NAME= "Patent_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_patpritp() {
		return ((String) getAttrVal("Id_patpritp"));
	}	
	public void setId_patpritp(String Id_patpritp) {
		setAttrVal("Id_patpritp", Id_patpritp);
	}
	public String getId_patcrettp() {
		return ((String) getAttrVal("Id_patcrettp"));
	}	
	public void setId_patcrettp(String Id_patcrettp) {
		setAttrVal("Id_patcrettp", Id_patcrettp);
	}
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	public FBoolean getFg_def() {
		return ((FBoolean) getAttrVal("Fg_def"));
	}	
	public void setFg_def(FBoolean Fg_def) {
		setAttrVal("Fg_def", Fg_def);
	}
	public String getCode_chis() {
		return ((String) getAttrVal("Code_chis"));
	}	
	public void setCode_chis(String Code_chis) {
		setAttrVal("Code_chis", Code_chis);
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
	public String getId_patcahp() {
		return ((String) getAttrVal("Id_patcahp"));
	}	
	public void setId_patcahp(String Id_patcahp) {
		setAttrVal("Id_patcahp", Id_patcahp);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	public String getId_hpkind() {
		return ((String) getAttrVal("Id_hpkind"));
	}	
	public void setId_hpkind(String Id_hpkind) {
		setAttrVal("Id_hpkind", Id_hpkind);
	}
	public String getName_hpkind() {
		return ((String) getAttrVal("Name_hpkind"));
	}	
	public void setName_hpkind(String Name_hpkind) {
		setAttrVal("Name_hpkind", Name_hpkind);
	}
	public FBoolean getFg_fundpay() {
		return ((FBoolean) getAttrVal("Fg_fundpay"));
	}	
	public void setFg_fundpay(FBoolean Fg_fundpay) {
		setAttrVal("Fg_fundpay", Fg_fundpay);
	}
	public FBoolean getFg_hp_card() {
		return ((FBoolean) getAttrVal("Fg_hp_card"));
	}	
	public void setFg_hp_card(FBoolean Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}	
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
	public FBoolean getFg_er() {
		return ((FBoolean) getAttrVal("Fg_er"));
	}	
	public void setFg_er(FBoolean Fg_er) {
		setAttrVal("Fg_er", Fg_er);
	}
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}	
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	public FBoolean getFg_pe() {
		return ((FBoolean) getAttrVal("Fg_pe"));
	}	
	public void setFg_pe(FBoolean Fg_pe) {
		setAttrVal("Fg_pe", Fg_pe);
	}
	public FBoolean getFg_fm() {
		return ((FBoolean) getAttrVal("Fg_fm"));
	}	
	public void setFg_fm(FBoolean Fg_fm) {
		setAttrVal("Fg_fm", Fg_fm);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getPatpritp_code() {
		return ((String) getAttrVal("Patpritp_code"));
	}	
	public void setPatpritp_code(String Patpritp_code) {
		setAttrVal("Patpritp_code", Patpritp_code);
	}
	public String getPatpritp_name() {
		return ((String) getAttrVal("Patpritp_name"));
	}	
	public void setPatpritp_name(String Patpritp_name) {
		setAttrVal("Patpritp_name", Patpritp_name);
	}
	public String getPatcrettp_code() {
		return ((String) getAttrVal("Patcrettp_code"));
	}	
	public void setPatcrettp_code(String Patcrettp_code) {
		setAttrVal("Patcrettp_code", Patcrettp_code);
	}
	public String getPatcrettp_name() {
		return ((String) getAttrVal("Patcrettp_name"));
	}	
	public void setPatcrettp_name(String Patcrettp_name) {
		setAttrVal("Patcrettp_name", Patcrettp_name);
	}
	public String getPatent_code() {
		return ((String) getAttrVal("Patent_code"));
	}	
	public void setPatent_code(String Patent_code) {
		setAttrVal("Patent_code", Patent_code);
	}
	public String getPatent_name() {
		return ((String) getAttrVal("Patent_name"));
	}	
	public void setPatent_name(String Patent_name) {
		setAttrVal("Patent_name", Patent_name);
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
		return "Id_patca";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_ca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatCaDODesc.class);
	}
	
}