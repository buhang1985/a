package iih.hp.cp.eletpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletpl.d.desc.HpCpElemBoundTplDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_计划边界_模板 DO数据 
 * 
 */
public class HpCpElemBoundTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ELE_BOUNDARY_TPL= "Id_ele_boundary_tpl";
	public static final String ID_ELE_TPL= "Id_ele_tpl";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_DEPT= "Id_dept";
	public static final String SPANDAYS= "Spandays";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ele_boundary_tpl() {
		return ((String) getAttrVal("Id_ele_boundary_tpl"));
	}	
	public void setId_ele_boundary_tpl(String Id_ele_boundary_tpl) {
		setAttrVal("Id_ele_boundary_tpl", Id_ele_boundary_tpl);
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
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	public Integer getSpandays() {
		return ((Integer) getAttrVal("Spandays"));
	}	
	public void setSpandays(Integer Spandays) {
		setAttrVal("Spandays", Spandays);
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
		return "Id_ele_boundary_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_BOUNDARY_TPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemBoundTplDODesc.class);
	}
	
}