package iih.nm.nqm.qctplelemaintenance.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.qctplelemaintenance.d.desc.NmQctplEleItmDODesc;
import java.math.BigDecimal;

/**
 * 质量模板元素项 DO数据 
 * 
 */
public class NmQctplEleItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QCTPL_ELE_ITM= "Id_qctpl_ele_itm";
	public static final String ID_QCTPL_ELE= "Id_qctpl_ele";
	public static final String ID_CHKTARGET= "Id_chktarget";
	public static final String SD_CHKTARGET= "Sd_chktarget";
	public static final String EU_COLLTP= "Eu_colltp";
	public static final String NAME_QCTPL_ELE= "Name_qctpl_ele";
	public static final String NAME_CHKTARGET= "Name_chktarget";
	public static final String CODE_CHKTARGET= "Code_chktarget";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qctpl_ele_itm() {
		return ((String) getAttrVal("Id_qctpl_ele_itm"));
	}	
	public void setId_qctpl_ele_itm(String Id_qctpl_ele_itm) {
		setAttrVal("Id_qctpl_ele_itm", Id_qctpl_ele_itm);
	}
	public String getId_qctpl_ele() {
		return ((String) getAttrVal("Id_qctpl_ele"));
	}	
	public void setId_qctpl_ele(String Id_qctpl_ele) {
		setAttrVal("Id_qctpl_ele", Id_qctpl_ele);
	}
	public String getId_chktarget() {
		return ((String) getAttrVal("Id_chktarget"));
	}	
	public void setId_chktarget(String Id_chktarget) {
		setAttrVal("Id_chktarget", Id_chktarget);
	}
	public String getSd_chktarget() {
		return ((String) getAttrVal("Sd_chktarget"));
	}	
	public void setSd_chktarget(String Sd_chktarget) {
		setAttrVal("Sd_chktarget", Sd_chktarget);
	}
	public Integer getEu_colltp() {
		return ((Integer) getAttrVal("Eu_colltp"));
	}	
	public void setEu_colltp(Integer Eu_colltp) {
		setAttrVal("Eu_colltp", Eu_colltp);
	}
	public String getName_qctpl_ele() {
		return ((String) getAttrVal("Name_qctpl_ele"));
	}	
	public void setName_qctpl_ele(String Name_qctpl_ele) {
		setAttrVal("Name_qctpl_ele", Name_qctpl_ele);
	}
	public String getName_chktarget() {
		return ((String) getAttrVal("Name_chktarget"));
	}	
	public void setName_chktarget(String Name_chktarget) {
		setAttrVal("Name_chktarget", Name_chktarget);
	}
	public String getCode_chktarget() {
		return ((String) getAttrVal("Code_chktarget"));
	}	
	public void setCode_chktarget(String Code_chktarget) {
		setAttrVal("Code_chktarget", Code_chktarget);
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
		return "Id_qctpl_ele_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_QCTPL_ELE_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmQctplEleItmDODesc.class);
	}
	
}