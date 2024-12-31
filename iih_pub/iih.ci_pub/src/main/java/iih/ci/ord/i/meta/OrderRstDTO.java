package iih.ci.ord.i.meta;

import java.util.Collection;

import iih.ci.ord.i.common.b.BaseCiDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

public class OrderRstDTO extends BaseCiDTO {
	/**
	 * 医嘱查询返回结果
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderRstDTO() {}
	
	public OrderRstDTO(FBoolean isOk) {
		this.setIsSuccess(isOk);
		
	}
	
	public OrderRstDTO(FBoolean isOk, String errorMsg) {
		this.setIsSuccess(isOk);
		this.setMessageInfo(errorMsg);
	}
	
	public OrderRstDTO(FBoolean isOk, Collection<?> dataCollection) {
		this.setIsSuccess(isOk);
		this.setDocument(new FArrayList());
		this.getDocument().addAll(dataCollection);
		
	}
	
	public OrderRstDTO(FBoolean isOk, String extKey, Object extValue) {
		this.setIsSuccess(isOk);
		this.setExtension(new FMap2());
		this.getExtension().put(extKey, extValue);
	}
	
	public OrderRstDTO(FBoolean isOk, String extKey, Collection<?> c) {
		this.setIsSuccess(isOk);
		this.setExtension(new FMap2());
		
		FArrayList dataList = new FArrayList();
		dataList.addAll(c);
		this.getExtension().put(extKey, dataList);
	}
	

	
	/**
	 * 成功标志
	 * @return
	 */
	public FBoolean getIsSuccess() {
		return ((FBoolean) getAttrVal("IsSuccess"));
	}
	/**
	 * 成功标志
	 * @param 真假值
	 */
	public void setIsSuccess(FBoolean IsSuccess) {
		setAttrVal("IsSuccess", IsSuccess);
	}
	/**
	 * 信息
	 * @return
	 */
	public String getMessageInfo() {
		return ((String) getAttrVal("MessageInfo"));
	}
	/**
	 * 信息
	 * @param 信息
	 */
	public void setMessageInfo(String MessageInfo) {
		setAttrVal("MessageInfo", MessageInfo);
	}
	
	
}
