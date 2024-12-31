package iih.ci.ord.i.error;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;

/**
 * 断点描述
 * @author wangqingzhu
 *
 */
public class StackPointDTO extends BaseXapJsonSerialization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱关键字
	 * @return
	 */
	public String getOrderKey() {
		return ((String) getAttrVal("OrderKey"));
	}
	/**
	 * 医嘱关键字
	 * @param OrderKey
	 */
	public void setOrderKey(String OrderKey) {
		setAttrVal("OrderKey", OrderKey);
	}

	/**
	 * 栈点
	 * @return
	 */
	public String getStackPoint() {
		return ((String) getAttrVal("StackPoint"));
	}
	/**
	 * 栈点
	 * @param StackPoint
	 */
	public void setStackPoint(String StackPoint) {
		setAttrVal("StackPoint", StackPoint);
	}
	
	/**
	 * 堆栈密钥
	 * @return
	 */
	public String getStackKey() {
		return ((String) getAttrVal("StackKey"));
	}
	/**
	 * 堆栈密钥
	 * @param StackKey
	 */
	public void setStackKey(String StackKey) {
		setAttrVal("StackKey", StackKey);
	}
	
	/**
	 * 堆栈值 - 可空
	 * @return
	 */
	public FArrayList getStackValue() {
		return ((FArrayList) getAttrVal("StackValue"));
	}
	/**
	 * 堆栈值 - 可空
	 * @param StackValue
	 */
	public void setStackValue(FArrayList StackValue) {
		setAttrVal("StackValue", StackValue);
	}
	
	/**
	 * UI回写后台 - 可空
	 * @return
	 */
	public FMap2 getParameter() {
		return ((FMap2) getAttrVal("Parameter"));
	}
	
	/**
	 * UI回写后台 - 可空
	 * @param Parameter
	 */
	public void setParameter(FMap2 Parameter) {
		setAttrVal("Parameter", Parameter);
	}
	
	/**
	 * 回调方法
	 * @return
	 */
	public String getCallback() {
		return ((String) getAttrVal("Callback"));
	}
	/**
	 * 回调方法
	 * @param Callback
	 */
	public void setCallback(String Callback) {
		setAttrVal("Callback", Callback);
	}
}
