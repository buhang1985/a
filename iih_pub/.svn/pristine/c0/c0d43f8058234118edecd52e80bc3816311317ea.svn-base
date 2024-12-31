package iih.nm.nqm.qctplelemaintenance.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.qctplelemaintenance.d.desc.NmQctplEleGrpDODesc;
import java.math.BigDecimal;

/**
 * 质量模板元素组 DO数据 
 * 
 */
public class NmQctplEleGrpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QCTPL_ELE_GRP= "Id_qctpl_ele_grp";
	public static final String ID_QCTPL_ELE= "Id_qctpl_ele";
	public static final String EU_SELTP= "Eu_seltp";
	public static final String EU_GRADETP= "Eu_gradetp";
	public static final String RATE_PASS= "Rate_pass";
	public static final String NAME_QCTPL_ELE= "Name_qctpl_ele";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qctpl_ele_grp() {
		return ((String) getAttrVal("Id_qctpl_ele_grp"));
	}	
	public void setId_qctpl_ele_grp(String Id_qctpl_ele_grp) {
		setAttrVal("Id_qctpl_ele_grp", Id_qctpl_ele_grp);
	}
	public String getId_qctpl_ele() {
		return ((String) getAttrVal("Id_qctpl_ele"));
	}	
	public void setId_qctpl_ele(String Id_qctpl_ele) {
		setAttrVal("Id_qctpl_ele", Id_qctpl_ele);
	}
	public Integer getEu_seltp() {
		return ((Integer) getAttrVal("Eu_seltp"));
	}	
	public void setEu_seltp(Integer Eu_seltp) {
		setAttrVal("Eu_seltp", Eu_seltp);
	}
	public Integer getEu_gradetp() {
		return ((Integer) getAttrVal("Eu_gradetp"));
	}	
	public void setEu_gradetp(Integer Eu_gradetp) {
		setAttrVal("Eu_gradetp", Eu_gradetp);
	}
	public FDouble getRate_pass() {
		return ((FDouble) getAttrVal("Rate_pass"));
	}	
	public void setRate_pass(FDouble Rate_pass) {
		setAttrVal("Rate_pass", Rate_pass);
	}
	public String getName_qctpl_ele() {
		return ((String) getAttrVal("Name_qctpl_ele"));
	}	
	public void setName_qctpl_ele(String Name_qctpl_ele) {
		setAttrVal("Name_qctpl_ele", Name_qctpl_ele);
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
		return "Id_qctpl_ele_grp";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_QCTPL_ELE_GRP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmQctplEleGrpDODesc.class);
	}
	
}