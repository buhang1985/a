package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmWarnValDODesc;
import java.math.BigDecimal;

/**
 * 体检项目预警值设定 DO数据 
 * 
 */
public class PeSrvitmWarnValDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检项目预警值主键标识
	public static final String ID_PESRVITMWARNVAL= "Id_pesrvitmwarnval";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//预警级别
	public static final String WARNLEVEL= "Warnlevel";
	//操作符
	public static final String OPERATOR= "Operator";
	//预警值
	public static final String WARNVAL= "Warnval";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检项目预警值主键标识
	 * @return String
	 */
	public String getId_pesrvitmwarnval() {
		return ((String) getAttrVal("Id_pesrvitmwarnval"));
	}	
	/**
	 * 体检项目预警值主键标识
	 * @param Id_pesrvitmwarnval
	 */
	public void setId_pesrvitmwarnval(String Id_pesrvitmwarnval) {
		setAttrVal("Id_pesrvitmwarnval", Id_pesrvitmwarnval);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 预警级别
	 * @return Integer
	 */
	public Integer getWarnlevel() {
		return ((Integer) getAttrVal("Warnlevel"));
	}	
	/**
	 * 预警级别
	 * @param Warnlevel
	 */
	public void setWarnlevel(Integer Warnlevel) {
		setAttrVal("Warnlevel", Warnlevel);
	}
	/**
	 * 操作符
	 * @return Integer
	 */
	public Integer getOperator() {
		return ((Integer) getAttrVal("Operator"));
	}	
	/**
	 * 操作符
	 * @param Operator
	 */
	public void setOperator(Integer Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 预警值
	 * @return String
	 */
	public String getWarnval() {
		return ((String) getAttrVal("Warnval"));
	}	
	/**
	 * 预警值
	 * @param Warnval
	 */
	public void setWarnval(String Warnval) {
		setAttrVal("Warnval", Warnval);
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
		return "Id_pesrvitmwarnval";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvitmwarnval";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvitmWarnValDODesc.class);
	}
	
}