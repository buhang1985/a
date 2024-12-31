package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemBoundaryDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_计划边界 DO数据 
 * 
 */
public class HpCpElemBoundaryDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//计划边界ID
	public static final String ID_ELE_BOUNDARY= "Id_ele_boundary";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//诊疗边界对应组织
	public static final String ID_DEPT= "Id_dept";
	//时间长度(天)
	public static final String SPANDAYS= "Spandays";
	//名称
	public static final String ID_DEPT_NAME= "Id_dept_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 计划边界ID
	 * @return String
	 */
	public String getId_ele_boundary() {
		return ((String) getAttrVal("Id_ele_boundary"));
	}	
	/**
	 * 计划边界ID
	 * @param Id_ele_boundary
	 */
	public void setId_ele_boundary(String Id_ele_boundary) {
		setAttrVal("Id_ele_boundary", Id_ele_boundary);
	}
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}	
	/**
	 * 元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 诊疗边界对应组织
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 诊疗边界对应组织
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 时间长度(天)
	 * @return Integer
	 */
	public Integer getSpandays() {
		return ((Integer) getAttrVal("Spandays"));
	}	
	/**
	 * 时间长度(天)
	 * @param Spandays
	 */
	public void setSpandays(Integer Spandays) {
		setAttrVal("Spandays", Spandays);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getId_dept_name() {
		return ((String) getAttrVal("Id_dept_name"));
	}	
	/**
	 * 名称
	 * @param Id_dept_name
	 */
	public void setId_dept_name(String Id_dept_name) {
		setAttrVal("Id_dept_name", Id_dept_name);
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
		return "Id_ele_boundary";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_Boundary";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemBoundaryDODesc.class);
	}
	
}