package iih.ci.ord.i.external.provide.meta.partner;

import xap.mw.core.data.BaseDTO;

/**
 * 医嘱是否已作废确认入参DTO
 * @author Young
 *
 */
public class IpOrderCancelStateParamDTO extends BaseDTO {
	/**
	 * 医嘱号
	 * @return
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
}
