package iih.hp.cp.eletpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletpl.d.desc.HpCpElemTextTplDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_文本元素_模板 DO数据 
 * 
 */
public class HpCpElemTextTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ELE_TXT_TPL= "Id_ele_txt_tpl";
	public static final String ID_ELE_TPL= "Id_ele_tpl";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_DE= "Id_de";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ele_txt_tpl() {
		return ((String) getAttrVal("Id_ele_txt_tpl"));
	}	
	public void setId_ele_txt_tpl(String Id_ele_txt_tpl) {
		setAttrVal("Id_ele_txt_tpl", Id_ele_txt_tpl);
	}
	public String getId_ele_tpl() {
		return ((String) getAttrVal("Id_ele_tpl"));
	}	
	public void setId_ele_tpl(String Id_ele_tpl) {
		setAttrVal("Id_ele_tpl", Id_ele_tpl);
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
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
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
		return "Id_ele_txt_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_TXT_TPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemTextTplDODesc.class);
	}
	
}