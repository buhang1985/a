package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出院诊断 DTO数据 
 * 
 */
public class DischargeDiagnosisDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院号
	 * @return String
	 */
	public String getZyh() {
		return ((String) getAttrVal("Zyh"));
	}
	/**
	 * 住院号
	 * @param Zyh
	 */
	public void setZyh(String Zyh) {
		setAttrVal("Zyh", Zyh);
	}
	/**
	 * 出院诊断-主要诊断名称
	 * @return String
	 */
	public String getHdsd00_11_024() {
		return ((String) getAttrVal("Hdsd00_11_024"));
	}
	/**
	 * 出院诊断-主要诊断名称
	 * @param Hdsd00_11_024
	 */
	public void setHdsd00_11_024(String Hdsd00_11_024) {
		setAttrVal("Hdsd00_11_024", Hdsd00_11_024);
	}
	/**
	 * 出院诊断-主要诊断疾病代码
	 * @return String
	 */
	public String getHdsd00_11_023() {
		return ((String) getAttrVal("Hdsd00_11_023"));
	}
	/**
	 * 出院诊断-主要诊断疾病代码
	 * @param Hdsd00_11_023
	 */
	public void setHdsd00_11_023(String Hdsd00_11_023) {
		setAttrVal("Hdsd00_11_023", Hdsd00_11_023);
	}
	/**
	 * 出院诊断-主要诊断入院病情代码
	 * @return String
	 */
	public String getHdsd00_11_025() {
		return ((String) getAttrVal("Hdsd00_11_025"));
	}
	/**
	 * 出院诊断-主要诊断入院病情代码
	 * @param Hdsd00_11_025
	 */
	public void setHdsd00_11_025(String Hdsd00_11_025) {
		setAttrVal("Hdsd00_11_025", Hdsd00_11_025);
	}
	/**
	 * 出院诊断-其他诊断名称
	 * @return String
	 */
	public String getHdsd00_11_021() {
		return ((String) getAttrVal("Hdsd00_11_021"));
	}
	/**
	 * 出院诊断-其他诊断名称
	 * @param Hdsd00_11_021
	 */
	public void setHdsd00_11_021(String Hdsd00_11_021) {
		setAttrVal("Hdsd00_11_021", Hdsd00_11_021);
	}
	/**
	 * 出院诊断-其他诊断疾病编码
	 * @return String
	 */
	public String getHdsd00_11_020() {
		return ((String) getAttrVal("Hdsd00_11_020"));
	}
	/**
	 * 出院诊断-其他诊断疾病编码
	 * @param Hdsd00_11_020
	 */
	public void setHdsd00_11_020(String Hdsd00_11_020) {
		setAttrVal("Hdsd00_11_020", Hdsd00_11_020);
	}
	/**
	 * 出院诊断-其他诊断入院病情代码
	 * @return String
	 */
	public String getHdsd00_11_022() {
		return ((String) getAttrVal("Hdsd00_11_022"));
	}
	/**
	 * 出院诊断-其他诊断入院病情代码
	 * @param Hdsd00_11_022
	 */
	public void setHdsd00_11_022(String Hdsd00_11_022) {
		setAttrVal("Hdsd00_11_022", Hdsd00_11_022);
	}
}