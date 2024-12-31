package iih.ei.std.exception;

import org.apache.commons.lang.exception.ExceptionUtils;

import iih.ei.std.d.IIHWsResultCodeConst;
import xap.mw.core.data.BizException;

/**
 * IIHWebService异常
 * 
 * @author hao_wu 2019-9-3
 *
 */
public class IIHWsException extends BizException {

	private static final long serialVersionUID = 1L;

	public IIHWsException(String errorCode, String msg) {
		super(msg);
		this.setErrorCode(errorCode);
	}

	public IIHWsException(String errorCode) {
		this.setErrorCode(errorCode);
	}

	public IIHWsException(String errorCode, Throwable throwable) {
		super(ExceptionUtils.getStackTrace(throwable));
		this.setErrorCode(errorCode);
	}

	/**
	 * 根据编码获取异常对象
	 * 
	 * @param errorCode
	 * @return
	 */
	public static IIHWsException createExByCode(String errorCode) {
		String result = IIHWsResultCodeConst.getResultMsg(errorCode);
		return new IIHWsException(errorCode, result);
	}

	/**
	 * 错误编码
	 */
	private String errorCode;

	/**
	 * 获取错误编码
	 * 
	 * @return
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * 设置错误编码
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
