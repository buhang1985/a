package iih.bl.cg.blrefundapplycanc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blrefundapplycanc.d.desc.BlRefundApplyCancDODesc;
import java.math.BigDecimal;

/**
 * 退费申请取消 DO数据 
 * 
 */
public class BlRefundApplyCancDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//退费申请撤消主键
	public static final String ID_RFDCANC= "Id_rfdcanc";
	//退费申请单
	public static final String ID_RFDAP= "Id_rfdap";
	//撤消部门
	public static final String ID_DEP_CANC= "Id_dep_canc";
	//撤消人
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//撤消时间
	public static final String DT_CANC= "Dt_canc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 退费申请撤消主键
	 * @return String
	 */
	public String getId_rfdcanc() {
		return ((String) getAttrVal("Id_rfdcanc"));
	}	
	/**
	 * 退费申请撤消主键
	 * @param Id_rfdcanc
	 */
	public void setId_rfdcanc(String Id_rfdcanc) {
		setAttrVal("Id_rfdcanc", Id_rfdcanc);
	}
	/**
	 * 退费申请单
	 * @return String
	 */
	public String getId_rfdap() {
		return ((String) getAttrVal("Id_rfdap"));
	}	
	/**
	 * 退费申请单
	 * @param Id_rfdap
	 */
	public void setId_rfdap(String Id_rfdap) {
		setAttrVal("Id_rfdap", Id_rfdap);
	}
	/**
	 * 撤消部门
	 * @return String
	 */
	public String getId_dep_canc() {
		return ((String) getAttrVal("Id_dep_canc"));
	}	
	/**
	 * 撤消部门
	 * @param Id_dep_canc
	 */
	public void setId_dep_canc(String Id_dep_canc) {
		setAttrVal("Id_dep_canc", Id_dep_canc);
	}
	/**
	 * 撤消人
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 撤消人
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 撤消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 撤消时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
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
		return "Id_rfdcanc";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_rfd_canc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlRefundApplyCancDODesc.class);
	}
	
}