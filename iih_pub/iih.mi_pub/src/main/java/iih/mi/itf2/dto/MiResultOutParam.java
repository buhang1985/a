package iih.mi.itf2.dto;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
 * 医保平台返回值
 * @author ly
 *
 */
public class MiResultOutParam<T> extends BaseDTO {

	private static final long serialVersionUID = 1L;

	public MiResultOutParam(){
		super();
		setFg_deal(FBoolean.TRUE);
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
	
	/**
	 * 医保是否成功
	 * 
	 * @param fg_HisSuccess
	 */
	public void setFg_HpSuccess(FBoolean Fg_HpSuccess) {
		setAttrVal("Fg_HpSuccess", Fg_HpSuccess);
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
	 * 返回业务数据
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getData() {
		return (T) getAttrVal("Data");
	}

	/**
	 * 返回业务数据
	 * 
	 * @param data
	 */
	public void setData(T data) {
		setAttrVal("Data", data);
	}
	
	/**
	 * 包装数据
	 * @return
	 */
	public FArrayList getWrapData(){
		return (FArrayList) getAttrVal("WrapData");
	}
	
	/**
	 * 包装数据
	 * @param data
	 */
	public void setWrapData(FArrayList data){
		setAttrVal("WrapData", data);
	}
	
	/**
	 * 数据包装
	 */
	@SuppressWarnings("unchecked")
	public void wrap(){
		if(this.getData() != null){
			FArrayList list = new FArrayList();
			list.add(this.getData());
			this.setWrapData(list);
		}
	}
}
