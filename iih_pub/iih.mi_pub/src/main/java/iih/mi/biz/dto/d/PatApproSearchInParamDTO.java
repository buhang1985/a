package iih.mi.biz.dto.d;

import xap.mw.core.data.BaseDTO;

/**
 * 患者审批信息查询条件 DTO数据 
 * 
 */
public class PatApproSearchInParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 审批类别
	 * @return String
	 */
	public String getApprotype() {
		return ((String) getAttrVal("Approtype"));
	}
	/**
	 * 审批类别
	 * @param Approtype
	 */
	public void setApprotype(String Approtype) {
		setAttrVal("Approtype", Approtype);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}
	/**
	 * 个人编号
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
}