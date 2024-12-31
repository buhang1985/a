package iih.bl.cg.blorderappendbillparamdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 仅属于门急诊记账字段DTO DTO数据 
 * 
 */
public class BlOrderAppendOutpBillParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者账户授权标志
	 * @return FBoolean
	 */
	public FBoolean getFg_acc() {
		return ((FBoolean) getAttrVal("Fg_acc"));
	}
	/**
	 * 患者账户授权标志
	 * @param Fg_acc
	 */
	public void setFg_acc(FBoolean Fg_acc) {
		setAttrVal("Fg_acc", Fg_acc);
	}
	/**
	 * 患者账户授权金额
	 * @return FDouble
	 */
	public FDouble getAmt_acc() {
		return ((FDouble) getAttrVal("Amt_acc"));
	}
	/**
	 * 患者账户授权金额
	 * @param Amt_acc
	 */
	public void setAmt_acc(FDouble Amt_acc) {
		setAttrVal("Amt_acc", Amt_acc);
	}
	/**
	 * 记账主键
	 * @return String
	 */
	public String getId_cgoep() {
		return ((String) getAttrVal("Id_cgoep"));
	}
	/**
	 * 记账主键
	 * @param Id_cgoep
	 */
	public void setId_cgoep(String Id_cgoep) {
		setAttrVal("Id_cgoep", Id_cgoep);
	}
	/**
	 * 记账明细主键
	 * @return String
	 */
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}
	/**
	 * 记账明细主键
	 * @param Id_cgitmoep
	 */
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
	}
	/**
	 * 记账主表SV
	 * @return FDateTime
	 */
	public FDateTime getMaster_sv() {
		return ((FDateTime) getAttrVal("Master_sv"));
	}
	/**
	 * 记账主表SV
	 * @param Master_sv
	 */
	public void setMaster_sv(FDateTime Master_sv) {
		setAttrVal("Master_sv", Master_sv);
	}
	/**
	 * 记账明细表SV
	 * @return String
	 */
	public String getItms_sv() {
		return ((String) getAttrVal("Itms_sv"));
	}
	/**
	 * 记账明细表SV
	 * @param Itms_sv
	 */
	public void setItms_sv(String Itms_sv) {
		setAttrVal("Itms_sv", Itms_sv);
	}
	/**
	 * 医保（商保）支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hpcg() {
		return ((FBoolean) getAttrVal("Fg_hpcg"));
	}
	/**
	 * 医保（商保）支付标志
	 * @param Fg_hpcg
	 */
	public void setFg_hpcg(FBoolean Fg_hpcg) {
		setAttrVal("Fg_hpcg", Fg_hpcg);
	}
	/**
	 * 科研项目标志
	 * @return String
	 */
	public FBoolean getFg_research() {
		return ((FBoolean) getAttrVal("Fg_research"));
	}
	/**
	 * 科研项目标志
	 * @param Fg_research
	 */
	public void setFg_research(FBoolean Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	/**
	 * 科研项目主键
	 * @return String
	 */
	public String getId_researchproject() {
		return ((String) getAttrVal("Id_researchproject"));
	}
	/**
	 * 科研项目主键
	 * @param Id_researchproject
	 */
	public void setId_researchproject(String Id_researchproject) {
		setAttrVal("Id_researchproject", Id_researchproject);
	}
}