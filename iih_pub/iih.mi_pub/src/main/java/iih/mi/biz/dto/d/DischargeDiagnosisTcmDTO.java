package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出院诊断-中医 DTO数据 
 * 
 */
public class DischargeDiagnosisTcmDTO extends BaseDTO {
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
	 * 出院中医诊断-主病名称
	 * @return String
	 */
	public String getHdsd00_12_028() {
		return ((String) getAttrVal("Hdsd00_12_028"));
	}
	/**
	 * 出院中医诊断-主病名称
	 * @param Hdsd00_12_028
	 */
	public void setHdsd00_12_028(String Hdsd00_12_028) {
		setAttrVal("Hdsd00_12_028", Hdsd00_12_028);
	}
	/**
	 * 出院中医诊断-主病编码
	 * @return String
	 */
	public String getHdsd00_12_027() {
		return ((String) getAttrVal("Hdsd00_12_027"));
	}
	/**
	 * 出院中医诊断-主病编码
	 * @param Hdsd00_12_027
	 */
	public void setHdsd00_12_027(String Hdsd00_12_027) {
		setAttrVal("Hdsd00_12_027", Hdsd00_12_027);
	}
	/**
	 * 出院中医诊断-主病-入院病情代码
	 * @return String
	 */
	public String getHdsd00_12_029() {
		return ((String) getAttrVal("Hdsd00_12_029"));
	}
	/**
	 * 出院中医诊断-主病-入院病情代码
	 * @param Hdsd00_12_029
	 */
	public void setHdsd00_12_029(String Hdsd00_12_029) {
		setAttrVal("Hdsd00_12_029", Hdsd00_12_029);
	}
	/**
	 * 出院诊断-主证名称
	 * @return String
	 */
	public String getHdsd00_12_030() {
		return ((String) getAttrVal("Hdsd00_12_030"));
	}
	/**
	 * 出院诊断-主证名称
	 * @param Hdsd00_12_030
	 */
	public void setHdsd00_12_030(String Hdsd00_12_030) {
		setAttrVal("Hdsd00_12_030", Hdsd00_12_030);
	}
	/**
	 * 出院中医诊断-主证编码
	 * @return String
	 */
	public String getHdsd00_12_032() {
		return ((String) getAttrVal("Hdsd00_12_032"));
	}
	/**
	 * 出院中医诊断-主证编码
	 * @param Hdsd00_12_032
	 */
	public void setHdsd00_12_032(String Hdsd00_12_032) {
		setAttrVal("Hdsd00_12_032", Hdsd00_12_032);
	}
	/**
	 * 出院中医诊断-主证-入院病情代码
	 * @return String
	 */
	public String getHdsd00_12_031() {
		return ((String) getAttrVal("Hdsd00_12_031"));
	}
	/**
	 * 出院中医诊断-主证-入院病情代码
	 * @param Hdsd00_12_031
	 */
	public void setHdsd00_12_031(String Hdsd00_12_031) {
		setAttrVal("Hdsd00_12_031", Hdsd00_12_031);
	}
	/**
	 * 出院诊断-主要诊断名称
	 * @return String
	 */
	public String getHdsd00_12_025() {
		return ((String) getAttrVal("Hdsd00_12_025"));
	}
	/**
	 * 出院诊断-主要诊断名称
	 * @param Hdsd00_12_025
	 */
	public void setHdsd00_12_025(String Hdsd00_12_025) {
		setAttrVal("Hdsd00_12_025", Hdsd00_12_025);
	}
	/**
	 * 出院诊断-主要诊断疾病代码
	 * @return String
	 */
	public String getHdsd00_12_024() {
		return ((String) getAttrVal("Hdsd00_12_024"));
	}
	/**
	 * 出院诊断-主要诊断疾病代码
	 * @param Hdsd00_12_024
	 */
	public void setHdsd00_12_024(String Hdsd00_12_024) {
		setAttrVal("Hdsd00_12_024", Hdsd00_12_024);
	}
	/**
	 * 出院诊断-主要诊断入院病情代码
	 * @return String
	 */
	public String getHdsd00_12_026() {
		return ((String) getAttrVal("Hdsd00_12_026"));
	}
	/**
	 * 出院诊断-主要诊断入院病情代码
	 * @param Hdsd00_12_026
	 */
	public void setHdsd00_12_026(String Hdsd00_12_026) {
		setAttrVal("Hdsd00_12_026", Hdsd00_12_026);
	}
	/**
	 * 出院诊断-其他诊断名称
	 * @return String
	 */
	public String getHdsd00_12_022() {
		return ((String) getAttrVal("Hdsd00_12_022"));
	}
	/**
	 * 出院诊断-其他诊断名称
	 * @param Hdsd00_12_022
	 */
	public void setHdsd00_12_022(String Hdsd00_12_022) {
		setAttrVal("Hdsd00_12_022", Hdsd00_12_022);
	}
	/**
	 * 出院诊断-其他诊断疾病编码
	 * @return String
	 */
	public String getHdsd00_12_021() {
		return ((String) getAttrVal("Hdsd00_12_021"));
	}
	/**
	 * 出院诊断-其他诊断疾病编码
	 * @param Hdsd00_12_021
	 */
	public void setHdsd00_12_021(String Hdsd00_12_021) {
		setAttrVal("Hdsd00_12_021", Hdsd00_12_021);
	}
	/**
	 * 出院诊断-其他诊断入院病情代码
	 * @return String
	 */
	public String getHdsd00_12_023() {
		return ((String) getAttrVal("Hdsd00_12_023"));
	}
	/**
	 * 出院诊断-其他诊断入院病情代码
	 * @param Hdsd00_12_023
	 */
	public void setHdsd00_12_023(String Hdsd00_12_023) {
		setAttrVal("Hdsd00_12_023", Hdsd00_12_023);
	}
}