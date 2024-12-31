package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 调用参数 DTO数据 
 * 
 */
public class Exec4CmlInsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编号
	 * @return String
	 */
	public String getCodepat() {
		return ((String) getAttrVal("Codepat"));
	}
	/**
	 * 患者编号
	 * @param Codepat
	 */
	public void setCodepat(String Codepat) {
		setAttrVal("Codepat", Codepat);
	}
	/**
	 * 类型编码
	 * @return String
	 */
	public String getCodefirm() {
		return ((String) getAttrVal("Codefirm"));
	}
	/**
	 * 类型编码
	 * @param Codefirm
	 */
	public void setCodefirm(String Codefirm) {
		setAttrVal("Codefirm", Codefirm);
	}
	/**
	 * 发票号集合
	 * @return FArrayList
	 */
	public FArrayList getBillnos() {
		return ((FArrayList) getAttrVal("Billnos"));
	}
	/**
	 * 发票号集合
	 * @param Billnos
	 */
	public void setBillnos(FArrayList Billnos) {
		setAttrVal("Billnos", Billnos);
	}
}