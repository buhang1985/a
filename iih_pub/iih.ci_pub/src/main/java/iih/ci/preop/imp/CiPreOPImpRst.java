package iih.ci.preop.imp;

import com.sun.net.httpserver.Authenticator.Success;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 返回信息
 * @author mkp
 *
 */
public class CiPreOPImpRst extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CiPreOPImpRst() {
	    
	}
	
	public CiPreOPImpRst(String message, FBoolean success) {
		super();
		this.setMessage(message);
		this.setSuccess(success);
	}
	
	public FBoolean success() {
	    return getSuccess();
	}

	// 返回成功标志
	public FBoolean getSuccess() {
		return (FBoolean) getAttrVal("Success");
	}
	
	public void setSuccess(FBoolean success) {
	    setAttrVal("Success", success);
	}

	// 返回信息
	public String getMessage() {
	    return (String) getAttrVal("Message");
	}

	public void setMessage(String message) {
	    setAttrVal("Message", message);
	}

}
