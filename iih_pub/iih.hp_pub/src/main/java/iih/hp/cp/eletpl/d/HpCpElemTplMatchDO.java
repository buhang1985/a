package iih.hp.cp.eletpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletpl.d.desc.HpCpElemTplMatchDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素模板对照 DO数据 
 * 
 */
public class HpCpElemTplMatchDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MATCH_TPL= "Id_match_tpl";
	public static final String ID_ELE_TPL= "Id_ele_tpl";
	public static final String ID_ELETP= "Id_eletp";
	public static final String EU_STATUS= "Eu_status";
	public static final String TARGET_POS= "Target_pos";
	public static final String ID_TARGET= "Id_target";
	public static final String EU_MATCH_TP= "Eu_match_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_match_tpl() {
		return ((String) getAttrVal("Id_match_tpl"));
	}	
	public void setId_match_tpl(String Id_match_tpl) {
		setAttrVal("Id_match_tpl", Id_match_tpl);
	}
	public String getId_ele_tpl() {
		return ((String) getAttrVal("Id_ele_tpl"));
	}	
	public void setId_ele_tpl(String Id_ele_tpl) {
		setAttrVal("Id_ele_tpl", Id_ele_tpl);
	}
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}	
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
	}
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}	
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	public String getTarget_pos() {
		return ((String) getAttrVal("Target_pos"));
	}	
	public void setTarget_pos(String Target_pos) {
		setAttrVal("Target_pos", Target_pos);
	}
	public String getId_target() {
		return ((String) getAttrVal("Id_target"));
	}	
	public void setId_target(String Id_target) {
		setAttrVal("Id_target", Id_target);
	}
	public Integer getEu_match_tp() {
		return ((Integer) getAttrVal("Eu_match_tp"));
	}	
	public void setEu_match_tp(Integer Eu_match_tp) {
		setAttrVal("Eu_match_tp", Eu_match_tp);
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
		return "Id_match_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_TPL_MATCH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemTplMatchDODesc.class);
	}
	
}