package iih.ei.std.d.v1.ci.ris.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方检查打印入参 DTO数据 
 * 
 */
public class EmsRisPrintDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单打印号
	 * @return String
	 */
	public String getCode_app() {
		return ((String) getAttrVal("Code_app"));
	}	
	/**
	 * 申请单打印号
	 * @param Code_app
	 */
	public void setCode_app(String Code_app) {
		setAttrVal("Code_app", Code_app);
	}
	/**
	 * 申请金额
	 * @return String
	 */
	public String getAmt_app() {
		return ((String) getAttrVal("Amt_app"));
	}	
	/**
	 * 申请金额
	 * @param Amt_app
	 */
	public void setAmt_app(String Amt_app) {
		setAttrVal("Amt_app", Amt_app);
	}
	/**
	 * 检查医嘱信息
	 * @return String
	 */
	public FArrayList getEmsrisorddto() {
		return ((FArrayList) getAttrVal("Emsrisorddto"));
	}	
	/**
	 * 检查医嘱信息
	 * @param Emsrisorddto
	 */
	public void setEmsrisorddto(FArrayList Emsrisorddto) {
		setAttrVal("Emsrisorddto", Emsrisorddto);
	}
}