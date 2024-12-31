package iih.bl.cg.dto.cglogic.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 记账错误信息dto DTO数据 
 * 
 */
public class BlCgErrorDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 错误信息
	 * @return String
	 */
	public String getError_msg() {
		return ((String) getAttrVal("Error_msg"));
	}
	/**
	 * 错误信息
	 * @param Error_msg
	 */
	public void setError_msg(String Error_msg) {
		setAttrVal("Error_msg", Error_msg);
	}
	/**
	 * 错误堆栈
	 * @return String
	 */
	public String getExcptionstack() {
		return ((String) getAttrVal("Excptionstack"));
	}
	/**
	 * 错误堆栈
	 * @param Excptionstack
	 */
	public void setExcptionstack(String Excptionstack) {
		setAttrVal("Excptionstack", Excptionstack);
	}
}