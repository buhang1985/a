package iih.en.pv.custom.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 输出结果
 * 
 * @author liubin
 *
 * @param <T>
 */
public class EnResultOutParam<T> extends BaseDTO {
	
	private static final long serialVersionUID = 1L;

	public EnResultOutParam() {
		super();
		setFg_deal(FBoolean.FALSE);;
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
}
