package iih.ei.std.d.v1.bl.iprefundsupplydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院退补费入参 DTO数据 
 * 
 */
public class IpRefundSupplyParamDTO extends BaseDTO {
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
	 * 住院次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}	
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
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
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}	
	/**
	 * 执行科室编码
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
	}
	/**
	 * 开立科室编码
	 * @return String
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}	
	/**
	 * 开立科室编码
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
	 * 住院退补费入参记账明细
	 * @return String
	 */
	public FArrayList getCgitm() {
		return ((FArrayList) getAttrVal("Cgitm"));
	}	
	/**
	 * 住院退补费入参记账明细
	 * @param Cgitm
	 */
	public void setCgitm(FArrayList Cgitm) {
		setAttrVal("Cgitm", Cgitm);
	}
}