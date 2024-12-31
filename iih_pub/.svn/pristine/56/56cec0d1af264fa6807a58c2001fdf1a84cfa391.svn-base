package iih.bl.cg.blredapply.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blredapply.d.desc.BlRefundApplyDODesc;
import java.math.BigDecimal;

/**
 * 退费申请单 DO数据 
 * 
 */
public class BlRefundApplyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//退费申请主键
	public static final String ID_RFDAP= "Id_rfdap";
	//退费申请单号
	public static final String CODE_RFDAP= "Code_rfdap";
	//退费申请部门
	public static final String ID_DEP_AP= "Id_dep_ap";
	//退费申请人
	public static final String ID_EMP_AP= "Id_emp_ap";
	//退费申请时间
	public static final String DT_AP= "Dt_ap";
	//退费理由
	public static final String DES= "Des";
	//撤消标志
	public static final String FG_CANC= "Fg_canc";
	//退费单类型ID
	public static final String ID_RFDAPTP= "Id_rfdaptp";
	//退费单类型编码
	public static final String SD_RFDAPTP= "Sd_rfdaptp";
	//是否审核
	public static final String FG_AUDIT= "Fg_audit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 退费申请主键
	 * @return String
	 */
	public String getId_rfdap() {
		return ((String) getAttrVal("Id_rfdap"));
	}	
	/**
	 * 退费申请主键
	 * @param Id_rfdap
	 */
	public void setId_rfdap(String Id_rfdap) {
		setAttrVal("Id_rfdap", Id_rfdap);
	}
	/**
	 * 退费申请单号
	 * @return String
	 */
	public String getCode_rfdap() {
		return ((String) getAttrVal("Code_rfdap"));
	}	
	/**
	 * 退费申请单号
	 * @param Code_rfdap
	 */
	public void setCode_rfdap(String Code_rfdap) {
		setAttrVal("Code_rfdap", Code_rfdap);
	}
	/**
	 * 退费申请部门
	 * @return String
	 */
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}	
	/**
	 * 退费申请部门
	 * @param Id_dep_ap
	 */
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	/**
	 * 退费申请人
	 * @return String
	 */
	public String getId_emp_ap() {
		return ((String) getAttrVal("Id_emp_ap"));
	}	
	/**
	 * 退费申请人
	 * @param Id_emp_ap
	 */
	public void setId_emp_ap(String Id_emp_ap) {
		setAttrVal("Id_emp_ap", Id_emp_ap);
	}
	/**
	 * 退费申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ap() {
		return ((FDateTime) getAttrVal("Dt_ap"));
	}	
	/**
	 * 退费申请时间
	 * @param Dt_ap
	 */
	public void setDt_ap(FDateTime Dt_ap) {
		setAttrVal("Dt_ap", Dt_ap);
	}
	/**
	 * 退费理由
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 退费理由
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 撤消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 撤消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 退费单类型ID
	 * @return String
	 */
	public String getId_rfdaptp() {
		return ((String) getAttrVal("Id_rfdaptp"));
	}	
	/**
	 * 退费单类型ID
	 * @param Id_rfdaptp
	 */
	public void setId_rfdaptp(String Id_rfdaptp) {
		setAttrVal("Id_rfdaptp", Id_rfdaptp);
	}
	/**
	 * 退费单类型编码
	 * @return String
	 */
	public String getSd_rfdaptp() {
		return ((String) getAttrVal("Sd_rfdaptp"));
	}	
	/**
	 * 退费单类型编码
	 * @param Sd_rfdaptp
	 */
	public void setSd_rfdaptp(String Sd_rfdaptp) {
		setAttrVal("Sd_rfdaptp", Sd_rfdaptp);
	}
	/**
	 * 是否审核
	 * @return FBoolean
	 */
	public FBoolean getFg_audit() {
		return ((FBoolean) getAttrVal("Fg_audit"));
	}	
	/**
	 * 是否审核
	 * @param Fg_audit
	 */
	public void setFg_audit(FBoolean Fg_audit) {
		setAttrVal("Fg_audit", Fg_audit);
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
		return "Id_rfdap";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_rfd_ap";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlRefundApplyDODesc.class);
	}
	
}