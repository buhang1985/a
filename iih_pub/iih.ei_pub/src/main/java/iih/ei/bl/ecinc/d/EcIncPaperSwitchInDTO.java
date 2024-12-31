package iih.ei.bl.ecinc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 换开纸质票据入参 DTO数据 
 * 
 */
public class EcIncPaperSwitchInDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 票据id
	 * @return String
	 */
	public String getId_inc() {
		return ((String) getAttrVal("Id_inc"));
	}
	/**
	 * 票据id
	 * @param Id_inc
	 */
	public void setId_inc(String Id_inc) {
		setAttrVal("Id_inc", Id_inc);
	}
	/**
	 * 票据类型
	 * @return String
	 */
	public String getInctype() {
		return ((String) getAttrVal("Inctype"));
	}
	/**
	 * 票据类型
	 * @param Inctype
	 */
	public void setInctype(String Inctype) {
		setAttrVal("Inctype", Inctype);
	}
	/**
	 * 电子票据代码
	 * @return String
	 */
	public String getEcinc_code() {
		return ((String) getAttrVal("Ecinc_code"));
	}
	/**
	 * 电子票据代码
	 * @param Ecinc_code
	 */
	public void setEcinc_code(String Ecinc_code) {
		setAttrVal("Ecinc_code", Ecinc_code);
	}
	/**
	 * 电子票据号
	 * @return String
	 */
	public String getEcincno() {
		return ((String) getAttrVal("Ecincno"));
	}
	/**
	 * 电子票据号
	 * @param Ecincno
	 */
	public void setEcincno(String Ecincno) {
		setAttrVal("Ecincno", Ecincno);
	}
	/**
	 * 纸质票据代码
	 * @return String
	 */
	public String getPinc_code() {
		return ((String) getAttrVal("Pinc_code"));
	}
	/**
	 * 纸质票据代码
	 * @param Pinc_code
	 */
	public void setPinc_code(String Pinc_code) {
		setAttrVal("Pinc_code", Pinc_code);
	}
	/**
	 * 纸质票据号
	 * @return String
	 */
	public String getPincno() {
		return ((String) getAttrVal("Pincno"));
	}
	/**
	 * 纸质票据号
	 * @param Pincno
	 */
	public void setPincno(String Pincno) {
		setAttrVal("Pincno", Pincno);
	}
}