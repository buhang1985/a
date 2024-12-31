package iih.sc.apt.out.ci.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方预约返回结果 DTO数据 
 * 
 */
public class MtAptResDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约是否成功
	 * @return FBoolean
	 */
	public FBoolean getSuccess() {
		return ((FBoolean) getAttrVal("Success"));
	}
	/**
	 * 预约是否成功
	 * @param Success
	 */
	public void setSuccess(FBoolean Success) {
		setAttrVal("Success", Success);
	}
	/**
	 * 失败信息
	 * @return String
	 */
	public String getError_msg() {
		return ((String) getAttrVal("Error_msg"));
	}
	/**
	 * 失败信息
	 * @param Error_msg
	 */
	public void setError_msg(String Error_msg) {
		setAttrVal("Error_msg", Error_msg);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getApt_time() {
		return ((FDateTime) getAttrVal("Apt_time"));
	}
	/**
	 * 预约时间
	 * @param Apt_time
	 */
	public void setApt_time(FDateTime Apt_time) {
		setAttrVal("Apt_time", Apt_time);
	}
	/**
	 * 功能节点编码
	 * @return String
	 */
	public String getFunc_code() {
		return ((String) getAttrVal("Func_code"));
	}
	/**
	 * 功能节点编码
	 * @param Func_code
	 */
	public void setFunc_code(String Func_code) {
		setAttrVal("Func_code", Func_code);
	}
}