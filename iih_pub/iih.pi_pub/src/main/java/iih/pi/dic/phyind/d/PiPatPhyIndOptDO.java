package iih.pi.dic.phyind.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.dic.phyind.d.desc.PiPatPhyIndOptDODesc;
import java.math.BigDecimal;

/**
 * 患者生理指标选项 DO数据 
 * 
 */
public class PiPatPhyIndOptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATPHYINDOPT= "Id_patphyindopt";
	public static final String ID_PATPHYIND= "Id_patphyind";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String INSTR= "Instr";
	public static final String DES= "Des";
	public static final String SORTNO= "Sortno";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String IND_CODE= "Ind_code";
	public static final String IND_NAME= "Ind_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patphyindopt() {
		return ((String) getAttrVal("Id_patphyindopt"));
	}	
	public void setId_patphyindopt(String Id_patphyindopt) {
		setAttrVal("Id_patphyindopt", Id_patphyindopt);
	}
	public String getId_patphyind() {
		return ((String) getAttrVal("Id_patphyind"));
	}	
	public void setId_patphyind(String Id_patphyind) {
		setAttrVal("Id_patphyind", Id_patphyind);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getInd_code() {
		return ((String) getAttrVal("Ind_code"));
	}	
	public void setInd_code(String Ind_code) {
		setAttrVal("Ind_code", Ind_code);
	}
	public String getInd_name() {
		return ((String) getAttrVal("Ind_name"));
	}	
	public void setInd_name(String Ind_name) {
		setAttrVal("Ind_name", Ind_name);
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
		return "Id_patphyindopt";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_phyindopt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatPhyIndOptDODesc.class);
	}
	
}