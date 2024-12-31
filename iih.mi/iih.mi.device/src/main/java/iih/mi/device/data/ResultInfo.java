package iih.mi.device.data;

import iih.valueobject.country.ruralcooperinsure.dto.d.CommonMsgHeaderDTO;

public class ResultInfo<T> {
	/**
	 * 是否成功
	 */
	protected boolean isSuccess;
	/**
	 * 结果编码
	 */
	protected String resultCode;
	/**
	 * 异常信息
	 */
	protected String errorMsg;
	/**
	 * 业务周期号
	 */
	protected String bizCycleCode;
	/**
	 * 中心交易流水号
	 */
	protected String centerTradeNo;
	/**
	 * his交易流水号
	 */
	protected String hisTradeNo;
	/**
	 * 业务编号
	 */
	protected String businessCode;
	/**
	 * 医保交易传入的数据串
	 */
	protected String strInputParam;
	/**
	 * 医保交易传出的数据串
	 */
	protected String strOutputParam;
	/**
	 * 医保交易传入的数据
	 */
	protected Object objectInputParam;
	/**
	 * 医保交易传出的数据
	 */
	protected Object objectOutputParam;
	/**
	 * 消息头
	 */
	protected CommonMsgHeaderDTO msgHeaderDto;
	/**
	 * 数据
	 */
	protected T data;

	/**
	 * 是否成功
	 * 
	 * @return the isSuccess
	 */
	public boolean getIsSuccess() {
		return isSuccess;
	}

	/**
	 * 是否成功
	 * 
	 * @param isSuccess
	 *            the isSuccess to set
	 */
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * 结果编码
	 * 
	 * @return
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * 结果编码
	 * 
	 * @param resultCode
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * 异常信息
	 * 
	 * @return
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * 异常信息
	 * 
	 * @return
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * 业务周期号
	 * 
	 * @return
	 */
	public String getBizCycleCode() {
		return bizCycleCode;
	}

	/**
	 * 业务周期号
	 * 
	 * @param bizCycleCode
	 */
	public void setBizCycleCode(String bizCycleCode) {
		this.bizCycleCode = bizCycleCode;
	}

	/**
	 * 中心交易流水号
	 * 
	 * @return
	 */
	public String getCenterTradeNo() {
		return centerTradeNo;
	}

	/**
	 * 中心交易流水号
	 * 
	 * @param centerTradeNo
	 */
	public void setCenterTradeNo(String centerTradeNo) {
		this.centerTradeNo = centerTradeNo;
	}

	/**
	 * his交易流水号
	 * 
	 * @return
	 */
	public String getHisTradeNo() {
		return hisTradeNo;
	}

	/**
	 * his交易流水号
	 * 
	 * @param hisTradeNo
	 */
	public void setHisTradeNo(String hisTradeNo) {
		this.hisTradeNo = hisTradeNo;
	}

	/**
	 * 业务编号
	 * 
	 * @return
	 */
	public String getBusinessCode() {
		return businessCode;
	}

	/**
	 * 业务编号
	 * 
	 * @param businessCode
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	/**
	 * 医保交易传入的数据串
	 * 
	 * @return
	 */
	public String getStrInputParam() {
		return strInputParam;
	}

	/**
	 * 医保交易传入的数据串
	 * 
	 * @param strInputParam
	 */
	public void setStrInputParam(String strInputParam) {
		this.strInputParam = strInputParam;
	}

	/**
	 * 医保交易传出的数据串
	 * 
	 * @return
	 */
	public String getStrOutputParam() {
		return strOutputParam;
	}

	/**
	 * 医保交易传出的数据串
	 * 
	 * @param strOutputParam
	 */
	public void setStrOutputParam(String strOutputParam) {
		this.strOutputParam = strOutputParam;
	}

	/**
	 * 医保交易传入的数据
	 * 
	 * @return
	 */
	public Object getObjectInputParam() {
		return objectInputParam;
	}

	/**
	 * 医保交易传入的数据
	 * 
	 * @param objectInputParam
	 */
	public void setObjectInputParam(Object objectInputParam) {
		this.objectInputParam = objectInputParam;
	}

	/**
	 * 医保交易传出的数据
	 * 
	 * @return
	 */
	public Object getObjectOutputParam() {
		return objectOutputParam;
	}

	/**
	 * 医保交易传出的数据
	 * 
	 * @param objectOutputParam
	 */
	public void setObjectOutputParam(Object objectOutputParam) {
		this.objectOutputParam = objectOutputParam;
	}

	/**
	 * 消息头
	 * 
	 * @return
	 */
	public CommonMsgHeaderDTO getMsgHeaderDto() {
		return msgHeaderDto;
	}

	/**
	 * 消息头
	 * 
	 * @param msgHeaderDto
	 */
	public void setMsgHeaderDto(CommonMsgHeaderDTO msgHeaderDto) {
		this.msgHeaderDto = msgHeaderDto;
	}

	/**
	 * 数据
	 * 
	 * @return
	 */
	public T getData() {
		return data;
	}

	/**
	 * 数据
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
}
