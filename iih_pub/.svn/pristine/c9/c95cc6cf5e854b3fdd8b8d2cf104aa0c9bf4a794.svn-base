package iih.pe.phm.pechkplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pechkplan.d.desc.PeChkPlanItmDODesc;
import java.math.BigDecimal;

/**
 * 健康体检计划项目 DO数据 
 * 
 */
public class PeChkPlanItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康体检计划项目主键标识
	public static final String ID_PECHKPLANITM= "Id_pechkplanitm";
	//健康体检计划ID
	public static final String ID_PECHKPLAN= "Id_pechkplan";
	//体检方案ID
	public static final String ID_PESRVPROG= "Id_pesrvprog";
	//编码
	public static final String CODE_PROG= "Code_prog";
	//名称
	public static final String NAME_PROG= "Name_prog";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康体检计划项目主键标识
	 * @return String
	 */
	public String getId_pechkplanitm() {
		return ((String) getAttrVal("Id_pechkplanitm"));
	}	
	/**
	 * 健康体检计划项目主键标识
	 * @param Id_pechkplanitm
	 */
	public void setId_pechkplanitm(String Id_pechkplanitm) {
		setAttrVal("Id_pechkplanitm", Id_pechkplanitm);
	}
	/**
	 * 健康体检计划ID
	 * @return String
	 */
	public String getId_pechkplan() {
		return ((String) getAttrVal("Id_pechkplan"));
	}	
	/**
	 * 健康体检计划ID
	 * @param Id_pechkplan
	 */
	public void setId_pechkplan(String Id_pechkplan) {
		setAttrVal("Id_pechkplan", Id_pechkplan);
	}
	/**
	 * 体检方案ID
	 * @return String
	 */
	public String getId_pesrvprog() {
		return ((String) getAttrVal("Id_pesrvprog"));
	}	
	/**
	 * 体检方案ID
	 * @param Id_pesrvprog
	 */
	public void setId_pesrvprog(String Id_pesrvprog) {
		setAttrVal("Id_pesrvprog", Id_pesrvprog);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_prog() {
		return ((String) getAttrVal("Code_prog"));
	}	
	/**
	 * 编码
	 * @param Code_prog
	 */
	public void setCode_prog(String Code_prog) {
		setAttrVal("Code_prog", Code_prog);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_prog() {
		return ((String) getAttrVal("Name_prog"));
	}	
	/**
	 * 名称
	 * @param Name_prog
	 */
	public void setName_prog(String Name_prog) {
		setAttrVal("Name_prog", Name_prog);
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
		return "Id_pechkplanitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pechkplanitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChkPlanItmDODesc.class);
	}
	
}