package iih.bl.cg.blrefundaudit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blrefundaudit.d.desc.BlRefundAuditDODesc;
import java.math.BigDecimal;

/**
 * 退费审核 DO数据 
 * 
 */
public class BlRefundAuditDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//退费确认主键
	public static final String ID_RFDCHK= "Id_rfdchk";
	//退费确认科室
	public static final String ID_DEP_CHK= "Id_dep_chk";
	//退费确认人员
	public static final String ID_EMP_CHK= "Id_emp_chk";
	//退费确认时间
	public static final String DT_CHK= "Dt_chk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 退费确认主键
	 * @return String
	 */
	public String getId_rfdchk() {
		return ((String) getAttrVal("Id_rfdchk"));
	}	
	/**
	 * 退费确认主键
	 * @param Id_rfdchk
	 */
	public void setId_rfdchk(String Id_rfdchk) {
		setAttrVal("Id_rfdchk", Id_rfdchk);
	}
	/**
	 * 退费确认科室
	 * @return String
	 */
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}	
	/**
	 * 退费确认科室
	 * @param Id_dep_chk
	 */
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	/**
	 * 退费确认人员
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}	
	/**
	 * 退费确认人员
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 退费确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 退费确认时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
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
		return "Id_rfdchk";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_rfd_chk";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlRefundAuditDODesc.class);
	}
	
}