package iih.ci.ord.i.external.provide.meta.partner;

import xap.mw.core.data.BaseDTO;

/**
 * 团检支付方式更新DTO
 */
public class UpdatePayByGroupRstDTO extends BaseDTO {

	/**
	 * 操作结果
	 * @return
	 */
	public String getResultcode() {
		return ((String) getAttrVal("Resultcode"));
	}	
	public void setResultcode(String Resultcode) {
		setAttrVal("Resultcode", Resultcode);
	}
	/**
	 * 提示信息
	 * @return
	 */
	public String getResultmsg() {
		return ((String) getAttrVal("Resultmsg"));
	}	
	public void setResultmsg(String Resultmsg) {
		setAttrVal("Resultmsg", Resultmsg);
	}
}
