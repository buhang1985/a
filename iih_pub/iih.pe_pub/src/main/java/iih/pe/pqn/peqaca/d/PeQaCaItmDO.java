package iih.pe.pqn.peqaca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peqaca.d.desc.PeQaCaItmDODesc;
import java.math.BigDecimal;

/**
 * 体检问卷组套明细 DO数据 
 * 
 */
public class PeQaCaItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEQACAITM= "Id_peqacaitm";
	public static final String ID_PEQACA= "Id_peqaca";
	public static final String ID_PEQACONTENTDEF= "Id_peqacontentdef";
	public static final String SORTNO= "Sortno";
	public static final String DOFIELD= "Dofield";
	public static final String NAME_PEQA= "Name_peqa";
	public static final String CODE= "Code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peqacaitm() {
		return ((String) getAttrVal("Id_peqacaitm"));
	}	
	public void setId_peqacaitm(String Id_peqacaitm) {
		setAttrVal("Id_peqacaitm", Id_peqacaitm);
	}
	public String getId_peqaca() {
		return ((String) getAttrVal("Id_peqaca"));
	}	
	public void setId_peqaca(String Id_peqaca) {
		setAttrVal("Id_peqaca", Id_peqaca);
	}
	public String getId_peqacontentdef() {
		return ((String) getAttrVal("Id_peqacontentdef"));
	}	
	public void setId_peqacontentdef(String Id_peqacontentdef) {
		setAttrVal("Id_peqacontentdef", Id_peqacontentdef);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getDofield() {
		return ((String) getAttrVal("Dofield"));
	}	
	public void setDofield(String Dofield) {
		setAttrVal("Dofield", Dofield);
	}
	public String getName_peqa() {
		return ((String) getAttrVal("Name_peqa"));
	}	
	public void setName_peqa(String Name_peqa) {
		setAttrVal("Name_peqa", Name_peqa);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
		return "Id_peqacaitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peqacaitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeQaCaItmDODesc.class);
	}
	
}