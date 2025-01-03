package iih.ei.std.d.v1.bl.oprefundsupplydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊退补费入参集合 DTO数据 
 * 
 */
public class OrderItm extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 体检流水号
	 * @return String
	 */
	public String getCode_pe() {
		return ((String) getAttrVal("Code_pe"));
	}	
	/**
	 * 体检流水号
	 * @param Code_pe
	 */
	public void setCode_pe(String Code_pe) {
		setAttrVal("Code_pe", Code_pe);
	}
	/**
	 * 门诊就诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}	
	/**
	 * 门诊就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 记账时间
	 * @return String
	 */
	public String getDt_cg() {
		return ((String) getAttrVal("Dt_cg"));
	}	
	/**
	 * 记账时间
	 * @param Dt_cg
	 */
	public void setDt_cg(String Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 记账人编码
	 * @return String
	 */
	public String getCode_emp_cg() {
		return ((String) getAttrVal("Code_emp_cg"));
	}	
	/**
	 * 记账人编码
	 * @param Code_emp_cg
	 */
	public void setCode_emp_cg(String Code_emp_cg) {
		setAttrVal("Code_emp_cg", Code_emp_cg);
	}
	/**
	 * 开立人编码
	 * @return String
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}	
	/**
	 * 开立人编码
	 * @param Code_emp_or
	 */
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 * 执行人编码
	 * @return String
	 */
	public String getCode_emp_mp() {
		return ((String) getAttrVal("Code_emp_mp"));
	}	
	/**
	 * 执行人编码
	 * @param Code_emp_mp
	 */
	public void setCode_emp_mp(String Code_emp_mp) {
		setAttrVal("Code_emp_mp", Code_emp_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}	
	/**
	 * 开立科室
	 * @param Code_dep_or
	 */
	public void setCode_dep_or(String Code_dep_or) {
		setAttrVal("Code_dep_or", Code_dep_or);
	}
	/**
	 * 补退费方向
	 * @return String
	 */
	public String getEu_direct() {
		return ((String) getAttrVal("Eu_direct"));
	}	
	/**
	 * 补退费方向
	 * @param Eu_direct
	 */
	public void setEu_direct(String Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 补费方式
	 * @return String
	 */
	public String getSupplyway() {
		return ((String) getAttrVal("Supplyway"));
	}	
	/**
	 * 补费方式
	 * @param Supplyway
	 */
	public void setSupplyway(String Supplyway) {
		setAttrVal("Supplyway", Supplyway);
	}
	/**
	 * 来源描述
	 * @return String
	 */
	public String getSourcedesc() {
		return ((String) getAttrVal("Sourcedesc"));
	}	
	/**
	 * 来源描述
	 * @param Sourcedesc
	 */
	public void setSourcedesc(String Sourcedesc) {
		setAttrVal("Sourcedesc", Sourcedesc);
	}
	/**
	 * 门诊退补费明细集合
	 * @return String
	 */
	public FArrayList getCgitm() {
		return ((FArrayList) getAttrVal("Cgitm"));
	}	
	/**
	 * 门诊退补费明细集合
	 * @param Cgitm
	 */
	public void setCgitm(FArrayList Cgitm) {
		setAttrVal("Cgitm", Cgitm);
	}
}