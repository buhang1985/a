package iih.bl.inc.dto.eincoutresultdto.d;

import java.io.Serializable;

/**
 * 电子票据开具接口出参
 * 
 * @author shaokx 2019.12.14
 *
 */
public class BlEIncOutResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String result;//返回编码
	private BlEIncOutMessageResult message;//返回信息
	
	private String errorMsg;//错误信息
	private String inputStr;//入参
	private String outputStr;//出参
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public BlEIncOutMessageResult getMessage() {
		return message;
	}
	public void setMessage(BlEIncOutMessageResult message) {
		this.message = message;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getInputStr() {
		return inputStr;
	}
	public void setInputStr(String inputStr) {
		this.inputStr = inputStr;
	}
	public String getOutputStr() {
		return outputStr;
	}
	public void setOutputStr(String outputStr) {
		this.outputStr = outputStr;
	}
	
}
