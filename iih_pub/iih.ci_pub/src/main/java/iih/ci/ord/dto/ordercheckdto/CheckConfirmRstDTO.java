package iih.ci.ord.dto.ordercheckdto;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

public class CheckConfirmRstDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 判断处理结果标志
	 * @return Boolean
	 */
	public Boolean isSuccessful() {
		return ((Boolean) getAttrVal("isSuccessful"));
	}
	/**
	 * 设置处理结果标志
	 * @param isSuccessful
	 */
	public void setSuccessful(Boolean isSuccessful) {
		setAttrVal("isSuccessful", isSuccessful);
	}
	
	/**
	 * 错误信息
	 * @return String
	 */
	public String getErrorMessage() {
		return ((String) getAttrVal("ErrorMessage"));
	}
	/**
	 * 错误信息
	 * @param ErrorMessage
	 */
	public void setErrorMessage(String emsDocument) {
		setAttrVal("ErrorMessage", emsDocument);
	}
	
}
