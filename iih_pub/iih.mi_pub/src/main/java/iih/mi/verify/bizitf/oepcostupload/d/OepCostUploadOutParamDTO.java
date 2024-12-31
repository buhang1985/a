package iih.mi.verify.bizitf.oepcostupload.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收退费上传出参 DTO数据 
 * 
 */
public class OepCostUploadOutParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 状态
	 * @return Integer
	 */
	public Integer getState() {
		return ((Integer) getAttrVal("State"));
	}
	/**
	 * 状态
	 * @param State
	 */
	public void setState(Integer State) {
		setAttrVal("State", State);
	}
	/**
	 * 提示信息
	 * @return String
	 */
	public String getMessage() {
		return ((String) getAttrVal("Message"));
	}
	/**
	 * 提示信息
	 * @param Message
	 */
	public void setMessage(String Message) {
		setAttrVal("Message", Message);
	}
}