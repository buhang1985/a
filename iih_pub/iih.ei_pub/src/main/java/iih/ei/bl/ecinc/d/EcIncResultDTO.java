package iih.ei.bl.ecinc.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 电子发票接口返回结果 DTO数据 
 * 
 */
public class EcIncResultDTO<T> extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 成功标志
	 * @return FBoolean
	 */
	public FBoolean getFg_success() {
		return ((FBoolean) getAttrVal("Fg_success"));
	}
	/**
	 * 成功标志
	 * @param Fg_success
	 */
	public void setFg_success(FBoolean Fg_success) {
		setAttrVal("Fg_success", Fg_success);
	}
	/**
	 * 错误信息
	 * @return String
	 */
	public String getErrormsg() {
		return ((String) getAttrVal("Errormsg"));
	}
	/**
	 * 错误信息
	 * @param Errormsg
	 */
	public void setErrormsg(String Errormsg) {
		setAttrVal("Errormsg", Errormsg);
	}
	/**
	 * 入参
	 * @return String
	 */
	public String getInparam() {
		return ((String) getAttrVal("Inparam"));
	}
	/**
	 * 入参
	 * @param Inparam
	 */
	public void setInparam(String Inparam) {
		setAttrVal("Inparam", Inparam);
	}
	/**
	 * 出参
	 * @return String
	 */
	public String getOutparam() {
		return ((String) getAttrVal("Outparam"));
	}
	/**
	 * 出参
	 * @param Outparam
	 */
	public void setOutparam(String Outparam) {
		setAttrVal("Outparam", Outparam);
	}
	/**
	 * 返回业务数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getData() {
		return (T) getAttrVal("Data");
	}
	/**
	 * 返回业务数据
	 * @param data
	 */
	public void setData(T data) {
		setAttrVal("Data", data);
	}
}