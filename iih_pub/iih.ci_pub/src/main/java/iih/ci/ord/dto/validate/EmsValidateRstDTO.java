package iih.ci.ord.dto.validate;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 医疗单保存，校验结果DTO
 * @author zhangwq
 *
 */
public class EmsValidateRstDTO extends BaseDTO{
	/**
	 * 审核结果的错误信息,存放String类型
	 * @return FArrayList
	 */
	public FArrayList getErrorList() {
		return ((FArrayList) getAttrVal("ErrorList"));
	}
	/**
	 * 审核结果的错误信息,存放String类型
	 * @param ErrorList
	 */
	public void setErrorList(FArrayList ErrorList) {
		setAttrVal("ErrorList", ErrorList);
	}
	/**
	 * 审核结果的提示信息,存放String类型
	 * @return FArrayList
	 */
	public FArrayList getWarnList() {
		return ((FArrayList) getAttrVal("WarnList"));
	}
	/**
	 * 审核结果的提示信息,存放String类型
	 * @param WarnList
	 */
	public void setWarnList(FArrayList WarnList) {
		setAttrVal("WarnList", WarnList);
	}
}
