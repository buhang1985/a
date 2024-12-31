package iih.mi.biz.dto.d;

import xap.mw.core.data.BaseDTO;

/**
 * 处方撤销入参DTO DTO数据 
 * 
 */
public class CancelInpRegisterParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	public static final String INPNO= "Inpno";
	public static final String AREACODE= "Areacode";
	public static final String BUSINESSNO= "Businessno";
	public static final String OPERATOR= "Operator";
	
	/**
	 * 参合地区编码
	 * @return String
	 */
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}
	/**
	 * 参合地区编码
	 * @param Areacode
	 */
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	/**
	 * 住院登记流水号
	 * @return String
	 */
	public String getInpno() {
		return ((String) getAttrVal("Inpno"));
	}
	/**
	 * 住院登记流水号
	 * @param Inpno
	 */
	public void setInpno(String Inpno) {
		setAttrVal("Inpno", Inpno);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getOperator() {
		return ((String) getAttrVal("Operator"));
	}
	/**
	 * 操作人
	 * @param Operator
	 */
	public void setOperator(String Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 发送方撤销交易流水号
	 * @return String
	 */
	public String getBusinessno() {
		return ((String) getAttrVal("Businessno"));
	}
	/**
	 * 发送方撤销交易流水号
	 * @param Businessno
	 */
	public void setBusinessno(String Businessno) {
		setAttrVal("Businessno", Businessno);
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
	/**
	 * 住院号(HIS)
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号(HIS)
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
}