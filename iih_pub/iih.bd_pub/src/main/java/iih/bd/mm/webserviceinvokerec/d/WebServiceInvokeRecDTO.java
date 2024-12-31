package iih.bd.mm.webserviceinvokerec.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方接口调用记录 DTO数据 
 * 
 */
public class WebServiceInvokeRecDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日志主键
	 * @return String
	 */
	public String getWebserviceid() {
		return ((String) getAttrVal("Webserviceid"));
	}
	/**
	 * 日志主键
	 * @param Webserviceid
	 */
	public void setWebserviceid(String Webserviceid) {
		setAttrVal("Webserviceid", Webserviceid);
	}
	/**
	 * webservice接口
	 * @return String
	 */
	public String getSer_interface() {
		return ((String) getAttrVal("Ser_interface"));
	}
	/**
	 * webservice接口
	 * @param Ser_interface
	 */
	public void setSer_interface(String Ser_interface) {
		setAttrVal("Ser_interface", Ser_interface);
	}
	/**
	 * 调用时间
	 * @return FDateTime
	 */
	public FDateTime getCall_time() {
		return ((FDateTime) getAttrVal("Call_time"));
	}
	/**
	 * 调用时间
	 * @param Call_time
	 */
	public void setCall_time(FDateTime Call_time) {
		setAttrVal("Call_time", Call_time);
	}
	/**
	 * 返回时间
	 * @return FDateTime
	 */
	public FDateTime getReturn_time() {
		return ((FDateTime) getAttrVal("Return_time"));
	}
	/**
	 * 返回时间
	 * @param Return_time
	 */
	public void setReturn_time(FDateTime Return_time) {
		setAttrVal("Return_time", Return_time);
	}
	/**
	 * 调用内容
	 * @return String
	 */
	public String getCall_content() {
		return ((String) getAttrVal("Call_content"));
	}
	/**
	 * 调用内容
	 * @param Call_content
	 */
	public void setCall_content(String Call_content) {
		setAttrVal("Call_content", Call_content);
	}
	/**
	 * 返回内容
	 * @return String
	 */
	public String getReturn_content() {
		return ((String) getAttrVal("Return_content"));
	}
	/**
	 * 返回内容
	 * @param Return_content
	 */
	public void setReturn_content(String Return_content) {
		setAttrVal("Return_content", Return_content);
	}
}