package iih.mi.itf.bizgrpitf.param.transferitf;

import iih.mi.biz.dto.d.ParamAttributeDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

public class ResultOutParamTransferDTO<T> extends BaseDTO {

	private static final long serialVersionUID = 393427981361338321L;

	public ResultOutParamTransferDTO() {
		super();
		setFg_deal(FBoolean.TRUE);
		setFg_HisSuccess(FBoolean.TRUE);
		setFg_HpSuccess(FBoolean.TRUE);
	}

	/**
	 * 是否进行处理
	 * 
	 * @return
	 */
	public FBoolean getFg_deal() {
		return (FBoolean) getAttrVal("Fg_deal");
	}

	/**
	 * 是否进行处理
	 * 
	 * @param fg_deal
	 */
	public void setFg_deal(FBoolean fg_deal) {
		setAttrVal("Fg_deal", fg_deal);
	}

	/***
	 * IIH是否成功
	 * 
	 * @return
	 */
	public FBoolean getFg_HisSuccess() {
		return (FBoolean) getAttrVal("Fg_HisSuccess");
	}

	/**
	 * IIH是否成功
	 * 
	 * @param fg_HisSuccess
	 */
	public void setFg_HisSuccess(FBoolean fg_HisSuccess) {
		setAttrVal("Fg_HisSuccess", fg_HisSuccess);
	}

	/**
	 * 医保是否成功
	 * 
	 * @return
	 */
	public FBoolean getFg_HpSuccess() {
		return (FBoolean) getAttrVal("Fg_HpSuccess");
	}

	/**
	 * 医保是否成功
	 * 
	 * @param fg_HpSuccess
	 */
	public void setFg_HpSuccess(FBoolean fg_HpSuccess) {
		setAttrVal("Fg_HpSuccess", fg_HpSuccess);
	}

	/**
	 * 中心交易流水号
	 * 
	 * @return
	 */
	public String getCenterTradeNo() {
		return (String) getAttrVal("CenterTradeNo");
	}

	/**
	 * 中心交易流水号
	 * 
	 * @param centerTradeNo
	 */
	public void setCenterTradeNo(String centerTradeNo) {
		setAttrVal("CenterTradeNo", centerTradeNo);
	}

	/**
	 * 异常信息
	 * 
	 * @return
	 */
	public String getErrorMsg() {
		return (String) getAttrVal("ErrorMsg");
	}

	/**
	 * 异常信息
	 * 
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		setAttrVal("ErrorMsg", errorMsg);
	}

	/**
	 * 返回值参数描述类
	 * 
	 * @return
	 */
	public ParamAttributeDTO getOutParamAttributes() {
		return (ParamAttributeDTO) getAttrVal("ParamAttributeDTO");
	}

	/**
	 * 返回值参数描述类
	 * 
	 * @param paramAttributeDTO
	 */
	public void setOutParamAttributes(ParamAttributeDTO paramAttributeDTO) {
		setAttrVal("ParamAttributeDTO", paramAttributeDTO);
	}

	/**
	 * 返回业务数据
	 * 
	 * @return
	 */
	public FArrayList getData() {
		return (FArrayList) getAttrVal("Data");
	}

	/**
	 * 返回业务数据
	 * 
	 * @param data
	 */
	public void setData(FArrayList data) {
		setAttrVal("Data", data);
	}
}
