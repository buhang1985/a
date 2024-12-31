package iih.ci.ord.dto.confirm;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
/**
 * 医嘱确认校验返回对象
 * @author zhangwq
 *
 */
public class OrConfirmRstDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 错误信息
	 * @return String
	 */
	public String getError_message() {
		return ((String) getAttrVal("Error_message"));
	}
	/**
	 * 错误信息
	 * @param Error_message
	 */
	public void setError_message(String Error_message) {
		setAttrVal("Error_message", Error_message);
	}
	/**
	 * 不允许确认的医嘱id_or集合
	 * @return FArrayList
	 */
	public FArrayList getId_ors_error() {
		return ((FArrayList) getAttrVal("Id_ors_error"));
	}
	/**
	 * 不允许确认的医嘱id_or集合
	 * @param Id_ors_error
	 */
	public void setId_ors_error(FArrayList Id_ors_error) {
		setAttrVal("Id_ors_error", Id_ors_error);
	}
}
